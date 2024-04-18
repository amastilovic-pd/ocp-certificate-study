import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Logger;

enum Fruit {

    APPLE("asdEEEEEEEEE"),
    ORANGE("asd"),
    BANANA("asd"),
    LEMON("test");

    private final String tst;

    Fruit(String test) {
        this.tst = test;
    }

    public void printExpectedVisitors(){
        System.out.println(tst);
    }
}

enum B { APPLE, ORANGE, BANANA, PEAR }

public class ChapterThree {

    public static final Logger log = Logger.getLogger(ChapterThree.class.getName());

    public static void main(String[] args) {
        log.info("inside main() method");

        ChapterThree chapterThree = new ChapterThree();

//        chapterThree.nestedLoops();
        chapterThree.optionalLabels();
    }

    public void switchCases(){
        int month = 5;
//        final int apples = 2;

        switch (month) {
            case 5:
                log.info("case 5");
                break;
            case 0:
                log.info("case 0");
                break;
//            case apples:
//                log.info("case 2");
//                break;
            case 1:
            case 11:
                log.info("case 1");
//                break;
            case 3:
                log.info("case 3");
//                break;
            case 4:
                log.info("case 4");
//                break;
            default:
                log.info("default");
//                break;
        };

        var mySwitch = switch (month) {
            case 1, 2, 3 -> 123;

            case 4 -> 4;
//                log.info("case 4");
            case 5 -> {
                int myNewInt = 6;

                if (myNewInt > 5) {

                    yield month + myNewInt;
                }

                yield myNewInt;
//                log.info("case 5");
            }

            case 6 -> 6;

            case 7 -> 7;
            default -> throw new RuntimeException("Default branch in switch expression");
        };

        Fruit frt = null;

        switch (Fruit.APPLE) {
            case APPLE:
                System.out.println("apple");
                break;
            case ORANGE:
                System.out.println("orange");
                break;
            case BANANA:
                System.out.println("banana");
                break;
        }

        Fruit fruit = Fruit.APPLE;
        nodefaultconstructor.Fruit newfruit = nodefaultconstructor.Fruit.ORANGE;

        var switching =
                switch (fruit) {
                    case APPLE -> fruit;
                    case BANANA -> "banana";

                    default -> "default";
//            case LEMON -> System.out.println("lemon");
//            case PEAR -> System.out.println("orange");
                };

        System.out.println("SWITCHING");
        System.out.println(switching);
//        log.info("mySwitch: " + mySwitch);
    }

    public void printName(Fruit fruit) {

        Map<String, Boolean> cc = new HashMap<>();


        switch(fruit) {
            case APPLE  -> System.out.println("f.toString()");

            default -> System.out.println("sout");
        }
    }

    private void nestedLoops(){
        int hungryHippopotamus = 18;

        while(hungryHippopotamus>0) {
            do {
                hungryHippopotamus-=2;
            } while (hungryHippopotamus>5);
            hungryHippopotamus--;
            System.out.print(hungryHippopotamus + ", ");
        }
    }

    private void optionalLabels(){
        int[][] myComplexArray = {{5,2,1,3}, {3,5,1,2}, {6,7,1,2}, {1,3,7,9}};

        OUTER_LOOP: for(int[] mySimpleArray : myComplexArray){
            INNER_LOOP: for(int i=0; i<mySimpleArray.length; i++){
                System.out.print(mySimpleArray[i]+"\t");
            }
            System.out.println();
        }
    }

}
