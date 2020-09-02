package project1.reesebenson.Controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import project1.reesebenson.DB.Dao.CommitDao;
import project1.reesebenson.DB.Dao.DaoManager;
import project1.reesebenson.DB.Dao.ProjectDao;
import project1.reesebenson.DB.Entities.CommitEntity;
import project1.reesebenson.DB.Entities.ProjectEntity;
import project1.reesebenson.Factory.ProjectFactory;
import project1.reesebenson.ProcessUtils.GitExecutor;
import project1.reesebenson.ProcessUtils.IPipeLine;
import project1.reesebenson.ProcessUtils.MvnGitPipline;
import project1.reesebenson.ProcessUtils.OSExecutor;

public class GitRepoController extends HttpServlet {

    /**
     * Defaut serial
     */
    private static final long serialVersionUID = 1L;
    private DaoManager daoManager;

    @Override
    public void init() throws ServletException {
        super.init();
        daoManager = new DaoManager(new ProjectDao(), new CommitDao());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String First = req.getReader().readLine().split("RepoPath: \"")[1];
        String RepoPath = First.substring(0, First.length()-2);
        IPipeLine<CommitEntity> pipline = new MvnGitPipline(RepoPath); 
        CommitEntity commit = pipline.runall();
        resp.getWriter().write(commit.getMessage());
        ProjectEntity project = ProjectFactory.createProject(RepoPath);
        daoManager.save(project, commit);  
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(":)");
    }
}