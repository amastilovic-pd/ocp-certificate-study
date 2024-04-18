package io.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NioExamples {

    public static void main(String[] args) {
        NioExamples e = new NioExamples();

//        e.useNioRelativePaths();

//        e.normalizePaths();
        e.resolvePaths();
    }

    public void useNioRelativePaths() {
        Path p1 = Paths.get("a/b/c"); // relative path
        Path p2 = Paths.get("a", "b", "c");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.getClass());

        System.out.println("for p1 - relative path");

        System.out.println("file name: " + p1.getFileName());
        System.out.println("root: " + p1.getRoot());
        System.out.println("parent: " + p1.getParent());

        System.out.println("for p2 - relative path");

        System.out.println("file name: " + p2.getFileName());
        System.out.println("root: " + p2.getRoot());
        System.out.println("parent: " + p2.getParent());
    }

    public void useNioAbsolutePaths() {
        Path p3 = Paths.get("/a/b/c"); // absolute path
        Path p4 = Paths.get("C:/a/b/c"); // absolute path

        System.out.println("for p3 - absolute path");

        System.out.println("file name: " + p3.getFileName());
        System.out.println("root: " + p3.getRoot());
        System.out.println("parent: " + p3.getParent());

        System.out.println("for p4 - absolute path");

        System.out.println("file name: " + p4.getFileName());
        System.out.println("root: " + p4.getRoot());
        System.out.println("parent: " + p4.getParent());
    }

    public void normalizePaths() {
        Path p1 = Paths.get("a/b/c/./././d/../../c");

        System.out.println(p1);
        System.out.println(p1.normalize());

        Path p2 = Paths.get("a/../../../b"); // relative

        System.out.println(p2.normalize());

        Path p3 = Paths.get("/a/../../../b"); // absolute

        System.out.println(p3.normalize());
    }

    public void resolvePaths() {
        Path p1 = Paths.get("/a/b/c"); // absolute
        Path p2 = Paths.get("d/e/f"); // relative
        Path path = Paths.get("/g/h/j");

        Path p3 = p1.resolve(p2); // /a/b/c/d/e/f   -> concats
        Path p4 = p2.resolve(p1); // /a/b/c -> cant concat relative path to absolute path
        Path p5 = p1.resolve(path); // /g/h/j -> always prints right absolute path

        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
    }
}
