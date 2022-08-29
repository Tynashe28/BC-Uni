package com.bc.uni.repositories;

import com.bc.uni.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findStudentByStudentId(long id);
}
