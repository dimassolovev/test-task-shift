package com.dimas.utils;

public class TypeParser {
    public Class<?> parseType(String input) {
        if (input == null || input.isEmpty()) {
            return String.class;
        }

        try {
            Long.parseLong(input);
            return Long.class;
        } catch (NumberFormatException ignored) {
        }

        try {
            Double.parseDouble(input);
            return Double.class;
        } catch (NumberFormatException ignored) {
        }

        return String.class;
    }
}
