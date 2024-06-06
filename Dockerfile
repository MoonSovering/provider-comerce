FROM gradle:7.3.0-jdk17 AS build

WORKDIR /app

COPY . /app

RUN chmod +x ./gradlew
RUN ./gradlew build

FROM openjdk:21-jdk-nanoserver

EXPOSE 3800

COPY --from=build /app/build/libs/shop-0.0.1-SNAPSHOT.jar /app/shop-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/shop-0.0.1-SNAPSHOT.jar"]