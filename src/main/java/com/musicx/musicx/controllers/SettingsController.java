package com.musicx.musicx.controllers;

import com.musicx.musicx.services.SettingsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingsController {
    private static final String SETTING_KEY = "app.display-name";

    private final String defaultDisplayName;

    public SettingsController(@Value("${app.display-name:MusicX}") String defaultDisplayName) {
        this.defaultDisplayName = defaultDisplayName;
    }

    @GetMapping("/settings/app.display-name")
    public SettingResponse getDisplayName() {
        return new SettingResponse(
                SETTING_KEY,
                SettingsService.get(SettingsService.DISPLAY_NAME_ENV_VARIABLE, defaultDisplayName));
    }

    public record SettingResponse(String key, String value) {
    }
}
