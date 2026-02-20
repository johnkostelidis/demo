# FIXED: Updated to a Java 25 image to match your pom.xml
FROM eclipse-temurin:25-jre-alpine

COPY target/demo-0.0.1-SNAPSHOT.jar demo.jar
ENTRYPOINT ["java","-jar","demo.jar"]