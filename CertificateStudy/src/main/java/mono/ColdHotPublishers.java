package mono;

import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.logging.Logger;

public class ColdHotPublishers {

    private static final Logger log = Logger.getLogger(ColdHotPublishers.class.getName());

    public static void main(String[] args) {

//        sampleMsg("test").subscribe();
        chainedThen().subscribe();
//        testEmpty()
//                .thenReturn("s")
//                .switchIfEmpty(Mono.error(new IllegalArgumentException("Empty")))
//                .subscribe();

//        String[] arr = {"1", "2", "3"};
//        if(arr.length != 0) {
//            System.out.println(Arrays.toString(arr));
//        }
//        String emptystr = "qwee";
//
//        String[] split = emptystr.split(";");
//        System.out.println(Arrays.toString(split));
    }

    private static Mono<String> sampleMsg(String str) {
        log.info("Call to Retrieve Sample Message!! -->" + str + " at: " + System.currentTimeMillis());
        return Mono.just(str);
    }

    private static Mono<String> chainedThen() {
//        return Flux.fromIterable(List.of("1", "2", "3"))
//                .concatMap(x -> x.equals("2")
//                        ? printShit(x).delayElement(Duration.ofSeconds(2))
//                        : printShit(x))
//                .flatMap(x -> printShit("void"))

        return Mono.just("delayed")
                .flatMap(x -> printMessage(x).delayElement(Duration.ofSeconds(2))
                        .then(printMessage("first then after delay"))
                )
                .flatMap(x -> printMessage("flatMap after flatMap"))
                .then(printMessage("after flatmap"))
                .then(printMessage("THEN WITH DELAY").delayElement(Duration.ofSeconds(2))
                .then(printMessage("THEN AFTE DELAY"))
                .then(printMessage("" + new Object().hashCode()))
                .log()
                .then(Mono.defer(() -> printMessage("mono defer after flatmap")))
                .log()
                .then(printMessage("after mono defer"))
                .thenReturn(printMessageBasic("after flatmap after then after mono defer after then")));
    }

    private static Mono<Void> printMessage(String num) {
        log.info("inside printMessage() method -->" + num);

        return Mono.just(num).then();
    }

    private static String printMessageBasic(String num) {
        log.info("inside printMessageBasic() method -->" + num);
        return "inside printMessageBasic() method -->" + num;
    }

    private static Mono<Void> testEmpty() {
        return Mono.just("s").then();
    }
}
