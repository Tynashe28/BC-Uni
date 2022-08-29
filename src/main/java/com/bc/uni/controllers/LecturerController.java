package com.bc.uni.controllers;


import com.bc.uni.models.Lecturer;
import com.bc.uni.services.interfaces.LecturerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/lecturer/")
@AllArgsConstructor
public class LecturerController {

    LecturerService lecturerService;

    @PostMapping
    ResponseEntity<Lecturer> registerLecturer(@RequestBody Lecturer lecturer){
        System.out.println("lecturer = " + lecturer);
        return new ResponseEntity<Lecturer>(this.lecturerService.registerLecturer(lecturer),HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    ResponseEntity<Lecturer> findLecturerById(@PathVariable long id){
        return new ResponseEntity<Lecturer>(lecturerService.findLecturerById(id),HttpStatus.FOUND);
    }

}
