package language.util;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import com.squareup.moshi.Json;
import language.ProgramFailed;
import language.Instruction;

public class Block implements Instruction {
    @Json(name = "instrukcje")
    private final List<Instruction> instructions;
    
    public Block() {
        this.instructions = new ArrayList<>();
    }
    
    public Block(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }
    
    @Override
    public double execute(HashMap<String, Double> variables) throws ProgramFailed {
        if (instructions.size() == 0)
            return 0;
        
        double lastInstructionValue = 0;
        for (Instruction instruction : instructions)
            lastInstructionValue = instruction.execute(variables);
        
        return lastInstructionValue;
    }

    @Override
    public String toLambda(String prefix) {
        if (instructions.size() == 0)
            return prefix + "new Lambda(() -> 0.0).get()";
        
        StringBuilder lambdas = new StringBuilder();
        for (int i = 0; i < instructions.size(); i++) {
            Instruction instruction = instructions.get(i);
            
            if (i < instructions.size() - 1) {
                lambdas.append(instruction.toLambda(prefix + "\t") + ";\n");
            } else {
                String lastWithoutTabs = instruction
                                         .toLambda(prefix + "\t")
                                         .substring(prefix.length() + 1);
                
                lambdas.append(prefix + "\treturn " + lastWithoutTabs + ";");
            }
        }
        
        return prefix + "new Lambda(() -> {\n" + 
               lambdas + "\n" +
               prefix + "}).get()";
    }
}
