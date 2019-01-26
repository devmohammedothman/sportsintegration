# sports Integration Application

This project build to integrate with Strava API or other similr Sports API to provide integration from Client API and save this data into database.

Project Architecture:
Project build as Maven Multi Module project with child modules as follows

sports-parent :Parent Module project

sports-integration : Spring Boot project that provide Service Implementation,Dao Implememntation, Rest Controller, Schedueled Tasks for Integration, Entity Classes that map database tables and other Util Classes that help in development phase such as 
ResponeDTO
ResponseError
RestProvider
RestUtils
SportsApplicationException
AppLoggingAspect using spring AOP for logging
General Exception Handling with Controller Advice

sports-integration-gen-client: Spring Boot project that built with swagger code gen tool to provide all api client related modules like (invoke api,model api classes)

this client generated based on rest template using this command :

java -jar swagger-codegen-cli-2.4.1.jar generate 
  -i https://developers.strava.com/swagger/swagger.json 
  --api-package com.quasas.sports.gen.client.api 
  --model-package com.quasas.sports.gen.client.model 
  --invoker-package com.quasas.sports.gen.client.invoker 
  --group-id com.quasas.sports.gen.client 
  --artifact-id sports-integration-gen-client 
  --artifact-version 0.0.1-SNAPSHOT 
  -l java 
  --library resttemplate 
  -o sports-integration-gen-client

sports-integration-simple-client: sprig Boot project that build as a simple client api that was used to communicate with API and generate access token , but later on i decided to use generated client to benefit from its wide range classes and i had to customize in this generated client to be able to get access token based on properties config file.

sports-angular-interface: Simple Angular 7 project which represent simple user interface of what is currently exist in Database.

How TO Run:
Since Strava API doesn't support Client Credentials of oauth flow so you have to get authorization code firstly by your self 
follow below steps:

1-you need to hava Strava Account and then go to this url : https://www.strava.com/settings/api
to create your application.

2-after that you need to click on "OAuth Authorization page" which will redirect you to another page in which there is authorize button

3-after click on authorize button you will be redirected to another page with code value in url of your browser 

for example : "http://localhost:8080/?state=&code=87e5dac0a2d7bb84ef844bc25a545aa09c73a1ed&scope="

Now you can get this code and your client id , client secret and put in application.properties in spring-integration project

Make sure of:

there is dbscript.sql file that need to be run on your MYsql database which will create table for saving activities.

Set your Database server user name and password in application.properties file

Change path of Log File according to your file system in Log4j2.xml 

Inside project spring-parent run mvn clean install

Inside project spring-integration run mvn spring-boot:run

Hit this URL from your browser or post man 
http://localhost:8080/sports/api/activity to see current activities in DB
http://localhost:8080/sports/api/activity/2084377508 to get specific activity with id in Strava API (Source ID)
