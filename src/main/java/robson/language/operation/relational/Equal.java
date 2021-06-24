package robson.language.operation.relational;

import robson.exception.ProgramProcessingException;
import robson.language.Instruction;
import robson.language.operation.BinaryOperator;
import robson.language.operation.Operator;

import java.util.HashMap;

public class Equal extends BinaryOperator {
    @SuppressWarnings("unused")
    public Equal() {
        super(false, true);
    }

    @SuppressWarnings("unused")
    public Equal(Instruction firstArg, Instruction secondArg) {
        super(firstArg, secondArg, false, true);
    }

    @Override
    public String getSign() {
        return "==";
    }

    @Override
    public double execute(HashMap<String, Double> variables) throws ProgramProcessingException {
        double firstValue = firstArg.execute(variables);
        double secondValue = secondArg.execute(variables);
        return Operator.toDouble(firstValue == secondValue);
    }
}
