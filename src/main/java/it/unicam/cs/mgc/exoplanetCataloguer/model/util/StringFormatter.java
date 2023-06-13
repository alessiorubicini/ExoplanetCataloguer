package it.unicam.cs.mgc.exoplanetCataloguer.model.util;

/**
 * Utility class to format strings in specific ways useful for this context
 */
public class StringFormatter {

    /**
     * Returns the resource of an URI
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

    /**
     * Converts any string to camelCase style
     * @param input the string to convert
     * @return the string in camel case style
     */
    public static String transformToCamelCase(String input) {
        if (input == null || input.isEmpty()) return input;

        StringBuilder camelCase = new StringBuilder();
        boolean capitalizeNext = false;

        for (char c : input.toCharArray()) {
            if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                camelCase.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                camelCase.append(Character.toLowerCase(c));
            }
        }

        return camelCase.toString();
    }
}

