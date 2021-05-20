package com.ffivrpportal.service;

import com.ffivrpportal.dto.PlayerCharacterDto;
import com.ffivrpportal.model.PlayerCharacter;
import com.ffivrpportal.repository.PlayerCharacterRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerCharacterServiceImpl implements PlayerCharacterService {

    private final PlayerCharacterRepository playerCharacterRepository;

    public PlayerCharacterServiceImpl(PlayerCharacterRepository playerCharacterRepository) {
        this.playerCharacterRepository = playerCharacterRepository;
    }

    @Override
    public void findByLodestoneId(PlayerCharacterDto playerCharacterDto) {

        String lodestoneId = playerCharacterDto.getLodestoneId();

        if(!lodestoneId.isBlank() && !lodestoneId.isEmpty())
        lodestoneId.replaceAll("[^0-9]", "");


    }

    @Override
    public void saveCharacter(PlayerCharacterDto playerCharacterDto) {

        playerCharacterRepository.save(new PlayerCharacter(playerCharacterDto));
    }
}
