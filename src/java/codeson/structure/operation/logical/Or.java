package codeson.structure.operation.logical;

import codeson.structure.ExecutionError;
import codeson.structure.Instruction;
import codeson.structure.operation.BinaryOperator;
import codeson.structure.operation.Operator;

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
    public double execute(HashMap<String, Double> variables) throws ExecutionError {
        boolean firstArgValue = firstArg.execute(variables) != 0;
        boolean secondArgValue = secondArg.execute(variables) != 0;
        return Operator.toDouble(firstArgValue || secondArgValue);
    }
}
