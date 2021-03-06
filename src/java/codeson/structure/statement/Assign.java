package codeson.structure.statement;

import java.util.HashMap;
import com.squareup.moshi.Json;

import codeson.structure.Instruction;

public class Assign implements Instruction {
    @Json(name = "target")
    private final String assignVariableName;
    
    @Json(name = "value")
    private final Instruction assignInstruction;
    
    public Assign(String assignVariableName, Instruction assignValue) {
        this.assignVariableName = assignVariableName;
        this.assignInstruction = assignValue;
    }
    
    @Override
    public double execute(HashMap<String, Double> variables) {
        double value = assignInstruction.execute(variables);
        variables.put(assignVariableName, value);
        return value;
    }
    
    @Override
    public String toLambda(String prefix) {
        return String.format(
                """
                %snew Lambda(() -> {
                %s      variables.put("%s", %s);
                %s      return variables.get("%s");
                %s}).get()""", 
                prefix,
                prefix, assignVariableName, assignInstruction.toLambda(""),
                prefix,
                assignVariableName,
                prefix
        );
    }
}
