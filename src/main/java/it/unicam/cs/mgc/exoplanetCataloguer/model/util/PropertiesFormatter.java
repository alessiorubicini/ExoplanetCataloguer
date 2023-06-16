package it.unicam.cs.mgc.exoplanetCataloguer.model.util;

/**
 * This class is used to format and clean up properties strings.
 */
public class PropertiesFormatter {

    /**
     * Removes useless types from inferenced type statement
     * @param input the rdf:type string
     * @return the string without unnecessary types for the context
     */
    public static String removeUselessTypes(String input) {
        input = input.replace("Thing, ", "");
        input = input.replace(", NamedIndividual", "");
        return input;
    }

    /**
     * Returns the resource of a URI
     * @param uri the complete URI to format
     * @return the resource as a string
     */
    public static String removeUriPrefix(String uri) {
        if(uri != null) {
            int index = uri.indexOf('#');
            if (index != -1) return uri.substring(index + 1);
            else return uri;
        } else {
            return "null";
        }
    }

    /**
     * Converts a string from camelCase style to white spaced style
     * @param camelCase the string in camel case format
     * @return the white spaced string
     */
    public static String camelCaseToSpacedString(String camelCase) {
        StringBuilder spacedString = new StringBuilder();
        for (int i = 0; i < camelCase.length(); i++) {
            char currentChar = camelCase.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                if (i > 0) {
                    spacedString.append(' ');
                }
                spacedString.append(Character.toLowerCase(currentChar));
            } else {
                spacedString.append(currentChar);
            }
        }
        return spacedString.toString();
    }

}

