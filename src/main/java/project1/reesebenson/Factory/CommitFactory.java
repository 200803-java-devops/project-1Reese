package project1.reesebenson.Factory;

import project1.reesebenson.DB.Entities.CommitEntity;

public class CommitFactory {
    
    public static CommitEntity createEmptyEntity(){
        return new CommitEntity(new String(), 0 , new String(), false, false , new String(), false);
    }
}