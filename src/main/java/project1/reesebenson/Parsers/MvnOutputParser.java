package project1.reesebenson.Parsers;

public class MvnOutputParser {
    public static Boolean parseCompileForSuccess(String toParse){
        return toParse.toLowerCase().contains("build success");
    }
    public static Boolean parseTestForSuccess(String toParse){
            String fail = toParse.split("Failures:")[1].strip().split(",")[0].strip();
            int Failures = Integer.parseInt(fail);
            return Failures == 0;       
    }
}