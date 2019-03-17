/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.conexion;
import To.boleta_TO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author EdsonSuarezL
 */
public class boletaDao {
    
    Connection connection;
    
    public ResultSet obteneriIDcliente() throws Exception {
        connection = conexion.getInstance().getConnection();
        String sql = "SELECT CODIGOCLIENTE,DNI FROM tb_cliente";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
    public void registrarCaja(String fecha, double inicio, double compras, double ventas, double reparaciones, double nuevoSaldo,String hrInicio,String hrFinal) throws Exception {
        connection = conexion.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement("INSERT INTO tb_caja VALUES(?,?,?,?,?,?,?,?)");
        ps.setString(1, fecha);
        ps.setDouble(2, inicio);
        ps.setDouble(3, compras);
        ps.setDouble(4, ventas);
        ps.setDouble(5, reparaciones);
        ps.setDouble(6, nuevoSaldo);
        ps.setString(7, hrInicio);
        ps.setString(8, hrFinal);
        ps.execute();
    }
    
    public void grabarFacturaVentas(boleta_TO to) throws Exception {
        connection = conexion.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement("INSERT INTO tb_factura VALUES(0,?,?,now(),?,?,?,?,?,now(),?,?)");
        ps.setString(1, to.getCodigoFactura());
        ps.setString(2, to.getRuc());        
        ps.setDouble(3, to.getIgv());
        ps.setDouble(4, to.getSubtotal());
        ps.setDouble(5, to.getTotal());
        ps.setString(6, to.getEstado());
        ps.setString(7, to.getTipoDepago());
        ps.setString(8, to.getCodEmpleado());
        ps.setString(9, to.getCodigoCliente());
        ps.execute();
    }
    // para el incremento del codigo de la factura
    public ResultSet codigoFacturaTop() throws Exception {
        connection = conexion.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement("select factura,ruc from tb_factura order by 1 desc limit 1");
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
    // obterner el n registro de la factura para el detalle de  venta
    public String obteneriIDfactura() throws Exception {
        connection = conexion.getInstance().getConnection();
        String sql = "SELECT CODIGOFACTURA FROM tb_factura ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.last();
        return rs.getString(1);
    }
    
    public ResultSet reportarVentas(String fechai, String fechaf) throws Exception {
        String sql = "select f.factura,c.datos,f.fecha,f.igv,f.subtotal,f.total from tb_factura f\n"
                + ",tb_cliente c where f.codigocliente=c.codigocliente  and fecha  between ? and ?  order by 1 desc";
        connection = conexion.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, fechai);
        ps.setString(2, fechaf);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
    public  ResultSet listaDetalle(String factura)throws Exception{
        String sql="SELECT f.factura, p.marca, p.serie,d.precio,d.cantidad,d.importe , c.datos, e.apellidos FROM tb_factura f , tb_detalle_venta d\n" +
", tb_producto p , tb_cliente c, tb_empleado e\n" +
"where f.codigofactura=d.codigofactura and d.codigoRegp=p.codigoRegp\n" +
"and e.codigoempleado=f.codigoempleado and c.codigocliente=f.codigocliente and factura = ? ";
         connection = conexion.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, factura);
        ResultSet rs = ps.executeQuery();
        return  rs;
    }
}
