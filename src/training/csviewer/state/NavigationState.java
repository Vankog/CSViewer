package training.csviewer.state;

import java.util.Objects;

public class NavigationState
{
    private Integer currentPage;
    private final Integer firstPage;
    private Integer lastPage;
    private final Integer pSize;

    /**
     * @param firstPage
     * @param currentPage
     * @param lastPage
     */
    public NavigationState(Integer pageSize, Integer firstPage)
    {
        Objects.requireNonNull(firstPage);
        Objects.requireNonNull(pageSize);
        this.firstPage = firstPage;
        setCurrentPage(firstPage);
        this.pSize = pageSize;
    }

    public int getCurrentPage()
    {
        return currentPage;
    }

    public Integer getFirstPage()
    {
        return firstPage;
    }

    public int getLastPage()
    {
        return lastPage;
    }

    public Integer getPageSize()
    {
        return pSize;
    }

    public void setCurrentPage(Integer newCurrentPage)
    {
        currentPage = newCurrentPage;
    }

    public void setLastPage(Integer lastPage)
    {
        this.lastPage = lastPage;
    }
}
