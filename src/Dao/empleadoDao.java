package Dao;

import Conexion.conexion;
import To.empleado_TO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author EdsonSuarezL
 */
public class empleadoDao {

    Connection connection;

    public ResultSet cargaEmpleado() throws Exception {
        connection = conexion.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement("select codigoempleado, apellidos,nombres from tb_empleado where estado='TRABAJANDO'");
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public ResultSet buscarEmpleado(String apellido, String nombre, String dni) throws Exception {
        nombre = '%' + nombre + '%';
        apellido = '%' + apellido + '%';
        dni = '%' + dni + '%';
        connection = conexion.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM v_empleados   where apellidos like ? or nombres like ? or  dni like ?");
        ps.setString(1, apellido);
        ps.setString(2, nombre);
        ps.setString(3, dni);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public void ModificarEmpleado(empleado_TO to) throws Exception {
        connection = conexion.getInstance().getConnection();
        CallableStatement cs = connection.prepareCall("CALL sp_empleado_update(?,?,?,?,?,?,?,?,?)");
        cs.setString(1, to.getCodigoempleado());
        cs.setString(2, to.getTipoUsuario());
        cs.setString(3, to.getDNI());
        cs.setString(4, to.getApellidos());
        cs.setString(5, to.getNombres());
        cs.setString(6, to.getDireccion());
        cs.setString(7, to.getCorreo());
        cs.setString(8, to.getTelefono());
        cs.setDouble(9, to.getSueldo());
        cs.execute();
    }

    public void EliminarEmpleado(empleado_TO to) throws Exception {
        connection = conexion.getInstance().getConnection();
        CallableStatement cs = connection.prepareCall("CALL sp_empleado_delete(?)");
        cs.setString(1, to.getCodigoempleado());
        cs.execute();
    }

    public void RegistrarEmpleado(empleado_TO to) throws Exception {
        connection = conexion.getInstance().getConnection();
        CallableStatement cs = connection.prepareCall("CALL sp_empleado_insert(?,?,?,?,?,?,?,?,?,?,?)");
        cs.setString(1, to.getTipoUsuario());
        cs.setString(2, to.getDNI());
        cs.setString(3, to.getApellidos());
        cs.setString(4, to.getNombres());
        cs.setString(5, to.getSexo());
        cs.setString(6, to.getDireccion());
        cs.setString(7, to.getCorreo());
        cs.setString(8, to.getTelefono());
        cs.setDouble(9, to.getSueldo());
        cs.setString(10, to.getId());
        cs.setString(11, to.getContraseña());
        cs.execute();
    }

    public ResultSet ventasEmpleados(String fechaI, String fechaF, String codigo) throws Exception {
        connection = conexion.getInstance().getConnection();
        String sql = "SELECT f.fecha,f.factura,f.estado,p.codigoproducto,p.marca,p.serie,p.precioventa,d.cantidad,d.importe,c.datos\n"
                + "                FROM tb_detalle_venta d,tb_factura f,tb_producto p, tb_cliente c,tb_empleado e\n"
                + "\n"
                + "                where f.codigofactura=d.codigofactura\n"
                + "                and d.codigoregp=p.codigoregp\n"
                + "\n"
                + "                and c.codigocliente=f.codigocliente\n"
                + "             and e.codigoempleado=f.codigoempleado\n"
                + "               and  not f.estado='venta c' and f.fecha  between ? and ? and f.codigoempleado=? order by 1 desc";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, fechaI);
        ps.setString(2, fechaF);
        ps.setString(3, codigo);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

}
