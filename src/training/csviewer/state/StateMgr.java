package training.csviewer.state;

import java.util.ArrayList;
import java.util.List;

public class StateMgr
{
    private final NavigationState currNavState;
    private final ValueState currValueState = new ValueState();

    public StateMgr(Integer pageSize, Integer firstPage)
    {
        currNavState = new NavigationState(pageSize, firstPage);
    }

    private void calculateLastPage()
    {
        int size = getValues().size();
        int pageDiv = size / getCurrNavState().getPageSize() - 1;
        if (getCurrNavState().getPageSize() * (pageDiv + 1) < size)
        {
            pageDiv++;
        }
        getCurrNavState().setLastPage(pageDiv);
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

    public NavigationState getCurrNavState()
    {
        return currNavState;
    }

    public ValueState getCurrValueState()
    {
        return currValueState;
    }

    public List<String> getHeader()
    {
        return getCurrValueState().getHeader();
    }

    public Integer getPageSize()
    {
        return getCurrNavState().getPageSize();
    }

    public List<List<String>> getValues()
    {
        return getCurrValueState().getValues();
    }

    public void setHeader(List<String> header)
    {
        getCurrValueState().setHeader(header);
    }

    public void setValues(List<List<String>> values)
    {
        getCurrValueState().setValues(values);
        calculateLastPage();
    }
}
