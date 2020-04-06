package com.example.springpracticssecurity.configs;

import com.example.springpracticssecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Конфигурация безопасности
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * Сервис для манпуляций пользователями.
     */
    @Autowired
    UserService userService;

    /**
     * Кодировщик паролей
     */
    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Конфигурирует HttpSecurity.
     *
     * @param http изменяемый HttpSecurity
     * @throws Exception выбрасываемое исключение в случае ошибки
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and().logout().permitAll();
    }

    /**
     * Конфигурирует билдер для создания объекта аутентификации.
     *
     * @param auth бидрер для создания объекта аутентификации
     * @throws Exception выбрасываемое исключение в случае ошибки
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder);
    }
}
