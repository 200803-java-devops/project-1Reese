package project1.reesebenson.DB.Entities;

public class CommitEntity {
    private String commit_id;
    private int project_id;
    private String user;
    private boolean build_success;
    private boolean test_success;

    public CommitEntity(String commit_id, int project_id, String user, boolean build_success, boolean test_success) {
        this.commit_id = commit_id;
        this.project_id = project_id;
        this.user = user;
        this.build_success = build_success;
        this.test_success = test_success;
    }
    
    public String getCommit_id() {
        return commit_id;
    }

    public boolean isTest_success() {
        return test_success;
    }

    public void setTest_success(boolean test_success) {
        this.test_success = test_success;
    }

    public boolean isBuild_success() {
        return build_success;
    }

    public void setBuild_success(boolean build_success) {
        this.build_success = build_success;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public void setCommit_id(String commit_id) {
        this.commit_id = commit_id;
    }

}