package com.dimas.processing;

import com.dimas.cli.CommandOptions;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StringProcessor implements DataProcessor<String> {
    private final CommandOptions commandOptions;
    private final Statistics<String> statistics;

    @Override
    public void process(String value) {
        this.statistics.getValues().add(value);

        if (this.commandOptions.isOptionF()) {
            this.statistics.setMaxLength(Math.max(value.length(), this.statistics.getMaxLength()));
            this.statistics.setMinLength(Math.min(value.length(), this.statistics.getMinLength()));
        }
    }

    @Override
    public Statistics<String> statistics() {
        return this.statistics;
    }
}
