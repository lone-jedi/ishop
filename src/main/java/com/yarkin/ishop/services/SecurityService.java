package com.yarkin.ishop.services;

import com.yarkin.ishop.dao.UserDao;
import com.yarkin.ishop.entities.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Objects;
import java.util.UUID;

public class SecurityService {
    private final UserDao userDao;

    public SecurityService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void login(String email, String password) {
        User user = userDao.getByEmail(email);

        if(user == null) {
            throw new RuntimeException("Email " + email
                    + " is not exist. Please register or enter other email");
        }

        String currentPasswordHash = hashPassword(password, user.getPasswordSalt());

        if(!Objects.equals(user.getPasswordHash(), currentPasswordHash)) {
            throw new RuntimeException("Incorrect email or password. Please try again");
        }

        // Login success ...
    }

    public void register(String email, String password) {
        String passwordSalt = generateRandomSalt();
        String passwordHash = hashPassword(password, passwordSalt);
        userDao.add(User.builder()
                .email(email)
                .passwordHash(passwordHash)
                .passwordSalt(passwordSalt)
                .build());
    }

    public String hashPassword(String password, String salt) {
        return DigestUtils.sha256Hex(salt + password);
    }

    public String generateRandomSalt() {
        return UUID.randomUUID().toString();
    }
}
