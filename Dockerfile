FROM openjdk:17-jdk-alpine
VOLUME /tmp
EXPOSE 8081
ARG JAR_FILE=target/AssesmentFinal-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} java-app.jar
ENTRYPOINT ["java", "-jar", "java-app.jar"]