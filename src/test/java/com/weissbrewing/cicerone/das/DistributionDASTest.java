package com.weissbrewing.cicerone.das;

import com.weissbrewing.cicerone.domain.Brewery;
import com.weissbrewing.cicerone.domain.Location;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by kevinweiss on 1/11/17.
 */
public class DistributionDASTest
{
    private static final Logger LOG = LoggerFactory.getLogger(DistributionDAS.class.getName());
    @Test
    public void testGetUniqueBreweries()
    {
        Location home = Location.NE;
        Location current = Location.WI;
        DistributionDAS distributionDAS = new DistributionDAS();
        List<Brewery> breweryList = distributionDAS.getUniqueBreweries(home, current);

        Assert.assertNotNull("List of breweries was null", breweryList);
        Assert.assertTrue("List of breweries was empty", breweryList.size() > 0);

        assertBrewery(breweryList);
    }

    /**
     * Perform verification on brewery lists
     * @param breweryList The list to perform verification upon breweries
     */
    private void assertBrewery(List<Brewery> breweryList)
    {
        for (Brewery brewery : breweryList)
        {
            Assert.assertNotNull("Brewery was null", brewery);
            Assert.assertNotNull("Brewery locations list was null", brewery.getLocations());
            Assert.assertTrue("Brewery has no distribution", brewery.getLocations().size() > 0);

            if (LOG.isTraceEnabled())
            {
                LOG.trace("Brewery [" + brewery.getName() + "] verified with distribution to [" + brewery.getAvailability() + "] locations.");
            }
        }
    }

    @Test
    public void testGetUniqueBreweriesEmpty()
    {
        Location home = Location.NE;
        Location current = Location.NE;
        DistributionDAS distributionDAS = new DistributionDAS();
        List<Brewery> breweryList = distributionDAS.getUniqueBreweries(home, current);

        Assert.assertNotNull("List of breweries was null", breweryList);
        Assert.assertEquals("List of breweries was not empty", breweryList.size(),  0);
    }

    @Test
    public void getBreweriesByLocationTest()
    {
        Location home = Location.NE;
        DistributionDAS distributionDAS = new DistributionDAS();
        List<Brewery> breweryList = distributionDAS.getBreweriesByLocation(home);

        Assert.assertNotNull("List of breweries was null", breweryList);
        Assert.assertTrue("List of breweries was empty", breweryList.size() > 0);
    }
}
