package robson.language.operation.relational;

import robson.exception.ProgramProcessingException;
import robson.language.Instruction;
import robson.language.operation.BinaryOperator;
import robson.language.operation.Operator;

import java.util.HashMap;

public class GreaterOrEqual extends BinaryOperator {
    @SuppressWarnings("unused")
    public GreaterOrEqual() {
        super(false, true);
    }

    @SuppressWarnings("unused")
    public GreaterOrEqual(Instruction firstArg, Instruction secondArg) {
        super(firstArg, secondArg, false, true);
    }

    @Override
    public String getSign() {
        return ">=";
    }

    @Override
    public double execute(HashMap<String, Double> variables) throws ProgramProcessingException {
        double firstValue = firstArg.execute(variables);
        double secondValue = secondArg.execute(variables);
        return Operator.toDouble(firstValue >= secondValue);
    }
}
