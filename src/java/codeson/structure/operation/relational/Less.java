package codeson.structure.operation.relational;

import codeson.structure.Instruction;
import codeson.structure.operation.BinaryOperator;
import codeson.structure.operation.Operator;

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
    public double execute(HashMap<String, Double> variables) {
        double firstArgValue = firstArg.execute(variables);
        double secondArgValue = secondArg.execute(variables);
        return Operator.toDouble(firstArgValue < secondArgValue);
    }
}
