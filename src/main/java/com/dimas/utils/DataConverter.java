package com.dimas.utils;

public class DataConverter {
    public Object convertToType(Class<?> type, String line) {
        if (type == Double.class) {
            return Double.parseDouble(line);
        } else if (type == Long.class) {
            return Long.parseLong(line);
        } else if (type == String.class) {
            return line;
        } else {
            throw new IllegalArgumentException("Unsupported type: " + type.getName());
        }
    }
}
