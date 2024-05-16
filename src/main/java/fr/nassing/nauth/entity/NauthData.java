package fr.nassing.nauth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@RedisHash("NAUTHDATA")
public class NauthData implements Serializable {
    @Id
    private UUID id;
    private String data;
}
