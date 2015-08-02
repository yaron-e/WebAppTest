package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import database.HibernateUtil;
import database.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
 
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher dispatcher = null;
		
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session1.beginTransaction();
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("Username: "+username + "\nPassword: "+password);
		//Insecure SQL statement
		Query q = session1.createQuery("FROM User as u WHERE u.userName='"+username + "' AND u.password='"+password+"'");
		
		// Secure SQL statement
//		Query q = session1.createQuery("FROM User as u WHERE u.userName=?1 AND u.password=?2");
//		q.setParameter("1", username);
//		q.setParameter("2", password);
		List<User> user = new ArrayList<User>();
		user = q.list();
		tx.commit();
		if(user.size() > 0){
			System.out.println("\n\n\nIn the DATABASE method !!!!!!!!!!!!!!!!!1111\n\n\n ");
			dispatcher = request.getRequestDispatcher("welcome.jsp");
		} else {
			System.out.println("Login Failed");
			
			request.setAttribute("errorMsg", "Wrong username or password");
			
			dispatcher = request.getRequestDispatcher("index.jsp");
		}
		dispatcher.forward(request, response);
 
	}
 
}