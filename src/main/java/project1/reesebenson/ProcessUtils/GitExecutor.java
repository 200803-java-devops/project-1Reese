package project1.reesebenson.ProcessUtils;

import project1.reesebenson.Parsers.GitOutputParser;
import static project1.reesebenson.ProcessUtils.ProcExecutor.executeCommand;

public class GitExecutor {
    private String executionLocation;

    public GitExecutor(String executionLocation){
        this.executionLocation = executionLocation;
    }

    public String push(){
        if(!HasRemote()){
            return "Use command: \n \t git remote add [-t <branch>] [-m <master>] [-f] [--tags | --no-tags] [--mirror=<fetch|push>] <name> <url> \n to add a remote repository to push to on sucessfully commits";
        }
        String remote = findRemote();
        String currentBranch = GitOutputParser.PraseCurrentBranchFromGitBranch(executeCommand("git branch", executionLocation));
        String result = executeCommand("git push -u " + remote + " " + currentBranch, executionLocation);
        return GitOutputParser.ParsePushResultsForResponse(result, remote, currentBranch);
    }

    private String findRemote(){
        String Remote = executeCommand("git branch -r", executionLocation);
       return GitOutputParser.PasreRemoteFromGitBranchDashR(Remote);
    }

    private boolean HasRemote(){
        return executeCommand("git branch -r", executionLocation) != null;
    }
}