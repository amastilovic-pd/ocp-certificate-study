package chapter6;

public abstract class Animal {
    abstract void bark();
    abstract void roar();

    void newTestPolyMethod(){
        System.out.println("polymorphism");
    };
}

abstract class Dog extends Animal {
    public void bark() {
        System.out.println("bark method from dog abstract class");
    } // inherited from Animal

    public Dog() {
        bark();
    }
}
