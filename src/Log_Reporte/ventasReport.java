/*  1:   */ package Log_Reporte;
/*  2:   */ 
/*  3:   */ public class ventasReport
/*  4:   */ {
/*  5:   */   String factura;
/*  6:   */   String cliente;
/*  7:   */   String fecha;
/*  8:   */   double igv;
/*  9:   */   double subtotal;
/* 10:   */   double total;
/* 11:   */   
/* 12:   */   public ventasReport() {}
/* 13:   */   
/* 14:   */   public ventasReport(String factura, String cliente, String fecha, double igv, double subtotal, double total)
/* 15:   */   {
/* 16:21 */     this.factura = factura;
/* 17:22 */     this.cliente = cliente;
/* 18:23 */     this.fecha = fecha;
/* 19:24 */     this.igv = igv;
/* 20:25 */     this.subtotal = subtotal;
/* 21:26 */     this.total = total;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public String getFactura()
/* 25:   */   {
/* 26:30 */     return this.factura;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public void setFactura(String factura)
/* 30:   */   {
/* 31:34 */     this.factura = factura;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public String getCliente()
/* 35:   */   {
/* 36:38 */     return this.cliente;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public void setCliente(String cliente)
/* 40:   */   {
/* 41:42 */     this.cliente = cliente;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public String getFecha()
/* 45:   */   {
/* 46:46 */     return this.fecha;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public void setFecha(String fecha)
/* 50:   */   {
/* 51:50 */     this.fecha = fecha;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public double getIgv()
/* 55:   */   {
/* 56:54 */     return this.igv;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void setIgv(double igv)
/* 60:   */   {
/* 61:58 */     this.igv = igv;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public double getSubtotal()
/* 65:   */   {
/* 66:62 */     return this.subtotal;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public void setSubtotal(double subtotal)
/* 70:   */   {
/* 71:66 */     this.subtotal = subtotal;
/* 72:   */   }
/* 73:   */   
/* 74:   */   public double getTotal()
/* 75:   */   {
/* 76:70 */     return this.total;
/* 77:   */   }
/* 78:   */   
/* 79:   */   public void setTotal(double total)
/* 80:   */   {
/* 81:74 */     this.total = total;
/* 82:   */   }
/* 83:   */ }


/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar
 * Qualified Name:     Log_Reporte.ventasReport
 * JD-Core Version:    0.7.0.1
 */