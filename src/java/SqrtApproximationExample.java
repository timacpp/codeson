import codeson.CodesonExecutor;

/** 
 * Example program comparing the evaluation of a square root
 * using binary search in Java and Codeson.
 */
public class SqrtApproximationExample {
    static private final double ROOT_SQUARED = 98695877281.0;
    static private final double EPSILON = 1e-9;
    
    private static double approximateRootJava() {
        double low = 0.0, high = ROOT_SQUARED;

        while (low + EPSILON < high) {
            double mid = (low + high) / 2;
            
            if (mid * mid <= ROOT_SQUARED) {
                low = mid;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
    
    private static double approximateRootCodeson() {
        return new CodesonExecutor("CodesonSqrt.json").execute();
    }
    
    public static void main(String[] args) {
        System.out.println("Result in Java: " + approximateRootJava());
        System.out.println("Result in Codeson: " + approximateRootCodeson());
    }
}
