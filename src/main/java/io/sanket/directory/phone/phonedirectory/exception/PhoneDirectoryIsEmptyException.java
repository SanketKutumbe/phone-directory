package io.sanket.directory.phone.phonedirectory.exception;

public class PhoneDirectoryIsEmptyException extends RuntimeException{
    public PhoneDirectoryIsEmptyException(){
        System.out.println("Phone directory is empty");
    }
}
