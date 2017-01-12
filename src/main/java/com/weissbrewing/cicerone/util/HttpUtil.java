package com.weissbrewing.cicerone.util;


import com.weissbrewing.cicerone.das.DistributionDAS;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import static org.apache.http.protocol.HTTP.USER_AGENT;

/**
 * Created by kevinweiss on 1/12/17.
 */
public class HttpUtil
{
    private static final Logger LOG = LoggerFactory.getLogger(HttpUtil.class.getName());

    private static final String BASE_URL = "https://api.untappd.com/v4/";
        //method_name?client_id=CLIENTID&client_secret=CLIENTSECRET";
    public static final String CLIENT_ID = "client_id=EA379E1B4EDC01F652FD0C9E0BFCB93F1F74DE68";
    public static final String CLIENT_SECRET = "client_secret=857595F39642428028062978B593475CBF052569";
    public static final String CREDENTIALS = "&" + CLIENT_ID + "&" + CLIENT_SECRET;

    /**
     * Execute a HTTP GET request using the specified URL
     * @param method The method to query
     * @param params The method parameters
     * @return The response as a String
     */
    public static String get(String method, String params)
    {
        HttpClient client = HttpClientBuilder.create().build();

        StringBuffer result = new StringBuffer();

        try
        {
            //String encodedParams = URLEncoder.encode(params + CREDENTIALS, "UTF-8");
            params += CREDENTIALS;
            String encodedParams = params.replaceAll(" ", "+");
            String url = BASE_URL + method + "?" + encodedParams;
            LOG.info("Encoded URL: " + url);

            HttpGet request = new HttpGet(url);

            request.addHeader("User-Agent", USER_AGENT);
            HttpResponse response = client.execute(request);

            if (LOG.isTraceEnabled())
            {
                LOG.trace("Response Code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));


            String line = "";
            while ((line = rd.readLine()) != null)
            {
                result.append(line);
            }
        }
        catch (IOException e)
        {
            LOG.error("Caught IOException attempting to issue HTTP GET request", e);
        }

        return result.toString();
    }
}
