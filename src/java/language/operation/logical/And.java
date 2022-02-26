package language.operation.logical;

import language.ExecutionError;
import language.Instruction;
import language.operation.BinaryOperator;
import language.operation.Operator;

import java.util.HashMap;

public class And extends BinaryOperator {
    @SuppressWarnings("unused")
    public And() {
        super(true, true);
    }

    @SuppressWarnings("unused")
    public And(Instruction firstArg, Instruction secondArg) {
        super(firstArg, secondArg, true, true);
    }

    @Override
    public String getSign() {
        return "&&";
    }

    @Override
    public double execute(HashMap<String, Double> variables) throws ExecutionError {
        boolean firstArgValue = firstArg.execute(variables) != 0;
        boolean secondArgValue = secondArg.execute(variables) != 0;
        return Operator.toDouble(firstArgValue && secondArgValue);
    }
}
