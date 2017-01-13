package com.weissbrewing.cicerone.domain.untappdAPI;

/**
 * Created by kevinweiss on 1/13/17.
 */
public class BeerListContainer
{
    private Beer beer;

    public Beer getBeer()
    {
        return beer;
    }

    public void setBeer(Beer beer)
    {
        this.beer = beer;
    }

    @Override
    public String toString()
    {
        return "BeerListContainer{" +
                "beer=" + beer +
                '}';
    }
}

