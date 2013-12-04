package training.daniel;

import java.io.IOException;

public class NavigationState
{
    private int currentPage = 0;
    private Integer lastPage;
    
    public void setCurrentPage(int newCurrentPage)
    {
        this.currentPage = newCurrentPage;
    }

    public int getCurrentPage()
    {
        return this.currentPage;
    }

    public int getLastPage()
    {
        return this.lastPage;
    }

    public void setLastPage(int lastPage)
    {
        this.lastPage = lastPage;
    }
    
    public int getNextPage(char c) throws IOException
    {
        String cStr = String.valueOf(c).toUpperCase();
        int currentPage = getCurrentPage();
        int lastPage = getLastPage();
        switch(cStr)
        {
            case "N":
                currentPage++;
                if (currentPage > lastPage)
                {
                    currentPage = lastPage;
                }
                break;
            case "P":
                currentPage--;
                if (currentPage < 0)
                {
                    currentPage = 0;
                }
                break;
            case "X":
                currentPage = -1;
                break;
            case "F":
                currentPage = 0;
                break;
            case "L":
                currentPage = lastPage;
                break;
        }
        return currentPage;
    }
}
