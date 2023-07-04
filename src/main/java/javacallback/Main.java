package javacallback;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        hello("Grizz", null, value -> System.out.println("No species found for " + value));

        hello2("Polar", null, () -> System.out.println("No species found!"));
    }
    static void hello2(String name, String species, Runnable callback){
        System.out.println(name);
        if(species != null){
            System.out.println(species);
        }
        else {
            callback.run();
        }
    }

    static void hello(String name, String species, Consumer<String> callback){
        System.out.println(name);
        if(species != null){
            System.out.println(species);
        }
        else {
            callback.accept(name);
        }
    }


}
