package com.example.learningspringboot;

public class MyFavException extends RuntimeException {

    private int code;

    public MyFavException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
