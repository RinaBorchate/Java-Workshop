package com.cybage.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.cybage.model.Employee;

@Service
public class EmployeeService {
	
	List<Employee> employeeList = new ArrayList<Employee>();
	
	public EmployeeService()
	{
		employeeList.add(new Employee(101,"Prerana","Software developer",30000));
		employeeList.add(new Employee(102,"Purvi","Manager",80000));
		employeeList.add(new Employee(103,"Swara","Trainee",20000));
		employeeList.add(new Employee(104,"Rinki","Software developer",30000));
	}

	public List<Employee> getEmployees()
	{
		return employeeList;
	}
	
	public void addEmployee(Employee employee)
	{
		employeeList.add(employee);
	}

	public void deleteEmployee(int id)
	{
		//employeeList.remove(id); its wrong it not take id took index
		//((List<Employee>) employeeList.stream().filter(employee->employee.id==id)).remove(employeeList);
		
		//Employee employee1 = employeeList.stream().filter(employee->employee.getEmployeeId()==id).findFirst().get();
		//OR one
		employeeList.removeIf(employee->employee.getEmployeeId()==id);
	}
	
	public Employee getEmployeeById(int id)
	{
		Employee employee1 = employeeList.stream().filter(employee->employee.getEmployeeId()==id).findFirst().get();
		return employee1;
	}

	public void updateEmployee(Employee employee)
	{
		Employee employee1 = employeeList.stream().filter(employee2->employee2.getEmployeeId()==employee.getEmployeeId()).findFirst().get();
		int index = employeeList.indexOf(employee1);
		employeeList.set(index, employee);
	}
}
