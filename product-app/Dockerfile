FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY target/product-app.jar product-app.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "product-app.jar"]
