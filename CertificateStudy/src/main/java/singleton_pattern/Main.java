package singleton_pattern;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        SingletonPattern singletonPattern = SingletonPattern.getInstance();
        SingletonPattern singletonPattern1 = SingletonPattern.getInstance();

        System.out.println(singletonPattern == singletonPattern1);
        System.out.println(Objects.equals(singletonPattern.hashCode(), singletonPattern1.hashCode()));

        SingletonEnum instance = SingletonEnum.INSTANCE;
        LinkedList<Object> objects = new LinkedList<>();

//        Object value = SingletonEnum.INSTANCE.getValue();
//        Object value2 = SingletonEnum.INSTANCE.getValue();
//        Object value3 = SingletonEnum.INSTANCE.getValue();
//        Object value4 = SingletonEnum.INSTANCE.getValue();
//        System.out.println(value.hashCode());
//        System.out.println(value2.hashCode());
//        System.out.println(value3.hashCode());
//        System.out.println(value4.hashCode());

//        Object singletonEnum = SingletonEnum.INSTANCE.getInstance();
//        Object singletonEnum2 = SingletonEnum.INSTANCE.getInstance();
//
//        System.out.println(singletonEnum == singletonEnum2);
//        System.out.println(Objects.equals(singletonEnum.hashCode(), singletonEnum2.hashCode()));
    }
}
