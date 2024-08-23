package strategy_pattern;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(String cardNumber, String cardHolderName, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean validate() {
        // Simple validation logic (e.g., check if card number is 16 digits)
        if (cardNumber.length() == 16 && cvv.length() == 3 && expiryDate.matches("\\d{2}/\\d{2}")) {
            System.out.println("Credit Card validated successfully.");
            return true;
        } else {
            System.out.println("Credit Card validation failed.");
            return false;
        }
    }

    @Override
    public void pay(int amount) {
        if (validate()) {
            System.out.println(amount + " paid with Credit Card.");
        } else {
            System.out.println("Payment failed due to invalid Credit Card.");
        }
    }
}
