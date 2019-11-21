FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar tech-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/tech-0.0.1-SNAPSHOT.jar"]
