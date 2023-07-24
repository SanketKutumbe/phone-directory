package io.sanket.directory.phone.phonedirectory.service;

import io.sanket.directory.phone.phonedirectory.entity.Contact;

import java.util.List;

public interface ContactService {
    public boolean addContact(Contact contact);
    public boolean updateContact(String id, Contact contact);
    public boolean deleteContact(Integer id);
    public List<Contact> getAllContact();
    public List<Contact> getContact(String name) ;
}
