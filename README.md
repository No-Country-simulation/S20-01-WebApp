# ![Logo del proyecto](/Nutriwise-logo.png) NutriWise 
NutriWise, es una aplicación para proponer recetas, que ofrece a cualquier 
usuario, un menú, basado en su tipo de dieta, pudiendo seleccionar comidas 
entre: desayuno,almuerzo o cena, para obtener dicha propuesta de receta.
Está conectada directamente a la IA (Gemini)

## Tabla de contenidos

- [Integrantes](#integrantes)
- [Stack](#stack)
- [Backend](#backend)
- [Frontend](#frontend)
- [Modo de uso](#modo-de-uso)
- [Tareas pendientes](#tareas-pendientes)

![Logo del proyecto](/Nutriwise-logo.png)
## Integrantes
- Claudia Duo: UX/UI
- Diógenes: Front End 
- Violeta Hours: Project Manager
- Felipe Azócar: Front End
- Elsa Beltrán: Back End

## Stack
### Backend

Framework: Spring Boot  

Dependencias:
- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Spring Boot DevTools
- Spring Boot Actuator
- Springdoc OpenApi

### Front End

Framework: Next.js + React

## Actualización version 0.0
En esta 1° etapa la aplicación es sin registro de usuario, será una marcha
blanca para enriquecer la BD, con solicitudes de recetas.
En una 2° etapa se estima ampliar sus funcionalidades, lo que implicará crear
un registro de usuario, se evaluará si se adjunta alguna suscripción de pago.

## Backend
### Documentación
https://docs.google.com/document/d/1RLhvDRR_XCYyXd2fI2uHXW0PHQtpIImdfJVsFJP_lKg/edit?usp=sharing

### Deploy
Se utiliza Docker, para generar archivo DockerFile y subirlo a Hub.docker.com para crear el repositorio
con la respectiva imagen. Se optó por esta manera, para realizar el deploy del Back End.
Con una BD externa, la cual se configura dentro de las variables de la aplicacion, la que configuras
en application.properties
Sin embargo, puedes directamente subir todo a Render desde el repo de Github
Utilizar tambien desde Render una BD.
Lo importante,ademas, es la configuracion de las variables, en Render, tanto de la BD, como
de la aplicacion, para este caso, ubicadas en application.properties

## Frontend

### Instalación

0. Cambia al directorio `frontend`
```sh
cd frontend/
```

1. Instala las dependencias de Node.js con NPM
```sh
npm install
```

2. Crea un archivo `.env` a partir de `.env.example` y reemplaza el valor de `API_URL` por la dirección donde vas a hostear la API del backend
```sh
cp .env.example .env
cat .env
API_URL=https://your-api.com/api # reemplaza esto
```

3. La instalación y configuración del frontend está completa. Puedes iniciar el frontend en un entorno de desarrollo con este comando:
```sh
npm run dev
```

## Modo de uso

Una vez tanto el backend como el frontend esten ejecutándose localmente, puedes acceder a la app en [http://localhost:3000/](http://localhost:3000/)

### Generación de recetas

Al hacer clic en "Genera tu receta" se ingresa al proceso de selección de preferencias. En primer lugar se pregunta por el tipo de comida ("Desayuno", "Almuerzo" o "Cena") y luego se pregunta por la dieta ("Balanceado", "Vegetariano" o "Sin Gluten"). Posteriormente se confirman las opciones seleccionadas y se procede a generar la receta.

## Tareas pendientes
- [ ] Definir estructura para recetas generadas
- [ ] Implementar registro de usuario y autenticación
- [ ] Incluir disponibilidad de ingredientes al generar recetas
- [ ] Implementar creación de menús diarios y semanales
- [ ] Permitir a los usuarios ingresar dietas personalizadas
- [ ] Crear una biblioteca de recetas públicas para invitados y de recetas privadas para usuarios registrados
