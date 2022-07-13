/**
 * Filter by Depth
 * 
 * @author Ginny Dang
 * @version July 13rd, 2022
 */

public class DepthFilter implements Filter {
    private double depthMin;
    private double depthMax;
    
    public DepthFilter(double min, double max) {
        depthMin = min;
        depthMax = max;
    }
    
    public boolean satisfies(QuakeEntry qe) {
        return (qe.getDepth() >= depthMin && qe.getDepth() <= depthMax);
    }
    
    public String getName() {
        return "Depth";
    }
}
