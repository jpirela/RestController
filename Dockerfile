# Usa una imagen oficial de OpenJDK
FROM eclipse-temurin:17-jdk

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo jar generado al contenedor
COPY target/*.jar app.jar

# Expone el puerto que Render asignará
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java","-jar","app.jar"]
