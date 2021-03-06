package codeson.structure.operation.arithmetical;

import codeson.structure.Instruction;
import codeson.structure.operation.BinaryOperator;

import java.util.HashMap;

public class Division extends BinaryOperator {
    @SuppressWarnings("unused")
    public Division() {
        super(false, false);
    }

    @SuppressWarnings("unused")
    public Division(Instruction firstArg, Instruction secondArg) {
        super(firstArg, secondArg, false, false);
    }

    @Override
    public String getSign() {
        return "/";
    }

    @Override
    public double execute(HashMap<String, Double> variables) {
        double secondArgValue = secondArg.execute(variables);
        
        if (secondArgValue == 0.0) {
            throw new ArithmeticException("Division by zero is illegal.");
        }
        
        return firstArg.execute(variables) / secondArg.execute(variables);
    }
}
