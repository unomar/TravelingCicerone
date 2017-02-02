package com.weissbrewing.cicerone.webservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.weissbrewing.cicerone.domain.Brewery;
import com.weissbrewing.cicerone.domain.Location;
import com.weissbrewing.cicerone.service.BreweryService;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;

import java.util.List;

/**
 * Created by kevinweiss on 1/29/17.
 */
public class LocationComparisonRestlet extends Restlet
{
    private BreweryService breweryService;

    /**
     * Constructor
     * @param breweryService The brewery service to use
     */
    public LocationComparisonRestlet(BreweryService breweryService)
    {
        this.breweryService = breweryService;
    }

    /**
     * Process the REST request for a brewery search
     * @param request
     * @param response
     */
    @Override
    public void handle(Request request, Response response)
    {
        String current = (String) request.getAttributes().get("current");
        String home = (String) request.getAttributes().get("home");

        Location currentLocation = Location.valueOf(current);
        Location homeLocation = Location.valueOf(home);

        if (request.getMethod().equals(Method.GET))
        {
            Gson gson = new GsonBuilder().create();
            List<String> breweries = breweryService.getUnavailableBreweries(homeLocation, currentLocation);

            response.setEntity(gson.toJson(breweries), MediaType.APPLICATION_JSON);
        }
        else
        {
            response.setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
        }
    }
}
