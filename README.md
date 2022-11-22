# About the project

Codeson is an experimental programming language, where everything is an instruction corresponding to a numeric value.

# Example program

This is a fragment of code taken from example program `src/CodesonSqrt.json`:

```
"condition":{
    "type":"<",
    "larg":{
        "type":"+",
        "larg":{
            "type":"variable",
            "name":"low"
        },
        "rarg":{
            "type":"variable",
            "name":"epsilon"
        }
    },
    "rarg":{
        "type":"variable",
        "name":"high"
    }
}
```  

which is equivalent to the following Java code: `low + epsilon < high`, where `low`, `high` and `epsilon` are some variables.

    
# Numeric evaluation

Codeson converts instructions to the numbers the following way:

* Numbers and constants are equal to their value
* Operators are equal to the result
* Loops and blocks are equal to the last executed instruction
* Branching instructions are equal to the next codeflow instruction

Instruction can be chained and composed any number of times. Due to such explicit conversion of instructions to `double`, the following code pieces are valid in Codeson:

* `if (while(...) {...}) {...}`
* `{...} = while(...} {...} + if(...) {...}`
* `if(if(if(...)))`

where `...` can be substituted with any instruction, not resulting in division by zero.

# Codeson translation

The `src/codeson/CodesonTranslator.java` is responsible for translating Codeson to Java. After deserialization, translator creates a runnable Java file with nested `Supplier<Double>` (with alias `Lambda`). Here is a generated translation of the Codeson program piece mentioned in *Example program* section (for more, see `src/SqrtCodesonTranslated.java`):

```
new Lambda(() -> toDouble(new Lambda(() -> new Lambda(() -> variables.getOrDefault("low", 0.0)).get() + new Lambda(() -> variables.getOrDefault("epsilon", 0.0)).get()).get() < new Lambda(() -> variables.getOrDefault("high", 0.0)).get())).get() != 0.0
```

# Codeson execution
The `src/codeson/CodesonExecutor.java` can be used to execute a Codeson program. After deserialization, it retuns a single `double` value, unless division by zero occured.

# Codeson serialization
The `src/codeson/CodesonCloner.java` is able to serialize Codeson programs. Which means, if a Codeson program was previously deserialized, it can create an identicle program without copying the previous file content.






