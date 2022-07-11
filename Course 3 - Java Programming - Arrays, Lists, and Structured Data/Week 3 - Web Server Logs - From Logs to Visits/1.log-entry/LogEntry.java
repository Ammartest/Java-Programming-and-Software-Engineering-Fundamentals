/**
 * Write a description of class LogRecord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import  java.util.*;

public class LogEntry {
    private String ipAddress;
    private Date accessTime;
    private String request;
    private int statusCode;
    private int bytesReturned;
    
    public LogEntry(String ip, Date time, String req, int status, int bytes) {
        ipAddress = ip;
        accessTime = time;
        request = req;
        statusCode = status;
        bytesReturned = bytes;
    }
   
    public String getIpAddress() {
        return ipAddress;
    }
    
    public Date getAccessTime() {
        return accessTime;
    }
    
    public String getRequest() {
        return request;
    }
    
    public int getStatusCode() {
        return statusCode;
    }
    
    public int getBytesReturned() {
        return bytesReturned;
    }
    
    public String toString() {
        /* Every class has a toString() method by default.
         * But it only knows to print out the memory address of an object, 
         * unless you actually specify a toString class.
         * 
         * This toString() method must be spelled correctly as "toString",
         * otherwise, the object address will be printed out instead of that object itself.
         */
        return ipAddress + " " + accessTime + " " + request 
           + " " + statusCode + " " + bytesReturned;
    }
}