package object_reference_testing;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private List<String> sections = new ArrayList<>();


    public Node() {
        super();
    }

    public Node(List<String> sections) {
        this.sections = sections;
    }

    public List<String> getSections() {
        return sections;
    }

    public void setSections(List<String> sections) {
        this.sections = sections;
    }
}
