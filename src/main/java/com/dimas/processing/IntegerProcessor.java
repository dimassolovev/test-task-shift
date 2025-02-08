package com.dimas.processing;

import com.dimas.cli.CommandOptions;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IntegerProcessor implements DataProcessor<Long> {
    private final CommandOptions commandOptions;

    @Override
    public void process(Statistics<Long> statistics, String input) {
        try {
            var value = Long.parseLong(input);
            statistics.getValues().add(value);

            if (this.commandOptions.isOptionF()) {
                if (statistics.getMax() == null)
                    statistics.setMax(value);

                statistics.setMax(Math.max(statistics.getMax(), value));

                if (statistics.getMin() == null)
                    statistics.setMin(value);

                statistics.setMin(Math.min(statistics.getMin(), value));

                statistics.setSum(statistics.getSum() + value);
                statistics.setAvg(statistics.getSum() / statistics.getValues().size());
            }
        } catch (NumberFormatException ignored) {
        }
    }
}
