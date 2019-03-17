/*   1:    */ package Log_Reporte;
/*   2:    */ 
/*   3:    */ public class ventas_vendedorReport
/*   4:    */ {
/*   5:    */   String fecha;
/*   6:    */   String codigofactura;
/*   7:    */   String estado;
/*   8:    */   String codigoproducto;
/*   9:    */   String nombre;
/*  10:    */   String modelo;
/*  11:    */   double precioventa;
/*  12:    */   int cantidad;
/*  13:    */   double importe;
/*  14:    */   String datos;
/*  15:    */   
/*  16:    */   public ventas_vendedorReport(String fecha, String codigofactura, String estado, String codigoproducto, String nombre, String modelo, double precioventa, int cantidad, double importe, String datos)
/*  17:    */   {
/*  18: 21 */     this.fecha = fecha;
/*  19: 22 */     this.codigofactura = codigofactura;
/*  20: 23 */     this.estado = estado;
/*  21: 24 */     this.codigoproducto = codigoproducto;
/*  22: 25 */     this.nombre = nombre;
/*  23: 26 */     this.modelo = modelo;
/*  24: 27 */     this.precioventa = precioventa;
/*  25: 28 */     this.cantidad = cantidad;
/*  26: 29 */     this.importe = importe;
/*  27: 30 */     this.datos = datos;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public String getFecha()
/*  31:    */   {
/*  32: 34 */     return this.fecha;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public void setFecha(String fecha)
/*  36:    */   {
/*  37: 38 */     this.fecha = fecha;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public String getCodigofactura()
/*  41:    */   {
/*  42: 42 */     return this.codigofactura;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void setCodigofactura(String codigofactura)
/*  46:    */   {
/*  47: 46 */     this.codigofactura = codigofactura;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public String getEstado()
/*  51:    */   {
/*  52: 50 */     return this.estado;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public void setEstado(String estado)
/*  56:    */   {
/*  57: 54 */     this.estado = estado;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public String getCodigoproducto()
/*  61:    */   {
/*  62: 58 */     return this.codigoproducto;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public void setCodigoproducto(String codigoproducto)
/*  66:    */   {
/*  67: 62 */     this.codigoproducto = codigoproducto;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public String getNombre()
/*  71:    */   {
/*  72: 66 */     return this.nombre;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void setNombre(String nombre)
/*  76:    */   {
/*  77: 70 */     this.nombre = nombre;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public String getModelo()
/*  81:    */   {
/*  82: 74 */     return this.modelo;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void setModelo(String modelo)
/*  86:    */   {
/*  87: 78 */     this.modelo = modelo;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public double getPrecioventa()
/*  91:    */   {
/*  92: 82 */     return this.precioventa;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setPrecioventa(double precioventa)
/*  96:    */   {
/*  97: 86 */     this.precioventa = precioventa;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public int getCantidad()
/* 101:    */   {
/* 102: 90 */     return this.cantidad;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public void setCantidad(int cantidad)
/* 106:    */   {
/* 107: 94 */     this.cantidad = cantidad;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public double getImporte()
/* 111:    */   {
/* 112: 98 */     return this.importe;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public void setImporte(double importe)
/* 116:    */   {
/* 117:102 */     this.importe = importe;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public String getDatos()
/* 121:    */   {
/* 122:106 */     return this.datos;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public void setDatos(String datos)
/* 126:    */   {
/* 127:110 */     this.datos = datos;
/* 128:    */   }
/* 129:    */ }


/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar
 * Qualified Name:     Log_Reporte.ventas_vendedorReport
 * JD-Core Version:    0.7.0.1
 */