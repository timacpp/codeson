package codeson.structure;

import java.util.HashMap;

public interface Instruction {
    /** Evaluates instruction with a given set of variables */
    double execute(HashMap<String, Double> variables);

    /** Converts instruction to a string Java Lambda */
    String toLambda(String prefix);
}