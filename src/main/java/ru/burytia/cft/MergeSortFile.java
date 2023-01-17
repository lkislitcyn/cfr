package ru.burytia.cft;

import java.io.*;

public class MergeSortFile {
    void margeSortIntFile(String fileInWay1, String fileInWay2, String fileOutWay) {

        try (
                BufferedReader file1 = new BufferedReader(new FileReader(fileInWay1));
                BufferedReader file2 = new BufferedReader(new FileReader(fileInWay2));
                BufferedWriter file3 = new BufferedWriter(new FileWriter(fileOutWay))) {
            String intLine1, intLine2;
            intLine1 = file1.readLine();
            intLine2 = file2.readLine();
            while (intLine1 != null && intLine2 != null) {

                if (Integer.parseInt(intLine1) < Integer.parseInt(intLine2)) {
                    file3.write(intLine1 + "\n");
                    intLine1 = file1.readLine();
                } else {
                    file3.write(intLine2 + "\n");
                    intLine2 = file2.readLine();
                }
            }
            mergeSortTail(file1, file2, file3, intLine1, intLine2);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    private void mergeSortTail(BufferedReader file1, BufferedReader file2, BufferedWriter file3, String intLine1, String intLine2) throws IOException {
        while (intLine1 != null || intLine2 != null) {
            if (intLine1 != null) {
                file3.write(intLine1 + "\n");
                intLine1 = file1.readLine();
            }
            if (intLine2 != null) {
                file3.write(intLine2 + "\n");
                intLine2 = file2.readLine();
            }
        }
    }

    void margeSortStrFile(String fileInWay1, String fileInWay2, String fileOutWay) {
        try (BufferedReader file1 = new BufferedReader(new FileReader(fileInWay1));
             BufferedReader file2 = new BufferedReader(new FileReader(fileInWay2));
             BufferedWriter file3 = new BufferedWriter(new FileWriter(fileOutWay))) {
            String intLine1, intLine2;
            intLine1 = file1.readLine();
            intLine2 = file2.readLine();

            while (intLine1 != null && intLine2 != null) {
                if (intLine2.compareTo(intLine1) > 0) {
                    file3.write(intLine1 + "\n");
                    intLine1 = file1.readLine();
                } else {
                    file3.write(intLine2 + "\n");
                    intLine2 = file2.readLine();
                }
            }
            mergeSortTail(file1, file2, file3, intLine1, intLine2);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}

