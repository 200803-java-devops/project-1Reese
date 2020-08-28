package project1.reesebenson.DB.Entities;

public class CommitEntity {
    private String commit_id;
    private int project_id;
    private String commiter;
    private boolean build_success;
    private boolean test_success;
    private String message;
    private boolean auto_push;

    public CommitEntity() {

    }

    public boolean isAuto_push() {
        return auto_push;
    }

    public void setAuto_push(boolean auto_push) {
        this.auto_push = auto_push;
    }

    public CommitEntity(String commit_id, int project_id, String commiter, boolean build_success, boolean test_success,
            String message, boolean auto_push) {
        this.commit_id = commit_id;
        this.project_id = project_id;
        this.commiter = commiter;
        this.build_success = build_success;
        this.test_success = test_success;
        this.message = message;
        this.auto_push = auto_push;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CommitEntity(String commit_id, int project_id, String user, boolean build_success, boolean test_success, boolean auto_push_success) {
        this.commit_id = commit_id;
        this.project_id = project_id;
        this.commiter = user;
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
        return commiter;
    }

    public void setUser(String user) {
        this.commiter = user;
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

	public void appendToMessage(String add) {
        if(message != null){
            this.message += add;
        }
        else
            this.message = add;
	}
}