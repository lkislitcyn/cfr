package ru.burytia.cft;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeSortFile {

    void mergeSortFile(SortDirection sortDirection, DataType dataType, String outFile, String inFile1, String inFile2) {

        System.out.println(inFile1 + " " + inFile2);
        try (var inReader1 = new BufferedReader(new FileReader(inFile1));
             var inReader2 = new BufferedReader(new FileReader(inFile2));
             var outWriter = new BufferedWriter(new FileWriter(outFile))) {
            var line1 = inReader1.readLine();
            var line2 = inReader2.readLine();
            while ((line1 != null) & (line2 != null)) {
                if (!line1.isEmpty() && !line2.isEmpty()) {
                    if (sortDirection == SortDirection.ASC) {
                        if (compareASC(line1, line2, dataType)) {
                            outWriter.write(line1 + "\n");
                            line1 = inReader1.readLine();
                        } else {
                            outWriter.write(line2 + "\n");
                            line2 = inReader2.readLine();
                        }
                    } else {
                        if (compareDES(line1, line2, dataType)) {
                            outWriter.write(line1 + "\n");
                            line1 = inReader2.readLine();
                        } else {
                            outWriter.write(line2 + "\n");
                            line2 = inReader2.readLine();
                        }
                    }
                } else {
                    if (line1.isEmpty()) {
                        line1 = inReader1.readLine();
                    }
                    if (line2.isEmpty()) {
                        line2 = inReader2.readLine();
                    }
                }
            }
            mergeSortTail(inReader1, outWriter, line1);
            mergeSortTail(inReader2, outWriter, line2);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void mergeSortTail(BufferedReader inReader, BufferedWriter outWriter, String line) throws IOException {
        while (line != null) {
            outWriter.write(line + "\n");
            line = inReader.readLine();

        }
    }

    private boolean compareASC(String line1, String line2, DataType dataType) {
        if (dataType == DataType.INT) {
            return (Integer.parseInt(line1) <= Integer.parseInt(line2));
        } else {
            return (line2.compareTo(line1) > 0);
        }
    }

    private boolean compareDES(String line1, String line2, DataType dataType) {
        if (dataType == DataType.INT) {
            return (Integer.parseInt(line1) >= Integer.parseInt(line2));
        } else {
            return (line1.compareTo(line2) > 0);
        }
    }



}





