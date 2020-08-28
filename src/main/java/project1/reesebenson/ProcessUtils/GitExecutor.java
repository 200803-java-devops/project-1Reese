package project1.reesebenson.ProcessUtils;

import project1.reesebenson.Parsers.GitOutputParser;
import static project1.reesebenson.ProcessUtils.ProcExecutor.executeCommand;

public class GitExecutor {
    private String executionLocation;

    public GitExecutor(String executionLocation){
        this.executionLocation = executionLocation;
    }

    public Pair<Boolean,String> push(){
        if(!HasRemote()){
            return new Pair<> (false,"Failed to Push, No remote branch found. \n\tUse command: \n \t git remote add [-t <branch>] [-m <master>] [-f] [--tags | --no-tags] [--mirror=<fetch|push>] <name> <url> \n to add a remote repository to push to on sucessfully commits");
        }
        String remote = findRemote();
        String currentBranch = GitOutputParser.PraseCurrentBranchFromGitBranch(executeCommand("git branch", executionLocation));
        String result = executeCommand("git push -u " + remote + " " + currentBranch, executionLocation);
        return GitOutputParser.ParsePushResultsForResponse(result, remote, currentBranch);
    }

    private String findRemote(){
        String Remote = executeCommand("git remote show", executionLocation);
       return GitOutputParser.PasreRemoteFromGitRemoteShow(Remote);
    }

    private boolean HasRemote(){
        String res = executeCommand("git remote show", executionLocation);
        return res != null && res.length() > 0;
    }

    public String log(){
        String res = executeCommand("git log", executionLocation);
        return res != null && res.length() > 0 ? res : null;
    }
}