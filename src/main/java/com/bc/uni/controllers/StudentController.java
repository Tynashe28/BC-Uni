package com.bc.uni.controllers;


import com.bc.uni.models.Student;
import com.bc.uni.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(this.studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> findStudentByStudentId(@PathVariable ("id") long id){
        return new ResponseEntity<Student>(this.studentService.findStudentByStudentId(id),HttpStatus.FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") long id){
        return new ResponseEntity<Student>(this.studentService.updateStudent(student,id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student Deleted",HttpStatus.OK);
    }
}
