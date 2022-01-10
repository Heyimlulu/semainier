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
import com.semainier.model.Work;
import com.semainier.repository.StudentRepository;
import com.semainier.repository.WorkRepository;

@Controller
public class WorkController {

	@Autowired
	private WorkRepository workRepository;

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/work")
	public String showWorkList(Model model) {
		return listByPage(model, 1, "id", "asc", "");
	}

	@GetMapping("/report/pdf")
	public String showReportInPDF(Model model){
		Sort sort = Sort.by("id");
		Page<Work> page = workRepository.findAll("", PageRequest.of(0, Constants.PAGE_SIZE, sort));

		model.addAttribute("listWorks", page.getContent());
		model.addAttribute("listStudent", studentRepository.findAll());

		return "report";
	}

	@GetMapping("/work/page/{pageNumber}")
	public String listByPage(Model model, @PathVariable int pageNumber, @RequestParam String sortField, @RequestParam String sortDir, @RequestParam String keyword){
		Sort sort = Sort.by(sortField);
		sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
		Page<Work> page = workRepository.findAll(keyword, PageRequest.of(pageNumber - 1, Constants.PAGE_SIZE, sort));

		model.addAttribute("listWorks", page.getContent());
		model.addAttribute("listStudent", studentRepository.findAll());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("keyword", keyword);

		return "work";
	}

	@GetMapping("/work/new")
	public String showCreateNewWorkForm(Model model) {
		model.addAttribute("listStudent", studentRepository.findAll());
		model.addAttribute("work", new Work());
		return "work_form";
	}

	@PostMapping("/work/save")
	public String saveWork(Work work) {
		workRepository.save(work);
		return "redirect:/work";
	}

	@GetMapping("/work/edit/{id}")
	public String showCreateNewWorkForm(@PathVariable Integer id, Model model) {
		model.addAttribute("listStudent", studentRepository.findAll());
		model.addAttribute("work", workRepository.findById(id).get());
		return "work_form";
	}

	@GetMapping("/work/delete/{id}")
	public String deleteWork(@PathVariable Integer id) {
		workRepository.deleteById(id);
		return "redirect:/work";
	}
}
