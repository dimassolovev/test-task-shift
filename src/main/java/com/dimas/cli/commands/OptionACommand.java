package com.dimas.cli.commands;

import com.dimas.cli.CommandOptions;

public class OptionACommand implements Command {
    @Override
    public void execute(CommandOptions commandOptions) {
        commandOptions.setOptionA(true);
    }
}
