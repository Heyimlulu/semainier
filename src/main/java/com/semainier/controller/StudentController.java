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
import com.semainier.repository.LocalityRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private LocalityRepository localityRepository;

	@GetMapping("/student")
	public String showStudentList(Model model) {
		return listByPage(model, 1, "id", "asc", "");
	}

	@GetMapping("/student/page/{pageNumber}")
	public String listByPage(Model model, @PathVariable int pageNumber, @RequestParam String sortField, @RequestParam String sortDir, @RequestParam String keyword){
		Sort sort = Sort.by(sortField);
		sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
		Page<Student> page = studentRepository.findAll(keyword, PageRequest.of(pageNumber - 1, Constants.PAGE_SIZE, sort));

		model.addAttribute("listStudents", page.getContent());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("keyword", keyword);

		return "student";
	}

	@GetMapping("/student/new")
	public String showCreateNewStudentForm(Model model) {
		model.addAttribute("listLocalities", localityRepository.findAll());
		model.addAttribute("student", new Student());
		return "student_form";
	}

	@PostMapping("/student/save")
	public String saveStudent(Student student) {
		/*
		int last = localityRepository.findAll().size();
		Locality l = localityRepository.findAll().get(last-1);
		student.setLocality(l);
		 */
		studentRepository.save(student);
		return "redirect:/student";
	}

	@GetMapping("/student/edit/{id}")
	public String showCreateNewStudentForm(@PathVariable Integer id, Model model) {
		model.addAttribute("listLocalities", localityRepository.findAll());
		model.addAttribute("student", studentRepository.findById(id).get());
		return "student_form";
	}

	@GetMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		studentRepository.deleteById(id);
		return "redirect:/student";
	}
}
