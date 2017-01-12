package com.weissbrewing.cicerone.das;

import com.weissbrewing.cicerone.domain.Brewery;
import org.junit.Test;

/**
 * Created by kevinweiss on 1/12/17.
 */
public class UntappdDASTest
{
    private UntappdDAS untappdDAS = new UntappdDAS();

    @Test
    public void testGetBeersByBrewery()
    {
        Brewery brewery = new Brewery();
        brewery.setName("Dogfish Head");
        untappdDAS.searchBrewery(brewery);
    }
}
