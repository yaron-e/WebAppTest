package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import database.HibernateUtil;
import database.User;

@WebServlet("/Working")
//@WebServlet("/LoginServlet") 
public class Working extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Session session = HibernateUtil.getSessionFactory().openSession();

		RequestDispatcher dispatcher = null;

		if(request.getParameter("idButton") != null) {
			System.out.println("In Button Pressed");
			String str = request.getParameter("id");
			System.out.println("str: "+str);
			//int id = Integer.parseInt(str);
			
			Query q = session.createQuery("FROM User WHERE userID="+str);
			List<User> list = q.list();
			
			if(list.size() != 0) {
				request.setAttribute("text", list);
				dispatcher = request.getRequestDispatcher("welcome.jsp");
			} else {
				request.setAttribute("var", "Failed not found");
				dispatcher = request.getRequestDispatcher("welcome.jsp");
			}
		} else {

			dispatcher = request.getRequestDispatcher("LogoutServlet");
		}
		dispatcher.forward(request, response);

	}

}