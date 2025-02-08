package com.dimas.processing;

import com.dimas.cli.CommandOptions;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StringProcessor implements DataProcessor<String> {
    private final CommandOptions commandOptions;

    @Override
    public void process(Statistics<String> statistics, String input) {
        statistics.getValues().add(input);

        if (this.commandOptions.isOptionF()) {
            statistics.setMaxLength(Math.max(input.length(), statistics.getMaxLength()));
            statistics.setMinLength(Math.min(input.length(), statistics.getMinLength()));
        }
    }
}
