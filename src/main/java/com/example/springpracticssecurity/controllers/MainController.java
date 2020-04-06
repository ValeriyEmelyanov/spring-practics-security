package com.example.springpracticssecurity.controllers;

import com.example.springpracticssecurity.entities.Role;
import com.example.springpracticssecurity.entities.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static java.util.stream.Collectors.joining;

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
    public String getMainPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        model.addAttribute("username", user.getUsername());
        model.addAttribute("roles", user.getAuthorities().stream().map(Role::getAuthority).collect(joining(",")));
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
