package training.csviewer.IO;

import java.util.List;

public interface Printer
{

    void printSeparatorLine(List<Integer> maxWidths);

    void print(List<List<String>> rows, List<Integer> maxWidths, int currentPage, Integer pageSize);

    void print(List<String> row, List<Integer> maxWidths);

    void print(String output);

    void print(String output, int value);

}