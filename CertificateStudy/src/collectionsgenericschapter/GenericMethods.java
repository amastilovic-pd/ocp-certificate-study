package collectionsgenericschapter;

public class GenericMethods {

    public static _Generics<String> createGenericString(String s){

        return new _Generics<>(s);
    }


    public static <T> _Generics<T> createGeneric(T t){

        return new _Generics<>(t);
    }
}
