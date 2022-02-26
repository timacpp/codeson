package language;

public class ProgramFailed extends Exception {
    public ProgramFailed() {
        this("Encoded input program cannot be executed.");
    }
    
    public ProgramFailed(String message) {
        super(message);
    }
}
