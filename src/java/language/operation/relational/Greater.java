package language.operation.relational;

import language.ProgramFailed;
import language.Instruction;
import language.operation.BinaryOperator;
import language.operation.Operator;

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
    public double execute(HashMap<String, Double> variables) throws ProgramFailed {
        double firstArgValue = firstArg.execute(variables);
        double secondArgValue = secondArg.execute(variables);
        return Operator.toDouble(firstArgValue > secondArgValue);
    }
}
