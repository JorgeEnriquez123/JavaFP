package optionals;


import java.util.NoSuchElementException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Object text1 = Optional.ofNullable("Jorge").orElse("Unkown name");
        System.out.println(text1); // Output: Jorge | // Output: Unkown name (If value = null)

        Object text2 = Optional.ofNullable("Jorge").orElseGet(() -> "Unknown name");
        System.out.println(text2); // Output: Jorge | // Output: Unknown name (If value = null)

        Object text3 = Optional.ofNullable("Jorge")
                .orElseThrow(() -> new NoSuchElementException("Value not present"));
        System.out.println(text3); // Output: Jorge | // Output: Exception (If value = null)

        Optional.ofNullable("Jorge")
                .ifPresent(System.out::println);
                // Output : "Jorge"

        Optional.ofNullable(null)
                .ifPresentOrElse(System.out::println, () -> System.out.println("No email"));
                // Output : "No email"
    }

}
