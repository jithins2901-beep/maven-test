# Stage 1: Build and test
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copy Maven configuration first for better caching
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Run JUnit tests
RUN mvn clean verify

# Stage 2: Production runtime
FROM eclipse-temurin:21-jre

WORKDIR /app

# Create non-root user
RUN groupadd -r appgroup && useradd -r -g appgroup appuser

# Copy packaged JAR
COPY --from=build /app/target/*.jar app.jar

# Set permissions
RUN chown appuser:appgroup app.jar

USER appuser

EXPOSE 8080

# Run Java application
ENTRYPOINT ["java", "-jar", "app.jar"]