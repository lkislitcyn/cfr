package ru.burytia.cft;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InputFileParametersParser {
    void inputFileParametersParser(InputFileParameters inputFileParameters) throws IOException {
        var dataType = inputFileParameters.getDataType();
        var sortDirection = inputFileParameters.getSortDirection();
        var fileOut = inputFileParameters.getOutFile();
        var mergeSortFile = new MergeSortFile();
        if (inputFileParameters.getInFiles().size() > 1) {
            mergeSortFile.mergeSortFile(sortDirection, dataType, fileOut, inputFileParameters.getInFiles().get(0), inputFileParameters.getInFiles().get(1));
            Path tempFile = Paths.get("temp.txt");
            for (int i = 2; i < (inputFileParameters.getInFiles().size()); i++) {
                Files.move(Paths.get(fileOut), tempFile);
                mergeSortFile.mergeSortFile(sortDirection, dataType, fileOut, "temp.txt", inputFileParameters.getInFiles().get(i));
            }
            if (Files.exists(tempFile)) {
                Files.delete(tempFile);
            }
        } else {
            Files.move(Paths.get(inputFileParameters.getInFiles().get(0)), Paths.get(fileOut));
        }
    }
}
