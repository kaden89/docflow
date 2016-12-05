package ru.karachurin.docflow.util.exception;

/**
 * Created by Денис on 02.12.2016.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
