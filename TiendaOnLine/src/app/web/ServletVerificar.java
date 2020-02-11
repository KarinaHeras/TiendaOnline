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
 * Servlet implementation class ServletVerificar
 */
@WebServlet("/servletverificar")
public class ServletVerificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVerificar() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		//Recobrar los datos del formulario
		Cliente clienteFormulario = (Cliente) request.getAttribute("clienteLogin");
		//Definir variables
		RequestDispatcher rd = null;
		//Verificar la password
		if(clienteFormulario!= null) {
			//Mandar llamar el método para verificar la password
			try {
				clienteFormulario = (new AccesoTiendaOnLine()).verificarPassword(clienteFormulario);
				request.setAttribute("clienteConNombre", clienteFormulario);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (clienteFormulario.getNombre()!=null) {
			//En caso de estar correcta la password pasar a pagar
			rd = request.getRequestDispatcher("/hacerpago.jsp");
		} else {
			//En caso de estar incorrecta regresar al menu principal
			rd = request.getRequestDispatcher("/index.jsp");
		}
		rd.forward(request, response);
		
		
	}

}
