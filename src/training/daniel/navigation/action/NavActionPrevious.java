/**
 * 
 */
package training.daniel.navigation.action;


/**
 * @author dmoench
 * 
 */
public class NavActionPrevious implements NavAction
{

    /*
     * (non-Javadoc)
     * @see training.daniel.navigation.action.NavAction#getPage(java.lang.Integer, java.lang.Integer, java.lang.Integer)
     */
    @Override
    public Integer getPage(Integer firstPage, Integer currentPage, Integer lastPage)
    {
        Integer newPage = currentPage;
        newPage--;
        if (newPage < firstPage)
        {
            newPage = firstPage;
        }
        return newPage;
    }

}
