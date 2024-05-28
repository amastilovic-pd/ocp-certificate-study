package chapter7;

public sealed interface SealedInterface permits ChildInterface, MyNonSealedClass {
}
