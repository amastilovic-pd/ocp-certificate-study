import java.util.List;

public class PurchasedIso extends LockedIso {

    private List<String> sections;

    public PurchasedIso(List<String> sections) {
        this.sections = sections;
    }

    public PurchasedIso(String name, String title, List<String> sections) {
        super(name, title);
        this.sections = sections;
    }

    public List<String> getSections() {
        return sections;
    }

    public void setSections(List<String> sections) {
        this.sections = sections;
    }
}
