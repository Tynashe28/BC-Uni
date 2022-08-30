package com.bc.uni.services.interfaces;

import com.bc.uni.models.Lecturer;
import com.bc.uni.models.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LecturerService {
    public Lecturer registerLecturer(Lecturer lecturer);
    Lecturer findLecturerById(long id);
    Role saveRole(Role role);
    void saveRoleToLecturer(String lecturerUsername,String roleName);

    Lecturer findLecturerByUsername(String username);

    // put pagination here
    List<Lecturer> getAllLecturers();


}