package com.example.springpracticssecurity.services;

import com.example.springpracticssecurity.entities.Role;
import com.example.springpracticssecurity.entities.User;
import com.example.springpracticssecurity.persistence.UserDao;
import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Сервис для манипуляций пользователями.
 */
@Service
public class UserService implements UserDetailsService {
    /**
     * Служит для доступа к данным пользователя в базе данных.
     */
    private UserDao userDao;

    /**
     * Кодировщик паролей.
     */
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Предварительная инициализация данных.
     * Добавление пользователей выполняется кодом один раз для простоты.
     */
    @PostConstruct
    public void init() {
        /*
        userDao.findByUserName("user").ifPresent(user -> {
            user.setPassword(passwordEncoder.encode("password"));
            userDao.save(user);
        });
        */

        if (!userDao.findByUserName("admin").isPresent()) {
            userDao.save(User.builder()
            .username("admin")
            .password(passwordEncoder.encode("admin"))
            .authorities(ImmutableList.of(Role.ADMIN))
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .enabled(true)
                    .build());
        }

        if (!userDao.findByUserName("power").isPresent()) {
            userDao.save(User.builder()
            .username("power")
            .password(passwordEncoder.encode("power"))
            .authorities(ImmutableList.of(Role.POWER_USER))
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .enabled(true)
                    .build());
        }

        if (!userDao.findByUserName("user").isPresent()) {
            userDao.save(User.builder()
                    .username("user")
                    .password(passwordEncoder.encode("password"))
                    .authorities(ImmutableList.of(Role.USER))
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .enabled(true)
                    .build());
        }
    }

    /**
     * Загружает пользователя по его имени.
     *
     * @param username имя пользователя
     * @return возвращает найденного пользователя
     * @throws UsernameNotFoundException вызывает исключение, если пользователь не найден
     */
    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return userDao.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s was not found!", username)));
    }
}
