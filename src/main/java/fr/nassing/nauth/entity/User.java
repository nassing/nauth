package fr.nassing.nauth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@RedisHash("User")
public class User implements Serializable {
    private UUID id;
    private String email;

}
