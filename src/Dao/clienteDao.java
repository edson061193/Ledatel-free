/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.conexion;
import To.cliente_TO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author EdsonSuarezL
 */
public class clienteDao {

    Connection connection;

    public void registrarClienteFactura(cliente_TO to) throws Exception {
        connection = conexion.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement("INSERT INTO tb_cliente VALUES(0,?,?,?,?,?,?,?)");
        ps.setString(1, to.getTipo());
        ps.setString(2, to.getDni());
        ps.setString(3, to.getDatos());
        ps.setString(4, to.getDireccion());
        ps.setString(5, to.getCelular());
        ps.setString(6, to.getEmail());
        ps.setString(7, to.getEstado());
        ps.execute();

    }
    public  void modificarCliente(cliente_TO t)throws Exception{
        connection=conexion.getInstance().getConnection();
        String sql="UPDATE tb_cliente t SET tipo=?,direccion = ?, celular=?,email=? where codigocliente=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, t.getTipo());
        ps.setString(2, t.getDireccion());
        ps.setString(3, t.getCelular());
        ps.setString(4, t.getEmail());
        ps.setString(5, t.getCodigo());
        ps.execute();
    }

    public ResultSet garcaCliente() throws Exception {
        connection = conexion.getInstance().getConnection();
        String SQL = "SELECT DNI,DATOS,DIRECCION,CELULAR,EMAIL,tipo,codigocliente  FROM tb_cliente WHERE ESTADO=1 ORDER BY CODIGOCLIENTE DESC";
        PreparedStatement PS = connection.prepareStatement(SQL);
        ResultSet rs = PS.executeQuery();
        return rs;
    }

    public ResultSet buscaCliente(String dni, String datos) throws Exception {
        dni = '%' + dni + '%';
        datos = '%' + datos + '%';
        connection = conexion.getInstance().getConnection();
        PreparedStatement ps
                = connection.prepareStatement("SELECT DNI,DATOS,DIRECCION,CELULAR,EMAIL,TIPO FROM tb_cliente WHERE ESTADO=1 and DNI like ? or DATOS like ?");
        ps.setString(1, dni);
        ps.setString(2, datos);
        ResultSet rs = ps.executeQuery();
        return rs;

    }
}
