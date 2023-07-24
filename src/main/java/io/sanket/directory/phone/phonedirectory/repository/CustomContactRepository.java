package io.sanket.directory.phone.phonedirectory.repository;

import io.sanket.directory.phone.phonedirectory.entity.Contact;

import java.util.*;
import java.util.stream.Collectors;

public class CustomContactRepository {
    private static int counter = 1;
    private static CustomContactRepository customContactRepository = null;
    private List<Contact> list = new ArrayList<>();
    private Map<Integer, Contact> map = new LinkedHashMap<>();
    private CustomContactRepository(){}
    public static CustomContactRepository getInstance(){
        if ( customContactRepository == null ){
            synchronized ( CustomContactRepository.class ){
                customContactRepository = new CustomContactRepository();
            }
        }
        return customContactRepository;
    }

    public boolean addContact(Contact contact){
        if( !map.isEmpty() && map.containsKey( contact.getId() ) ) return false;
        contact.setId(counter++);
        list.add(contact);
        map.put(contact.getId(), contact);
        return true;
    }
    public boolean updateContact(Integer id, Contact contact){
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
        contact.setId(counter++);
        list.add(contact);
        map.put(contact.getId(), contact);
        return false;
    }
    public boolean deleteContact(int id){
        if( map.isEmpty() || !map.containsKey(id) ) return false;
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
    public List<Contact> getAllContact(){
        return list;
    }
    public List<Contact> getContact(String name) {
        return list.stream().filter(a -> a.getName().equals(name)).collect(Collectors.toList());
    }
}
