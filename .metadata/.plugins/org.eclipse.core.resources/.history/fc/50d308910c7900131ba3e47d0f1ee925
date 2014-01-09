/**
 * 
 */
package training.daniel.navigation.action;


/**
 * @author dmoench
 * 
 */
public class NavActionNext implements NavAction
{
    @Override
    public Integer getPage(Integer firstPage, Integer currentPage, Integer lastPage)
    {
        Integer newPage = currentPage;
        newPage++;
        if (newPage > lastPage)
        {
            newPage = lastPage;
        }
        return newPage;
    }

}
