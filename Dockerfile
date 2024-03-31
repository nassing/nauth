FROM openjdk:17-oracle

WORKDIR /app

COPY build.gradle settings.gradle gradlew /app/
COPY src app/src/

RUN chmod +x ./gradlew
RUN ./gradlew build

COPY --from=build /app/build/libs/nauth-1.0-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
