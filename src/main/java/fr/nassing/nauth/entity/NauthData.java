package fr.nassing.nauth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class NauthData {
    private UUID id;
    private String data;
}
