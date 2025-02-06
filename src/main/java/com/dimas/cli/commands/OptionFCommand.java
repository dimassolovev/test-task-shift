package com.dimas.cli.commands;

import com.dimas.cli.CommandOptions;

public class OptionFCommand implements Command {
    @Override
    public void execute(CommandOptions commandOptions) {commandOptions.setOptionF(true);}
}
