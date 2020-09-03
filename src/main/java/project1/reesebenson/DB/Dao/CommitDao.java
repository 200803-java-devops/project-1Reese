package project1.reesebenson.DB.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import project1.reesebenson.DB.ConnectionUtils.ConnectionUtils;
import project1.reesebenson.DB.Entities.CommitEntity;

public class CommitDao implements IDao<CommitEntity, String>{
    final String Table = "commit_history";

    public List<CommitEntity> get(){
        String sql = "select * from " + Table;
        List<CommitEntity> result = new ArrayList<CommitEntity>();
        try {
            PreparedStatement stmt = ConnectionUtils.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            rs.next();
                while(!rs.isAfterLast()){
                    String commit_id = rs.getString("commit_id");
                    int project_id = rs.getInt("project_id");
                    String commiter = rs.getString("commiter");
                    Boolean build_success = rs.getBoolean("build_success");
                    Boolean test_success =rs.getBoolean("test_success");
                    String message = rs.getString("message");
                    Boolean auto_push = rs.getBoolean("auto_push_success");
                    CommitEntity entity = new CommitEntity(commit_id, project_id, commiter, build_success, test_success, message, auto_push);
                    result.add(entity);
                    rs.next();
                }
            } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    public CommitEntity get(String id){
        String sql = "Select * FROM " + Table + " where commit_id = ?";
        try {
            PreparedStatement stmt = ConnectionUtils.getConnection().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            String commit_id = rs.getString("commit_id");
            int project_id = rs.getInt("project_id");
            String commiter = rs.getString("commiter");
            Boolean build_success = rs.getBoolean("build_success");
            Boolean test_success =rs.getBoolean("test_success");
            String message = rs.getString("message");
            Boolean auto_push = rs.getBoolean("auto_push_success");
            CommitEntity entity = new CommitEntity(commit_id, project_id, commiter, build_success, test_success, message, auto_push);
            return entity;
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    public void create(CommitEntity entity){
        String sql = "Insert into " + Table + " (commit_id, project_id, commiter, build_success, test_success, auto_push_success, message) Values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = ConnectionUtils.getConnection().prepareStatement(sql);
            stmt.setString(1, entity.getCommit_id());
            stmt.setInt(2, entity.getProject_id());
            stmt.setString(3, entity.getUser());
            stmt.setBoolean(4, entity.isBuild_success());
            stmt.setBoolean(5, entity.isTest_success());
            stmt.setBoolean(6, entity.isAuto_push());
            stmt.setString(7, entity.getMessage());
            stmt.executeUpdate();
            } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            }
            return;
    }

    public void delete(CommitEntity entity){
        return;
    }

    public void update(CommitEntity entity){
        return;
    }
}