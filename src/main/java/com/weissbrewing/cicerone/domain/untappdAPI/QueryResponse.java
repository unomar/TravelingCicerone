package com.weissbrewing.cicerone.domain.untappdAPI;

import com.weissbrewing.cicerone.domain.Brewery;

import java.util.List;

/**
 * Created by kevinweiss on 1/13/17.
 */
public class QueryResponse
{
    private String search_type;

    private String sort;

    private String term;

    private String key;

    private int found;

    private BreweryList brewery;

    public String getSearch_type()
    {
        return search_type;
    }

    public String getSort()
    {
        return sort;
    }

    public String getTerm()
    {
        return term;
    }

    public String getKey()
    {
        return key;
    }

    public int getFound()
    {
        return found;
    }

    public BreweryList getBrewery()
    {
        return brewery;
    }

    @Override
    public String toString()
    {
        return "QueryResponse{" +
                "search_type='" + search_type + '\'' +
                ", sort='" + sort + '\'' +
                ", term='" + term + '\'' +
                ", key='" + key + '\'' +
                ", found=" + found +
                ", brewery=" + brewery +
                '}';
    }
}
