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

   ![image](https://github.com/SanketKutumbe/phone-directory/assets/30076041/ea7609dc-355f-4912-8019-f1e32a6ee3bd)


3) Modify/Updating contact:

   ![image](https://github.com/SanketKutumbe/phone-directory/assets/30076041/acadf30f-cc5f-46c4-87ec-6370bcdea79e)


4) Deleting a contact:

   ![image](https://github.com/SanketKutumbe/phone-directory/assets/30076041/19206342-71cc-447b-be07-9f536a5cdf8d)


5) Retrieving all contacts:

   ![image](https://github.com/SanketKutumbe/phone-directory/assets/30076041/9878ee48-0d11-4596-8c8c-f612359b89f8)


7) Searching contacts by name:

   ![image](https://github.com/SanketKutumbe/phone-directory/assets/30076041/a02d7799-ac7f-4a90-9ab1-fdb919ef9d50)




   
   
