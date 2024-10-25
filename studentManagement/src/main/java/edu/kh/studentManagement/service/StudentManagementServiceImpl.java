package edu.kh.studentManagement.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.studentManagement.common.StudentTemplate.*;
import edu.kh.studentManagement.dao.StudentManagementDAO;
import edu.kh.studentManagement.dao.StudentManagementDAOImpl;
import edu.kh.studentManagement.dto.Student;

public class StudentManagementServiceImpl implements StudentManagementService {

	private StudentManagementDAO dao = new StudentManagementDAOImpl();

	@Override
	public List<Student> studentListFullView() throws Exception {
		
		//커넥션 생성
		Connection conn = getConnection();
		
		List<Student> studentList = dao.studentListFullView(conn);
		
		close(conn);
		
		return studentList;
	}

	@Override
	public Student studentDetailView(int stdNo) throws Exception {

		Connection conn = getConnection();
		
		Student student = dao.studentDetailView(conn, stdNo);
		
		close(conn);
		
		return student; 
	
	}

	@Override
	public int studentUpdate(int stdNo, String stdName, int stdAge, String stdScore) throws Exception {

		Connection conn = getConnection();
		
		int result = dao.studentUpdate(conn, stdNo, stdName, stdAge, stdScore);
		
		if( result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	@Override
	public int studentDelete(int stdNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.studentDelete(conn, stdNo);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	@Override
	public int studentAdd(String stdName, int stdAge, String stdGender, String stdScore)throws Exception {
		Connection conn = getConnection();
		
		int result = dao.studentAdd(conn,stdName, stdAge, stdGender, stdScore);
		
		if(result > 0 ) commit(conn);
		else 			rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	
	
}
