package com.example.springpracticssecurity.entities;

/**
 * Служит для обращения к именам полей сущности User.
 */
public enum UserField {
    USER_NAME("username");

    private final String field;

    UserField(String field) {
        this.field = field;
    }

    public String field() {
        return field;
    }
}
