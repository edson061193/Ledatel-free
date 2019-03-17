package Dao;

import Conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Edson Suarez
 */
public class servicioDao {
    Connection connection;

public ResultSet obtenerCodServc() throws Exception {
        connection = conexion.getInstance().getConnection();
        String sql = "SELECT * FROM tb_servicio";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
     
}
