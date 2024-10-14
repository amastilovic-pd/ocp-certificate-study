package singleton_pattern;

public enum SingletonEnum {
    INSTANCE;

    private final Object value;

    SingletonEnum() {
        System.out.println("inside constructor");
        value = new Object();
    }

    public Object getValue() {
        return value;
    }
}
