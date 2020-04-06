package com.example.springpracticssecurity.persistence;

import com.example.springpracticssecurity.entities.User;
import com.example.springpracticssecurity.entities.UserField;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Служит для доступа к данным пользователя в базе данных.
 */
@Component
public class UserDao {
    /**
     * Для обращения к ьазе данных MongoDB.
     */
    private MongoTemplate mongoTemplate;

    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * Получение Optional пользователя по имени пользователя.
     *
     * @param username имя пользователя
     * @return Optional пользователя
     */
    public Optional<User> findByUserName(String username) {
        return Optional.ofNullable(
                mongoTemplate.findOne(
                        query(where(UserField.USER_NAME.field()).is(username))
                        , User.class));
    }

    /**
     * Сохранение пользователя в баззе данных.
     *
     * @param user данные пользователя
     */
    public void save(@NonNull User user) {
        mongoTemplate.save(user);
    }
}
