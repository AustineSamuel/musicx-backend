package com.musicx.musicx.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicx.musicx.dto.User;
import com.musicx.musicx.services.SettingsService;

@RestController
public class UsersControllers {
    @GetMapping("/users/list")
    public List<User> getUsers() {
        String[] names = { "Alex Morgan", "Sam Taylor" };
        String[] emails = { "alex@example.com", "sam@example.com" };
        List<User> users = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            users.add(new User(i + 1L, names[i], emails[i]));
        }
        System.out.print(SettingsService.get("app-name", "app name not provided"));
        return users;
    }
}
