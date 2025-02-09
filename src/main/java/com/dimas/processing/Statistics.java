package com.dimas.processing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Statistics<T> {
    private String fileName;
    private List<String> values = new ArrayList<>();
    private T max;
    private T min;
    private double sum = 0.0;
    private double avg = 0.0;
    private int minLength = Integer.MAX_VALUE;
    private int maxLength = Integer.MIN_VALUE;

    public Statistics(String fileName) {
        this.fileName = fileName;
    }
}
