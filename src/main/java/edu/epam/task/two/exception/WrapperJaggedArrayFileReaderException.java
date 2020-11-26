package edu.epam.task.two.exception;

public class WrapperJaggedArrayFileReaderException extends Exception{

    public WrapperJaggedArrayFileReaderException() {

    }

    public WrapperJaggedArrayFileReaderException(String message) {
        super(message);
    }

    public WrapperJaggedArrayFileReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrapperJaggedArrayFileReaderException(Throwable cause) {
        super(cause);
    }
}
