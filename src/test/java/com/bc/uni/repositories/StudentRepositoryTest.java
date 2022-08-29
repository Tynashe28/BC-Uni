package com.bc.uni.repositories;


import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootTest @RestController
public class StudentRepositoryTest {
    @Autowired
    private RestTemplate restTemplate;
    
    @Test
    void findStudentByStudentId() {
        String url = "http://localhost:8080/api/v1/students/3";
        String response = this.restTemplate.getForObject(url,String.class);
        System.out.println("response = " + response);
    }
}