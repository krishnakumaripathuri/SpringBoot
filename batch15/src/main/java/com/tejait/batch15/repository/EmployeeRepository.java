package com.tejait.batch15.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tejait.batch15.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findByDept(String dept);

	public List<Employee> findByFname(String fname);

    public List<Employee> findByFnameAndLname(String fname, String lname);
	
	public List<Employee> findByFnameOrLname(String fname, String lname);
	
	public List<Employee> findByAgeBetween(int minage,int maxage);
	
	public List<Employee> findByFnameEquals(String fname);
//  JPA QUERY
	@Query("select e from Employee e")
	public List<Employee> getAll();

// SQL QUERY
	@Query(value = "select * from employee_b15", nativeQuery = true)
	public List<Employee> getAllEmps();

	@Query("select e from Employee e where e.dept=?1")
	public List<Employee> findByDepartment(String department);

	@Query("select e from Employee e where e.fname=?1 and e.lname=?2")
	public List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

// PARAM QUERY
	@Query("select e from Employee e where e.fname=:firstname and e.lname=:lastname")
	public List<Employee> findByFirstNameAndLastNameData(@Param("firstname") String frtname,
			@Param("lastname") String lstname);

// select distrinct(dept) from employee_b15; - SQL QUERY
	@Query("select distinct(e.dept) from Employee e") // JPA QUERY
	public List<String> findDistinctByDept();

// SEARCH OPERATION
	@Query("select e from Employee e where concat(e.dept,e.salary,e.fname,e.lname,e.empcode,e.age,e.fullname) like %?1% ")
	public List<Employee> searchEmployee(String searchTerm);

// -----------------------------find by starts with  -----------------------------	
	public List<Employee> findByEmpcodeStartingWith(String empcode);
	
	public List<Employee> findByEmpcodeEndsWith(String empcode);
	
	public List<Employee> findByEmpcodeContaining(String empcode);
	
	public List<Employee> findByEmpcodeNotContaining(String empcode);
	
	public List<Employee> findByEmpcode(String empcode); // EQUALS
	
	public List<Employee> findByEmpcodeNot(String empcode); // NOTEQUALS
// -----------------------------find by ends with ------------------------------

}
