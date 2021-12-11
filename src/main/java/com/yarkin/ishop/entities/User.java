package com.yarkin.ishop.entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private int id;
    private String email;
    private String passwordHash;
    private String passwordSalt;
}
