package streamschapter;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsChapter {

    public static void main(String[] args) {
//        peekStream();
 //        streamReduce();
//        streamCollect();
//        streamJoining();
//        streamCollectToMap();
//        streamCollectToMapWithDuplicateValues();
//        streamCollectGroupingBy();
//        streamCollectPartitioningBy();
//        streamCollectMapTo();

        int[] arr = {1, 5, 3, 2, 4};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        ReferenceTest<List<String>> listReferenceTest = null;

        listReferenceTest = new ReferenceTest<>();
        List<String> list = new LinkedList<>();
        listReferenceTest.setValue(list);

        list.add("test");
        System.out.println(listReferenceTest);
    }

    static void peekStream() {
        List<Integer> list = Arrays.asList(86, 101, 55, 107);

        list.stream()
                .peek(System.out::println)
                .filter(temp -> temp > 100)
                .peek(System.out::println)
                .count();

    }

    static void streamReduce() {
        Stream<String> stringStream = Stream.of("test1", "test2", "test3");

        // in first iteration,
        // s is initial "" value (known as identity)
        // c is first value from stream (which is "test1")
        String reduce = stringStream.reduce("", (s, c) -> s + c);
//        String reduce = stringStream.reduce("", String::concat);
//        String reduce = stringStream.reduce(new StringBuilder(), StringBuilder::append, StringBuilder::append).toString();
        System.out.println(reduce);
    }

    static void streamCollect() {
        Stream<String> stringStream = Stream.of("test1", "test2", "test3");

        StringBuilder stringBuilder = stringStream.collect(
                () -> new StringBuilder(),      // StringBuilder::new
                (sb, str) -> sb.append(str),    // StringBuilder::append
                (sb1, sb2) -> sb1.append(sb2)); // StringBuilder::append

        System.out.println(stringBuilder);
    }

    static void streamJoining() {
        Stream<String> stringStream = Stream.of("test1", "test2", "test3");

        String collect = stringStream.collect(Collectors.joining(", "));

        System.out.println(collect);
    }

    static void streamCollectToMap() {
        Stream<String> stringStream = Stream.of("test1", "test2", "test3");

        Map<String, Integer> collect = stringStream.collect(Collectors.toMap(
                s -> s,             // Function for the key
                s -> s.length()));  // Function for the value

        System.out.println(collect);
    }

    static void streamCollectToMapWithDuplicateValues() {
        Stream<String> stringStream = Stream.of("test1", "test2", "test3", "t");

        Map<Integer, String> collect = stringStream.collect(Collectors.toMap(
                s -> s.length(),             // Key is the length
                s -> s,                      // value is the String
                (s1, s2) -> s1 + "," + s2)); // merge function - what to do if we have duplicate keys
        // in this case, if values have same length,
        // they will be merged into single string and displayed as one value

        System.out.println(collect);
    }

    static void streamCollectGroupingBy() {
        Supplier<Stream<String>> streamSupplier = () -> Stream.of("test1", "test2", "test3", "t");

        Map<Integer, List<String>> collectList = streamSupplier.get().collect(
                // passing in a function that determines key in a map
                // in this case its length, and if values have same length
                // they will be grouped into a single list (list is by default)
                Collectors.groupingBy(String::length)); // s -> s.length()

        TreeMap<Integer, Set<String>> collectSet = streamSupplier.get().collect(
                // passing in a function that determines key in a map
                // in this case its length, and if values have same length
                // they will be grouped into a single list (list is by default)
                Collectors.groupingBy(
                        String::length,         // s -> s.length()
                        TreeMap::new,           // map type supplier returns TreeMap instead of HashMap
                        Collectors.toSet()));   // downstream collector -> values are collected as set instead of default list

        System.out.println("groupingBy as list: " + collectList);
        System.out.println("groupingBy as set: " + collectSet);
    }

    static void streamCollectPartitioningBy() {
        Supplier<Stream<String>> streamSupplier = () -> Stream.of("test1", "test2", "test3", "t");

        Map<Boolean, List<String>> collect = streamSupplier.get()
                .collect(
                        // partitioning by takes predicate
                        // returns map with two keys
                        // first key is false, where value is list of all false values from predicate
                        // second key is true, where value is list of all true values from predicate
                        Collectors.partitioningBy(s -> s.length() > 3));

        Map<Boolean, Set<String>> collectSet = streamSupplier.get()
                .collect(
                        // partitioning by takes predicate
                        // returns map with two keys
                        // first key is false, where value is list of all false values from predicate
                        // second key is true, where value is list of all true values from predicate
                        Collectors.partitioningBy(
                                s -> s.length() > 3,
                                Collectors.toSet())); // downstream collector -> values are stored in a set instead of default list

        System.out.println("partitioningBy: " + collect);
    }

    static void streamCollectMapTo() {
        Supplier<Stream<String>> streamSupplier = () -> Stream.of("test1", "test2", "test3", "t");

//        streamSupplier.get().map(tree -> (double) tree.length()).forEach(System.out::println);
        streamSupplier.get().mapToDouble(tree -> tree.length()).forEach(System.out::println);
        Hashtable<String, String> ht = new Hashtable<>();
//        System.out.println("partitioningBy: " + collect);

    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;
        return i + 1;
    }

    private static void bubbleSort(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


}
