package combinator;

import java.util.function.Function;

public interface CustomerRegistrationValidator extends Function<Customer, CustomerRegistrationValidator.ValidationResult> {

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@") ?
                ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isTitleValid() {
        return customer -> customer.getTitle().equals("Mr.") || customer.getTitle().equals("Mrs.") ?
                ValidationResult.SUCCESS : ValidationResult.IS_NOT_AN_ADULT;
    }

    static CustomerRegistrationValidator isNameValid() {
        return customer -> customer.getName().isEmpty() ?
                ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
        };
    }

    default String or() {
        return "";
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
