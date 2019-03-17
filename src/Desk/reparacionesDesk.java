/*   1:    */ package Desk;
/*   2:    */ 
/*   3:    */ import Dao.boletaDao;
/*   4:    */ import Dao.clienteDao;
/*   5:    */ import Dao.detalleDao;
/*   6:    */ import Dao.empleadoDao;
/*   7:    */ import Dao.productoDao;
/*   8:    */ import Dao.servicioDao;
/*   9:    */ import Gui.VentanaPrincipalGUI;
/*  10:    */ import Log_Reporte.imprimirBoletaVenta;
/*  11:    */ import To.boleta_TO;
/*  12:    */ import To.cliente_TO;
/*  13:    */ import To.detalleventa_TO;
/*  14:    */ import To.producto_TO;
/*  15:    */ import java.awt.Color;
/*  16:    */ import java.awt.Container;
/*  17:    */ import java.awt.Dimension;
/*  18:    */ import java.awt.Font;
/*  19:    */ import java.awt.event.ActionEvent;
/*  20:    */ import java.awt.event.ActionListener;
/*  21:    */ import java.awt.event.KeyAdapter;
/*  22:    */ import java.awt.event.KeyEvent;
/*  23:    */ import java.io.PrintStream;
/*  24:    */ import java.sql.ResultSet;
/*  25:    */ import java.util.ArrayList;
/*  26:    */ import java.util.Calendar;
/*  27:    */ import java.util.HashMap;
/*  28:    */ import java.util.List;
/*  29:    */ import java.util.Map;
/*  30:    */ import javax.swing.BorderFactory;
/*  31:    */ import javax.swing.DefaultComboBoxModel;
/*  32:    */ import javax.swing.GroupLayout;
/*  33:    */ import javax.swing.GroupLayout.Alignment;
/*  34:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  35:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  36:    */ import javax.swing.ImageIcon;
/*  37:    */ import javax.swing.JButton;
/*  38:    */ import javax.swing.JComboBox;
/*  39:    */ import javax.swing.JDesktopPane;
/*  40:    */ import javax.swing.JInternalFrame;
/*  41:    */ import javax.swing.JLabel;
/*  42:    */ import javax.swing.JOptionPane;
/*  43:    */ import javax.swing.JPanel;
/*  44:    */ import javax.swing.JScrollPane;
/*  45:    */ import javax.swing.JTable;
/*  46:    */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*  47:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  48:    */ import javax.swing.table.DefaultTableModel;
/*  49:    */ import javax.swing.table.TableColumn;
/*  50:    */ import javax.swing.table.TableColumnModel;
/*  51:    */ import net.sf.jasperreports.engine.JasperFillManager;
/*  52:    */ import net.sf.jasperreports.engine.JasperPrint;
/*  53:    */ import net.sf.jasperreports.engine.JasperReport;
/*  54:    */ import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
/*  55:    */ import net.sf.jasperreports.engine.util.JRLoader;
/*  56:    */ import net.sf.jasperreports.view.JasperViewer;
/*  57:    */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*  58:    */ import org.netbeans.lib.awtextra.AbsoluteLayout;
/*  59:    */ 
/*  60:    */ public class reparacionesDesk
/*  61:    */   extends JInternalFrame
/*  62:    */ {
/*  63: 36 */   private static reparacionesDesk fromReparaciones = null;
/*  64:    */   ResultSet rs;
/*  65:    */   
/*  66:    */   public static reparacionesDesk getForm()
/*  67:    */   {
/*  68: 39 */     if (fromReparaciones == null) {
/*  69: 40 */       fromReparaciones = new reparacionesDesk();
/*  70:    */     }
/*  71: 42 */     return fromReparaciones;
/*  72:    */   }
/*  73:    */   
/*  74: 45 */   empleadoDao oEmpleado = new empleadoDao();
/*  75: 46 */   servicioDao oServicio = new servicioDao();
/*  76:    */   DefaultTableModel model;
/*  77: 48 */   double importe = 0.0D;
/*  78:    */   double igv;
/*  79:    */   double subtotal;
/*  80:    */   double total;
/*  81: 50 */   clienteDao oCliente = new clienteDao();
/*  82: 51 */   cliente_TO toCliente = new cliente_TO();
/*  83: 52 */   boletaDao oBoleta = new boletaDao();
/*  84: 53 */   boleta_TO toBoleta = new boleta_TO();
/*  85: 54 */   detalleDao oDetalle = new detalleDao();
/*  86: 55 */   productoDao oProducto = new productoDao();
/*  87:    */   private JButton btnActivar;
/*  88:    */   private JButton btnAdd_Prodc;
/*  89:    */   private JButton btnBuscar;
/*  90:    */   private JButton btnBuscarCliente;
/*  91:    */   private JButton btnImprimir;
/*  92:    */   private JButton btnQuitar_prodc;
/*  93:    */   private JButton btnVender;
/*  94:    */   private JComboBox cboPago;
/*  95:    */   private JLabel jLabel1;
/*  96:    */   private JLabel jLabel10;
/*  97:    */   private JLabel jLabel11;
/*  98:    */   private JLabel jLabel12;
/*  99:    */   private JLabel jLabel13;
/* 100:    */   private JLabel jLabel14;
/* 101:    */   private JLabel jLabel16;
/* 102:    */   private JLabel jLabel17;
/* 103:    */   private JLabel jLabel18;
/* 104:    */   private JLabel jLabel2;
/* 105:    */   private JLabel jLabel3;
/* 106:    */   private JLabel jLabel4;
/* 107:    */   private JLabel jLabel5;
/* 108:    */   private JLabel jLabel6;
/* 109:    */   private JLabel jLabel7;
/* 110:    */   private JLabel jLabel8;
/* 111:    */   private JLabel jLabel9;
/* 112:    */   private JPanel jPanel1;
/* 113:    */   private JPanel jPanel2;
/* 114:    */   private JPanel jPanel3;
/* 115:    */   private JScrollPane jScrollPane1;
/* 116:    */   private JLabel lblFecha;
/* 117:    */   private JTable tblBoleta;
/* 118:    */   private JTextField txtBoleta;
/* 119:    */   public static JTextField txtCantidad;
/* 120:    */   public static JTextField txtDNI;
/* 121:    */   public static JTextField txtDatos;
/* 122:    */   public static JTextField txtDireccion;
/* 123:    */   private JTextField txtIGV;
/* 124:    */   private JTextField txtImporte;
/* 125:    */   public static JTextField txtMarca_modelo;
/* 126:    */   private JTextField txtObservacion;
/* 127:    */   private JTextField txtPago;
/* 128:    */   public static JTextField txtPrecio;
/* 129:    */   private JTextField txtRUC;
/* 130:    */   private JTextField txtSubtotal;
/* 131:    */   private JTextField txtTotal;
/* 132:    */   private JTextField txtVuelto;
/* 133:    */   public static JTextField txtcod_prod;
/* 134:    */   
/* 135:    */   public reparacionesDesk()
/* 136:    */   {
/* 137: 58 */     initComponents();
/* 138: 59 */     muestraCodigoFactura();
/* 139: 60 */     calendario();
/* 140:    */   }
/* 141:    */   
/* 142:    */   private void initComponents()
/* 143:    */   {
/* 144: 67 */     this.jPanel1 = new JPanel();
/* 145: 68 */     this.jLabel1 = new JLabel();
/* 146: 69 */     this.jLabel2 = new JLabel();
/* 147: 70 */     this.jLabel3 = new JLabel();
/* 148: 71 */     this.jLabel4 = new JLabel();
/* 149: 72 */     this.txtImporte = new JTextField();
/* 150: 73 */     txtcod_prod = new JTextField();
/* 151: 74 */     txtMarca_modelo = new JTextField();
/* 152: 75 */     txtPrecio = new JTextField();
/* 153: 76 */     txtCantidad = new JTextField();
/* 154: 77 */     this.btnBuscar = new JButton();
/* 155: 78 */     this.jLabel5 = new JLabel();
/* 156: 79 */     this.jScrollPane1 = new JScrollPane();
/* 157: 80 */     this.tblBoleta = new JTable();
/* 158: 81 */     this.btnAdd_Prodc = new JButton();
/* 159: 82 */     this.btnQuitar_prodc = new JButton();
/* 160: 83 */     this.jPanel3 = new JPanel();
/* 161: 84 */     this.jLabel13 = new JLabel();
/* 162: 85 */     this.jLabel14 = new JLabel();
/* 163: 86 */     this.txtBoleta = new JTextField();
/* 164: 87 */     this.txtRUC = new JTextField();
/* 165: 88 */     this.btnActivar = new JButton();
/* 166: 89 */     this.lblFecha = new JLabel();
/* 167: 90 */     this.jLabel16 = new JLabel();
/* 168: 91 */     this.jLabel17 = new JLabel();
/* 169: 92 */     this.jLabel18 = new JLabel();
/* 170: 93 */     txtDNI = new JTextField();
/* 171: 94 */     txtDatos = new JTextField();
/* 172: 95 */     txtDireccion = new JTextField();
/* 173: 96 */     this.btnBuscarCliente = new JButton();
/* 174: 97 */     this.jPanel2 = new JPanel();
/* 175: 98 */     this.jLabel10 = new JLabel();
/* 176: 99 */     this.jLabel11 = new JLabel();
/* 177:100 */     this.jLabel12 = new JLabel();
/* 178:101 */     this.txtIGV = new JTextField();
/* 179:102 */     this.txtSubtotal = new JTextField();
/* 180:103 */     this.txtTotal = new JTextField();
/* 181:104 */     this.jLabel7 = new JLabel();
/* 182:105 */     this.cboPago = new JComboBox();
/* 183:106 */     this.btnVender = new JButton();
/* 184:107 */     this.btnImprimir = new JButton();
/* 185:108 */     this.jLabel8 = new JLabel();
/* 186:109 */     this.txtPago = new JTextField();
/* 187:110 */     this.jLabel9 = new JLabel();
/* 188:111 */     this.txtVuelto = new JTextField();
/* 189:112 */     this.jLabel6 = new JLabel();
/* 190:113 */     this.txtObservacion = new JTextField();
/* 191:    */     
/* 192:115 */     setClosable(true);
/* 193:116 */     setIconifiable(true);
/* 194:117 */     setMaximizable(true);
/* 195:118 */     setTitle("Boleta de ventas");
/* 196:119 */     setMinimumSize(new Dimension(1350, 620));
/* 197:120 */     setPreferredSize(new Dimension(1350, 620));
/* 198:    */     
/* 199:122 */     this.jPanel1.setBackground(new Color(102, 102, 102));
/* 200:123 */     this.jPanel1.setLayout(new AbsoluteLayout());
/* 201:    */     
/* 202:125 */     this.jLabel1.setForeground(new Color(255, 255, 255));
/* 203:126 */     this.jLabel1.setText("CÓDIGO PRODUCTO:");
/* 204:127 */     this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(237, 150, -1, -1));
/* 205:    */     
/* 206:129 */     this.jLabel2.setFont(new Font("Bookman Old Style", 0, 14));
/* 207:130 */     this.jLabel2.setForeground(new Color(255, 255, 255));
/* 208:131 */     this.jLabel2.setText("MARCA/SERIE :");
/* 209:132 */     this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(250, 180, -1, -1));
/* 210:    */     
/* 211:134 */     this.jLabel3.setFont(new Font("Bookman Old Style", 0, 14));
/* 212:135 */     this.jLabel3.setForeground(new Color(255, 255, 255));
/* 213:136 */     this.jLabel3.setText("PRECIO UNITARIO:");
/* 214:137 */     this.jPanel1.add(this.jLabel3, new AbsoluteConstraints(230, 220, -1, -1));
/* 215:    */     
/* 216:139 */     this.jLabel4.setFont(new Font("Bookman Old Style", 0, 14));
/* 217:140 */     this.jLabel4.setForeground(new Color(255, 255, 255));
/* 218:141 */     this.jLabel4.setText("CANTIDAD:");
/* 219:142 */     this.jPanel1.add(this.jLabel4, new AbsoluteConstraints(280, 250, -1, -1));
/* 220:    */     
/* 221:144 */     this.txtImporte.setEditable(false);
/* 222:145 */     this.txtImporte.setFont(new Font("sansserif", 1, 36));
/* 223:146 */     this.txtImporte.setForeground(new Color(0, 0, 51));
/* 224:147 */     this.txtImporte.setHorizontalAlignment(0);
/* 225:148 */     this.txtImporte.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2), "Importe a pagar :  S/.", 2, 2));
/* 226:149 */     this.jPanel1.add(this.txtImporte, new AbsoluteConstraints(610, 150, 195, 130));
/* 227:    */     
/* 228:151 */     txtcod_prod.setHorizontalAlignment(0);
/* 229:152 */     txtcod_prod.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 230:153 */     this.jPanel1.add(txtcod_prod, new AbsoluteConstraints(371, 148, 202, -1));
/* 231:    */     
/* 232:155 */     txtMarca_modelo.setHorizontalAlignment(0);
/* 233:156 */     txtMarca_modelo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2)));
/* 234:157 */     this.jPanel1.add(txtMarca_modelo, new AbsoluteConstraints(371, 180, 202, -1));
/* 235:    */     
/* 236:159 */     txtPrecio.setHorizontalAlignment(0);
/* 237:160 */     txtPrecio.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 238:161 */     this.jPanel1.add(txtPrecio, new AbsoluteConstraints(370, 220, 200, -1));
/* 239:    */     
/* 240:163 */     txtCantidad.setHorizontalAlignment(0);
/* 241:164 */     txtCantidad.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 242:165 */     txtCantidad.addKeyListener(new KeyAdapter()
/* 243:    */     {
/* 244:    */       public void keyReleased(KeyEvent evt)
/* 245:    */       {
/* 246:167 */         reparacionesDesk.this.txtCantidadKeyReleased(evt);
/* 247:    */       }
/* 248:    */       
/* 249:    */       public void keyTyped(KeyEvent evt)
/* 250:    */       {
/* 251:170 */         reparacionesDesk.this.txtCantidadKeyTyped(evt);
/* 252:    */       }
/* 253:172 */     });
/* 254:173 */     this.jPanel1.add(txtCantidad, new AbsoluteConstraints(370, 250, 200, -1));
/* 255:    */     
/* 256:175 */     this.btnBuscar.setBackground(new Color(153, 204, 255));
/* 257:176 */     this.btnBuscar.setFont(new Font("sansserif", 1, 14));
/* 258:177 */     this.btnBuscar.setText("BUSCAR  PRODUCTO");
/* 259:178 */     this.btnBuscar.setBorder(null);
/* 260:179 */     this.btnBuscar.addActionListener(new ActionListener()
/* 261:    */     {
/* 262:    */       public void actionPerformed(ActionEvent evt)
/* 263:    */       {
/* 264:181 */         reparacionesDesk.this.btnBuscarActionPerformed(evt);
/* 265:    */       }
/* 266:183 */     });
/* 267:184 */     this.jPanel1.add(this.btnBuscar, new AbsoluteConstraints(820, 150, 190, 57));
/* 268:    */     
/* 269:186 */     this.jLabel5.setFont(new Font("sansserif", 1, 14));
/* 270:187 */     this.jLabel5.setForeground(new Color(255, 0, 0));
/* 271:188 */     this.jLabel5.setHorizontalAlignment(0);
/* 272:189 */     this.jLabel5.setText("LISTA DE PRODUCTOS EN UTILIDADES ");
/* 273:190 */     this.jPanel1.add(this.jLabel5, new AbsoluteConstraints(100, 330, 300, -1));
/* 274:    */     
/* 275:192 */     this.tblBoleta.setModel(new DefaultTableModel(new Object[0][], new String[] { "Cant.", "codigo", "observación", "precio unit.", "importe" })
/* 276:    */     {
/* 277:200 */       boolean[] canEdit = { false, false, false, false, false };
/* 278:    */       
/* 279:    */       public boolean isCellEditable(int rowIndex, int columnIndex)
/* 280:    */       {
/* 281:205 */         return this.canEdit[columnIndex];
/* 282:    */       }
/* 283:207 */     });
/* 284:208 */     this.jScrollPane1.setViewportView(this.tblBoleta);
/* 285:209 */     if (this.tblBoleta.getColumnModel().getColumnCount() > 0)
/* 286:    */     {
/* 287:210 */       this.tblBoleta.getColumnModel().getColumn(0).setMinWidth(50);
/* 288:211 */       this.tblBoleta.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 289:212 */       this.tblBoleta.getColumnModel().getColumn(0).setMaxWidth(50);
/* 290:213 */       this.tblBoleta.getColumnModel().getColumn(1).setMinWidth(70);
/* 291:214 */       this.tblBoleta.getColumnModel().getColumn(1).setPreferredWidth(70);
/* 292:215 */       this.tblBoleta.getColumnModel().getColumn(1).setMaxWidth(70);
/* 293:216 */       this.tblBoleta.getColumnModel().getColumn(3).setMinWidth(80);
/* 294:217 */       this.tblBoleta.getColumnModel().getColumn(3).setPreferredWidth(80);
/* 295:218 */       this.tblBoleta.getColumnModel().getColumn(3).setMaxWidth(80);
/* 296:219 */       this.tblBoleta.getColumnModel().getColumn(4).setMinWidth(60);
/* 297:220 */       this.tblBoleta.getColumnModel().getColumn(4).setPreferredWidth(60);
/* 298:221 */       this.tblBoleta.getColumnModel().getColumn(4).setMaxWidth(60);
/* 299:    */     }
/* 300:224 */     this.jPanel1.add(this.jScrollPane1, new AbsoluteConstraints(100, 350, 900, 170));
/* 301:    */     
/* 302:226 */     this.btnAdd_Prodc.setBackground(new Color(0, 51, 51));
/* 303:227 */     this.btnAdd_Prodc.setFont(new Font("sansserif", 1, 14));
/* 304:228 */     this.btnAdd_Prodc.setText("AGREGAR");
/* 305:229 */     this.btnAdd_Prodc.setBorder(null);
/* 306:230 */     this.btnAdd_Prodc.addActionListener(new ActionListener()
/* 307:    */     {
/* 308:    */       public void actionPerformed(ActionEvent evt)
/* 309:    */       {
/* 310:232 */         reparacionesDesk.this.btnAdd_ProdcActionPerformed(evt);
/* 311:    */       }
/* 312:234 */     });
/* 313:235 */     this.jPanel1.add(this.btnAdd_Prodc, new AbsoluteConstraints(820, 220, 100, 40));
/* 314:    */     
/* 315:237 */     this.btnQuitar_prodc.setBackground(new Color(0, 51, 51));
/* 316:238 */     this.btnQuitar_prodc.setFont(new Font("sansserif", 1, 14));
/* 317:239 */     this.btnQuitar_prodc.setText("QUITAR");
/* 318:240 */     this.btnQuitar_prodc.setBorder(null);
/* 319:241 */     this.btnQuitar_prodc.addActionListener(new ActionListener()
/* 320:    */     {
/* 321:    */       public void actionPerformed(ActionEvent evt)
/* 322:    */       {
/* 323:243 */         reparacionesDesk.this.btnQuitar_prodcActionPerformed(evt);
/* 324:    */       }
/* 325:245 */     });
/* 326:246 */     this.jPanel1.add(this.btnQuitar_prodc, new AbsoluteConstraints(920, 220, 90, 40));
/* 327:    */     
/* 328:248 */     this.jPanel3.setBackground(new Color(0, 0, 0));
/* 329:    */     
/* 330:250 */     this.jLabel13.setFont(new Font("sansserif", 1, 14));
/* 331:251 */     this.jLabel13.setForeground(new Color(255, 255, 255));
/* 332:252 */     this.jLabel13.setText("R.U.C :");
/* 333:    */     
/* 334:254 */     this.jLabel14.setFont(new Font("sansserif", 1, 14));
/* 335:255 */     this.jLabel14.setForeground(new Color(255, 255, 255));
/* 336:256 */     this.jLabel14.setText("N° BOLETA:");
/* 337:    */     
/* 338:258 */     this.txtBoleta.setEditable(false);
/* 339:259 */     this.txtBoleta.setFont(new Font("sansserif", 1, 14));
/* 340:260 */     this.txtBoleta.setForeground(new Color(255, 0, 0));
/* 341:261 */     this.txtBoleta.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
/* 342:    */     
/* 343:263 */     this.txtRUC.setEditable(false);
/* 344:264 */     this.txtRUC.setFont(new Font("sansserif", 1, 14));
/* 345:265 */     this.txtRUC.setForeground(new Color(0, 0, 204));
/* 346:266 */     this.txtRUC.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
/* 347:    */     
/* 348:268 */     this.btnActivar.setBackground(new Color(153, 204, 255));
/* 349:269 */     this.btnActivar.setFont(new Font("sansserif", 1, 14));
/* 350:270 */     this.btnActivar.setIcon(new ImageIcon(getClass().getResource("/icon/application-pgp-signature.png")));
/* 351:271 */     this.btnActivar.setText("A C T I V A R");
/* 352:272 */     this.btnActivar.addActionListener(new ActionListener()
/* 353:    */     {
/* 354:    */       public void actionPerformed(ActionEvent evt)
/* 355:    */       {
/* 356:274 */         reparacionesDesk.this.btnActivarActionPerformed(evt);
/* 357:    */       }
/* 358:277 */     });
/* 359:278 */     this.lblFecha.setFont(new Font("sansserif", 1, 20));
/* 360:279 */     this.lblFecha.setForeground(new Color(255, 255, 255));
/* 361:280 */     this.lblFecha.setHorizontalAlignment(0);
/* 362:281 */     this.lblFecha.setText("dd/mm/aa");
/* 363:282 */     this.lblFecha.setBorder(BorderFactory.createLineBorder(new Color(153, 255, 0)));
/* 364:    */     
/* 365:284 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 366:285 */     this.jPanel3.setLayout(jPanel3Layout);
/* 367:286 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(39, 39, 39).addComponent(this.jLabel13).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtRUC, -2, 226, -2).addGap(84, 84, 84).addComponent(this.jLabel14).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtBoleta, -2, 226, -2).addGap(33, 33, 33).addComponent(this.btnActivar, -2, 163, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 274, 32767).addComponent(this.lblFecha, -2, 152, -2).addContainerGap()));
/* 368:    */     
/* 369:    */ 
/* 370:    */ 
/* 371:    */ 
/* 372:    */ 
/* 373:    */ 
/* 374:    */ 
/* 375:    */ 
/* 376:    */ 
/* 377:    */ 
/* 378:    */ 
/* 379:    */ 
/* 380:    */ 
/* 381:    */ 
/* 382:    */ 
/* 383:    */ 
/* 384:303 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel13).addComponent(this.jLabel14)).addComponent(this.btnActivar, -2, 47, -2)).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtRUC, -2, -1, -2).addComponent(this.txtBoleta, -2, -1, -2)).addGap(15, 15, 15)).addComponent(this.lblFecha, -1, -1, 32767));
/* 385:    */     
/* 386:    */ 
/* 387:    */ 
/* 388:    */ 
/* 389:    */ 
/* 390:    */ 
/* 391:    */ 
/* 392:    */ 
/* 393:    */ 
/* 394:    */ 
/* 395:    */ 
/* 396:    */ 
/* 397:    */ 
/* 398:    */ 
/* 399:    */ 
/* 400:    */ 
/* 401:    */ 
/* 402:    */ 
/* 403:322 */     this.jPanel1.add(this.jPanel3, new AbsoluteConstraints(0, 0, 1340, -1));
/* 404:    */     
/* 405:324 */     this.jLabel16.setFont(new Font("sansserif", 1, 12));
/* 406:325 */     this.jLabel16.setForeground(new Color(255, 255, 255));
/* 407:326 */     this.jLabel16.setText("D N I   C L I E N T E :");
/* 408:327 */     this.jPanel1.add(this.jLabel16, new AbsoluteConstraints(101, 90, -1, -1));
/* 409:    */     
/* 410:329 */     this.jLabel17.setFont(new Font("sansserif", 1, 12));
/* 411:330 */     this.jLabel17.setForeground(new Color(255, 255, 255));
/* 412:331 */     this.jLabel17.setText("D A T O S :");
/* 413:332 */     this.jPanel1.add(this.jLabel17, new AbsoluteConstraints(411, 90, -1, -1));
/* 414:    */     
/* 415:334 */     this.jLabel18.setFont(new Font("sansserif", 1, 12));
/* 416:335 */     this.jLabel18.setForeground(new Color(255, 255, 255));
/* 417:336 */     this.jLabel18.setText("D I R E C C I Ó N :");
/* 418:337 */     this.jPanel1.add(this.jLabel18, new AbsoluteConstraints(758, 90, -1, -1));
/* 419:    */     
/* 420:339 */     txtDNI.setFont(new Font("sansserif", 0, 14));
/* 421:340 */     txtDNI.setHorizontalAlignment(0);
/* 422:341 */     txtDNI.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
/* 423:342 */     txtDNI.addKeyListener(new KeyAdapter()
/* 424:    */     {
/* 425:    */       public void keyTyped(KeyEvent evt)
/* 426:    */       {
/* 427:344 */         reparacionesDesk.this.txtDNIKeyTyped(evt);
/* 428:    */       }
/* 429:346 */     });
/* 430:347 */     this.jPanel1.add(txtDNI, new AbsoluteConstraints(212, 87, 154, -1));
/* 431:    */     
/* 432:349 */     txtDatos.setFont(new Font("sansserif", 0, 14));
/* 433:350 */     txtDatos.setHorizontalAlignment(0);
/* 434:351 */     txtDatos.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
/* 435:352 */     this.jPanel1.add(txtDatos, new AbsoluteConstraints(487, 87, 186, -1));
/* 436:    */     
/* 437:354 */     txtDireccion.setFont(new Font("sansserif", 0, 14));
/* 438:355 */     txtDireccion.setHorizontalAlignment(0);
/* 439:356 */     txtDireccion.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
/* 440:357 */     this.jPanel1.add(txtDireccion, new AbsoluteConstraints(876, 87, 227, -1));
/* 441:    */     
/* 442:359 */     this.btnBuscarCliente.setBackground(new Color(153, 204, 255));
/* 443:360 */     this.btnBuscarCliente.setFont(new Font("sansserif", 1, 14));
/* 444:361 */     this.btnBuscarCliente.setText("BUSCAR / A D D  CLIENTE");
/* 445:362 */     this.btnBuscarCliente.addActionListener(new ActionListener()
/* 446:    */     {
/* 447:    */       public void actionPerformed(ActionEvent evt)
/* 448:    */       {
/* 449:364 */         reparacionesDesk.this.btnBuscarClienteActionPerformed(evt);
/* 450:    */       }
/* 451:366 */     });
/* 452:367 */     this.jPanel1.add(this.btnBuscarCliente, new AbsoluteConstraints(1130, 80, 208, -1));
/* 453:    */     
/* 454:369 */     this.jPanel2.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
/* 455:370 */     this.jPanel2.setOpaque(false);
/* 456:    */     
/* 457:372 */     this.jLabel10.setText("IGV");
/* 458:    */     
/* 459:374 */     this.jLabel11.setText("Subtotal");
/* 460:    */     
/* 461:376 */     this.jLabel12.setText("Total");
/* 462:    */     
/* 463:378 */     this.txtIGV.setHorizontalAlignment(0);
/* 464:379 */     this.txtIGV.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 465:    */     
/* 466:381 */     this.txtSubtotal.setHorizontalAlignment(0);
/* 467:382 */     this.txtSubtotal.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 468:    */     
/* 469:384 */     this.txtTotal.setHorizontalAlignment(0);
/* 470:385 */     this.txtTotal.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 471:    */     
/* 472:387 */     this.jLabel7.setText("Tipo de Pago:");
/* 473:    */     
/* 474:389 */     this.cboPago.setBackground(new Color(51, 51, 51));
/* 475:390 */     this.cboPago.setModel(new DefaultComboBoxModel(new String[] { "EFECTIVO", "CREDITO", "TARGETA" }));
/* 476:    */     
/* 477:392 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 478:393 */     this.jPanel2.setLayout(jPanel2Layout);
/* 479:394 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel7).addGap(87, 87, 87).addComponent(this.jLabel12, -2, 37, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.cboPago, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel11)).addComponent(this.jLabel10, GroupLayout.Alignment.TRAILING)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.txtTotal, -2, 96, -2)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.txtSubtotal, -2, 97, -2).addGap(0, 1, 32767))).addContainerGap(12, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.txtIGV, -2, 97, -2).addContainerGap(-1, 32767)))));
/* 480:    */     
/* 481:    */ 
/* 482:    */ 
/* 483:    */ 
/* 484:    */ 
/* 485:    */ 
/* 486:    */ 
/* 487:    */ 
/* 488:    */ 
/* 489:    */ 
/* 490:    */ 
/* 491:    */ 
/* 492:    */ 
/* 493:    */ 
/* 494:    */ 
/* 495:    */ 
/* 496:    */ 
/* 497:    */ 
/* 498:    */ 
/* 499:    */ 
/* 500:    */ 
/* 501:    */ 
/* 502:    */ 
/* 503:    */ 
/* 504:    */ 
/* 505:    */ 
/* 506:    */ 
/* 507:    */ 
/* 508:423 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel12).addComponent(this.jLabel7)).addComponent(this.txtTotal, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel11).addComponent(this.txtSubtotal, -2, -1, -2).addComponent(this.cboPago, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel10).addComponent(this.txtIGV, -2, -1, -2)).addContainerGap(-1, 32767)));
/* 509:    */     
/* 510:    */ 
/* 511:    */ 
/* 512:    */ 
/* 513:    */ 
/* 514:    */ 
/* 515:    */ 
/* 516:    */ 
/* 517:    */ 
/* 518:    */ 
/* 519:    */ 
/* 520:    */ 
/* 521:    */ 
/* 522:    */ 
/* 523:    */ 
/* 524:    */ 
/* 525:    */ 
/* 526:    */ 
/* 527:    */ 
/* 528:    */ 
/* 529:444 */     this.jPanel1.add(this.jPanel2, new AbsoluteConstraints(1010, 360, -1, -1));
/* 530:    */     
/* 531:446 */     this.btnVender.setBackground(new Color(153, 204, 255));
/* 532:447 */     this.btnVender.setIcon(new ImageIcon(getClass().getResource("/icon/basic3-017_invoice_bill-32.png")));
/* 533:448 */     this.btnVender.setText("Vender");
/* 534:449 */     this.btnVender.addActionListener(new ActionListener()
/* 535:    */     {
/* 536:    */       public void actionPerformed(ActionEvent evt)
/* 537:    */       {
/* 538:451 */         reparacionesDesk.this.btnVenderActionPerformed(evt);
/* 539:    */       }
/* 540:453 */     });
/* 541:454 */     this.jPanel1.add(this.btnVender, new AbsoluteConstraints(1010, 470, 170, 63));
/* 542:    */     
/* 543:456 */     this.btnImprimir.setBackground(new Color(153, 204, 255));
/* 544:457 */     this.btnImprimir.setIcon(new ImageIcon(getClass().getResource("/icon/print-32.png")));
/* 545:458 */     this.btnImprimir.setText("Imprimir");
/* 546:459 */     this.btnImprimir.addActionListener(new ActionListener()
/* 547:    */     {
/* 548:    */       public void actionPerformed(ActionEvent evt)
/* 549:    */       {
/* 550:461 */         reparacionesDesk.this.btnImprimirActionPerformed(evt);
/* 551:    */       }
/* 552:463 */     });
/* 553:464 */     this.jPanel1.add(this.btnImprimir, new AbsoluteConstraints(1200, 470, 140, 60));
/* 554:    */     
/* 555:466 */     this.jLabel8.setBackground(new Color(255, 204, 102));
/* 556:467 */     this.jLabel8.setHorizontalAlignment(0);
/* 557:468 */     this.jLabel8.setText("Pago con S/. ");
/* 558:469 */     this.jPanel1.add(this.jLabel8, new AbsoluteConstraints(110, 530, 123, -1));
/* 559:    */     
/* 560:471 */     this.txtPago.setFont(new Font("sansserif", 1, 14));
/* 561:472 */     this.txtPago.setForeground(new Color(51, 153, 0));
/* 562:473 */     this.txtPago.setHorizontalAlignment(0);
/* 563:474 */     this.txtPago.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 564:475 */     this.txtPago.addKeyListener(new KeyAdapter()
/* 565:    */     {
/* 566:    */       public void keyReleased(KeyEvent evt)
/* 567:    */       {
/* 568:477 */         reparacionesDesk.this.txtPagoKeyReleased(evt);
/* 569:    */       }
/* 570:479 */     });
/* 571:480 */     this.jPanel1.add(this.txtPago, new AbsoluteConstraints(120, 550, 123, -1));
/* 572:    */     
/* 573:482 */     this.jLabel9.setBackground(new Color(255, 204, 102));
/* 574:483 */     this.jLabel9.setHorizontalAlignment(0);
/* 575:484 */     this.jLabel9.setText("Cambio (vuelto) S/.");
/* 576:485 */     this.jPanel1.add(this.jLabel9, new AbsoluteConstraints(320, 530, 123, -1));
/* 577:    */     
/* 578:487 */     this.txtVuelto.setFont(new Font("sansserif", 1, 14));
/* 579:488 */     this.txtVuelto.setForeground(new Color(51, 153, 0));
/* 580:489 */     this.txtVuelto.setHorizontalAlignment(0);
/* 581:490 */     this.txtVuelto.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 582:491 */     this.jPanel1.add(this.txtVuelto, new AbsoluteConstraints(310, 550, 167, -1));
/* 583:    */     
/* 584:493 */     this.jLabel6.setText("OBSERVACION:");
/* 585:494 */     this.jPanel1.add(this.jLabel6, new AbsoluteConstraints(610, 300, -1, -1));
/* 586:    */     
/* 587:496 */     this.txtObservacion.setFont(new Font("sansserif", 0, 14));
/* 588:497 */     this.txtObservacion.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 589:498 */     this.jPanel1.add(this.txtObservacion, new AbsoluteConstraints(730, 300, 290, -1));
/* 590:    */     
/* 591:500 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 592:501 */     getContentPane().setLayout(layout);
/* 593:502 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(0, 0, 32767)));
/* 594:    */     
/* 595:    */ 
/* 596:    */ 
/* 597:    */ 
/* 598:    */ 
/* 599:508 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
/* 600:    */     
/* 601:    */ 
/* 602:    */ 
/* 603:    */ 
/* 604:    */ 
/* 605:    */ 
/* 606:    */ 
/* 607:516 */     pack();
/* 608:    */   }
/* 609:    */   
/* 610:    */   private void btnActivarActionPerformed(ActionEvent evt)
/* 611:    */   {
/* 612:520 */     String val = VentanaPrincipalGUI.lblEmpleado.getText();
/* 613:521 */     if (val.equals("|ADMINISTRADOR|"))
/* 614:    */     {
/* 615:522 */       this.txtRUC.setEditable(true);
/* 616:523 */       this.txtBoleta.setEditable(true);
/* 617:524 */       this.txtRUC.grabFocus();
/* 618:525 */       this.btnActivar.setEnabled(false);
/* 619:    */     }
/* 620:    */   }
/* 621:    */   
/* 622:    */   private void btnBuscarActionPerformed(ActionEvent evt)
/* 623:    */   {
/* 624:530 */     productoDesk GUI = new productoDesk();
/* 625:531 */     VentanaPrincipalGUI.desk.add(GUI);
/* 626:532 */     GUI.show();
/* 627:    */   }
/* 628:    */   
/* 629:    */   private void txtCantidadKeyReleased(KeyEvent evt)
/* 630:    */   {
/* 631:536 */     int cantidad = Integer.parseInt(txtCantidad.getText());
/* 632:537 */     double precio = Double.parseDouble(txtPrecio.getText());
/* 633:538 */     double importe = cantidad * precio;
/* 634:539 */     this.txtImporte.setText(String.valueOf(importe));
/* 635:    */   }
/* 636:    */   
/* 637:    */   private void btnAdd_ProdcActionPerformed(ActionEvent evt)
/* 638:    */   {
/* 639:    */     try
/* 640:    */     {
/* 641:544 */       this.model = ((DefaultTableModel)this.tblBoleta.getModel());
/* 642:545 */       this.importe = Double.parseDouble(this.txtImporte.getText());
/* 643:546 */       int filas = this.tblBoleta.getRowCount();
/* 644:547 */       for (int i = 0; i < filas; i++) {
/* 645:548 */         if (txtcod_prod.getText().equalsIgnoreCase(this.tblBoleta.getValueAt(i, 1).toString()))
/* 646:    */         {
/* 647:549 */           JOptionPane.showMessageDialog(this.rootPane, "Ud. ya Esta Utilizando este Producto");
/* 648:550 */           this.model.removeRow(this.tblBoleta.getSelectedRow());
/* 649:551 */           limpiaControles();
/* 650:    */         }
/* 651:    */       }
/* 652:554 */       if (this.importe > 0.0D)
/* 653:    */       {
/* 654:555 */         Object[] registros = { txtCantidad.getText(), txtcod_prod.getText(), this.txtObservacion.getText() + "(" + txtMarca_modelo.getText() + ")", txtPrecio.getText(), Double.valueOf(this.importe) };
/* 655:    */         
/* 656:    */ 
/* 657:558 */         this.model.addRow(registros);
/* 658:559 */         calcularTotales();
/* 659:    */       }
/* 660:561 */       txtMarca_modelo.setText("");
/* 661:562 */       txtPrecio.setText("0.0");
/* 662:563 */       txtCantidad.setText("");
/* 663:564 */       this.txtImporte.setText("0.0");
/* 664:565 */       this.txtObservacion.setText("");
/* 665:    */     }
/* 666:    */     catch (Exception e)
/* 667:    */     {
/* 668:567 */       System.out.println(e.getMessage());
/* 669:    */     }
/* 670:    */   }
/* 671:    */   
/* 672:    */   private void btnQuitar_prodcActionPerformed(ActionEvent evt)
/* 673:    */   {
/* 674:572 */     this.model.removeRow(this.tblBoleta.getSelectedRow());
/* 675:573 */     calcularTotales();
/* 676:    */   }
/* 677:    */   
/* 678:    */   private void txtPagoKeyReleased(KeyEvent evt)
/* 679:    */   {
/* 680:578 */     double pago = Double.parseDouble(this.txtPago.getText());
/* 681:579 */     double cambio = pago - this.total;
/* 682:580 */     this.txtVuelto.setText(String.valueOf(cambio));
/* 683:    */   }
/* 684:    */   
/* 685:    */   private void btnVenderActionPerformed(ActionEvent evt)
/* 686:    */   {
/* 687:    */     try
/* 688:    */     {
/* 689:586 */       String codigoCliente = "";
/* 690:587 */       String codigoEmpleado = "";
/* 691:588 */       this.rs = this.oBoleta.obteneriIDcliente();
/* 692:589 */       while (this.rs.next()) {
/* 693:590 */         if (txtDNI.getText().equals(this.rs.getString(2))) {
/* 694:591 */           codigoCliente = this.rs.getString(1);
/* 695:    */         }
/* 696:    */       }
/* 697:595 */       String codEmple = VentanaPrincipalGUI.lblEmpleado.getText();
/* 698:596 */       this.rs = this.oEmpleado.cargaEmpleado();
/* 699:597 */       while (this.rs.next())
/* 700:    */       {
/* 701:598 */         if (VentanaPrincipalGUI.lblEmpleado.getText().equals(this.rs.getString(2) + " " + this.rs.getString(3)))
/* 702:    */         {
/* 703:599 */           codigoEmpleado = this.rs.getString(1);
/* 704:600 */           System.out.println(codigoEmpleado);
/* 705:    */         }
/* 706:602 */         if (codEmple.equals("|ADMINISTRADOR|")) {
/* 707:603 */           codigoEmpleado = "100000";
/* 708:    */         }
/* 709:    */       }
/* 710:607 */       this.toBoleta.setCodigoFactura(this.txtBoleta.getText());
/* 711:608 */       this.toBoleta.setRuc(this.txtRUC.getText());
/* 712:609 */       this.toBoleta.setIgv(this.igv);
/* 713:610 */       this.toBoleta.setSubtotal(this.subtotal);
/* 714:611 */       this.toBoleta.setTotal(this.total);
/* 715:612 */       this.toBoleta.setTipoDepago(this.cboPago.getSelectedItem().toString());
/* 716:613 */       this.toBoleta.setEstado("VENTA R REALIZADA");
/* 717:614 */       this.toBoleta.setCodEmpleado(codigoEmpleado);
/* 718:615 */       this.toBoleta.setCodigoCliente(codigoCliente);
/* 719:616 */       this.oBoleta.grabarFacturaVentas(this.toBoleta);
/* 720:617 */       System.out.println("Factura registrada");
/* 721:618 */       producto_TO toProducto = new producto_TO();
/* 722:    */       try
/* 723:    */       {
/* 724:623 */         String observacion = "";
/* 725:624 */         String costo = "";
/* 726:625 */         String pro = "";
/* 727:    */         
/* 728:627 */         int filaP = this.tblBoleta.getRowCount();
/* 729:628 */         for (int i = 0; i < filaP; i++)
/* 730:    */         {
/* 731:629 */           observacion = this.tblBoleta.getValueAt(i, 2).toString();
/* 732:630 */           costo = this.tblBoleta.getValueAt(i, 4).toString();
/* 733:631 */           this.rs = this.oProducto.obternerCodigo();
/* 734:632 */           while (this.rs.next()) {
/* 735:633 */             if (this.rs.getString(2).equals(this.tblBoleta.getValueAt(i, 1))) {
/* 736:634 */               pro = this.rs.getString(1);
/* 737:    */             }
/* 738:    */           }
/* 739:637 */           this.oDetalle.grabarDetalle_SERVICIOS(observacion, costo, pro);
/* 740:    */         }
/* 741:    */       }
/* 742:    */       catch (Exception e)
/* 743:    */       {
/* 744:641 */         System.out.println(e + " en servic");
/* 745:    */       }
/* 746:644 */       String idFactura = this.oBoleta.obteneriIDfactura();
/* 747:645 */       int filas = this.tblBoleta.getRowCount();
/* 748:647 */       for (int i = 0; i < filas; i++)
/* 749:    */       {
/* 750:648 */         detalleventa_TO to = new detalleventa_TO();
/* 751:649 */         to.setCodfactura(idFactura);
/* 752:    */         
/* 753:651 */         this.rs = this.oServicio.obtenerCodServc();
/* 754:652 */         while (this.rs.next()) {
/* 755:653 */           if (this.tblBoleta.getValueAt(i, 2).equals(this.rs.getString(2)))
/* 756:    */           {
/* 757:654 */             to.setCodServ(this.rs.getString(1));
/* 758:655 */             System.out.println(this.rs.getString(1));
/* 759:    */           }
/* 760:    */         }
/* 761:659 */         to.setPrecio(Double.parseDouble(this.tblBoleta.getValueAt(i, 3).toString()));
/* 762:660 */         to.setCantidad(Integer.parseInt(this.tblBoleta.getValueAt(i, 0).toString()));
/* 763:661 */         to.setImporte(Double.parseDouble(this.tblBoleta.getValueAt(i, 4).toString()));
/* 764:662 */         this.oDetalle.grabarDetalle_serv(to);
/* 765:    */         
/* 766:    */ 
/* 767:665 */         this.rs = this.oProducto.obternerCodigo();
/* 768:666 */         while (this.rs.next()) {
/* 769:667 */           if (this.rs.getString(2).equals(this.tblBoleta.getValueAt(i, 1))) {
/* 770:668 */             to.setCodproducto(this.rs.getString(1));
/* 771:    */           }
/* 772:    */         }
/* 773:672 */         int cantidadventa = Integer.parseInt(this.tblBoleta.getValueAt(i, 0).toString());
/* 774:673 */         toProducto.setCodigoProd(this.tblBoleta.getValueAt(i, 1).toString());
/* 775:674 */         this.oProducto.reduceProducto(cantidadventa, toProducto);
/* 776:    */       }
/* 777:677 */       JOptionPane.showMessageDialog(this.rootPane, "Venta registrada Correctamente   C:");
/* 778:678 */       muestraCodigoFactura();
/* 779:679 */       limpiacontroles();
/* 780:    */     }
/* 781:    */     catch (Exception e)
/* 782:    */     {
/* 783:681 */       System.out.println(e.getMessage() + "try c");
/* 784:    */     }
/* 785:    */   }
/* 786:    */   
/* 787:    */   private void txtCantidadKeyTyped(KeyEvent evt)
/* 788:    */   {
/* 789:686 */     char c = evt.getKeyChar();
/* 790:687 */     if ((c < '0') || (c > '9')) {
/* 791:688 */       evt.consume();
/* 792:    */     }
/* 793:    */   }
/* 794:    */   
/* 795:    */   private void txtDNIKeyTyped(KeyEvent evt)
/* 796:    */   {
/* 797:693 */     char c = evt.getKeyChar();
/* 798:694 */     if ((c < '0') || (c > '9')) {
/* 799:695 */       evt.consume();
/* 800:    */     }
/* 801:    */   }
/* 802:    */   
/* 803:    */   private void btnImprimirActionPerformed(ActionEvent evt)
/* 804:    */   {
/* 805:700 */     List lista = new ArrayList();
/* 806:701 */     for (int i = 0; i < this.tblBoleta.getRowCount(); i++)
/* 807:    */     {
/* 808:702 */       imprimirBoletaVenta listac = new imprimirBoletaVenta(Integer.parseInt(this.tblBoleta.getValueAt(i, 0).toString()), this.tblBoleta.getValueAt(i, 1).toString(), this.tblBoleta.getValueAt(i, 2).toString(), Double.parseDouble(this.tblBoleta.getValueAt(i, 3).toString()), Double.parseDouble(this.tblBoleta.getValueAt(i, 4).toString()));
/* 809:    */       
/* 810:    */ 
/* 811:    */ 
/* 812:    */ 
/* 813:    */ 
/* 814:    */ 
/* 815:709 */       lista.add(listac);
/* 816:    */     }
/* 817:    */     try
/* 818:    */     {
/* 819:713 */       JasperReport report = (JasperReport)JRLoader.loadObject("C:\\Ledatel\\reportes\\imprimirFacturaVenta.jasper");
/* 820:714 */       Map parametro = new HashMap();
/* 821:715 */       parametro.put("DNI", txtDNI.getText());
/* 822:716 */       parametro.put("Datos", txtDatos.getText());
/* 823:717 */       parametro.put("Direccion", txtDireccion.getText());
/* 824:718 */       parametro.put("IGV", this.txtIGV.getText());
/* 825:719 */       parametro.put("Subtotal", this.txtSubtotal.getText());
/* 826:720 */       parametro.put("Total", this.txtTotal.getText());
/* 827:721 */       parametro.put("FechaVenta", this.lblFecha.getText());
/* 828:722 */       parametro.put("RUC", this.txtRUC.getText());
/* 829:723 */       parametro.put("Boleta", this.txtBoleta.getText());
/* 830:724 */       JasperPrint print = JasperFillManager.fillReport(report, parametro, new JRBeanCollectionDataSource(lista));
/* 831:725 */       JasperViewer.viewReport(print, false);
/* 832:726 */       JasperViewer.viewReport(print, false);
/* 833:    */     }
/* 834:    */     catch (Exception e)
/* 835:    */     {
/* 836:728 */       System.out.println(e.getMessage());
/* 837:    */     }
/* 838:    */   }
/* 839:    */   
/* 840:    */   private void btnBuscarClienteActionPerformed(ActionEvent evt)
/* 841:    */   {
/* 842:733 */     clienteDesk g = new clienteDesk();
/* 843:734 */     VentanaPrincipalGUI.desk.add(g);
/* 844:735 */     g.show();
/* 845:    */   }
/* 846:    */   
/* 847:    */   private void calendario()
/* 848:    */   {
/* 849:789 */     Calendar cal1 = Calendar.getInstance();
/* 850:790 */     String mesInt = "";
/* 851:791 */     int mes = cal1.get(2);
/* 852:792 */     int mesActual = mes + 1;
/* 853:793 */     if (mesActual < 9) {
/* 854:794 */       mesInt = "0" + mesActual + "/";
/* 855:    */     } else {
/* 856:796 */       mesInt = mesActual + "/";
/* 857:    */     }
/* 858:799 */     int dia = cal1.get(5);
/* 859:800 */     String diaInt = "";
/* 860:801 */     if (dia < 10) {
/* 861:802 */       diaInt = "0" + dia + "/";
/* 862:    */     } else {
/* 863:804 */       diaInt = dia + "/";
/* 864:    */     }
/* 865:806 */     int año = cal1.get(1);
/* 866:807 */     int añoAc = año - 2000;
/* 867:    */     
/* 868:809 */     this.lblFecha.setText("" + diaInt + mesInt + añoAc);
/* 869:    */   }
/* 870:    */   
/* 871:    */   private void limpiaControles()
/* 872:    */   {
/* 873:813 */     txtCantidad.setText(null);
/* 874:814 */     txtcod_prod.setText("");
/* 875:815 */     txtPrecio.setText(null);
/* 876:816 */     txtMarca_modelo.setText(null);
/* 877:817 */     txtMarca_modelo.grabFocus();
/* 878:    */   }
/* 879:    */   
/* 880:    */   private void calcularTotales()
/* 881:    */   {
/* 882:    */     try
/* 883:    */     {
/* 884:823 */       this.subtotal = 0.0D;
/* 885:824 */       this.igv = 0.0D;
/* 886:825 */       this.total = 0.0D;
/* 887:826 */       int filas = this.model.getRowCount();
/* 888:827 */       for (int i = 0; i < filas; i++) {
/* 889:828 */         this.total += Double.parseDouble(this.tblBoleta.getValueAt(i, 4).toString());
/* 890:    */       }
/* 891:830 */       this.igv = (this.total * 0.18D);
/* 892:831 */       this.subtotal = (this.total - this.igv);
/* 893:832 */       this.txtIGV.setText(String.format("%.2f", new Object[] { Double.valueOf(this.igv) }));
/* 894:833 */       this.txtSubtotal.setText(String.format("%.2f", new Object[] { Double.valueOf(this.subtotal) }));
/* 895:834 */       this.txtTotal.setText(String.valueOf(Math.round(this.total * 10.0D) / 10.0D));
/* 896:    */     }
/* 897:    */     catch (Exception e)
/* 898:    */     {
/* 899:836 */       System.out.println(e);
/* 900:    */     }
/* 901:    */   }
/* 902:    */   
/* 903:    */   private void muestraCodigoFactura()
/* 904:    */   {
/* 905:    */     try
/* 906:    */     {
/* 907:843 */       int codigoAnterior = 0;
/* 908:844 */       this.rs = this.oBoleta.codigoFacturaTop();
/* 909:845 */       while (this.rs.next())
/* 910:    */       {
/* 911:846 */         codigoAnterior = this.rs.getInt(1);
/* 912:847 */         this.txtRUC.setText(this.rs.getString(2));
/* 913:    */       }
/* 914:849 */       this.txtBoleta.setText("");
/* 915:850 */       int nuevoCodigo = codigoAnterior + 1;
/* 916:851 */       this.txtBoleta.setText(String.valueOf(nuevoCodigo));
/* 917:    */     }
/* 918:    */     catch (Exception e)
/* 919:    */     {
/* 920:853 */       System.out.println(e.getMessage());
/* 921:    */     }
/* 922:    */   }
/* 923:    */   
/* 924:    */   private void limpiacontroles()
/* 925:    */   {
/* 926:858 */     txtCantidad.setText("");
/* 927:859 */     txtcod_prod.setText("");
/* 928:860 */     txtDNI.setText("");
/* 929:861 */     this.txtImporte.setText("");
/* 930:862 */     txtPrecio.setText("");
/* 931:863 */     this.txtSubtotal.setText("");
/* 932:864 */     txtDatos.setText("");
/* 933:865 */     txtDireccion.setText("");
/* 934:866 */     this.txtPago.setText("");
/* 935:867 */     this.txtVuelto.setText("");
/* 936:868 */     this.btnImprimir.setEnabled(true);
/* 937:869 */     this.txtIGV.setText("");
/* 938:870 */     this.txtTotal.setText("");
/* 939:871 */     int filas = this.tblBoleta.getRowCount();
/* 940:872 */     for (int i = 0; filas > i; i++) {
/* 941:873 */       this.model.removeRow(0);
/* 942:    */     }
/* 943:    */   }
/* 944:    */ }



/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar

 * Qualified Name:     Desk.reparacionesDesk

 * JD-Core Version:    0.7.0.1

 */