package com.example.sms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sms.entity.Student;

public interface StudRepo extends JpaRepository<Student, Long>
{

}
