package com.dimas;

import com.dimas.cli.CLIParser;
import com.dimas.cli.CommandExecutor;
import com.dimas.io.FileReader;

public class Main {
    public static void main(String[] args) {
        var parser = new CLIParser(args);
        var fileReader = new FileReader();
        var options = parser.parse(args);
        var commandExecutor = new CommandExecutor(options);
        commandExecutor.execute();
        var data = fileReader.readFiles(options);
    }
}
