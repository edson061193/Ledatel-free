/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.conexion;
import To.detalleventa_TO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author EdsonSuarezL
 */
public class detalleDao {

    Connection connection;

    public void grabarDetalle(detalleventa_TO to) throws Exception {
        connection = conexion.getInstance().getConnection();
        CallableStatement cs = connection.prepareCall("INSERT INTO tb_detalle_venta VALUES(?,?,?,?,?)");
        cs.setString(1, to.getCodfactura());
        cs.setString(2, to.getCodproducto());
        cs.setDouble(3, to.getPrecio());
        cs.setInt(4, to.getCantidad());
        cs.setDouble(5, to.getImporte());
        cs.execute();

    }
    public void grabarDetalle_serv(detalleventa_TO to) throws Exception {
        connection = conexion.getInstance().getConnection();
        CallableStatement cs = connection.prepareCall("INSERT INTO tb_detalle_servicios VALUES(?,?,?,?,?)");
        cs.setString(1, to.getCodfactura());
        cs.setString(2, to.getCodServ());
        cs.setDouble(3, to.getPrecio());
        cs.setInt(4, to.getCantidad());
        cs.setDouble(5, to.getImporte());
        cs.execute();

    }

    public void grabarDetalle_SERVICIOS(String obs,String costo,String prod) throws Exception {
        connection = conexion.getInstance().getConnection();
        PreparedStatement cs = connection.prepareStatement("INSERT INTO tb_servicio VALUES(0,?,?,now(),?)");
        cs.setString(1, obs);
        cs.setString(2, costo);
        cs.setString(3, prod);
                cs.execute();

    }
}
