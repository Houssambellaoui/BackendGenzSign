# Use an official OpenJDK runtime as the base image
FROM openjdk:19-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the project source code into the container
COPY . .

# Run the Maven build to generate the JAR file
RUN ./mvnw clean package -DskipTests

# Expose the port the app will run on
EXPOSE 8080

# Define the command to start the Spring Boot application
CMD ["java", "-jar", "target/Barid-0.0.1-SNAPSHOT.jar"]