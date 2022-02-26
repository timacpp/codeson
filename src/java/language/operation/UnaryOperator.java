package language.operation;

import com.squareup.moshi.Json;
import language.Instruction;

public abstract class UnaryOperator extends Operator {
    @Json(name = "argument")
    protected Instruction argument;
    
    public UnaryOperator(boolean logicalInput, boolean logicalOutput) {
        super(logicalInput, logicalOutput);
        this.argument = null;
    }
    
    public UnaryOperator(Instruction argument, boolean logicalInput, boolean logicalOutput) {
        super(logicalInput, logicalOutput);
        this.argument = argument;
    }
    
    @Override
    public String toLambda(String prefix) {
        String argLambda = argument.toLambda("") + (logicalInput ? " != 0" : "");
        return prefix + "new Lambda(() -> " +
                (logicalOutput ? "toDouble(" : "") +
                getSign() + "(" + argLambda + ")" +
                (logicalOutput ? ")" : "") + ").get()";
    }
}
