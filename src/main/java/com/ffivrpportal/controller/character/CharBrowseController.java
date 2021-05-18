package com.ffivrpportal.controller.character;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/charbrowse")
public class CharBrowseController {

    @GetMapping
    public String displayPage() {
        return "char-browse";
    }
}
