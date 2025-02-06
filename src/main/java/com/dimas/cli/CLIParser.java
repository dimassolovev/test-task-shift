package com.dimas.cli;

import com.dimas.cli.commands.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CLIParser implements CommandLineParser {
    private final Map<String, Command> commands = new HashMap<>();
    private final Iterator<String> argsIterator;

    public CLIParser(String[] args) {
        this.argsIterator = Arrays.asList(args).iterator();

        this.commands.put("-o", new OptionOCommand(this.argsIterator));
        this.commands.put("-p", new OptionPCommand(this.argsIterator));
        this.commands.put("-a", new OptionACommand());
        this.commands.put("-s", new OptionSCommand());
        this.commands.put("-f", new OptionFCommand());
    }

    @Override
    public CommandOptions parse(String[] args) {
        var commandOptions = new CommandOptions();

        while (this.argsIterator.hasNext()) {
            var arg = this.argsIterator.next();
            var command = this.commands.getOrDefault(arg, new InputFilesCommand(this.argsIterator, arg));
            command.execute(commandOptions);
        }

        return commandOptions;
    }
}
