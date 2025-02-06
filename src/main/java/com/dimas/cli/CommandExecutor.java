package com.dimas.cli;

public class CommandExecutor {
    private final CommandOptions options;

    public CommandExecutor(CommandOptions options) {
        this.options = options;
    }

    public void execute() {
        System.out.println("Options:");
        System.out.println(" -o (output path): " + options.getOptionO());
        System.out.println(" -p (prefix): " + options.getOptionP());
        System.out.println(" -a (append mode): " + options.isOptionA());
        System.out.println(" -s (short stats): " + options.isOptionS());
        System.out.println(" -f (full stats): " + options.isOptionF());
        System.out.println(" Input Files: " + options.getInputFiles());
    }
}
