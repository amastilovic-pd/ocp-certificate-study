package io.serialixation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class Owner implements Serializable {

//    private static final long serialVersionUID = 2L;

    private String name;
    private Gorilla gorilla;
    private int age;

    public Owner(String name, Gorilla gorilla) {
        this.name = name;
        this.gorilla = gorilla;
    }

    public static void main(String[] args) {
        Owner owner = new Owner(null, null);
        System.out.println(owner.name);

        Random r = new Random();

        Predicate<String> pd = s -> s.contains("a");
        pd.negate();
//        pd.test();
        Function<Integer, Integer> fn = x->x+x;
//        fn.compose();
        LongUnaryOperator lg = x->1;

        List<Integer> integers = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", gorilla=" + gorilla +
                '}';
    }
}
