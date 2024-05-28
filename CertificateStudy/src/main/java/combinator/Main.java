package combinator;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Alice", "Mrs.", "");
        Customer customer2 = new Customer("Bob", "Mr.", "a@a");

        CustomerRegistrationValidator.ValidationResult result  = isValid(customer2);

        System.out.println(result);

        CustomerRegistrationValidator.ValidationResult valid = isValid(customer);
        System.out.println(valid);
    }

    private static CustomerRegistrationValidator.ValidationResult isValid(Customer customer) {
        return CustomerRegistrationValidator.isEmailValid()
                .and(CustomerRegistrationValidator.isNameValid())
                .and(CustomerRegistrationValidator.isTitleValid())
                .apply(customer);
    }
}
