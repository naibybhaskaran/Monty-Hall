#Monty Hall game simulation

Prerequisites: Java 1.11, Maven 4.0.

This Monty Hall Simulation application will shows the probability to win the game based on the STICK or CHANGE strategy. 

To package the application, run the following command in command line:

    mvn clean install  

To run the application - use the jar file created in the previous step. Make sure the port 8080 is available:

    java -jar target/monty-hall-1.0.0.jar

 To access the application, go to your browser or in POSTMAN (https://www.postman.com/downloads/)
 
     http://localhost:8080/playgame/v1
     http://localhost:8080/playgame/v1?limit=50000
     
 To run the tests from the command line using maven:
 
    mvn clean test
 
 To see the documentation, import the the monty-hall.yaml file in Swagger Editor(https://editor.swagger.io/)
