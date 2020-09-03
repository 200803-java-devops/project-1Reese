package project1.reesebenson.DB.Dao;

import java.util.List;

import project1.reesebenson.DB.Entities.CommitEntity;
import project1.reesebenson.DB.Entities.ProjectEntity;

public class DaoManager{
    ProjectDao projectDao;
    CommitDao commitDao;
    
    public List<CommitEntity> getCommits(){
        return commitDao.get();
    }
    
    public CommitEntity getCommit(String id){
        return commitDao.get(id);
    }
    
    public List<ProjectEntity> getProjects(){
        return projectDao.get();
    }

    public ProjectEntity getProject(int id){
        return projectDao.get(id);
    }

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