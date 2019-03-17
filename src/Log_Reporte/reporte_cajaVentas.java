/*  1:   */ package Log_Reporte;
/*  2:   */ 
/*  3:   */ public class reporte_cajaVentas
/*  4:   */ {
/*  5:   */   String boleta;
/*  6:   */   String codigo;
/*  7:   */   String marca;
/*  8:   */   String serie;
/*  9:   */   int cantidad;
/* 10:   */   double precio;
/* 11:   */   double importe;
/* 12:   */   String estado;
/* 13:   */   
/* 14:   */   public reporte_cajaVentas() {}
/* 15:   */   
/* 16:   */   public reporte_cajaVentas(String boleta, String codigo, String marca, String serie, int cantidad, double precio, double importe, String estado)
/* 17:   */   {
/* 18:23 */     this.boleta = boleta;
/* 19:24 */     this.codigo = codigo;
/* 20:25 */     this.marca = marca;
/* 21:26 */     this.serie = serie;
/* 22:27 */     this.cantidad = cantidad;
/* 23:28 */     this.precio = precio;
/* 24:29 */     this.importe = importe;
/* 25:30 */     this.estado = estado;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public String getBoleta()
/* 29:   */   {
/* 30:34 */     return this.boleta;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void setBoleta(String boleta)
/* 34:   */   {
/* 35:38 */     this.boleta = boleta;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public String getCodigo()
/* 39:   */   {
/* 40:44 */     return this.codigo;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public void setCodigo(String codigo)
/* 44:   */   {
/* 45:48 */     this.codigo = codigo;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public String getMarca()
/* 49:   */   {
/* 50:52 */     return this.marca;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public void setMarca(String marca)
/* 54:   */   {
/* 55:56 */     this.marca = marca;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public String getSerie()
/* 59:   */   {
/* 60:60 */     return this.serie;
/* 61:   */   }
/* 62:   */   
/* 63:   */   public void setSerie(String serie)
/* 64:   */   {
/* 65:64 */     this.serie = serie;
/* 66:   */   }
/* 67:   */   
/* 68:   */   public int getCantidad()
/* 69:   */   {
/* 70:68 */     return this.cantidad;
/* 71:   */   }
/* 72:   */   
/* 73:   */   public void setCantidad(int cantidad)
/* 74:   */   {
/* 75:72 */     this.cantidad = cantidad;
/* 76:   */   }
/* 77:   */   
/* 78:   */   public double getPrecio()
/* 79:   */   {
/* 80:76 */     return this.precio;
/* 81:   */   }
/* 82:   */   
/* 83:   */   public void setPrecio(double precio)
/* 84:   */   {
/* 85:80 */     this.precio = precio;
/* 86:   */   }
/* 87:   */   
/* 88:   */   public double getImporte()
/* 89:   */   {
/* 90:84 */     return this.importe;
/* 91:   */   }
/* 92:   */   
/* 93:   */   public void setImporte(double importe)
/* 94:   */   {
/* 95:88 */     this.importe = importe;
/* 96:   */   }
/* 97:   */   
/* 98:   */   public String getEstado()
/* 99:   */   {
/* :0:92 */     return this.estado;
/* :1:   */   }
/* :2:   */   
/* :3:   */   public void setEstado(String estado)
/* :4:   */   {
/* :5:96 */     this.estado = estado;
/* :6:   */   }
/* :7:   */ }


/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar
 * Qualified Name:     Log_Reporte.reporte_cajaVentas
 * JD-Core Version:    0.7.0.1
 */