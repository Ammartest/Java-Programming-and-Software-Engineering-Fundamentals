/**
 * Tester for the hashmap of LogAnalyzer
 * 
 * @author Ginny Dang
 * @version July 11st, 2022
 */

import java.util.*;

public class CountTester {
    public void testCounts() {
        LogAnalyzer la = new LogAnalyzer();
        //la.readFile("weblog3-short_log");
        //la.readFile("weblog1_log.txt");
        la.readFile("weblog2_log.txt");
        
        HashMap<String, Integer> counts = la.countVisitsPerIP();
        //System.out.println(counts);
        
        int maxCount = la.mostNumberVisitsByIP(counts);
        //System.out.println(maxCount);
        
        ArrayList<String> maxIPs = la.iPsMostVisits(counts);
        //System.out.println(maxIPs);
        
        HashMap<String, ArrayList<String>> daysAndIPs = la.iPsForDays();
        //System.out.println(daysAndIPs);
        
        String maxDay = la.dayWithMostIPVisits(daysAndIPs);
        //System.out.println(maxDay);
        
        ArrayList<String> mostIPsOnDay = la.iPsWithMostVisitsOnDay(daysAndIPs, "Sep 30");
        System.out.println(mostIPsOnDay);
    }
}