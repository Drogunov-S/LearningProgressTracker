package tracker.exception;

public class StudentNotFoundForId extends RuntimeException {
    public StudentNotFoundForId(String message) {
        super(message);
    }
}
