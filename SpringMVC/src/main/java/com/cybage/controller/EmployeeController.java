package com.cybage.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cybage.model.Employee;
import com.cybage.service.EmployeeService;

@Controller
public class EmployeeController {
	
	
	//@RequestMapping("/getAllEmp",method=RequestMethod.GET)
	//@GetMapping("/getAllEmp
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getAllEmp")
	public ModelAndView getAllEmployee()
	{
		List<Employee> employeeList = employeeService.getEmployees();
		return new ModelAndView("displayEmployee","empList",employeeList);
	}
	
	@GetMapping("/addEmployee")
	public String showForm(Model model)
	{
		model.addAttribute("employee", new Employee());
		return "addEmployee";
	}
	
//	@PostMapping("/addEmployee")
//	public ModelAndView addEmployee(@ModelAttribute("employee") Employee employee)
//	{
//		employeeService.addEmployee(employee);
//		return new ModelAndView("displayEmployee","empList",employeeService.getEmployees());
//	}
	
	@PostMapping("/addEmployee")
	public ModelAndView addEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result)
	{
		if(result.hasErrors())
		{
			return new ModelAndView("addEmployee","employee",employee);
		}
		employeeService.addEmployee(employee);
		return new ModelAndView("displayEmployee","empList",employeeService.getEmployees());
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public ModelAndView deleteEmployee(@PathVariable int id)
	{
		employeeService.deleteEmployee(id);
		return new ModelAndView("displayEmployee","empList",employeeService.getEmployees());
	}
	
	//two method for update
	
	@GetMapping("/edit/{id}")
	public ModelAndView showUpdateForm(@PathVariable int id)
	{
		Employee employee = employeeService.getEmployeeById(id);
		return new ModelAndView("updateEmployee","employee",employee);
	}
	
	@PostMapping("/updateEmployee")
	public ModelAndView updateEmployee(@ModelAttribute("employee") Employee employee)
	{
		employeeService.updateEmployee(employee);
		//return new ModelAndView("updateEmployee","employee",employee);
		return new ModelAndView("displayEmployee","empList",employeeService.getEmployees());
	}
	
	// two methods for retrieve the info
	@GetMapping("/getEmployeeById")
	public String showUpdateID()
	{
		return "employee";
	}
	
	@PostMapping("/getEmployeeById")
	public ModelAndView getEmployeeById(@RequestParam("empId") int id)
	{
		Employee employee = employeeService.getEmployeeById(id);
		return new ModelAndView("employeeDetail","employeeInfo",employee);
	}
}
