/**
 * Programming Exercise: Parsing Export Data
 * 
 * @author Ginny Dang
 * @version July 6th, 2022
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class ParsingExportData {
    public String countryInfo(CSVParser parser, String country) {
        for (CSVRecord record : parser) {
            if (record.get("Country").equals(country)) {
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");
                return (country + ": " + exports + ": " + value);
            }
        }
        return "NOT FOUND";
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
                System.out.println(record.get("Country"));
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem) {
        int exporters = 0;
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem)) {
                exporters += 1;
            }
        }
        return exporters;
    }
    
    public void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            if (value.length() > amount.length()) {
                System.out.println(record.get("Country") + " " + value);
            }
        }
    }
    
    public void tester() {
        FileResource fr = new FileResource();
        // Test the countryInfo() method
        CSVParser parser = fr.getCSVParser();
        String info = countryInfo(parser, "Nauru");
        System.out.println(info);
        
        // Test the listExportersTwoProducts() method
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "fish", "nuts");
        
        // Test the numberOfExporters() method
        parser = fr.getCSVParser();
        int exporters = numberOfExporters(parser,"sugar");
        System.out.println(exporters);
        
        // Test the bigExporters method
        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
    }
}
