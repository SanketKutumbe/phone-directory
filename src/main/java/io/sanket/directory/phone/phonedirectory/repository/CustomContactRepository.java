package io.sanket.directory.phone.phonedirectory.repository;

import io.sanket.directory.phone.phonedirectory.entity.Contact;

import java.util.*;
import java.util.stream.Collectors;

// Its a singleton class
public class CustomContactRepository {
    private static int counter = 1;
    private static CustomContactRepository customContactRepository = null;

    // maintains list of all contacts
    private List<Contact> list = new ArrayList<>();

    // Stores map of contact_id and contact
    private Map<Integer, Contact> map = new LinkedHashMap<>();
    private CustomContactRepository(){}

    // Retrieves instance of class
    public static CustomContactRepository getInstance(){
        if ( customContactRepository == null ){
            synchronized ( CustomContactRepository.class ){
                customContactRepository = new CustomContactRepository();
            }
        }
        return customContactRepository;
    }

    // adds contact
    public boolean addContact(Contact contact){
        // if contact already exists, return false.
        if( !map.isEmpty() && map.containsKey( contact.getId() ) ) return false;

        // Adds contact to map and list.
        contact.setId(counter++);
        list.add(contact);
        map.put(contact.getId(), contact);
        return true;
    }

    // updates contact if existing, otherwise it gets created.
    public boolean updateContact(Integer id, Contact contact){

        // if contact exists, then it gets updated
        if( !map.isEmpty() && map.containsKey( id ) ) {
            map.replace(id, contact);

            for(Contact con: list) {
                if( con.getId() == id ){
                    if( contact.getName() != null ) con.setName(contact.getName());
                    if( contact.getEmail() != null ) con.setEmail(contact.getEmail());
                    if( contact.getPhoneNumber() != null ) con.setPhoneNumber(contact.getPhoneNumber());

                    break;
                }
            }
            return true;
        }

        // if contact is not existing, then it gets added
        contact.setId(counter++);
        list.add(contact);
        map.put(contact.getId(), contact);
        return false;
    }

    // existing contact  is deleted using its id, otherwise return false.
    public boolean deleteContact(int id){

        // if contact is not existing or directory is empty, then return false
        if( map.isEmpty() || !map.containsKey(id) ) return false;

        // contact gets deleted
        map.remove(id);
        int index = 0;
        for(Contact con: list) {
            if( con.getId() == id ){
                break;
            }
            index++;
        }
        list.remove(index);
        return true;
    }

    // retrieve all contacts
    public List<Contact> getAllContact(){
        return list;
    }

    // search contact with provided name.
    public List<Contact> getContact(String name) {
        return list.stream().filter(a -> a.getName().equals(name)).collect(Collectors.toList());
    }
}
