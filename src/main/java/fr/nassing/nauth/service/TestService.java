package fr.nassing.nauth.service;

import fr.nassing.nauth.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import fr.nassing.nauth.repository.UserRepository;

import java.util.UUID;

@Service
@AllArgsConstructor
public class TestService {

    private final UserRepository userRepository;

    public String test() {
        User user = new User(UUID.randomUUID(), "test@test.com");
        user = userRepository.save(user);

        return user.toString();
    }
}
