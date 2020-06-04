package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAOImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String respuesta="";
		String nombre = request.getParameter("nombre");
		String pasword = request.getParameter("pass");
		HttpSession sesion = request.getSession(true);
		UsuarioDAOImpl dao= UsuarioDAOImpl.getInstance();
		Usuario usuario = dao.existe(nombre, pasword);

		try {
			

			if (usuario !=null) {

				sesion.setAttribute("isLogeado", true);
				sesion.setAttribute("nombre", nombre);
				sesion.setAttribute("contrasenia", pasword);
				
				respuesta = usuario.toString();
				request.setAttribute("alerta", new Alerta("success","Enhorabuena, estas conectado con nosotros"));			
				request.getRequestDispatcher("index.jsp").forward(request, response);

			} else {

				respuesta ="hay una sesion ";
				request.setAttribute("respuesta",respuesta);
				request.setAttribute("alerta", new Alerta("warning","no Logeado"));
				request.getRequestDispatcher("login.jsp").forward(request, response);

			}

		} catch (Exception e) {

			System.out.println("danger");
			e.printStackTrace();

		}

	}

}
