package com.example.demo2.Check;

public class nameChecker implements Checker{
    @Override
    public boolean isValid(String text) {
        return (text.matches("^[a-zA-Z]+$") && !text.isEmpty());
    }
}
