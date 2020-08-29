package project1.reesebenson.DB.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project1.reesebenson.DB.ConnectionUtils.ConnectionUtils;
import project1.reesebenson.DB.Entities.ProjectEntity;

public class ProjectDao implements IDao<ProjectEntity,Integer> {
    private final String Table = "project";

    public ProjectEntity getFromProjectName(String name){
        String sql = "select id from " + Table + " where title = ?";
        PreparedStatement statement;
        ProjectEntity p;
        try{
            statement = ConnectionUtils.getConnection().prepareStatement(sql);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery(); 
            rs.next();
            int id = rs.getInt("id");
            p = new ProjectEntity(name, id);       
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return new ProjectEntity(name, 0);
        }
        return p;
    }
    
    @Override
    public ProjectEntity get(Integer id) {
        String sql = "select id from " + Table + " where id = ?";
        PreparedStatement statement;
        ProjectEntity p = null;
        try{
            statement = ConnectionUtils.getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery(); 
            rs.next();
            String title = rs.getString("title");
            p = new ProjectEntity(title, id);       
        }catch(SQLException e){
            System.out.println(e.getMessage());
            //TODO: log exception
        }
        return p;
    }

    @Override
    public void delete(ProjectEntity entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void create(ProjectEntity entity) {
        // TODO Auto-generated method stub
        String sql = "insert into " + Table + " (title) values (?)";
        PreparedStatement statement;
        try{
            statement = ConnectionUtils.getConnection().prepareStatement(sql);
            statement.setString(1, entity.getTitle());
            statement.executeUpdate(); 
        }catch(SQLException e){
            //TODO: log exception
            System.out.println(e.getMessage());
        }
        return;
    }

    @Override
    public void update(ProjectEntity entity) {
        // TODO Auto-generated method stub

    }
    
}