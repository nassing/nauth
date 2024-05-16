package fr.nassing.nauth.service;

import fr.nassing.nauth.entity.NauthData;
import fr.nassing.nauth.entity.NauthUser;
import fr.nassing.nauth.repository.NauthDataRepository;
import fr.nassing.nauth.repository.NauthUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TestService {
    private final NauthUserRepository nauthUserRepository;
    private final NauthDataRepository nauthDataRepository;

    public String test() {
        UUID randomUUID = UUID.randomUUID();
        UUID randomUUID2 = UUID.randomUUID();

        NauthData nauthData = new NauthData(randomUUID2, "myData");

        NauthUser testUser = new NauthUser(randomUUID, "test", List.of(nauthData));
        nauthUserRepository.save(testUser);


        return "inserted value in Redis: " + getNauthUser(randomUUID.toString());
    }

    public String saveNauthUser(NauthUser nauthUser) {
        nauthUserRepository.save(nauthUser);
        return "inserted value in Redis" + getNauthUser(nauthUser.getId().toString());
    }

    public NauthUser getNauthUser(String id) {
        return (NauthUser) nauthUserRepository.findById(id.toString()).orElse(null);
    }
}