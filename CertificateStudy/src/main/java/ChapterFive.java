import java.util.logging.Logger;

import static java.lang.Math.round;

class GiraffeFamily {
    static {
        System.out.print("A");
    }
    {
        System.out.print("B");
    }

    public GiraffeFamily(String name) {
        this(1);
        System.out.print("C");
    }

    public GiraffeFamily() {
        System.out.print("D");
    }

    public GiraffeFamily(int stripes) {
        System.out.print("E");
    }
}

class Giraffe extends GiraffeFamily {
    static {
        System.out.print("F");
    }

    public Giraffe(int stripes) {
        super("stripes");
        System.out.print("G");
    }

    {
        System.out.print("H");
    }
}

public class ChapterFive {

    Logger log = Logger.getLogger(this.getClass().getName());
    public static final int NUM_SECONDS;
    public static final int NUM_MINUTES;
    public static final int NUM_HOURS;
    public static final int NUM_FOUR = 4;

    static {
        NUM_SECONDS = 2;
        NUM_MINUTES = 4;
        NUM_HOURS = 3;
//        NUM_FOUR = 5;
    }
// page 303 inheritance prints
// a f b e c h g
// b e c h g
    public static void main(String[] args) {
//        round()
        new Giraffe(1);
//        System.out.println();
//        new Giraffe(2);
    }
}
