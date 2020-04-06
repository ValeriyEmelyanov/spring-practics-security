# Пример Spring Boot приложения с авторизацией и хранением пользователей в MongoDB

Пример Spring Boot приложения с Session Based Authentication  и хранением пользователей в MongoDB.
Приложение не выполняет полезной работы, просто выводит на экран "Hello world".

### Испольхуемые технологии

* Java 8
* Spring Boot, Spring Security
* Lombok
* MongoDB
* Maven
* Tomcat
* FreeMarker

### Запуск MongoDB

`    mongod --storageEngine=mmapv1 --dbpath C:\data\db\spring-practics`

### Сборка и запуск приложения

`mvn spring-boot:run`

### Endpoints
* `/` - корневой каталог
* `/login` - аутентификация пользователя
* `/logout` - выход пользователя
