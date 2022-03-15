import codeson.CodesonCloner;
import codeson.CodesonTranslator;

/**
 * Example program translating a Codeson program to Java and
 * creating a clone of Codeson program using serialization.
 */
public class SqrtTranslationExample {
    public static void main(String[] args) {
        CodesonTranslator translator = new CodesonTranslator("CodesonSqrt.json");
        translator.translate("src/java/CodesonSqrtTranslated.java");
        
        CodesonCloner cloner = new CodesonCloner("CodesonSqrt.json");
        cloner.clone("CodesonSqrtCloned.json");
    }
}
