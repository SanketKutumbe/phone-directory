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
import java.util.Optional;

/*
        -
        - Modify an existing contact.
        - Delete an existing contact.
        - Retrieve all contacts.
        - Search contacts by name.

 */
@RestController
public class ContactController {

    private ContactService contactService = new ContactServiceImpl();

    /*
        Adds contact in a directory.
        @Params: Contact(name, phoneNumber, email)
            E.g
            {
                "name":"contactOne",
                "phoneNumber":"11111111111",
                "email":"contactOne@gmail.com"
            }

        @Return: JsonResponse
            E.g
            {
                "status": 201,
                "message": "Contact added successfully",
                "data": {
                    "id": 1,
                    "name": "contactOne",
                    "phoneNumber": "11111111111",
                    "email": "contactOne@gmail.com"
                }
            }

        @Exception: It fails to add if "name" and/or "phone number"is not provided , exception is thrown and in case when contact details are empty, exception is thrown.
     */
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
            insufficientAttributeProvisionException.printStackTrace();
            jsonResponse.setStatus(400);
            jsonResponse.setMessage("Bad Request. Please provide both, name and phone number");
        }
        catch (ContactAdditionFailedException cafe) {
            cafe.printStackTrace();
            jsonResponse.setStatus(202);
            jsonResponse.setMessage("User already existing, so it cannot be created once again");
        } catch (Exception e) {
            e.printStackTrace();
            jsonResponse.setStatus(500);
            jsonResponse.setMessage("Internal server error occurred. Please try after sometime.");
        }finally {
            return jsonResponse;
        }
    }

    /*
        Update contact in a directory.
        @Params: Contact(name, phoneNumber, email)***
            E.g
            {
                "phoneNumber":"11111111111"
            }
        (Note: Passing few contact details with contact-id is valid.)

        @Return: JsonResponse
            E.g
            {
                "status": 200,
                "message": "Contact updated successfully.",
                "data": null
            }
        (Note: null value in data doesn't represent failure to update the contact.)

        @Exception: If contact is not existing to update, then in case of creating contact, it fails to add if "name" and/or
                    "phone number"is not provided, exception is thrown and when contact details are empty, exception is thrown.
     */
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

    /*
        Delete contact in a directory.
        @Params: Contact-Id

        @Return: JsonResponse
            E.g
            {
                "status": 204,
                "message": "Contact deleted successfully",
                "data": null
            }

        (Note: null value in data doesn't represent failure to update the contact.)

        @Exception: If contact is not existing to delete or directory is empty, exception is thrown.
     */
    @RequestMapping( method = RequestMethod.DELETE, value = "/contacts/{id}")
    public JsonResponse<Contact> deleteContact(@PathVariable Integer id){
        JsonResponse<Contact> jsonResponse = new JsonResponse<>();
        try{
            if( !contactService.deleteContact(id) ) throw new ContactNotFoundException();
            jsonResponse.setStatus(204);
            jsonResponse.setMessage("Contact deleted successfully");
        }catch(ContactNotFoundException contactNotFoundException){
            contactNotFoundException.printStackTrace();
            jsonResponse.setStatus(404);
            jsonResponse.setMessage("Contact not found");
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            return jsonResponse;
        }

    }

    /*
       Get all contacts in a directory.

       @Return: JsonResponse
           E.g
            {
                "status": 200,
                "message": "1 contacts found in the phone directory",
                "data": [
                    {
                        "id": 1,
                        "name": "contactOne",
                        "phoneNumber": "2222222222",
                        "email": "contactOne@gmail.com"
                    }
                ]
            }

       @Exception: If contact is not existing to delete, exception is thrown.
    */
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
            jsonResponse.setStatus(503);
            jsonResponse.setMessage("Phone directory is empty");
        }
        catch(Exception e){
            e.printStackTrace();
        }finally {
            return jsonResponse;
        }
    }

    /*
       Searching contact(s) in a directory.

       @Params: String

       @Return: JsonResponse
           E.g
            {
                "status": 200,
                "message": "1 contacts found in the phone directory",
                "data": [
                    {
                        "id": 1,
                        "name": "contactOne",
                        "phoneNumber": "2222222222",
                        "email": "contactOne@gmail.com"
                    }
                ]
            }

       @Exception: If contact is not existing to delete, exception is thrown.
    */
    @RequestMapping(method = RequestMethod.GET, value="/contacts/search")
    public JsonResponse searchContact(@RequestParam("name") String name){
        JsonResponse<List<Contact>> jsonResponse = new JsonResponse<>();
        try {
            List<Contact> contact = contactService.getContact(name);
            if( contact == null ) throw new ContactNotFoundException();
            jsonResponse.setStatus(200);
            jsonResponse.setData(contact);
            jsonResponse.setMessage(contact.size() + " contact(s) found");
        }catch(ContactNotFoundException contactNotFoundException){
            contactNotFoundException.printStackTrace();
            jsonResponse.setStatus(404);
            jsonResponse.setMessage("Contact not found");
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            return jsonResponse;
        }
    }
}
