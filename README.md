# Sistema de Gestión de Tickets para Incidentes Tecnológicos

🚀 **Aplicación en vivo:** [https://web-production-0776.up.railway.app/](https://web-production-0776.up.railway.app/)

📦 **Repositorio GitHub:** [https://github.com/gsvillacis/demo-mongo-tickets](https://github.com/gsvillacis/demo-mongo-tickets)

## 👩‍💻 Información del Desarrollador

- **Nombre:** Gissela Stefania Villacis Villacis
- **Correo electrónico:** [gsvillacis@utpl.edu.ec](mailto:gsvillacis@utpl.edu.ec)
- **Empresa:** Banco Pichincha
- **Proyecto:** Sistema de Gestión de Tickets para incidentes tecnológicos para Banco Pichincha

## Descripción

Aplicación web desarrollada con Spring Boot y Java para la gestión de tickets de incidentes. Permite crear, editar, visualizar y administrar tickets con diferentes estados y prioridades.

## Características

- **Gestión completa de tickets** con ID único autogenerado
- **Estados**: Nuevo, En Proceso, Resuelto
- **Prioridades**: P1-Crítico, P2-Alto, P3-Medio, P4-Bajo
- **Interfaz web responsiva** con Bootstrap 5
- **Base de datos MongoDB** para almacenamiento
- **Formularios mejorados** para mejor UX

## Tecnologías

- Java 17
- Spring Boot 3.5.4
- Spring Data MongoDB
- Thymeleaf
- Bootstrap 5
- Maven

## Estructura del Proyecto

```text
src/
├── main/
│   ├── java/com/utpl/demo_mongo/
│   │   ├── controller/         # Controladores REST
│   │   ├── models/            # Entidades/Modelos
│   │   ├── repository/        # Repositorios MongoDB
│   │   ├── service/           # Lógica de negocio
│   │   └── enums/             # Enumeraciones
│   └── resources/
│       ├── templates/         # Vistas Thymeleaf
│       └── application.properties
└── test/
```

## Campos del Ticket

- **ID**: Generado automáticamente (único)
- **Nombre de la persona**: Quien registra el ticket
- **Número de contacto**: Teléfono o email
- **Aplicación afectada**: Sistema con problemas
- **Prioridad**: P1, P2, P3, P4
- **Grupo resolutor**: Equipo responsable
- **Descripción**: Descripción detallada del problema
- **Acciones de recuperación**: Acciones tomadas para resolver
- **Estado**: Nuevo (por defecto), En Proceso, Resuelto
- **Fecha de creación**: Timestamp automático

## Ejecutar localmente

```bash
./mvnw spring-boot:run
```

## Variables de entorno para Railway

- `MONGODB_URI`: URI de conexión a MongoDB
- `PORT`: Puerto del servidor (configurado automáticamente)

## Despliegue en Railway

✅ **Aplicación desplegada:** [https://web-production-0776.up.railway.app/](https://web-production-0776.up.railway.app/)

### Pasos de deployment

1. Conectar repositorio de GitHub
2. Configurar MongoDB Atlas como base de datos
3. Establecer variable de entorno MONGODB_URI
4. Desplegar automáticamente

### Configuración de producción

- **Base de datos:** MongoDB Atlas (M0 Sandbox)
- **Plataforma:** Railway
- **Variables de entorno:** MONGODB_URI, PORT
- **Repositorio:** [https://github.com/gsvillacis/demo-mongo-tickets](https://github.com/gsvillacis/demo-mongo-tickets)
