package codeson.structure;

public class ExecutionError extends RuntimeException {
    public ExecutionError() {
        this("Encoded input program cannot be executed.");
    }
    
    public ExecutionError(String message) {
        super(message);
    }
}
