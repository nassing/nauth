package fr.nassing.nauth.service;


import fr.nassing.nauth.entity.NauthUser;
import fr.nassing.nauth.entity.NauthUser.NauthData;
import fr.nassing.nauth.repository.NauthUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TestService {
    private final NauthUserRepository nauthUserRepository;
    private final RedisTemplate<String, Object> redisTemplate;

    public String test() {
//        NauthUser nauthUser = NauthUser.builder().email("test email").build();
//        testUser.addNauthData(NauthData.builder().data("test data").build());
        HashMap<UUID, NauthData> nauthData = new HashMap<>();
        nauthData.put(UUID.randomUUID(), new NauthData(UUID.randomUUID(), "test data"));
        NauthUser nauthUser = new NauthUser(UUID.randomUUID(), "test email", nauthData);

        save(nauthUser);

        return "inserted value in Redis: " + getNauthUser(nauthUser.getId().toString());
    }

    public void save(NauthUser nauthUser) {
        nauthUserRepository.save(nauthUser);

//        for (Map.Entry<UUID, JsonObject> item : nauthUser.getData().entrySet()) {
//            String key = "USER:" + nauthUser.getId().toString();
//            redisTemplate.opsForHash().put(key, "DATA:" + item.getKey().toString(), item.getValue());
//        }
    }

    public String saveNauthUser(NauthUser nauthUser) {
        nauthUserRepository.save(nauthUser);
        return "inserted value in Redis" + getNauthUser(nauthUser.getId().toString());
    }

    public NauthUser getNauthUser(String id) {
        return nauthUserRepository.findById(id).orElse(null);
    }
}