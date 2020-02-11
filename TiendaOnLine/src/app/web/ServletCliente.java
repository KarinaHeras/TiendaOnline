package app.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.modelo.Cliente;
import app.persistencia.AccesoTiendaOnLine;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/servletcliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		// TODO Auto-generated method stub
		doGet(request, response);
		//Declarar variables
		boolean alta = false;
		Cliente clienteDeRegistrar = (Cliente) request.getAttribute("c1");
		System.out.println("El cliente que recibe " + clienteDeRegistrar);
		if (clienteDeRegistrar != null) {
			System.out.println("Entra a no nulo");
			//Llamar a la capa de persistencia para
			//Guardar el cliente en la BBDD
			try {
				 alta = (new AccesoTiendaOnLine()).altaCliente(clienteDeRegistrar);
				 System.out.println("lo dio de alta " + alta);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher rq = null;
		if (alta) {
			rq = request.getRequestDispatcher("/hacerpago.jsp");
			
		} else {
			rq = request.getRequestDispatcher("/index.jsp");
		}
		rq.forward(request, response);
	}
}
