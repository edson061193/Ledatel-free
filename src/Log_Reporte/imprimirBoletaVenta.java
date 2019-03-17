/*  1:   */ package Log_Reporte;
/*  2:   */ 
/*  3:   */ public class imprimirBoletaVenta
/*  4:   */ {
/*  5:   */   int cantidad;
/*  6:   */   String codigo;
/*  7:   */   String observacion;
/*  8:   */   double precioUnitario;
/*  9:   */   double importe;
/* 10:   */   
/* 11:   */   public imprimirBoletaVenta(int cantidad, String codigo, String observacion, double precioUnitario, double importe)
/* 12:   */   {
/* 13:19 */     this.cantidad = cantidad;
/* 14:20 */     this.codigo = codigo;
/* 15:21 */     this.observacion = observacion;
/* 16:22 */     this.precioUnitario = precioUnitario;
/* 17:23 */     this.importe = importe;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public int getCantidad()
/* 21:   */   {
/* 22:27 */     return this.cantidad;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public void setCantidad(int cantidad)
/* 26:   */   {
/* 27:31 */     this.cantidad = cantidad;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public String getCodigo()
/* 31:   */   {
/* 32:35 */     return this.codigo;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public void setCodigo(String codigo)
/* 36:   */   {
/* 37:39 */     this.codigo = codigo;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public String getObservacion()
/* 41:   */   {
/* 42:43 */     return this.observacion;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public void setObservacion(String observacion)
/* 46:   */   {
/* 47:47 */     this.observacion = observacion;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public double getPrecioUnitario()
/* 51:   */   {
/* 52:51 */     return this.precioUnitario;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public void setPrecioUnitario(double precioUnitario)
/* 56:   */   {
/* 57:55 */     this.precioUnitario = precioUnitario;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public double getImporte()
/* 61:   */   {
/* 62:59 */     return this.importe;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public void setImporte(double importe)
/* 66:   */   {
/* 67:63 */     this.importe = importe;
/* 68:   */   }
/* 69:   */ }


/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar
 * Qualified Name:     Log_Reporte.imprimirBoletaVenta
 * JD-Core Version:    0.7.0.1
 */