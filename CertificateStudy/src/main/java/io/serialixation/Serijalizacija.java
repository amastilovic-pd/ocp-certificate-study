package io.serialixation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serijalizacija {

    public static void main(String[] args) {
        Serijalizacija srs = new Serijalizacija();

//        srs.writeCatObjectToFile();
//        srs.readCatObjectFromFile();

//        srs.writeDogObjectToFile();
//        srs.readDogObjectFromFile();

//        srs.writeOwnerObjectToFile();
//        srs.readOwnerObjectFromFile();
    }

    public void writeCatObjectToFile() {

        File dataFile = new File("cat1");

        try (FileOutputStream fos = new FileOutputStream(dataFile);
             ObjectOutputStream out = new ObjectOutputStream(fos)) {

            var cat = new Cat("Tom");

            out.writeObject(cat);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readCatObjectFromFile() {

        File dataFile = new File("cat1");

        try (var fis = new FileInputStream(dataFile);
             var in = new ObjectInputStream(fis)) {

            var cat = (Cat) in.readObject();

            System.out.println(cat);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeDogObjectToFile() {

        try (FileOutputStream fos = new FileOutputStream("dog1");
             ObjectOutputStream out = new ObjectOutputStream(fos)) {

            var dog = new Dog("Tommy", 5, null);

            out.writeObject(dog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readDogObjectFromFile() {

        File dataFile = new File("dog1");

        try (var fis = new FileInputStream(dataFile);
             var in = new ObjectInputStream(fis)) {

            Dog dog = (Dog) in.readObject();

            System.out.println(dog);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeOwnerObjectToFile() {

        try (FileOutputStream fos = new FileOutputStream("owner1");
             ObjectOutputStream out = new ObjectOutputStream(fos)) {

                                                // make Gorilla class implement Serializable
                                                // or in Owner class make Gorilla transient
            var owner = new Owner("Jim", new Gorilla());

            out.writeObject(owner);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readOwnerObjectFromFile() {

        try (var fis = new FileInputStream("owner1");
             var in = new ObjectInputStream(fis)) {

            Owner owner = (Owner) in.readObject();

            System.out.println(owner);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
