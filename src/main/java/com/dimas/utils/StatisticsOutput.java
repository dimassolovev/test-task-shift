package com.dimas.utils;

import com.dimas.cli.CommandOptions;
import com.dimas.processing.Statistics;

public class StatisticsOutput {
    public void print(Statistics<?> statistics, CommandOptions commandOptions) {

        if (!statistics.getValues().isEmpty() && (commandOptions.isOptionF() || commandOptions.isOptionS())
        ) {
            System.out.printf("Количество элементов: %s\n", statistics.getValues().size());

            if (statistics.getMax() != null) {
                System.out.printf("Максимальное значение: %s\n", statistics.getMax());
                System.out.printf("Минимальное значение: %s\n", statistics.getMin());
                System.out.printf("Сумма: %s\n", statistics.getSum());
                System.out.printf("Среднее: %s\n", statistics.getAvg());
            }

            else {
                System.out.printf("Максимальная длина строки: %s\n", statistics.getMaxLength());
                System.out.printf("Минимальная длина строки: %s\n", statistics.getMinLength());
            }
        }
    }
}
