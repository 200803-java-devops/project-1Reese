package project1.reesebenson;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Watch {
    public static void main(String[] args) {
        if (args.length == 1) {
            String RepoPath = args[0];
            File repo = new File(RepoPath);
            if (!repo.exists() || !repo.isDirectory()) {
                System.err.println("The path you provided is not a Directory");
            } else if (CheckForGit(repo)) {
                File headFile = new File(repo.getAbsolutePath() + "/.git/logs/HEAD");
                long lastModified = headFile.lastModified();
                System.out.println("Watching for commits: last head modification at-" + lastModified);
                while (true) {
                    if (headFile.lastModified() != lastModified) {
                        lastModified = headFile.lastModified();
                        System.out.println("Commit Detected! at " + lastModified);
                        try {
                            URL url = new URL("http://localhost:8080/jankins/Repo");
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            connection.setRequestMethod("POST");
                            connection.setRequestProperty("Content-Type", "application/json; utf-8");
                            connection.setRequestProperty("Accept", "application/json");
                            connection.setDoOutput(true);
                            String jsonInputString = "{RepoPath: \""+RepoPath+"\"}";
                            try(OutputStream os = connection.getOutputStream()) {
                                byte[] input = jsonInputString.getBytes("utf-8");
                                os.write(input, 0, input.length);			
                            }
                            StringBuilder responseBody = new StringBuilder();
                            BufferedReader reader = new BufferedReader( new InputStreamReader(connection.getInputStream()));
                           while(reader.ready()){
                                responseBody.append(reader.readLine() + "\n");
                           }
                            System.out.println("Response:" + connection.getResponseCode() + "\n" + responseBody);
                            reader.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
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