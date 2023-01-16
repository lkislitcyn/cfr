package ru.burytia.cft;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        try (
                BufferedReader file1 = new BufferedReader(new FileReader("/home/lkislitcyn/workdir/integer/1.txt"));
                BufferedReader file2 = new BufferedReader(new FileReader("/home/lkislitcyn/workdir/integer/2.txt"));
                BufferedWriter file3 = new BufferedWriter(new FileWriter("/home/lkislitcyn/workdir/integer/3.txt"))) {


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


        } catch (IOException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);

        }


    }
}


