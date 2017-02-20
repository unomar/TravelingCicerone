package com.weissbrewing.cicerone.app;

import com.weissbrewing.cicerone.service.BreweryService;
import com.weissbrewing.cicerone.webservice.BrewerySearchRestlet;
import com.weissbrewing.cicerone.webservice.LocationComparisonRestlet;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

/**
 * Created by kevinweiss on 1/20/17.
 */
public class TravelingCiceroneWebApp extends Application
{

    public static final String BREWERY_SEARCH_ENDPOINT = "/brewerysearch/{breweryName}";
    public static final String BREWERY_COMPARISON_ENDPOINT = "/brewerysearch/{current}/{home}";
    public static final int PORT = 8182;

    public static void main(String [] args) throws Exception {
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, PORT);

        BrewerySearchRestlet brewerySearchRestlet = new BrewerySearchRestlet(new BreweryService());
        component.getDefaultHost().attach(BREWERY_SEARCH_ENDPOINT, brewerySearchRestlet);
        component.getDefaultHost().attach(BREWERY_COMPARISON_ENDPOINT, new LocationComparisonRestlet(new BreweryService()));
        component.start();
    }

    public Restlet createRoot() {
        Router router = new Router(getContext());
        router.attach(BREWERY_SEARCH_ENDPOINT, new BrewerySearchRestlet(new BreweryService()));
        router.attach(BREWERY_COMPARISON_ENDPOINT, new LocationComparisonRestlet(new BreweryService()));

        return router;
    }
}