package ru.burytia.cft;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.arraycopy;

public class Main {
    public static void main(String[] args) {


        ArrayList<Integer> arrayList = new ArrayList<>();

        try (BufferedReader file1 = new BufferedReader(new FileReader("/home/lkislitcyn/workdir/1.txt"));
             BufferedReader file2 = new BufferedReader(new FileReader("/home/lkislitcyn/workdir/2.txt"));
             BufferedWriter file3 = new BufferedWriter(new FileWriter("/home/lkislitcyn/workdir/3.txt"))) {

            String int_line1, int_line2;

            int_line1 = file1.readLine();
            int_line2 = file2.readLine();
            while (int_line1 != null && int_line2 != null) {

                if (Integer.parseInt(int_line1) < Integer.parseInt(int_line2))
                {
                    arrayList.add(Integer.parseInt(int_line1));
                    file3.write(int_line1+"\n");
                    int_line1=file1.readLine();
                } else {
                    arrayList.add(Integer.parseInt(int_line2));
                    file3.write(int_line2+"\n");
                    int_line2=file2.readLine();
                }
            }

            while (int_line1 != null )
            {
                arrayList.add(Integer.parseInt(int_line1));
                file3.write(int_line1+"\n");
                int_line1=file1.readLine();
            }

            while (int_line2 != null )
            {
                arrayList.add(Integer.parseInt(int_line2));
                file3.write(int_line2+"\n");
                int_line2=file2.readLine();
            }


        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }

        System.out.println(arrayList);

    }
}
