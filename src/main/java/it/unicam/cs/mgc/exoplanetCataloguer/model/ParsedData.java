package it.unicam.cs.mgc.exoplanetCataloguer.model;

import java.util.Collection;

/**
 * Classes implementing this interface are used to expose dictionary-like data
 */
public interface ParsedData {

    /**
     * Returns the value of a specific property in the data.
     * @param property the key value
     * @return the value corresponding to the key
     */
    String getProperty(String property);

    /**
     * Returns all the values from the data
     * @return the collection of values
     */
    Collection<String> getAllValues();

}
