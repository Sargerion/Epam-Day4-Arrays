package edu.epam.task.two.exception;

public class WrapperJaggedArrayException extends Exception{

    public WrapperJaggedArrayException() {

    }

    public WrapperJaggedArrayException(String message) {
        super(message);
    }

    public WrapperJaggedArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrapperJaggedArrayException(Throwable cause) {
        super(cause);
    }
}
