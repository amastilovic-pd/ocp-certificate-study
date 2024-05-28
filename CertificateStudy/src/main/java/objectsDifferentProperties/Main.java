package objectsDifferentProperties;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Product<?>> products = new ArrayList<>();
//        products.add(new Product<>("1", List.of(new Resource("resurs"))));
//        products.add(new Product<>("1", List.of(new Service("servis"))));
        products.add(new Product<>("1", List.of(new Object())));

        products.forEach(System.out::println);
    }
}
