package codeson;

import codeson.jsonwrap.CodesonAdapter;
import codeson.structure.Instruction;

/** Super-class for classes manipulating Codeson programs */
public abstract class CodesonProcessor {
    protected final Instruction program;

    public CodesonProcessor(String filename) {
        this.program = new CodesonAdapter().fromCodeson(filename);
    }
}
