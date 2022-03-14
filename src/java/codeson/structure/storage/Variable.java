package codeson.structure.storage;

import com.squareup.moshi.Json;
import codeson.structure.Instruction;

import java.util.HashMap;

public class Variable implements Instruction {
    @Json(name = "name")
    private final String name;
    
    public Variable(String name) {
        this.name = name;
    }

    @Override
    public double execute(HashMap<String, Double> variables) {
        return variables.getOrDefault(name, 0.0);
    }

    @Override
    public String toLambda(String prefix) {
        return prefix + "new Lambda(() -> variables.getOrDefault(\"" + name + "\", 0.0)).get()";
    }
}
