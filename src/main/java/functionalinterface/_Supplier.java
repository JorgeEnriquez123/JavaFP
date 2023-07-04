package functionalinterface;

import java.util.Random;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(randomNumberSupplier.get());
    }
    static int randomNumber(){
        Random random = new Random();
        return random.nextInt(10); // from 0 to 9
    }
    static Supplier<Integer> randomNumberSupplier =
            () -> {
                Random rnd = new Random();
                return rnd.nextInt(10);
            };
    }
