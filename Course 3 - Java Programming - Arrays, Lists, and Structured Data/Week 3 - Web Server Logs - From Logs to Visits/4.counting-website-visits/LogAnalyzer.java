/**
 * Analyze log file
 * 
 * @author Ginny Dang
 * @version July 11st, 2022
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;
    
    public LogAnalyzer() {
        records = new ArrayList<LogEntry>();
    }
    
    public void readFile(String filename) {
        FileResource fr = new FileResource(filename);
        for (String line : fr.lines()) {
            LogEntry le = WebLogParser.parseEntry(line);
            records.add(le);
        }
    }
    
    public int countUniqueIPs() {
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for (LogEntry le : records) {
            String ipAddr = le.getIpAddress();
            if (!uniqueIPs.contains(ipAddr)) {
                uniqueIPs.add(ipAddr);
            }
        }
        return uniqueIPs.size();
    }
    
    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }
    
    public void printAllHigherThanNum(int num) {
        for (LogEntry le : records) {
            int statusCode = le.getStatusCode();
            if (statusCode > num) {
                System.out.println(le);
            }
        }
    }
    
    public ArrayList<String> uniqueIPVisitsOnDay(String someday) {
        ArrayList<String> uniqueIPVisits = new ArrayList<String>();
        for (LogEntry le : records) {
            String ipAddr = le.getIpAddress();
            String date = le.getAccessTime().toString().substring(4, 10);
            if (date.equals(someday) && !uniqueIPVisits.contains(ipAddr)) {
                uniqueIPVisits.add(ipAddr);
            }
        }
        return uniqueIPVisits;
    }
    
    public int countUniqueIPsInRange(int low, int high) {
        ArrayList<String> uniqueIPsInRange = new ArrayList<String>();
        for (LogEntry le : records) {
            String ipAddr = le.getIpAddress();
            int statusCode = le.getStatusCode();
            if (statusCode >= low && statusCode <= high && !uniqueIPsInRange.contains(ipAddr)) {
                uniqueIPsInRange.add(ipAddr);
            }
        }
        return uniqueIPsInRange.size();
    }
    
    public HashMap<String, Integer> countVisitsPerIP() {
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
        for (LogEntry le : records) {
            String ip = le.getIpAddress();
            if (!counts.containsKey(ip)) {
                counts.put(ip, 1);
            } else {
                counts.put(ip, counts.get(ip) + 1);
            }
        }
        return counts;
    }
    
    public int mostNumberVisitsByIP(HashMap<String, Integer> counts) {
        int maxCount = 0;
        for (int count : counts.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }
    
    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> counts) {
        int maxCount = mostNumberVisitsByIP(counts);
        ArrayList<String> maxIPs = new ArrayList<String>();
        for (String ip : counts.keySet()) {
            if (counts.get(ip) == maxCount) {
                maxIPs.add(ip);
            }
        }
        return maxIPs;
    }
    
    public HashMap<String, ArrayList<String>> iPsForDays() {
        HashMap<String, ArrayList<String>> daysAndIPs = new HashMap<String, ArrayList<String>>();
        for (LogEntry le : records) {
            String date = le.getAccessTime().toString().substring(4, 10);
            String ip = le.getIpAddress();
            if (!daysAndIPs.containsKey(date)) {
                ArrayList<String> ips = new ArrayList<String>();
                ips.add(ip);
                daysAndIPs.put(date, ips);
            } else {
                ArrayList<String> ips = daysAndIPs.get(date);
                ips.add(ip);
                daysAndIPs.put(date, ips);
            }
        }
        return daysAndIPs;
    }
    
    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> daysAndIPs) {
        int maxCount = 0;
        String maxDay = "";
        for (String day : daysAndIPs.keySet()) {
            int count = daysAndIPs.get(day).size();
            if (count > maxCount) {
                maxCount = count;
                maxDay = day;
            }
        }
        return maxDay;
    }
    
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> daysAndIPs, String day) {
        ArrayList<String> mostIPsOnDay = new ArrayList<String>();
        // Error handling
        if (!daysAndIPs.containsKey(day)) {
            return mostIPsOnDay;
        }
        
        ArrayList<String> iPsOnDay = daysAndIPs.get(day);
        HashMap<String, Integer> ipCounts = new HashMap<String, Integer>();
        
        for (String ip : iPsOnDay) {
            if (!ipCounts.containsKey(ip)) {
                ipCounts.put(ip, 1);
            } else {
                ipCounts.put(ip, ipCounts.get(ip) + 1);
            }
        }
        
        int mostCount = 0;
        for (int count : ipCounts.values()) {
            if (count > mostCount) {
                mostCount = count;
            }
        }
        
        for (String ip : iPsOnDay) {
            if (ipCounts.get(ip) == mostCount && !mostIPsOnDay.contains(ip)) {
                mostIPsOnDay.add(ip);
            }
        }
        return mostIPsOnDay;
    }
}