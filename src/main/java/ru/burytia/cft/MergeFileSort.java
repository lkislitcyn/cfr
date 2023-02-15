package ru.burytia.cft;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

public class MergeFileSort {
    void mergeFileSort(SortDirection sortDirection, DataType dataType, String outFile, String inFile1, String inFile2) {
        try (var inReader1 = new BufferedReader(new FileReader(inFile1));
             var inReader2 = new BufferedReader(new FileReader(inFile2));
             var outWriter = new BufferedWriter(new FileWriter(outFile))) {
            if (dataType == DataType.INT) {
                mergeSort(intCompare(sortDirection), inReader1, inReader2, outWriter);
            } else {
                mergeSort(strCompare(sortDirection), inReader1, inReader2, outWriter);
            }
        } catch (IOException e) {
           e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.err.println("Symbol in file " + inFile1 + " or " + inFile2);
            //e.printStackTrace();
        }
    }

    void mergeSort(Comparator<String> comparator, BufferedReader in1, BufferedReader in2, BufferedWriter out) throws IOException {
        var line1 = in1.readLine();
        var line2 = in2.readLine();

        while ((line1 != null) && (line2 != null)) {
            if (!line1.isBlank() && !line2.isBlank()) {
                if (comparator.compare(line1, line2) < 0) {
                    out.write(line1);
                    out.newLine();
                    line1 = in1.readLine();
                } else {
                    out.write(line2);
                    out.newLine();
                    line2 = in2.readLine();
                }
            } else if (line1.isBlank()) {
                line1 = in1.readLine();
            } else {
                line2 = in2.readLine();
            }
        }
        mergeSortTail(line1, in1, out);
        mergeSortTail(line2, in2, out);
    }

    Comparator<String> intCompare(SortDirection sortDirection) throws NumberFormatException {
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //try {
                if (sortDirection == SortDirection.ASC) {
                    return Integer.parseInt(o1) - Integer.parseInt(o2);
                } else {
                    return Integer.parseInt(o2) - Integer.parseInt(o1);
                }
//                } catch (NumberFormatException ex) {
//                    System.err.println("Symbol in input file");
//                    ex.printStackTrace();
//                }
//                return 0;
            }
        };
    }


    Comparator<String> strCompare(SortDirection sortDirection) {
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (sortDirection == SortDirection.ASC) {
                    return o1.compareTo(o2);
                } else {
                    return o2.compareTo(o1);
                }
            }
        };
    }

    private void mergeSortTail(String line, BufferedReader in, BufferedWriter out) throws IOException {
        while (line != null) {
            if (!line.isBlank()) {
                out.write(line);
                out.newLine();
            }
            line = in.readLine();
        }
    }
}


