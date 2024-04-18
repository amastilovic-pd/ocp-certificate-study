package chpater11;

public class ChildRuntimeException extends RuntimeException {

    private HandlingExceptions thr() throws ChildRuntimeException {
        throw new RuntimeException();
    }
}
