FROM openjdk:11-jdk-slim

EXPOSE 9009

WORKDIR /opt

# Add & Run Microservice
ADD okul/okul/target/okul-0.0.1-SNAPSHOT.jar /opt/
ADD okul/okul/src/main/resources/application.properties /opt/


ENTRYPOINT ["java", "-Xmx768m", "-Xms384m", "-jar", "-Dspring.config.location=/opt/", "okul-0.0.1-SNAPSHOT.jar"]
