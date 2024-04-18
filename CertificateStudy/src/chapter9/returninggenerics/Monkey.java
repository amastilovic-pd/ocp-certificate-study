package chapter9.returninggenerics;

import java.util.ArrayList;
import java.util.List;

public class Monkey extends Mammal {
    @Override
    public ArrayList<CharSequence> play() {
        return null;
    }

    @Override
    public CharSequence sleep() {
        return super.sleep();
    }
}
