package PinturasDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;

import ProyectoPinturas.Conexion;
import ProyectoPinturas.Usuario;

public class RegistroDB extends JFrame{

	public static Usuario doLogin(String usuario, String pass) throws SQLException  {
		Conexion cone = new Conexion();
		Connection link = cone.abrirConsulta();
		Usuario nuevo= null;
		String query= "SELECT * FROM Usuario where DNI = ? AND BINARY Contraseña = ?";
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
				int resp = rs.getInt(5);

				nuevo= new Usuario (DNI,nombre,"", email, resp);
				return nuevo;
			}

		}


		return null;
	}

	public static void añadirUsuario(String DNI, String nombre, String pass,String pass1, String email) {
	    Conexion cone = new Conexion();
	    Connection link = null;
	    try {
	        link = cone.abrirConsulta();
	        if (pass.equals(pass1)) {
	            String query= "INSERT INTO Usuario (DNI,Nombre,Contraseña, Email) VALUES (?,?,?,?)";
	            PreparedStatement llamada= link.prepareStatement(query);
	            llamada.setString(1,DNI);
	            llamada.setString(2,nombre);
	            llamada.setString(3,pass);
	            llamada.setString(4,email);

	            llamada.executeUpdate();
	        } else {
	            System.out.println("Debe poner la misma contraseña");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Manejar la excepción apropiadamente
	    } finally {
	        if (link != null) {
	            try {
	                link.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	                // Manejar la excepción apropiadamente
	            }
	        }
	    }
	}
	
}



