package com.daniel.springdemo.demo.Services.Excpetions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException (Object id){
        super("Resource Not Found Exception, ID: " + id);
    }
}
