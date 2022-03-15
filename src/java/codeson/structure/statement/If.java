package codeson.structure.statement;

import java.util.HashMap;

import com.squareup.moshi.Json;
import codeson.structure.Instruction;

public class If implements Instruction {
    @Json(name = "condition")
    private final Instruction condition;
    
    @Json(name = "true-block")
    private final Instruction truthInstruction;
    
    @Json(name = "false-block")
    private final Instruction elseInstruction;
    
    public If(Instruction condition, Instruction truthInstruction, Instruction elseInstruction) {
        this.condition = condition;
        this.truthInstruction = truthInstruction;
        this.elseInstruction = elseInstruction;
    }
    
    @Override
    public double execute(HashMap<String, Double> variables) {
        if (condition.execute(variables) != 0)
            return truthInstruction.execute(variables);
        
        return elseInstruction == null ? 0 : elseInstruction.execute(variables);
    }
    
    @Override
    public String toLambda(String prefix) {
        return String.format(
               """
               %snew Lambda(() -> %s != 0.0
               %s  ?
               %s
               %s  :
               %s
               %s   ).get()
               """,
                prefix, condition.toLambda(""),
                prefix,
                truthInstruction.toLambda(prefix + "	"),
                prefix,
                getElseBlockLambda(prefix),
                prefix
        );
    }
    
    private String getElseBlockLambda(String prefix) {
        if (elseInstruction == null)
            return new Block().toLambda(prefix + "\t");
        
        return elseInstruction.toLambda(prefix + "\t");
    }
}
