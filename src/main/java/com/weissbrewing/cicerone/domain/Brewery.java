package com.weissbrewing.cicerone.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevinweiss on 1/11/17.
 */
public class Brewery
{
    private int id;

    private String name;

    private List<Location> locations;

    private Integer availability;

    private Integer apiId;

    private List<Beer> beerList;

    public Brewery()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Location> getLocations()
    {
        return locations;
    }

    public void setLocations(List<Location> locations)
    {
        this.locations = locations;
    }

    public Integer getAvailability()
    {
        return availability;
    }

    public void setAvailability(Integer availability)
    {
        this.availability = availability;
    }

    public Integer getApiId()
    {
        return apiId;
    }

    public void setApiId(Integer apiId)
    {
        this.apiId = apiId;
    }

    public List<Beer> getBeerList()
    {
        if (beerList == null)
        {
            this.beerList = new ArrayList<>();
        }
        return beerList;
    }

    public void setBeerList(List<Beer> beerList)
    {
        this.beerList = beerList;
    }
}
