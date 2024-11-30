// src/main/java/edu/fra/uas/controller/GradeController.java
package edu.fra.uas.controller;

import edu.fra.uas.model.Grade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GradeController {

    private List<Grade> grades = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("grades", grades);
        return "grades";
    }

    @PostMapping("/add")
    public String addGrade(@RequestParam("subject") String subject, 
                           @RequestParam("grade") double grade) {
        grades.add(new Grade(subject, grade));
        return "redirect:/";
    }

    @GetMapping("/average")
    public String calculateAverage(Model model) {
        double sum = grades.stream().mapToDouble(Grade::getGrade).sum();
        double average = grades.isEmpty() ? 0 : sum / grades.size();
        model.addAttribute("average", average);
        return "average";
    }
}
