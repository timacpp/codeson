package codeson.structure.statement;

import java.util.HashMap;

import com.squareup.moshi.Json;
import codeson.structure.ExecutionError;
import codeson.structure.Instruction;

public class If implements Instruction {
    @Json(name = "warunek")
    private final Instruction condition;
    
    @Json(name = "blok_prawda")
    private final Instruction truthInstruction;
    
    @Json(name = "blok_falsz")
    private final Instruction elseInstruction;
    
    public If(Instruction condition, Instruction truthInstruction, Instruction elseInstruction) {
        this.condition = condition;
        this.truthInstruction = truthInstruction;
        this.elseInstruction = elseInstruction;
    }
    
    @Override
    public double execute(HashMap<String, Double> variables) throws ExecutionError {
        if (condition.execute(variables) != 0)
            return truthInstruction.execute(variables);
        
        return (elseInstruction == null ? 0 : elseInstruction.execute(variables));
    }
    
    @Override
    public String toLambda(String prefix) {
        String elseLambda = elseInstruction == null ?
                            new Block().toLambda(prefix + "\t") :
                            elseInstruction.toLambda(prefix + "\t");
        
        return prefix + "new Lambda(() -> " + condition.toLambda("") + " != 0.0\n" +
               prefix + "\t?\n" +
               truthInstruction.toLambda(prefix + "\t") + "\n" +
               prefix + "\t:\n" +
               elseLambda + "\n" + 
               prefix + "\t).get()"; 
    }
}