package com.bc.uni.controllers;

import com.bc.uni.models.Lecturer;
import com.bc.uni.services.LecturerService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest @RestController
class LecturerControllerTest {
    @Autowired
    private RestTemplate restTemplate;
    String url = "http://localhost:8080/api/v1/lecturer/";

    @Test
    void registerLecturer() {
        url.concat("");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Map<String,Object> lecturer = new HashMap<>();
        lecturer.put("name","killi-killi");

        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(lecturer,headers);

        ResponseEntity<Lecturer> response = this.restTemplate.postForEntity(url,entity,Lecturer.class);

        if (response.getStatusCode() == HttpStatus.OK){
            System.out.println("response.getBody() = " + response.getBody());
        }
    }

    @Test
    void findLecturerById() {
        url = url + "102";
        Lecturer response =  this.restTemplate.getForObject(url,Lecturer.class);
        System.out.println("response = " + response);
    }
}