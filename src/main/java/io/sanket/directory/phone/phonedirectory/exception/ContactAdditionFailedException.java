package io.sanket.directory.phone.phonedirectory.exception;

import io.sanket.directory.phone.phonedirectory.handler.JsonResponse;

public class ContactAdditionFailedException extends RuntimeException{
    public ContactAdditionFailedException(){
        System.out.println("Failed to save contact in the directory. Please check your request and try again !!!");
    }
}
