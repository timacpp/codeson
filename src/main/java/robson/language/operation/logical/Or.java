package robson.language.operation.logical;

import robson.exception.ProgramProcessingException;
import robson.language.Instruction;
import robson.language.operation.BinaryOperator;
import robson.language.operation.Operator;

import java.util.HashMap;

public class Or extends BinaryOperator {
    @SuppressWarnings("unused")
    public Or() {
        super(true, true);
    }
    
    @SuppressWarnings("unused")
    public Or(Instruction firstArg, Instruction secondArg) {
        super(firstArg, secondArg, true, true);
    }

    @Override
    public String getSign() {
        return "||";
    }
    
    @Override
    public double execute(HashMap<String, Double> variables) throws ProgramProcessingException {
        boolean firstValue = firstArg.execute(variables) != 0;
        boolean secondValue = secondArg.execute(variables) != 0;
        return Operator.toDouble(firstValue || secondValue);
    }
}
