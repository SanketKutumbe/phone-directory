# Phone Directory
It provides api to add, modify, delete, search and retrieval of all contacts. Contact information includes name, phone and email.

<h2> Tech-stack used: </h2>
<h3> Java-8, REST, Spring-boot framework, JUnit5 framework, MAVEN </h3>

<h2> Project Setup </h2>
For Windows:
1) Download and install JDK 8 (set environment variables like JAVA_HOME and update PATH )
2) Download MAVEN (update Environment variables and update PATH)
3) Clone repository into IDE (E.g IntelliJ idea community edition).

Build project (Windows/Linux):
1) Execute (in cmd or powershell or Terminal): "mvn clean install" to build package. Executable jar can be found inside target folder. While project building, it will take care of unit tests execution.
2) Execute: "java -jar phone-directory.jar" in order to start spring application.
3) Apis can be tested using tools like Postman, with "localhost:8080/contacts"

Testing api (E.g postman): (Header field includes content-type as application/json)
1) Addition of a contact:
     ![image](https://github.com/SanketKutumbe/phone-directory/assets/30076041/2816d184-9f5e-498d-9c5c-ff45216bc071)

2) Modify/Updating contact:
   ![image](https://github.com/SanketKutumbe/phone-directory/assets/30076041/537c0f02-52eb-4729-87b1-378dac9ee9cf)

3) Deleting a contact:
    ![image](https://github.com/SanketKutumbe/phone-directory/assets/30076041/d0869597-efd9-42fe-8809-7199e939f4cb)

4) Retrieving all contacts:
   ![image](https://github.com/SanketKutumbe/phone-directory/assets/30076041/25856333-5cfe-438b-939b-29934a840964)

5) Searching contacts by name:
   ![image](https://github.com/SanketKutumbe/phone-directory/assets/30076041/e04d1c51-c6db-47a7-bab5-72989d0528db)



   
   
