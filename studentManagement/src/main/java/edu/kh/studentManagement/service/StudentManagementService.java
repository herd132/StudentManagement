package edu.kh.studentManagement.service;

import java.util.List;

import edu.kh.studentManagement.dto.Student;

public interface StudentManagementService {

	List<Student> studentListFullView() throws Exception;

	Student studentDetailView(int stdNo) throws Exception;

	int studentUpdate(int stdNo, String stdName, int stdAge, String stdScore) throws Exception;

	int studentDelete(int stdNo) throws Exception;

	int studentAdd(String stdName, int stdAge, String stdGender, String stdScore) throws Exception;



	
}
