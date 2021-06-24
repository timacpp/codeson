package robson.exception;

public class ProgramProcessingException extends RobsonException {
    public ProgramProcessingException() {
        super("Input ROBSON program cannot be executed.");
    }
}
