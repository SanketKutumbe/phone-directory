package io.sanket.directory.phone.phonedirectory.exception;

public class InsufficientAttributeProvisionException extends RuntimeException{
    public InsufficientAttributeProvisionException(){
        System.out.println("All mandatory fields like name, and phone number, are not initialised ");
    }
}
