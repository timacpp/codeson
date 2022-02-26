package language.operation.relational;

import language.ExecutionError;
import language.Instruction;
import language.operation.BinaryOperator;
import language.operation.Operator;

import java.util.HashMap;

public class Unequal extends BinaryOperator {
    @SuppressWarnings("unused")
    public Unequal() {
        super(false, true);
    }

    @SuppressWarnings("unused")
    public Unequal(Instruction firstArg, Instruction secondArg) {
        super(firstArg, secondArg, false, true);
    }

    @Override
    public String getSign() {
        return "!=";
    }

    @Override
    public double execute(HashMap<String, Double> variables) throws ExecutionError {
        double firstArgValue = firstArg.execute(variables);
        double secondArgValue = secondArg.execute(variables);
        return Operator.toDouble(firstArgValue != secondArgValue);
    }
}
