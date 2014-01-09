package training.csviewer.navigation.action;

public class NavActionExit implements NavAction
{

    @Override
    public Integer getPage(Integer firstPage, Integer currentPage, Integer lastPage)
    {
        return firstPage - 1;
    }

}
