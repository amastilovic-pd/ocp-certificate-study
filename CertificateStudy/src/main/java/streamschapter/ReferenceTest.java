package streamschapter;

import java.util.Objects;

public class ReferenceTest<T> {
    private T value;

    public ReferenceTest(T value) {
        this.value = value;
    }

    public ReferenceTest() {
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ReferenceTest{" +
                "value=" + value +
                '}';
    }
}
