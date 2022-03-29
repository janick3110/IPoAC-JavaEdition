package dhbw.ipoat;

public class InternalError extends Exception {
    public InternalError(String message) {
        super("Internal Error: " + message);
    }
}
