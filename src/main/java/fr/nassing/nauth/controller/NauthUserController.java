package fr.nassing.nauth.controller;

import fr.nassing.nauth.dto.input.NauthUserPasswordInput;
import fr.nassing.nauth.entity.NauthUser;
import fr.nassing.nauth.service.NauthUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class NauthUserController {

    private final NauthUserService nauthUserService;

    @PostMapping
    public ResponseEntity<NauthUser> saveWithPassword(@RequestBody NauthUserPasswordInput userInput) {
        return ResponseEntity.ok(nauthUserService.saveWithPassword(userInput));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NauthUser> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(nauthUserService.findById(id));
    }
}
