package ru.burytia.cft;
public class Main {
    public static void main(String[] args) {

    var argsParser = new ArgsParser();
    InputFileParameters inputFileParameters = argsParser.parser(args);

        System.out.println(inputFileParameters);


    }
}


