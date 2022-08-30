package com.bc.uni;

import com.bc.uni.models.Lecturer;
import com.bc.uni.models.Role;
import com.bc.uni.services.LecturerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
public class BcUniApplication {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(BcUniApplication.class, args);
    }



    @Bean
    CommandLineRunner run(LecturerService lecturerService){
        return args -> {
            lecturerService.saveRole(new Role(null,"ROLE_USER"));
            lecturerService.saveRole(new Role(null,"ROLE_MANAGER"));
            lecturerService.saveRole(new Role(null,"ROLE_ADMIN"));
            lecturerService.saveRole(new Role(null,"ROLE_ROOT"));
            lecturerService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
            lecturerService.saveRole(new Role(null,"ROLE_SUPERVISOR"));

            lecturerService.registerLecturer(new Lecturer(null,"Tinashe Mabika","a","tinashe",new ArrayList<>()));
            lecturerService.registerLecturer(new Lecturer(null,"Tanya Mabika","a","tanya",new ArrayList<>()));
            lecturerService.registerLecturer(new Lecturer(null,"Antony Santos","a","tony",new ArrayList<>()));

            lecturerService.saveRoleToLecturer("tinashe","ROLE_ROOT");
            lecturerService.saveRoleToLecturer("tinashe","ROLE_SUPERVISOR");
            lecturerService.saveRoleToLecturer("tanya","ROLE_MANAGER");
            lecturerService.saveRoleToLecturer("tanya","ROLE_USER");
            lecturerService.saveRoleToLecturer("tony","ROLE_SUPER_ADMIN");

        };
    }

}
