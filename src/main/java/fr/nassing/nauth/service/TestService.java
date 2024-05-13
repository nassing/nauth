package fr.nassing.nauth.service;

import fr.nassing.nauth.entity.NauthUser;
import fr.nassing.nauth.repository.NauthRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class TestService {
    private final NauthRepository nauthRepository;

    public String test() {
        UUID randomUUID = UUID.randomUUID();

        NauthUser testUser = new NauthUser(randomUUID, "test");
        nauthRepository.save(testUser);

        return "inserted value in Redis" + getNauthUser(randomUUID.toString());
    }

    public NauthUser getNauthUser(String id) {
        return (NauthUser) nauthRepository.findById(id.toString()).orElse(null);
    }
}