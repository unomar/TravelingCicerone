package com.weissbrewing.cicerone.domain.untappdAPI;

/**
 * Created by kevinweiss on 1/13/17.
 */
public class Response
{
    private Meta meta;

    private QueryResponse response;

    public Meta getMeta()
    {
        return meta;
    }

    public QueryResponse getResponse()
    {
        return response;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("Response{");
        sb.append("meta=");
        sb.append(meta);
        sb.append("} response=[");
        sb.append(response.toString());
        sb.append("}");

        return sb.toString();
    }
}
