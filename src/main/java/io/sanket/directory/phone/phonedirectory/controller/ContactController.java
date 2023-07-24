package io.sanket.directory.phone.phonedirectory.controller;

import io.sanket.directory.phone.phonedirectory.entity.Contact;
import io.sanket.directory.phone.phonedirectory.exception.ContactAdditionFailedException;
import io.sanket.directory.phone.phonedirectory.exception.ContactNotFoundException;
import io.sanket.directory.phone.phonedirectory.exception.InsufficientAttributeProvisionException;
import io.sanket.directory.phone.phonedirectory.exception.PhoneDirectoryIsEmptyException;
import io.sanket.directory.phone.phonedirectory.handler.JsonResponse;
import io.sanket.directory.phone.phonedirectory.service.ContactService;
import io.sanket.directory.phone.phonedirectory.service.impl.ContactServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*
        - Add a contact to the directory.
        - Modify an existing contact.
        - Delete an existing contact.
        - Retrieve all contacts.
        - Search contacts by name.

 */
@RestController
public class ContactController {

    private ContactService contactService = new ContactServiceImpl();

    @RequestMapping( method = RequestMethod.POST, value = "/contacts")
    public JsonResponse addContact(@RequestBody Contact contact)
    throws ContactAdditionFailedException, InsufficientAttributeProvisionException {
        JsonResponse<Contact> jsonResponse = new JsonResponse();
        jsonResponse.setData(contact);
        try {
            if( contact.getName() == null || contact.getPhoneNumber() == null ) throw new InsufficientAttributeProvisionException();
            if ( !contactService.addContact(contact) ) throw new ContactAdditionFailedException();
            jsonResponse.setStatus(201);
            jsonResponse.setMessage("Contact added successfully");
        } catch (InsufficientAttributeProvisionException insufficientAttributeProvisionException) {

//            insufficientAttributeProvisionException.printStackTrace();
            jsonResponse.setStatus(400);
            jsonResponse.setMessage("Bad Request. Please provide both, name and phone number");
        }
        catch (ContactAdditionFailedException cafe) {
            cafe.printStackTrace();
            jsonResponse.setStatus(200);
            jsonResponse.setMessage("User already existing, so it cannot be created once again");
        } catch (Exception e) {
            e.printStackTrace();
            jsonResponse.setStatus(500);
            jsonResponse.setMessage("Internal server error occurred. Please try after sometime.");
        }finally {
            return jsonResponse;
        }
    }

    @RequestMapping( method = RequestMethod.PUT, value = "/contacts/{id}")
    public JsonResponse<Contact> updateContact(@RequestBody Contact contact, @PathVariable String id)
    throws InsufficientAttributeProvisionException{
        JsonResponse<Contact> jsonResponse = new JsonResponse();
        try{
            if( contactService.updateContact(id, contact) ){
                jsonResponse.setStatus(200);
                jsonResponse.setMessage("Contact updated successfully.");
            }
            else{
                if( contact.getName() == null || contact.getPhoneNumber() == null ) throw new InsufficientAttributeProvisionException();
                jsonResponse.setStatus(201);
                jsonResponse.setMessage("Contact weren't existing, so contacted added successfully");
            }
        }catch (InsufficientAttributeProvisionException insufficientAttributeProvisionException) {
            insufficientAttributeProvisionException.printStackTrace();
            jsonResponse.setStatus(400);
            jsonResponse.setMessage("Bad Request. Please provide both, name and phone number");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return jsonResponse;
        }
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/contacts/{id}")
    public JsonResponse<Contact> deleteContact(@PathVariable Integer id){
        JsonResponse<Contact> jsonResponse = new JsonResponse<>();
        try{
            if( !contactService.deleteContact(id) ) throw new ContactNotFoundException();
            jsonResponse.setStatus(201);
            jsonResponse.setMessage("Contact deleted successfully");
        }catch(ContactNotFoundException contactNotFoundException){
            contactNotFoundException.printStackTrace();
            jsonResponse.setMessage("Contact not found");
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            return jsonResponse;
        }

    }

    @RequestMapping("/contacts")
    public JsonResponse getAllContacts() {
        JsonResponse<List<Contact>> jsonResponse = new JsonResponse<>();
        List<Contact> result = contactService.getAllContact();
        try{
            if( result == null ) throw new PhoneDirectoryIsEmptyException();
            jsonResponse.setStatus(200);
            jsonResponse.setData(result);
            jsonResponse.setMessage(result.size() + " contacts found in the phone directory");
        }catch(PhoneDirectoryIsEmptyException phoneDirectoryIsEmptyException){
            phoneDirectoryIsEmptyException.printStackTrace();
            jsonResponse.setMessage("Phone directory is empty");
        }
        catch(Exception e){
            e.printStackTrace();
        }finally {
            return jsonResponse;
        }
    }

    @RequestMapping("/contacts/{name}")
    public JsonResponse searchContact(@PathVariable String name){
        JsonResponse<List<Contact>> jsonResponse = new JsonResponse<>();
        try {
            List<Contact> contact = contactService.getContact(name);
            if( contact == null ) throw new ContactNotFoundException();
            jsonResponse.setStatus(200);
            jsonResponse.setData(contact);
            jsonResponse.setMessage(contact.size() + " contact(s) found");
        }catch(ContactNotFoundException contactNotFoundException){
            contactNotFoundException.printStackTrace();
            jsonResponse.setMessage("Contact not found");
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            return jsonResponse;
        }
    }
}
