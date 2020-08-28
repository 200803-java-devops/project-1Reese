package project1.reesebenson.DB.Dao;

import java.util.List;

import project1.reesebenson.DB.Entities.CommitEntity;

public class CommitDao implements IDao<CommitEntity, String>{
    
    public List<CommitEntity> getAll(int projectId){
        return null;
    }

    public CommitEntity get(String id){
        return null;
    }

    public void create(CommitEntity entity){
        return;
    }

    public void delete(CommitEntity entity){
        return;
    }

    public void update(CommitEntity entity){
        return;
    }
}