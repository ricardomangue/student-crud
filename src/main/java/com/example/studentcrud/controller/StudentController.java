
package com.example.studentcrud.controller;

import com.example.studentcrud.model.Student;
import com.example.studentcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    // PROBLEMA 1: injeção por campo (field injection)
    @Autowired
    private StudentRepository repository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student, Model model) {
        // PROBLEMA 2: sem validação; aceita qualquer coisa
        repository.save(student);
        model.addAttribute("message", "Student Added!");
        return "index"; // PROBLEMA 3: sem padrão PRG (Post/Redirect/Get)
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam String rollNo, Model model) {
        // PROBLEMA 4: apaga sem verificar se existe (IDOR silencioso)
        repository.deleteById(rollNo);
        model.addAttribute("message", "Student Deleted!");
        return "index";
    }

    @GetMapping("/display")
    public String displayAll(Model model) {
        // PROBLEMA 5: findAll() sem paginação
        model.addAttribute("students", repository.findAll());
        return "display";
    }

    @GetMapping("/display/{rollNo}")
    public String displayById(@PathVariable String rollNo, Model model) {
        // PROBLEMA 6: orElse(null) esconde a ausência de dados
        model.addAttribute("student", repository.findById(rollNo).orElse(null));
        return "displayOne";
    }
}
