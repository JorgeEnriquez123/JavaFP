package functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static functionalinterface._Predicate.Species.*;

public class _Predicate {
    public static void main(String[] args) {
        Bear bear1 = new Bear("Grizz", GRIZZLY);
        Bear bear2 = new Bear("Polar", POLAR_BEAR);
        Bear bear3 = new Bear("Shiro", POLAR_BEAR);

        // * BIPREDICATE<>
        System.out.println(areSameSpecies.test(bear1, bear2)); //Output: false
        System.out.println(areSameSpecies.test(bear2, bear3)); //Output: true


        // * WITH AND()
        System.out.println(isPolarBearPredicate.and(isNamedPolar).test(bear2)); //Output: true

        System.out.println(isPolarBearPredicate.and(isNamedPolar).test(bear3)); //Output: false

        // * WITH PREDICATE<>
        System.out.println(isPolarBearPredicate.test(bear1)); //Output: false
        System.out.println(isPolarBearPredicate.test(bear2)); //Output: true


        // * WITHOUT PREDICATE<>
        System.out.println(isPolarBear(bear1));
        System.out.println(isPolarBear(bear2));

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

    static boolean isPolarBear(Bear bear){
        return bear.species.equals(POLAR_BEAR);
    }
    static Predicate<Bear> isPolarBearPredicate =
            bear -> bear.species.equals(POLAR_BEAR);
    static Predicate<Bear> isNamedPolar =
            bear -> bear.name.equals("Polar");

    static BiPredicate<Bear, Bear> areSameSpecies =
            (bear1, bear2) -> bear1.species.equals(bear2.species);
}
