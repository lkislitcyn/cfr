package ru.burytia.cft;



public class Main {
    public static void main(String[] args) {

    var argsParser = new ArgsParser();
    InputFileParametres inputFileParametres = argsParser.parser(args);

        System.out.println(inputFileParametres);




//
//        String fileIn1="/home/lkislitcyn/workdir/intAscending/1.txt";
//        String fileIn2="/home/lkislitcyn/workdir/intAscending/2.txt";
//        String fileOut="/home/lkislitcyn/workdir/intAscending/3.txt";
//        MergeSortFile mergeSortFile = new MergeSortFile();
//        mergeSortFile.margeSortFileAsc(fileIn1,fileIn2,fileOut,  0);
//
//        fileIn1="/home/lkislitcyn/workdir/strAscending/1.txt";
//        fileIn2="/home/lkislitcyn/workdir/strAscending/2.txt";
//        fileOut="/home/lkislitcyn/workdir/strAscending/3.txt";
//
//        mergeSortFile.margeSortFileAsc(fileIn1,fileIn2,fileOut,1);
//
//        fileIn1="/home/lkislitcyn/workdir/intDescending/1.txt";
//        fileIn2="/home/lkislitcyn/workdir/intDescending/2.txt";
//        fileOut="/home/lkislitcyn/workdir/intDescending/3.txt";
//        mergeSortFile.margeSortFileDes(fileIn1,fileIn2,fileOut,0);
//
//        fileIn1="/home/lkislitcyn/workdir/strDescending/1.txt";
//        fileIn2="/home/lkislitcyn/workdir/strDescending/2.txt";
//        fileOut="/home/lkislitcyn/workdir/strDescending/3.txt";
//        mergeSortFile.margeSortFileDes(fileIn1,fileIn2,fileOut,1);


    }
}


