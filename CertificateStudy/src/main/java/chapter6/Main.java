package chapter6;

public class Main {

    public static void main(String[] args) {
        ChildDog childDog = new ChildDog();
        ParentDog parentDog = childDog;
        childDog.printPoly();
        parentDog.printPoly();
        System.out.println(childDog.name);
        System.out.println(parentDog.name);
    }
}
