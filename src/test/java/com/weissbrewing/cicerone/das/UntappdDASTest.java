package com.weissbrewing.cicerone.das;

import com.weissbrewing.cicerone.domain.Brewery;
import com.weissbrewing.cicerone.util.HttpUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.print.URIException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by kevinweiss on 1/12/17.
 */
public class UntappdDASTest
{
    private HttpUtil mockHttpUtil = Mockito.mock(HttpUtil.class);

    private static final String breweryName = "Dogfish Head";

    private static final String SEARCH_BREWERY_RESPONSE = "searchBreweryResponse.json";

    @Test
    public void testSearchBrewery()
    {
        UntappdDAS untappdDAS = new UntappdDAS(mockHttpUtil);

        try
        {
            String response = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(SEARCH_BREWERY_RESPONSE).toURI())));
            Mockito.when(mockHttpUtil.get("search/brewery", "q=" + breweryName)).thenReturn(response);

            Brewery brewery = new Brewery();

            brewery.setName(breweryName);
            Brewery retrieved = untappdDAS.searchBrewery(brewery);

            Assert.assertEquals("UntappdDAS did not set the correct Brewery API ID", new Integer(459), retrieved.getApiId());
        }
        catch (IOException|URISyntaxException e)
        {
            Assert.fail("Caught IOException attempting to load json from file");
        }
    }
}
