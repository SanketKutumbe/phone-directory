package io.sanket.directory.phone.phonedirectory.service.impl;

import io.sanket.directory.phone.phonedirectory.entity.Contact;
import io.sanket.directory.phone.phonedirectory.repository.ContactRepository;
import io.sanket.directory.phone.phonedirectory.service.ContactService;
import java.util.List;

public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository = ContactRepository.getInstance();
    public boolean addContact(Contact contact){
        return contactRepository.addContact(contact);
    }
    public boolean updateContact(String id, Contact contact){
        return contactRepository.updateContact(Integer.parseInt(id), contact);
    }
    public boolean deleteContact(Integer id){
        return contactRepository.deleteContact(id);
    }
    public List<Contact> getAllContact(){
        return contactRepository.getAllContact();
    }
    public List<Contact> getContact(String name) {
        return contactRepository.getContact(name);
    }
}
