package ru.burytia.cft;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var argsParser = new ArgsParser();
        InputFileParameters inputFileParameters = argsParser.parser(args);
        InputFileParametersParser inputFileParametersParser = new InputFileParametersParser();
        inputFileParametersParser.inputFileParametersParser(inputFileParameters);
        System.out.println(inputFileParameters);
    }
}


