package com.tejait.batch15.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.tejait.batch15.model.Employee;

public interface EmployeeService {
	
public Employee saveEmployee(Employee emp);

public void deleteEmployee(Integer id);

public Optional<Employee> getById(Integer id);

public List<Employee> getAllEmps();

public boolean existsById(Integer id);

public Page<Employee> getpaginationData(int pagenum, int pagesize);

public List<Employee> getsortingData(String property, String orderType);

public List<Employee> findbyDept(String dept);

public List<Employee> getfindByFname(String fname);

public List<Employee> getfindByFnameAndLname(String fname, String lname);

public List<String> distinctByDept();

public List<Employee> searchEmployee(String searchTerm);

public List<Employee> searchFilters(String filterType, String empcode);

public List<Employee> findByFnameOrLname(String fname, String lname);

public List<Employee> findByAgeBetween(int minage, int maxage);






}
