package com.example.springpracticssecurity.entities;

import org.springframework.security.core.GrantedAuthority;

/**
 * Роли пользователей
 */
public enum Role implements GrantedAuthority {
    USER;

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
