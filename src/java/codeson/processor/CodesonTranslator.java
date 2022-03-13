package codeson.processor;

import java.io.FileWriter;
import java.io.IOException;

/** Class for translating Codeson program to executable Java code */
public class CodesonTranslator extends CodesonProcessor {
    public CodesonTranslator(String filename) {
        super(filename);
    }
    
    /**
     * Translates a Codeson program to Java file.
     * @param filename name of Java file to create.
     */
    public void translate(String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            String programTranslated = program.toLambda("\t\t\t");
            String className = filename.substring(0, filename.length() - ".java".length());
            writer.write(constructTranslation(className, programTranslated));
        }
    }
    
    private static String constructTranslation(String className, String program) {
        return String.format(
                """
                import java.util.HashMap;
                import java.util.function.Supplier;
                        
                class Lambda {
                    private final Supplier<Double> function;
                    
                    public Lambda(Supplier<Double> function) {
                            this.function = function;
                    }
                        
                    public Double get() {
                        return function.get();
                    }
                }
                                        
                public class %s {
                    public static double toDouble(boolean value) {
                        return (value ? 1.0 : 0.0);
                    }
                    
                    public static void main(String[] args) {
                        HashMap<String, Double> variables = new HashMap<>();
                        System.out.println(
                            %s
                        );
                     }
                }
                """, className, program);
    }
}
