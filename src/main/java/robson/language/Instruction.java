package robson.language;

import robson.exception.ProgramProcessingException;

import java.util.HashMap;

public interface Instruction {
    /* Method for processing and evaluation of instruction
    on a particular map of variables 'variables'. */
    double execute(HashMap<String, Double> variables) throws ProgramProcessingException;

    /* Method for conversation instruction to string
    value with prefix of a custom Java lambda function. */
    String toLambda(String prefix);
}