package codeson.structure.operation.arithmetical;

import codeson.structure.Instruction;
import codeson.structure.operation.BinaryOperator;

import java.util.HashMap;

public class Addition extends BinaryOperator {
    @SuppressWarnings("unused")
    public Addition() {
        super(false, false);
    }

    @SuppressWarnings("unused")
    public Addition(Instruction firstArg, Instruction secondArg) {
        super(firstArg, secondArg, false, false);
    }

    @Override
    public String getSign() {
        return "+";
    }
    
    @Override
    public double execute(HashMap<String, Double> variables) {
        return firstArg.execute(variables) + secondArg.execute(variables);
    }
}
