package com.bc.uni.services;

import com.bc.uni.exceptions.ResourceNotFoundException;
import com.bc.uni.models.Student;
import com.bc.uni.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements com.bc.uni.services.interfaces.StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return this.studentRepository.save(student);
    }


    @Override
    public Student findStudentByStudentId(long id){

        return Optional.ofNullable(studentRepository.findStudentByStudentId(id)).orElseThrow(
                ()-> new ResourceNotFoundException("Student","StudentId",Long.toString(id))
        );
    }
    @Override
    public Student updateStudent(Student student, long id){
        Student existingStudent = studentRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Student","id",Long.toString(id))
        );

        existingStudent.setEmail(student.getEmail());
        existingStudent.setName(student.getName());
        existingStudent.setSurname(student.getSurname());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(long id){
        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Student", "id", Long.toString(id))
        );
        studentRepository.delete(student);
    }
}
