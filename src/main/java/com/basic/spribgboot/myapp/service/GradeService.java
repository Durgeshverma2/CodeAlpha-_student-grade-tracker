package com.basic.spribgboot.myapp.service;

import org.springframework.stereotype.Service;

import com.basic.spribgboot.myapp.model.Student;
import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService {

	private final List<Student>students=new ArrayList<>();
	
	public void addStudent(Student s) {
		students.add(s);
	}
	public List<Student>getAllStudents(){
		return students;
	}
	public double getAverage() {
		return students.stream().mapToDouble(Student::getNumber).average().orElse(0);
	
	}
	public double getMaxinum() {
		return students.stream().mapToDouble(Student::getNumber).max().orElse(0);
		
	}
	public double getMinimum() {
		return students.stream().mapToDouble(Student::getNumber).min().orElse(0);

		}
	}