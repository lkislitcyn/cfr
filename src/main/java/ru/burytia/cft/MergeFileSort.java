package ru.burytia.cft;

import java.io.*;
import java.util.Comparator;

public class MergeFileSort {
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

    Comparator<String> intCompare(SortDirection sortDirection) {

        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (sortDirection == SortDirection.ASC) {
                    return Integer.parseInt(o1) - Integer.parseInt(o2);
                } else {
                    return Integer.parseInt(o2) - Integer.parseInt(o1);
                }
            }
        };
    }
    Comparator<String> strCompare(SortDirection sortDirection)
    {
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

    private void mergeSortTail(String line, BufferedReader in1, BufferedWriter out) throws IOException {
        while (line != null) {
            if (!line.isBlank()) {
                out.write(line);
                out.newLine();
            }
            line = in1.readLine();
        }
    }

}


//class MergeMain {
//    public static void main(String[] args) {
//
//    }
//}
////        MergeFileSort mergeFileSort = new MergeFileSort();
//
////
//        try (BufferedReader in1 = new BufferedReader(new FileReader("strASC/1.txt"));
//             BufferedReader in2 = new BufferedReader(new FileReader("strASC/2.txt"));
//             BufferedWriter out = new BufferedWriter(new FileWriter("strASC/out.txt"))
//        ) {
//            mergeFileSort.mergeSort(mergeFileSort.stringMethod(SortDirection.ASC), in1, in2, out);
//          } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        try (BufferedReader in1 = new BufferedReader(new FileReader("intASC/1.txt"));
//             BufferedReader in2 = new BufferedReader(new FileReader("intASC/2.txt"));
//             BufferedWriter out = new BufferedWriter(new PrintWriter("intASC/out.txt"))
//        ) {
//            mergeFileSort.mergeSort(mergeFileSort.intMethod(SortDirection.ASC), in1, in2, out);
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        try (BufferedReader in1 = new BufferedReader(new FileReader("strDESC/1.txt"));
//             BufferedReader in2 = new BufferedReader(new FileReader("strDESC/2.txt"));
//             BufferedWriter out = new BufferedWriter(new FileWriter("strDESC/out.txt"))
//        ) {
//            mergeFileSort.mergeSort(mergeFileSort.stringMethod(SortDirection.DESC), in1, in2, out);
//
//
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        try (BufferedReader in1 = new BufferedReader(new FileReader("intDESC/1.txt"));
//             BufferedReader in2 = new BufferedReader(new FileReader("intDESC/2.txt"));
//             BufferedWriter out = new BufferedWriter(new FileWriter("intDESC/out.txt"))
//        ) {
//            mergeFileSort.mergeSort(mergeFileSort.intMethod(SortDirection.DESC), in1, in2, out);
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}