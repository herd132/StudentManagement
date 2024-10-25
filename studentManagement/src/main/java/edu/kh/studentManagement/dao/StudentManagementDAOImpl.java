package edu.kh.studentManagement.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static edu.kh.studentManagement.common.StudentTemplate.*;
import edu.kh.studentManagement.dto.Student;

public class StudentManagementDAOImpl implements StudentManagementDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public StudentManagementDAOImpl(){
		
		try {
			
			String filePath = StudentManagementDAOImpl.class.getResource("/xml/sql.xml").getPath();
			
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e){
			System.out.println("sql.xml 로드 중 예외발생");
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<Student> studentListFullView(Connection conn) throws Exception {
		
		List<Student> studentList = new ArrayList<Student>();
		
		try {
			String sql = prop.getProperty("studentListFullView");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Student student = Student.builder()
								  .stdNo(rs.getInt("STD_NO"))
								  .stdName(rs.getString("STD_NAME"))
								  .stdAge(rs.getInt("STD_AGE"))
								  .stdGender(rs.getString("STD_GENDER"))
								  .stdScore(rs.getString("STD_SCORE"))
								  .build();
				
				studentList.add(student);
				
			}
					
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return studentList;
		
		
	}


	@Override
	public Student studentDetailView(Connection conn, int stdNo) throws Exception {
		
		Student student = null;
		
		try {
			
			String sql = prop.getProperty("studentDetailView");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stdNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				student = Student.builder()
						.stdNo(rs.getInt("STD_NO"))
						.stdName(rs.getString("STD_NAME"))
						.stdAge(rs.getInt("STD_AGE"))
						.stdGender(rs.getString("STD_GENDER"))
						.stdScore(rs.getString("STD_SCORE"))
						.build();
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return student;
	}


	@Override
	public int studentUpdate(Connection conn,int stdNo, String stdName, int stdAge, String stdScore) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("studentUpdate");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stdName);
			pstmt.setInt(2, stdAge);
			pstmt.setString(3, stdScore);
			pstmt.setInt(4, stdNo);
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	@Override
	public int studentDelete(Connection conn, int stdNo) throws Exception {
		int result = 0;
		
		try { 
			String sql = prop.getProperty("studentDelete");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, stdNo);
			
			result = pstmt.executeUpdate();		
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	@Override
	public int studentAdd(Connection conn,String stdName, int stdAge, String stdGender, String stdScore)
			throws Exception {

		int result = 0;
		
		try {
			String sql = prop.getProperty("studentAdd");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, stdName);
			pstmt.setInt(2, stdAge);
			pstmt.setString(3, stdGender);
			pstmt.setString(4, stdScore);
			
			result = pstmt.executeUpdate();
		
			
		} finally {
			close(pstmt);
		}
			
		return result;
	}

}
