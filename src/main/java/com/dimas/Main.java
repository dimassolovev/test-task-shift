package com.dimas;

import com.dimas.cli.*;

public class Main {
    public static void main(String[] args) {
        var parser = new CLIParser(args);
        var options = parser.parse(args);
        var executor = new CommandExecutor(options);
        executor.execute();
    }
}
