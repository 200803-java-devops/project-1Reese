package project1.reesebenson.ProcessUtils;

import project1.reesebenson.DB.Entities.CommitEntity;
import project1.reesebenson.Factory.CommitFactory;

public class MvnGitPipline implements IPipeLine<CommitEntity> {
    protected CommitEntity commit;
    protected String executionLocation;
    GitExecutor git;
    MvnExecutor mvn;


    @Override
    public boolean compile() {
        Pair<Boolean, String> result = mvn.compile();
        commit.appendToMessage(result.getValue()); 
        commit.setTest_success(result.getKey());
        return result.getKey();
    }

    @Override
    public boolean test() {
        Pair<Boolean, String> result = mvn.test();
        commit.appendToMessage("\n" + result.getValue()); 
        commit.setTest_success(result.getKey());
        return result.getKey();
    }

    @Override
    public boolean push() {
        Pair<Boolean, String> result = git.push();
        commit.appendToMessage("\n" + result.getValue());
        commit.setAuto_push(result.getKey());
        return result.getKey();
    }

    @Override
    public CommitEntity runall() {
        commit = CommitFactory.createEmptyEntity();
        if(compile())
            if(test())    
                push();
        commit.setUser(git.getCurrentUser());
        commit.setCommit_id(git.gitHeadId());
        return commit;
    }

    public MvnGitPipline(String executionLocation, GitExecutor git, MvnExecutor mvn) {
        this.executionLocation = executionLocation;
        this.git = git;
        this.mvn = mvn;
    }

    public MvnGitPipline(String executionLocation) {
        this.executionLocation = executionLocation;
        this.git = new GitExecutor(executionLocation);
        this.mvn = new MvnExecutor(executionLocation);
    }
    
}