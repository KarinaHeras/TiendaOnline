package app.persistencia;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.modelo.Cliente;
import app.modelo.Producto;

public class AccesoTiendaOnLine extends Conexion {

	public ArrayList<Producto> obtenerTodos() throws ClassNotFoundException, SQLException {

		// Declarar las variables
		String sql = "call tiendaonline.obtenertodos()";
		CallableStatement cmd;
		ResultSet rs;
		ArrayList<Producto> productos = new ArrayList();

		// 1. Abrir la conexión
		abrirConexion();
		// 2. Obtener el comando de la conexión
		cmd = miConexion.prepareCall(sql);
		// 3. Ejecutar el Procedimiento almacenado
		rs = cmd.executeQuery();
		// 4. Recorrer el result set para ir añadiendo a la coleccion
		while (rs.next()) {
			Producto p1 = new Producto(rs.getInt("idproducto"), rs.getString("nombre"), rs.getDouble("precio"));
			productos.add(p1);
		}
		// 5. Cerrar la conexion
		cerrarConexion();
		System.out.println("listas de productos -"+ productos);
		return productos;
	}

	public Producto buscar(int id) throws ClassNotFoundException, SQLException {
		// Declarar variables
		String sql = "call tiendaonline.obteneruno(?);";
		CallableStatement cmd = null;
		ResultSet rs = null;
		Producto p1 = null;
		// Pasos para acceder a la BBDD
		// 1.- Abrir la conexion
		abrirConexion();
		// 2.- Obtener el comando de la conexion
		cmd = miConexion.prepareCall(sql);
		// 3.- Asignar los parámetros de la Query
		cmd.setInt(1, id);
		// 3A. Ejecutar la query
		rs = cmd.executeQuery();
		// 4.- Obtener el resultado y crear el producto
		if (rs.next()) {
			p1 = new Producto(rs.getInt("idproducto"), rs.getString("nombre"), rs.getDouble("precio"));

		}
		// 5.- Cerrar la conexion.
		cerrarConexion();
		return p1;
	}

    public boolean altaCliente(Cliente c) throws ClassNotFoundException, SQLException {
    	//1. Declarar variables
    	String sql ="call altaCliente(?, ?, ?, ?);";
    	CallableStatement cmd = null;
    	int exito = 0;
    	//2. Abrir la conexion
    	abrirConexion();
    	//3. Recuperar el comando
    	cmd = miConexion.prepareCall(sql);
    	//4. Asignar valor a los parametros
    	cmd.setString(1, c.getNombre());
    	cmd.setString(2, c.getEmail());
    	cmd.setString(3, c.getDireccion());
    	cmd.setString(4, c.getPassword());
    	//5. Ejecutar el comando
    	exito = cmd.executeUpdate();
    	System.out.println("exito desde la BBDD " + exito);
    	//6. Revisar la respuesta
    	//7. Cerrar la conexion
    	cerrarConexion();
    	//8. Devolver si se ha logrado dar de alta en la BBDD
    	return exito>=1;
    }

    public Cliente verificarPassword(Cliente c) throws ClassNotFoundException, SQLException {
    	//1.- Declarar variables
    	String sql ="call verificarpassword(?);";
    	CallableStatement cmd = null;
    	ResultSet rs = null;
    	String passwordBBDD = null;
    	//2.- Abrir la conexion
    	abrirConexion();
    	//3.- Obtener la sentencia
    	cmd = miConexion.prepareCall(sql);
    	//4.- Asignar valores a los parametros de la query
    	cmd.setString(1,c.getEmail());
    	//5.- Ejecutar la Query
    	rs = cmd.executeQuery();
    	//6.- Recuperar los datos
    	if(rs.next()) {
    		passwordBBDD = rs.getString("password");
    	}
    	//7.- Validar el Password
    	if(passwordBBDD.equals(c.getPassword())) {
    		c.setNombre(rs.getString("nombre"));
    	}
    	//8.- Cerrar la conexion
    	cerrarConexion();
    	//9.- devolver el cliente con el nombre
    	return c;
    }

}
