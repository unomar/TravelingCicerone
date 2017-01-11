package com.weissbrewing.cicerone.das;

import com.weissbrewing.cicerone.domain.Brewery;
import com.weissbrewing.cicerone.domain.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.*;

/**
 * Created by kevinweiss on 1/11/17.
 */
public class DistributionDAS
{
    private static final Logger LOG = LoggerFactory.getLogger(DistributionDAS.class.getName());

    private static final String SQLITE_JDBC = "org.sqlite.JDBC";

    private static final String GET_UNIQUE_BREWERIES_SQL = "select * from distribution where %s = 0 and %s = 1";
    private static final String GET_BREWERIES_SQL = "select * from distribution where %s = 1";

    private Connection c = null;

    /**
     * Initialize the SQLite DB connection
     */
    private void init()
    {
        try {
            Class.forName(SQLITE_JDBC);
            c = DriverManager.getConnection("jdbc:sqlite::resource:beer.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        LOG.info("Database initialized");
    }

    /**
     * Default Constructor
     */
    public DistributionDAS()
    {
        init();
    }

    public List<Brewery> getBreweriesByLocation(final Location location)
    {
        String query = String.format(GET_BREWERIES_SQL, location.name());
        return getBreweries(query);
    }

    /**
     * Retrieve a list of unique breweries
     * @param home The users home location
     * @param current The users current location
     * @return A list of breweries that are not available in their home state, but are available in their current state
     */
    public List<Brewery> getUniqueBreweries(final Location home, final Location current)
    {
        String query = String.format(GET_UNIQUE_BREWERIES_SQL, home.name(), current.name());
        return getBreweries(query);
    }

    /**
     * Retrieve a list of breweries using the specified SQL Query
     * @param sqlQuery The Query to use
     * @return A list of Breweries
     */
    private List<Brewery> getBreweries(final String sqlQuery)
    {
        List<Brewery> breweries = new ArrayList<>();

        if (c == null)
        {
            init();
        }

        Statement stmt = null;
        try
        {
            stmt = c.createStatement();

            LOG.info("Executing query: " + sqlQuery);
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next())
            {
                Brewery brewery = buildBrewery(rs);
                breweries.add(brewery);
            }

            rs.close();
        }
        catch (SQLException e)
        {
            LOG.error("Caught SQLException  attempting to get unique breweries", e);
        }
        finally
        {
            if (stmt != null)
            {
                try
                {
                    stmt.close();
                }
                catch (SQLException e)
                {
                    LOG.error("Caught exception attempting to close stmt", e);
                }
            }
        }

        return breweries;
    }

    /**
     * Build a brewery object from a ResultSet
     * @param rs The ResultSet object containing Brewery Info
     * @return A Brewery object
     * @throws SQLException on error
     */
    private Brewery buildBrewery(ResultSet rs) throws SQLException
    {
        Brewery brewery = new Brewery();
        brewery.setId(rs.getInt("id"));
        brewery.setName(rs.getString("name"));
        brewery.setAvailability(rs.getInt("Total"));

        List<Location> locations = new ArrayList<>();
        for (Location location : Location.values())
        {
            if (rs.getInt(location.name()) == 1)
            {
                locations.add(location);
            }
        }
        brewery.setLocations(locations);

        return brewery;
    }
}
