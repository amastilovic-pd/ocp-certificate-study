package batch;

public class ReactiveRuntimeException extends RuntimeException {
    public ReactiveRuntimeException(String message) {
        super(message);
    }

    public ReactiveRuntimeException(Throwable cause) {
        super(cause);
    }
}
