package com.example.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sms.entity.Student;
import com.example.sms.service.StudService;

@Controller
public class Studentcontroller 
{
	private StudService studservice;

	public Studentcontroller(StudService studservice) {
		super();
		this.studservice = studservice;
	}
	
	@RequestMapping("/students")
	public String listStudents(Model model)
	{
		model.addAttribute("student", studservice.getAllStudent());
		return "student";
	}
	
	@RequestMapping("/students/new")
	public String createNew(Model model) 
	{
		Student student=new Student();
		model.addAttribute("student",student);
		return "create";
	}
	
	@PostMapping("/students")
	public String saveStud(@ModelAttribute("student") Student student)
	{
		studservice.saveStudent(student);
		return "redirect:students";
		
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStud(@PathVariable Long id,Model model) 
	{
		model.addAttribute("student", studservice.getStudentById(id));
		return "edit";
		
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student stud,Model model)
	{
		Student existing=studservice.getStudentById(id);
		existing.setId(id);
		existing.setFirstName(stud.getFirstName());
		existing.setLastName(stud.getLastName());
		existing.setEmail(stud.getEmail());
		studservice.updateStudent(existing);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		studservice.deleteStudentById(id);
		return "redirect:/students";
	}
}
