package language.operation.logical;

import language.ExecutionError;
import language.Instruction;
import language.operation.Operator;
import language.operation.UnaryOperator;

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
