package ua.lviv.lgs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.lviv.lgs.entity.Student;
import ua.lviv.lgs.service.StudentService;

import java.util.Optional;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/create")
    public String getStudentPage() {
        return "student";
    }

    @PostMapping("/students/create")
    public String createStudent(@ModelAttribute Student student) {
        studentService.create(student);
        return "redirect:/students";
    }

    @PostMapping("/students/update")
    public String updateStudent(@ModelAttribute Student student) {
        studentService.update(student);
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students-list";
    }

    @GetMapping("/students/mv")
    public ModelAndView getStudents(ModelAndView modelAndView) {
        modelAndView.setViewName("students-list");
        modelAndView.addObject("students", studentService.findAll());
        return modelAndView;
    }

    @GetMapping("/students/delete")
    public String deleteStudent(@RequestParam Integer id) {
        try {
            studentService.deleteById(id);
        } catch (Exception e) {
            return "student-notfound";
        }
        return "redirect:/students";
    }

    @GetMapping("/students/one")
    public String getOne(@RequestParam Integer id, Model model) {

        Optional<Student> studentOptional = studentService.findById(id);

        if (studentOptional.isPresent()) {
            model.addAttribute("student", studentOptional.get());
            return "student-update";
        }
        return "student-notfound";
    }

}
