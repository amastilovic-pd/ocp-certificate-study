package chapter5;

import java.awt.event.ActionListener;

public class Rope {

//    @Override
//    public Integer test(int n) {
//        return 3;
//    }

    public static void swing() {
        System.out.print("swing");
    }

    public void climb() {
        System.out.println("climb");
    }

    public static void play() {
        swing();
    }

    public static int mynum() {
        return 5;
    }

    public static void main(String[] args) {
//        Rope rope = new Rope();
//        rope.play();

        Rope rope2 = null;
//        System.out.print("-");
        rope2.play();
    }
}
