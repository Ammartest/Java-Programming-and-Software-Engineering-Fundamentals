/**
 * Tester for other classes
 * 
 * @author Ginny Dang
 * @version July 11st, 2022
 */

import java.util.*;

public class Tester {
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log.txt");
        
        //System.out.println("All log entries:");
        //la.printAll();
        
        int num = 400;
        //System.out.println("\nAll log entries whose status codes are greater than " + num);
        //la.printAllHigherThanNum(num);
        
        String day = "Mar 17";
        //System.out.println("\nUnique IP address visits on " + day);
        ArrayList<String> uniqueVisits = la.uniqueIPVisitsOnDay(day);
        //System.out.println(uniqueVisits.size());
        day = "Sep 30";
        //System.out.println("\nUnique IP address visits on " + day);
        uniqueVisits = la.uniqueIPVisitsOnDay(day);
        //System.out.println(uniqueVisits.size());
        
        int low = 400;
        int high = 499;
        int uniqueInRange = la.countUniqueIPsInRange(low, high);
        System.out.println(uniqueInRange);
    }
    
    public void testUniqIP() {
        LogAnalyzer la = new LogAnalyzer();
        //la.readFile("short-test_log");
        la.readFile("weblog2_log.txt");
        int uniqueIPs = la.countUniqueIPs();
        System.out.println("There are " + uniqueIPs + " IPs");
    }
}