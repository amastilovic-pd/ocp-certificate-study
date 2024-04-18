package objectsDifferentProperties;

import java.util.List;

public class Product<T> {
    private String id;;
    private List<T> child;

    public Product(String id, List<T> child) {
        this.id = id;
        this.child = child;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<T> getChild() {
        return child;
    }

    public void setChild(List<T> child) {
        this.child = child;
    }
}
