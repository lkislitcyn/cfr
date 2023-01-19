package ru.burytia.cft;

import java.util.ArrayList;

public class ArgsParser {



    InputFileParametres parser(String[] args) {
        SortDirection sortDirection = SortDirection.ASC;
        DataType dataType = null;
        String outFile = null;
        ArrayList<String> inFiles = new ArrayList<>();

        for (String i : args) {
            if (i.equals("-i")) {
                dataType = DataType.INT;
            } else if (i.equals("-s")) {
                dataType = DataType.STRING;
            } else if (i.equals("-d")) {
                sortDirection = SortDirection.DESC;
            } else if (i.equals("-a")) {
                sortDirection = SortDirection.ASC;
            } else if ((outFile == null) && !i.startsWith("-")) {
                outFile = i;
            } else if (!i.startsWith("-")) {
                inFiles.add(i);
            } else System.out.println("error!");
        }

        return new InputFileParametres(sortDirection, dataType, outFile, inFiles);
    }


}


