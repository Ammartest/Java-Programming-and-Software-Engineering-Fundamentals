/**
 * Programming Exercise: Parsing Weather Data
 * 
 * @author Ginny Dang
 * @version July 7th, 2022
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class ParsingWeatherData {
    public CSVRecord getSmallestOfTwo(CSVRecord currentRow, CSVRecord coldestSoFar) {
        if (currentRow.get("TemperatureF").equals("-9999")) {
            return coldestSoFar;
        } else if (coldestSoFar == null) {
            coldestSoFar = currentRow;
        } else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
            if (currentTemp < coldestTemp) {
                coldestSoFar = currentRow;
            }
        }
        return coldestSoFar;
    }
    
    public CSVRecord getLowestOfTwo(CSVRecord currentRow, CSVRecord lowestSoFar) {
        if (currentRow.get("Humidity").equals("N/A")) {
            return lowestSoFar;
        } else if (lowestSoFar == null) {
            lowestSoFar = currentRow;
        } else {
            int currentHumidity = Integer.parseInt(currentRow.get("Humidity"));
            int lowestHumidity = Integer.parseInt(lowestSoFar.get("Humidity"));
            if (currentHumidity < lowestHumidity) {
                lowestSoFar = currentRow;
            }
        }
        return lowestSoFar;
    }
    
    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord coldestSoFar = null;
        for (CSVRecord currentRow : parser) {
            coldestSoFar = getSmallestOfTwo(currentRow, coldestSoFar);
        }
        return coldestSoFar;
    }
    
    public String fileWithColdestTemperature() {
        String fileWithColdest = null;
        CSVRecord coldestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            String currentFileName = f.getName();
            FileResource fr = new FileResource(f);
            CSVRecord currentColdest = coldestHourInFile(fr.getCSVParser());
            coldestSoFar = getSmallestOfTwo(currentColdest, coldestSoFar);
            if (coldestSoFar == currentColdest) {
                fileWithColdest = currentFileName;
            }
        }
        return fileWithColdest;
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestSoFar = null;
        for (CSVRecord currentRow : parser) {
            lowestSoFar = getLowestOfTwo(currentRow, lowestSoFar);
        }
        return lowestSoFar;
    }
    
    public CSVRecord lowestHumidityInManyFiles() {
        CSVRecord lowestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentLowest = lowestHumidityInFile(fr.getCSVParser());
            lowestSoFar = getLowestOfTwo(currentLowest, lowestSoFar);
        }
        return lowestSoFar;
    }
    
    public double averageTemperatureInFile(CSVParser parser) {
        double avgTemp = 0;
        double totalTemp = 0;
        int count = 0;
        for (CSVRecord record : parser) {
            totalTemp += Double.parseDouble(record.get("TemperatureF"));
            count += 1;
        }
        avgTemp = totalTemp / count;
        return avgTemp;
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        double avgTemp = 0;
        double totalTemp = 0;
        int count = 0;
        for (CSVRecord record : parser) {
            int currHumidity = Integer.parseInt(record.get("Humidity"));
            if (currHumidity >= value) {
                totalTemp += Double.parseDouble(record.get("TemperatureF"));
                count += 1;
            }
        }
        // There's no record in the file whose humidity is greater than or equal to value
        if (count == 0) {
            return -9999;
        }
        avgTemp = totalTemp / count;
        return avgTemp;
    }
    
    public void testColdestHourInFile() {
        FileResource fr = new FileResource("nc_weather/2014/weather-2014-05-01.csv");
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest hour on " + coldest.get("DateUTC") + " was " + coldest.get("TimeEDT"));
        System.out.println("- Temperature: " + coldest.get("TemperatureF") + "°F");
        //System.out.println("- Dew Point: " + coldest.get("Dew PointF") + "°F");
        //System.out.println("- Humidity: " + coldest.get("Humidity"));
        //System.out.println("- Sea Level Pressure: " + coldest.get("Sea Level PressureIn") + "inch");
        //System.out.println("- Visibility: " + coldest.get("VisibilityMPH") + "mph");
        //System.out.println("- Wind Direction: " + coldest.get("Wind Direction"));
        //System.out.println("- Wind Speed: " + coldest.get("Wind SpeedMPH") + "mph");
        //System.out.println("- Gust Speed: " + coldest.get("Gust SpeedMPH") + "mph");
        //System.out.println("- Precipitation: " + coldest.get("PrecipitationIn") + "inch");
        //System.out.println("- Conditions: " + coldest.get("Conditions"));
        //System.out.println("- Wind Direction in Degree: " + coldest.get("WindDirDegrees") + "°");
    }
    
    public void testFileWithColdestTemperature() {
        String coldestFile = fileWithColdestTemperature();
        System.out.println("Coldest day was in file " + coldestFile);
        FileResource fr = new FileResource("nc_weather/2013/" + coldestFile);
        CSVRecord coldestHour = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temperature on that day was " + coldestHour.get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were:");
        CSVParser coldestParser = fr.getCSVParser();
        for (CSVRecord record : coldestParser) {
            System.out.println(record.get("DateUTC") + " " + record.get("TemperatureF"));
        }
    }
    
    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource("nc_weather/2014/weather-2014-07-22.csv");
        CSVParser lowestParser = fr.getCSVParser();
        CSVRecord lowestHour = lowestHumidityInFile(lowestParser);
        System.out.println("Lowest Humidity was " + lowestHour.get("Humidity") + " at " + lowestHour.get("DateUTC"));
    }
    
    public void testLowestHumidityInManyFiles() {
        CSVRecord lowestRecord = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + lowestRecord.get("Humidity") + " at " + lowestRecord.get("DateUTC"));
    }
    
    public void testAverageTemperatureInFile() {
        FileResource fr = new FileResource("nc_weather/2013/weather-2013-08-10.csv");
        CSVParser avgParser = fr.getCSVParser();
        double avgTemp = averageTemperatureInFile(avgParser);
        System.out.println(avgTemp);
    }
    
    public void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource("nc_weather/2013/weather-2013-09-02.csv");
        CSVParser avgParser = fr.getCSVParser();
        double avgTemp = averageTemperatureWithHighHumidityInFile(avgParser, 80);
        
        if (avgTemp == -9999) {
            System.out.println("No temperatures with that humidity");
        } else {
            System.out.println("Average Temp when high Humidity is " + avgTemp);
        }
        
        fr = new FileResource("nc_weather/2014/weather-2014-03-20.csv");
        avgParser = fr.getCSVParser();
        avgTemp = averageTemperatureWithHighHumidityInFile(avgParser, 80);
        
        if (avgTemp == -9999) {
            System.out.println("No temperatures with that humidity");
        } else {
            System.out.println("Average Temp when high Humidity is " + avgTemp);
        }
    }
}