package com.weissbrewing.cicerone.das;

import com.weissbrewing.cicerone.domain.Beer;
import com.weissbrewing.cicerone.domain.Brewery;
import com.weissbrewing.cicerone.util.HttpUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.print.URIException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by kevinweiss on 1/12/17.
 */
public class UntappdDASTest
{

    private HttpUtil mockHttpUtil = Mockito.mock(HttpUtil.class);

    private static final String breweryName = "Dogfish Head";
    private static final int breweryId = 459;

    private static final String SEARCH_BREWERY_RESPONSE = "searchBreweryResponse.json";
    private static final String BREWERY_INFO_RESPONSE = "breweryInfoResponse.json";

    @Test
    public void testSearchBrewery()
    {
        UntappdDAS untappdDAS = new UntappdDAS(mockHttpUtil);

        try
        {
            String response = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(SEARCH_BREWERY_RESPONSE).toURI())));
            Mockito.when(mockHttpUtil.get("search/brewery", "q=" + breweryName)).thenReturn(response);

            Brewery brewery = new Brewery();
            brewery.setName(breweryName);

            Brewery retrieved = untappdDAS.searchBrewery(brewery);

            Assert.assertEquals("UntappdDAS did not set the correct Brewery API ID", new Integer(breweryId), retrieved.getApiId());
        }
        catch (IOException|URISyntaxException e)
        {
            Assert.fail("Caught IOException attempting to load json from file");
        }
    }

    @Test
    public void testBreweryInfo()
    {
        UntappdDAS untappdDAS = new UntappdDAS(mockHttpUtil);

        try
        {
            String response = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(BREWERY_INFO_RESPONSE).toURI())));
            Mockito.when(mockHttpUtil.get("brewery/info/" + breweryId, null)).thenReturn(response);

            Brewery brewery = new Brewery();
            brewery.setName(breweryName);
            brewery.setApiId(breweryId);

            Brewery retrieved = untappdDAS.getBreweryInfo(brewery);

            Assert.assertNotNull("UntappdDAS returned null brewery object from getBreweryInfo", retrieved);
            Assert.assertEquals("Brewery does not contain the correct number of beers", 25, retrieved.getBeerList().size());

            for (Beer beer : brewery.getBeerList())
            {
                Assert.assertNotNull("Beer name is null", beer.getName());
                Assert.assertNotNull("Beer ABV is null", beer.getAbv());
                Assert.assertNotNull("Beer Overall Score is null", beer.getOverall_score());
            }
        }
        catch (IOException|URISyntaxException e)
        {
            Assert.fail("Caught IOException attempting to load json from file");
        }
    }
}
