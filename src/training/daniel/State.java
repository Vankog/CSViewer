package training.daniel;

import java.util.ArrayList;
import java.util.List;

public class State
{
    private final Integer pageSize;
    private NavigationState currNavState; 
    private List<String> header;
    private List<List<String>> values;

    public State(Integer pSize)
    {
        pageSize = pSize;
        currNavState = new NavigationState();
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public NavigationState getCurrNavState()
    {
        return currNavState;
    }

    public void setCurrNavState(NavigationState currNavState)
    {
        this.currNavState = currNavState;
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
        setLastPage();
    }

    private void setLastPage()
    {
        int size = getValues().size();
        int pageDiv = size / getPageSize() - 1;
        if (getPageSize() * (pageDiv+1) < size) 
        {
            pageDiv++;
        }
        currNavState.setLastPage(pageDiv);
    }


    public List<Integer> getCurrentMaxWidths()
    {
        List<String> header = getHeader();
        List<Integer> maxWidths = new ArrayList<>(header.size());
        for (int i = 0; i < header.size(); i++)
        {
            maxWidths.add(header.get(i).length());
        }
        List<List<String>> values = getValues();
        for (List<String> row : values)
        {
            for (int i = 0; i < row.size(); i++)
            {
                maxWidths.set(i, Math.max(row.get(i).length(), maxWidths.get(i)));
            }
        }
        return maxWidths;
    }
}
