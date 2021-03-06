package com.student.crud.example2.services;

import com.student.crud.example2.models.Student;
import com.student.crud.example2.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student){
        return repository.save(student);
    }

    public List<Student> saveStudents(List<Student> students){
        return repository.saveAll(students);
    }

    public List<Student> getStudents(){
        return repository.findAll();
    }

    public Student getStudentById(int id){
        return repository.findById(id).orElse(null);
    }

    public Student getStudentByName(String name){
        return repository.findByName(name);
    }

    public String deleteStudent(int id){
        repository.deleteById(id);
        return "student removed!!"+id;
    }

    public Student updateStudent(Student student){
        Student existingStudent=repository.findById(student.getId()).orElse(null);
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setGpa(student.getGpa());
        existingStudent.setMajor(student.getMajor());
        return repository.save(existingStudent);


    }

    public int getNumberOfStudents(){
        return (int) repository.count();
    }




}

