# 🏪 Akihabara Market - Microservicio CRUD Otaku

Bienvenido a **Akihabara Market**, un microservicio desarrollado en Spring Boot que permite gestionar productos otaku (figuras, mangas, pósters, etc.) en una tienda ficticia ambientada en Neo-Tokyo.

Este proyecto fue creado como reto para ayudar al Maestro Tanaka a modernizar su tienda otaku con tecnología de primer nivel ☁️🗼

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3.2.5
- Spring Data JPA
- Spring Web
- H2 Database (en memoria)
- Swagger (OpenAPI)
- Docker (para ejecución en contenedor)

---

## 🎯 Funcionalidades

- CRUD completo de productos
- Consola web H2 para ver la base de datos
- Validación de datos con `@Valid`
- Documentación interactiva con Swagger UI
- Datos precargados al iniciar (Figura de Luffy, Manga de Naruto, Póster de One Piece)

---

## 📦 Estructura de la API

### 🛍️ Entidad `ProductoOtaku`

| Campo      | Tipo    | Requerido |
|------------|---------|-----------|
| id         | Long    | Sí (auto) |
| nombre     | String  | ✅        |
| categoria  | String  | ✅        |
| precio     | Double  | ✅        |
| stock      | Integer | ✅        |

---

## 🔧 Endpoints disponibles

| Método | Endpoint              | Descripción                     |
|--------|-----------------------|---------------------------------|
| GET    | `/productos`          | Listar todos los productos      |
| GET    | `/productos/{id}`     | Obtener producto por ID         |
| POST   | `/productos`          | Crear nuevo producto            |
| PUT    | `/productos/{id}`     | Actualizar producto existente   |
| DELETE | `/productos/{id}`     | Eliminar producto por ID        |

---

## 🧪 Cómo ejecutar

### ✅ Opción 1: Local (sin Docker)

```bash
mvn clean install
mvn spring-boot:run

✅ Opción 2: Docker
Generar el .jar:

bash:
mvn clean package

Construir imagen:
bash:
docker build -t akihabara-market .

Ejecutar contenedor:
bash:
docker run -p 8080:8080 akihabara-market
docker run -d --name mario-kun -p 8080:8080 akihabara-market


🌐 Acceso
Swagger UI: http://localhost:8080/swagger-ui.html

Consola H2: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:otaku

Usuario: sa

Contraseña: (vacía)

👾 Créditos
Desarrollado por Mario, como parte del desafío técnico para el microservicio de la tienda Akihabara Market 🧑‍💻💥
Inspirado por el espíritu otaku y la eficiencia de Neo-Tokyo ⚔️

📁 Licencia
Este proyecto es de uso educativo y puede ser adaptado para futuras evoluciones o integraciones con bases de datos reales y seguridad avanzada.