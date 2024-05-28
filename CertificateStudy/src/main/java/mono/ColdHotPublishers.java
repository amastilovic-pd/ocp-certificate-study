package mono;

import reactor.core.publisher.Mono;

import java.util.logging.Logger;

public class ColdHotPublishers {

    private static final Logger log = Logger.getLogger(ColdHotPublishers.class.getName());

    public static void main(String[] args) {

        sampleMsg("test").subscribe();
    }

    private static Mono<String> sampleMsg(String str) {
        log.info("Call to Retrieve Sample Message!! -->" + str +  " at: " + System.currentTimeMillis());
        return Mono.just(str);
    }
}
