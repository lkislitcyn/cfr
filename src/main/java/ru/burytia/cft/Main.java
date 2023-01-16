package ru.burytia.cft;

import java.io.*;
import java.util.Arrays;

import static java.lang.System.arraycopy;

public class Main {
    public static void main(String[] args) {

        int[] mas1 = new int[15], mas2 = new int[20];
        int[] mas3 = new int[mas1.length + mas2.length];

        try (BufferedReader file1 = new BufferedReader(new FileReader("/home/lkislitcyn/workdir/1.txt"));
             BufferedReader file2 = new BufferedReader(new FileReader("/home/lkislitcyn/workdir/2.txt"))) {

            String int_line1, int_line2;
            int i = 0, j = 0, k = 0;
            int_line1 = file1.readLine();
            int_line2 = file2.readLine();
            while (int_line1 != null && int_line2 != null) {

                if (Integer.parseInt(int_line1) < Integer.parseInt(int_line2))
                {
                    mas3[k++]=Integer.parseInt(int_line1);
                    int_line1=file1.readLine();
                } else {
                    mas3[k++]=Integer.parseInt(int_line2);
                    int_line2=file2.readLine();
                }
            }

            while (int_line1 != null )
            {
                mas3[k++]=Integer.parseInt(int_line1);
                int_line1=file1.readLine();
            }

            while (int_line2 != null )
            {
                mas3[k++]=Integer.parseInt(int_line2);
                int_line2=file2.readLine();
            }

//            for(int i=0;(int_line = file1.readLine()) != null;i++)
//
//                mas1[i]=Integer.parseInt(int_line);
//            for(int i=0;(int_line = file2.readLine()) != null;i++)
//                mas2[i]=Integer.parseInt(int_line);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }
//        System.out.println(Arrays.toString(mas1));
//        System.out.println(Arrays.toString(mas2));


//        int i=0, j=0, k=0;
//        while(i < mas1.length && j < mas2.length) {
//            mas3[k++] = mas1[i] < mas2[j] ? mas1[i++] : mas2[j++];
//        }
//        if(i< mas1.length) {
//            arraycopy(mas1, i, mas3, k, mas1.length - i);
//        } else if(j< mas2.length) {
//            arraycopy(mas2, j, mas3, k, mas2.length - j);
//        }
//
        System.out.println(Arrays.toString(mas3));

    }
}
