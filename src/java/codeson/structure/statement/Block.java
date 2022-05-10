package codeson.structure.statement;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

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
        return instructions.stream()
                .mapToDouble(instruction -> instruction.execute(variables))
                .skip(instructions.size() - 1).findFirst().orElse(0.0);
    }

    @Override
    public String toLambda(String prefix) {
        return String.format("%snew Lambda(() -> %s).get()", prefix, getInstructionsLambda(prefix));
    }
    
    private String getInstructionsLambda(String prefix) {
        if (instructions.size() == 0)
            return "0.0";
        
        String lambdas = getNonterminatingLambdas(prefix) + getTerminatingLambda(prefix);
        return formatInstructionsLambda(lambdas, prefix);
    }
    
    private String getNonterminatingLambdas(String prefix) {
        StringBuilder lambdas = new StringBuilder();
        instructions.stream()
                .map(instruction -> instruction.toLambda(prefix + "\t") + ";\n")
                .limit(instructions.size() - 1)
                .forEachOrdered(lambdas::append);
        
        return lambdas.toString();
    }
    
    private String getTerminatingLambda(String prefix) {
        StringBuilder builder = new StringBuilder();
        String instruction = instructions.get(instructions.size() - 1).toLambda(prefix + "\t");
        String suffix = instruction.substring(prefix.length() + 1);
        return builder.append(prefix).append("\treturn ").append(suffix).append(";").toString();
    }
    
    private String formatInstructionsLambda(String lambdas, String prefix) {
        return String.format(
                """
                {
                %s
                %s}""", lambdas, prefix
        );
    }
}
