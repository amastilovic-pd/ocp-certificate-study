package io.serialixation.inheritanceexample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Example {

    public static void main(String[] args) {
        Example e = new Example();

//        e.writeObjectToFile();
        e.readObjectFromFile();
    }

    public void writeObjectToFile() {

        try (FileOutputStream fos = new FileOutputStream("c");
             ObjectOutputStream out = new ObjectOutputStream(fos)) {

            C c = new C();

            out.writeObject(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readObjectFromFile() {

        try (var fis = new FileInputStream("c");
             var in = new ObjectInputStream(fis)) {

            C c = (C) in.readObject();

            System.out.println(c);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
