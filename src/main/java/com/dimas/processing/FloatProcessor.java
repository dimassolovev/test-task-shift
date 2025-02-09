package com.dimas.processing;

import com.dimas.cli.CommandOptions;
import com.dimas.utils.DataConverter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FloatProcessor implements DataProcessor<Double> {
    private final CommandOptions commandOptions;
    private final Statistics<Double> statistics;
    private final DataConverter dataConverter;

    @Override
    public void process(String input) {
        double value = (double) dataConverter.convertToType(Double.class, input);

        this.statistics.getValues().add(input);

        if (this.commandOptions.isOptionF()) {
            if (this.statistics.getMax() == null)
                this.statistics.setMax(value);

            this.statistics.setMax(Math.max(statistics.getMax(), value));

            if (this.statistics.getMin() == null)
                this.statistics.setMin(value);

            this.statistics.setMin(Math.min(this.statistics.getMin(), value));

            this.statistics.setSum(this.statistics.getSum() + value);
            this.statistics.setAvg(this.statistics.getSum() / this.statistics.getValues().size());
        }
    }

    @Override
    public Statistics<Double> statistics() {
        return this.statistics;
    }
}
