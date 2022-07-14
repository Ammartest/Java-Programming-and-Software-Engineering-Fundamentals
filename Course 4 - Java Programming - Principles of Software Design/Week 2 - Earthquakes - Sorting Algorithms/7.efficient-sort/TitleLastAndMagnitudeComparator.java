/**
 * Sort earthquakes by the last word in their title first and break ties by magnitude 
 * 
 * @author Ginny Dang
 * @version July 14th, 2022
 */

import java.util.*; 

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        String[] titleWords1 = q1.getInfo().split("\\W+");
        String[] titleWords2 = q2.getInfo().split("\\W+");
        String lastWord1 = titleWords1[titleWords1.length - 1];
        String lastWord2 = titleWords2[titleWords2.length - 1];
        int titleLastCompare = lastWord1.compareTo(lastWord2);
        if (titleLastCompare == 0) {
            return Double.compare(q1.getMagnitude(), q2.getMagnitude());
        }
        return titleLastCompare;
    }
}