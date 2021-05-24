package com.ffivrpportal.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class OverviewController {

    @GetMapping
    public String displayPage(){
        return "admin/overview";
    }
}
