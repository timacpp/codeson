package language;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory;

import language.operation.arithmetical.*;
import language.operation.logical.*;
import language.operation.relational.*;
import language.statement.*;
import language.storage.*;
import language.util.*;

public class Robson {
    private Instruction program; // Field is set outside of constructor

    /* This constructor is needed in case of usage 'fromJSON()' method. */
    public Robson() {
        this.program = null;
    }
    
    /* Construction of universal adapter for all superclasses of Instruction interface. */
    private JsonAdapter<Instruction> buildJSONAdapter() {
        Moshi moshi = new Moshi.Builder()
                .add(
                        PolymorphicJsonAdapterFactory.of(Instruction.class, "typ")
                                .withSubtype(Constant.class, "Liczba")
                                .withSubtype(Constant.class, "True")
                                .withSubtype(Constant.class, "False")
                                .withSubtype(Variable.class, "Zmienna")
                                .withSubtype(Assign.class, "Przypisanie")
                                .withSubtype(Block.class, "Blok")
                                .withSubtype(If.class, "If")
                                .withSubtype(While.class, "While")
                                .withSubtype(Addition.class, "Plus")
                                .withSubtype(Subtraction.class, "Minus")
                                .withSubtype(Multiplications.class, "Razy")
                                .withSubtype(Division.class, "Dzielenie")
                                .withSubtype(And.class, "And")
                                .withSubtype(Or.class, "Or")
                                .withSubtype(Not.class, "Not")
                                .withSubtype(Less.class, "<")
                                .withSubtype(LessOrEqual.class, "<=")
                                .withSubtype(Greater.class, ">")
                                .withSubtype(GreaterOrEqual.class, ">=")
                                .withSubtype(Equal.class, "==")
                                .withSubtype(Unequal.class, "!=")
                )
                .build();
        return moshi.adapter(Instruction.class);
    }
    
    /* Import ROBSON program 'filename' to Java class language structure. */
    public void fromJSON(String filename) throws IOException, InvalidProgram {
        JsonAdapter<Instruction> adapter = buildJSONAdapter();
        
        /* Reading the whole file to the string. */
        Scanner scanner = new Scanner(new File(filename)).useDelimiter("\\Z");
        String jsonProgram = scanner.next();

        program = adapter.fromJson(jsonProgram);
        scanner.close();
    }

    /* Export imported ROBSON program to JSON file named 'filename'. */
    public void toJSON(String filename) throws IOException {
        JsonAdapter<Instruction> adapter = buildJSONAdapter();
        
        /* Writing formatted JSON program to the file. */
        String jsonProgram = adapter.indent("\t").toJson(program);
        FileWriter output = new FileWriter(filename);
        
        output.write(jsonProgram);
        output.close();
    }

    private static String getStringConvertedImports() {
        return """
                import java.util.HashMap;
                import java.util.function.Supplier;

                """;
    }

    private static String getStringConvertedLambdaClass() {
        return """
                class Lambda {
                \tprivate final Supplier<Double> function;

                \tpublic Lambda(Supplier<Double> function) {
                \t\tthis.function = function;
                \t}

                \tpublic Double get() {
                \t\treturn function.get();
                \t}
                }

                """;
    }

    /* Note: non static function, attribute 'program' is used. */
    private String getStringConvertedMainClass(String filename) {
        return "public class " + filename.substring(0, filename.length() - ".java".length()) + " {\n" +
                "\tpublic static double toDouble(boolean value) {\n" +
                "\t\treturn (value ? 1.0 : 0.0);\n" +
                "\t}\n\n" +
                "\tpublic static void main(String[] args) {\n" +
                "\t\tHashMap<String, Double> variables = new HashMap<>();\n" +
                "\t\tSystem.out.println(\n" +
                program.toLambda("\t\t\t") + "\n" +
                "\t\t);\n" +
                "\t}" +
                "\n}";
    }

    /* Export imported ROBSON program to Java file named 'filename'. */
    public void toJava(String filename) throws IOException {
        FileWriter output = new FileWriter(filename);
        output.write(getStringConvertedImports() +
                getStringConvertedLambdaClass() +
                getStringConvertedMainClass(filename));

        output.close();
    }

    /* Perform imported ROBSON program to get a numerical result. */
    public double wykonaj() throws ProgramFailed {
        /* Empty hashmap is required to store values
        of variables on which program operates. */
        return program.execute(new HashMap<String, Double>());
    }
}
