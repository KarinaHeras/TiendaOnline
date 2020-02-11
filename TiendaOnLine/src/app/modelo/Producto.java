package app.modelo;

import java.io.Serializable;

public class Producto implements Serializable{
//Atributos
	private int idProducto;
	private String nombre;
	private double precio;
//Constructores
	public Producto() {
		// TODO Auto-generated constructor stub
	}
public Producto(int idProducto, String nombre, double precio) {
	this.idProducto = idProducto;
	this.nombre = nombre;
	this.precio = precio;
}
//Getters y Setters
/**
 * @return the idProducto
 */
public int getIdProducto() {
	return idProducto;
}
/**
 * @param idProducto the idProducto to set
 */
public void setIdProducto(int idProducto) {
	this.idProducto = idProducto;
}
/**
 * @return the nombre
 */
public String getNombre() {
	return nombre;
}
/**
 * @param nombre the nombre to set
 */
public void setNombre(String nombre) {
	this.nombre = nombre;
}
/**
 * @return the precio
 */
public double getPrecio() {
	return precio;
}
/**
 * @param precio the precio to set
 */
public void setPrecio(double precio) {
	this.precio = precio;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + "]";
}

	
}
