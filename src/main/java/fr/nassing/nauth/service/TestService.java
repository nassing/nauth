package fr.nassing.nauth.service;

import fr.nassing.nauth.entity.NauthUser;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class TestService {
    private final RedisTemplate<String, NauthUser> redisTemplate;

    public String test() {
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.opsForHash().put("USER", UUID.randomUUID(), new NauthUser(UUID.randomUUID(), "test"));

        return "a";
    }

    public NauthUser getNauthUser(String id) {
        return (NauthUser) redisTemplate.opsForHash().get("USER", id);
    }
}