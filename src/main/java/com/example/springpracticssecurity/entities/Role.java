package com.example.springpracticssecurity.entities;

import org.springframework.security.core.GrantedAuthority;

/**
 * Роли пользователей
 */
public enum Role implements GrantedAuthority {
    ADMIN, POWER_USER, USER;

    /**
     * Возвращает строковое представление Authority
     *
     * @return возвращает Authority
     */
    @Override
    public String getAuthority() {
        return name();
    }
}
