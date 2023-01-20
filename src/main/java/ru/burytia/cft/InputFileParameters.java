package ru.burytia.cft;

import java.util.List;

public class InputFileParameters {
    private SortDirection sortDirection;
    private DataType dataType;
    private String outFile;
    private List<String> inFiles;

    public InputFileParameters(SortDirection sortDirection, DataType dataType, String outFile, List<String> inFiles) {
        this.sortDirection = sortDirection;
        this.dataType = dataType;
        this.outFile = outFile;
        this.inFiles = inFiles;
    }

    public SortDirection getSortDirection() {
        return sortDirection;
    }

    public DataType getDataType() {
        return dataType;
    }

    public String getOutFile() {
        return outFile;
    }

    public List<String> getInFiles() {
        return inFiles;
    }

    @Override
    public String toString() {
        return "InputData{" +
                "sortDirection=" + sortDirection +
                ", dataType=" + dataType +
                ", outFile='" + outFile + '\'' +
                ", inFiles=" + inFiles +
                '}';
    }
}
