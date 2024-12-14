# Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/pulsarservice-0.0.1-SNAPSHOT.jar /app/pulsarservice.jar

# Expose the application port
EXPOSE 8080

# Run the Java application
CMD ["java", "-jar", "/app/pulsarservice.jar"]