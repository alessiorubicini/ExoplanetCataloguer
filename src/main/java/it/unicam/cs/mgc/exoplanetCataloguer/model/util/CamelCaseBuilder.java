package it.unicam.cs.mgc.exoplanetCataloguer.model.util;

public class CamelCaseBuilder {
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

