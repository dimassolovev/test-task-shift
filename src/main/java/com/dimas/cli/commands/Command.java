package com.dimas.cli.commands;

import com.dimas.cli.CommandOptions;

public interface Command {
    void execute(CommandOptions commandOptions);
}
