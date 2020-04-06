package com.example.springpracticssecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Основной контроллер приложения
 */
@Controller
public class MainController {
    /**
     * Маппинг корневого каталога.
     *
     * @return возвращает имя главной страницы
     */
    @GetMapping("/")
    public String showHelloWorld() {
        return "index";
    }

}
