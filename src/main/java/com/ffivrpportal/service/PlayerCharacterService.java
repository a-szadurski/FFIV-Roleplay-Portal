package com.ffivrpportal.service;

import com.ffivrpportal.dto.PlayerCharacterDto;

import java.util.List;

public interface PlayerCharacterService {

    void findByLodestoneId(PlayerCharacterDto playerCharacterDto);

    void saveCharacter(PlayerCharacterDto playerCharacterDto);

    List<PlayerCharacterDto> findPlayerCharactersByUserId(Long id);
}
