FROM maven:3.8.5-openjdk-17 AS builder

WORKDIR /app

# Copiar el archivo pom.xml y el código fuente
COPY pom.xml .
COPY src ./src

# Construir el proyecto y empaquetar el JAR
RUN mvn clean package -DskipTests=true

# Usar una imagen base de OpenJDK para ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR del contenedor builder
COPY --from=builder /app/target/backend-luisguzman-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]