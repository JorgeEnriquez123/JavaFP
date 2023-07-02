package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static imperative.JavaImp.Species.*;

public class JavaImp {
    public static void main(String[] args) {
        List<Bear> bears = List.of(
                new Bear("Grizz", 5, GRIZZLY),
                new Bear("Shiro", 7, POLAR),
                new Bear("Shadow", 3, BLACK),
                new Bear("Rocky", 2, GRIZZLY),
                new Bear("Luna", 8, GRIZZLY),
                new Bear("Frost", 4, POLAR)
        );

        // ! GET POLAR BEARS - IMPERATIVE

        System.out.println("// IMPERATIVE APPROACH");
        List<Bear> polarBears = new ArrayList<>();
        for (Bear bear : bears){
            if(POLAR.equals(bear.species)){
                polarBears.add(bear);
            }
        }
        for (Bear polarbears : polarBears){
            System.out.println(polarbears);
        }

        // * GET POLAR BEARS - DECLARATIVE

        System.out.println("// DECLARATIVE APPROACH");
        bears.stream()
                .filter(bear -> POLAR.equals(bear.species))
                .forEach(System.out::println);
        // --------------- THEY ARE THE SAME ----------------------------
        Predicate<Bear> bearPredicate = bear -> POLAR.equals(bear.species);
        bears.stream()
                .filter(bearPredicate)
                .forEach(System.out::println);
    }

    static class Bear {
        private final String name;
        private final int age;
        private final Species species;

        public Bear(String name, int age, Species species) {
            this.name = name;
            this.age = age;
            this.species = species;
        }

        @Override
        public String toString() {
            return "Bear{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", species=" + species +
                    '}';
        }
    }

    enum Species{
        GRIZZLY, POLAR, BLACK
    }
}
