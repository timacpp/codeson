package language.operation.logical;

import language.ProgramFailed;
import language.Instruction;
import language.operation.BinaryOperator;
import language.operation.Operator;

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
    public double execute(HashMap<String, Double> variables) throws ProgramFailed {
        boolean firstArgValue = firstArg.execute(variables) != 0;
        boolean secondArgValue = secondArg.execute(variables) != 0;
        return Operator.toDouble(firstArgValue || secondArgValue);
    }
}
