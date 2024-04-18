package object_reference_testing;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Node node = new Node();
        node.getSections().add("a");
        node.getSections().add("b");
        node.getSections().add("c");
        node.getSections().add("d");

        List<String> sections = node.getSections();

        System.out.println(node.getSections());

        sections.add("e");

        System.out.println(node.getSections());

    }
}
