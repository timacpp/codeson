import codeson.processor.CodesonExecutor;

/** 
 * Example program comparing the evaluation of a square root
 * using binary search in Java and Codeson.
 */

public class SqrtApproximationExample {
    static private final double ROOT_SQUARED = 98695877281.0;
    static private final double PRECISION = 1e-9;
    
    private static double approximateRootJava() {
        double l = 0.0, r = ROOT_SQUARED;

        while (l + PRECISION < r) {
            double m = (l + r) / 2;
            
            if (m * m <= ROOT_SQUARED) {
                l = m;
            } else {
                r = m;
            }
        }
        
        return l;
    }
    
    private static double approximateRootCodeson() {
        return new CodesonExecutor("CodesonSqrt.json").execute();
    }
    
    public static void main(String[] args) {
        System.out.println("Result in Java: " + approximateRootJava());
        System.out.println("Result in Codeson: " + approximateRootCodeson());
    }
}
