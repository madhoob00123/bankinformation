FROM openjdk:8-jdk-alpine

MAINTAINER "Armando Reyna"

COPY build/libs/bankapp-0.0.1-SNAPSHOT.jar /bankInfo.jar

WORKDIR /

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom" ,"-Dspring.profiles.active=default,cloud","-jar","/bankInfo.jar"]