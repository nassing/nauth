package fr.nassing.nauth.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;

@Data
@Builder
@RedisHash("USER")
public class NauthUser implements Serializable {
    @Id
    private final UUID id;
    private String email;
    private String username;
    private String password;

    private final HashMap<UUID, NauthData> nauthData = new HashMap<>();

    public void addNauthData(NauthData nauthData) {
        this.nauthData.put(nauthData.getId(), nauthData);
    }
}
