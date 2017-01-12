package com.weissbrewing.cicerone.das;

import com.weissbrewing.cicerone.domain.Beer;
import com.weissbrewing.cicerone.domain.Brewery;
import com.weissbrewing.cicerone.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by kevinweiss on 1/12/17.
 */
public class UntappdDAS
{
    private static final Logger LOG = LoggerFactory.getLogger(DistributionDAS.class.getName());

    /**
     * Retrieve a list of beers by brewery
     * @param brewery The brewery to query
     * @return A list of Beers
     */
    public Brewery searchBrewery(final Brewery brewery)
    {
        String response = HttpUtil.get("search/brewery", "q=" + brewery.getName());

        LOG.info("Received response: " + response);

        // Parse JSON response and extract Brewery_ID

        // Set Brewery_ID on brewery object and return.

        return brewery;
    }

    public List<Beer> getBeersByBrewery(final Brewery brewery)
    {
        String response = HttpUtil.get("brewery/info/" + brewery.getId(), "q=" + brewery.getName());

        // Parse JSON and extract list of beers

        return null;
    }
}
