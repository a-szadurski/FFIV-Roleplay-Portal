package com.ffivrpportal.controller.user;

import com.ffivrpportal.dto.UserDto;
import com.ffivrpportal.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/sign-up")
public class SignUpController {

    private final UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String displayPage(Model model) {

        model.addAttribute("user", new UserDto());
        return "sign-up";
    }

    @PostMapping
    public String registerUser(Model model, @Valid @ModelAttribute("user") UserDto userDto, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("user", new UserDto());
            return "sign-up";
        }

        userService.saveUser(userDto);
        return "redirect:/sign-in";
    }
}
