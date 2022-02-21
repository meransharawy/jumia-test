
From maven:3.8.1-jdk-8 AS build
COPY src /Jumia-test/app/src
COPY pom.xml /Jumia-test/app
RUN mvn -f /Jumia-test/app/pom.xml clean package

FROM openjdk:8-jdk
COPY --from=build /Jumia-test/app/target/countrynumberscategorization-0.0.1-SNAPSHOT.jar countrynumberscategorization-0.0.1-SNAPSHOT.jar
COPY sample.db sample.db
EXPOSE 8181
ENTRYPOINT ["java","-jar","countrynumberscategorization-0.0.1-SNAPSHOT.jar"]
