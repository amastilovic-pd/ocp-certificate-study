package chapter13;

public class ContentHolder <T> {
    private T content;

    public ContentHolder(T content) {
        this.content = content;
    }

    public ContentHolder() {
    }


    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
