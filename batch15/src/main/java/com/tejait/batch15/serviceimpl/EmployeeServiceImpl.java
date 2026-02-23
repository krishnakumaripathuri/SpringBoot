package com.tejait.batch15.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tejait.batch15.constants.SearchFilters;
import com.tejait.batch15.model.Employee;
import com.tejait.batch15.repository.EmployeeRepository;
import com.tejait.batch15.service.EmployeeService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
	//@Autowired
	EmployeeRepository repository;

	@Override
	public Employee saveEmployee(Employee emp) {
		String fname = emp.getFname(); // krishna
		String lname = emp.getLname(); // kumari
		emp.setFullname(fname.concat(" " + lname)); // krishnakumari
		return repository.save(emp);
	}

	@Override
	public void deleteEmployee(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public Optional<Employee> getById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public List<Employee> getAllEmps() {
		// return repository.findAll();
		// return repository.getAll();
		return repository.getAllEmps();

	}

	@Override
	public boolean existsById(Integer id) {
		return repository.existsById(id);
	}

	@Override
	public Page<Employee> getpaginationData(int pagenum, int pagesize) {
		Pageable pageable = PageRequest.of(pagenum, pagesize);
		return repository.findAll(pageable);

	}

	@Override
	public List<Employee> getsortingData(String property, String orderType) {
		if (orderType.equalsIgnoreCase("desc")) {
			return repository.findAll(Sort.by(Direction.DESC, property));
		}
		return repository.findAll(Sort.by(Direction.ASC, property));
	}

	@Override
	public List<Employee> findbyDept(String dept) {
		// return repository.findByDept(dept);
		return repository.findByDepartment(dept);
	}

	@Override
	public List<Employee> getfindByFname(String fname) {
		return repository.findByFname(fname);
	}

	@Override
	public List<Employee> getfindByFnameAndLname(String fname, String lname) {
		// return repository.findByFnameAndLname(fname, lname);
		// return repository.findByFirstNameAndLastName(fname, lname);
		return repository.findByFirstNameAndLastNameData(fname, lname);
	}

	@Override
	public List<String> distinctByDept() {
		return repository.findDistinctByDept();
	}

	@Override
	public List<Employee> searchEmployee(String searchTerm) {
		return repository.searchEmployee(searchTerm);
	}

	@Override
	public List<Employee> searchFilters(String filterType, String empcode) {
		List<Employee> list=null;
		switch(filterType) {
		case SearchFilters.EQUALS:
			list=repository.findByEmpcode(empcode);
		break;
		case SearchFilters.NOT_EQUALS:
			list=repository.findByEmpcodeNotContaining(empcode);
		break;
		case SearchFilters.CONTAINS:
			list=repository.findByEmpcodeContaining(empcode);
		break;
		case SearchFilters.NOT_CONTAINS:
			repository.findByEmpcodeNotContaining(empcode);
			break;
		case SearchFilters.START_WITH:
			repository.findByEmpcodeStartingWith(empcode);
			break;
		case SearchFilters.END_WITH:
			repository.findByEmpcodeEndsWith(empcode);
			break;
			default :
				throw new IllegalArgumentException("unexceptedvalue ::  "+filterType);
			
		}
		return list;
	}

	@Override
	public List<Employee> findByFnameOrLname(String fname, String lname) {
		return repository.findByFnameOrLname(fname, lname);
	}

	@Override
	public List<Employee> findByAgeBetween(int minage, int maxage) {
		return repository.findByAgeBetween(minage, maxage);
	}

	
	

}
