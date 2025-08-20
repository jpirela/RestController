# Etapa 1: Construir la aplicación con Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copiar pom.xml y descargar dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar el resto del código fuente y construir el jar
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Ejecutar la aplicación
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copiar el jar desde la etapa de construcción
COPY --from=builder /app/target/*.jar app.jar

# Exponer el puerto asignado por Render
EXPOSE 8080

# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]
