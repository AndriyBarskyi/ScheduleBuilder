FROM eclipse-temurin:11-jre-jammy AS base
WORKDIR /app

COPY build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
