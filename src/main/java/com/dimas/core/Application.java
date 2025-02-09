package com.dimas.core;

import com.dimas.cli.CLIParser;
import com.dimas.io.FileReader;
import com.dimas.io.FileWriter;
import com.dimas.processing.DataProcessorFactory;
import com.dimas.utils.StatisticsOutput;
import com.dimas.utils.TypeParser;

public class Application {
    private final CLIParser cliParser;
    private final FileReader fileReader;
    private final FileWriter fileWriter;
    private final TypeParser typeParser;
    private final StatisticsOutput statisticsOutput;

    public Application(String[] args) {
        this.cliParser = new CLIParser(args);
        this.fileReader = new FileReader();
        this.typeParser = new TypeParser();
        this.fileWriter = new FileWriter();
        this.statisticsOutput = new StatisticsOutput();
    }

    public void run() {
        var commandOptions = this.cliParser.parse();
        var dataProcessorFactory = new DataProcessorFactory(commandOptions);
        var userData = this.fileReader.readFiles(commandOptions);

        for (var line : userData) {
            var type = this.typeParser.parseType(line);
            var dataProcessor = dataProcessorFactory.getProcessor(type);

            dataProcessor.process(line);
        }

        for (var dataProcessor: dataProcessorFactory.getProcessors().values()) {
            var statistics = dataProcessor.statistics();

            var filePath = String.format("%s%s", commandOptions.getOptionP(), statistics.getFileName());
            if (!commandOptions.getOptionO().isBlank())
                filePath = String.format("%s/%s", commandOptions.getOptionO(), filePath);

            this.fileWriter.writeDataToFile(filePath, statistics.getValues(), commandOptions);

            System.out.println(filePath);
            statisticsOutput.print(statistics, commandOptions);

            // Посмотреть возможные баги и написать пару unit тестов.
        }
    }
}
