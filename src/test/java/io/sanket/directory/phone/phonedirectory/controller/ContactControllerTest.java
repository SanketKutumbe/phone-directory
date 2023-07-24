package io.sanket.directory.phone.phonedirectory.controller;

import io.sanket.directory.phone.phonedirectory.entity.Contact;
import io.sanket.directory.phone.phonedirectory.exception.InsufficientAttributeProvisionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactControllerTest {

    private ContactController contactController = new ContactController();

    @Test
    public void addContact() {
        Contact contact = new Contact("abc", "1111111111", "abc@gmail.com");
        assertEquals(201, contactController.addContact(contact).getStatus());
    }

     
}