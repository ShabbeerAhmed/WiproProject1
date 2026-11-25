FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY target/naming-server.jar naming-server.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "naming-server.jar"]
