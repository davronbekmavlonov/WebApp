// src/main/java/edu/fra/uas/rest/GradeRestController.java
package edu.fra.uas.controller;

import edu.fra.uas.model.Grade;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grades")
public class GradeRestController {

    private List<Grade> grades = new ArrayList<>();

    @GetMapping
    public List<Grade> getAllGrades() {
        return grades;
    }

    @PostMapping
    public void addGrade(@RequestBody Grade grade) {
        grades.add(grade);
    }

    @GetMapping("/{id}")
    public Grade getGrade(@PathVariable int id) {
        return grades.get(id);
    }

    @PutMapping("/{id}")
    public void updateGrade(@PathVariable int id, @RequestBody Grade grade) {
        grades.set(id, grade);
    }

    @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable int id) {
        grades.remove(id);
    }
}
