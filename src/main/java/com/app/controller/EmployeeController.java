package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Employee;
import com.app.service.IEmployeeService;
import com.app.validator.EmployeeValidator;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeValidator validator;

	@Autowired
	private IEmployeeService service;

	//1. Show Register Page
	@RequestMapping("/reg")
	public String showReg(ModelMap map) {
		//Form Backing Object
		map.addAttribute("employee", new Employee());
		return "Register";
	}

	//2. save data on click submit
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveData(
			@ModelAttribute Employee employee,
			Errors errors,
			ModelMap map
			) 
	{

		//call validator
		validator.validate(employee, errors);

		if(!errors.hasErrors()) {//if no errors
			//call service layer
			Integer id=service.saveEmployee(employee);
			String msg="Employee '"+id+"' saved";
			//send msg to UI
			map.addAttribute("message", msg);
			//clear form 
			map.addAttribute("employee", new Employee());
		}else { //errors exist
			map.addAttribute("message", "Please check all Errors");
		}
		return "Register";
	}

	//3. Display All rows at UI
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		//read all rows from DB to List
		List<Employee> emps=service.getAllEmployees();
		//send this data to UI
		map.addAttribute("list", emps);
		return "Data";
	}

	//4. delete employee by id
	@RequestMapping("/delete")
	public String deleteEmp(
			@RequestParam Integer id)
	{
		//call service layer
		service.deleteEmployee(id);
		//response.sendRedirect To All
		return "redirect:all";
	}




}



