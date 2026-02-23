package com.tejait.batch15.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch15.exceptions.AccountAlreadyExists;
import com.tejait.batch15.exceptions.DataNotFoundException;
import com.tejait.batch15.exceptions.IdNotFoundException;
import com.tejait.batch15.exceptions.InsuffiecientFundsException;
import com.tejait.batch15.exceptions.MailAlreadyExists;
import com.tejait.batch15.exceptions.MobileAlreadyExists;
import com.tejait.batch15.model.Employee;
import com.tejait.batch15.service.EmployeeService;

import lombok.AllArgsConstructor;

//@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	EmployeeService service;

	@PostMapping(value = "saveEmp")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		Employee savedemp = service.saveEmployee(emp);
		return new ResponseEntity<>(savedemp, HttpStatus.CREATED);
	}

	@PutMapping(value = "updateEmp")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
		Employee updatedEmployee = service.saveEmployee(emp);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}

	@DeleteMapping(value = "deleteEmp/{id}")
	public ResponseEntity<String> deletebyEmpId(@PathVariable Integer id) {
		service.deleteEmployee(id);
		return new ResponseEntity<>("deleted Employee ID:: " + id, HttpStatus.OK);

	}

	@GetMapping(value = "getByEmpId/{id}")
	public ResponseEntity<Employee> getByEmpId(@PathVariable Integer id) {
		Optional<Employee> empobj = service.getById(id);
		return new ResponseEntity<>(empobj.get(), HttpStatus.OK);
	}

	@GetMapping(value = "getAll")
	public ResponseEntity<List<Employee>> getAllEmps() {
		List<Employee> list = service.getAllEmps();
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@GetMapping(value = "existsById/{id}")
	public ResponseEntity<Boolean> existsById(@PathVariable Integer id) {
		boolean result = service.existsById(id);
		if (!result) {
			//throw new IdNotFoundException("Given Id Not Available");
			// throw new MobileAlreadyExists();
			// throw new MailAlreadyExists();
			// throw new AccountAlreadyExists();
			// throw new DataNotFoundException();
			throw new InsuffiecientFundsException();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("pegination")
	public ResponseEntity<Page<Employee>> peginationData(@RequestParam int pagenum, @RequestParam int pagesize) {
		Page<Employee> page = service.getpaginationData(pagenum, pagesize);
		return new ResponseEntity<>(page, HttpStatus.OK);
	}

	@GetMapping("dataSorting")
	public ResponseEntity<List<Employee>> sortingData(@RequestParam String property, @RequestParam String orderType) {
		List<Employee> employee = service.getsortingData(property, orderType);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("findByDept/{Dept}")
	public ResponseEntity<List<Employee>> findByDept(@PathVariable String Dept) {
		List<Employee> list = service.findbyDept(Dept);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("findByFname/{fname}")
	public ResponseEntity<List<Employee>> findByFname(@PathVariable String fname) {
		List<Employee> list = service.getfindByFname(fname);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("findByFnameAndLname")
	public ResponseEntity<List<Employee>> findByFnameAndLname(@RequestParam String fname, @RequestParam String lname) {
		List<Employee> list = service.getfindByFnameAndLname(fname, lname);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@GetMapping("distinctDept")
	public ResponseEntity<List<String>> distinctByDept(){
		List<String> list=service.distinctByDept();
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}
	@GetMapping("search/{searchTerm}")
	public ResponseEntity<List<Employee>> searchData(@PathVariable String searchTerm){
		List<Employee> list=service.searchEmployee(searchTerm);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@GetMapping("searchfilters")
	public ResponseEntity<List<Employee>> searchFilters(@RequestParam String filterType,@RequestParam String empcode){
		List<Employee> list=service.searchFilters(filterType,empcode);
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	}
	@GetMapping("findByFnameOrLname")
	public ResponseEntity<List<Employee>> findByFnameOrLname(@RequestParam String fname,@RequestParam String lname){
		List<Employee> list=service.findByFnameOrLname(fname,lname);
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	}
	@GetMapping("findByAgeBetween")
	public ResponseEntity<List<Employee>> findByAgeBetween(@RequestParam int minage,@RequestParam int maxage){
		List<Employee> list=service.findByAgeBetween(minage,maxage);
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	}
	
	
}
