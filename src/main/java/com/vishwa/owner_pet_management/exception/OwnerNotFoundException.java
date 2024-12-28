package com.vishwa.owner_pet_management.exception;

public class OwnerNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public OwnerNotFoundException(String message) {
        super(message);
    }
}
