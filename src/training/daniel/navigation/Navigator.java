/**
 * 
 */
package training.daniel.navigation;

import training.daniel.IO.InputReader;

/**
 * @author dmoench
 * 
 */
public interface Navigator
{
    Integer getNewPage(InputReader inReader, Integer firstPage, Integer currentPage, Integer lastPage);

}