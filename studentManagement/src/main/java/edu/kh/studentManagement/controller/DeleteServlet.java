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

@WebServlet("/student/delete")
public class DeleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			int stdNo = Integer.parseInt(req.getParameter("stdNo"));
			
			StudentManagementService service = new StudentManagementServiceImpl();
			
			int result = service.studentDelete(stdNo);
			
			HttpSession session = req.getSession();
			
			if(result > 0) {
				
				session.setAttribute("message", "삭제되었습니다");
				resp.sendRedirect("/");
				return;
			}
			
			session.setAttribute("message", "student가 존재하지 않습니다.");
			resp.sendRedirect("/");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
