package com.example.springpracticssecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String getMainPage() {
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) String error,
                               @RequestParam(value = "logout", required = false) String logout,
                               Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }
}
