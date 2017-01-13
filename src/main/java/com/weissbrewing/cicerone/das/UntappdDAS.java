package com.weissbrewing.cicerone.das;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.weissbrewing.cicerone.domain.Beer;
import com.weissbrewing.cicerone.domain.Brewery;
import com.weissbrewing.cicerone.domain.untappdAPI.BreweryContainer;
import com.weissbrewing.cicerone.domain.untappdAPI.BreweryList;
import com.weissbrewing.cicerone.domain.untappdAPI.Response;
import com.weissbrewing.cicerone.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringReader;
import java.util.List;

/**
 * Created by kevinweiss on 1/12/17.
 */
public class UntappdDAS
{
    private static final Logger LOG = LoggerFactory.getLogger(DistributionDAS.class.getName());

    private HttpUtil httpUtil;

    /**
     * Default Constructor
     */
    public UntappdDAS()
    {
        this(new HttpUtil());
    }

    /**
     * Constructor with specified HttpUtil (for unit testing)
     * @param httpUtil The HttpUtil to use
     */
    protected UntappdDAS(HttpUtil httpUtil)
    {
        this.httpUtil = httpUtil;
    }

    /**
     * Retrieve a list of beers by brewery
     * @param brewery The brewery to query
     * @return A list of Beers
     */
    public Brewery searchBrewery(final Brewery brewery)
    {
        String responseStr = httpUtil.get("search/brewery", "q=" + brewery.getName());

        LOG.info("Received response: " + responseStr);



        // Parse JSON response and extract Brewery_ID
        StringReader stringReader = new StringReader(responseStr);
        Gson gson = new GsonBuilder().create();
        Response response = gson.fromJson(stringReader, Response.class);

        LOG.info("Received response: " + response.toString());

        // Set Brewery_ID on brewery object and return.
        if (response != null)
        {
            BreweryList breweryList = response.getResponse().getBrewery();
            if (breweryList.getCount() != 0)
            {
                for (BreweryContainer breweryContainer : breweryList.getItems())
                {
                    brewery.setApiId(breweryContainer.getBrewery().getBrewery_id());
                }
            }
            else
            {
                LOG.error("Untappd API did not find any breweries matching the name: [" + brewery.getName() + "]");
            }
        }
        else
        {
            LOG.error("Untappd API returned unparsable or null response");
        }

        return brewery;
    }

    public List<Beer> getBeersByBrewery(final Brewery brewery)
    {
        String response = httpUtil.get("brewery/info/" + brewery.getId(), "q=" + brewery.getName());

        // Parse JSON and extract list of beers

        return null;
    }
}
