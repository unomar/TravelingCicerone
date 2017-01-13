package com.weissbrewing.cicerone.domain.untappdAPI;

/**
 * Created by kevinweiss on 1/13/17.
 */
public class BrewerySearchResponseContainer
{
    private Meta meta;

    private BrewerySearchResponse response;

    public Meta getMeta()
    {
        return meta;
    }

    public BrewerySearchResponse getResponse()
    {
        return response;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("BrewerySearchResponseContainer{");
        sb.append("meta=");
        sb.append(meta);
        sb.append("} response=[");
        sb.append(response.toString());
        sb.append("}");

        return sb.toString();
    }
}
