package com.example.sms.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sms.entity.Student;
import com.example.sms.repo.StudRepo;
import com.example.sms.service.StudService;
@Service
public class StudServiceImpl implements StudService
{
	private StudRepo studrepo;

	public StudServiceImpl(StudRepo studrepo) {
		super();
		this.studrepo = studrepo;
	}
	
	@Override
	public List<Student> getAllStudent() 
	{
		// TODO Auto-generated method stub
		return studrepo.findAll();
	}

	@Override
	public Student saveStudent(Student stud) 
	{
		return studrepo.save(stud);
	}

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return studrepo.findById(id).get();
	}

	@Override
	public Student updateStudent(Student stud) {
		// TODO Auto-generated method stub
		return studrepo.save(stud);
	}

	@Override
	public void deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		studrepo.deleteById(id);
	}




	
	
}
