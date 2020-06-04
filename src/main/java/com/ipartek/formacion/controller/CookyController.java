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
 * Servlet implementation class CookyController
 */
@WebServlet("/cooky")
public class CookyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idioma = request.getParameter("idioma");
			
		String idioma1 = "es";
		String mensaje = "";
		
		// recuperar cookie de Idioma para mensaje de salida		
		Cookie[] cookies = request.getCookies();
		if ( cookies != null ) {
			for ( Cookie c : cookies ) {			
				if ( "cIdioma".equals(c.getName()) ) {   // cookie encontrada
					idioma1 = c.getValue();
					break;
				}			
			}
		}	
			
		switch (idioma1) {
		case "es":
			mensaje = "Adios nos vemos pronto";
			break;
			
		case "eu":
			mensaje = "Agur eta ohore";
			break;	

		default:
			mensaje = "You are wellcome to the hell";
			break;
		}
	
		
		request.setAttribute("alerta", new Alerta("success", mensaje ));

		
		// ATENCIION hacer lo ultimo, no antes de trabajar con las cookies
		HttpSession session = request.getSession();
		session.invalidate();
		session = null;
		
		request.getRequestDispatcher("index.jsp").forward(request, response);	
		
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Alerta alerta = new Alerta();

		String idioma = request.getParameter("idioma");
		
		
		//crear cookie de idioma
		Cookie cIdioma = new Cookie("cIdioma", idioma);
		cIdioma.setMaxAge( 60 * 1 * 60 * 24 * 365 * 5 ); // 5 años
		// guardar cookie 
		
		response.addCookie(cIdioma);
		
		
		Cookie cookie = new Cookie("cemail", " ");

		cookie.setMaxAge(60 * 60 * 24);
		String email = request.getParameter("email");
		cookie.setValue(email);

		
			alerta = new Alerta("success", "Cookie guardada con exito");
			request.setAttribute("alerta", alerta);
		

		response.addCookie(cookie);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
