# Phone Directory
It provides api to add, modify, delete, search and retrieval of all contacts. Contact information includes name, phone and email.

# Project Architecture Flow:

![](C:\Users\adsan\Downloads\phone-directory.drawio.png)

# Project components:

1) API client (like postman) - Provided details of usage at end.
2) ContactController involves addContact(), updateContact(), deleteContact(), getAllContacts() and searchContact() methods.
3) ContactService involves business logic to implement above mentioned methods
4) ContactRepository is storage layer where contacts are stored
5) Exception:
    <table>
   <tr>
    <td>Exception</td>
   <td>Reason</td>
    </tr>
   <tr>
   <td>ContactAdditionFailedException</td>
   <td>Contact cannot be re-added if it is existing</td>
   </tr>
   <tr>
   <td>ContactNotFoundException</td>
   <td>Searching non-existing contact</td>
   </tr>
   <tr>
   <td>InsufficientAttributeProvisionException</td>
   <td>Contact's name and/or phone is empty while adding the contact</td>
   </tr>
   <tr>
   <td>PhoneDirectoryIsEmptyException</td>
   <td>Retrieval of contacts failed when directory is empty</td>
   </tr>
    </table>

6) Contact : It involves Id, name, phoneNumber and email attributes
7) Others:

    <table>
    <tr>
    <td>Status Code</td>
    <td>Meaning</td>
    </tr>
   <tr>
    <td>200</td>
    <td>Contact updated successfully</td>
    </tr>
   <tr>
    <td>201</td>
    <td>Contact added successfully</td>
    </tr>
    <tr>
    <td>202</td>
    <td>User already existing, so it cannot be created once again</td>
    </tr>
    <tr>
    <td>204</td>
    <td>Contact deleted successfully</td>
    </tr>   
    <tr>
    <td>400</td>
    <td>Bad Request. Please provide both, name and phone number</td>
    </tr>
    <tr>
    <td>404</td>
    <td>Contact not found</td>
    </tr>
    <tr>
    <td>500</td>
    <td>Internal server error occurred. Please try after sometime.</td>
    </tr>
    <tr>
    <td>503</td>
    <td>Phone directory is empty</td>
    </tr>
   </table>

<h2> Project Setup </h2>
<h3> For Windows: </h3>

1) Download and install JDK 8 (set environment variables like JAVA_HOME and update PATH )
2) Download MAVEN (update Environment variables and update PATH)
3) Clone repository into IDE (E.g IntelliJ idea community edition).

<h3> Build project (Windows/Linux): </h3>

1) Execute (in cmd or powershell or Terminal): "mvn clean install" to build package. Executable jar can be found inside target folder.
2) To start application, execute: "java -jar phone-directory.jar".
3) To run tests, execute: "mvn test -Dtest=ContactControllerTest".
4) Apis can be tested using tools like Postman, with "localhost:8080/contacts"

<h3> Testing api (E.g postman): (Header field includes content-type as application/json) </h3>

1) <u> <b>Addition of a contact:

![image](https://github.com/SanketKutumbe/phone-directory/assets/30076041/ea7609dc-355f-4912-8019-f1e32a6ee3bd)


2) Modify/Updating contact:

![image](https://github.com/SanketKutumbe/phone-directory/assets/30076041/acadf30f-cc5f-46c4-87ec-6370bcdea79e)

3) Deleting a contact:

![image](https://github.com/SanketKutumbe/phone-directory/assets/30076041/19206342-71cc-447b-be07-9f536a5cdf8d)

4) Retrieving all contacts:

![image](https://github.com/SanketKutumbe/phone-directory/assets/30076041/9878ee48-0d11-4596-8c8c-f612359b89f8)

5) Searching contacts by name:

![image](https://github.com/SanketKutumbe/phone-directory/assets/30076041/afb7649f-ef68-411e-ac2d-bdfe5ec355f4)

</b></u>


   
   
