/**
 * 
 */
package training.csviewer.navigation.action;


/**
 * @author dmoench
 * 
 */
public interface NavAction
{
    Integer getPage(Integer firstPage, Integer currentPage, Integer lastPage);

}
