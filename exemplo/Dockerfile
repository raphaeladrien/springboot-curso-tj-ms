FROM openjdk:17-slim as build

ENV APP_HOME /app
WORKDIR /app

COPY src src

COPY .mvn .mvn
COPY ["mvnw", "pom.xml", "$APP_HOME/"]

RUN bash mvnw clean package

FROM openjdk:17-slim as app

# Env variables
ENV APP_HOME /app

# Workdir creation
WORKDIR $APP_HOME
COPY --from=build /app/target/exemplo-0.0.1-SNAPSHOT.jar .


CMD ["java", "-jar", "exemplo-0.0.1-SNAPSHOT.jar"]
