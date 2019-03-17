package Dao;

import Conexion.conexion;
import To.cajero_TO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Edson Suarez
 */
public class cajeroDao {

    Connection connection;

    public ResultSet iniciaCajero(String fecha) throws Exception {
        abrirConexion();
        String sql;
        sql = "select inicio from tb_caja where fecha= ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, fecha);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public ResultSet ver_reparaciones(String fecha) throws Exception {
        abrirConexion();
        String sql;
        sql = "SELECT * FROM v_reparaciones where fecha= ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, fecha);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public ResultSet Cajero_compras(String fecha) throws Exception {
        abrirConexion();
        String sql;
        sql = "select sum(c.costos),c.fecha from tb_compras c   where c.fecha=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, fecha);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public ResultSet Cajero_compras_detalle(String fecha) throws Exception {
        abrirConexion();
        String sql;
        sql = "SELECT * FROM v_compras  where fecha=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, fecha);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public ResultSet Cajero_ventas(String fecha) throws Exception {
        abrirConexion();
        String sql;
        sql = "select sum(d.importe),f.fecha from tb_factura f , tb_detalle_venta d\n"
                + "              where d.codigofactura=f.codigofactura and  f.fecha= ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, fecha);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public ResultSet Cajero_reparaciones(String fecha) throws Exception {
        abrirConexion();
        String sql;
        sql = "select sum(d.importe),f.fecha from tb_factura f , tb_detalle_servicios d\n"
                + "               where d.codigofactura=f.codigofactura and  f.fecha= ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, fecha);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public ResultSet Cajero_Fecha() throws Exception {
        abrirConexion();
        String sql;
        sql = "SELECT * FROM tb_caja ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public void cerraCaja(cajero_TO to) throws Exception {
        abrirConexion();
        String sql = "CALL sp_caja_update(?,?,?,?,?,?,?)";
        CallableStatement ps = connection.prepareCall(sql);
        ps.setString(1, to.getFecha());
        ps.setDouble(2, to.getIncio());
        ps.setDouble(3, to.getCompras());
        ps.setDouble(4, to.getVentas());
        ps.setDouble(5, to.getReparaciones());
        ps.setDouble(6, to.getNuevoSaldo());
        ps.setString(7, to.getHrFinal());

        ps.execute();
    }

    protected void abrirConexion() throws Exception {
        connection = conexion.getInstance().getConnection();
    }

    public ResultSet verVentas(String fecha)throws Exception{
      abrirConexion();
      String sql="SELECT * FROM v_ventas v WHERE FECHA =? ";
      PreparedStatement ps= connection.prepareStatement(sql);
      ps.setString(1, fecha);
      ResultSet rs= ps.executeQuery();
      return rs;

    }

}
