package com.ffivrpportal.service;

import com.ffivrpportal.dto.PlayerCharacterDto;

public interface PlayerCharacterService {

    void findByLodestoneId(PlayerCharacterDto playerCharacterDto);

    void saveCharacter(PlayerCharacterDto playerCharacterDto);
}
