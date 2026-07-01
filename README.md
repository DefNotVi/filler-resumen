# Microservicio Backend Resumen - Historial de Likes/Dislikes

## Descripción
Este microservicio desacoplado se encarga exclusivamente de procesar, registrar y mantener el historial de las interacciones (likes y dislikes) realizadas por el usuario desde el frontend, consume los datos provistos por el microservicio principal 
y opera mediante una API REST

## Tecnologías Utilizadas
* Java con Spring Boot
* Arquitectura basada en microservicios desacoplados

## Requisitos e Instalación
* Clonar el repositorio
* Configurar las propiedades del entorno en el archivo `src/main/resources/application.properties` (SOLO SI ES NECESARIO)
* Ejecutar con el [botón de Ejecutar](https://i.imgur.com/pWEN7D2.png) o con el comando para ejecutar de manera local: `.\mvnw.cmd spring-boot:run`

## Endpoints de la API (Endpoints REST)
* `GET api/reacciones/likes` - Obtiene Los likes
* `POST api/reacciones/likes` - Obtiene los dislikes

## Ejecución de Pruebas Unitarias
* Comando para correr los tests: `.\mvnw.cmd test`.
