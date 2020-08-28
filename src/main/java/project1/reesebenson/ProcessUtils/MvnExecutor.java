package project1.reesebenson.ProcessUtils;

import static project1.reesebenson.ProcessUtils.ProcExecutor.executeCommand;

import project1.reesebenson.Parsers.MvnOutputParser;

public class MvnExecutor {
    String executionLocation;

    
    public Pair<Boolean, String> compile(){
        String result= executeCommand("mvn clean compile", executionLocation); 
        if(MvnOutputParser.parseCompileForSuccess(result))
            return new Pair<Boolean, String> (true, "Build Success!");
        return new Pair<Boolean, String> (false, "Build Failed with response: \n " + result);
    }

    public Pair<Boolean, String> test(){
        String result = executeCommand("mvn test", executionLocation);
        if(MvnOutputParser.parseTestForSuccess(result))
            return new Pair<Boolean, String> ( true, "Tests Success!");
        return new Pair<Boolean, String> (false, "Test Failed with response: \n " + result);
    }

    public MvnExecutor(String executionLocation) {
        this.executionLocation = executionLocation;
    }
}