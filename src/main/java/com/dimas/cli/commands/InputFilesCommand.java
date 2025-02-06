package com.dimas.cli.commands;

import com.dimas.cli.CommandOptions;
import lombok.RequiredArgsConstructor;

import java.util.Iterator;

@RequiredArgsConstructor
public class InputFilesCommand implements Command {
    private final Iterator<String> args;
    private final String firstArg;

    @Override
    public void execute(CommandOptions commandOptions) {
        commandOptions.getInputFiles().add(this.firstArg);

        while (this.args.hasNext()) {
            commandOptions.getInputFiles().add(this.args.next());
        }
    }
}
