package com.ffivrpportal.controller.user;

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

    private final String SIGN_IN_PAGE = "user/sign-in";

    private String authenticate(Authentication authentication) {
        if (authentication != null && authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
            return "redirect:/";
        }

        if (authentication != null && authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/";
        }
        return SIGN_IN_PAGE;
    }

    @GetMapping("/sign-in")
    public String loginPage() {

        return authenticate(SecurityContextHolder.getContext().getAuthentication());
    }


    @GetMapping("/sign-in/error")
    public String loginWithError(Model model) {

        model.addAttribute("loginError", true);
        return SIGN_IN_PAGE;
    }

    @GetMapping("/sign-out")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

}
