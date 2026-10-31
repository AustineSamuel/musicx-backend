package com.musicx.musicx.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class SettingsControllerTest {
    @Test
    void getsAllowlistedDisplayName() throws Exception {
        MockMvc mockMvc = standaloneSetup(new SettingsController("MusicX")).build();
        String expectedValue = System.getenv().getOrDefault("APP_DISPLAY_NAME", "MusicX");

        mockMvc.perform(get("/settings/app.display-name"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.key").value("app.display-name"))
                .andExpect(jsonPath("$.value").value(expectedValue));
    }
}
