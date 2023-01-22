package ru.burytia.cft;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class InputFileParametersParser {
    private final static String TEMP_FILE = "temp.txt";

    void inputFileParametersParser(InputFileParameters inputFileParameters) throws IOException {
        var dataType = inputFileParameters.getDataType();
        var sortDirection = inputFileParameters.getSortDirection();
        var fileOut = inputFileParameters.getOutFile();
        var mergeSortFile = new MergeSortFile();
        var tempFile = Paths.get(TEMP_FILE);
        var fileOutPath = Paths.get(fileOut);
        if (inputFileParameters.getInFiles().size() > 1) {
            mergeSortFile.mergeSortFile(sortDirection, dataType, fileOut, inputFileParameters.getInFiles().get(0), inputFileParameters.getInFiles().get(1));

            for (int i = 2; i < (inputFileParameters.getInFiles().size()); i++) {
                Files.move(fileOutPath, tempFile);
                mergeSortFile.mergeSortFile(sortDirection, dataType, fileOut, TEMP_FILE, inputFileParameters.getInFiles().get(i));
                if (Files.exists(tempFile)) {
                    Files.delete(tempFile);
                }
            }
        } else {
            Files.copy(Paths.get(inputFileParameters.getInFiles().get(0)), fileOutPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
