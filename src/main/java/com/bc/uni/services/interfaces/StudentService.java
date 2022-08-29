package com.bc.uni.services.interfaces;

import com.bc.uni.models.Student;

public interface StudentService{
    Student saveStudent(Student student);
    Student findStudentByStudentId(long id);

    Student updateStudent(Student student,long id);

    void deleteStudent(long id);
}
