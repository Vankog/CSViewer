/**
 * 
 */
package training.csviewer.navigation;

import training.csviewer.IO.InputReader;

/**
 * @author dmoench
 * 
 */
public interface Navigator
{
    Integer getNewPage(InputReader inReader, Integer firstPage, Integer currentPage, Integer lastPage);

}
