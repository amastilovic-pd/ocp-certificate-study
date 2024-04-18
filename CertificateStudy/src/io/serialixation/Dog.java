package io.serialixation;

import java.io.Serializable;

public class Dog implements Serializable {

    private String name;
    private transient int age; // transient

    public Dog(String name, int age, Dog dog) {
        this.name = name;
        this.age = age;
        dog.name = "str";
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
