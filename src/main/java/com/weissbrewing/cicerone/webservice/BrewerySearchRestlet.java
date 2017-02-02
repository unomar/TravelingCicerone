package com.weissbrewing.cicerone.webservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.weissbrewing.cicerone.domain.Brewery;
import com.weissbrewing.cicerone.service.BreweryService;
import org.restlet.Component;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Protocol;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.util.Iterator;
import java.util.List;

/**
 * Created by kevinweiss on 1/18/17.
 */
public class BrewerySearchRestlet extends Restlet
{
    private BreweryService breweryService;

    /**
     * Constructor
     * @param breweryService The brewery service to use
     */
    public BrewerySearchRestlet(BreweryService breweryService)
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
        String breweryName = (String) request.getAttributes().get("breweryName");
        if (request.getMethod().equals(Method.GET))
        {
            Gson gson = new GsonBuilder().create();
            Brewery brewery = breweryService.getBreweryByName(breweryName);

            response.setEntity(gson.toJson(brewery), MediaType.APPLICATION_JSON);
        }
        else
        {
            response.setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
        }
    }
}
