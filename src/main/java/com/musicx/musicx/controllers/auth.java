package com.musicx.musicx.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class auth {
    @GetMapping("/")
	public String index() {
		return "built for the top changes changes times 3. "+(4+5);
	}

      @GetMapping("/about")
	public String about() {
        System.out.println("About page loaded");
		return "about us";
	}

    @GetMapping("/health")
    public String health(){
        System.out.println("checking system health");
        return "System is down";
    }
}
