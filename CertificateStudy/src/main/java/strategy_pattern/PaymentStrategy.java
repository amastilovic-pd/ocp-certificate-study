package strategy_pattern;

public interface PaymentStrategy {
    boolean validate();
    void pay(int amount);
}
