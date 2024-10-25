package edu.kh.studentManagement.controller;

import java.io.IOException;

import edu.kh.studentManagement.service.StudentManagementService;
import edu.kh.studentManagement.service.StudentManagementServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/student/add")
public class AddServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			StudentManagementService service = new StudentManagementServiceImpl();
			
			String stdName = req.getParameter("stdName");
			int stdAge = Integer.parseInt(req.getParameter("stdAge"));
			String stdGender = req.getParameter("stdGender");
			String stdScore = req.getParameter("stdScore");
			
			int result = service.studentAdd(stdName,stdAge,stdGender,stdScore);
			
			String message = null;
			if(result > 0) message = "추가 성공!";
			else           message = "추가 실패...";
			
			HttpSession session = req.getSession();
			session.setAttribute("message", message);
			
			resp.sendRedirect("/");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	
	
	
	
	
	}
}
