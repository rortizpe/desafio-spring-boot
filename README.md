# Task Management API

Este proyecto corresponde al desafío técnico de **Previred** para el puesto de desarrollador backend. El objetivo fue implementar una API RESTful para la gestión de tareas y usuarios, utilizando **Java 17**, **Spring Boot 3.4.x**, autenticación con **JWT**, persistencia con **H2 en memoria**, y documentación con **Swagger/OpenAPI**.

---

## Tecnologías Utilizadas

- Java 17
- Spring Boot 3.4.x
- Spring Security (con JWT)
- H2 Database (en memoria)
- JPA/Hibernate
- OpenAPI 3 / Swagger UI
- Maven

---

## Estructura del Proyecto

El proyecto sigue una arquitectura en capas, respetando principios SOLID y buenas prácticas:

- `controller`: Exposición de endpoints RESTful.
- `service`: Lógica de negocio.
- `repository`: Capa de acceso a datos con JPA.
- `model`: Incluye entidades JPA, DTOs.

---

## Base de Datos

La aplicación utiliza una base de datos **H2 en memoria**. Al iniciar, se cargan automáticamente los siguientes datos:

### Estados de Tarea (`task_status`):

| ID | Nombre       |
|----|--------------|
| 1  | PENDING      |
| 2  | IN_PROGRESS  |
| 3  | COMPLETED    |

### Usuario por defecto:

- **Usuario**: `raul`
- **Contraseña**: `password123` (encriptada con BCrypt)

### Tarea inicial:

```json
{
  "id": 1,
  "title": "Tarea inicial",
  "description": "Primera tarea demo",
  "status": "PENDING",
  "user": "raul"
}
```

---

## Seguridad y Autenticación

La autenticación se realiza mediante JWT.

### Endpoint de Login

```http
POST /auth/login
Content-Type: application/json
```

#### Body:
```json
{
  "username": "raul",
  "password": "password123"
}
```

#### Respuesta:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "username": "raul"
}
```

Una vez autenticado, el token debe enviarse en el encabezado `Authorization` para todos los demás endpoints:

```
Authorization: Bearer <token>
```

---

## Endpoints CRUD de Tareas

Todos los siguientes endpoints requieren autenticación:

### Crear Tarea

```http
POST /tasks
Authorization: Bearer <token>
Content-Type: application/json
```

```json
{
  "title": "Nueva tarea",
  "description": "Descripción opcional",
  "statusId": 1
}
```

### Obtener todas las tareas

```http
GET /tasks
Authorization: Bearer <token>
```

### Obtener tarea por ID

```http
GET /tasks/{id}
Authorization: Bearer <token>
```

### Actualizar tarea

```http
PUT /tasks/{id}
Authorization: Bearer <token>
Content-Type: application/json
```

```json
{
  "title": "Tarea actualizada",
  "description": "Nuevo detalle",
  "statusId": 2
}
```

### Eliminar tarea

```http
DELETE /tasks/{id}
Authorization: Bearer <token>
```

---

## Documentación Swagger

La API está documentada con Swagger UI y puede ser visualizada en:

```
http://localhost:8080/swagger-ui/index.html
```

---

## Cómo Ejecutar

1. Clonar el repositorio.
2. Ejecutar `mvn spring-boot:run` o correr desde el IDE.
3. Acceder a:
    - API: http://localhost:8080
    - Swagger: http://localhost:8080/swagger-ui/index.html
    - H2 Console: http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:mem:taskdb`, user: `sa`, sin password)

---

## API First (OpenAPI)

La definición `openapi.yml` se encuentra en el repositorio en la raíz. La estructura de los controladores se ha alineado con el diseño propuesto desde esta especificación.

---

## Autor

Raúl Ortiz  
Postulante al cargo de Desarrollador Backend  
