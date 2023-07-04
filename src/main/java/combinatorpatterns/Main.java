package combinatorpatterns;

import combinatorpatterns.CustomerValidatorCustom.ValidationResult;

import java.time.LocalDate;

import static combinatorpatterns.CustomerValidatorCustom.*;

public class Main {
    public static void main(String[] args) {
        Customer customer =
                new Customer("Jorge",
                        "jorge123@hotmail.com",
                        "+03123",
                        LocalDate.of(2001, 1, 5));

        CustomerValidatorService validatorService = new CustomerValidatorService();
        System.out.println(validatorService.isValid(customer)); //Output : true

        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);
        if (result != ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
}
