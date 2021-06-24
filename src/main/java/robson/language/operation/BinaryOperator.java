package robson.language.operation;

import com.squareup.moshi.Json;
import robson.language.Instruction;

public abstract class BinaryOperator extends Operator {
    @Json(name = "argument1")
    protected Instruction firstArg;
    @Json(name = "argument2")
    protected Instruction secondArg;
    
    public BinaryOperator(boolean logicalInput, boolean logicalOutput) {
        super(logicalInput, logicalOutput);
        firstArg = null;
        secondArg = null;
    }
    
    public BinaryOperator(Instruction firstArg, Instruction secondArg,
                          boolean logicalInput, boolean logicalOutput) {
        super(logicalInput, logicalOutput);
        this.firstArg = firstArg;
        this.secondArg = secondArg;
    }

    @Override
    public String toLambda(String prefix) {
        String firstLambda = firstArg.toLambda("") + (logicalInput ? " != 0" : "");
        String secondLambda = secondArg.toLambda("") + (logicalInput ? " != 0" : "");
        return prefix + "new Lambda(() -> " + (logicalOutput ? "toDouble(" : "") +
               firstLambda + " " +  getSign() + " " + secondLambda +
                (logicalOutput ? ")": "") +").get()";
    }
}
