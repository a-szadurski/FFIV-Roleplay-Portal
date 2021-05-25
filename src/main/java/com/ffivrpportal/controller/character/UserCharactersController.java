package com.ffivrpportal.controller.character;

import com.ffivrpportal.service.PlayerCharacterService;
import com.ffivrpportal.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/characters")
public class UserCharactersController {

    private final UserService userService;
    private final PlayerCharacterService playerCharacterService;

    public UserCharactersController(UserService userService, PlayerCharacterService playerCharacterService) {
        this.userService = userService;
        this.playerCharacterService = playerCharacterService;
    }

    @GetMapping
    public String displayPage(Model model) {
        return "user/user-characters";
    }
}
