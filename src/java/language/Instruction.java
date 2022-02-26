package language;

import java.util.HashMap;

public interface Instruction {
    /** Evaluates instruction with a given set of variables */
    double execute(HashMap<String, Double> variables) throws ExecutionError;

    /** Converts instruction to a string Java Lambda */
    String toLambda(String prefix);
}