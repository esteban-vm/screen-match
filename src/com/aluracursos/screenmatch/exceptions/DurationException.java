package com.aluracursos.screenmatch.exceptions;

public class DurationException extends RuntimeException {
    private final String message;

    public DurationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
