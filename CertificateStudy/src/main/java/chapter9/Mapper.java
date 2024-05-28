package chapter9;

public interface Mapper<T, U> {

    public T toEntity(U u);
    public U toEntityDto(T t);
}
