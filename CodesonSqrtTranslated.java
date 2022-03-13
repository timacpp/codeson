/** This code was generated automatically using CodesonTranslator class. */

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

public class CodesonSqrtTranslated {
    public static double toDouble(boolean value) {
        return (value ? 1.0 : 0.0);
    }

    public static void main(String[] args) {
        HashMap<String, Double> variables = new HashMap<>();
        System.out.println(
            			new Lambda(() -> {
				new Lambda(() -> {
					variables.put("value", new Lambda(() -> 9.8695877281E10).get());
					return variables.get("value");
				}).get();
				new Lambda(() -> {
					variables.put("epsilon", new Lambda(() -> 1.0E-9).get());
					return variables.get("epsilon");
				}).get();
				new Lambda(() -> {
					variables.put("l", new Lambda(() -> 0.0).get());
					return variables.get("l");
				}).get();
				new Lambda(() -> {
					variables.put("r", new Lambda(() -> variables.getOrDefault("value", 0.0)).get());
					return variables.get("r");
				}).get();
				new Lambda(() -> {
					while (new Lambda(() -> toDouble(new Lambda(() -> new Lambda(() -> variables.getOrDefault("l", 0.0)).get() + new Lambda(() -> variables.getOrDefault("epsilon", 0.0)).get()).get() < new Lambda(() -> variables.getOrDefault("r", 0.0)).get())).get() != 0.0) {
						new Lambda(() -> {
							new Lambda(() -> {
								variables.put("m", new Lambda(() -> new Lambda(() -> new Lambda(() -> variables.getOrDefault("l", 0.0)).get() + new Lambda(() -> variables.getOrDefault("r", 0.0)).get()).get() / new Lambda(() -> 2.0).get()).get());
								return variables.get("m");
							}).get();
							return new Lambda(() -> new Lambda(() -> toDouble(new Lambda(() -> new Lambda(() -> variables.getOrDefault("m", 0.0)).get() * new Lambda(() -> variables.getOrDefault("m", 0.0)).get()).get() <= new Lambda(() -> variables.getOrDefault("value", 0.0)).get())).get() != 0.0
								?
								new Lambda(() -> {
									variables.put("l", new Lambda(() -> variables.getOrDefault("m", 0.0)).get());
									return variables.get("l");
								}).get()
								:
								new Lambda(() -> {
									variables.put("r", new Lambda(() -> variables.getOrDefault("m", 0.0)).get());
									return variables.get("r");
								}).get()
								).get();
						}).get();
					}
					return 0.0;
				}).get();
				return new Lambda(() -> variables.getOrDefault("l", 0.0)).get();
			}).get()
        );
     }
}
