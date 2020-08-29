package project1.reesebenson.Factory;

import project1.reesebenson.DB.Entities.ProjectEntity;
import project1.reesebenson.ProcessUtils.OSExecutor;

public class ProjectFactory {
    
    public static ProjectEntity createProject(String RepoPath){
        OSExecutor osEx = new OSExecutor(RepoPath);
        String title = osEx.whoAmI().trim() + ":" + RepoPath;
        return new ProjectEntity(title);
    }
}