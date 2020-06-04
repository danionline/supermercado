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
 * Servlet implementation class FormOutController
 */
@WebServlet("/formout")
public class FormOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormOutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String color="";
		String mensaje="";
		
		
		// recuperar cookie de Idioma para mensaje de salida		
		Cookie[] cookies = request.getCookies();
		if ( cookies != null ) {
			for ( Cookie c : cookies ) {			
				if ( "cColor".equals(c.getName()) ) {   // cookie encontrada
					color = c.getValue();
					break;
				}			
			}
		}	
		switch (color) {
		case "1":
			mensaje = "rojo";
			break;
			
		case "2":
			mensaje = "verde";
			break;	

		case "3":
			mensaje = "blanco";
			break;	

		default:
			mensaje = "You are wellcome to the hell";
			break;
		}
	
		
		request.setAttribute("alerta", new Alerta("success", mensaje));

		
		// ATENCIION hacer lo ultimo, no antes de trabajar con las cookies
		HttpSession session = request.getSession();
		session.invalidate();
		session = null;
		
		
		
		request.setAttribute("alerta", new Alerta("success", color ));

		
		// ATENCIION hacer lo ultimo, no antes de trabajar con las cookies
	
		
		response.sendRedirect("formout.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
