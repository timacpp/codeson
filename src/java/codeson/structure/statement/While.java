package codeson.structure.statement;

import java.util.HashMap;

import com.squareup.moshi.Json;
import codeson.structure.Instruction;

public class While implements Instruction {
    @Json(name = "condition")
    private final Instruction condition;
    
    @Json(name = "instruction")
    private final Instruction loopInstruction;

    public While(Instruction condition, Instruction loopBlock) {
        this.condition = condition;
        this.loopInstruction = loopBlock;
    }
    
    @Override
    public double execute(HashMap<String, Double> variables) {
        while (condition.execute(variables) != 0) {
            loopInstruction.execute(variables);
        }
        
        return 0;
    }
    
    public String toLambda(String prefix) {
        return String.format(
                """
                %snew Lambda(() -> {
                %s      while (%s != 0.0) {
                %s;
                %s      }
                %s      return 0.0;
                %s}).get()""",
                prefix,
                prefix, condition.toLambda(""), 
                loopInstruction.toLambda(prefix + "\t\t\t"),
                prefix,
                prefix,
                prefix
        );
    }
}
