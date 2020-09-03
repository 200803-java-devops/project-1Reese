package project1.reesebenson.Parsers;

public class URIParser {
    public static String getLastSegment(String toParse){
        String[] pathSegments = toParse.split("/");
        return pathSegments[pathSegments.length -1];
    }
}
