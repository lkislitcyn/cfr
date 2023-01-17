package ru.burytia.cft;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MergeSortFile {


    void margeSortFileAsc(String fileInWay1, String fileInWay2, String fileOutWay, int type) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        try (
                BufferedReader file1 = new BufferedReader(new FileReader(fileInWay1));
                BufferedReader file2 = new BufferedReader(new FileReader(fileInWay2));
                BufferedWriter file3 = new BufferedWriter(new FileWriter(fileOutWay))) {
            String intLine1, intLine2;
            intLine1 = file1.readLine();
            intLine2 = file2.readLine();

            switch (type) {
                case 0: {
                    while ((intLine1 != null) && (intLine2 != null))
                        if (Integer.parseInt(intLine1) <= Integer.parseInt(intLine2)) {
                            arrayList.add(Integer.parseInt(intLine1));
                            file3.write(intLine1 + "\n");
                            intLine1 = file1.readLine();
                        } else {
                            arrayList.add(Integer.parseInt(intLine2));
                            file3.write(intLine2 + "\n");
                            intLine2 = file2.readLine();
                        }
                    while (intLine1 != null || intLine2 != null) {
                        if (intLine1 != null) {
                            arrayList.add(Integer.parseInt(intLine1));
                            file3.write(intLine1 + "\n");
                            intLine1 = file1.readLine();
                        }
                        if (intLine2 != null) {
                            arrayList.add(Integer.parseInt(intLine2));
                            file3.write(intLine2 + "\n");
                            intLine2 = file2.readLine();
                        }
                    }
                }
                case 1:
                    while ((intLine1 != null) && (intLine2 != null))
                        if (intLine2.compareTo(intLine1) > 0) {
                            file3.write(intLine1 + "\n");
                            intLine1 = file1.readLine();
                        } else {
                            file3.write(intLine2 + "\n");
                            intLine2 = file2.readLine();
                        }
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

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(arrayList);
    }

    void margeSortFileDes(String fileInWay1, String fileInWay2, String fileOutWay, int type) {

        try (
                BufferedReader file1 = new BufferedReader(new FileReader(fileInWay1));
                BufferedReader file2 = new BufferedReader(new FileReader(fileInWay2));
                BufferedWriter file3 = new BufferedWriter(new FileWriter(fileOutWay))) {
            String intLine1, intLine2;
            intLine1 = file1.readLine();
            intLine2 = file2.readLine();
            switch (type) {
                case 0:
                    while ((intLine1 != null) && (intLine2 != null))
                        if (Integer.parseInt(intLine1) >= Integer.parseInt(intLine2)) {
                            file3.write(intLine1 + "\n");
                            intLine1 = file1.readLine();
                        } else {
                            file3.write(intLine2 + "\n");
                            intLine2 = file2.readLine();
                        }
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

                case 1:
                    while ((intLine1 != null) && (intLine2 != null))
                        if (intLine1.compareTo(intLine2) > 0) {
                            file3.write(intLine1 + "\n");
                            intLine1 = file1.readLine();
                        } else {
                            file3.write(intLine2 + "\n");
                            intLine2 = file2.readLine();
                        }
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//        private void mergeSortTail(BufferedReader file1, BufferedReader file2, BufferedWriter file3, String intLine1, String intLine2) throws IOException {
//            while (intLine1 != null || intLine2 != null) {
//            if (intLine1 != null) {
//                arrayList.add(Integer.parseInt(intLine1));
//                file3.write(intLine1 + "\n");
//                intLine1 = file1.readLine();
//            }
//            if (intLine2 != null) {
//                arrayList.add(Integer.parseInt(intLine2));
//                file3.write(intLine2 + "\n");
//                intLine2 = file2.readLine();
//            }
//        }
//    }
}

