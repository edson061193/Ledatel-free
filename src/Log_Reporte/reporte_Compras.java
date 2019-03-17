/*   1:    */ package Log_Reporte;
/*   2:    */ 
/*   3:    */ public class reporte_Compras
/*   4:    */ {
/*   5:    */   String codigoproducto;
/*   6:    */   String marca;
/*   7:    */   String serie;
/*   8:    */   double preciocompra;
/*   9:    */   double precioventa;
/*  10:    */   int stock;
/*  11:    */   String fecha;
/*  12:    */   String proveedor;
/*  13:    */   String estado;
/*  14:    */   
/*  15:    */   public reporte_Compras(String codigoproducto, String marca, String serio, double preciocompra, double precioventa, int stock, String fechadecompra, String proveedor, String estado)
/*  16:    */   {
/*  17: 20 */     this.codigoproducto = codigoproducto;
/*  18: 21 */     this.marca = marca;
/*  19: 22 */     this.serie = serio;
/*  20: 23 */     this.preciocompra = preciocompra;
/*  21: 24 */     this.precioventa = precioventa;
/*  22: 25 */     this.stock = stock;
/*  23: 26 */     this.fecha = fechadecompra;
/*  24: 27 */     this.proveedor = proveedor;
/*  25: 28 */     this.estado = estado;
/*  26:    */   }
/*  27:    */   
/*  28:    */   public String getCodigoproducto()
/*  29:    */   {
/*  30: 32 */     return this.codigoproducto;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public void setCodigoproducto(String codigoproducto)
/*  34:    */   {
/*  35: 36 */     this.codigoproducto = codigoproducto;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public String getMarca()
/*  39:    */   {
/*  40: 40 */     return this.marca;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public void setMarca(String marca)
/*  44:    */   {
/*  45: 44 */     this.marca = marca;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public String getSerie()
/*  49:    */   {
/*  50: 48 */     return this.serie;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public void setSerie(String serie)
/*  54:    */   {
/*  55: 52 */     this.serie = serie;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public double getPreciocompra()
/*  59:    */   {
/*  60: 58 */     return this.preciocompra;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public void setPreciocompra(double preciocompra)
/*  64:    */   {
/*  65: 62 */     this.preciocompra = preciocompra;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public double getPrecioventa()
/*  69:    */   {
/*  70: 66 */     return this.precioventa;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public void setPrecioventa(double precioventa)
/*  74:    */   {
/*  75: 70 */     this.precioventa = precioventa;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public int getStock()
/*  79:    */   {
/*  80: 74 */     return this.stock;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public void setStock(int stock)
/*  84:    */   {
/*  85: 78 */     this.stock = stock;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public String getFecha()
/*  89:    */   {
/*  90: 82 */     return this.fecha;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public void setFecha(String fecha)
/*  94:    */   {
/*  95: 86 */     this.fecha = fecha;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public String getProveedor()
/*  99:    */   {
/* 100: 92 */     return this.proveedor;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void setProveedor(String proveedor)
/* 104:    */   {
/* 105: 96 */     this.proveedor = proveedor;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public String getEstado()
/* 109:    */   {
/* 110:100 */     return this.estado;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public void setEstado(String estado)
/* 114:    */   {
/* 115:104 */     this.estado = estado;
/* 116:    */   }
/* 117:    */ }


/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar
 * Qualified Name:     Log_Reporte.reporte_Compras
 * JD-Core Version:    0.7.0.1
 */