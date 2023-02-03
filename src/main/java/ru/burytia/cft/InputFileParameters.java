package ru.burytia.cft;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputFileParameters that = (InputFileParameters) o;
        return sortDirection == that.sortDirection && dataType == that.dataType && Objects.equals(outFile, that.outFile) && Objects.equals(inFiles, that.inFiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sortDirection, dataType, outFile, inFiles);
    }
}
