package language.statement;

import java.util.HashMap;
import com.squareup.moshi.Json;

import language.ExecutionError;
import language.Instruction;

public class Assign implements Instruction {
    @Json(name = "nazwa")
    private final String assignVariableName;
    
    @Json(name = "wartosc")
    private final Instruction assignInstruction;
    
    public Assign(String assignVariableName, Instruction assignValue) {
        this.assignVariableName = assignVariableName;
        this.assignInstruction = assignValue;
    }
    
    @Override
    public double execute(HashMap<String, Double> variables) throws ExecutionError {
        double value = assignInstruction.execute(variables);
        variables.put(assignVariableName, value);
        return value;
    }
    
    @Override
    public String toLambda(String prefix) {
        return prefix + "new Lambda(() -> {\n" + 
                prefix + "\t" + "variables.put(" + 
                "\"" + assignVariableName + "\", " + 
                assignInstruction.toLambda("") + ");\n" + 
                prefix + "\t" + "return variables.get(" + 
                "\"" + assignVariableName + "\");\n" + 
                prefix + "}).get()";
    }
}
