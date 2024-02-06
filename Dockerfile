FROM openjdk:17-jdk-alpine
ADD . /src
WORKDIR /src
RUN ./mvnw package -DskipTests
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "target/dashboard_test-0.0.1-SNAPSHOT.jar"]
