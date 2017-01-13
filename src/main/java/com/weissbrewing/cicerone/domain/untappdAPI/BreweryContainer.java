package com.weissbrewing.cicerone.domain.untappdAPI;

/**
 * Created by kevinweiss on 1/13/17.
 */
public class BreweryContainer
{
    private Brewery brewery;

    public Brewery getBrewery()
    {
        return brewery;
    }

    @Override
    public String toString()
    {
        return "BreweryContainer{" +
                "brewery=" + brewery +
                '}';
    }
}
