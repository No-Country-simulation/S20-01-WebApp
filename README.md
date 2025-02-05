# ![Logo del proyecto](/Nutriwise-logo.png) NutriWise 
NutriWise, es una aplicación para proponer recetas, que ofrece a cualquier 
usuario, un menú, basado en su tipo de dieta, pudiendo seleccionar comidas 
entre: desayuno,almuerzo o cena, para obtener dicha propuesta de receta.
Está conectada directamente a la IA (Gemini)

![Logo del proyecto](/Nutriwise-logo.png)
## Integrantes:
### Claudia Duo : UX/UI
### Diógenes    : Front End 
### Violeta Hours: PM
### Felipe Azócar: Front End
### Elsa Beltrán: Back End

## Datos de contacto:
## Backend

Framework: Spring Boot
## Front End

Tools: React, Figma

### Dependencias
- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Spring Boot DevTools
- Spring Boot Actuator
- Springdoc OpenApi

## Actualización version 0.0
En esta 1° etapa la aplicación es sin registro de usuario, será una marcha
blanca para enriquecer la BD, con solicitudes de recetas.
En una 2° etapa se estima ampliar sus funcionalidades, lo que implicará crear
un registro de usuario, se evaluará si se adjunta alguna suscripción de pago.

## Documentación Back End
https://docs.google.com/document/d/1RLhvDRR_XCYyXd2fI2uHXW0PHQtpIImdfJVsFJP_lKg/edit?usp=sharing

## Deploy Back End
Se utiliza Docker, para generar archivo DockerFile y subirlo a Hub.docker.com para crear el repositorio
con la respectiva imagen. Se optó por esta manera, para realizar el deploy del Back End.
Con una BD externa, la cual se configura dentro de las variables de la aplicacion, la que configuras
en application.properties
Sin embargo, puedes directamente subir todo a Render desde el repo de Github
Utilizar tambien desde Render una BD.
Lo importante,ademas, es la configuracion de las variables, en Render, tanto de la BD, como
de la aplicacion, para este caso, ubicadas en application.properties

## Front End
