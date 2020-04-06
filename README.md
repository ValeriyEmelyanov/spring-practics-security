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
* Bootstrap

### Запуск MongoDB

`    mongod --storageEngine=mmapv1 --dbpath C:\data\db\spring-practics`

### Сборка и запуск приложения

Перед запуском приложения должен быть запущен сервер MongoDB.

`mvn spring-boot:run`

### Endpoints
* `/` - корневой каталог
* `/login` - аутентификация пользователя
* `/logout` - выход пользователя

### Проблемы и их решения

* Перестал работать logout. Помогло:
```
protected void configure(HttpSecurity http) throws Exception {
    http
        // ...
        .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
}
```
Ответ нашел <a href="https://issue.life/questions/43598628">здесь</a>.