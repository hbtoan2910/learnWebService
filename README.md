# learnWebService
This is a demo focusing on how to generate a web service and how to consume a web service

## project_01: this is a Dynamic Web Project
This is used to generate web service
project_01 structure:
![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/17b58bf6-cb66-41e5-9c81-8e94ea438273)
1. JdbcSQLServerConnection.java -> set up connect to SQL server db
   Note:
   a) In case you use property file to store key/value, file must locate in same place (same folder/package) with java file in order to use class.getResourceAsStream().
   If it is placed in WEB-INF/config/, it returns 'null' when using use class.getResourceAsStream()

   b) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver") -> this line is mandatory
   Without this line, this error shown up while testing web service "java.sql.SQLException: No suitable driver found for 
        	   jdbc:sqlserver://DESKTOP-QQE9C8H\SQLEXPRESS;database=AdventureWorksLT2012;user=sa;password=12345;encrypt=true;trustServerCertificate=true;
   
2.CustomerAPI.java -> method must return Array instead of List 
  Cause the JAX-RPC specification does not support certain data types, such as java.util.List, directly. Instead, it supports arrays for serializing and deserializing data

3. Right click on CustomerAPI.java > Web Services > Create Web Service -> create a web service
![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/5b5649b0-14a4-46de-8d91-abe69b3e65c2)


## AppConsumeWS: this is a Maven Project
This is used to consume web service
AppConsumeWS structure:
![image](https://github.com/hbtoan2910/learnWebService/assets/59778636/5f0e52ec-0d52-476a-abaf-fb619d2d4a87)
