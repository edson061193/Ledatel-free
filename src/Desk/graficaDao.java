/*  1:   */ package Desk;
/*  2:   */ 
/*  3:   */ import Conexion.conexion;
/*  4:   */ import java.sql.Connection;
/*  5:   */ import java.sql.PreparedStatement;
/*  6:   */ import java.sql.ResultSet;
/*  7:   */ 
/*  8:   */ class graficaDao
/*  9:   */ {
/* 10:   */   public ResultSet cargaFecha(String añoI, String añoF)
/* 11:   */     throws Exception
/* 12:   */   {
/* 13:20 */     Connection conn = conexion.getInstance().getConnection();
/* 14:21 */     String sql = "select sum(total) from tb_factura  where fecha between ? and ?";
/* 15:22 */     PreparedStatement ps = conn.prepareStatement(sql);
/* 16:23 */     ps.setString(1, añoI);
/* 17:24 */     ps.setString(2, añoF);
/* 18:25 */     ResultSet rs = ps.executeQuery();
/* 19:26 */     return rs;
/* 20:   */   }
/* 21:   */ }


/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar
 * Qualified Name:     Desk.graficaDao
 * JD-Core Version:    0.7.0.1
 */