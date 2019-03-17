/*  1:   */ package Log_Reporte;
/*  2:   */ 
/*  3:   */ public class reporte_cajaReparaciones
/*  4:   */ {
/*  5:   */   String boleta;
/*  6:   */   String tipo;
/*  7:   */   String codigoroducto;
/*  8:   */   String marca;
/*  9:   */   String serie;
/* 10:   */   String observacion;
/* 11:   */   double costo;
/* 12:   */   int cantidad;
/* 13:   */   double importe;
/* 14:   */   
/* 15:   */   public reporte_cajaReparaciones(String factura, String tipo, String codigoroducto, String marca, String serie, String observacion, double costo, int cantidad, double importe)
/* 16:   */   {
/* 17:14 */     this.boleta = factura;
/* 18:15 */     this.tipo = tipo;
/* 19:16 */     this.codigoroducto = codigoroducto;
/* 20:17 */     this.marca = marca;
/* 21:18 */     this.serie = serie;
/* 22:19 */     this.observacion = observacion;
/* 23:20 */     this.costo = costo;
/* 24:21 */     this.cantidad = cantidad;
/* 25:22 */     this.importe = importe;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public String getBoleta()
/* 29:   */   {
/* 30:26 */     return this.boleta;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void setBoleta(String boleta)
/* 34:   */   {
/* 35:30 */     this.boleta = boleta;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public String getTipo()
/* 39:   */   {
/* 40:35 */     return this.tipo;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public void setTipo(String tipo)
/* 44:   */   {
/* 45:39 */     this.tipo = tipo;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public String getCodigoroducto()
/* 49:   */   {
/* 50:43 */     return this.codigoroducto;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public void setCodigoroducto(String codigoroducto)
/* 54:   */   {
/* 55:47 */     this.codigoroducto = codigoroducto;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public String getMarca()
/* 59:   */   {
/* 60:51 */     return this.marca;
/* 61:   */   }
/* 62:   */   
/* 63:   */   public void setMarca(String marca)
/* 64:   */   {
/* 65:55 */     this.marca = marca;
/* 66:   */   }
/* 67:   */   
/* 68:   */   public String getSerie()
/* 69:   */   {
/* 70:59 */     return this.serie;
/* 71:   */   }
/* 72:   */   
/* 73:   */   public void setSerie(String serie)
/* 74:   */   {
/* 75:63 */     this.serie = serie;
/* 76:   */   }
/* 77:   */   
/* 78:   */   public String getObservacion()
/* 79:   */   {
/* 80:67 */     return this.observacion;
/* 81:   */   }
/* 82:   */   
/* 83:   */   public void setObservacion(String observacion)
/* 84:   */   {
/* 85:71 */     this.observacion = observacion;
/* 86:   */   }
/* 87:   */   
/* 88:   */   public double getCosto()
/* 89:   */   {
/* 90:75 */     return this.costo;
/* 91:   */   }
/* 92:   */   
/* 93:   */   public void setCosto(double costo)
/* 94:   */   {
/* 95:79 */     this.costo = costo;
/* 96:   */   }
/* 97:   */   
/* 98:   */   public int getCantidad()
/* 99:   */   {
/* :0:83 */     return this.cantidad;
/* :1:   */   }
/* :2:   */   
/* :3:   */   public void setCantidad(int cantidad)
/* :4:   */   {
/* :5:87 */     this.cantidad = cantidad;
/* :6:   */   }
/* :7:   */   
/* :8:   */   public double getImporte()
/* :9:   */   {
/* ;0:91 */     return this.importe;
/* ;1:   */   }
/* ;2:   */   
/* ;3:   */   public void setImporte(double importe)
/* ;4:   */   {
/* ;5:95 */     this.importe = importe;
/* ;6:   */   }
/* ;7:   */ }


/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar
 * Qualified Name:     Log_Reporte.reporte_cajaReparaciones
 * JD-Core Version:    0.7.0.1
 */