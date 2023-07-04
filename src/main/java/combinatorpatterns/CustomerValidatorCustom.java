package combinatorpatterns;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static combinatorpatterns.CustomerValidatorCustom.*;
import static combinatorpatterns.CustomerValidatorCustom.ValidationResult.*;

public interface CustomerValidatorCustom extends Function<Customer, ValidationResult> {

    static CustomerValidatorCustom isEmailValid() {
        return customer -> customer.getEmail().contains("@") ? SUCCESS : EMAIL_NOT_VALID;
    }
    static CustomerValidatorCustom isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().startsWith("+0") ? SUCCESS : PHONE_NUMBER_NOT_VALID;
    }
    static CustomerValidatorCustom isAnAdult() {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ? SUCCESS : IS_NOT_ADULT;
    }
    default CustomerValidatorCustom and(CustomerValidatorCustom other){
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }
    enum ValidationResult{
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_ADULT
    }
}
