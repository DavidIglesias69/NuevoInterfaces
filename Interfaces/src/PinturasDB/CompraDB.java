package PinturasDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import PinturasInterface.Conexion;

public class CompraDB {
    public static int guardarCompra(String dniUsuario, Date fecha, Connection conn) throws SQLException {
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO Compra (DNI, Fecha) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, dniUsuario);
            statement.setDate(2, fecha);
            statement.executeUpdate();
            rs = statement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return -1;
    }
}
