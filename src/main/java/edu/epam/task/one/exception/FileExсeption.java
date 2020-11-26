package edu.epam.task.one.exception;

public class FileExсeption extends Exception{

    public FileExсeption() {

    }

    public FileExсeption(String message) {
        super(message);
    }

    public FileExсeption(String message, Throwable cause) {
        super(message, cause);
    }

    public FileExсeption(Throwable cause) {
        super(cause);
    }
}
