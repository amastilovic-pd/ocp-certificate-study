package chapter8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LambdaAccess {

    private String color;

    private void lambdaAccessLevel(String name) {
        String volume = "loud";
//        name = "Caty";
        color = "blue";

        Consumer<String> consumer = s ->
                System.out.println(name + volume + color);
    }
}
