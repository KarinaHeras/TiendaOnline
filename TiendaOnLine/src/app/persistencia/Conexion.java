package app.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	//Atributos
	protected Connection miConexion;
	protected String driverBD;
	protected String stringConexion;
	
	//Constructores
	public Conexion() {
		// TODO Auto-generated constructor stub
	}	
	public Conexion(String driverBD) {
		this.driverBD = driverBD;
	}

	//metodos
	public void abrirConexion() throws SQLException, ClassNotFoundException {
		 Class.forName("com.mysql.cj.jdbc.Driver");
	     miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendaonline?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false",
	              "root", "Curso2019$");
	     System.out.println("Se abrió correctamente la conexion");
//				
	}
	public void cerrarConexion() throws SQLException {
		miConexion.close();
	}

}
