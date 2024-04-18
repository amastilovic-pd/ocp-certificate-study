package chapter10;

import combinator.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStreams {

    public static void main(String[] args) {
        List<Customer> custs = new ArrayList<>();
        Customer customer = new Customer("test", "Mr", "");
        Customer customer2 = new Customer("test1", "Mr", "");
        Customer customer3 = new Customer("test3", "Mr", "");
        Customer customer4 = new Customer("test4", "Mr", "");
        Customer customer5 = new Customer("test5", "Mr", "");
        Customer customer6 = new Customer("test6", "Mr", "");

        custs.addAll(Arrays.asList(customer, customer2, customer3, customer4, customer5, customer6));

        Map<String, String> collect = custs.stream()
                .filter(c -> c.getName().contains("1") || c.getName().contains("3"))
                .collect(Collectors.toMap(Customer::getName, c -> c.getTitle()));

//        System.out.println(collect);

        custs.stream()
                .filter(c -> c.getName().contains("1") || c.getName().contains("3") || c.getName().contains("5"))
                .allMatch(c -> {
                    System.out.println(c.getName());
                    return true;
                });
        // types of primitive streams
        BinaryOperator<String> binary = (x, y) -> x.concat(y);
        UnaryOperator<String> unary = x -> x.toUpperCase();
        // IntStream - used for int, short, byte, char
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//
//        int[] primitiveNums = numbers.stream()
//                .mapToInt(Integer::valueOf)
//                .toArray();
//
//        // map primitive int to long
//        long[] longsArray = IntStream.of(primitiveNums)
//                .mapToLong(x->x*x)
//                .toArray();
//
//        IntSummaryStatistics intSummaryStatistics = IntStream.of(primitiveNums)
//                .summaryStatistics();
//
//        System.out.println(intSummaryStatistics.getMax());
//        System.out.println("Primitive ints: " + Arrays.toString(primitiveNums));
//
//        // LongStream - used for long
//        List<Long> floatNums = Arrays.asList(10L, 5L, 20L, 15L, 25L);
//
//        OptionalLong optionalLong = floatNums.stream()
//                .mapToLong(Long::longValue)
//                .max();
//
//        long[] longs = LongStream.of(optionalLong.orElseThrow())
//                .filter(f -> f > 5f)
//                .toArray();
//
//        System.out.println("Maximum long value: " + optionalLong.orElseThrow());
//
//        long sum = LongStream.of(1, 2, 3)
//                .sum();
//        System.out.println(sum);
//
//        // DoubleStream - used for double and float
//        List<Double> values = Arrays.asList(1.2, 2.5, 3.8, 4.1, 5.4);
//
//        double average = values.stream()
////                .mapToDouble(x->x.doubleValue())
//                .mapToDouble(Double::doubleValue)
//                .average()
//                .orElse(Double.NaN);
//
//        OptionalDouble firstDouble = DoubleStream.of(average)
//                .findFirst();
//
//        System.out.println("Average double value: " + average);
//
//        Stream<Integer> s = Stream.of(1);

//        s.reduce();

//        List<String> list = List.of("a", "b", "c", "d");
//        ArrayList<String> arr = new ArrayList<>(list);
//        System.out.println(arr);
//        changeString(arr);
//        System.out.println(arr);

        IntStream.rangeClosed(1, 1000)
                .mapToObj(String::valueOf)
                .forEach(System.out::println);
    }

    public static void changeString(List<String> s) {
        s.add("e");
    }

    void advancedStreams() {
        Stream<String> stringStream = Stream.of("test1", "test2", "test3");
        TreeMap<Integer, Set<String>> collect = stringStream.collect(Collectors.groupingBy(
                String::length,
                TreeMap::new,
                Collectors.toSet()));
        System.out.println(collect);
    }


}
