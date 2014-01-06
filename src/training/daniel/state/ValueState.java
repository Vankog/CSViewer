package training.daniel.state;

import java.util.List;

public class ValueState
{
    private List<String> header;
    private List<List<String>> values;

    public ValueState()
    {
    }

    public List<String> getHeader()
    {
        return header;
    }

    public void setHeader(List<String> header)
    {
        this.header = header;
    }

    public List<List<String>> getValues()
    {
        return values;
    }

    public void setValues(List<List<String>> values)
    {
        this.values = values;
    }
}