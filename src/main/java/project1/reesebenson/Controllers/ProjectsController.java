package project1.reesebenson.Controllers;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import project1.reesebenson.DB.Dao.CommitDao;
import project1.reesebenson.DB.Dao.DaoManager;
import project1.reesebenson.DB.Dao.ProjectDao;
import project1.reesebenson.DB.Entities.ProjectEntity;
import project1.reesebenson.Parsers.URIParser;

public class ProjectsController extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    DaoManager daoManager;
    @Override
    public void init() throws ServletException {
        super.init();
        daoManager = new DaoManager(new ProjectDao(), new CommitDao());
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lastSegment = URIParser.getLastSegment(req.getRequestURI());
        ObjectMapper objectMapper = new ObjectMapper();
        String JSON = null;
        //if no id is provided get all cases null, path/projects, path/projects/
        if(lastSegment == null || lastSegment.toLowerCase().equals("projects") || lastSegment.length() == 0){
            List<ProjectEntity> result = daoManager.getProjects();
            JSON = objectMapper.writeValueAsString(result);
        }
        //if id is provided get specified if
        else{
            int id = Integer.parseInt(lastSegment); 
            ProjectEntity result = daoManager.getProject(id);
            JSON = objectMapper.writeValueAsString(result);
        }
        resp.setContentType("application/json");
        resp.getWriter().write(JSON);
    }
}
