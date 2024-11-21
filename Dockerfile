# Use an OpenJDK image with JDK 17
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Maven build file
COPY target/CraftProject2-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port (assuming 8080)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
