package project1.reesebenson.Parsers;

public class GitOutputParser {
    public static String PraseCurrentBranchFromGitBranch(String toParse){
        String parsed = toParse.split("*")[1].split("\n")[0].strip();
        return parsed;
    }
    public static String PasreRemoteFromGitBranchDashR(String toParse){
        String parsed = toParse.split("/")[1].strip();
        return parsed;
    }
	public static String ParsePushResultsForResponse(String toParse, String remote, String branch) {
        String lower = toParse.toLowerCase();
        String result = "";
        if(lower.contains("fatal") || lower.contains("error")){
            return "push failed with response:\n" + toParse;
        }
        result += "Push successful\n";
        if(lower.contains("[new branch]")){
            result += "New branch" + branch + "Added to remote:" + remote + "\n";
        }
		return result;
	}
}