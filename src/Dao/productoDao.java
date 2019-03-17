package Dao;

import Conexion.conexion;
import To.producto_TO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author EdsonSuarezL
 */
public class productoDao {

    Connection connection;

    public ResultSet buscarProductoVentas(String marca, String modelo) throws Exception {
        marca = '%' + marca + '%';
        modelo = '%' + modelo + '%';
//        connection = conexion.getInstance().getConnection();
        abrirConexion();
        PreparedStatement ps
                = connection.prepareStatement("SELECT * FROM V_PRODUCTO_VENTAS where CANTIDAD>0 and MARCA like ? or SERIE like ?");
        ps.setString(1, marca);
        ps.setString(2, modelo);
        ResultSet rs = ps.executeQuery();
        return rs;

    }

    public void reduceProducto(int cantidad, producto_TO to) throws Exception {
//        connection = conexion.getInstance().getConnection();
        abrirConexion();
        PreparedStatement ps = connection.prepareStatement("update tb_producto cantidad set cantidad=cantidad-? where codigoProducto=?");
        ps.setInt(1, cantidad);
        ps.setString(2, to.getCodigoProd());
        ps.execute();
    }

    public void ProductoDevolucion(int cantidad, producto_TO to) throws Exception {
        abrirConexion();
        PreparedStatement ps = connection.prepareStatement("update tb_producto stock set stock=stock+? where codigorProducto=?");
        ps.setInt(1, cantidad);
        ps.setString(2, to.getCodigoProd());
        ps.execute();
    }

    public void devuelveProducStock(int cantidad, String codigo) throws Exception {
        connection = conexion.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement("update tb_producto  set stock=stock+? where codigorProducto=?");
        ps.setInt(1, cantidad);
        ps.setString(2, codigo);
        ps.execute();
    }

    public void RegistrarComprar(String codigo, int cantidad, double gastos) throws Exception {
        abrirConexion();
        CallableStatement cs = connection.prepareCall("INSERT INTO tb_compras VALUES(NULL,?,?,?,NOW())");
        cs.setString(1, codigo);
        cs.setInt(2, cantidad);
        cs.setDouble(3, gastos);
        cs.execute();
    }

    public void registrar_Producto(producto_TO to) throws Exception {
        abrirConexion();
        PreparedStatement cs = connection.prepareStatement("INSERT INTO tb_producto VALUES(0,?,?,?,?,?,?,?,?,?,?)");
        cs.setString(1, to.getProveedor());
        cs.setString(2, to.getTipo());
        cs.setString(3, to.getCodigoProd());
        cs.setString(4, to.getMarca());
        cs.setString(5, to.getModelo());
        cs.setDouble(6, to.getPrecioCpmpra());
        cs.setDouble(7, to.getPrecioVenta());
        cs.setInt(8, to.getStock());
        cs.setString(9, to.getDescripcion());
        cs.setString(10, to.getEstado());

        cs.execute();
    }

    public String obtenerCodProducto() throws Exception {
        abrirConexion();
        String sql = "SELECT codigoRegp FROM tb_producto ORDER BY 1 DESC LIMIT 1";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.last();
        return rs.getString(1);
    }

    public ResultSet reportarCompras(String fechaIncio, String fechaFin) throws Exception {
        String sql;
        sql = "SELECT * FROM V_COMPRA_PRODUCTO where  fecha  between ? and ? order by fecha";
        abrirConexion();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, fechaIncio);
        ps.setString(2, fechaFin);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public ResultSet cargaMarca() throws Exception {
        abrirConexion();
        PreparedStatement ps = connection.prepareStatement("SELECT *  FROM TB_PRODUCTO group by 5");
        ResultSet rs = ps.executeQuery();
        return rs;
    }
 public ResultSet obternerCodigo() throws Exception {
        abrirConexion();
        PreparedStatement ps = connection.prepareStatement("SELECT CODIGOREGP,CODIGOPRODUCTO FROM TB_PRODUCTO");
        ResultSet rs = ps.executeQuery();
        return rs;
    }
 

    public ResultSet buscaPorMarca(String marca) throws Exception {
        abrirConexion();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM V_PRODUCTO_VENTAS where CANTIDAD>0 and MARCA = ?");
        ps.setString(1, marca);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
public  void modificar_Producto(producto_TO to)throws Exception{
    abrirConexion();
    String Sql="CALL sp_producto_update(?,?,?,?) ";
    CallableStatement cs = connection.prepareCall(Sql);
    cs.setString(1, to.getCodigoProd());
    cs.setDouble(2, to.getPrecioVenta());
    cs.setInt(3, to.getStock());
    cs.setString(4, to.getEstado());
    cs.execute();


}
    
    private void abrirConexion() throws Exception {
        connection = conexion.getInstance().getConnection();
    }

}
