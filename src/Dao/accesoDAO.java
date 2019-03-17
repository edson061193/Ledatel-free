package Dao;

import Conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class accesoDAO {

    Connection connection;

    public boolean validarAccesoAdmin(String usuario, String clave) throws Exception {
        connection = conexion.getInstance().getConnection();
        PreparedStatement ps
                = connection.prepareStatement("SELECT * FROM tb_empleado WHERE tipoEmpleado='Administrador' and idEmpleado=? AND clave=?");
        ps.setString(1, usuario);
        ps.setString(2, clave);
        ResultSet rs = ps.executeQuery();
        boolean rpta = rs.next();

        return rpta;
    }

    public boolean validarAccesoEmpl(String usuario, String clave) throws SQLException {
        try {
            connection = conexion.getInstance().getConnection();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM tb_empleado WHERE tipoEmpleado='vendedor' and idEmpleado=? AND clave=? ");
        ps.setString(1, usuario);
        ps.setString(2, clave);
        ResultSet rs = ps.executeQuery();
        boolean rpta = rs.next();

        return rpta;
    }

    public ResultSet caragAccesoEmpl(String usuario, String clave) throws Exception {
        connection = conexion.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM tb_empleado where idEmpleado=? AND clave=? ");
        ps.setString(1, usuario);
        ps.setString(2, clave);
        ResultSet rs = ps.executeQuery();

        return rs;
    }

}
