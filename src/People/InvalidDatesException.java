package People;

public class InvalidDatesException extends Exception {
    public InvalidDatesException() {
        super("Data de final nu poate fi mai mare ca data de inceput!");
    }
}
