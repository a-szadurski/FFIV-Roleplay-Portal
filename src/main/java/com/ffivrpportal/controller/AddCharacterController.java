package com.ffivrpportal.controller;

import com.ffivrpportal.dto.PlayerCharacterDto;
import com.ffivrpportal.service.PlayerCharacterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/add")
public class AddCharacterController {

    private final PlayerCharacterService playerCharacterService;

    public AddCharacterController(PlayerCharacterService playerCharacterService) {
        this.playerCharacterService = playerCharacterService;
    }

    @GetMapping
    public String displayPage(Model model){

        model.addAttribute("newCharacter", new PlayerCharacterDto());
        return "user/add-character";
    }
}
