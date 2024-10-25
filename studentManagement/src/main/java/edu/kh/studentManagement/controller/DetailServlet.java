package edu.kh.studentManagement.controller;

import java.io.IOException;

import edu.kh.studentManagement.dto.Student;
import edu.kh.studentManagement.service.StudentManagementService;
import edu.kh.studentManagement.service.StudentManagementServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student/detail")
public class DetailServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			int stdNo = Integer.parseInt(req.getParameter("stdNo"));
			
			StudentManagementService service = new StudentManagementServiceImpl();
			
			Student student = service.studentDetailView(stdNo);
			
			if(student == null) {
				HttpSession session = req.getSession();
				session.setAttribute("message", "학생이 존재하지 않습니다");
				
				resp.sendRedirect("/");
				return;
			}
			
			req.setAttribute("student", student);
			String path = "/WEB-INF/views/detail.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
