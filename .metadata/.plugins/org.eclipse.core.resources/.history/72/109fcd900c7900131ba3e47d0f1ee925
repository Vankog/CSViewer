package training.daniel.navigation.action;

import java.io.IOException;
import java.util.Objects;

import training.daniel.IO.InputReader;

public class NavActionGoTo implements NavAction
{
    private final InputReader inReader;
    private final String prompt;

    public NavActionGoTo(String promptGoTo, InputReader inReader)
    {
        Objects.requireNonNull(promptGoTo);
        Objects.requireNonNull(inReader);
        prompt = promptGoTo;
        this.inReader = inReader;
    }

    @Override
    public Integer getPage(Integer firstPage, Integer currentPage, Integer lastPage)
    {
        Integer newPage;
        try
        {
            String input = inReader.readLine(prompt);
            newPage = Integer.valueOf(input);
        }
        catch(NumberFormatException | IOException e)
        {
            // just do nothing
            return currentPage;
        }

        if (newPage < firstPage)
        {
            newPage = firstPage;
        }
        else if (newPage > lastPage)
        {
            newPage = lastPage;
        }
        return newPage;
    }
}
