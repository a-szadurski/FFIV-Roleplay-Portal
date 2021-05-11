package com.ffivrpportal.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignInController {

    private final Authentication AUTHENTICATION = SecurityContextHolder.getContext().getAuthentication();

    private String authenticate(Authentication authentication) {
        if (authentication != null && authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
            return "redirect:/user/home";
        }

        if (authentication != null && authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/admin/home";
        }
        return "sign-in";
    }

    @GetMapping("/sign-in")
    public String loginPage() {

        return authenticate(AUTHENTICATION);
    }


    @GetMapping("/sign-in/error")
    public String loginWithError(Model model) {

        model.addAttribute("loginError", true);
        return "sign-in";
    }

    @GetMapping("/sign-out")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {

        if (AUTHENTICATION != null) {
            new SecurityContextLogoutHandler().logout(request, response, AUTHENTICATION);
        }
        return "redirect:/";
    }

}
