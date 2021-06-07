package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("psw");
		
		if(user.equals("root") && password.equals("root")) {
			HttpSession session = request.getSession();
			session.setAttribute("user-loggato", true);
			session.setMaxInactiveInterval(60);
			String autoLogin = request.getParameter("auto-login");
			if(autoLogin!=null && autoLogin.equals("on")) {
				Cookie cookie = new Cookie("auto-login", "true");
				cookie.setMaxAge(30 * 24 * 60 * 60);
				response.addCookie(cookie);
			}
			response.sendRedirect("admin/stampaPersona");
		} else {
			request.setAttribute("error", "Credenziali errate. Riprova!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
