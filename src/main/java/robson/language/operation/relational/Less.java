package robson.language.operation.relational;

import robson.exception.ProgramProcessingException;
import robson.language.Instruction;
import robson.language.operation.BinaryOperator;
import robson.language.operation.Operator;

import java.util.HashMap;

public class Less extends BinaryOperator {
    @SuppressWarnings("unused")
    public Less() {
        super(false, true);
    }
    
    @SuppressWarnings("unused")
    public Less(Instruction firstArg, Instruction secondArg) {
        super(firstArg, secondArg, false, true);
    }

    @Override
    public String getSign() {
        return "<";
    }

    @Override
    public double execute(HashMap<String, Double> variables) throws ProgramProcessingException {
        double firstValue = firstArg.execute(variables);
        double secondValue = secondArg.execute(variables);
        return Operator.toDouble(firstValue < secondValue);
    }
}
