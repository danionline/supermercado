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
 * Servlet implementation class LoginFormController
 */
@WebServlet("/loginform")
public class LoginFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginFormController() {
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
		String nombre = request.getParameter("nombre");
	
		String color = request.getParameter("color");
		
		
		//crear cookie de idioma
		Cookie cColor = new Cookie("cColor", color);
		cColor.setMaxAge( 60 * 1 * 60 * 24 * 365 * 5 ); // 5 años
		// guardar cookie 
		response.addCookie(cColor);
		
		

		HttpSession session = request.getSession();
		
		//TODO validar contra BBDD
		if ( "daniel".equals(nombre)  ){
		
			
			session.setMaxInactiveInterval( 60 * 5 ); // 5 minutos sin peticiones, se invalida la session del usuario
			session.setAttribute("isLogeado", true );
			session.setAttribute("nombre", "Daniel" );
			
			request.setAttribute("alerta", new Alerta("success", "Bienvenido ya esta Logeado"));
			response.sendRedirect("formout.jsp");
			
		}else {
			
			//TODO logoout controller
			session.invalidate();
						
			request.setAttribute("alerta", new Alerta("warning", "Credenciales Incorrectas"));
			response.sendRedirect("formout.jsp");
			
		}
		
		
		
		
		
	}

	}


