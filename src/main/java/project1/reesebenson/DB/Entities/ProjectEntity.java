package project1.reesebenson.DB.Entities;

public class ProjectEntity {
    private String title;
    private int id;

    public String getTitle() {
        return title;
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
}