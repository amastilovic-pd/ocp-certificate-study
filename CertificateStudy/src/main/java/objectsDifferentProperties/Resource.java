package objectsDifferentProperties;

import java.util.List;

public class Resource extends AbstractProduct {


    private String resourceName;
    private List<String> resources;

    public Resource() {
    }

    public Resource(String resourceName, List<String> resources) {
        this.resourceName = resourceName;
        this.resources = resources;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public List<String> getResources() {
        return resources;
    }

    public void setResources(List<String> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "resourceName='" + resourceName + '\'' +
                ", resources=" + resources +
                ", id='" + this.getId() + '\'' +
                ", productName='" + this.getResourceName() + '\'' +
                '}';
    }
}
