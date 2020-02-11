package app.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.modelo.Producto;
import app.negocio.Carrito;
import app.persistencia.AccesoTiendaOnLine;

/**
 * Servlet implementation class ServletTienda
 */
@WebServlet("/servlettienda")
public class ServletTienda extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTienda() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Recoger variables
		String opcion = request.getParameter("op");
		ArrayList<Producto> productos = null;
		RequestDispatcher rd = null;
		HttpSession miSesion;
		Carrito c1 = null;
		switch (opcion) {
		case "1":
			AccesoTiendaOnLine at1 = new AccesoTiendaOnLine();
			try {
				productos = at1.obtenerTodos();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Guardar productos (ArrayList) en el ambito de request
			request.setAttribute("p", productos);
			rd = request.getRequestDispatcher("/mostrarproductos.jsp");
			rd.forward(request, response);

			break;
		case "6":
			// Recuperar o crear la sesion
			miSesion = request.getSession();
			// Recuperar el carrito de mi sesion
			c1 = (Carrito) miSesion.getAttribute("MiCarro");
			// Compruebo que existe el carrito
			if (c1 == null) {
				c1 = new Carrito();
				miSesion.setAttribute("MiCarro", c1);
			}
			// Agregar el producto al carrito
			try {
				System.out.println("llega con el producto " + request.getParameter("id"));
				c1.addProducto(Integer.parseInt(request.getParameter("id")));
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
			rd = request.getRequestDispatcher("/mostrarcarrito.jsp");
			rd.forward(request, response);
			break;
		case "7":
			// Recuperar o crear la sesion
			miSesion = request.getSession();
			// Recuperar el carrito de mi sesion
			c1 = (Carrito) miSesion.getAttribute("MiCarro");
			// Compruebo que existe el carrito
			if (c1 == null) {
				c1 = new Carrito();
				miSesion.setAttribute("MiCarro", c1);
			}
			// Eliminar el producto del carrito

			System.out.println("llega con el producto " + request.getParameter("id"));
			c1.removeProducto(Integer.parseInt(request.getParameter("id")));
			rd = request.getRequestDispatcher("/mostrarcarrito.jsp");
			rd.forward(request, response);
			break;
		default:
			break;
		}
	}

}
