import java.util.ArrayList;
import java.util.List;

public class Penguin {
    private enum Baby { EGG }

    static class Chick {
        enum Baby { EGG }
    }

    public static void main(String[] args) {
//        PenguinInterface pi = new Penguin();

        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");

        new Penguin().tst(strings);
        System.out.println(strings);


//        PenguinInterface.fly();

//        System.out.println(PenguinInterface.flew());
    }

    void tst (List<String> strs){
        strs.add("d");
        strs.add("e");
    }
}
