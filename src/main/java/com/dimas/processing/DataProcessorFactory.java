package com.dimas.processing;

import com.dimas.cli.CommandOptions;
import com.dimas.utils.DataConverter;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class DataProcessorFactory {
    private final Map<Class<?>, DataProcessor<?>> processors = new HashMap<>();

    public DataProcessorFactory(CommandOptions commandOptions) {
        var dataConverter = new DataConverter();

        this.processors.put(Long.class, new IntegerProcessor(commandOptions, new Statistics<>("integers.txt"), dataConverter));
        this.processors.put(Double.class, new FloatProcessor(commandOptions, new Statistics<>("floats.txt"), dataConverter));
        this.processors.put(String.class, new StringProcessor(commandOptions, new Statistics<>("strings.txt")));
    }

    public DataProcessor<?> getProcessor(Class<?> clazz) {
        return this.processors.getOrDefault(clazz, this.processors.get(String.class));
    }
}
