package codeson.structure;

public class InvalidProgram extends RuntimeException {
    public InvalidProgram() {
        super("The encoded input program is invalid.");
    }
}
