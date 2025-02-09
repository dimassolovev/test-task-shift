package com.dimas.cli;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandOptions {
    private String optionO = ""; // путь для результатов: integers.txt, floats.txt, strings.txt
    private String optionP = ""; // префикс имен выходных файлов
    private boolean optionA; // режим добавления в существующие файлы
    private boolean optionS; // краткая статистика - количество элементов записанных в исходящие файлы
    private boolean optionF; // полная статистика - минимальное и максимальное значения, сумма и среднее
    private final List<String> inputFiles = new ArrayList<>(); // Входные файлы с данными
}
