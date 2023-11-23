FROM openjdk:17-slim as build

ENV APP_HOME /app
WORKDIR /app

COPY src src
COPY .mvn .mvn

COPY ["mvnw", "pom.xml", "$APP_HOME/"]

RUN bash mvnw clean package

FROM gcr.io/distroless/java17-debian11:nonroot AS service-registry

ENV APP_HOME /app
WORKDIR /app

COPY --from=build /app/target/cadastro-0.0.1-SNAPSHOT.jar .

CMD ["cadastro-0.0.1-SNAPSHOT.jar"]
