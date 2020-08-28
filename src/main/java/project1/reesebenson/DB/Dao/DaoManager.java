package project1.reesebenson.DB.Dao;
import project1.reesebenson.DB.Dao.ProjectDao;
import project1.reesebenson.DB.Entities.CommitEntity;
import project1.reesebenson.DB.Entities.ProjectEntity;
import project1.reesebenson.DB.Dao.CommitDao;

public class DaoManager{
    ProjectDao projectDao;
    IDao<CommitEntity, String> commitDao;

    
    public void save(ProjectEntity project, CommitEntity commit){
       int projectID = projectDao.getFromProjectName(project.getTitle()).getId();
       if(projectID == 0){
            projectDao.create(project);
            projectID = projectDao.getFromProjectName(project.getTitle()).getId();
       }
        commit.setProject_id(projectID);
        commitDao.create(commit);
    }

    public DaoManager(ProjectDao projectDao, CommitDao commitDao) {
        this.projectDao = projectDao;
        this.commitDao = commitDao;
    }
}