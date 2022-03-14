package codeson.structure.unit;

import com.squareup.moshi.Json;
import codeson.structure.Instruction;

import java.util.HashMap;

public class Constant implements Instruction {
    @Json(name = "value")
    private final Double value;

    public Constant(Double value) {
        this.value = value;
    }

    @Override
    public double execute(HashMap<String, Double> variables) {
        return value;
    }

    @Override
    public String toLambda(String prefix) {
        return prefix + "new Lambda(() -> " + value + ").get()";
    }
    
}
