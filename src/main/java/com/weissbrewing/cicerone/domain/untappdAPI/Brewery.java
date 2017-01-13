package com.weissbrewing.cicerone.domain.untappdAPI;

/**
 * Created by kevinweiss on 1/13/17.
 */
public class Brewery
{
    private int brewery_id;

    private int beer_count;

    private String brewery_name;

    private String brewery_slug;

    private String brewery_label;

    private String country_name;

    private BeerList beer_list;

    public int getBrewery_id()
    {
        return brewery_id;
    }

    public int getBeer_count()
    {
        return beer_count;
    }

    public String getBrewery_name()
    {
        return brewery_name;
    }

    public String getBrewery_slug()
    {
        return brewery_slug;
    }

    public String getBrewery_label()
    {
        return brewery_label;
    }

    public String getCountry_name()
    {
        return country_name;
    }

    public BeerList getBeer_list()
    {
        return beer_list;
    }

    public void setBeer_list(BeerList beer_list)
    {
        this.beer_list = beer_list;
    }

    @Override
    public String toString()
    {
        return "Brewery{" +
                "brewery_id=" + brewery_id +
                ", beer_count=" + beer_count +
                ", brewery_name='" + brewery_name + '\'' +
                ", brewery_slug='" + brewery_slug + '\'' +
                ", brewery_label='" + brewery_label + '\'' +
                ", country_name='" + country_name + '\'' +
                ", beer_list=" + beer_list +
                '}';
    }
}
