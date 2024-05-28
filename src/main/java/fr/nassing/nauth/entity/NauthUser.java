package fr.nassing.nauth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;

@Data
@AllArgsConstructor
@RedisHash("USER")
public class NauthUser implements Serializable {
    @Id
    private UUID id;
    private String email;

//    @Transient
//    private HashMap<UUID, JsonObject> data;

//    @Builder
//    public NauthUser(String email) {
//        this.id = UUID.randomUUID();
//        this.data = new HashMap<>();
//
//        this.email = email;
//    }
    @Data
    @AllArgsConstructor
    public static class NauthData {
        private UUID id;
        private String data;
    }

    private HashMap<UUID, NauthData> nauthData;

}
