package edu.kh.studentManagement.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.studentManagement.dto.Student;
import edu.kh.studentManagement.service.StudentManagementService;
import edu.kh.studentManagement.service.StudentManagementServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// Service 객체 생성
			StudentManagementService service = new StudentManagementServiceImpl();
			
			List<Student> studentList = service.studentListFullView();
			
			req.setAttribute("studentList", studentList);
			
			String path = "/WEB-INF/views/main.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
