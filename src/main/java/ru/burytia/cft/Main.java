package ru.burytia.cft;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var argsParser = new ArgsParser();
        InputFileParameters inputFileParameters = argsParser.parser(args);
        MergeService mergeService = new MergeService();
        mergeService.mergeService(inputFileParameters);
        System.out.println(inputFileParameters);
    }
}


