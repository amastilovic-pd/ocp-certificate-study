package chapter9.returninggenerics;

import java.util.List;

public class Goat extends Mammal {
    @Override
    public List<CharSequence> play() {
        return super.play();
    }

    // ne radi kako treba jbg
    @Override
    public CharSequence sleep() {
        return super.sleep();
    }
}
