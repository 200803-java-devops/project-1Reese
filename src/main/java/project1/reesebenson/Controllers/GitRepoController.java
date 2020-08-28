package project1.reesebenson.Controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import project1.reesebenson.DB.Entities.CommitEntity;
import project1.reesebenson.ProcessUtils.IPipeLine;
import project1.reesebenson.ProcessUtils.MvnGitPipline;

public class GitRepoController extends HttpServlet {

    /**
     * Defaut serial
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String First = req.getReader().readLine().split("RepoPath: \"")[1];
        String RepoPath = First.substring(0, First.length()-2);
        IPipeLine<CommitEntity> pipline = new MvnGitPipline(RepoPath); 
        CommitEntity entity = pipline.runall();
        resp.getWriter().write(entity.getMessage());
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(":)");
    }
}