package it.unicam.cs.mgc.exoplanetCataloguer.model;

/**
 * Classes implementing this interface are used to expose a dictionary-like data chunk regarding an entity
 */
public interface AppData {
    /**
     * Returns the value of a specific property in the data chunck
     * @param property the key value
     * @return the value corresponding to the key
     */
    String getProperty(String property);
}
