package robson.exception;

public class InvalidProgramException extends RobsonException{
    public InvalidProgramException() {
        super("Invalid ROBSON program input.");
    }
}
