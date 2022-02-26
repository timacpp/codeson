package language;

public class ExecutionError extends Exception {
    public ExecutionError() {
        this("Encoded input program cannot be executed.");
    }
    
    public ExecutionError(String message) {
        super(message);
    }
}
