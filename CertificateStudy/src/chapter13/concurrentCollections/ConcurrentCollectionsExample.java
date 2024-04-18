package chapter13.concurrentCollections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentCollectionsExample {

    public void usingConcurrentCollections() {
        new ConcurrentHashMap<>();
        new ConcurrentSkipListSet<>();
    }

    public void usingSynchronizedCollections() {
        Set<String> syncSet = Collections.synchronizedSet(new HashSet<String>());
    }
}
