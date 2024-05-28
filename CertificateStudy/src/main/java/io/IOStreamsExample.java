package io;

import java.io.IOException;
import java.util.List;

public class IOStreamsExample {

    public static void main(String[] args) throws IOException {

        //Low-level stream
        //  InputStream
        //  OutputStream
        //  FileInputStream
        //  FileOutputStream
//        new BufferedInputStream(new FileReader("test.txt")); // doesnt compile
//        new File();
//        Paths.get();

        //High-level stream
        //  DataInputStream
        //  DataOutputStream
        //  PrintStream - out
        //  PrintWriter - in
        //  BufferedReader
        //  BufferedWriter
//        new BufferedWriter(new FileOutputStream("tst.txt")); // doesnt compile
//        new BufferedWriter(new FileInputStream("tst.txt"));
        //  ObjectInputStream
        //  ObjectOutputStream

        final var javaVersions = List.of(17, 11, 8);
        var names = List.of("JDK", "JAVA");
        V: for (var e1 : javaVersions) {
            E: for (String e2 : names)
                System.out.println(e1 + "_" + e2);
                break;
        }
    }
}
