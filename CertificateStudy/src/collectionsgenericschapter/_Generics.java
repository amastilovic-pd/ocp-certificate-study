package collectionsgenericschapter;

import java.util.Objects;

public class _Generics<T> {
    T instance;

    public _Generics(T instance) {
        this.instance = instance;
    }

    public T getInstance() {
        return instance;
    }

    public void setInstance(T instance) {
        this.instance = instance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof _Generics<?> generics)) return false;
        return Objects.equals(instance, generics.instance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instance);
    }
}
