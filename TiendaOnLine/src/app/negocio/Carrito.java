package app.negocio;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.modelo.Producto;
import app.persistencia.AccesoTiendaOnLine;

public class Carrito implements Serializable{
	//Atributos
	private List<Producto> contenido = new ArrayList<>();
	private double importe;
	
	//Constructores
	public Carrito() {
		// TODO Auto-generated constructor stub
	}
	//Añadir Productos al carrito
	public void addProducto(int id) throws ClassNotFoundException, SQLException {	
		Producto producto = (new AccesoTiendaOnLine()).buscar(id);
		System.out.println("El producto es --> "+ producto);
		contenido.add(producto);
		System.out.println("Importe antes de sumar " + importe);
		importe += producto.getPrecio();
		System.out.println("Importe despues de sumar " + importe);
	}
	
	public void removeProducto(int id) {
		Producto eliminar = null;
		//recorre la lista para buscar el producto con el mismo id
		for (Producto producto : contenido) {
			if (producto.getIdProducto() == id) {
				eliminar = producto;
			}
		}
		contenido.remove(eliminar);
		importe -= eliminar.getPrecio();
	}
	
//	private Producto buscar(int id) {
//		ItfzDAO dao = new ProductosDAO();
//		Producto encontrado = dao.buscarProducto(id);
//		return encontrado;
//	}

	public List<Producto> getContenido() {
		return contenido;
	}

	public double getImporte() {
		return importe;
	}

}
