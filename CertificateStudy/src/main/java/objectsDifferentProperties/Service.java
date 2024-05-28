package objectsDifferentProperties;

import java.util.List;

public class Service extends AbstractProduct{

    private String name;
    private List<String> services;

    public Service() {
    }

    public Service(String name, List<String> services) {
        this.name = name;
        this.services = services;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }


}
