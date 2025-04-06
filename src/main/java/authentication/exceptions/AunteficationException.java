package authentication.exceptions;

public class AunteficationException extends Exception{
    public AunteficationException() {
    }


    public AunteficationException(String message) {
        super(message);
    }

    public AunteficationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AunteficationException(Throwable cause) {
        super(cause);
    }

}
