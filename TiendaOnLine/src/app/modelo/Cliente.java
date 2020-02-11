package app.modelo;

import java.io.Serializable;

public class Cliente implements Serializable{
   //Atributos - sin tomar encuenta el id
	private String nombre;
	private String email;
	private String direccion;
	private String password;
	
	//Constructores
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nombre, String email, String direccion, String password) {
		this.nombre = nombre;
		this.email = email;
		this.direccion = direccion;
		this.password = password;
	}
	//Setters y Getters
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", email=" + email + ", direccion=" + direccion + ", password=" + password
				+ "]";
	}
	
	
	
	
	
	
}
