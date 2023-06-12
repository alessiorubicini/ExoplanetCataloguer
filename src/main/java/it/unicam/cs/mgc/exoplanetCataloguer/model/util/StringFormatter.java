package it.unicam.cs.mgc.exoplanetCataloguer.model.util;

/**
 * Utility class to format strings in specific ways
 */
public class StringFormatter {

    public static String removeUriPrefix(String uri) {
        if(uri != null) {
            int index = uri.indexOf('#');
            if (index != -1) return uri.substring(index + 1);
            else return uri;
        } else {
            return "null";
        }
    }

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

