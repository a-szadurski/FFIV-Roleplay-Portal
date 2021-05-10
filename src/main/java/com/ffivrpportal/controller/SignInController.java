package com.ffivrpportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sign-in")
public class SignInController {

    @GetMapping
    public String displayPage() {
        return "sign-in";
    }

}
