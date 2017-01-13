package com.weissbrewing.cicerone.domain;

/**
 * Created by kevinweiss on 1/12/17.
 */
public class Beer
{
    private String name;
    private String style;
    private Double abv;
    private String description;
    private String label;
    private double ibu;
    private double user_score;
    private double overall_score;
    private int rating_count;
    private boolean wish_list;



    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getStyle()
    {
        return style;
    }

    public void setStyle(String style)
    {
        this.style = style;
    }

    public Double getAbv()
    {
        return abv;
    }

    public void setAbv(Double abv)
    {
        this.abv = abv;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public double getIbu()
    {
        return ibu;
    }

    public void setIbu(double ibu)
    {
        this.ibu = ibu;
    }

    public double getUser_score()
    {
        return user_score;
    }

    public void setUser_score(double user_score)
    {
        this.user_score = user_score;
    }

    public double getOverall_score()
    {
        return overall_score;
    }

    public void setOverall_score(double overall_score)
    {
        this.overall_score = overall_score;
    }

    public int getRating_count()
    {
        return rating_count;
    }

    public void setRating_count(int rating_count)
    {
        this.rating_count = rating_count;
    }

    public boolean isWish_list()
    {
        return wish_list;
    }

    public void setWish_list(boolean wish_list)
    {
        this.wish_list = wish_list;
    }

    @Override
    public String toString()
    {
        return "Beer{" +
                "name='" + name + '\'' +
                ", style='" + style + '\'' +
                ", abv=" + abv +
                ", description='" + description + '\'' +
                ", label='" + label + '\'' +
                ", ibu=" + ibu +
                ", user_score=" + user_score +
                ", overall_score=" + overall_score +
                ", rating_count=" + rating_count +
                ", wish_list=" + wish_list +
                '}';
    }
}
