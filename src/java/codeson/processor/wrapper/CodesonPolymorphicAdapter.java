package codeson.processor.wrapper;

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
        this.factory = PolymorphicJsonAdapterFactory.of(Instruction.class, "typ");
        this.addStorageSubtypes().addStatementSubtypes().addOperationSubtypes();
    }

    private CodesonPolymorphicAdapter addStorageSubtypes() {
        this.factory = factory.withSubtype(Constant.class, "Liczba")
                .withSubtype(Constant.class, "True")
                .withSubtype(Constant.class, "False")
                .withSubtype(Variable.class, "Zmienna");
        
        return this;
    }
    
    private CodesonPolymorphicAdapter addStatementSubtypes() {
        this.factory = factory.withSubtype(Assign.class, "Przypisanie")
                .withSubtype(Block.class, "Blok")
                .withSubtype(If.class, "If")
                .withSubtype(While.class, "While");
        
        return this;
    }
    
    private CodesonPolymorphicAdapter addOperationSubtypes() {
        return this.addArithmeticalSubtypes()
                .addLogicalSubtypes()
                .addRelationalSubtypes();
    }
    
    private CodesonPolymorphicAdapter addArithmeticalSubtypes() {
        this.factory = factory.withSubtype(Addition.class, "Plus")
                .withSubtype(Subtraction.class, "Minus")
                .withSubtype(Multiplications.class, "Razy")
                .withSubtype(Division.class, "Dzielenie");
        
        return this;
    }
    
    private CodesonPolymorphicAdapter addLogicalSubtypes() {
        this.factory = factory.withSubtype(And.class, "And")
                .withSubtype(Or.class, "Or")
                .withSubtype(Not.class, "Not");
        
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
