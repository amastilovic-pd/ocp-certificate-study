package batch;

public class BasicResponseDto<T> {
    private T data;

    public BasicResponseDto() {}

    public BasicResponseDto(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
