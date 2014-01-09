package training.csviewer.navigation.action;

public class NavActionLast implements NavAction
{

    @Override
    public Integer getPage(Integer firstPage, Integer currentPage, Integer lastPage)
    {
        return lastPage;
    }

}
