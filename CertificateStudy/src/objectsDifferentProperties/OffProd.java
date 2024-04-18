package objectsDifferentProperties;

import java.util.ArrayList;
import java.util.List;

public class OffProd implements GlavniProduct {
    public static void main(String[] args) {
        List<AbstractProduct> products = new ArrayList<>();
        Resource resource = new Resource("resurs", List.of("resrs"));
        resource.setId("prodId");
        resource.setProductName("prodName");

        Service service = new Service("servis", List.of("servis"));
        service.setId("prodId");
        service.setProductName("prodName");
        products.add(resource);
        products.add(service);

        products.forEach(x -> System.out.println(x));
    }
}
