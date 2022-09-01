package com.bc.uni.controllers;


import com.bc.uni.models.AppUser;
import com.bc.uni.services.AppUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class AppUserController {
    
    AppUserService appUserService;
    
    @GetMapping("/{username}")
    void getUser(HttpServletRequest request, HttpServletResponse response, @PathVariable String username) throws IOException {
       // String username = request.getParameter("username");
        System.out.println("username = " + username);
        AppUser user = (AppUser) appUserService.loadUserByUsername(username);
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(),username);
    }
}
