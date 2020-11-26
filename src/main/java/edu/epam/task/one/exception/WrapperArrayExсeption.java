package edu.epam.task.one.exception;

public class WrapperArrayExсeption extends Exception{

    public WrapperArrayExсeption() {

    }

    public WrapperArrayExсeption(String message) {
        super(message);
    }

    public WrapperArrayExсeption(String message, Throwable cause) {
        super(message, cause);
    }

    public WrapperArrayExсeption(Throwable cause) {
        super(cause);
    }
}
