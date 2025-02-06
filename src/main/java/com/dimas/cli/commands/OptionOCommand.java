package com.dimas.cli.commands;

import com.dimas.cli.CommandOptions;
import lombok.RequiredArgsConstructor;

import java.util.Iterator;

@RequiredArgsConstructor
public class OptionOCommand implements Command {
    private final Iterator<String> args;

    @Override
    public void execute(CommandOptions commandOptions) {
        if (this.args.hasNext())
            commandOptions.setOptionO(this.args.next());
    }
}
