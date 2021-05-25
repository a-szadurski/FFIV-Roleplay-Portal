package com.ffivrpportal.controller.character;

import com.ffivrpportal.dto.PlayerCharacterDto;
import com.ffivrpportal.dto.UserDto;
import com.ffivrpportal.service.PlayerCharacterService;
import com.ffivrpportal.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/user/add")
public class AddCharacterController {

    private final PlayerCharacterService playerCharacterService;
    private final UserService userService;

    public AddCharacterController(PlayerCharacterService playerCharacterService, UserService userService) {
        this.playerCharacterService = playerCharacterService;
        this.userService = userService;
    }

    @GetMapping
    public String displayPage(Model model) {

        model.addAttribute("newCharacter", new PlayerCharacterDto());
        return "user/add-character";
    }

    @PostMapping
    public String executeForm(Model model, @Valid @ModelAttribute("newCharacter") PlayerCharacterDto playerCharacterDto,
                              BindingResult result, Principal principal) {

        if (result.hasErrors()) {
            model.addAttribute("newCharacter", new PlayerCharacterDto());
            return "user/add-character";
        }

        if (playerCharacterDto.getLodestoneId() != null) {
            playerCharacterService.findByLodestoneId(playerCharacterDto);
            return "redirect:/user/add/step2";
        }
        UserDto userDto = userService.findByEmailDto(principal.getName());
        if (userDto != null) {
            playerCharacterDto.setUser(userService.setUser(userDto));
            playerCharacterService.saveCharacter(playerCharacterDto);
        }
        return "redirect:/user/characters";
    }
}
