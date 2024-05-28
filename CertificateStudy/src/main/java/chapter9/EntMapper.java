package chapter9;

import java.util.List;

public class EntMapper implements Mapper{

    @Override
    public Object toEntity(Object o) {
        return null;
    }

    @Override
    public Object toEntityDto(Object o) {
        var v = List.of("asd", "asd");
        v.removeIf(String::isEmpty);
        return null;
    }
}
