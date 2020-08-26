package project1.reesebenson.Controllers;

import project1.reesebenson.Parsers.GitOutputParser;
import project1.reesebenson.Parsers.MvnOutputParser;
import project1.reesebenson.ProcessUtils.GitExecutor;

import static project1.reesebenson.ProcessUtils.ProcExecutor.executeCommand;

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
        if(MvnOutputParser.parseCompileForSuccess(result)){
            System.out.println("Build Success");
            resp.getWriter().println("Build Success");
            if(MvnOutputParser.parseTestForSuccess((result = executeCommand("mvn test", RepoPath)))){
                System.out.println("Tests Success");
                resp.getWriter().println("Tests Success");
                GitExecutor git = new GitExecutor(RepoPath);
                resp.getWriter().println(git.push());
                
            }else{
                System.out.println("Tests Failure");
                    resp.getWriter().println(result);
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
}