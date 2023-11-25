package com.neo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginVerifyFilter
 */
@WebFilter("/*")
public class LoginVerifyFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginVerifyFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		String userName = (String) req.getSession().getAttribute("UserName");
		
		String url = req.getServletPath();
		
		if(!url.contains("Login")&&
				!url.contains("Register")&&
				!url.contains("Logout")&&
				!url.contains("index.jsp")&&
				!url.contains("style.css")&&
				!url.contains("jquery.js")&&
				!url.contains("Blog_main")&&
				!url.contains("AtricleDisplay")&&
				!url.contains("FindArtByTitle")&&
				!url.contains("FindUser")&&
				!url.contains("UserList")&&!url.contains("Blog_main.jsp")&&
				!url.contains("UserArt"))
			if(userName == null ||userName.equals("")){
				res.sendRedirect("Login");
				return;
			}
		
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
