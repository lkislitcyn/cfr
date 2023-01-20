package ru.burytia.cft;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortFile {

    void mergeSortFile(SortDirection sortDirection, DataType dataType, String outFile, String inFile1, String inFile2) {
        try (var inReader1 = new BufferedReader(new FileReader(inFile1));
             var inReader2 = new BufferedReader(new FileReader(inFile2));
             var outWriter = new BufferedWriter(new FileWriter(outFile));) {
            String line1, line2;
            line1 = inReader1.readLine();
            line2 = inReader2.readLine();
            while ((line1 != null) && (line2 != null)) {
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
                        line1 = inReader1.readLine();
                    } else {
                        outWriter.write(line2 + "\n");
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
            return (Integer.parseInt(line1) <= Integer.parseInt(line2));
        } else {
            return (line1.compareTo(line2) > 0);
        }
    }
}

class MainTest {
    public static void main(String[] args) {
        String filein1 = "/home/lkislitcyn/workdir/strDescending/1.txt";
        String filein2 = "/home/lkislitcyn/workdir/strDescending/2.txt";
        String fileOut = "/home/lkislitcyn/workdir/strDescending/3.txt";

        MergeSortFile mergeSortFile = new MergeSortFile();
        mergeSortFile.mergeSortFile(SortDirection.DESC, DataType.STRING, fileOut, filein1,filein2);
    }
}


