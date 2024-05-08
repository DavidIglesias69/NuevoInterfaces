package PinturasDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import ProyectoPinturas.Conexion;
import ProyectoPinturas.Usuario;

public class RegistroDB {

	public static Usuario doLogin(String usuario, String pass) throws SQLException  {
		Conexion cone = new Conexion();
		Connection link = cone.abrirConsulta();
		Usuario nuevo= null;
		String query= "SELECT * FROM Usuario where usuario = ? AND BINARY password = ?";
		PreparedStatement llamada= link.prepareStatement(query);
		llamada.setString(1,usuario);
		llamada.setString(2,pass);
		ResultSet rs = llamada.executeQuery();

		if (rs != null) {
			while (rs.next()) {
				String DNI = rs.getString(1);
				String nombre = rs.getString(2);				
				//String password = rs.getString(3); me salto la contraseña no la almaceno no es recomandable				
				String email = rs.getString(4);

				nuevo= new Usuario (DNI,"",nombre, email);
				return nuevo;
			}

		}


		return null;
	}

	public static void añadirUsuario(String DNI, String nombre, String pass,String pass1, String email) throws SQLException {
		Conexion cone = new Conexion();
		Connection link = cone.abrirConsulta() ;
		if (pass==pass1) {		

		String query= "INSERT INTO Usuario (DNI,nombre,password, email) VALUES (?,?,?,?)";
		PreparedStatement llamada= link.prepareStatement(query);
		llamada.setString(1,DNI);
		llamada.setString(2,nombre);
		llamada.setString(3,pass);
		llamada.setString(4,email);
		

		llamada.executeUpdate();

		}
		
		else {
			System.out.println("Debe poner la misma contraseña");
		}
	}
	/*public static String[] getEditoriales () throws SQLException{

		ArrayList<String> listado= new ArrayList<>();
		Conexion cone = new Conexion();
		Connection link = cone.abrirConsulta();
		String select = "SELECT * FROM editorial";
		PreparedStatement llamada= link.prepareStatement(select);
		ResultSet rs= llamada.executeQuery();

		if (rs != null) {
			while (rs.next()) {

				String nombre= rs.getString(2);
				listado.add(nombre);

			}

		}

		String[] resultado=new String [listado.size()];

		for (int i = 0; i < resultado.length; i++) {
			resultado [i]= listado.get(i);
		}


		return resultado;

	}

	public static Editorial getEditorial (String nombre) throws SQLException {

		Conexion cone = new Conexion();
		Connection link = cone.abrirConsulta();
		Editorial nuevo= null;
		String query= "SELECT * FROM editorial where nombre = ?";
		PreparedStatement llamada= link.prepareStatement(query);

		llamada.setString(1,nombre);
		ResultSet rs = llamada.executeQuery();

		if (rs != null) {
			while (rs.next()) {
				
				String cif = rs.getString(1);
				String nombre1 = rs.getString(2);


				nuevo= new Editorial (cif,nombre1);
				return nuevo;
			}

		}


		return null;

	}*/
}



