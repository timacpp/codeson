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
					variables.put("root_squared", new Lambda(() -> 9.8695877281E10).get());
					return variables.get("root_squared");
				}).get();
				new Lambda(() -> {
					variables.put("epsilon", new Lambda(() -> 1.0E-9).get());
					return variables.get("epsilon");
				}).get();
				new Lambda(() -> {
					variables.put("low", new Lambda(() -> 0.0).get());
					return variables.get("low");
				}).get();
				new Lambda(() -> {
					variables.put("high", new Lambda(() -> variables.getOrDefault("root_squared", 0.0)).get());
					return variables.get("high");
				}).get();
				new Lambda(() -> {
					while (new Lambda(() -> toDouble(new Lambda(() -> new Lambda(() -> variables.getOrDefault("low", 0.0)).get() + new Lambda(() -> variables.getOrDefault("epsilon", 0.0)).get()).get() < new Lambda(() -> variables.getOrDefault("high", 0.0)).get())).get() != 0.0) {
						new Lambda(() -> {
							new Lambda(() -> {
								variables.put("mid", new Lambda(() -> new Lambda(() -> new Lambda(() -> variables.getOrDefault("low", 0.0)).get() + new Lambda(() -> variables.getOrDefault("high", 0.0)).get()).get() / new Lambda(() -> 2.0).get()).get());
								return variables.get("mid");
							}).get();
							return new Lambda(() -> new Lambda(() -> toDouble(new Lambda(() -> new Lambda(() -> variables.getOrDefault("mid", 0.0)).get() * new Lambda(() -> variables.getOrDefault("mid", 0.0)).get()).get() <= new Lambda(() -> variables.getOrDefault("root_squared", 0.0)).get())).get() != 0.0
								?
								new Lambda(() -> {
									variables.put("low", new Lambda(() -> variables.getOrDefault("mid", 0.0)).get());
									return variables.get("low");
								}).get()
								:
								new Lambda(() -> {
									variables.put("high", new Lambda(() -> variables.getOrDefault("mid", 0.0)).get());
									return variables.get("high");
								}).get()
								).get();
						}).get();
					}
					return 0.0;
				}).get();
				return new Lambda(() -> variables.getOrDefault("low", 0.0)).get();
			}).get()
        );
     }
}
