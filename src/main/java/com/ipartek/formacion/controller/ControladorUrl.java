package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ControladorUrl
 */
@WebServlet("/apartado-a")
public class ControladorUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorUrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Alerta alerta =new Alerta();
		
		Cookie cookie = new Cookie("cColor", " ");

		cookie.setMaxAge(60 * 60 * 24);
		String coor = request.getParameter("color");
		cookie.setValue(coor);

		
			alerta = new Alerta("success", "Cookie guardada con exito");
			request.setAttribute("alerta", alerta);
		

		response.addCookie(cookie);
		
		
		
		

		Alerta alerta1 =new Alerta();
		
		Cookie cookie1 = new Cookie("cNombre", " ");

		cookie1.setMaxAge(60 * 60 * 24);
		String nomb = request.getParameter("nombre");
		cookie1.setValue(nomb);

		
			
			

		response.addCookie(cookie1);
		
		
		HttpSession session = request.getSession();
		
		String nav= request.getHeader( "user-agent");
		long time= session.getMaxInactiveInterval(); 
		session.setAttribute("time", time);
		session.setAttribute("nomb", nomb);
		session.setAttribute("nav", nav);
		
		
		response.sendRedirect("resultadoA.jsp");
		
		
	}
}

