package chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRef {

    public static void main(String[] args) {
        //method reference can be used on

        String st="";

        //static methods
        Function<Integer, Double> lambdaConverter = x -> Math.sqrt(x);
        Function<Integer, Double> referenceConverter = Math::sqrt;

        //Instance methods on a particular object
        List<String> testList = Arrays.asList("A", "B", "C");
        testList.forEach(x-> System.out.println(x));
        testList.forEach(System.out::println);

        //Instance methods on a parameter
        StringParameterCheck lambdaCheck = s -> s.isEmpty();
        StringParameterCheck methodRefCheck = String::isEmpty;

        //Constructor
        Supplier<List<String>> lambdaListSupplier = () -> new ArrayList<>();
        Supplier<List<String>> referenceListSupplier = ArrayList::new;
    }
}

interface StringParameterCheck {
    boolean check(String text);
}