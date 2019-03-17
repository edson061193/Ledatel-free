/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;
import Conexion.conexion;
import To.contratoTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Edson Jsl
 */
public class contratoDao {
    Connection conn=null;
    public void RegistrarCredito(contratoTO to) throws Exception{
        AbrirConexion();
        String SQL="INSERT INTO tb_contrato VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, to.getCodContrado());
        ps.setString(2, to.getCodigocliente());
        ps.setString(3, to.getCodigoRegP());
        ps.setInt(4, to.getCantidad());
        ps.setDouble(5, to.getPrecioActual());
        ps.setDouble(6, to.getPrecioNuevo());
        ps.setInt(7, to.getPeriodo());
        ps.setDouble(8, to.getPago());
        ps.setInt(9, to.getLetra());
        ps.setString(10, to.getFechapagos());
        ps.execute();        
    }
    
   public void AbrirConexion()throws Exception{
    conn= conexion.getInstance().getConnection();
    }

    public ResultSet validarCliente() throws  Exception {
      AbrirConexion();
      PreparedStatement ps = conn.prepareStatement("SELECT * FROM tb_cliente");
      ResultSet rs = ps.executeQuery();
      return rs;
    }

    public ResultSet validarProducto()throws Exception{
    AbrirConexion();
      PreparedStatement ps = conn.prepareStatement("SELECT * FROM tb_producto");
      ResultSet rs = ps.executeQuery();
      return rs;    
    }
    public ResultSet devuelveNumContrato()throws Exception{
        AbrirConexion();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM tb_contrato t order by 1 desc limit 1");
        ResultSet rs=ps.executeQuery();
        return rs;
    }

    public ResultSet cargaRegistros_Contrato()throws Exception{
       AbrirConexion();
       PreparedStatement ps = conn.prepareStatement("SELECT * FROM v_contrato order by 1 desc");
       ResultSet rs = ps.executeQuery();
       return rs;
    }
}
