# learnWebService
This is a demo focusing on how to generate a web service and how to consume a web service

## project_01: this is a Dynamic Web Project
This is used to generate web service.

project_01 structure:

![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/17b58bf6-cb66-41e5-9c81-8e94ea438273)

1. JdbcSQLServerConnection.java -> set up connect to SQL server db
   Note:
   a) In case you use property file to store key/value, file must locate in same place (same folder/package) with java file in order to use class.getResourceAsStream().
   If it is placed in WEB-INF/config/, it returns 'null' when using use class.getResourceAsStream()

   b) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver") -> this line is mandatory
   Without this line, this error shown up while testing web service "java.sql.SQLException: No suitable driver found for 
        	   jdbc:sqlserver://DESKTOP-QQE9C8H\SQLEXPRESS;database=AdventureWorksLT2012;user=sa;password=12345;encrypt=true;trustServerCertificate=true;
   
2. CustomerAPI.java -> method must return Array instead of List 
  Cause the JAX-RPC specification does not support certain data types, such as java.util.List, directly. Instead, it supports arrays for serializing and deserializing data

3. Right click on CustomerAPI.java > Web Services > Create Web Service -> create a web service
 
![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/5b5649b0-14a4-46de-8d91-abe69b3e65c2)


## AppConsumeWS: this is a Maven Project
This is used to consume web service

AppConsumeWS structure:

![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/5f0e52ec-0d52-476a-abaf-fb619d2d4a87)

1. Copy and paste wsdl file into src/main/resourses

2. Import this plugin: cxf-codegen-plugin (add to pom.xml) to generate java files from wsdl file (wsdl2java)
   Note:
   packagename is the package where these wsdl files will be extracted into. As default, this package will be auto generated inside: /AppConsumeWS/target/generated-sources/cxf/
   
![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/378b3efd-ffde-412f-a56f-4563038b63c2)

3. ConsumeWebServiceServlet.java -> to consume web service and display result on webpage

## TESTING:

Run on server AppConsumeWS -> When you add multiple projects to Tomcat and run the server, all the deployed projects will be active and running simultaneously. As default, running on same port (8080).
And each project will be accessible via its corresponding URL context path. This allows you to deploy and manage multiple web applications within the same Tomcat server instance

![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/f8634bd9-577d-40cb-9811-4ce69dc2be59)

![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/6ce06543-fec0-4b51-aad3-6829267d91e5)

After clicking Get Customers btn, data will be retrieved from SQL server db [via the imported web service (wsdl files)] and display on webpage properly.

![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/1ebe70f3-5969-4962-bc95-893e27869b57)


