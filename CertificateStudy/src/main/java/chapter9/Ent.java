package chapter9;

import java.util.ArrayList;
import java.util.List;

public class Ent {

    public static <T> T identity(T t) {

        return t;
    }

    public <T> T identifier(T t) {
        // wildcard (?) is used when you are OK with any type

        List<String> myList = new ArrayList<>();
        myList.add("asd");

        //wildcard with upper bound - any class that extends or class itself
        List<? extends Exception> aExcpt = new ArrayList<RuntimeException>();

        //wildcard with lower bound - this class or super class
        List<? super CharSequence> superExtnd = new ArrayList<>();
        superExtnd.add("asd");

        return t;
    }

    //unbouded wildcard
    public void myWildcardMeth(List<?> myl) {
        for (Object o : myl) {
            System.out.println(myl);
        }
    }

    public static void main(String[] args) {
        List<? super CharSequence> superExtnd = new ArrayList<>();

        superExtnd.add("asd");
        superExtnd.add(new StringBuilder("asd"));

        System.out.println(superExtnd);
    }
}
