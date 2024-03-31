FROM openjdk:17-alpine as build

WORKDIR /app

COPY build.gradle settings.gradle gradlew /app/
COPY src /app/src/
COPY gradle /app/gradle/

RUN chmod +x ./gradlew
RUN ./gradlew clean build

COPY /build/libs/nauth-1.0-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
