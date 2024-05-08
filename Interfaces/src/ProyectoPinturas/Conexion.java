package ProyectoPinturas;


import java.sql.*;

public class Conexion {

	private final String database = "jdbc:mysql://92.222.10.128/DavidIglesias";
	private final String usuario = "davidiglesias";
	private final String password = "Clave123!";
	
	public Statement abrirConexion() {
		
		Connection link;
		Statement stm = null;
		
		try {
			
			//Class.forName("com.mysql.cj.jdbc.Driver");
			link = DriverManager.getConnection(database, usuario, password);
			stm = link.createStatement();
		
		} catch (Exception e) {
			//MANEJO DE EXCEPCIONES
			
			
		}
		
		return stm;
	}
	
public Connection abrirConsulta() {
		
		Connection link= null;
		
		
		try {
			
			//Class.forName("com.mysql.cj.jdbc.Driver");
			link = DriverManager.getConnection(database, usuario, password);
			
		
		} catch (Exception e) {
			e.printStackTrace();
			
			
		}
		
		return link;
	}
	
	public void cerrarConexion(Statement stm) {
		
		try {
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
