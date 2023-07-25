# Phone Directory
It provides api to add, modify, delete, search and retrieval of all contacts. Contact information includes name, phone and email.

# Project Architecture Flow:

![image](https://github.com/SanketKutumbe/phone-directory/assets/30076041/f639cee5-317b-4571-a1b4-feb8b75ed45c)


<h2> Project Setup </h2>
For Windows:
1) Download and install JDK 8 (set environment variables like JAVA_HOME and update PATH )
2) Download MAVEN (update Environment variables and update PATH)
3) Clone repository into IDE (E.g IntelliJ idea community edition).

Build project (Windows/Linux):
1) Execute (in cmd or powershell or Terminal): "mvn clean install" to build package. Executable jar can be found inside target folder. While project building, it will take care of unit tests execution.
2) To start spring application, execute: "java -jar phone-directory.jar"
3) To run tests, execute: "mvn test -Dtest=ContactControllerTest" 
4) Apis can be tested using tools like Postman, with "localhost:8080/contacts"

Testing api (E.g postman): (Header field includes content-type as application/json)
1) Addition of a contact:

   ![image](https://github.com/SanketKutumbe/phone-directory/assets/30076041/ea7609dc-355f-4912-8019-f1e32a6ee3bd)


3) Modify/Updating contact:

   ![image](https://github.com/SanketKutumbe/phone-directory/assets/30076041/acadf30f-cc5f-46c4-87ec-6370bcdea79e)


4) Deleting a contact:

   ![image](https://github.com/SanketKutumbe/phone-directory/assets/30076041/19206342-71cc-447b-be07-9f536a5cdf8d)


5) Retrieving all contacts:

   ![image](https://github.com/SanketKutumbe/phone-directory/assets/30076041/9878ee48-0d11-4596-8c8c-f612359b89f8)


7) Searching contacts by name:

   ![image](https://github.com/SanketKutumbe/magic-dice-game/assets/30076041/e7d57335-5886-4d29-b1e6-3fa637943db8)



   
   
