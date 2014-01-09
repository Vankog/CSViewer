/**
 * 
 */
package training.csviewer.navigation.action;

/**
 * @author dmoench
 * 
 */
public class NavActionFirst implements NavAction
{

    @Override
    public Integer getPage(Integer firstPage, Integer currentPage, Integer lastPage)
    {
        return firstPage;
    }

}
