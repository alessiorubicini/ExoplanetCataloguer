package it.unicam.cs.mgc.exoplanetCataloguer.model;

import it.unicam.cs.mgc.exoplanetCataloguer.model.util.PropertiesFormatter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PropertiesFormatterTest {

    @Test
    public void testRemoveUselessTypes() {
        String test = "Thing, celestial body, planet, rocky planet, NamedIndividual";
        String result = PropertiesFormatter.removeUselessTypes(test);
        assertEquals("celestial body, planet, rocky planet", result);
    }

    @Test
    public void testRemoveURI() {
        String test = "http://www.w3.org/2000/01/rdf-schema#type";
        String result = PropertiesFormatter.removeUriPrefix(test);
        assertEquals("type", result);
    }

    @Test
    public void testCamelCaseToSpacedString() {
        String test = "isMainlyComposedOf";
        String result = PropertiesFormatter.camelCaseToSpacedString(test);
        assertEquals("is mainly composed of", result);
    }

    @Test
    public void testStringToFirstLetterUpperCase() {
        String test = "trappist-1d";
        String result = PropertiesFormatter.stringToFirstLetterUpperCase(test);
        assertEquals("Trappist-1d", result);
    }

}
