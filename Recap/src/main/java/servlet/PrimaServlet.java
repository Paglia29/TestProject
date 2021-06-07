package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.JPADaoFactory;
import dao.JPAPersonaDao;
import dao.PersonaDao;
import entity.Persona;

@WebServlet("/admin/stampaPersona")
public class PrimaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("nome", "Generation30");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		DaoFactory daoFactory = DaoFactory.getDaoFactory();
//		JPADaoFactory daoFactory = (JPADaoFactory) DaoFactory.getDaoFactory();
		PersonaDao daoPersona = daoFactory.getPersonaDao();
		daoPersona.insert(new Persona(nome, cognome));
		System.out.println(nome);
	}

}
