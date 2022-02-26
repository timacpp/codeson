package language.operation.arithmetical;

import language.ProgramFailed;
import language.Instruction;
import language.operation.BinaryOperator;

import java.util.HashMap;

public class Subtraction extends BinaryOperator {
    @SuppressWarnings("unused")
    public Subtraction() {
        super(false, false);
    }

    @SuppressWarnings("unused")
    public Subtraction(Instruction firstArg, Instruction secondArg) {
        super(firstArg, secondArg, false, false);
    }

    @Override
    public String getSign() {
        return "-";
    }

    @Override
    public double execute(HashMap<String, Double> variables) throws ProgramFailed {
        return firstArg.execute(variables) - secondArg.execute(variables);
    }
}