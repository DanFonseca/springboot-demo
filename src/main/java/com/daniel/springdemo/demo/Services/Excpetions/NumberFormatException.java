package com.daniel.springdemo.demo.Services.Excpetions;

public class NumberFormatException extends RuntimeException {
    public NumberFormatException (Object obj){
        super("NumberFormatException from: " + obj);
    }
}
