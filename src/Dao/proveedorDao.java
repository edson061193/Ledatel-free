/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.conexion;
import To.proveedor_TO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Edson Jsl
 */
public class proveedorDao {

    Connection connection;

    public void registrarProveedor(proveedor_TO to) throws Exception {
        connection = conexion.getInstance().getConnection();
        String sql = "CALL sp_proveedor_insertar(?,?,?,?,?,?,?)";
        CallableStatement cs = connection.prepareCall(sql);
        cs.setString(1, to.getEmpresa());
        cs.setString(2, to.getContacto());
        cs.setString(3, to.getTelefono());
        cs.setString(4, to.getDireccion());
        cs.setString(5, to.getEmail());
        cs.setString(6, to.getTipo());
        cs.setString(7, to.getServicios());
        cs.execute();
    }

    public void EditarProveedor(proveedor_TO to) throws Exception {
        connection = conexion.getInstance().getConnection();
        String sql = "CALL sp_proveedor_update(?,?,?,?,?,?,?,?)";
        CallableStatement cs = connection.prepareCall(sql);
        cs.setString(1, to.getCodigo());
        cs.setString(2, to.getEmpresa());
        cs.setString(3, to.getContacto());
        cs.setString(4, to.getTelefono());
        cs.setString(5, to.getDireccion());
        cs.setString(6, to.getEmail());
        cs.setString(7, to.getTipo());
        cs.setString(8, to.getServicios());
        cs.execute();
    }

    public void EliminarProveedor(proveedor_TO to) throws Exception {
        connection = conexion.getInstance().getConnection();
        String sql = "CALL sp_proveedor_delete(?)";
        CallableStatement cs = connection.prepareCall(sql);
        cs.setString(1, to.getCodigo());
        cs.execute();
    }

    public ResultSet cargarProveedor() throws Exception {
        connection = conexion.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM tb_proveedor where estado='1'");
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public ResultSet buscaProveedor(String sociedad, String servicios) throws Exception {
        sociedad = '%' + sociedad + '%';
        servicios = '%' + servicios + '%';
        connection = conexion.getInstance().getConnection();
        String SQL = "SELECT * FROM tb_proveedor where sociedad  like ? or actividad like ?";
        PreparedStatement ps = connection.prepareStatement(SQL);
        ps.setString(1, sociedad);
        ps.setString(2, servicios);
        ResultSet rs = ps.executeQuery();
        return rs;

    }

}
