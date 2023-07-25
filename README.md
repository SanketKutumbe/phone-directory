# Phone Directory
It provides api to add, modify, delete, search and retrieval of all contacts. Contact information includes name, phone and email.

# Project Architecture Flow:

![](C:\Users\adsan\Downloads\phone-directory.drawio.png)

<h2> Project Setup </h2>
<h3> For Windows: </h3>

1) Download and install JDK 8 (set environment variables like JAVA_HOME and update PATH )
2) Download MAVEN (update Environment variables and update PATH)
3) Clone repository into IDE (E.g IntelliJ idea community edition).

<h3> Build project (Windows/Linux): </h3>

1) Execute (in cmd or powershell or Terminal): "mvn clean install" to build package. Executable jar can be found inside target folder. While project building, it will take care of unit tests execution.
2) Execute: "java -jar phone-directory.jar" in order to start spring application.
3) Apis can be tested using tools like Postman, with "localhost:8080/contacts"

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


   
   
