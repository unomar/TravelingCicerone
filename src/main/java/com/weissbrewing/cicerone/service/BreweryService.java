package com.weissbrewing.cicerone.service;

import com.weissbrewing.cicerone.das.DistributionDAS;
import com.weissbrewing.cicerone.domain.Brewery;
import com.weissbrewing.cicerone.domain.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevinweiss on 1/11/17.
 */
public class BreweryService
{
    private DistributionDAS distributionDAS = new DistributionDAS();

    /**
     * Default Constructor
     */
    public BreweryService()
    {

    }

    /**
     * Get a list of breweries available in your current state that are unavailable in your home state.
     * @param home Home location
     * @param current Current location
     * @return A list of brewery names
     */
    public List<String> getUnavailableBreweries(Location home, Location current)
    {
        return getUnavailableBreweriesByAvailability(home, current, 0);
    }

    /**
     * Get a list of breweries available in your current state that are unavailable in your home state.
     * @param home Home location
     * @param current Current location
     * @param minAvailability The minimum availibility index to return
     * @return A list of brewery names
     */
    public List<String> getUnavailableBreweriesByAvailability(Location home, Location current, final int minAvailability)
    {
        List<String> breweryNames = new ArrayList<>();


        List<Brewery> breweries = null;

        if (current == null)
        {
            breweries = distributionDAS.getBreweriesByLocation(home);
        }
        else
        {
            breweries = distributionDAS.getUniqueBreweries(home, current);
        }

        for (Brewery brewery : breweries)
        {
            if (brewery.getAvailability() > minAvailability)
            {
                breweryNames.add(brewery.getName());
            }
        }

        return breweryNames;
    }

    /**
     * Get a list of Available Brewery names by state
     * @param location The state
     * @return A list of brewery names
     */
    public List<String> getAvailableBreweriesByState(Location location)
    {
        return getUnavailableBreweries(location, null);
    }

    public static void main(String [] args)
    {
        if (args.length < 1)
        {
            System.out.println("Usage: ");
            System.out.println("  " + BreweryService.class.getName() + " location1 <location2>");
            System.exit(1);
        }

        Location home = Location.valueOf(args[0]);

        BreweryService breweryService = new BreweryService();
        List<String> breweryNames;

        if (args.length > 1)
        {
            Location current = Location.valueOf(args[1]);

            breweryNames = breweryService.getUnavailableBreweries(home, current);
            System.out.println("Breweries available in " + current.name() + " that are not available in " + home.name());
        }
        else
        {
            breweryNames = breweryService.getAvailableBreweriesByState(home);
            System.out.println("Breweries available in " + home.name());
        }

        if (breweryNames != null)
        {
            for (String name : breweryNames)
            {
                System.out.println(" " + name);
            }
        }
    }
}
