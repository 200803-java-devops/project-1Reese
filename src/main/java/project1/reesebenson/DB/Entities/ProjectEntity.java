package project1.reesebenson.DB.Entities;

import java.util.ArrayList;
import java.util.List;


public class ProjectEntity {
    private String title;
    private int id;
    private List<String> Commits;

    public String getTitle() {
        return title;
    }

    public List<String> getCommits() {
        return Commits;
    }

    public void setCommits(List<String> commits) {
        this.Commits = commits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProjectEntity(String title, int id) {
        this.title = title;
        this.setId(id);
    }

    public ProjectEntity(String title) {
        this.title = title;
        setId(0);
    }

    public ProjectEntity() {
        title = new String();
        id = 0;
        Commits = new ArrayList<String>();
    }
}