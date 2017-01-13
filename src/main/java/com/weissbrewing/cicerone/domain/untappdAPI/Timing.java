package com.weissbrewing.cicerone.domain.untappdAPI;

/**
 * Created by kevinweiss on 1/13/17.
 */
public class Timing
{
    private double time;

    private String measure;

    /**
     * Custom toString method
     * @return
     */
    @Override
    public String toString()
    {
        return "time=" + time + " measure="  + measure;
    }
}
