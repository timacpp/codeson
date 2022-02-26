import language.Robson;

import java.io.IOException;

/*
    input.json - example ROBSON program used to calculate approximation of a
    square root of value with precision of epsilon in logarithmic time.
    Testing values are: value = 98695877281.0, epsilon = 1e-9.
    This program can be represented as the following Java code:
    
        double value = 98695877281.0
        double epsilon = 1e-9;
        double l = 0.0;
        double r = value;
        while (l + epsilon < r) {
            double m = (l + r) / 2;
            if (m * m <= value)
                l = m;
            else
                r = m;
        }
        System.out.println(l);    
*/

public class Main {
    public static void main(String[] args) {
        Robson robson = new Robson();
        try {
            robson.fromJSON("input.json");
            robson.toJSON("output.json");
            robson.toJava("Translation.java");
            System.out.println(robson.wykonaj());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
