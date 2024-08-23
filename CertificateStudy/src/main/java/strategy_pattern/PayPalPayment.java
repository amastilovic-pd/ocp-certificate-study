package strategy_pattern;

public class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean validate() {
        // Simple validation logic (e.g., check if email contains '@')
        if (email.contains("@") && password.length() > 6) {
            System.out.println("PayPal account validated successfully.");
            return true;
        } else {
            System.out.println("PayPal account validation failed.");
            return false;
        }
    }

    @Override
    public void pay(int amount) {
        if (validate()) {
            System.out.println(amount + " paid with PayPal.");
        } else {
            System.out.println("Payment failed due to invalid PayPal account.");
        }
    }
}
