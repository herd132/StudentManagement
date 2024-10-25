package edu.kh.studentManagement.dao;

import java.sql.Connection;
import java.util.List;

import edu.kh.studentManagement.dto.Student;

public interface StudentManagementDAO {

	List<Student> studentListFullView(Connection conn) throws Exception;

	Student studentDetailView(Connection conn, int stdNo) throws Exception;

	int studentUpdate(Connection conn,int stdNo, String stdName, int stdAge, String stdScore) throws Exception;

	int studentDelete(Connection conn, int stdNo) throws Exception;

	int studentAdd(Connection conn,String stdName, int stdAge, String stdGender, String stdScore) throws Exception;

}
