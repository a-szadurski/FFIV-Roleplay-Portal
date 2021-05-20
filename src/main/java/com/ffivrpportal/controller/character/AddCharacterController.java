package com.ffivrpportal.controller.character;

import com.ffivrpportal.dto.PlayerCharacterDto;
import com.ffivrpportal.service.PlayerCharacterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user/add")
public class AddCharacterController {

    private final PlayerCharacterService playerCharacterService;

    public AddCharacterController(PlayerCharacterService playerCharacterService) {
        this.playerCharacterService = playerCharacterService;
    }

    @GetMapping
    public String displayPage(Model model) {

        model.addAttribute("newCharacter", new PlayerCharacterDto());
        return "user/add-character";
    }

    @PostMapping
    public String executeForm(Model model, @Valid @ModelAttribute("newCharacter") PlayerCharacterDto playerCharacterDto,
                              BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("newCharacter", new PlayerCharacterDto());
            return "user/add-character";
        }

        playerCharacterService.findByLodestoneId(playerCharacterDto);
        return "redirect:/";
    }
}
