package project1.reesebenson.ProcessUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcExecutor {
    public static String executeCommand(String command, String executionDirectory) {
        ProcessBuilder builder = new ProcessBuilder();
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        if (isWindows) {
            builder.command("cmd.exe", "/c", command);
        } else {
            builder.command("sh", "-c", command);
        }

        builder.directory(new File(executionDirectory));
        Process process = null;
        int exited = 0;
        String output = "";
        try {
            process = builder.start();
            exited = process.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while(reader.ready()){
                output += reader.readLine() + "\n";
            }
        }catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return output;
    }
}