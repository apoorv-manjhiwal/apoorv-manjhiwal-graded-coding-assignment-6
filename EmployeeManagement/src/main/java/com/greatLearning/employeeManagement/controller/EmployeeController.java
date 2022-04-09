package com.greatLearning.employeeManagement.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.servlet.ModelAndView;

import com.greatLearning.employeeManagement.entity.Employee;
import com.greatLearning.employeeManagement.service.EmployeeService;





@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;



	

	@RequestMapping("/list")
	public String listBooks(Model theModel) {

	
		
		List<Employee> theEmployee = employeeService.findAll();
		

		
		theModel.addAttribute("Employee", theEmployee);

		return "list-Employee";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		
		Employee theEmployee = new Employee();

		theModel.addAttribute("Employee", theEmployee);

		return "Employee-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
			Model theModel) {

		
		Employee theEmployee = employeeService.findById(theId);


		
		theModel.addAttribute("Employee", theEmployee);

		
		return "Employee-form";			
	}


	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id,
			@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("id") String id,@RequestParam("email") String email) {

		System.out.println(id);
		Employee theEmployee;
		if(id!=0)
		{
			theEmployee=employeeService.findById(id);
			theEmployee.setFirstName(firstName);
			theEmployee.setLastName(lastName);
			theEmployee.setid(id);
			theEmployee.setemail(email);
		}
		else
			theEmployee=new Employee(firstName, lastName, id,email);
		// save the Book
		employeeService.save(theEmployee);


		// use a redirect to prevent duplicate submissions
		return "redirect:/employee/list";

	}


	@RequestMapping("/delete")
	public String delete(@RequestParam("emailId") int theId) {

		// delete the Book
		employeeService.deleteById(theId);

		// redirect to /Books/list
		return "redirect:/employee/list";

	}
	
	@RequestMapping("/403")
	public ModelAndView accessDenied(Principal user) {
		
		ModelAndView mv = new ModelAndView();
		if (user!= null) {
			mv.addObject("msg", "hi" + user.getName()
			+ "you do not have permission to access this page");
		} else {
			mv.addObject("msg",  "you do not have permission to access this page");
			
		}
		mv.setViewName("403");
		return mv;
		
	}


	
} 
