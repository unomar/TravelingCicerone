package com.weissbrewing.cicerone.das;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.weissbrewing.cicerone.domain.Brewery;
import com.weissbrewing.cicerone.domain.untappdAPI.*;
import com.weissbrewing.cicerone.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringReader;

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

        return parseBrewerySearchResponse(brewery, responseStr);
    }

    /**
     * Retrieve information about a specific brewery from the external API
     * @param brewery
     * @return
     */
    public Brewery getBreweryInfo(final Brewery brewery)
    {
        String responseStr = httpUtil.get("brewery/info/" + brewery.getApiId(), null);

        LOG.info("Received BreweryInfo response: " + responseStr);

        return parseBreweryInfoResponse(brewery, responseStr);
    }

    /**
     * Parse a Brewery Search Response object
     * @param brewery
     * @param responseStr
     * @return
     */
    private Brewery parseBrewerySearchResponse(Brewery brewery, final String responseStr)
    {
        // Parse JSON brewerySearchResponseContainer and extract Brewery_ID
        StringReader stringReader = new StringReader(responseStr);
        Gson gson = new GsonBuilder().create();
        BrewerySearchResponseContainer brewerySearchResponseContainer = gson.fromJson(stringReader, BrewerySearchResponseContainer.class);

        LOG.info("Received brewerySearchResponseContainer: " + brewerySearchResponseContainer.toString());

        // Set Brewery_ID on brewery object and return.
        if (brewerySearchResponseContainer != null)
        {
            BreweryList breweryList = brewerySearchResponseContainer.getResponse().getBrewery();
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
            LOG.error("Untappd API returned unparsable or null brewerySearchResponseContainer");
        }

        return brewery;
    }

    /**
     * Parse a Brewery Info Response object
     * @param brewery
     * @param responseStr
     * @return
     */
    private Brewery parseBreweryInfoResponse(Brewery brewery, final String responseStr)
    {
        // Parse JSON brewerySearchResponseContainer and extract Brewery_ID
        StringReader stringReader = new StringReader(responseStr);
        Gson gson = new GsonBuilder().create();
        BreweryInfoResponseContainer breweryInfoResponseContainer = gson.fromJson(stringReader, BreweryInfoResponseContainer.class);

        LOG.info("Received brewerySearchResponseContainer: " + breweryInfoResponseContainer.toString());

        // Set Brewery_ID on brewery object and return.
        if (breweryInfoResponseContainer != null)
        {
            com.weissbrewing.cicerone.domain.untappdAPI.Brewery breweryList = breweryInfoResponseContainer.getResponse().getBrewery();
            if (breweryList.getBeer_count() != 0)
            {
                for (BeerListContainer beerListContainer : breweryList.getBeer_list().getItems())
                {
                    Beer beer = beerListContainer.getBeer();
                    com.weissbrewing.cicerone.domain.Beer dBeer = new com.weissbrewing.cicerone.domain.Beer();
                    dBeer.setName(beer.getBeer_name());
                    dBeer.setAbv(beer.getBeer_abv());
                    dBeer.setDescription(beer.getBeer_description());
                    dBeer.setStyle(beer.getBeer_style());
                    dBeer.setIbu(beer.getBeer_ibu());
                    dBeer.setLabel(beer.getBeer_label());
                    dBeer.setOverall_score(beer.getRating_score());
                    dBeer.setUser_score(beer.getAuth_rating());
                    dBeer.setRating_count(beer.getRating_count());
                    dBeer.setWish_list(beer.isWish_list());

                    brewery.getBeerList().add(dBeer);
                }
            }
            else
            {
                LOG.error("Untappd API did not find any breweries matching the name: [" + brewery.getName() + "]");
            }
        }
        else
        {
            LOG.error("Untappd API returned unparsable or null brewerySearchResponseContainer");
        }

        return brewery;
    }
}
