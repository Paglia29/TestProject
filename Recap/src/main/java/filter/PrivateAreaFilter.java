package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PrivateAreaFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		
		Object isLoggato = session.getAttribute("user-loggato");
		Cookie[] cookies = req.getCookies();
		boolean autoLogin = false;
		for(Cookie c: cookies) {
			if(c.getName().equals("auto-login")&& c.getValue().equals("true")) {
				autoLogin = true;
				break;
			}
		}
		if(isLoggato != null || autoLogin) {
			chain.doFilter(request, response);
		}else {
			res.sendRedirect("../login.jsp");
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
