package chapter7;

import java.util.function.Consumer;

public sealed class MySealedClass permits MyNonSealedClass {

    public void prntsmth() {

        System.out.println("MySealedClass print");
    }
}
