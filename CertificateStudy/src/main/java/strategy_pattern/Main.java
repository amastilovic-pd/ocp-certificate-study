package strategy_pattern;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(new PayPalPayment("test", "test"));
        cart.checkout(50);

        printDate();
        System.out.println(UUID.randomUUID());
    }

    //print date with only date
    public static void printDate() {
        LocalDateTime date = LocalDateTime.now();
        System.out.println(LocalDate.now());
    }
}
