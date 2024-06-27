FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/gestor-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} gestor.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "gestor.jar"]