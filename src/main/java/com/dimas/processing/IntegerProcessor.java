package com.dimas.processing;

import com.dimas.cli.CommandOptions;
import com.dimas.utils.DataConverter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IntegerProcessor implements DataProcessor<Long> {
    private final CommandOptions commandOptions;
    private final Statistics<Long> statistics;
    private final DataConverter dataConverter;

    @Override
    public void process(String input) {
        long value = (long) dataConverter.convertToType(Long.class, input);

        this.statistics.getValues().add(input);

        if (this.commandOptions.isOptionF()) {
            if (this.statistics.getMax() == null)
                this.statistics.setMax(value);

            this.statistics.setMax(Math.max(this.statistics.getMax(), value));

            if (this.statistics.getMin() == null)
                this.statistics.setMin(value);

            this.statistics.setMin(Math.min(this.statistics.getMin(), value));

            this.statistics.setSum(this.statistics.getSum() + value);
            this.statistics.setAvg(this.statistics.getSum() / this.statistics.getValues().size());
        }
    }

    @Override
    public Statistics<Long> statistics() {
        return this.statistics;
    }
}
