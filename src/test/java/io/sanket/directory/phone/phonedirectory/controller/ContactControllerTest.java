package io.sanket.directory.phone.phonedirectory.controller;

import io.sanket.directory.phone.phonedirectory.entity.Contact;
import io.sanket.directory.phone.phonedirectory.exception.ContactAdditionFailedException;
import io.sanket.directory.phone.phonedirectory.exception.InsufficientAttributeProvisionException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactControllerTest {

    private ContactController contactController = new ContactController();

    @Test
    public void addContactTest() throws ContactAdditionFailedException, InsufficientAttributeProvisionException{
        Contact contact = new Contact("aaa","111","aaa@gmail.com");
        assertEquals(201, contactController.addContact(contact).getStatus());
        assertEquals(400, contactController.addContact(new Contact()).getStatus());
    }

    @Test
    public void updateContactTest() throws InsufficientAttributeProvisionException{
        Contact contact = new Contact();
        contact.setPhoneNumber("111");
        assertEquals(400, contactController.updateContact(contact,"1").getStatus());
    }

    @Test
    public void deleteContactTest() throws InsufficientAttributeProvisionException{
        assertEquals(204, contactController.deleteContact(1).getStatus());
    }
}