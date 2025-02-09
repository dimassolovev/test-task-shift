package com.dimas.processing;

public interface DataProcessor<T> {
    void process(String input);

    Statistics<T> statistics();
}
