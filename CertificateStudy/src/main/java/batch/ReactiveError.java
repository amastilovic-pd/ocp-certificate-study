package batch;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;


public class ReactiveError {

    public static void main(String[] args) {
        List<String> list = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        List<String> objects = List.of();
        batchesWithSublistConsumer(-1, 2).accept(objects);
    }

    private static Consumer<List<String>> batchesWithSublistConsumer(int totalItems, int batchSize) {
        return elements -> {
            AtomicInteger currBatch = new AtomicInteger(1);
            int endCount = (totalItems / batchSize) + 1;
            System.out.println("endCount" + endCount);

            Flux.range(0, endCount)
                    .mapNotNull(i -> elements.subList(i * batchSize, Math.min(totalItems, (i + 1) * batchSize)))
                    .concatMap(batch -> {
                        String sb =
//                            mainId +
//                            ";" +
                                String.join(";", batch);

                        System.out.println("printing batch" + currBatch.getAndIncrement() +":" + sb);
                        return Mono.just(sb);
                    })
                    .collectList()
                    .onErrorMap(RuntimeException.class, cause -> new ReactiveRuntimeException("from onErrorMap"))
                    .doOnError(error -> {
                        throw new ReactiveRuntimeException("from doOnError");
                    })
                    .mapNotNull(wrapper -> new BasicResponseDto<List<String>>(wrapper))
                    .defaultIfEmpty(new BasicResponseDto("empty"))
                    .subscribe();

            System.out.println("-----------------list-with-collectlist-----------------");
//        System.out.println(listMono.block());
//        listMono.subscribe();
            System.out.println("-----------------external-list-----------------");
//        System.out.println(idsList);
        };
    }

}
