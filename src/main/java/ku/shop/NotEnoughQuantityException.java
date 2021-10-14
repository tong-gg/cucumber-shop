package ku.shop;

public class NotEnoughQuantityException extends RuntimeException {
    public NotEnoughQuantityException() {}

    public NotEnoughQuantityException(String message) {
        super(message);
    }
}
