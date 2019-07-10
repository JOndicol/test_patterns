package com.sopra.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class EjemploServletString
 */
@WebServlet("/EjemploServletString")
public class EjemploServletString extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ApplicationContext context;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	@Override
	public void init() throws ServletException {
		this.context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("objSingleton", context.getBean("objetoSingleton"));
		request.setAttribute("objPrototype", context.getBean("objetoPrototype"));
		request.setAttribute("objRequest", context.getBean("objetoRequest"));
		request.setAttribute("objSession", context.getBean("obsession"));
		getServletContext().getRequestDispatcher("/WEB-INF/jsps/saludar.jsp").forward(request, response);
	}

}
