package com.dimas.processing;

public interface DataProcessor<T> {
    void process(Statistics<T> statistics, String input);
}
