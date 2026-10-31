package com.musicx.musicx.services;

public final class SettingsService {
    public static final String DISPLAY_NAME_ENV_VARIABLE = "APP_DISPLAY_NAME";

    private SettingsService() {
    }

    public static String get(String environmentVariable, String defaultValue) {
        String value = System.getenv(environmentVariable);
        return value != null ? value : defaultValue;
    }
}
