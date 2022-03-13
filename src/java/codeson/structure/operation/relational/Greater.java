package codeson.structure.operation.relational;

import codeson.structure.ExecutionError;
import codeson.structure.Instruction;
import codeson.structure.operation.BinaryOperator;
import codeson.structure.operation.Operator;

import java.util.HashMap;

public class Greater extends BinaryOperator {
    @SuppressWarnings("unused")
    public Greater() {
        super(false, true);
    }

    @SuppressWarnings("unused")
    public Greater(Instruction firstArg, Instruction secondArg) {
        super(firstArg, secondArg, false, true);
    }

    @Override
    public String getSign() {
        return ">";
    }

    @Override
    public double execute(HashMap<String, Double> variables) throws ExecutionError {
        double firstArgValue = firstArg.execute(variables);
        double secondArgValue = secondArg.execute(variables);
        return Operator.toDouble(firstArgValue > secondArgValue);
    }
}
