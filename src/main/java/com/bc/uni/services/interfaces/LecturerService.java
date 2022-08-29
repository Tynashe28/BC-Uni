package com.bc.uni.services.interfaces;

import com.bc.uni.models.Lecturer;
import org.springframework.stereotype.Service;

@Service
public interface LecturerService {
    public Lecturer registerLecturer(Lecturer lecturer);

    Lecturer findLecturerById(long id);
}