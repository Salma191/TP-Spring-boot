/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springboot.controller;

import com.example.springboot.entity.Student;
import com.example.springboot.repository.StudentRepository;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lenovo
 */
@RestController
@RequestMapping("students")
public class StudentController {
@Autowired
private StudentRepository studentRepository;
@PostMapping("/save")
public void save(@RequestBody Student student){
studentRepository.save(student);
}
@DeleteMapping("/delete/{id}")
public void delete(@PathVariable (required = true) String id){
Student s = studentRepository.findById(Integer.parseInt(id));
studentRepository.delete(s);
}
@GetMapping("/all")
public List<Student> findAll(){
return studentRepository.findAll();
}
@GetMapping(value = "/count")
public long countStudent() {
return studentRepository.count();
}
@GetMapping(value = "/byYear")
public Collection<?> findByYear() {
return studentRepository.findNbrStudentByYear();
}
}

