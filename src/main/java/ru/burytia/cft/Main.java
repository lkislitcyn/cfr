package ru.burytia.cft;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        var argsParser = new ArgsParser();
        InputFileParameters inputFileParameters = argsParser.parser(args);
        MergeService mergeService = new MergeService();
        try {
            mergeService.mergeService(inputFileParameters);
        }
        catch (IOException e)
        {
            e.getMessage();
        }


        System.out.println(inputFileParameters);
    }
}


