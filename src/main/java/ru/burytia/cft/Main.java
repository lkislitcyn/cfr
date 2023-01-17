package ru.burytia.cft;


public class Main {
    public static void main(String[] args) {
        String fileIn1="/home/lkislitcyn/workdir/integer/1.txt";
        String fileIn2="/home/lkislitcyn/workdir/integer/2.txt";
        String fileOut="/home/lkislitcyn/workdir/integer/3.txt";
        MergeSortFile mergeSortFile = new MergeSortFile();
        mergeSortFile.margeSortIntFile(fileIn1,fileIn2,fileOut);

        fileIn1="/home/lkislitcyn/workdir/string/1.txt";
        fileIn2="/home/lkislitcyn/workdir/string/2.txt";
        fileOut="/home/lkislitcyn/workdir/string/3.txt";

        mergeSortFile.margeSortStrFile(fileIn1,fileIn2,fileOut);


    }
}


