/*   1:    */ package Desk;
/*   2:    */ 
/*   3:    */ import Dao.boletaDao;
/*   4:    */ import Dao.clienteDao;
/*   5:    */ import Dao.detalleDao;
/*   6:    */ import Dao.empleadoDao;
/*   7:    */ import Dao.productoDao;
/*   8:    */ import Gui.VentanaPrincipalGUI;
/*   9:    */ import Log_Reporte.imprimirBoletaVenta;
/*  10:    */ import To.boleta_TO;
/*  11:    */ import To.cliente_TO;
/*  12:    */ import To.detalleventa_TO;
/*  13:    */ import To.producto_TO;
/*  14:    */ import java.awt.Color;
/*  15:    */ import java.awt.Container;
/*  16:    */ import java.awt.Dimension;
/*  17:    */ import java.awt.Font;
/*  18:    */ import java.awt.event.ActionEvent;
/*  19:    */ import java.awt.event.ActionListener;
/*  20:    */ import java.awt.event.KeyAdapter;
/*  21:    */ import java.awt.event.KeyEvent;
/*  22:    */ import java.io.PrintStream;
/*  23:    */ import java.sql.ResultSet;
/*  24:    */ import java.util.ArrayList;
/*  25:    */ import java.util.Calendar;
/*  26:    */ import java.util.HashMap;
/*  27:    */ import java.util.List;
/*  28:    */ import java.util.Map;
/*  29:    */ import javax.swing.BorderFactory;
/*  30:    */ import javax.swing.DefaultComboBoxModel;
/*  31:    */ import javax.swing.GroupLayout;
/*  32:    */ import javax.swing.GroupLayout.Alignment;
/*  33:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  34:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  35:    */ import javax.swing.ImageIcon;
/*  36:    */ import javax.swing.JButton;
/*  37:    */ import javax.swing.JComboBox;
/*  38:    */ import javax.swing.JDesktopPane;
/*  39:    */ import javax.swing.JInternalFrame;
/*  40:    */ import javax.swing.JLabel;
/*  41:    */ import javax.swing.JOptionPane;
/*  42:    */ import javax.swing.JPanel;
/*  43:    */ import javax.swing.JScrollPane;
/*  44:    */ import javax.swing.JTable;
/*  45:    */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*  46:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  47:    */ import javax.swing.table.DefaultTableModel;
/*  48:    */ import javax.swing.table.TableColumn;
/*  49:    */ import javax.swing.table.TableColumnModel;
/*  50:    */ import net.sf.jasperreports.engine.JasperFillManager;
/*  51:    */ import net.sf.jasperreports.engine.JasperPrint;
/*  52:    */ import net.sf.jasperreports.engine.JasperReport;
/*  53:    */ import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
/*  54:    */ import net.sf.jasperreports.engine.util.JRLoader;
/*  55:    */ import net.sf.jasperreports.view.JasperViewer;
/*  56:    */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*  57:    */ import org.netbeans.lib.awtextra.AbsoluteLayout;
/*  58:    */ 
/*  59:    */ public class boletaDesk
/*  60:    */   extends JInternalFrame
/*  61:    */ {
/*  62: 39 */   private static boletaDesk fromBoleta = null;
/*  63:    */   ResultSet rs;
/*  64:    */   
/*  65:    */   public static boletaDesk getForm()
/*  66:    */   {
/*  67: 42 */     if (fromBoleta == null) {
/*  68: 43 */       fromBoleta = new boletaDesk();
/*  69:    */     }
/*  70: 45 */     return fromBoleta;
/*  71:    */   }
/*  72:    */   
/*  73: 48 */   empleadoDao oEmpleado = new empleadoDao();
/*  74:    */   DefaultTableModel model;
/*  75: 50 */   double importe = 0.0D;
/*  76:    */   double igv;
/*  77:    */   double subtotal;
/*  78:    */   double total;
/*  79: 52 */   clienteDao oCliente = new clienteDao();
/*  80: 53 */   cliente_TO toCliente = new cliente_TO();
/*  81: 54 */   boletaDao oBoleta = new boletaDao();
/*  82: 55 */   boleta_TO toBoleta = new boleta_TO();
/*  83: 56 */   detalleDao oDetalle = new detalleDao();
/*  84: 57 */   productoDao oProducto = new productoDao();
/*  85:    */   private JButton btnActivar;
/*  86:    */   private JButton btnAdd_Prodc;
/*  87:    */   private JButton btnBuscar;
/*  88:    */   private JButton btnBuscarCliente;
/*  89:    */   private JButton btnImprimir;
/*  90:    */   private JButton btnQuitar_prodc;
/*  91:    */   private JButton btnVender;
/*  92:    */   private JComboBox cboPago;
/*  93:    */   private JLabel jLabel1;
/*  94:    */   private JLabel jLabel10;
/*  95:    */   private JLabel jLabel11;
/*  96:    */   private JLabel jLabel12;
/*  97:    */   private JLabel jLabel13;
/*  98:    */   private JLabel jLabel14;
/*  99:    */   private JLabel jLabel16;
/* 100:    */   private JLabel jLabel17;
/* 101:    */   private JLabel jLabel18;
/* 102:    */   private JLabel jLabel2;
/* 103:    */   private JLabel jLabel3;
/* 104:    */   private JLabel jLabel4;
/* 105:    */   private JLabel jLabel5;
/* 106:    */   private JLabel jLabel7;
/* 107:    */   private JLabel jLabel8;
/* 108:    */   private JLabel jLabel9;
/* 109:    */   private JPanel jPanel1;
/* 110:    */   private JPanel jPanel2;
/* 111:    */   private JPanel jPanel3;
/* 112:    */   private JScrollPane jScrollPane1;
/* 113:    */   private JLabel lblFecha;
/* 114:    */   private JTable tblBoleta;
/* 115:    */   private JTextField txtBoleta;
/* 116:    */   public static JTextField txtCantidad;
/* 117:    */   public static JTextField txtDNI;
/* 118:    */   public static JTextField txtDatos;
/* 119:    */   public static JTextField txtDireccion;
/* 120:    */   private JTextField txtIGV;
/* 121:    */   private JTextField txtImporte;
/* 122:    */   public static JTextField txtMarca_modelo;
/* 123:    */   private JTextField txtPago;
/* 124:    */   public static JTextField txtPrecio;
/* 125:    */   private JTextField txtRUC;
/* 126:    */   private JTextField txtSubtotal;
/* 127:    */   private JTextField txtTotal;
/* 128:    */   private JTextField txtVuelto;
/* 129:    */   public static JTextField txtcod_prod;
/* 130:    */   
/* 131:    */   public boletaDesk()
/* 132:    */   {
/* 133: 62 */     initComponents();
/* 134: 63 */     muestraCodigoFactura();
/* 135: 64 */     calendario();
/* 136:    */   }
/* 137:    */   
/* 138:    */   private void initComponents()
/* 139:    */   {
/* 140: 72 */     this.jPanel1 = new JPanel();
/* 141: 73 */     this.jLabel1 = new JLabel();
/* 142: 74 */     this.jLabel2 = new JLabel();
/* 143: 75 */     this.jLabel3 = new JLabel();
/* 144: 76 */     this.jLabel4 = new JLabel();
/* 145: 77 */     this.txtImporte = new JTextField();
/* 146: 78 */     txtcod_prod = new JTextField();
/* 147: 79 */     txtMarca_modelo = new JTextField();
/* 148: 80 */     txtPrecio = new JTextField();
/* 149: 81 */     txtCantidad = new JTextField();
/* 150: 82 */     this.btnBuscar = new JButton();
/* 151: 83 */     this.jLabel5 = new JLabel();
/* 152: 84 */     this.jScrollPane1 = new JScrollPane();
/* 153: 85 */     this.tblBoleta = new JTable();
/* 154: 86 */     this.btnAdd_Prodc = new JButton();
/* 155: 87 */     this.btnQuitar_prodc = new JButton();
/* 156: 88 */     this.jPanel3 = new JPanel();
/* 157: 89 */     this.jLabel13 = new JLabel();
/* 158: 90 */     this.jLabel14 = new JLabel();
/* 159: 91 */     this.txtBoleta = new JTextField();
/* 160: 92 */     this.txtRUC = new JTextField();
/* 161: 93 */     this.btnActivar = new JButton();
/* 162: 94 */     this.lblFecha = new JLabel();
/* 163: 95 */     this.jLabel16 = new JLabel();
/* 164: 96 */     this.jLabel17 = new JLabel();
/* 165: 97 */     this.jLabel18 = new JLabel();
/* 166: 98 */     txtDNI = new JTextField();
/* 167: 99 */     txtDatos = new JTextField();
/* 168:100 */     txtDireccion = new JTextField();
/* 169:101 */     this.btnBuscarCliente = new JButton();
/* 170:102 */     this.jPanel2 = new JPanel();
/* 171:103 */     this.jLabel10 = new JLabel();
/* 172:104 */     this.jLabel11 = new JLabel();
/* 173:105 */     this.jLabel12 = new JLabel();
/* 174:106 */     this.txtIGV = new JTextField();
/* 175:107 */     this.txtSubtotal = new JTextField();
/* 176:108 */     this.txtTotal = new JTextField();
/* 177:109 */     this.jLabel7 = new JLabel();
/* 178:110 */     this.cboPago = new JComboBox();
/* 179:111 */     this.btnVender = new JButton();
/* 180:112 */     this.btnImprimir = new JButton();
/* 181:113 */     this.jLabel8 = new JLabel();
/* 182:114 */     this.txtPago = new JTextField();
/* 183:115 */     this.jLabel9 = new JLabel();
/* 184:116 */     this.txtVuelto = new JTextField();
/* 185:    */     
/* 186:118 */     setClosable(true);
/* 187:119 */     setIconifiable(true);
/* 188:120 */     setTitle("Boleta de ventas");
/* 189:121 */     setMinimumSize(new Dimension(1350, 620));
/* 190:122 */     setPreferredSize(new Dimension(1350, 620));
/* 191:    */     
/* 192:124 */     this.jPanel1.setBackground(new Color(102, 102, 102));
/* 193:125 */     this.jPanel1.setLayout(new AbsoluteLayout());
/* 194:    */     
/* 195:127 */     this.jLabel1.setForeground(new Color(255, 255, 255));
/* 196:128 */     this.jLabel1.setText("CÓDIGO PRODUCTO:");
/* 197:129 */     this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(237, 150, -1, -1));
/* 198:    */     
/* 199:131 */     this.jLabel2.setFont(new Font("Bookman Old Style", 0, 14));
/* 200:132 */     this.jLabel2.setForeground(new Color(255, 255, 255));
/* 201:133 */     this.jLabel2.setText("MARCA/SERIE :");
/* 202:134 */     this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(250, 180, -1, -1));
/* 203:    */     
/* 204:136 */     this.jLabel3.setFont(new Font("Bookman Old Style", 0, 14));
/* 205:137 */     this.jLabel3.setForeground(new Color(255, 255, 255));
/* 206:138 */     this.jLabel3.setText("PRECIO UNITARIO:");
/* 207:139 */     this.jPanel1.add(this.jLabel3, new AbsoluteConstraints(230, 220, -1, -1));
/* 208:    */     
/* 209:141 */     this.jLabel4.setFont(new Font("Bookman Old Style", 0, 14));
/* 210:142 */     this.jLabel4.setForeground(new Color(255, 255, 255));
/* 211:143 */     this.jLabel4.setText("CANTIDAD:");
/* 212:144 */     this.jPanel1.add(this.jLabel4, new AbsoluteConstraints(280, 250, -1, -1));
/* 213:    */     
/* 214:146 */     this.txtImporte.setEditable(false);
/* 215:147 */     this.txtImporte.setFont(new Font("sansserif", 1, 36));
/* 216:148 */     this.txtImporte.setForeground(new Color(0, 0, 51));
/* 217:149 */     this.txtImporte.setHorizontalAlignment(0);
/* 218:150 */     this.txtImporte.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2), "Importe a pagar :  S/.", 2, 2));
/* 219:151 */     this.jPanel1.add(this.txtImporte, new AbsoluteConstraints(610, 150, 195, 130));
/* 220:    */     
/* 221:153 */     txtcod_prod.setHorizontalAlignment(0);
/* 222:154 */     txtcod_prod.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 223:155 */     this.jPanel1.add(txtcod_prod, new AbsoluteConstraints(371, 148, 202, -1));
/* 224:    */     
/* 225:157 */     txtMarca_modelo.setHorizontalAlignment(0);
/* 226:158 */     txtMarca_modelo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2)));
/* 227:159 */     this.jPanel1.add(txtMarca_modelo, new AbsoluteConstraints(371, 180, 202, -1));
/* 228:    */     
/* 229:161 */     txtPrecio.setHorizontalAlignment(0);
/* 230:162 */     txtPrecio.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 231:163 */     this.jPanel1.add(txtPrecio, new AbsoluteConstraints(370, 220, 200, -1));
/* 232:    */     
/* 233:165 */     txtCantidad.setHorizontalAlignment(0);
/* 234:166 */     txtCantidad.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 235:167 */     txtCantidad.addKeyListener(new KeyAdapter()
/* 236:    */     {
/* 237:    */       public void keyReleased(KeyEvent evt)
/* 238:    */       {
/* 239:169 */         boletaDesk.this.txtCantidadKeyReleased(evt);
/* 240:    */       }
/* 241:    */       
/* 242:    */       public void keyTyped(KeyEvent evt)
/* 243:    */       {
/* 244:172 */         boletaDesk.this.txtCantidadKeyTyped(evt);
/* 245:    */       }
/* 246:174 */     });
/* 247:175 */     this.jPanel1.add(txtCantidad, new AbsoluteConstraints(370, 250, 200, -1));
/* 248:    */     
/* 249:177 */     this.btnBuscar.setBackground(new Color(153, 204, 255));
/* 250:178 */     this.btnBuscar.setFont(new Font("sansserif", 1, 14));
/* 251:179 */     this.btnBuscar.setText("BUSCAR  PRODUCTO");
/* 252:180 */     this.btnBuscar.setBorder(null);
/* 253:181 */     this.btnBuscar.addActionListener(new ActionListener()
/* 254:    */     {
/* 255:    */       public void actionPerformed(ActionEvent evt)
/* 256:    */       {
/* 257:183 */         boletaDesk.this.btnBuscarActionPerformed(evt);
/* 258:    */       }
/* 259:185 */     });
/* 260:186 */     this.jPanel1.add(this.btnBuscar, new AbsoluteConstraints(820, 150, 190, 57));
/* 261:    */     
/* 262:188 */     this.jLabel5.setFont(new Font("sansserif", 1, 14));
/* 263:189 */     this.jLabel5.setForeground(new Color(255, 0, 0));
/* 264:190 */     this.jLabel5.setHorizontalAlignment(0);
/* 265:191 */     this.jLabel5.setText("LISTA DE PRODUCTOS A VENDER ");
/* 266:192 */     this.jPanel1.add(this.jLabel5, new AbsoluteConstraints(100, 280, 256, -1));
/* 267:    */     
/* 268:194 */     this.tblBoleta.setModel(new DefaultTableModel(new Object[0][], new String[] { "Cant.", "codigo", "observación", "precio unit.", "importe" })
/* 269:    */     {
/* 270:202 */       boolean[] canEdit = { false, false, false, false, false };
/* 271:    */       
/* 272:    */       public boolean isCellEditable(int rowIndex, int columnIndex)
/* 273:    */       {
/* 274:207 */         return this.canEdit[columnIndex];
/* 275:    */       }
/* 276:209 */     });
/* 277:210 */     this.jScrollPane1.setViewportView(this.tblBoleta);
/* 278:211 */     if (this.tblBoleta.getColumnModel().getColumnCount() > 0)
/* 279:    */     {
/* 280:212 */       this.tblBoleta.getColumnModel().getColumn(0).setMinWidth(50);
/* 281:213 */       this.tblBoleta.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 282:214 */       this.tblBoleta.getColumnModel().getColumn(0).setMaxWidth(50);
/* 283:215 */       this.tblBoleta.getColumnModel().getColumn(1).setMinWidth(70);
/* 284:216 */       this.tblBoleta.getColumnModel().getColumn(1).setPreferredWidth(70);
/* 285:217 */       this.tblBoleta.getColumnModel().getColumn(1).setMaxWidth(70);
/* 286:218 */       this.tblBoleta.getColumnModel().getColumn(3).setMinWidth(80);
/* 287:219 */       this.tblBoleta.getColumnModel().getColumn(3).setPreferredWidth(80);
/* 288:220 */       this.tblBoleta.getColumnModel().getColumn(3).setMaxWidth(80);
/* 289:221 */       this.tblBoleta.getColumnModel().getColumn(4).setMinWidth(60);
/* 290:222 */       this.tblBoleta.getColumnModel().getColumn(4).setPreferredWidth(60);
/* 291:223 */       this.tblBoleta.getColumnModel().getColumn(4).setMaxWidth(60);
/* 292:    */     }
/* 293:226 */     this.jPanel1.add(this.jScrollPane1, new AbsoluteConstraints(101, 305, 900, 180));
/* 294:    */     
/* 295:228 */     this.btnAdd_Prodc.setBackground(new Color(0, 51, 51));
/* 296:229 */     this.btnAdd_Prodc.setFont(new Font("sansserif", 1, 14));
/* 297:230 */     this.btnAdd_Prodc.setText("AGREGAR");
/* 298:231 */     this.btnAdd_Prodc.setBorder(null);
/* 299:232 */     this.btnAdd_Prodc.addActionListener(new ActionListener()
/* 300:    */     {
/* 301:    */       public void actionPerformed(ActionEvent evt)
/* 302:    */       {
/* 303:234 */         boletaDesk.this.btnAdd_ProdcActionPerformed(evt);
/* 304:    */       }
/* 305:236 */     });
/* 306:237 */     this.jPanel1.add(this.btnAdd_Prodc, new AbsoluteConstraints(820, 220, 100, 40));
/* 307:    */     
/* 308:239 */     this.btnQuitar_prodc.setBackground(new Color(0, 51, 51));
/* 309:240 */     this.btnQuitar_prodc.setFont(new Font("sansserif", 1, 14));
/* 310:241 */     this.btnQuitar_prodc.setText("QUITAR");
/* 311:242 */     this.btnQuitar_prodc.setBorder(null);
/* 312:243 */     this.btnQuitar_prodc.addActionListener(new ActionListener()
/* 313:    */     {
/* 314:    */       public void actionPerformed(ActionEvent evt)
/* 315:    */       {
/* 316:245 */         boletaDesk.this.btnQuitar_prodcActionPerformed(evt);
/* 317:    */       }
/* 318:247 */     });
/* 319:248 */     this.jPanel1.add(this.btnQuitar_prodc, new AbsoluteConstraints(920, 220, 90, 40));
/* 320:    */     
/* 321:250 */     this.jPanel3.setBackground(new Color(0, 0, 0));
/* 322:    */     
/* 323:252 */     this.jLabel13.setFont(new Font("sansserif", 1, 14));
/* 324:253 */     this.jLabel13.setForeground(new Color(255, 255, 255));
/* 325:254 */     this.jLabel13.setText("R.U.C :");
/* 326:    */     
/* 327:256 */     this.jLabel14.setFont(new Font("sansserif", 1, 14));
/* 328:257 */     this.jLabel14.setForeground(new Color(255, 255, 255));
/* 329:258 */     this.jLabel14.setText("N° BOLETA:");
/* 330:    */     
/* 331:260 */     this.txtBoleta.setEditable(false);
/* 332:261 */     this.txtBoleta.setFont(new Font("sansserif", 1, 14));
/* 333:262 */     this.txtBoleta.setForeground(new Color(255, 0, 0));
/* 334:263 */     this.txtBoleta.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
/* 335:    */     
/* 336:265 */     this.txtRUC.setEditable(false);
/* 337:266 */     this.txtRUC.setFont(new Font("sansserif", 1, 14));
/* 338:267 */     this.txtRUC.setForeground(new Color(0, 0, 204));
/* 339:268 */     this.txtRUC.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
/* 340:    */     
/* 341:270 */     this.btnActivar.setBackground(new Color(153, 204, 255));
/* 342:271 */     this.btnActivar.setFont(new Font("sansserif", 1, 14));
/* 343:272 */     this.btnActivar.setIcon(new ImageIcon(getClass().getResource("/icon/application-pgp-signature.png")));
/* 344:273 */     this.btnActivar.setText("A C T I V A R");
/* 345:274 */     this.btnActivar.addActionListener(new ActionListener()
/* 346:    */     {
/* 347:    */       public void actionPerformed(ActionEvent evt)
/* 348:    */       {
/* 349:276 */         boletaDesk.this.btnActivarActionPerformed(evt);
/* 350:    */       }
/* 351:279 */     });
/* 352:280 */     this.lblFecha.setFont(new Font("sansserif", 1, 20));
/* 353:281 */     this.lblFecha.setForeground(new Color(255, 255, 255));
/* 354:282 */     this.lblFecha.setHorizontalAlignment(0);
/* 355:283 */     this.lblFecha.setText("dd/mm/aa");
/* 356:284 */     this.lblFecha.setBorder(BorderFactory.createLineBorder(new Color(153, 255, 0)));
/* 357:    */     
/* 358:286 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 359:287 */     this.jPanel3.setLayout(jPanel3Layout);
/* 360:288 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(39, 39, 39).addComponent(this.jLabel13).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtRUC, -2, 226, -2).addGap(84, 84, 84).addComponent(this.jLabel14).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtBoleta, -2, 226, -2).addGap(33, 33, 33).addComponent(this.btnActivar, -2, 163, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 274, 32767).addComponent(this.lblFecha, -2, 152, -2).addContainerGap()));
 jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel13).addComponent(this.jLabel14)).addGap(0, 0, 32767)).addComponent(this.btnActivar, -2, 47, -2)).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtRUC, -2, -1, -2).addComponent(this.txtBoleta, -2, -1, -2)).addGap(15, 15, 15)).addComponent(this.lblFecha, -1, -1, 32767));

/* 398:326 */     this.jPanel1.add(this.jPanel3, new AbsoluteConstraints(0, 0, 1340, -1));
/* 399:    */     
/* 400:328 */     this.jLabel16.setFont(new Font("sansserif", 1, 12));
/* 401:329 */     this.jLabel16.setForeground(new Color(255, 255, 255));
/* 402:330 */     this.jLabel16.setText("D N I   C L I E N T E :");
/* 403:331 */     this.jPanel1.add(this.jLabel16, new AbsoluteConstraints(101, 90, -1, -1));
/* 404:    */     
/* 405:333 */     this.jLabel17.setFont(new Font("sansserif", 1, 12));
/* 406:334 */     this.jLabel17.setForeground(new Color(255, 255, 255));
/* 407:335 */     this.jLabel17.setText("D A T O S :");
/* 408:336 */     this.jPanel1.add(this.jLabel17, new AbsoluteConstraints(411, 90, -1, -1));
/* 409:    */     
/* 410:338 */     this.jLabel18.setFont(new Font("sansserif", 1, 12));
/* 411:339 */     this.jLabel18.setForeground(new Color(255, 255, 255));
/* 412:340 */     this.jLabel18.setText("D I R E C C I Ó N :");
/* 413:341 */     this.jPanel1.add(this.jLabel18, new AbsoluteConstraints(758, 90, -1, -1));
/* 414:    */     
/* 415:343 */     txtDNI.setFont(new Font("sansserif", 0, 14));
/* 416:344 */     txtDNI.setHorizontalAlignment(0);
/* 417:345 */     txtDNI.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
/* 418:346 */     txtDNI.addKeyListener(new KeyAdapter()
/* 419:    */     {
/* 420:    */       public void keyTyped(KeyEvent evt)
/* 421:    */       {
/* 422:348 */         boletaDesk.this.txtDNIKeyTyped(evt);
/* 423:    */       }
/* 424:350 */     });
/* 425:351 */     this.jPanel1.add(txtDNI, new AbsoluteConstraints(212, 87, 154, -1));
/* 426:    */     
/* 427:353 */     txtDatos.setFont(new Font("sansserif", 0, 14));
/* 428:354 */     txtDatos.setHorizontalAlignment(0);
/* 429:355 */     txtDatos.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
/* 430:356 */     this.jPanel1.add(txtDatos, new AbsoluteConstraints(487, 87, 186, -1));
/* 431:    */     
/* 432:358 */     txtDireccion.setFont(new Font("sansserif", 0, 14));
/* 433:359 */     txtDireccion.setHorizontalAlignment(0);
/* 434:360 */     txtDireccion.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
/* 435:361 */     this.jPanel1.add(txtDireccion, new AbsoluteConstraints(876, 87, 227, -1));
/* 436:    */     
/* 437:363 */     this.btnBuscarCliente.setBackground(new Color(153, 204, 255));
/* 438:364 */     this.btnBuscarCliente.setFont(new Font("sansserif", 1, 14));
/* 439:365 */     this.btnBuscarCliente.setText("BUSCAR / A D D  CLIENTE");
/* 440:366 */     this.btnBuscarCliente.addActionListener(new ActionListener()
/* 441:    */     {
/* 442:    */       public void actionPerformed(ActionEvent evt)
/* 443:    */       {
/* 444:368 */         boletaDesk.this.btnBuscarClienteActionPerformed(evt);
/* 445:    */       }
/* 446:370 */     });
/* 447:371 */     this.jPanel1.add(this.btnBuscarCliente, new AbsoluteConstraints(1130, 80, 208, -1));
/* 448:    */     
/* 449:373 */     this.jPanel2.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
/* 450:374 */     this.jPanel2.setOpaque(false);
/* 451:    */     
/* 452:376 */     this.jLabel10.setText("IGV");
/* 453:    */     
/* 454:378 */     this.jLabel11.setText("Subtotal");
/* 455:    */     
/* 456:380 */     this.jLabel12.setText("Total");
/* 457:    */     
/* 458:382 */     this.txtIGV.setHorizontalAlignment(0);
/* 459:383 */     this.txtIGV.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 460:    */     
/* 461:385 */     this.txtSubtotal.setHorizontalAlignment(0);
/* 462:386 */     this.txtSubtotal.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 463:    */     
/* 464:388 */     this.txtTotal.setHorizontalAlignment(0);
/* 465:389 */     this.txtTotal.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 466:    */     
/* 467:391 */     this.jLabel7.setText("Tipo de Pago:");
/* 468:    */     
/* 469:393 */     this.cboPago.setBackground(new Color(51, 51, 51));
/* 470:394 */     this.cboPago.setModel(new DefaultComboBoxModel(new String[] { "EFECTIVO", "CREDITO", "TARGETA" }));
/* 471:    */     
/* 472:396 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 473:397 */     this.jPanel2.setLayout(jPanel2Layout);
/* 474:398 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel7).addGap(87, 87, 87).addComponent(this.jLabel12, -2, 37, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.cboPago, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel11)).addComponent(this.jLabel10, GroupLayout.Alignment.TRAILING)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.txtTotal, -2, 96, -2)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.txtSubtotal, -2, 97, -2).addGap(0, 1, 32767))).addContainerGap(12, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.txtIGV, -2, 97, -2).addContainerGap(-1, 32767)))));
/* 475:    */     
/* 476:    */ 
/* 477:    */ 
/* 478:    */ 
/* 479:    */ 
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
/* 503:427 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel12).addComponent(this.jLabel7)).addComponent(this.txtTotal, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel11).addComponent(this.txtSubtotal, -2, -1, -2).addComponent(this.cboPago, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel10).addComponent(this.txtIGV, -2, -1, -2)).addContainerGap(-1, 32767)));
/* 504:    */     
/* 505:    */ 
/* 506:    */ 
/* 507:    */ 
/* 508:    */ 
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
/* 524:448 */     this.jPanel1.add(this.jPanel2, new AbsoluteConstraints(1010, 310, -1, -1));
/* 525:    */     
/* 526:450 */     this.btnVender.setBackground(new Color(153, 204, 255));
/* 527:451 */     this.btnVender.setIcon(new ImageIcon(getClass().getResource("/icon/basic3-017_invoice_bill-32.png")));
/* 528:452 */     this.btnVender.setText("Vender");
/* 529:453 */     this.btnVender.addActionListener(new ActionListener()
/* 530:    */     {
/* 531:    */       public void actionPerformed(ActionEvent evt)
/* 532:    */       {
/* 533:455 */         boletaDesk.this.btnVenderActionPerformed(evt);
/* 534:    */       }
/* 535:457 */     });
/* 536:458 */     this.jPanel1.add(this.btnVender, new AbsoluteConstraints(1010, 420, 170, 63));
/* 537:    */     
/* 538:460 */     this.btnImprimir.setBackground(new Color(153, 204, 255));
/* 539:461 */     this.btnImprimir.setIcon(new ImageIcon(getClass().getResource("/icon/print-32.png")));
/* 540:462 */     this.btnImprimir.setText("Imprimir");
/* 541:463 */     this.btnImprimir.addActionListener(new ActionListener()
/* 542:    */     {
/* 543:    */       public void actionPerformed(ActionEvent evt)
/* 544:    */       {
/* 545:465 */         boletaDesk.this.btnImprimirActionPerformed(evt);
/* 546:    */       }
/* 547:467 */     });
/* 548:468 */     this.jPanel1.add(this.btnImprimir, new AbsoluteConstraints(1200, 420, 140, 60));
/* 549:    */     
/* 550:470 */     this.jLabel8.setBackground(new Color(255, 204, 102));
/* 551:471 */     this.jLabel8.setHorizontalAlignment(0);
/* 552:472 */     this.jLabel8.setText("Pago con S/. ");
/* 553:473 */     this.jPanel1.add(this.jLabel8, new AbsoluteConstraints(110, 510, 123, -1));
/* 554:    */     
/* 555:475 */     this.txtPago.setFont(new Font("sansserif", 1, 14));
/* 556:476 */     this.txtPago.setForeground(new Color(51, 153, 0));
/* 557:477 */     this.txtPago.setHorizontalAlignment(0);
/* 558:478 */     this.txtPago.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 559:479 */     this.txtPago.addKeyListener(new KeyAdapter()
/* 560:    */     {
/* 561:    */       public void keyReleased(KeyEvent evt)
/* 562:    */       {
/* 563:481 */         boletaDesk.this.txtPagoKeyReleased(evt);
/* 564:    */       }
/* 565:483 */     });
/* 566:484 */     this.jPanel1.add(this.txtPago, new AbsoluteConstraints(120, 530, 123, -1));
/* 567:    */     
/* 568:486 */     this.jLabel9.setBackground(new Color(255, 204, 102));
/* 569:487 */     this.jLabel9.setHorizontalAlignment(0);
/* 570:488 */     this.jLabel9.setText("Cambio (vuelto) S/.");
/* 571:489 */     this.jPanel1.add(this.jLabel9, new AbsoluteConstraints(320, 510, 123, -1));
/* 572:    */     
/* 573:491 */     this.txtVuelto.setFont(new Font("sansserif", 1, 14));
/* 574:492 */     this.txtVuelto.setForeground(new Color(51, 153, 0));
/* 575:493 */     this.txtVuelto.setHorizontalAlignment(0);
/* 576:494 */     this.txtVuelto.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 577:495 */     this.jPanel1.add(this.txtVuelto, new AbsoluteConstraints(310, 530, 167, -1));
/* 578:    */     
/* 579:497 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 580:498 */     getContentPane().setLayout(layout);
/* 581:499 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(0, 0, 32767)));
/* 582:    */     
/* 583:    */ 
/* 584:    */ 
/* 585:    */ 
/* 586:    */ 
/* 587:505 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, 609, 32767).addContainerGap()));
/* 588:    */     
/* 589:    */ 
/* 590:    */ 
/* 591:    */ 
/* 592:    */ 
/* 593:    */ 
/* 594:    */ 
/* 595:513 */     pack();
/* 596:    */   }
/* 597:    */   
/* 598:    */   private void btnActivarActionPerformed(ActionEvent evt)
/* 599:    */   {
/* 600:517 */     String val = VentanaPrincipalGUI.lblEmpleado.getText();
/* 601:518 */     if (val.equals("|ADMINISTRADOR|"))
/* 602:    */     {
/* 603:519 */       this.txtRUC.setEditable(true);
/* 604:520 */       this.txtBoleta.setEditable(true);
/* 605:521 */       this.txtRUC.grabFocus();
/* 606:522 */       this.btnActivar.setEnabled(false);
/* 607:    */     }
/* 608:    */   }
/* 609:    */   
/* 610:    */   private void btnBuscarActionPerformed(ActionEvent evt)
/* 611:    */   {
/* 612:527 */     productoDesk GUI = new productoDesk();
/* 613:528 */     VentanaPrincipalGUI.desk.add(GUI);
/* 614:529 */     GUI.show();
/* 615:    */   }
/* 616:    */   
/* 617:    */   private void txtCantidadKeyReleased(KeyEvent evt)
/* 618:    */   {
/* 619:533 */     int cantidad = Integer.parseInt(txtCantidad.getText());
/* 620:534 */     double precio = Double.parseDouble(txtPrecio.getText());
/* 621:535 */     double importe = cantidad * precio;
/* 622:536 */     this.txtImporte.setText(String.valueOf(importe));
/* 623:    */   }
/* 624:    */   
/* 625:    */   private void btnAdd_ProdcActionPerformed(ActionEvent evt)
/* 626:    */   {
/* 627:    */     try
/* 628:    */     {
/* 629:541 */       this.model = ((DefaultTableModel)this.tblBoleta.getModel());
/* 630:542 */       this.importe = Double.parseDouble(this.txtImporte.getText());
/* 631:543 */       int filas = this.tblBoleta.getRowCount();
/* 632:544 */       for (int i = 0; i < filas; i++) {
/* 633:545 */         if (txtcod_prod.getText().equalsIgnoreCase(this.tblBoleta.getValueAt(i, 1).toString()))
/* 634:    */         {
/* 635:546 */           JOptionPane.showMessageDialog(this.rootPane, "Ud. ya Esta Utilizando este Producto");
/* 636:547 */           this.model.removeRow(this.tblBoleta.getSelectedRow());
/* 637:548 */           limpiaControles();
/* 638:    */         }
/* 639:    */       }
/* 640:551 */       if (this.importe > 0.0D)
/* 641:    */       {
/* 642:552 */         Object[] registros = { txtCantidad.getText(), txtcod_prod.getText(), txtMarca_modelo.getText(), txtPrecio.getText(), Double.valueOf(this.importe) };
/* 643:    */         
/* 644:    */ 
/* 645:555 */         this.model.addRow(registros);
/* 646:556 */         calcularTotales();
/* 647:    */       }
/* 648:558 */       txtMarca_modelo.setText("");
/* 649:559 */       txtPrecio.setText("0.0");
/* 650:560 */       txtCantidad.setText("");
/* 651:561 */       this.txtImporte.setText("0.0");
/* 652:    */     }
/* 653:    */     catch (Exception e)
/* 654:    */     {
/* 655:563 */       System.out.println(e.getMessage());
/* 656:    */     }
/* 657:    */   }
/* 658:    */   
/* 659:    */   private void btnQuitar_prodcActionPerformed(ActionEvent evt)
/* 660:    */   {
/* 661:568 */     this.model.removeRow(this.tblBoleta.getSelectedRow());
/* 662:569 */     calcularTotales();
/* 663:    */   }
/* 664:    */   
/* 665:    */   private void txtPagoKeyReleased(KeyEvent evt)
/* 666:    */   {
/* 667:574 */     double pago = Double.parseDouble(this.txtPago.getText());
/* 668:575 */     double cambio = pago - this.total;
/* 669:576 */     this.txtVuelto.setText(String.valueOf(cambio));
/* 670:    */   }
/* 671:    */   
/* 672:    */   private void btnVenderActionPerformed(ActionEvent evt)
/* 673:    */   {
/* 674:    */     try
/* 675:    */     {
/* 676:583 */       String codigoCliente = "";
/* 677:584 */       String codigoEmpleado = "";
/* 678:585 */       this.rs = this.oBoleta.obteneriIDcliente();
/* 679:586 */       while (this.rs.next()) {
/* 680:587 */         if (txtDNI.getText().equals(this.rs.getString(2))) {
/* 681:588 */           codigoCliente = this.rs.getString(1);
/* 682:    */         }
/* 683:    */       }
/* 684:592 */       String codEmple = VentanaPrincipalGUI.lblEmpleado.getText();
/* 685:593 */       this.rs = this.oEmpleado.cargaEmpleado();
/* 686:594 */       while (this.rs.next())
/* 687:    */       {
/* 688:595 */         if (VentanaPrincipalGUI.lblEmpleado.getText().equals(this.rs.getString(2) + " " + this.rs.getString(3)))
/* 689:    */         {
/* 690:596 */           codigoEmpleado = this.rs.getString(1);
/* 691:597 */           System.out.println(codigoEmpleado);
/* 692:    */         }
/* 693:599 */         if (codEmple.equals("|ADMINISTRADOR|")) {
/* 694:600 */           codigoEmpleado = "100000";
/* 695:    */         }
/* 696:    */       }
/* 697:605 */       this.toBoleta.setCodigoFactura(this.txtBoleta.getText());
/* 698:606 */       this.toBoleta.setRuc(this.txtRUC.getText());
/* 699:607 */       this.toBoleta.setIgv(this.igv);
/* 700:608 */       this.toBoleta.setSubtotal(this.subtotal);
/* 701:609 */       this.toBoleta.setTotal(this.total);
/* 702:610 */       this.toBoleta.setTipoDepago(this.cboPago.getSelectedItem().toString());
/* 703:611 */       this.toBoleta.setEstado("VENTA REALIZADA");
/* 704:612 */       this.toBoleta.setCodEmpleado(codigoEmpleado);
/* 705:613 */       this.toBoleta.setCodigoCliente(codigoCliente);
/* 706:    */       
/* 707:615 */       this.oBoleta.grabarFacturaVentas(this.toBoleta);
/* 708:616 */       System.out.println("Factura registrada");
/* 709:    */       
/* 710:618 */       producto_TO toProducto = new producto_TO();
/* 711:    */       
/* 712:    */ 
/* 713:    */ 
/* 714:    */ 
/* 715:623 */       String idFactura = this.oBoleta.obteneriIDfactura();
/* 716:624 */       int filas = this.tblBoleta.getRowCount();
/* 717:626 */       for (int i = 0; i < filas; i++)
/* 718:    */       {
/* 719:627 */         detalleventa_TO to = new detalleventa_TO();
/* 720:628 */         to.setCodfactura(idFactura);
/* 721:    */         
/* 722:630 */         this.rs = this.oProducto.obternerCodigo();
/* 723:631 */         while (this.rs.next()) {
/* 724:632 */           if (this.rs.getString(2).equals(this.tblBoleta.getValueAt(i, 1))) {
/* 725:633 */             to.setCodproducto(this.rs.getString(1));
/* 726:    */           }
/* 727:    */         }
/* 728:637 */         to.setPrecio(Double.parseDouble(this.tblBoleta.getValueAt(i, 3).toString()));
/* 729:638 */         to.setCantidad(Integer.parseInt(this.tblBoleta.getValueAt(i, 0).toString()));
/* 730:639 */         to.setImporte(Double.parseDouble(this.tblBoleta.getValueAt(i, 4).toString()));
/* 731:640 */         this.oDetalle.grabarDetalle(to);
/* 732:    */         
/* 733:    */ 
/* 734:643 */         int cantidadventa = Integer.parseInt(this.tblBoleta.getValueAt(i, 0).toString());
/* 735:644 */         toProducto.setCodigoProd(this.tblBoleta.getValueAt(i, 1).toString());
/* 736:645 */         this.oProducto.reduceProducto(cantidadventa, toProducto);
/* 737:    */       }
/* 738:648 */       JOptionPane.showMessageDialog(this.rootPane, "Venta registrada Correctamente   C:");
/* 739:649 */       muestraCodigoFactura();
/* 740:650 */       limpiacontroles();
/* 741:    */     }
/* 742:    */     catch (Exception e)
/* 743:    */     {
/* 744:654 */       System.out.println(e.getMessage() + "try c");
/* 745:    */     }
/* 746:    */   }
/* 747:    */   
/* 748:    */   private void txtCantidadKeyTyped(KeyEvent evt)
/* 749:    */   {
/* 750:660 */     char c = evt.getKeyChar();
/* 751:661 */     if ((c < '0') || (c > '9')) {
/* 752:662 */       evt.consume();
/* 753:    */     }
/* 754:    */   }
/* 755:    */   
/* 756:    */   private void txtDNIKeyTyped(KeyEvent evt)
/* 757:    */   {
/* 758:667 */     char c = evt.getKeyChar();
/* 759:668 */     if ((c < '0') || (c > '9')) {
/* 760:669 */       evt.consume();
/* 761:    */     }
/* 762:    */   }
/* 763:    */   
/* 764:    */   private void btnImprimirActionPerformed(ActionEvent evt)
/* 765:    */   {
/* 766:674 */     List lista = new ArrayList();
/* 767:675 */     for (int i = 0; i < this.tblBoleta.getRowCount(); i++)
/* 768:    */     {
/* 769:676 */       imprimirBoletaVenta listac = new imprimirBoletaVenta(Integer.parseInt(this.tblBoleta.getValueAt(i, 0).toString()), this.tblBoleta.getValueAt(i, 1).toString(), this.tblBoleta.getValueAt(i, 2).toString(), Double.parseDouble(this.tblBoleta.getValueAt(i, 3).toString()), Double.parseDouble(this.tblBoleta.getValueAt(i, 4).toString()));
/* 770:    */       
/* 771:    */ 
/* 772:    */ 
/* 773:    */ 
/* 774:    */ 
/* 775:    */ 
/* 776:683 */       lista.add(listac);
/* 777:    */     }
/* 778:    */     try
/* 779:    */     {
/* 780:686 */       JasperReport report = (JasperReport)JRLoader.loadObject("C:\\Ledatel\\reportes\\imprimirFacturaVenta.jasper");
/* 781:687 */       Map parametro = new HashMap();
/* 782:688 */       parametro.put("DNI", txtDNI.getText());
/* 783:689 */       parametro.put("Datos", txtDatos.getText());
/* 784:690 */       parametro.put("Direccion", txtDireccion.getText());
/* 785:691 */       parametro.put("IGV", this.txtIGV.getText());
/* 786:692 */       parametro.put("Subtotal", this.txtSubtotal.getText());
/* 787:693 */       parametro.put("Total", this.txtTotal.getText());
/* 788:694 */       parametro.put("FechaVenta", this.lblFecha.getText());
/* 789:695 */       parametro.put("RUC", this.txtRUC.getText());
/* 790:696 */       parametro.put("Boleta", this.txtBoleta.getText());
/* 791:697 */       JasperPrint print = JasperFillManager.fillReport(report, parametro, new JRBeanCollectionDataSource(lista));
/* 792:698 */       JasperViewer.viewReport(print, false);
/* 793:    */     }
/* 794:    */     catch (Exception e)
/* 795:    */     {
/* 796:701 */       System.out.println(e.getMessage());
/* 797:    */     }
/* 798:    */   }
/* 799:    */   
/* 800:    */   private void btnBuscarClienteActionPerformed(ActionEvent evt)
/* 801:    */   {
/* 802:706 */     clienteDesk g = new clienteDesk();
/* 803:707 */     VentanaPrincipalGUI.desk.add(g);
/* 804:708 */     g.show();
/* 805:    */   }
/* 806:    */   
/* 807:    */   private void calendario()
/* 808:    */   {
/* 809:760 */     Calendar cal1 = Calendar.getInstance();
/* 810:761 */     String mesInt = "";
/* 811:    */     
/* 812:763 */     int mes = cal1.get(2);
/* 813:764 */     int mesActual = mes + 1;
/* 814:765 */     if (mesActual < 9) {
/* 815:766 */       mesInt = "0" + mesActual + "/";
/* 816:    */     } else {
/* 817:768 */       mesInt = mesActual + "/";
/* 818:    */     }
/* 819:771 */     int dia = cal1.get(5);
/* 820:772 */     String diaInt = "";
/* 821:773 */     if (dia < 10) {
/* 822:774 */       diaInt = "0" + dia + "/";
/* 823:    */     } else {
/* 824:776 */       diaInt = dia + "/";
/* 825:    */     }
/* 826:778 */     int año = cal1.get(1);
/* 827:779 */     int añoAc = año - 2000;
/* 828:    */     
/* 829:781 */     this.lblFecha.setText("" + diaInt + mesInt + añoAc);
/* 830:    */   }
/* 831:    */   
/* 832:    */   private void limpiaControles()
/* 833:    */   {
/* 834:785 */     txtCantidad.setText(null);
/* 835:786 */     txtcod_prod.setText("");
/* 836:787 */     txtPrecio.setText(null);
/* 837:788 */     txtMarca_modelo.setText(null);
/* 838:789 */     txtMarca_modelo.grabFocus();
/* 839:    */   }
/* 840:    */   
/* 841:    */   private void calcularTotales()
/* 842:    */   {
/* 843:    */     try
/* 844:    */     {
/* 845:795 */       this.subtotal = 0.0D;
/* 846:796 */       this.igv = 0.0D;
/* 847:797 */       this.total = 0.0D;
/* 848:798 */       int filas = this.model.getRowCount();
/* 849:799 */       for (int i = 0; i < filas; i++) {
/* 850:800 */         this.total += Double.parseDouble(this.tblBoleta.getValueAt(i, 4).toString());
/* 851:    */       }
/* 852:802 */       this.igv = (this.total * 0.18D);
/* 853:803 */       this.subtotal = (this.total - this.igv);
/* 854:804 */       this.txtIGV.setText(String.format("%.2f", new Object[] { Double.valueOf(this.igv) }));
/* 855:805 */       this.txtSubtotal.setText(String.format("%.2f", new Object[] { Double.valueOf(this.subtotal) }));
/* 856:806 */       this.txtTotal.setText(String.valueOf(Math.round(this.total * 10.0D) / 10.0D));
/* 857:    */     }
/* 858:    */     catch (Exception e)
/* 859:    */     {
/* 860:808 */       System.out.println(e);
/* 861:    */     }
/* 862:    */   }
/* 863:    */   
/* 864:    */   private void muestraCodigoFactura()
/* 865:    */   {
/* 866:    */     try
/* 867:    */     {
/* 868:815 */       int codigoAnterior = 0;
/* 869:816 */       this.rs = this.oBoleta.codigoFacturaTop();
/* 870:817 */       while (this.rs.next())
/* 871:    */       {
/* 872:818 */         codigoAnterior = this.rs.getInt(1);
/* 873:819 */         this.txtRUC.setText(this.rs.getString(2));
/* 874:    */       }
/* 875:821 */       this.txtBoleta.setText("");
/* 876:822 */       int nuevoCodigo = codigoAnterior + 1;
/* 877:823 */       this.txtBoleta.setText(String.valueOf(nuevoCodigo));
/* 878:    */     }
/* 879:    */     catch (Exception e)
/* 880:    */     {
/* 881:825 */       System.out.println(e.getMessage());
/* 882:    */     }
/* 883:    */   }
/* 884:    */   
/* 885:    */   private void limpiacontroles()
/* 886:    */   {
/* 887:830 */     txtCantidad.setText("");
/* 888:831 */     txtcod_prod.setText("");
/* 889:832 */     txtDNI.setText("");
/* 890:833 */     this.txtImporte.setText("");
/* 891:834 */     txtPrecio.setText("");
/* 892:835 */     this.txtSubtotal.setText("");
/* 893:836 */     txtDatos.setText("");
/* 894:837 */     txtDireccion.setText("");
/* 895:838 */     this.txtPago.setText("");
/* 896:839 */     this.txtVuelto.setText("");
/* 897:840 */     this.btnImprimir.setEnabled(true);
/* 898:841 */     this.txtIGV.setText("");
/* 899:842 */     this.txtTotal.setText("");
/* 900:843 */     int filas = this.tblBoleta.getRowCount();
/* 901:844 */     for (int i = 0; filas > i; i++) {
/* 902:845 */       this.model.removeRow(0);
/* 903:    */     }
/* 904:    */   }
/* 905:    */ }



/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar

 * Qualified Name:     Desk.boletaDesk

 * JD-Core Version:    0.7.0.1

 */