package nodefaultconstructor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Reptile {
    {
        System.out.println("A");
    }

    public Reptile(int hatch){}
    public Reptile(){}
    void layEggs() {
        System.out.println("Reptile");
    }
}

class Lizard extends Reptile {
    static {
        System.out.println("B");
    }
    public Lizard(int hatch){
    }

    public final void layEggs() {
        System.out.println("Lizard");
    }

    public static void main(String[] args) {
        Reptile r = new Lizard(3);
        Queue<Integer> q = new LinkedList<>();
        List<Integer> l = new LinkedList<>();
        var v = new LinkedList<>();

        Map m = Map.of(1,2,3,5);

        var reptile = new Lizard(1);
        reptile.layEggs();
    }
}
