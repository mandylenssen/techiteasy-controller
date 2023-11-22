package exeptions;

public class NameNotApprovedException extends RuntimeException {
    public NameNotApprovedException() {
        super();
    }
    public NameNotApprovedException(String message) {
        super(message);
    }
}
