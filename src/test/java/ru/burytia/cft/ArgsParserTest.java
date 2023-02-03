package ru.burytia.cft;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ArgsParserTest {
    @Test
    public void argsParserTest() {
        InputFileParameters inputFileParameters = new InputFileParameters(SortDirection.ASC, DataType.INT, "out.txt", new ArrayList<>(Arrays.asList("1.txt", "2.txt")));
        ArgsParser argsParser = new ArgsParser();
        String[] strings = {"-a", "-i", "out.txt", "1.txt", "2.txt"};
//        System.out.println(inputFileParameters);
//        System.out.println(argsParser.parser(strings));
        Assert.assertEquals(inputFileParameters, argsParser.parser(strings));
    }
}
