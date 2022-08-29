package com.bc.uni.services;

import com.bc.uni.exceptions.ResourceNotFoundException;
import com.bc.uni.models.Lecturer;
import com.bc.uni.repositories.LecturerRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor @Data @Service @Slf4j
public class LecturerService implements com.bc.uni.services.interfaces.LecturerService {

    private LecturerRepository lecturerRepository;


    @Override
    public Lecturer registerLecturer(Lecturer lecturer) {
        System.out.println("lecturer.getName() = " + lecturer.getName());
        return this.lecturerRepository.save(lecturer);
    }

    @Override
    public Lecturer findLecturerById(long id){
        return this.lecturerRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Lecturer","id",id)
        );
    }
}
