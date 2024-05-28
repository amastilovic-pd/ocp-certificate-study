package chapter9.returninggenerics;

import java.util.ArrayList;
import java.util.List;

public class Mammal {
    public List<CharSequence> play() {
        List<CharSequence> l = new ArrayList<>();
        l.add("a");
        return l;
    }

    public CharSequence sleep() {

        return "a";
    }
}
