package com.weissbrewing.cicerone.domain.untappdAPI;

import java.util.List;

/**
 * Created by kevinweiss on 1/13/17.
 */
public class BeerList
{
    private int count;

    private List<BeerListContainer> items;

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public List<BeerListContainer> getItems()
    {
        return items;
    }

    public void setItems(List<BeerListContainer> items)
    {
        this.items = items;
    }

    @Override
    public String toString()
    {
        return "BeerList{" +
                "count=" + count +
                ", items=" + items +
                '}';
    }
}
