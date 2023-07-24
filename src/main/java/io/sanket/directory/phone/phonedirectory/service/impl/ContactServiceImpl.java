package io.sanket.directory.phone.phonedirectory.service.impl;

import io.sanket.directory.phone.phonedirectory.entity.Contact;
import io.sanket.directory.phone.phonedirectory.repository.CustomContactRepository;
import io.sanket.directory.phone.phonedirectory.service.ContactService;
import java.util.List;

public class ContactServiceImpl implements ContactService {

    private CustomContactRepository customContactRepository = CustomContactRepository.getInstance();
    public boolean addContact(Contact contact){
        return customContactRepository.addContact(contact);
    }
    public boolean updateContact(String id, Contact contact){
        return customContactRepository.updateContact(Integer.parseInt(id), contact);
    }
    public boolean deleteContact(Integer id){
        return customContactRepository.deleteContact(id);
    }
    public List<Contact> getAllContact(){
        return customContactRepository.getAllContact();
    }
    public List<Contact> getContact(String name) {
        return customContactRepository.getContact(name);
    }
}
