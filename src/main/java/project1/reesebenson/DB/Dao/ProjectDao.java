package project1.reesebenson.DB.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project1.reesebenson.DB.ConnectionUtils.ConnectionUtils;
import project1.reesebenson.DB.Entities.CommitEntity;
import project1.reesebenson.DB.Entities.ProjectEntity;

public class ProjectDao implements IDao<ProjectEntity, Integer> {
    private static final String Url = "localHost:8080/jankins/";
    private static final String commitPath = "commits/";
    private final String Table = "project";
    private final String Commits = "commit_history";

    public ProjectEntity getFromProjectName(String name) {
        String sql = "select id from " + Table + " where title = ?";
        PreparedStatement statement;
        ProjectEntity p;
        try {
            statement = ConnectionUtils.getConnection().prepareStatement(sql);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            p = new ProjectEntity(name, id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ProjectEntity(name, 0);
        }
        return p;
    }

    @Override
    public ProjectEntity get(Integer id) {
        String sql = "select title, commit_id from " + Table + " p join " + Commits + " c on p.id = c.project_id where id = ?";
        PreparedStatement statement;
        ProjectEntity p = null;
        try {
            statement = ConnectionUtils.getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            String title = rs.getString("title");
            List<String> commitUrls = new ArrayList<String>();
            while(!rs.isAfterLast()){
                commitUrls.add(Url + commitPath + rs.getString("commit_id"));
                rs.next();
            }
            p = new ProjectEntity(title, id);
            p.setCommits(commitUrls);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // TODO: log exception
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
        try {
            statement = ConnectionUtils.getConnection().prepareStatement(sql);
            statement.setString(1, entity.getTitle());
            statement.executeUpdate();
        } catch (SQLException e) {
            // TODO: log exception
            System.out.println(e.getMessage());
        }
        return;
    }

    @Override
    public void update(ProjectEntity entity) {
        // TODO Auto-generated method stub

    }

    public List<ProjectEntity> get() {
        List<ProjectEntity> result = new ArrayList<ProjectEntity>();
        String sql = "select id, title, commit_id from " + Table + " p join " + Commits + " c on p.id = c.project_id order by p.id";
        PreparedStatement statement;
        try {
            statement = ConnectionUtils.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            rs.next();
            while(!rs.isAfterLast()){
                String title = rs.getString("title");
                int id = rs.getInt("id");
                ProjectEntity projectEntity = new ProjectEntity(title, id);
                List<String> commitUrls = new ArrayList<String>();
                while(!rs.isAfterLast() && id == rs.getInt("id")){
                    commitUrls.add(Url + commitPath + rs.getString("commit_id"));
                    rs.next();
                }
                projectEntity.setCommits(commitUrls);
                result.add(projectEntity);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // TODO: log exception
        }
        return result;
    }
    
}