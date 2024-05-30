package fr.nassing.nauth.dto.input;

import lombok.Data;

@Data
public class NauthUserPasswordInput {
    private String username;
    private String password;
}
