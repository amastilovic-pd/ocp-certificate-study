package chapter7;

interface  MyInterface {
    void doSomething();
}

abstract class MyAbstractClass{
    abstract void doSomethinElse();

    void notAbstractMethod() {};
}

public class AnonymousClass {

    public static void main(String[] args) {
        MyInterface myObj = new MyInterface() {
            @Override
            public void doSomething() {
                System.out.println("anon class");
            }
        };

        MyAbstractClass myAbstractClass = new MyAbstractClass() {
            @Override
            void doSomethinElse() {
                System.out.println("doin somehtin else");
            }
        };

        MyAbstractClass myAbstractClass1 = new MyAbstractClass() {
            @Override
            void notAbstractMethod() {
                System.out.println("tester");
            }

            @Override
            void doSomethinElse() {

            }
        };

        myObj.doSomething();
        myAbstractClass.doSomethinElse();
        myAbstractClass1.notAbstractMethod();
    }
}
