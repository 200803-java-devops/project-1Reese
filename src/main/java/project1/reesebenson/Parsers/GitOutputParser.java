package project1.reesebenson.Parsers;

import project1.reesebenson.ProcessUtils.Pair;

public class GitOutputParser {

    public static String PraseCurrentBranchFromGitBranch(String toParse){
        String parsed = toParse.split("\\*")[1].split("\n")[0].strip();
        return parsed;
    }

    public static String PasreRemoteFromGitRemoteShow(String toParse){
        if(toParse.contains("origin\n")){
            return "origin";
        }
        String parsed = toParse.split("\n")[0].strip();
        return parsed;
    }
	public static Pair<Boolean, String> ParsePushResultsForResponse(String toParse, String remote, String branch) {
        String lower = toParse.toLowerCase();
        String result = "";
        if(lower.contains("fatal") || lower.contains("error")){
            return  new Pair<> (false,"push failed with response:\n" + toParse);
        }
        result += "Push successful\n";
        if(lower.contains("[new branch]")){
            result += "New branch " + branch + " Added to remote:" + remote + "\n";
        }
		return new Pair<> (true, result);
	}
}