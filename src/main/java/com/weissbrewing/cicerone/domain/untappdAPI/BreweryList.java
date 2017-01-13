package com.weissbrewing.cicerone.domain.untappdAPI;

import com.weissbrewing.cicerone.domain.*;

import java.util.List;

/**
 * Created by kevinweiss on 1/13/17.
 */
public class BreweryList
{
    private int count;

    private List<BreweryContainer> items;

    public int getCount()
    {
        return count;
    }

    public List<BreweryContainer> getItems()
    {
        return items;
    }

    @Override
    public String toString()
    {
        return "BreweryList{" +
                "count=" + count +
                ", items=" + items +
                '}';
    }
}
