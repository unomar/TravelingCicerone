package com.weissbrewing.cicerone.domain.untappdAPI;

/**
 * Created by kevinweiss on 1/13/17.
 */
public class Beer
{
    private int bid;
    private String beer_name;
    private String beer_label;
    private String beer_style;
    private double beer_abv;
    private double beer_ibu;
    private String beer_slug;
    private String beer_description;
    private int is_in_production;
    private String created_at;
    private int auth_rating;
    private boolean wish_list;
    private double rating_score;
    private int rating_count;

    public int getBid()
    {
        return bid;
    }

    public void setBid(int bid)
    {
        this.bid = bid;
    }

    public String getBeer_name()
    {
        return beer_name;
    }

    public void setBeer_name(String beer_name)
    {
        this.beer_name = beer_name;
    }

    public String getBeer_label()
    {
        return beer_label;
    }

    public void setBeer_label(String beer_label)
    {
        this.beer_label = beer_label;
    }

    public String getBeer_style()
    {
        return beer_style;
    }

    public void setBeer_style(String beer_style)
    {
        this.beer_style = beer_style;
    }

    public double getBeer_abv()
    {
        return beer_abv;
    }

    public void setBeer_abv(double beer_abv)
    {
        this.beer_abv = beer_abv;
    }

    public double getBeer_ibu()
    {
        return beer_ibu;
    }

    public void setBeer_ibu(double beer_ibu)
    {
        this.beer_ibu = beer_ibu;
    }

    public String getBeer_slug()
    {
        return beer_slug;
    }

    public void setBeer_slug(String beer_slug)
    {
        this.beer_slug = beer_slug;
    }

    public String getBeer_description()
    {
        return beer_description;
    }

    public void setBeer_description(String beer_description)
    {
        this.beer_description = beer_description;
    }

    public int getIs_in_production()
    {
        return is_in_production;
    }

    public void setIs_in_production(int is_in_production)
    {
        this.is_in_production = is_in_production;
    }

    public String getCreated_at()
    {
        return created_at;
    }

    public void setCreated_at(String created_at)
    {
        this.created_at = created_at;
    }

    public int getAuth_rating()
    {
        return auth_rating;
    }

    public void setAuth_rating(int auth_rating)
    {
        this.auth_rating = auth_rating;
    }

    public boolean isWish_list()
    {
        return wish_list;
    }

    public void setWish_list(boolean wish_list)
    {
        this.wish_list = wish_list;
    }

    public double getRating_score()
    {
        return rating_score;
    }

    public void setRating_score(double rating_score)
    {
        this.rating_score = rating_score;
    }

    public int getRating_count()
    {
        return rating_count;
    }

    public void setRating_count(int rating_count)
    {
        this.rating_count = rating_count;
    }

    @Override
    public String toString()
    {
        return "Beer{" +
                "bid=" + bid +
                ", beer_name='" + beer_name + '\'' +
                ", beer_label='" + beer_label + '\'' +
                ", beer_style='" + beer_style + '\'' +
                ", beer_abv=" + beer_abv +
                ", beer_ibu=" + beer_ibu +
                ", beer_slug='" + beer_slug + '\'' +
                ", beer_description='" + beer_description + '\'' +
                ", is_in_production=" + is_in_production +
                ", created_at='" + created_at + '\'' +
                ", auth_rating=" + auth_rating +
                ", wish_list=" + wish_list +
                ", rating_score=" + rating_score +
                ", rating_count=" + rating_count +
                '}';
    }
}
