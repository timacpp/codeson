package robson.language.operation.logical;

import robson.exception.ProgramProcessingException;
import robson.language.Instruction;
import robson.language.operation.Operator;
import robson.language.operation.UnaryOperator;

import java.util.HashMap;

public class Not extends UnaryOperator {
    @SuppressWarnings("unused")
    public Not() {
        super(true, true);
    }

    @SuppressWarnings("unused")
    public Not(Instruction argument) {
        super(argument, true, true);
    }

    @Override
    public String getSign() {
        return "!";
    }
    
    @Override
    public double execute(HashMap<String, Double> variables) throws ProgramProcessingException {
        return Operator.toDouble(argument.execute(variables) == 0);
    }
}
