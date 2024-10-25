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

@WebServlet("/student/update")
public class UpdateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			int stdNo = Integer.parseInt(req.getParameter("stdNo"));
			
			StudentManagementService service = new StudentManagementServiceImpl();
			Student student = service.studentDetailView(stdNo);
			
			if(student == null) {
				resp.sendRedirect("/");
				return;
			}
			
			req.setAttribute("student", student);
			
			String path = "/WEB-INF/views/update.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			String stdName = req.getParameter("stdName");
			int stdAge = Integer.parseInt(req.getParameter("stdAge"));
			String stdScore = req.getParameter("stdScore");
			int stdNo = Integer.parseInt(req.getParameter("stdNo"));
			
			StudentManagementService service = new StudentManagementServiceImpl();
			int result = service.studentUpdate(stdNo, stdName, stdAge, stdScore);
			
			String url = null;
			String message = null;
			
			if(result > 0 ) {
				url = "/";
				message = "수정 되었습니다";
			} else {
				url = "/student/update?stdNo=" + stdNo;
				message = "수정 실패";
			}
			
			req.getSession().setAttribute("message", message);
			
			resp.sendRedirect(url);
			
		} catch (Exception e){
			e.printStackTrace();
		}
	 
	}

}
