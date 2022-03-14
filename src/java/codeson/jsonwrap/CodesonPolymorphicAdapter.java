package codeson.jsonwrap;

import codeson.structure.Instruction;
import codeson.structure.operation.arithmetical.*;
import codeson.structure.operation.logical.*;
import codeson.structure.operation.relational.*;
import codeson.structure.statement.*;
import codeson.structure.storage.*;

import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory;

/** Wrapper for PolymorphicJsonAdapterFactory of Codeson instructions */
public class CodesonPolymorphicAdapter {
    private PolymorphicJsonAdapterFactory<Instruction> factory;
    
    public CodesonPolymorphicAdapter() {
        this.factory = PolymorphicJsonAdapterFactory.of(Instruction.class, "type");
        this.addStorageSubtypes().addStatementSubtypes().addOperationSubtypes();
    }

    private CodesonPolymorphicAdapter addStorageSubtypes() {
        this.factory = factory.withSubtype(Variable.class, "variable")
                .withSubtype(Constant.class, "number");
        
        return this;
    }
    
    private CodesonPolymorphicAdapter addStatementSubtypes() {
        this.factory = factory.withSubtype(Assign.class, "=")
                .withSubtype(Block.class, "block")
                .withSubtype(If.class, "if")
                .withSubtype(While.class, "while");
        
        return this;
    }
    
    private CodesonPolymorphicAdapter addOperationSubtypes() {
        return this.addArithmeticalSubtypes()
                .addLogicalSubtypes()
                .addRelationalSubtypes();
    }
    
    private CodesonPolymorphicAdapter addArithmeticalSubtypes() {
        this.factory = factory.withSubtype(Addition.class, "+")
                .withSubtype(Subtraction.class, "-")
                .withSubtype(Multiplication.class, "*")
                .withSubtype(Division.class, "/");
        
        return this;
    }
    
    private CodesonPolymorphicAdapter addLogicalSubtypes() {
        this.factory = factory.withSubtype(And.class, "&&")
                .withSubtype(Or.class, "||")
                .withSubtype(Not.class, "!");
        
        return this;
    }
    
    private CodesonPolymorphicAdapter addRelationalSubtypes() {
        this.factory = factory.withSubtype(Less.class, "<")
                .withSubtype(LessOrEqual.class, "<=")
                .withSubtype(Greater.class, ">")
                .withSubtype(GreaterOrEqual.class, ">=")
                .withSubtype(Equal.class, "==")
                .withSubtype(Unequal.class, "!=");
        
        return this;
    }
    
    public PolymorphicJsonAdapterFactory<Instruction> getJsonFactory() {
        return factory;
                
    }
}
