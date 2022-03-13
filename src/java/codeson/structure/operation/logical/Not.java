package codeson.structure.operation.logical;

import codeson.structure.ExecutionError;
import codeson.structure.Instruction;
import codeson.structure.operation.Operator;
import codeson.structure.operation.UnaryOperator;

import java.util.HashMap;

public class Not extends UnaryOperator {
    @SuppressWarnings("unused")
    public Not() {
        super(true, true);
    }

    @SuppressWarnings("unused")
    public Not(Instruction argument) {
        super(argument, true, true);
    }

    @Override
    public String getSign() {
        return "!";
    }
    
    @Override
    public double execute(HashMap<String, Double> variables) throws ExecutionError {
        return Operator.toDouble(argument.execute(variables) == 0);
    }
}
