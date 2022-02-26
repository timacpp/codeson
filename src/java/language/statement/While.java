package language.statement;

import java.util.HashMap;

import com.squareup.moshi.Json;
import language.ProgramFailed;
import language.Instruction;

public class While implements Instruction {
    @Json(name = "warunek")
    private final Instruction condition;
    @Json(name = "blok")
    private final Instruction loopInstruction;

    public While(Instruction condition, Instruction loopBlock) {
        this.condition = condition;
        this.loopInstruction = loopBlock;
    }
    
    @Override
    public double execute(HashMap<String, Double> variables) throws ProgramFailed {
        while (condition.execute(variables) != 0)
            loopInstruction.execute(variables);
        
        return 0;
    }

    @Override
    public String toLambda(String prefix) {
        return prefix + "new Lambda(() -> {\n" +
               prefix + "\twhile (" + condition.toLambda("") + " != 0.0) {\n" + 
               loopInstruction.toLambda(prefix + "\t\t") + ";\n" +
               prefix + "\t}\n" + 
               prefix + "\treturn 0.0;\n" + 
               prefix + "}).get()"; 
    }
}
