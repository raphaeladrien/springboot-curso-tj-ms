FROM openjdk:17-slim

ENV APP_HOME /app
WORKDIR /app

COPY src src

COPY .mvn .mvn
COPY ["mvnw", "pom.xml", "$APP_HOME/"]

RUN bash mvnw clean package
CMD ["java", "-jar", "target/hello-0.0.1-SNAPSHOT.jar"]
