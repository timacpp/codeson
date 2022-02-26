package language;

public class InvalidProgram extends Exception {
    public InvalidProgram() {
        super("The encoded input program is invalid.");
    }
}
