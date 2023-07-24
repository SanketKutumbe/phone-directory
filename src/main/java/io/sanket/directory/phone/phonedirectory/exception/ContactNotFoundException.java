package io.sanket.directory.phone.phonedirectory.exception;

public class ContactNotFoundException extends RuntimeException{
    public ContactNotFoundException(){
        System.out.println("Contact not found in the directory");
    }
}
