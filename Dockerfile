# Imagen base: Java 17 con Alpine Linux
FROM eclipse-temurin:17-jdk-alpine

# Autor de la imagen (opcional)
LABEL author="mario"

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el JAR generado al contenedor
COPY target/AkihabaraMarket-1.0.0.jar app.jar

# Exponer el puerto 8080 para que el contenedor lo abra
EXPOSE 8080

# Comando que se ejecuta al iniciar el contenedor
ENTRYPOINT ["java", "-jar", "app.jar"]
