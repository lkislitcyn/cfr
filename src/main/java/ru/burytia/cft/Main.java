package ru.burytia.cft;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        try (
                BufferedReader file1 = new BufferedReader(new FileReader("/home/lkislitcyn/workdir/1.txt"));
                BufferedReader file2 = new BufferedReader(new FileReader("/home/lkislitcyn/workdir/2.txt"));
                BufferedWriter file3 = new BufferedWriter(new FileWriter("/home/lkislitcyn/workdir/3.txt"))) {

            String intLine1, intLine2;

            intLine1 = file1.readLine();
            intLine2 = file2.readLine();
            while (intLine1 != null && intLine2 != null) {

                if (Integer.parseInt(intLine1) < Integer.parseInt(intLine2)) {
                    arrayList.add(Integer.parseInt(intLine1));
                    file3.write(intLine1 + "\n");
                    intLine1 = file1.readLine();
                } else {
                    arrayList.add(Integer.parseInt(intLine2));
                    file3.write(intLine2 + "\n");
                    intLine2 = file2.readLine();
                }
            }

            while (intLine1 != null) {
                arrayList.add(Integer.parseInt(intLine1));
                file3.write(intLine1 + "\n");
                intLine1 = file1.readLine();
            }

            while (intLine2 != null) {
                arrayList.add(Integer.parseInt(intLine2));
                file3.write(intLine2 + "\n");
                intLine2 = file2.readLine();
            }


        } catch (
                FileNotFoundException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }

        System.out.println(arrayList);

    }
}


