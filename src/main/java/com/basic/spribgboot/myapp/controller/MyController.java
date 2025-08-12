package com.basic.spribgboot.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.basic.spribgboot.myapp.model.Admin;
import com.basic.spribgboot.myapp.model.Student;
import com.basic.spribgboot.myapp.service.AdminService;
import com.basic.spribgboot.myapp.service.GradeService;



@RestController
@RequestMapping("/myapplication")
public class MyController {
	
	@Autowired
    private GradeService gradeService;
	
	@Autowired AdminService adminService;

	
	 @PostMapping("/login")
	public ModelAndView showForm(@RequestParam String email, @RequestParam String password) {
		 System.out.println("Username: "+email +"Password : "+ password);
		Admin admin = adminService.getAdmin(email);
		 ModelAndView mv = new ModelAndView();
		 if(admin.getPassword().equals(password))
		{
			mv.addObject("student", new Student());
			mv.setViewName("index");
		}
		else
		{
			mv.setViewName("login");
			mv.addObject("admin", new Admin());
			 mv.addObject("error", "Password faild ");
		}
	        return mv;
	    }

	 @GetMapping("/login")
	    public ModelAndView showLogin() {
	        ModelAndView mv = new ModelAndView("login");
			 Admin admin = new Admin();
		        mv.addObject("admin", admin);

	        return mv;
	    }
	 
	 @PostMapping("/register")
	    public ModelAndView register(@ModelAttribute Admin admin) {
		 adminService.addAdmin(admin);
		 ModelAndView mv = new ModelAndView("login");
		 mv.addObject("admin", new Admin());
		 mv.addObject("successMessage","Admin register successfully");
	        return mv;
	    }
	 @GetMapping("/studentRegistration")
	 public ModelAndView showRegistrationPage() {
		 Admin admin = new Admin();
		 ModelAndView mv = new ModelAndView("studentRegistration");
		 mv.addObject("admin", admin);
	        return mv;
	     // no .html, Thymeleaf will find it
	 }
	 

	 @GetMapping("/")
	    public ModelAndView login() {
	        ModelAndView mv = new ModelAndView("login");
			 Admin admin = new Admin();
	        mv.addObject("admin", admin);
	        return mv;
	    }
	
	 @PostMapping("/addStudent")
	    public ModelAndView addStudent(@ModelAttribute Student student) {
	        gradeService.addStudent(student);
	        ModelAndView mv = new ModelAndView("index");
	        mv.addObject("student", new Student());
	        mv.addObject("status", "Student added successfully");
	        return mv;
	    }
	 @GetMapping("/addStudent")
	    public ModelAndView addStudent() {
	        ModelAndView mv = new ModelAndView("index");
	        mv.addObject("student", new Student());
	        return mv;
	
	 }
	
	@GetMapping("/studentlist")
	public ModelAndView  studentList()
	{
		ModelAndView model= new ModelAndView();
		model.setViewName("student.html");
		List<Student> students = gradeService.getAllStudents();
		
		double minNumber = gradeService.getMinimum();
		double maxNumber = gradeService.getMaxinum();
		double avgNumber = gradeService.getAverage();

		
		model.addObject("employs", students);
		model.addObject("minNumber", minNumber);
		model.addObject("maxNumber", maxNumber);
		model.addObject("avgNumber", avgNumber);
		
		
		
	
		return model;
		
	}

}
