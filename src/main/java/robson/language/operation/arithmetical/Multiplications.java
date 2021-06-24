package robson.language.operation.arithmetical;

import robson.exception.ProgramProcessingException;
import robson.language.Instruction;
import robson.language.operation.BinaryOperator;

import java.util.HashMap;

public class Multiplications extends BinaryOperator {
    @SuppressWarnings("unused")
    public Multiplications() {
        super(false, false);
    }

    @SuppressWarnings("unused")
    public Multiplications(Instruction firstArg, Instruction secondArg) {
        super(firstArg, secondArg, false, false);
    }

    @Override
    public String getSign() {
        return "*";
    }
    @Override
    public double execute(HashMap<String, Double> variables) throws ProgramProcessingException {
        return firstArg.execute(variables) * secondArg.execute(variables);
    }
}
