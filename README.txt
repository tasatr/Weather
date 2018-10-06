
To run this service, execute the following command in command line, in project root directory:

./gradlew build && java -jar build/libs/weather-service-0.1.0.jar

This will run the tests, and if successful, will deploy the application by default to

http://localhost:8080/weather?station=Tallinn-Harku

If you want to change the port to e.g. 9090, run this:

./gradlew build && java -jar build/libs/weather-service-0.1.0.jar --server.port=9090

http://localhost:9090/weather?station=Tallinn-Harku

Deploying to multiple URLs:
It is easy to configure different ports and mappings for the same service on Spring Boot.

In order to deploy to different application servers (test server 1, test server2) I would 
write a Jenkins Pipeline, which deploys to as many servers as necessary once the tests pass.
