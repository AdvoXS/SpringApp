package com.gyper.controller;


import com.gyper.entity.Student;
import com.gyper.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/student")
    public String address(@RequestParam(name = "id", required = false) String id, Model model) {
        model.addAttribute("id", id);
        return "student";
    }

    @RequestMapping(value = "/student", method = {RequestMethod.POST})
    public String add(@RequestParam String name, @RequestParam String secondName, @RequestParam String age, @RequestParam String course, Map<String, Object> map) {
        Student student = new Student(name, secondName, Integer.parseInt(age), Integer.parseInt(course));
        studentRepository.save(student);
        Iterable<Student> students = studentRepository.findAll();
        map.put("students", students);
        //findAll(map);
        return "student";
    }

    private void findAll(Map<String, Object> map) {
        Iterable<Student> students = studentRepository.findAll();
        map.put("students", students);
    }
}
