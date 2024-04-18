package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

public class RWFiles {

    // FileOutputStream
    // FileInputStream
    // BufferedWriter -> Writer
    // BufferedReader -> Reader

    // PrintStream -> System.out / System.err
    // PrintWriter

    public static void main(String[] args) {
        RWFiles rw = new RWFiles();

        rw.writeDataToFile();
//        rw.writeDataWithFlush();
//        rw.chainingConstructors();
//        rw.writeDataWithPrintStream();
//        rw.writeDataWithPrintWriter();
    }

    public void writeDataToFile() {

        try (Writer w = new FileWriter("writeDataToFile.txt"); // empty string throws an error
             BufferedWriter out = new BufferedWriter(w)) {

            out.write("I am from writeDataToFile method");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeDataWithFlush() {

        Writer w = null;
        BufferedWriter out = null;

        try {
            w = new FileWriter("writeDataWithFlush.txt");
            out = new BufferedWriter(w);
            out.write("I am from writeDataWithFlush method");

            out.flush(); // without flush or close doesnt write data
            w.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void chainingConstructors() {

        try (var out = new BufferedWriter(new FileWriter(new File("chainingConstructors.txt")))) {

            out.write("I am from chainingConstructors method");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeDataWithPrintStream() {

        try (PrintStream out = new PrintStream("writeDataWithPrintStream.txt")) {

            out.println("I am from writeDataWithPrintStream method");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeDataWithPrintWriter() {

        try (PrintWriter out = new PrintWriter(                           // autoflush
                new FileOutputStream("writeDataWithPrintWriter.txt") , true)) {

            out.println("I am from writeDataWithPrintWriter method");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
