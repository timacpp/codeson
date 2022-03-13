import codeson.processor.CodesonExecutor;

public class RootApproximation {
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
        return new CodesonExecutor("fastsqrt.json").execute();
    }
    
    public static void main(String[] args) {
        double rootJava = approximateRootJava();
        double rootCodeson = approximateRootCodeson();
        
        System.out.println(rootJava);
        System.out.println(rootCodeson);
    }
}
