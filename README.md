# Fabric3 Spring Boot Sample Application

This sample is currently a work-in-progress under active development. To compile and run, you will first need to built the v3.0 SNAPSHOT versions of the
following repositories:

1. https://github.com/Fabric3/fabric3-gradle-plugins

2. https://github.com/Fabric3/fabric3-core

3. https://github.com/Fabric3/fabric3-spring-boot


Then to compile:

./gradlew bootRepackage

and to run:

java -jar build/libs/spring-boot-sample-0.0.1-SNAPSHOT.jar
