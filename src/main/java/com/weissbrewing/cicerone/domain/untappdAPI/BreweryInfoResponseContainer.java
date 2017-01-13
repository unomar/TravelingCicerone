package com.weissbrewing.cicerone.domain.untappdAPI;

/**
 * Created by kevinweiss on 1/13/17.
 */
public class BreweryInfoResponseContainer
{
    private Meta meta;

    private BreweryInfoResponse response;

    public Meta getMeta()
    {
        return meta;
    }

    public BreweryInfoResponse getResponse()
    {
        return response;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("BreweryInfoResponseContainer{");
        sb.append("meta=");
        sb.append(meta);
        sb.append("} response=[");
        sb.append(response.toString());
        sb.append("}");

        return sb.toString();
    }
}
