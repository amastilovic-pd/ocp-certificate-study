package batch;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Batchrequest {

    static List<Long> durationList = new ArrayList<>();
    static List<Long> memoryList = new ArrayList<>();

    public static void main(String[] args) {
//        int batchSize = 3;
//        int index = 266;
//        List<Integer> integers = generateNumbers().get();
//
//        List<Integer> integers1 = integers.subList(index * batchSize, integers.size());
//        System.out.println(integers);
//        System.out.println(integers1);
//        for (int i = 0; i < 10; i++) {
            testMethodPerformance();

////        }
        calcPerformance(memoryList, durationList);
//        testFluxRange();
    }

    public static void testFluxRange(){
        Flux.range(0, 5)
                .map(i -> "item" + i)
                .subscribe(System.out::println);
    }

    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        // Convert the first character to uppercase and the rest to lowercase
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    private static void calcPerformance(List<Long> memory, List<Long> duration) {
        BigDecimal averageMemory = memory
                .stream()
                .map(a -> BigDecimal.valueOf(a).divide(BigDecimal.valueOf(memory.size())))
                .findFirst()
                .orElse(BigDecimal.ZERO);

        OptionalDouble averageDuration = duration
                .stream()
                .mapToDouble(a -> a)
                .average();
        long timeInMilliseconds = TimeUnit.MILLISECONDS.convert((long) averageDuration.getAsDouble(), TimeUnit.NANOSECONDS);
        System.out.println("average memory usage in bytes: " + averageMemory);
        System.out.println("average execution time in ns: " + averageDuration.getAsDouble());
        System.out.println("average time in milliseconds: " + timeInMilliseconds);
    }

    public static void testMethodPerformance() {
        List<String> ids = generateIds().get();
//        List<BasicResponseDto<String>> basicResponseDtos = generateObjects().get();
//        String mainId = ids.remove(0);
        final int batchSize = 20;
        final int totalItems = ids.size();

        System.out.println("Total items: " + totalItems);
        System.out.println("Batch size: " + batchSize);
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long startTime = System.nanoTime();

        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

//        batchesFromBuffer(ids, batchSize);
//        batchesWithSublistConsumer(totalItems, batchSize).accept(ids);
//        classicBatchesConsumer(totalItems, batchSize).accept(ids);
//        testStringBuilder(basicResponseDtos);
//        testStreamMap(basicResponseDtos);
//        testStringBuffer(basicResponseDtos);
        long endTime = System.nanoTime();
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long duration = endTime - startTime; // in nanoseconds
        long memoryUsed = usedMemoryAfter - usedMemoryBefore;
        long timeInSeconds = TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS);
        durationList.add(duration);
        memoryList.add(memoryUsed);

        System.out.println("Memory used: " + memoryUsed + " bytes");
        System.out.println("Execution time: " + duration + " ns");
        System.out.println("count:"+(totalItems + batchSize - 1) / batchSize);
        System.out.println("time in seconds: " + timeInSeconds);
    }

    private static void testStreamMap(List<BasicResponseDto<String>> objs) {
        List<String> ids = objs.stream()
                .map(BasicResponseDto::getData)
                .collect(Collectors.toList());
        System.out.println(ids);
    }

    private static void testStringBuilder(List<BasicResponseDto<String>> ids) {
        StringBuilder sb = new StringBuilder();
        for (BasicResponseDto<String> id : ids) {
            sb.append(id.getData()).append(",");
        }
        System.out.println(sb.toString());
    }

    private static void testStringBuffer(List<BasicResponseDto<String>> ids) {
        StringBuffer sb = new StringBuffer();
        for (BasicResponseDto<String> id : ids) {
            sb.append(id.getData()).append(",");
        }
        System.out.println(sb.toString());
    }

    static void writePerformanceResults(long memoryUsed, long duration) {
        String filePath = "performanceresults/sublist/results" +
                UUID.randomUUID() +
                ".txt";

        // The data to be written to the file
        String data = "performance results: " + memoryUsed + " bytes, " + duration + " ns";

        // FileWriter inside a try-with-resources statement to ensure proper resource management
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(data);
            System.out.println("Data has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void batchesFromBuffer(List<String> ids, int batchSize) {
        Flux.fromIterable(ids)
                .buffer(batchSize)
                .concatMap(batch -> {
                    String collect = String.join(";", batch);
                    String string = "first;" + collect;
                    System.out.println("printing batch:" + string);
                    return Mono.just(string);
                })
                .subscribe();
    }

    private static Consumer<List<String>> batchesFromBufferConsumer(List<String> ids, int batchSize) {
        return elements -> {
        Flux.fromIterable(ids)
                .buffer(batchSize)
                .concatMap(batch -> {
                    String collect = String.join(";", batch);
                    String string = "first;" + collect;
                    System.out.println("printing batch:" + string);
                    return Mono.just(string);
                })
                .subscribe();
        };
    }

    //this method takes less memory and time compared to batchesFromBuffer
    private static void batchesWithSublist(int totalItems, int batchSize, List<String> ids) {
        AtomicInteger currBatch = new AtomicInteger(1);
        int endCount = calculateOrderEndCount(totalItems, batchSize);
        System.out.println("endCount" + endCount);

        Flux.range(0, endCount)
                .mapNotNull(i -> ids.subList(i * batchSize, Math.min(totalItems, (i + 1) * batchSize)))
                .concatMap(batch -> {
                    String sb =
//                            mainId +
//                            ";" +
                            String.join(";", batch);

                    System.out.println("printing batch" + currBatch.getAndIncrement() +":" + sb);
//                    try {
//                        Thread.sleep(400);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    return Mono.just(sb);
                })
                .collectList()
                .subscribe();

        System.out.println("-----------------list-with-collectlist-----------------");
//        System.out.println(listMono.block());
//        listMono.subscribe();
        System.out.println("-----------------external-list-----------------");
//        System.out.println(idsList);
    }
    private static Consumer<List<String>> batchesWithSublistConsumer(int totalItems, int batchSize) {
        return elements -> {
        AtomicInteger currBatch = new AtomicInteger(1);
        int endCount = calculateOrderEndCount(totalItems, batchSize);
        System.out.println("endCount" + endCount);

        Flux.range(0, endCount)
                .mapNotNull(i -> elements.subList(i * batchSize, Math.min(totalItems, (i + 1) * batchSize)))
                .concatMap(batch -> {
                    String sb =
//                            mainId +
//                            ";" +
                            String.join(";", batch);

                    System.out.println("printing batch" + currBatch.getAndIncrement() +":" + sb);
//                    try {
//                        Thread.sleep(400);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    return Mono.just(sb);
                })
                .collectList()
                .subscribe();

        System.out.println("-----------------list-with-collectlist-----------------");
//        System.out.println(listMono.block());
//        listMono.subscribe();
        System.out.println("-----------------external-list-----------------");
//        System.out.println(idsList);
        };
    }

    private static void classicBatches(int totalItems, int batchSize, List<String> elements) {
        int endCount = calculateOrderEndCount(totalItems, batchSize);
        for (int page = 1; page <= endCount; page++) {
            List<String> pageContent = getPage(elements, page, batchSize);
            System.out.println("Page " + page + ": " + pageContent);
        }
    }
    private static Consumer<List<String>> classicBatchesConsumer(int totalItems, int batchSize) {
        return elements -> {
            int endCount = calculateOrderEndCount(totalItems, batchSize);
            for (int page = 1; page <= endCount; page++) {
                List<String> pageContent = getPage(elements, page, batchSize);
                System.out.println("Page " + page + ": " + pageContent);
            }
        };
    }

    public static List<String> getPage(List<String> list, int pageNumber, int pageSize) {
        int fromIndex = (pageNumber - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, list.size());
        return list.subList(fromIndex, toIndex);
    }

    public static Supplier<List<String>> generateIds() {
        return () -> {
            List<String> itemIds = new ArrayList<>();

            // Populate the itemIds list with sample data (800 items for testing)
            for (int i = 1; i <= 8000000; i++) {
                itemIds.add("item" + i);
            }
            return itemIds;
        };
    }

    public static Supplier<List<BasicResponseDto<String>>> generateObjects() {
        return () -> {
            List<BasicResponseDto<String>> itemIds = new ArrayList<>();

            // Populate the itemIds list with sample data (800 items for testing)
            for (int i = 1; i <= 8000000; i++) {
                itemIds.add(new BasicResponseDto<String>("item" + i));
            }
            return itemIds;
        };
    }

    public static Supplier<List<Integer>> generateNumbers() {
        return () -> {
            List<Integer> numbers = new ArrayList<>();

            // Populate the itemIds list with sample data (800 items for testing)
            for (int i = 1; i <= 800; i++) {
                numbers.add(i);
            }
            return numbers;
        };
    }

    private static int calculateOrderEndCount(int totalItems, int batchSize) {
        if(batchSize <= 0) {
            throw new RuntimeException("Batch size must be greater than 0");
        }

        double endCountDouble = (totalItems * 1.0) / (batchSize * 1.0);

        return (int)Math.ceil(endCountDouble);
    }
}
