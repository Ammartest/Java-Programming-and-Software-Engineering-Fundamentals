import java.util.*;

public class LargestQuakes {
    public void findLargestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for " + list.size() + " quakes");
        /*
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
        */
        int largestIndex = indexOfLargest(list);
        //System.out.println("location of the largest magnitude earthquake: " + largestIndex);
        //System.out.println("earthquake with the largest magnitude: " + list.get(largestIndex));
       
        System.out.println("earthquakes of largest magnitude:");
        ArrayList<QuakeEntry> largest = getLargest(list, 50);
        for (QuakeEntry qe : largest) {
            System.out.println(qe);
        }
    }
    
    public int indexOfLargest(ArrayList<QuakeEntry> data) {
        int maxMagIndex = 0;
        double maxMag = data.get(0).getMagnitude();
        for (int i = 0; i < data.size(); i++) {
            double currMag = data.get(i).getMagnitude();
            if (currMag > maxMag) {
                maxMag = currMag;
                maxMagIndex = i;
            }
        }
        return maxMagIndex;
    }
    
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany) {
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        for (int i = 0; i < howMany; i++) {
            if (copy.size() > 0) {
                int maxIndex = indexOfLargest(copy);
                ret.add(copy.get(maxIndex));
                copy.remove(maxIndex);
            } else {
                break;
            }
        }
        return ret;
    }
}