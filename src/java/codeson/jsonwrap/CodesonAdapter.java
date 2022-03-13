package codeson.jsonwrap;

import codeson.structure.Instruction;
import codeson.structure.storage.*;

import com.squareup.moshi.Moshi;
import com.squareup.moshi.JsonAdapter;

import java.io.IOException;

/** Adapter from Json files to Codeson */
public class CodesonAdapter {
    private final JsonAdapter<Instruction> jsonAdapter;
    
    public CodesonAdapter() {
        this("");
    }
    
    public CodesonAdapter(String indent) {
        this.jsonAdapter = buildUnderlyingAdapter().indent(indent);
    }

    public Instruction fromCodeson(String filename) {
        try (CodesonReader reader = new CodesonReader(filename, "\\Z")) {
            return jsonAdapter.fromJson(reader.next());
        } catch (IOException e) {
            e.printStackTrace();
            return new Constant(0.0);
        }
    }
    
    public String toCodeson(Instruction program) {
        return jsonAdapter.toJson(program);
    }

    /**
     * Creates universal json adapter for implementations of Instruction interface.
     * @return json adapter for Codeson instructions
     */
    private static JsonAdapter<Instruction> buildUnderlyingAdapter() {
        CodesonPolymorphicAdapter factory = new CodesonPolymorphicAdapter();
        Moshi moshi = new Moshi.Builder().add(factory.getJsonFactory()).build();
        return moshi.adapter(Instruction.class);
    }
}
