package chapter13;

import chapter5.Rope;

import java.util.Objects;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        String s1 = new String("Hello");

        Optional<String> s3 = Optional.of(s1);
        Optional<String> s4 = Optional.of(new String("Hello"));
        Rope rope = new Rope();
        Optional<Rope> rope1 = Optional.of(rope);

        System.out.println(s1.hashCode() == s3.hashCode());
        System.out.println(s1.hashCode() == s4.hashCode());
        System.out.println(Objects.equals(s1.hashCode(), s3.hashCode()));
        System.out.println(Objects.equals(s1.hashCode(), s4.hashCode()));
        System.out.println(Objects.deepEquals(s1.hashCode(), s3.hashCode()));
        System.out.println(Objects.deepEquals(s1.hashCode(), s4.hashCode()));
        System.out.println(Objects.deepEquals(rope.hashCode(), rope1.hashCode()));

        ContentHolder<String> contentHolder = new ContentHolder<>();
        contentHolder.setContent("Hello");
        chngr(contentHolder);
        System.out.println(contentHolder.getContent());
        String s = "Hello";
        strchg(s);
        System.out.println(s);
    }

    static void chngr(ContentHolder<String> contentHolder) {
        contentHolder.setContent("changed");
    }

    static void strchg(String s) {
        s = "changed";
    }
}
