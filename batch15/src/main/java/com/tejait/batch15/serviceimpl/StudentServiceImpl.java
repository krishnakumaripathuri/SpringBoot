package com.tejait.batch15.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tejait.batch15.model.Student;
import com.tejait.batch15.repository.StudentRepository;
import com.tejait.batch15.service.StudentService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
	
	StudentRepository repository;

	@Override
	public Student savestudent(Student student) {
		String fname = student.getFname();
		String lname = student.getLname();
		student.setFullname(fname.concat(" " + lname));
		return repository.save(student);
	}

	@Override
	public void deleteStudent(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public Optional<Student> getById(Integer id) {

		return repository.findById(id);
	}

	@Override
	public List<Student> getAllstus() {
		return repository.findAll();
	}
}
