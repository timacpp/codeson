package language.statement;

import java.util.HashMap;
import com.squareup.moshi.Json;

import language.ProgramFailed;
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
    public double execute(HashMap<String, Double> variables) throws ProgramFailed {
        double value = assignInstruction.execute(variables);
        variables.put(assignVariableName, value);
        return value;
    }
    
    @Override
    public String toLambda(String prefix) {
        return prefix + "new Lambda(() -> {\n" +
               prefix + "\tvariables.put(" + 
               "\"" + assignVariableName + "\", " +
               assignInstruction.toLambda("") + ");\n" +
               prefix + "\treturn variables.get(" +
               "\"" + assignVariableName + "\");\n" +
               prefix + "}).get()";
    }
}
