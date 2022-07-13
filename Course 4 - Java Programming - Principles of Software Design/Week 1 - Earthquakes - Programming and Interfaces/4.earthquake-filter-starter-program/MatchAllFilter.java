/**
 * Store and apply many filters
 * 
 * @author Ginny Dang
 * @version July 13rd, 2022
 */

import java.util.*;

public class MatchAllFilter implements Filter{
    private ArrayList<Filter> filters;
    
    public MatchAllFilter() {
        filters = new ArrayList<Filter>();
    }
    
    public void addFilter(Filter f) {
        filters.add(f);
    }
    
    public boolean satisfies(QuakeEntry qe) {
        for (Filter f : filters) {
            if (!f.satisfies(qe)) {
                return false;
            }
        }
        return true;
    }
    
    public String getName() {
        StringBuilder usedFilters = new StringBuilder();
        for (Filter f : filters) {
            usedFilters.append(f.getName() + " ");
        }
        return usedFilters.toString();
    }
}