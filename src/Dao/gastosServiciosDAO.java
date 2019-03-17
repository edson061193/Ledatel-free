/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Conexion.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Edson J Suárez L
 */
public class gastosServiciosDAO {

    public ResultSet cargaCompras(String fechaIcinio, String fechaFinal) throws Exception{
        Connection con= conexion.getInstance().getConnection();
        PreparedStatement ps= con.prepareStatement("select sum(costos) from tb_compras where fecha between ? and ?");
        ps.setString(1, fechaIcinio);
        ps.setString(2, fechaFinal);
        ResultSet rs = ps.executeQuery();
        return  rs;
    }

    public ResultSet cargaventas(String fechaIcinio, String fechaFinal) throws Exception{
    Connection con= conexion.getInstance().getConnection();
        PreparedStatement ps= con.prepareStatement("select sum(importe) from tb_detalle_venta d , tb_factura f where\n" +
"f.codigofactura = d.codigofactura and f.fecha between  ?  and ?");
        ps.setString(1, fechaIcinio);
        ps.setString(2, fechaFinal);
        ResultSet rs = ps.executeQuery();  
        return rs;
    }

    public ResultSet cargareparaciones(String fechaIcinio, String fechaFinal)  throws Exception{
    Connection con= conexion.getInstance().getConnection();
        PreparedStatement ps= con.prepareStatement("select sum(importe) from tb_detalle_servicios d , tb_factura f where\n" +
"f.codigofactura = d.codigofactura and f.fecha between  ?  and ?");
        ps.setString(1, fechaIcinio);
        ps.setString(2, fechaFinal);
        ResultSet rs = ps.executeQuery();  
        return rs;
    }
    
}
