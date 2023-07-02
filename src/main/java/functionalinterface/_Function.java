package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        // ? -- Function<> --

        int increment = incrementByOne(1);
        System.out.println(increment); //Output: 2

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2); //Output: 2

        int increment3 = incrementThenMultiplyFunction.apply(2);
        System.out.println(increment3); //Output : 6

        // ? -- BiFuction<> --

        int increment4 = incrementByOneAndMultiplyBy.apply(4, 100);
        System.out.println(increment4); //Output: 500

        // ? -- Consumer<> --

        Bear bear = new Bear("Grizz", 6);
        introductionFunction.accept(bear);
        //Output: Your bear is Grizz and is 6 years old

        // ? -- BiConsumer<> --

        Bear bear2 = new Bear("Polar", 4);
        introductionFunctionOptions.accept(bear2, true);
        // Output: Your bear is Polar and is 4 years old

        introductionFunctionOptions.accept(bear2, false);
        // Output: Your bear is Polar
    }


    static int incrementByOne(int number){
        return number + 1;
    }

    // * ------ Function<T, R> -------

    // Function<Input, Output> functionName = operation;
    // functionName.apply(argument)
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;
    static Function<Integer, Integer> multiplyByTwoFunction = number -> number * 2;

    static Function<Integer, Integer> incrementThenMultiplyFunction = incrementByOneFunction.andThen(multiplyByTwoFunction);

    // * ---- BiFunction<T, U, R> ----
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBy =
            (toAdd, toMultiply) -> (toAdd + 1) * toMultiply;


    // ? -------------------------------

    // * ---- Consumer<T> ------
    static class Bear{
        private final String name;
        private final int age;

        public Bear(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    static Consumer<Bear> introductionFunction =
            bear -> System.out.println("Your bear is " + bear.name + " and is " + bear.age + " years old");

    // * ---- BiConsumer<T> -------
    static BiConsumer<Bear, Boolean> introductionFunctionOptions =
            (bear, showAge) ->
                    System.out.println("Your bear is " + bear.name +
                            (showAge ? " and is " + bear.age + " years old" : ""));

}
