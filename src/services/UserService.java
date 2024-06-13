package services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import models.User;

public class UserService {
    private Map<String, User> users = new HashMap<>();

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean register(String username, String password, String email) {
        if (users.containsKey(username)) {
            return false; // Username already exists
        }
        String hashedPassword = hashPassword(password);
        User user = new User(username, hashedPassword, email);
        users.put(username, user);
        return true; // Registration successful
    }

    public boolean login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(hashPassword(password))) {
            return true;
        }
        return false;
    }
}


