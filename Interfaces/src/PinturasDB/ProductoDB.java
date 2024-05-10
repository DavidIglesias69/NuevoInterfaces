package PinturasDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import PinturasInterface.Conexion;

public class ProductoDB {
	
	 public static double obtenerPrecio(String nombreProducto) throws SQLException {
	        Conexion cone = new Conexion();
	        Connection link = cone.abrirConsulta();
	        double precio = 0;

	        try {
	            String query = "SELECT precio FROM Producto WHERE nombre = ?";
	            PreparedStatement preparedStatement = link.prepareStatement(query);
	            preparedStatement.setString(1, nombreProducto);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                precio = resultSet.getDouble("precio");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Manejar la excepción apropiadamente
	        } finally {
	            if (link != null) {
	                link.close();
	            }
	        }

	        return precio;
	    }
	 
	 public static double calcularPrecioTotal(int cantidadPintura, int cantidadRodillo, int cantidadPapel,
             int cantidadBrocha, int cantidadEscalera, int cantidadBarniz,
             int cantidadDisolvente, int cantidadPlasticos, int cantidadDecapante,
             int cantidadEspatula, double precioPintura, double precioRodillo,
             double precioPapel, double precioBrocha, double precioEscalera,
             double precioBarniz, double precioDisolvente, double precioPlasticos,
             double precioDecapante, double precioEspatula) {
// Calcular el precio total sumando los precios individuales de los productos seleccionados
double precioTotal = (precioPintura * cantidadPintura) + (precioRodillo * cantidadRodillo) +
(precioPapel * cantidadPapel) + (precioBrocha * cantidadBrocha) +
(precioEscalera * cantidadEscalera) + (precioBarniz * cantidadBarniz) +
(precioDisolvente * cantidadDisolvente) + (precioPlasticos * cantidadPlasticos) +
(precioDecapante * cantidadDecapante) + (precioEspatula * cantidadEspatula);

return precioTotal;
}


}
