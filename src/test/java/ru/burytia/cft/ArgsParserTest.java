package ru.burytia.cft;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ArgsParserTest {
    @Test
    public void argsParserTestASC_INT() {
        InputFileParameters inputFileParameters = new InputFileParameters(SortDirection.ASC, DataType.INT, "out.txt", new ArrayList<>(Arrays.asList("1.txt", "2.txt")));
        ArgsParser argsParser = new ArgsParser();
        String[] strings = {"-a", "-i", "out.txt", "1.txt", "2.txt"};
        Assert.assertEquals(inputFileParameters, argsParser.parser(strings));
    }

    @Test
    public void argsParserTestDESC_STRING()
    {
        InputFileParameters inputFileParameters = new InputFileParameters(SortDirection.DESC, DataType.STRING, "out.txt", new ArrayList<>(Arrays.asList("1.txt", "2.txt")));
        ArgsParser argsParser = new ArgsParser();
        String[] strings = {"-d", "-s", "out.txt", "1.txt", "2.txt"};
        Assert.assertEquals(inputFileParameters, argsParser.parser(strings));
    }
}
