package fr.nassing.nauth.service;


import fr.nassing.nauth.dto.input.NauthUserPasswordInput;
import fr.nassing.nauth.entity.NauthUser;
import fr.nassing.nauth.repository.NauthUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class NauthUserService {

    private final NauthUserRepository nauthUserRepository;

    public NauthUser saveWithPassword(NauthUserPasswordInput userInput) {
        // ToDo: validation
        NauthUser nauthUser = NauthUser.builder()
            .username(userInput.getUsername())
            .password(userInput.getPassword())
            .build();

        return nauthUserRepository.save(nauthUser);
    }

    public NauthUser findById(UUID id) {
        //ToDo: validation

        return nauthUserRepository.findById(id.toString()).orElse(null);
    }
}