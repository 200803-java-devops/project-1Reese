package project1.reesebenson.Parsers;

public class MvnOutputParser {
    public static Boolean parseCompileForSuccess(String toParse){
        return toParse.toLowerCase().contains("build success");
    }
    public static Boolean parseTestForSuccess(String toParse){
            return !toParse.contains("<<< FAILURE!");
    }
}