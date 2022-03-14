package codeson.structure.statement;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import com.squareup.moshi.Json;
import codeson.structure.Instruction;

public class Block implements Instruction {
    @Json(name = "instructions")
    private final List<Instruction> instructions;
    
    public Block() {
        this.instructions = new ArrayList<>();
    }
    
    public Block(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }
    
    @Override
    public double execute(HashMap<String, Double> variables) {
        if (instructions.size() == 0)
            return 0;
        
        double lastInstructionValue = 0;
        
        for (Instruction instruction : instructions) {
            lastInstructionValue = instruction.execute(variables);
        }
        
        return lastInstructionValue;
    }

    @Override
    public String toLambda(String prefix) {
        if (instructions.size() == 0)
            return prefix + "new Lambda(() -> 0.0).get()";
        
        StringBuilder lambdas = new StringBuilder();
        
        for (int i = 0; i < instructions.size(); i++) {
            String instruction = instructions.get(i).toLambda(prefix + "\t");

            if (i < instructions.size() - 1) {
                lambdas.append(instruction).append(";\n");
            } else {
                String suffix = instruction.substring(prefix.length() + 1);
                lambdas.append(prefix).append("\treturn ").append(suffix).append(";");
            }
        }
        
        return prefix + "new Lambda(() -> {\n" + lambdas + "\n" + prefix + "}).get()";
    }
}
