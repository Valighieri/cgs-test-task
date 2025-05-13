FROM maven:3.9.8-eclipse-temurin-21 AS build
COPY ./src /cgs-test-task/src
COPY ./pom.xml /cgs-test-task

WORKDIR /cgs-test-task
RUN mvn -f pom.xml clean install -DskipTests

FROM openjdk:21-slim
COPY --from=build /cgs-test-task/target/*.jar cgs-test-task.jar
ENTRYPOINT ["java","-jar","cgs-test-task.jar"]