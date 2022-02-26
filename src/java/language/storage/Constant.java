package language.storage;

import com.squareup.moshi.Json;
import language.Instruction;

import java.util.HashMap;

public class Constant implements Instruction {
    @Json(name = "wartosc")
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
