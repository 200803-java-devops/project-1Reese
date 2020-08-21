package project1.reesebenson;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Watch {
    public static void main(String[] args) {
        if(args.length == 1){

            String RepoPath = args[0]; 
            File repo = new File(RepoPath);
            if(!repo.exists() || !repo.isDirectory()){
                System.err.println("The path you provided is not a Directory");
            }else if(CheckForGit(repo)){
                File headFile = new File(repo.getAbsolutePath() + "/.git/logs/HEAD");
                long lastModified = headFile.lastModified();
                System.out.println("Watching for commits: last head modification at-" + lastModified);
                while(true){
                    if(headFile.lastModified() != lastModified){
                        lastModified = headFile.lastModified();
                        System.out.println("Commit Detected! at " + lastModified);
                    }
                }
            }else{
                System.err.println("No git repository found at path.");
            }
        }else{
            System.err.println("No arguments given");
        }
            
    }

    public static boolean CheckForGit(File repo) {
        File git = new File(repo.getAbsolutePath() + "/.git");
        return git.exists();
    }
}