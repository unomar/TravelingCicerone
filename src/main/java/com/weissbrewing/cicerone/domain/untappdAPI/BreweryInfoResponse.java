package com.weissbrewing.cicerone.domain.untappdAPI;

/**
 * Created by kevinweiss on 1/13/17.
 */
public class BreweryInfoResponse
{
    private Brewery brewery;

    public Brewery getBrewery()
    {
        return brewery;
    }

    public void setBrewery(Brewery brewery)
    {
        this.brewery = brewery;
    }

    @Override
    public String toString()
    {
        return "BreweryInfoResponse{" +
                "brewery=" + brewery +
                '}';
    }
}
