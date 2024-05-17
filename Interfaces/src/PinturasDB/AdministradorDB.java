package PinturasDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import PinturasInterface.Conexion;

public class AdministradorDB {

    public static double obtenerPrecio(String nombreProducto) throws SQLException {
        Conexion conexion = new Conexion();
        Connection con = conexion.abrirConsulta();
        double precio = 0;
        try {
            String sql = "SELECT precio FROM Producto WHERE nombre = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nombreProducto);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                precio = rs.getDouble("precio");
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return precio;
    }

    public static int obtenerCantidad(String nombreProducto) throws SQLException {
        Conexion conexion = new Conexion();
        Connection con = conexion.abrirConsulta();
        int cantidad = 0;
        try {
            String sql = "SELECT cantidad FROM Producto WHERE nombre = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nombreProducto);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cantidad = rs.getInt("cantidad");
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return cantidad;
    }

    public static void añadirProducto(String nombreProducto, int cantidad) throws SQLException {
        Conexion conexion = new Conexion();
        Connection con = conexion.abrirConsulta();
        try {
            String sql = "UPDATE Producto SET cantidad = cantidad + ? WHERE nombre = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, cantidad);
            pst.setString(2, nombreProducto);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void eliminarProducto(String nombreProducto, int cantidad) throws SQLException {
        Conexion conexion = new Conexion();
        Connection con = conexion.abrirConsulta();
        try {
            String sql = "UPDATE Producto SET cantidad = cantidad - ? WHERE nombre = ? AND cantidad >= ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, cantidad);
            pst.setString(2, nombreProducto);
            pst.setInt(3, cantidad);  // Asegura que la cantidad no sea negativa
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void actualizarPrecio(String nombreProducto, double nuevoPrecio) throws SQLException {
        Conexion conexion = new Conexion();
        Connection con = conexion.abrirConsulta();
        try {
            String sql = "UPDATE Producto SET precio = ? WHERE nombre = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDouble(1, nuevoPrecio);
            pst.setString(2, nombreProducto);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
