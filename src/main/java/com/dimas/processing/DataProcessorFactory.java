package com.dimas.processing;

import com.dimas.cli.CommandOptions;

import java.util.HashMap;
import java.util.Map;

public class DataProcessorFactory {
    private final Map<Class<?>, DataProcessor<?>> processors = new HashMap<>();

    public DataProcessorFactory(CommandOptions commandOptions) {
        this.processors.put(Long.class, new IntegerProcessor(commandOptions));
        this.processors.put(Double.class, new FloatProcessor(commandOptions));
        this.processors.put(String.class, new StringProcessor(commandOptions));
    }

    public DataProcessor<?> getProcessor(Class<?> clazz) {
        return this.processors.getOrDefault(clazz, this.processors.get(String.class));
    }
}
