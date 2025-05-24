# -------------------------------
# Etapa 1: Compilar el proyecto con Maven
# -------------------------------

# Imagen base con Maven 3.9.4 y Java 17 (Temurin)
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia todo el contenido del proyecto al contenedor
COPY . .

# Ejecuta Maven para limpiar y empaquetar el proyecto, saltando los tests
RUN mvn clean package -DskipTests

# -------------------------------
# Etapa 2: Crear una imagen liviana para producción
# -------------------------------

# Imagen base liviana con Java 17 (Temurin) sobre Alpine Linux
FROM eclipse-temurin:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor final
WORKDIR /app

# Copia el .jar generado en la etapa anterior al contenedor final
COPY --from=build /app/target/AkihabaraMarket-1.0.0.jar app.jar

# Expone el puerto 8080 para acceder a la aplicación desde fuera del contenedor
EXPOSE 8080

# Comando por defecto para ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
