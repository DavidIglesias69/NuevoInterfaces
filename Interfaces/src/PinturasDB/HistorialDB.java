package PinturasDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JSpinner;

import PinturasInterface.Conexion;

public class HistorialDB {
	public static void actualizarHistorial(int idCompra, ArrayList<JSpinner> componentes, ArrayList<JLabel> labels) throws SQLException {
	    Conexion conexion = new Conexion();
	    Connection conn = conexion.abrirConsulta();
	    try {
	        String sql = "INSERT INTO Historial_Producto (ID_Compra, ID_Producto, Cantidad, Precio_Total) VALUES (?, ?, ?, ?)";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        for (int i = 0; i < componentes.size(); i++) {
	            int cantidad = (Integer) componentes.get(i).getValue();
	            if (cantidad > 0) {
	                // Suponiendo que el ID del producto se puede deducir o es conocido de alguna manera
	                int idProducto = i + 1; // Por ejemplo, si cada spinner corresponde a un ID de producto consecutivo
	                String text = labels.get(i).getText().replace("€", "");
	                double precio = Double.parseDouble(text) * cantidad;
	                
	                statement.setInt(1, idCompra);
	                statement.setInt(2, idProducto);
	                statement.setInt(3, cantidad);
	                statement.setDouble(4, precio);
	                statement.executeUpdate();
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (conn != null) conn.close();
	    }
	}

}
