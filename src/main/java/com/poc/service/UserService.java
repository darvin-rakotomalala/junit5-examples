package com.poc.service;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService {

    public boolean login(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new IllegalArgumentException("Username and password must not be null or empty");
        } else return username.equals("admin") && password.equals("password123");
    }

    public boolean changePassword(long userId, String oldPassword, String newPassword) {
        return userId == 1 && StringUtils.isNotBlank(newPassword) && !newPassword.equals(oldPassword);
    }

    public boolean resetPassword(long userId) {
        List<Long> existingUsers = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
        return existingUsers.contains(userId);
    }

    public boolean logout(long userId) {
        List<Long> existingUsers = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
        return existingUsers.contains(userId);
    }

}
