package CRUD.myfirst.exception;

import com.sun.istack.NotNull;

public class AdminAddbookException extends RuntimeException{

    public AdminAddbookException() {
    }

    public AdminAddbookException(String message) {
        super(message);
    }

    public AdminAddbookException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdminAddbookException(Throwable cause) {
        super(cause);
    }

    public AdminAddbookException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
