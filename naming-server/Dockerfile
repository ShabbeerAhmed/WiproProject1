# Use Java 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy the built jar file (verify the exact jar name in your target folder)
COPY target/*.jar app.jar

# Expose the port configured for naming-server (commonly 8761)
EXPOSE 8761

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
