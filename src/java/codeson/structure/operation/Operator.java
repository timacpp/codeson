package codeson.structure.operation;

import codeson.structure.Instruction;

public abstract class Operator implements Instruction {
    protected final transient boolean logicalInput;
    protected final transient boolean logicalOutput;
    
    public Operator(boolean logicalInput, boolean logicalOutput) {
        this.logicalInput = logicalInput;
        this.logicalOutput = logicalOutput;
    }

    public abstract String getSign();
    
    public static double toDouble(boolean value) {
        return value ? 1.0 : 0.0;
    }
}
