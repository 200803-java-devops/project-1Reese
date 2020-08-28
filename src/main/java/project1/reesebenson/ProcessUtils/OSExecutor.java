package project1.reesebenson.ProcessUtils;

public class OSExecutor {
    private String executionLocation;
    public String whoAmI(){
        return ProcExecutor.executeCommand("whoami", executionLocation);
    }

    public OSExecutor(String executionLocation) {
        this.executionLocation = executionLocation;
    }
}