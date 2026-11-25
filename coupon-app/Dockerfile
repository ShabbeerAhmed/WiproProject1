FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY target/coupon-app.jar coupon-app.jar

EXPOSE 8086

ENTRYPOINT ["java", "-jar", "coupon-app.jar"]
