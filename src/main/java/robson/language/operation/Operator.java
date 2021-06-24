package robson.language.operation;

import robson.language.Instruction;

public abstract class Operator implements Instruction {
    /* Transient fields are not parsed by Moshi. */
    protected final transient boolean logicalInput;
    protected final transient boolean logicalOutput;
    
    public Operator(boolean logicalInput, boolean logicalOutput) {
        this.logicalInput = logicalInput;
        this.logicalOutput = logicalOutput;
    }

    public abstract String getSign();
    
    public static double toDouble(boolean value) {
        return (value ? 1.0 : 0.0);
    }
}
