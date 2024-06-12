# learnWebService
This is a demo focusing on how to generate a web service and how to consume a web service

## project_01: this is a Dynamic Web Project
### This is used to generate web service.

project_01 structure:

First creation:

![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/c3e72bec-b5c5-4103-88e7-a618f5daea66)

![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/603f17c7-c726-47cd-9f17-ce442d7b591a)

When creating web service from HelloWorld.java:

![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/9d294513-b893-4cb4-8812-5cef78ee0416)

![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/1350853d-4ae6-4bc0-abdd-2bb2da61dcfe)

Test using Web Services Explorer:

![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/fabe1963-42d8-4648-aa18-a9c89492acdf)


Final:

![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/17b58bf6-cb66-41e5-9c81-8e94ea438273)

#### SUPER IMPORTANCE:

USE:

Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)

Version: 2023-03 (4.27.0) -> generate web service (wsdl file) properly WITHOUT any error using Tomcat9 + Axis (Deprecated)

![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/d85d49fd-8e33-4ab5-a196-d0c9bcc5e275)

DON'T USE:

Other lastest versions of Eclipse including:

Eclipse IDE for Java Developers (includes Incubating components)

Version: 2024-03 (4.31.0) -> generate web service (wsdl file) properly WITH any error using Tomcat9 + Axis (Deprecated)

![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/54e0b9e1-1d37-49e6-8221-6563b2f70f21)



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
### This is used to consume web service

AppConsumeWS structure:

![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/5f0e52ec-0d52-476a-abaf-fb619d2d4a87)

1. Copy and paste wsdl file into src/main/resourses

2. Import this plugin: cxf-codegen-plugin (add to pom.xml) to generate java files from wsdl file (wsdl2java)
   Note:
   
   packagename is the package where these wsdl files will be extracted into. As default, this package will be auto generated inside: /AppConsumeWS/target/generated-sources/cxf/
   
![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/378b3efd-ffde-412f-a56f-4563038b63c2)

3. ConsumeWebServiceServlet.java -> to consume web service and display result on webpage



## TESTING:

Run on server AppConsumeWS 

-> When you add multiple projects to Tomcat and run the server, all the deployed projects will be active and running simultaneously. As default, running on same port (8080).
And each project will be accessible via its corresponding URL context path. This allows you to deploy and manage multiple web applications within the same Tomcat server instance.

![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/f8634bd9-577d-40cb-9811-4ce69dc2be59)

![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/6ce06543-fec0-4b51-aad3-6829267d91e5)

After clicking Get Customers btn, data will be retrieved from SQL server db [via the imported web service (wsdl files)] and display on webpage properly.

![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/1ebe70f3-5969-4962-bc95-893e27869b57)


## EXTRA: run each project with Tomcat9 but with DIFFERENT ports

1. Right click on each project > Export > WAR file (After that, we got: AppConsumeWS.war & project_01.war)

2. Create new folder: Tomcat9-Instance1

3. Copy [ conf, webapps and temp folders ] from C:\apache-tomcat-9.0.86 and paste them to C:\Tomcat9-Instance1
   
   You can delete contents from webapps and temp folders located under instance1, but don't touch conf contents
   
4. Copy > paste C:\Tomcat9-Instance1 and rename it to Tomcat9-Instance2. That way, both Tomcat9-Instance1 and Tomcat9-Instance2 will have the same content.

5. Go to C:\Tomcat9-Instance2\conf, edit server.xml and change the numbers of these ports (I marked those as XXXX):

   `<Server port="XXXX" shutdown="SHUTDOWN">`
      
   `<Connector port="XXXX" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" />`
   
   `<Connector port="XXXX" protocol="AJP/1.3" redirectPort="8443" />`

   Example:

   C:\Tomcat9-Instance1\conf\server.xml. In its content, focus on these 3 elements:
   
   `<Server port="8005" shutdown="SHUTDOWN">`
   
    `<Connector port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443"
               maxParameterCount="1000"
               />`

    `<Connector protocol="AJP/1.3"
               address="::1"
               port="8009"
               redirectPort="8443"
               maxParameterCount="1000"
               />`
   
   C:\Tomcat9-Instance2\conf\server.xml. In its content, focus on these 3 elements:

   `<Server port="7005" shutdown="SHUTDOWN">`

   `<Connector port="7001" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443"
               maxParameterCount="1000"
               />`

   `<Connector protocol="AJP/1.3"
               address="::1"
               port="7009"
               redirectPort="8443"
               maxParameterCount="1000"
               />`
   
   
7. Deploy project_01.war to Tomcat9-Instance1\webapps and AppConsumeWS.war to Tomcat9-Instance2\webapps

8. Create the following 4 batch files:

   File: instance1_startup.bat (create a txt file and paste the content)
   
   @echo off
   
   set CATALINA_BASE=C:\Tomcat9-Instance1
   
   cd "%CATALINA_HOME%\bin"
   
   set TITLE=My Tomcat Instance 01
   
   call startup.bat %TITLE%
   

   File: instance1_shutdown.bat
   
   @echo off
   
   set CATALINA_BASE=C:\Tomcat9-Instance1
   
   cd "%CATALINA_HOME%\bin"
   
   call shutdown.bat
   

   File: instance2_startup.bat
   
   @echo off
   
   set CATALINA_BASE=C:\Tomcat9-Instance2
   
   cd "%CATALINA_HOME%\bin"
   
   set TITLE=My Tomcat Instance 02
   
   call startup.bat %TITLE%


   File: instance2_shutdown.bat
   
   @echo off
   
   set CATALINA_BASE=C:\Tomcat9-Instance2
   
   cd "%CATALINA_HOME%\bin"
   
   call shutdown.bat

9. Run instance1_startup.bat and instance2_startup.bat, it should work :")

![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/f580db94-b968-4615-8ad2-dc968ccc8e04)

![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/9f5ee5da-c9ca-4740-8507-06c34f3057cd)

![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/b1fd149b-6180-49dc-b3a7-01a08f8fa2ea)


## Reference links:

https://stackoverflow.com/questions/16110528/tomcat-multiple-instances-simultaneously/21945707#21945707

