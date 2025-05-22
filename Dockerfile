# Etapa 1: Compilar el proyecto con Maven
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Imagen liviana para producción
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/AkihabaraMarket-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
