package com.semainier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.semainier.Constants;
import com.semainier.model.Student;
import com.semainier.repository.StudentRepository;


@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;


	@GetMapping("/eleves")
	public String showStudentList(Model model) {
		return listByPage(model, 1, "id", "asc", "");
	}

	@GetMapping("/eleves/page/{pageNumber}")
	public String listByPage(Model model, @PathVariable int pageNumber, @RequestParam String sortField, @RequestParam String sortDir, @RequestParam String keyword){
		Sort sort = Sort.by(sortField);
		sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
		Page<Student> page = studentRepository.findAll(keyword, PageRequest.of(pageNumber - 1, Constants.PAGE_SIZE, sort));

		model.addAttribute("listStudents", page.getContent());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("keyword", keyword);

		return "eleves";
	}

	@GetMapping("/eleves/new")
	public String showCreateNewStudentForm(Model model) {
		model.addAttribute("student", new Student());
		return "eleve_form";
	}


	@PostMapping("/eleves/save")
	public String saveStudent(Student student) {
		studentRepository.save(student);
		return "redirect:/eleves";
	}

	@GetMapping("/eleves/edit/{id}")
	public String showCreateNewStudentForm(@PathVariable Integer id, Model model) {
		model.addAttribute("student", studentRepository.findById(id).get());
		return "eleve_form";
	}

	@GetMapping("/eleves/delete/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		studentRepository.deleteById(id);
		return "redirect:/eleves";
	}
}
