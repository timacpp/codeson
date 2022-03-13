package codeson.processor;

import java.util.HashMap;

/** Class for executing Codeson programs */
public class CodesonExecutor extends CodesonProcessor {
    public CodesonExecutor(String filename) {
        super(filename);
    }

    /** 
     * Executes the Codeson program, assuming
     * each variable is initially equal to zero.
     * @return value of a last executed instruction
     */
    public double execute() {
        /* Empty hashmap to store variable values */
        return program.execute(new HashMap<>());
    }
}
