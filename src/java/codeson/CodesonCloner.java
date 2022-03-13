package codeson;

import codeson.jsonwrap.CodesonAdapter;

import java.io.FileWriter;
import java.io.IOException;

/** Class for serialization of a Codeson program */
public class CodesonCloner extends CodesonProcessor {
    public CodesonCloner(String filename) {
        super(filename);
    }
    
    public void clone(String filename) {
        String textProgram = new CodesonAdapter("\t").toCodeson(program);
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(textProgram);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
