package io.sanket.directory.phone.phonedirectory.controller;

import io.sanket.directory.phone.phonedirectory.entity.Contact;
import io.sanket.directory.phone.phonedirectory.exception.InsufficientAttributeProvisionException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactControllerTest {

    private ContactController contactController = new ContactController();

    @Test
    public void addContactTest() throws InsufficientAttributeProvisionException{
        assertEquals(400, contactController.addContact(new Contact()).getStatus());
    }
}