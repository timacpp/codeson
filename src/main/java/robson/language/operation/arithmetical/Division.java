package robson.language.operation.arithmetical;

import robson.exception.ProgramProcessingException;
import robson.language.Instruction;
import robson.language.operation.BinaryOperator;

import java.util.HashMap;

public class Division extends BinaryOperator {
    @SuppressWarnings("unused")
    public Division() {
        super(false, false);
    }

    @SuppressWarnings("unused")
    public Division(Instruction firstArg, Instruction secondArg) {
        super(firstArg, secondArg, false, false);
    }

    @Override
    public String getSign() {
        return "/";
    }

    @Override
    public double execute(HashMap<String, Double> variables) throws ProgramProcessingException {
        double secondArgValue = secondArg.execute(variables);
        
        if (secondArgValue == 0.0)
            throw new ProgramProcessingException();
        
        return firstArg.execute(variables) / secondArg.execute(variables);
    }
}
