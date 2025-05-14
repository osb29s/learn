FROM openjdk:17-jdk-slim AS build

WORKDIR /app

COPY mvnw pom.xml ./

COPY src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
