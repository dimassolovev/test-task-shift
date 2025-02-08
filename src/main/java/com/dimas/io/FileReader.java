package com.dimas.io;

import com.dimas.cli.CommandOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public List<String> readFiles(CommandOptions commandOptions) {
        var filePathList = commandOptions.getInputFiles();
        List<String> result = new ArrayList<>();

        for (String filePath : filePathList) {

            try (
                    BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(filePath));
            ) {
                String line;

                while ((line = bufferedReader.readLine()) != null)
                    result.add(line);
            } catch (IOException e) {
                System.out.println("Error reading file: " + filePath);
            }
        }

        return result;
    }
}
