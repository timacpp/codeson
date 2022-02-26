package language.operation.relational;

import language.ProgramFailed;
import language.Instruction;
import language.operation.BinaryOperator;
import language.operation.Operator;

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
    public double execute(HashMap<String, Double> variables) throws ProgramFailed {
        double firstValue = firstArg.execute(variables);
        double secondValue = secondArg.execute(variables);
        return Operator.toDouble(firstValue < secondValue);
    }
}
