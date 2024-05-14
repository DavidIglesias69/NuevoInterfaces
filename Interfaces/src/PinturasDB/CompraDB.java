package PinturasDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import PinturasInterface.Conexion;

public class CompraDB {

    public static void guardarCompra(String dniUsuario, Date fecha) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.abrirConsulta();

        try {
            // Preparar la consulta SQL para insertar una nueva compra
            String sql = "INSERT INTO Compra (DNI, Fecha) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = null;
            statement.setString(1, dniUsuario);
            statement.setDate(2, fecha);
            System.out.println(statement.toString());

            // Ejecutar la consulta
            statement.executeUpdate();
            
            /*
            rs = statement.getGeneratedKeys(); Consigue el dato que se inserta
            int idCompra = 0;
            if(rs.next()) {
            	idCompra = rs.getInt(1); consigue el id del insert
            }
            */
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        } finally {
            // Cerrar la conexión
            if (conn != null) {
                conn.close();
            }
        }
    }
   
}
