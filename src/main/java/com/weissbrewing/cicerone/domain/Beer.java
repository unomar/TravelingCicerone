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

}
