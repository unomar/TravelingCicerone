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
    public static void main(String [] args) throws Exception {
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 8182);

        BrewerySearchRestlet brewerySearchRestlet = new BrewerySearchRestlet(new BreweryService());
        component.getDefaultHost().attach("/brewerysearch/{breweryName}", brewerySearchRestlet);
        component.getDefaultHost().attach("/brewerysearch/{current}/{home}", new LocationComparisonRestlet(new BreweryService()));
        component.start();
    }

    public Restlet createRoot() {
        Router router = new Router(getContext());
        router.attach("/brewerysearch/{breweryName}", new BrewerySearchRestlet(new BreweryService()));
        router.attach("/brewerysearch/{current}/{home}", new LocationComparisonRestlet(new BreweryService()));

        return router;
    }
}
