package project1.reesebenson.Parsers;

public class PathParse {
    public static String getFileName(String toParse){
        String[] fileNames =toParse.split("\\");
        return fileNames[fileNames.length-1];
    }    
}