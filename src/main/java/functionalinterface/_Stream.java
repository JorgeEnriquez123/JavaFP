package functionalinterface;

import java.util.List;

import static functionalinterface._Stream.Species.GRIZZLY;
import static functionalinterface._Stream.Species.POLAR_BEAR;

public class _Stream {
    public static void main(String[] args) {
        Bear bear1 = new Bear("Grizz", GRIZZLY);
        Bear bear2 = new Bear("Polar", POLAR_BEAR);
        Bear bear3 = new Bear("Shiro", POLAR_BEAR);


        // * map -> Function<> Equivalent
        List<Bear> bearList = List.of(bear1, bear2, bear3);
        bearList.stream()
                .map(bear -> bear.name) // To map to Strings
                .mapToInt(String::length) // To convert to Int
                .forEach(System.out::println);
                /* Output: 5
                           5
                           5 */

        // * allMatch() - anyMatch() -> Predicate<> Equivalent
        boolean areAllPolarBears = bearList.stream()
                .allMatch(bear -> POLAR_BEAR.equals(bear.species));
        System.out.println(areAllPolarBears); // Output: false

        boolean areThereAnyPolarBears = bearList.stream()
                .anyMatch(bear -> POLAR_BEAR.equals(bear.species));
        System.out.println(areThereAnyPolarBears); //Output: true
    }



    static class Bear{
        private final String name;
        private final Species species;

        public Bear(String name, Species species) {
            this.name = name;
            this.species = species;
        }
    }
    enum Species{
        GRIZZLY, POLAR_BEAR
    }
}
