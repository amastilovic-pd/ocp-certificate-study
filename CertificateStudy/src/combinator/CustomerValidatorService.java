package combinator;

public class CustomerValidatorService {

        private boolean isEmailValid(String email) {
            return email.contains("@");
        }

        private boolean isNameValid(String name) {
            return !name.isEmpty();
        }

        private boolean isTitleValid(String title) {
            return title.equals("Mr.") || title.equals("Mrs.");
        }

        public boolean isValid(Customer customer) {
            return isEmailValid(customer.getEmail()) &&
                    isNameValid(customer.getName()) &&
                    isTitleValid(customer.getTitle());
        }
}
