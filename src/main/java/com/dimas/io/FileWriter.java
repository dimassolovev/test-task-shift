package com.dimas.io;

import com.dimas.cli.CommandOptions;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class FileWriter {
    public void writeDataToFile(String filePath, List<String> data, CommandOptions commandOptions) {
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(filePath, commandOptions.isOptionA()))
        ) {
            for (String line : data) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + filePath);
        }
    }
}
