package com.dimas.cli.commands;

import com.dimas.cli.CommandOptions;

public class OptionSCommand implements Command {

    @Override
    public void execute(CommandOptions commandOptions) {
        commandOptions.setOptionS(true);
    }
}
