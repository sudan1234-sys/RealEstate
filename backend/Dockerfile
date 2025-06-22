# Use a valid base image
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory inside container
WORKDIR /app

# Copy project files
COPY . .

# Build the project using Maven
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17

WORKDIR /app

# Copy built jar from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose port (same as in application)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
