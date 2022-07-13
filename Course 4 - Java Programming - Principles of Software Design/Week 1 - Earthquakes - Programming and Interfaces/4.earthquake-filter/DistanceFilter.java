/**
 * Filter by Distance
 * 
 * @author Ginny Dang
 * @version July 13rd, 2022
 */

public class DistanceFilter implements Filter{
    private Location loc;
    private double distMax;
    
    public DistanceFilter(Location location, double max) {
        loc = location;
        distMax = max;
    }
    
    public boolean satisfies(QuakeEntry qe) {
        return (loc.distanceTo(qe.getLocation()) < distMax);
    }
    
    public String getName() {
        return "Distance";
    }
}