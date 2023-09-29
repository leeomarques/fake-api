package com.example.fakeapi.infrastrucutre.Exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String entityName, Object id) {
        super("Entity " + entityName + " with ID " + id + " not found.");
    }
}
