# Use Maven with Java 17
FROM maven:3.9.9-eclipse-temurin-17

# Set working directory
WORKDIR /app

# Copy Maven configuration
COPY pom.xml .

# Copy Java source and test files
COPY src ./src

# Download project dependencies
RUN mvn dependency:resolve

# Clean and run JUnit tests
RUN mvn clean test

# Package the Maven project
RUN mvn package

# Run tests when container starts
CMD ["mvn", "test"]