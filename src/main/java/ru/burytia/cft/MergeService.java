package ru.burytia.cft;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MergeService {
    private static final String TEMP_FILE = "temp.txt";

    void mergeService(InputFileParameters inputFileParameters) throws IOException {
        var dataType = inputFileParameters.getDataType();
        var sortDirection = inputFileParameters.getSortDirection();
        var fileOut = inputFileParameters.getOutFile();
        var tempFile = Paths.get(TEMP_FILE);
        var fileOutPath = Paths.get(fileOut);
        var mergeFileSort = new MergeFileSort();
        if (inputFileParameters.getInFiles().size() > 1) {
            mergeFileSort.mergeFileSort(sortDirection, dataType, fileOut, inputFileParameters.getInFiles().get(0), inputFileParameters.getInFiles().get(1));
            for (int i = 2; i < (inputFileParameters.getInFiles().size()); i++) {
                Files.move(fileOutPath, tempFile);
                mergeFileSort.mergeFileSort(sortDirection, dataType, fileOut, TEMP_FILE, inputFileParameters.getInFiles().get(i));
                if (Files.exists(tempFile)) {
                    Files.delete(tempFile);
                }
            }
        } else {
            Files.copy(Paths.get(inputFileParameters.getInFiles().get(0)), fileOutPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
