package project1.reesebenson.Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GitRepoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String First = req.getReader().readLine().split("RepoPath: \"")[1];
        String RepoPath = First.substring(0, First.length()-2);
        String result= executeCommand("mvn clean compile", RepoPath); 
        if(result.toLowerCase().contains("build success")){
            System.out.println("Build Success");
            resp.getWriter().println("Build Success");
            result = executeCommand("mvn test", RepoPath);
            String fail = result.split("Failures:")[1].strip().split(",")[0].strip();
            int Failures = Integer.parseInt(fail);
            if(Failures > 0){
                System.out.println("Tests Failure");
                resp.getWriter().println(result);
            }else{
                System.out.println("Tests Success");
                resp.getWriter().println("Build Success");
            }       
        }else{
            System.out.println("Build Failure");
            resp.getWriter().println(result);
        }      
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(":)");
    }

    private String executeCommand(String command, String executionDirectory) {
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
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        return output;
    }
}