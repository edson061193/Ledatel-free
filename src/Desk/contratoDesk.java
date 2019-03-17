/*   1:    */ package Desk;
/*   2:    */ 
/*   3:    */ import Dao.contratoDao;
/*   4:    */ import Dao.productoDao;
/*   5:    */ import Gui.VentanaPrincipalGUI;
/*   6:    */ import To.contratoTO;
/*   7:    */ import java.awt.Color;
/*   8:    */ import java.awt.Container;
/*   9:    */ import java.awt.Cursor;
/*  10:    */ import java.awt.Dimension;
/*  11:    */ import java.awt.Font;
/*  12:    */ import java.awt.event.ActionEvent;
/*  13:    */ import java.awt.event.ActionListener;
/*  14:    */ import java.io.PrintStream;
/*  15:    */ import java.sql.ResultSet;
/*  16:    */ import javax.swing.BorderFactory;
/*  17:    */ import javax.swing.GroupLayout;
/*  18:    */ import javax.swing.GroupLayout.Alignment;
/*  19:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  20:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  21:    */ import javax.swing.ImageIcon;
/*  22:    */ import javax.swing.JButton;
/*  23:    */ import javax.swing.JDesktopPane;
/*  24:    */ import javax.swing.JInternalFrame;
/*  25:    */ import javax.swing.JLabel;
/*  26:    */ import javax.swing.JOptionPane;
/*  27:    */ import javax.swing.JPanel;
/*  28:    */ import javax.swing.JScrollPane;
/*  29:    */ import javax.swing.JTabbedPane;
/*  30:    */ import javax.swing.JTable;
/*  31:    */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*  32:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  33:    */ import javax.swing.table.DefaultTableModel;
/*  34:    */ import javax.swing.table.TableColumn;
/*  35:    */ import javax.swing.table.TableColumnModel;
/*  36:    */ 
/*  37:    */ public class contratoDesk
/*  38:    */   extends JInternalFrame
/*  39:    */ {
/*  40:    */   DefaultTableModel model;
/*  41:    */   ResultSet result;
/*  42: 26 */   productoDao oProducto = new productoDao();
/*  43: 27 */   contratoDao oContrado = new contratoDao();
/*  44:    */   private JTable btlPagosPORrealizar;
/*  45:    */   private JButton btnAcreditar;
/*  46:    */   private JButton btnBuscar;
/*  47:    */   private JButton btnImprimir;
/*  48:    */   private JButton btnIr;
/*  49:    */   private JButton btnNuevo;
/*  50:    */   private JButton btnPagar;
/*  51:    */   private JLabel jLabel1;
/*  52:    */   private JLabel jLabel10;
/*  53:    */   private JLabel jLabel11;
/*  54:    */   private JLabel jLabel12;
/*  55:    */   private JLabel jLabel13;
/*  56:    */   private JLabel jLabel2;
/*  57:    */   private JLabel jLabel3;
/*  58:    */   private JLabel jLabel4;
/*  59:    */   private JLabel jLabel5;
/*  60:    */   private JLabel jLabel6;
/*  61:    */   private JLabel jLabel7;
/*  62:    */   private JLabel jLabel8;
/*  63:    */   private JLabel jLabel9;
/*  64:    */   private JPanel jPanel1;
/*  65:    */   private JPanel jPanel2;
/*  66:    */   private JPanel jPanel3;
/*  67:    */   private JScrollPane jScrollPane1;
/*  68:    */   private JScrollPane jScrollPane2;
/*  69:    */   private JScrollPane jScrollPane3;
/*  70:    */   private JScrollPane jScrollPane4;
/*  71:    */   private JScrollPane jScrollPane5;
/*  72:    */   private JTable jTable3;
/*  73:    */   private JTable tblPagosCancelados;
/*  74:    */   private JTable tblPagosRecientes;
/*  75:    */   private JTabbedPane tblPagosVencidos;
/*  76:    */   private JTable tblRegistro_contratos;
/*  77:    */   private JTextField txtBuscar;
/*  78:    */   public static JTextField txtCantidad;
/*  79:    */   public static JTextField txtCliente;
/*  80:    */   public static JTextField txtCodigo_producto;
/*  81:    */   public static JTextField txtDNI;
/*  82:    */   private JTextField txtFechaPagos;
/*  83:    */   private JTextField txtLetras;
/*  84:    */   public static JTextField txtMarca_serie;
/*  85:    */   private JTextField txtNuevoPrecio;
/*  86:    */   private JTextField txtPagos;
/*  87:    */   private JTextField txtPeriodo;
/*  88:    */   public static JTextField txtPrecio_contado;
/*  89:    */   private JTextField txtn_contrado;
/*  90:    */   
/*  91:    */   public contratoDesk()
/*  92:    */   {
/*  93: 30 */     initComponents();
/*  94: 31 */     cargaNumContrato();
/*  95: 32 */     cargaContratos();
/*  96:    */   }
/*  97:    */   
/*  98:    */   private void initComponents()
/*  99:    */   {
/* 100: 44 */     this.jPanel1 = new JPanel();
/* 101: 45 */     this.jPanel2 = new JPanel();
/* 102: 46 */     this.jLabel1 = new JLabel();
/* 103: 47 */     this.jLabel2 = new JLabel();
/* 104: 48 */     this.txtn_contrado = new JTextField();
/* 105: 49 */     txtCliente = new JTextField();
/* 106: 50 */     this.jLabel3 = new JLabel();
/* 107: 51 */     txtDNI = new JTextField();
/* 108: 52 */     this.btnIr = new JButton();
/* 109: 53 */     this.jPanel3 = new JPanel();
/* 110: 54 */     this.jLabel4 = new JLabel();
/* 111: 55 */     this.jLabel5 = new JLabel();
/* 112: 56 */     this.jLabel6 = new JLabel();
/* 113: 57 */     this.jLabel7 = new JLabel();
/* 114: 58 */     this.jLabel8 = new JLabel();
/* 115: 59 */     this.jLabel9 = new JLabel();
/* 116: 60 */     this.jLabel10 = new JLabel();
/* 117: 61 */     this.jLabel11 = new JLabel();
/* 118: 62 */     this.jLabel12 = new JLabel();
/* 119: 63 */     txtCodigo_producto = new JTextField();
/* 120: 64 */     txtMarca_serie = new JTextField();
/* 121: 65 */     txtCantidad = new JTextField();
/* 122: 66 */     txtPrecio_contado = new JTextField();
/* 123: 67 */     this.txtNuevoPrecio = new JTextField();
/* 124: 68 */     this.txtPeriodo = new JTextField();
/* 125: 69 */     this.txtPagos = new JTextField();
/* 126: 70 */     this.txtLetras = new JTextField();
/* 127: 71 */     this.txtFechaPagos = new JTextField();
/* 128: 72 */     this.btnNuevo = new JButton();
/* 129: 73 */     this.btnBuscar = new JButton();
/* 130: 74 */     this.btnAcreditar = new JButton();
/* 131: 75 */     this.jLabel13 = new JLabel();
/* 132: 76 */     this.txtBuscar = new JTextField();
/* 133: 77 */     this.tblPagosVencidos = new JTabbedPane();
/* 134: 78 */     this.jScrollPane1 = new JScrollPane();
/* 135: 79 */     this.tblPagosRecientes = new JTable();
/* 136: 80 */     this.jScrollPane2 = new JScrollPane();
/* 137: 81 */     this.btlPagosPORrealizar = new JTable();
/* 138: 82 */     this.jScrollPane3 = new JScrollPane();
/* 139: 83 */     this.jTable3 = new JTable();
/* 140: 84 */     this.jScrollPane4 = new JScrollPane();
/* 141: 85 */     this.tblPagosCancelados = new JTable();
/* 142: 86 */     this.jScrollPane5 = new JScrollPane();
/* 143: 87 */     this.tblRegistro_contratos = new JTable();
/* 144: 88 */     this.btnPagar = new JButton();
/* 145: 89 */     this.btnImprimir = new JButton();
/* 146:    */     
/* 147: 91 */     setClosable(true);
/* 148: 92 */     setMaximizable(true);
/* 149: 93 */     setFrameIcon(new ImageIcon(getClass().getResource("/Fondos/ld.png")));
/* 150: 94 */     setMinimumSize(new Dimension(1350, 620));
/* 151: 95 */     setPreferredSize(new Dimension(1350, 620));
/* 152:    */     
/* 153: 97 */     this.jPanel1.setBackground(new Color(153, 153, 153));
/* 154:    */     
/* 155: 99 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/* 156:    */     
/* 157:101 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 158:102 */     this.jPanel2.setLayout(jPanel2Layout);
/* 159:103 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
/* 160:    */     
/* 161:    */ 
/* 162:    */ 
/* 163:107 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 25, 32767));
/* 164:    */     
/* 165:    */ 
/* 166:    */ 
/* 167:    */ 
/* 168:112 */     this.jLabel1.setFont(new Font("sansserif", 3, 14));
/* 169:113 */     this.jLabel1.setForeground(new Color(255, 255, 255));
/* 170:114 */     this.jLabel1.setText("Numero de contrado:");
/* 171:    */     
/* 172:116 */     this.jLabel2.setFont(new Font("sansserif", 3, 14));
/* 173:117 */     this.jLabel2.setForeground(new Color(255, 255, 255));
/* 174:118 */     this.jLabel2.setText("Cliente :");
/* 175:    */     
/* 176:120 */     this.txtn_contrado.setFont(new Font("Aharoni", 1, 48));
/* 177:121 */     this.txtn_contrado.setForeground(new Color(153, 0, 51));
/* 178:122 */     this.txtn_contrado.setHorizontalAlignment(0);
/* 179:123 */     this.txtn_contrado.setText("00");
/* 180:124 */     this.txtn_contrado.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 181:125 */     this.txtn_contrado.setOpaque(false);
/* 182:    */     
/* 183:127 */     txtCliente.setEditable(false);
/* 184:128 */     txtCliente.setFont(new Font("sansserif", 0, 14));
/* 185:129 */     txtCliente.setForeground(new Color(0, 0, 204));
/* 186:130 */     txtCliente.setHorizontalAlignment(0);
/* 187:131 */     txtCliente.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 188:    */     
/* 189:133 */     this.jLabel3.setFont(new Font("sansserif", 3, 14));
/* 190:134 */     this.jLabel3.setForeground(new Color(255, 255, 255));
/* 191:135 */     this.jLabel3.setText("DNI:");
/* 192:    */     
/* 193:137 */     txtDNI.setEditable(false);
/* 194:138 */     txtDNI.setFont(new Font("sansserif", 0, 14));
/* 195:139 */     txtDNI.setForeground(new Color(0, 0, 204));
/* 196:140 */     txtDNI.setHorizontalAlignment(0);
/* 197:141 */     txtDNI.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 198:    */     
/* 199:143 */     this.btnIr.setIcon(new ImageIcon(getClass().getResource("/Iconos/ADD.PNG")));
/* 200:144 */     this.btnIr.setContentAreaFilled(false);
/* 201:145 */     this.btnIr.addActionListener(new ActionListener()
/* 202:    */     {
/* 203:    */       public void actionPerformed(ActionEvent evt)
/* 204:    */       {
/* 205:147 */         contratoDesk.this.btnIrActionPerformed(evt);
/* 206:    */       }
/* 207:150 */     });
/* 208:151 */     this.jPanel3.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2));
/* 209:152 */     this.jPanel3.setOpaque(false);
/* 210:    */     
/* 211:154 */     this.jLabel4.setFont(new Font("sansserif", 3, 14));
/* 212:155 */     this.jLabel4.setForeground(new Color(255, 255, 255));
/* 213:156 */     this.jLabel4.setText("codigo producto:");
/* 214:    */     
/* 215:158 */     this.jLabel5.setFont(new Font("sansserif", 3, 14));
/* 216:159 */     this.jLabel5.setForeground(new Color(255, 255, 255));
/* 217:160 */     this.jLabel5.setText("marca/ serie :");
/* 218:    */     
/* 219:162 */     this.jLabel6.setFont(new Font("sansserif", 3, 14));
/* 220:163 */     this.jLabel6.setForeground(new Color(255, 255, 255));
/* 221:164 */     this.jLabel6.setText("cantidad:");
/* 222:    */     
/* 223:166 */     this.jLabel7.setFont(new Font("sansserif", 3, 14));
/* 224:167 */     this.jLabel7.setForeground(new Color(255, 255, 255));
/* 225:168 */     this.jLabel7.setText("precio al contado:");
/* 226:    */     
/* 227:170 */     this.jLabel8.setFont(new Font("sansserif", 3, 14));
/* 228:171 */     this.jLabel8.setForeground(new Color(255, 255, 255));
/* 229:172 */     this.jLabel8.setText("nuevo precio:");
/* 230:    */     
/* 231:174 */     this.jLabel9.setFont(new Font("sansserif", 3, 14));
/* 232:175 */     this.jLabel9.setForeground(new Color(255, 255, 255));
/* 233:176 */     this.jLabel9.setText("periodo:");
/* 234:    */     
/* 235:178 */     this.jLabel10.setFont(new Font("sansserif", 3, 14));
/* 236:179 */     this.jLabel10.setForeground(new Color(255, 255, 255));
/* 237:180 */     this.jLabel10.setText("pagos :");
/* 238:    */     
/* 239:182 */     this.jLabel11.setFont(new Font("sansserif", 3, 14));
/* 240:183 */     this.jLabel11.setForeground(new Color(255, 255, 255));
/* 241:184 */     this.jLabel11.setText("letras:");
/* 242:    */     
/* 243:186 */     this.jLabel12.setText("fecha de pagos:");
/* 244:    */     
/* 245:188 */     txtCodigo_producto.setEditable(false);
/* 246:189 */     txtCodigo_producto.setFont(new Font("sansserif", 0, 14));
/* 247:190 */     txtCodigo_producto.setForeground(new Color(0, 0, 204));
/* 248:191 */     txtCodigo_producto.setHorizontalAlignment(0);
/* 249:192 */     txtCodigo_producto.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 250:    */     
/* 251:194 */     txtMarca_serie.setEditable(false);
/* 252:195 */     txtMarca_serie.setFont(new Font("sansserif", 0, 14));
/* 253:196 */     txtMarca_serie.setForeground(new Color(0, 0, 204));
/* 254:197 */     txtMarca_serie.setHorizontalAlignment(0);
/* 255:198 */     txtMarca_serie.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 256:    */     
/* 257:200 */     txtCantidad.setEditable(false);
/* 258:201 */     txtCantidad.setFont(new Font("sansserif", 0, 14));
/* 259:202 */     txtCantidad.setForeground(new Color(0, 0, 204));
/* 260:203 */     txtCantidad.setHorizontalAlignment(0);
/* 261:204 */     txtCantidad.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 262:    */     
/* 263:206 */     txtPrecio_contado.setEditable(false);
/* 264:207 */     txtPrecio_contado.setFont(new Font("sansserif", 0, 14));
/* 265:208 */     txtPrecio_contado.setForeground(new Color(0, 0, 204));
/* 266:209 */     txtPrecio_contado.setHorizontalAlignment(0);
/* 267:210 */     txtPrecio_contado.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 268:    */     
/* 269:212 */     this.txtNuevoPrecio.setFont(new Font("sansserif", 0, 14));
/* 270:213 */     this.txtNuevoPrecio.setForeground(new Color(0, 0, 204));
/* 271:214 */     this.txtNuevoPrecio.setHorizontalAlignment(0);
/* 272:215 */     this.txtNuevoPrecio.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 273:    */     
/* 274:217 */     this.txtPeriodo.setFont(new Font("sansserif", 0, 14));
/* 275:218 */     this.txtPeriodo.setForeground(new Color(0, 0, 204));
/* 276:219 */     this.txtPeriodo.setHorizontalAlignment(0);
/* 277:220 */     this.txtPeriodo.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 278:    */     
/* 279:222 */     this.txtPagos.setFont(new Font("sansserif", 0, 14));
/* 280:223 */     this.txtPagos.setForeground(new Color(0, 0, 204));
/* 281:224 */     this.txtPagos.setHorizontalAlignment(0);
/* 282:225 */     this.txtPagos.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 283:    */     
/* 284:227 */     this.txtLetras.setFont(new Font("sansserif", 0, 14));
/* 285:228 */     this.txtLetras.setForeground(new Color(0, 0, 204));
/* 286:229 */     this.txtLetras.setHorizontalAlignment(0);
/* 287:230 */     this.txtLetras.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 288:    */     
/* 289:232 */     this.txtFechaPagos.setFont(new Font("sansserif", 0, 14));
/* 290:233 */     this.txtFechaPagos.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new ImageIcon(getClass().getResource("/icon/Calendar_black-32.png"))));
/* 291:    */     
/* 292:235 */     this.btnNuevo.setBackground(new Color(153, 153, 255));
/* 293:236 */     this.btnNuevo.setIcon(new ImageIcon(getClass().getResource("/Iconos/NUEVO.PNG")));
/* 294:237 */     this.btnNuevo.setText("N U E V O");
/* 295:238 */     this.btnNuevo.addActionListener(new ActionListener()
/* 296:    */     {
/* 297:    */       public void actionPerformed(ActionEvent evt)
/* 298:    */       {
/* 299:240 */         contratoDesk.this.btnNuevoActionPerformed(evt);
/* 300:    */       }
/* 301:243 */     });
/* 302:244 */     this.btnBuscar.setBackground(new Color(153, 153, 255));
/* 303:245 */     this.btnBuscar.setIcon(new ImageIcon(getClass().getResource("/icon/search-32.png")));
/* 304:246 */     this.btnBuscar.setText("B U S C A R");
/* 305:247 */     this.btnBuscar.addActionListener(new ActionListener()
/* 306:    */     {
/* 307:    */       public void actionPerformed(ActionEvent evt)
/* 308:    */       {
/* 309:249 */         contratoDesk.this.btnBuscarActionPerformed(evt);
/* 310:    */       }
/* 311:252 */     });
/* 312:253 */     this.btnAcreditar.setBackground(new Color(153, 153, 255));
/* 313:254 */     this.btnAcreditar.setIcon(new ImageIcon(getClass().getResource("/icon/Profile_black-32.png")));
/* 314:255 */     this.btnAcreditar.setText("A C R E D I T A R");
/* 315:256 */     this.btnAcreditar.addActionListener(new ActionListener()
/* 316:    */     {
/* 317:    */       public void actionPerformed(ActionEvent evt)
/* 318:    */       {
/* 319:258 */         contratoDesk.this.btnAcreditarActionPerformed(evt);
/* 320:    */       }
/* 321:261 */     });
/* 322:262 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 323:263 */     this.jPanel3.setLayout(jPanel3Layout);
/* 324:264 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel4).addComponent(this.jLabel5).addComponent(this.jLabel6)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(txtCodigo_producto, -1, 166, 32767).addComponent(txtMarca_serie).addComponent(txtCantidad))).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel7).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(txtPrecio_contado, -1, 164, 32767))).addGap(184, 184, 184).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel8).addComponent(this.jLabel9).addComponent(this.jLabel10).addComponent(this.jLabel11)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtNuevoPrecio).addComponent(this.txtPeriodo).addComponent(this.txtPagos, -1, 193, 32767).addComponent(this.txtLetras)).addGap(32, 32, 32).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnNuevo, -1, -1, 32767).addComponent(this.btnBuscar, -1, -1, 32767).addComponent(this.btnAcreditar, -1, -1, 32767))).addGroup(jPanel3Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jLabel12).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtFechaPagos, -2, 123, -2))).addContainerGap()));
/* 325:    */     
/* 326:    */ 
/* 327:    */ 
/* 328:    */ 
/* 329:    */ 
/* 330:    */ 
/* 331:    */ 
/* 332:    */ 
/* 333:    */ 
/* 334:    */ 
/* 335:    */ 
/* 336:    */ 
/* 337:    */ 
/* 338:    */ 
/* 339:    */ 
/* 340:    */ 
/* 341:    */ 
/* 342:    */ 
/* 343:    */ 
/* 344:    */ 
/* 345:    */ 
/* 346:    */ 
/* 347:    */ 
/* 348:    */ 
/* 349:    */ 
/* 350:    */ 
/* 351:    */ 
/* 352:    */ 
/* 353:    */ 
/* 354:    */ 
/* 355:    */ 
/* 356:    */ 
/* 357:    */ 
/* 358:    */ 
/* 359:    */ 
/* 360:    */ 
/* 361:    */ 
/* 362:    */ 
/* 363:    */ 
/* 364:    */ 
/* 365:    */ 
/* 366:    */ 
/* 367:    */ 
/* 368:    */ 
/* 369:309 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel11).addComponent(this.txtLetras, -2, -1, -2)).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(txtCodigo_producto, -2, -1, -2).addComponent(this.jLabel8).addComponent(this.txtNuevoPrecio, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(txtMarca_serie, -2, -1, -2).addComponent(this.jLabel9).addComponent(this.txtPeriodo, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6).addComponent(txtCantidad, -2, -1, -2).addComponent(this.jLabel10).addComponent(this.txtPagos, -2, -1, -2)).addGap(26, 26, 26).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(txtPrecio_contado, -2, -1, -2).addComponent(this.jLabel7))).addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup().addComponent(this.btnNuevo, -2, 54, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnBuscar, -2, 51, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnAcreditar, -1, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel12).addComponent(this.txtFechaPagos, -2, 20, -2)).addContainerGap()));
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
/* 384:    */ 
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
/* 403:    */ 
/* 404:    */ 
/* 405:    */ 
/* 406:    */ 
/* 407:    */ 
/* 408:    */ 
/* 409:    */ 
/* 410:    */ 
/* 411:    */ 
/* 412:352 */     this.jLabel13.setFont(new Font("DotumChe", 3, 14));
/* 413:353 */     this.jLabel13.setForeground(new Color(204, 255, 0));
/* 414:354 */     this.jLabel13.setText("FILTRAR DATOS :");
/* 415:    */     
/* 416:356 */     this.txtBuscar.setFont(new Font("sansserif", 2, 14));
/* 417:357 */     this.txtBuscar.setForeground(new Color(0, 0, 102));
/* 418:358 */     this.txtBuscar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 419:    */     
/* 420:360 */     this.tblPagosVencidos.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(204, 255, 204)), BorderFactory.createLineBorder(new Color(204, 255, 204))));
/* 421:361 */     this.tblPagosVencidos.setTabLayoutPolicy(1);
/* 422:362 */     this.tblPagosVencidos.setAlignmentX(0.0F);
/* 423:363 */     this.tblPagosVencidos.setAlignmentY(0.0F);
/* 424:364 */     this.tblPagosVencidos.setCursor(new Cursor(12));
/* 425:365 */     this.tblPagosVencidos.setFocusable(false);
/* 426:366 */     this.tblPagosVencidos.setFont(new Font("sansserif", 3, 14));
/* 427:    */     
/* 428:368 */     this.tblPagosRecientes.setModel(new DefaultTableModel(new Object[0][], new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/* 429:    */     
/* 430:    */ 
/* 431:    */ 
/* 432:    */ 
/* 433:    */ 
/* 434:    */ 
/* 435:    */ 
/* 436:376 */     this.jScrollPane1.setViewportView(this.tblPagosRecientes);
/* 437:    */     
/* 438:378 */     this.tblPagosVencidos.addTab("Pagos Recientes", this.jScrollPane1);
/* 439:    */     
/* 440:380 */     this.btlPagosPORrealizar.setModel(new DefaultTableModel(new Object[0][], new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/* 441:    */     
/* 442:    */ 
/* 443:    */ 
/* 444:    */ 
/* 445:    */ 
/* 446:    */ 
/* 447:    */ 
/* 448:388 */     this.jScrollPane2.setViewportView(this.btlPagosPORrealizar);
/* 449:    */     
/* 450:390 */     this.tblPagosVencidos.addTab("Pagos por Realizar", this.jScrollPane2);
/* 451:    */     
/* 452:392 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/* 453:    */     
/* 454:    */ 
/* 455:    */ 
/* 456:    */ 
/* 457:    */ 
/* 458:    */ 
/* 459:    */ 
/* 460:400 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 461:    */     
/* 462:402 */     this.tblPagosVencidos.addTab("Pagos vencidos", this.jScrollPane3);
/* 463:    */     
/* 464:404 */     this.tblPagosCancelados.setModel(new DefaultTableModel(new Object[0][], new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/* 465:    */     
/* 466:    */ 
/* 467:    */ 
/* 468:    */ 
/* 469:    */ 
/* 470:    */ 
/* 471:    */ 
/* 472:412 */     this.jScrollPane4.setViewportView(this.tblPagosCancelados);
/* 473:    */     
/* 474:414 */     this.tblPagosVencidos.addTab("Pagos completos", this.jScrollPane4);
/* 475:    */     
/* 476:416 */     this.tblRegistro_contratos.setModel(new DefaultTableModel(new Object[0][], new String[] { "num° Contrato", "DNI Cliente", "Datos", "Codigo Producto", "Marca", "Serie" })
/* 477:    */     {
/* 478:424 */       boolean[] canEdit = { false, false, false, false, false, false };
/* 479:    */       
/* 480:    */       public boolean isCellEditable(int rowIndex, int columnIndex)
/* 481:    */       {
/* 482:429 */         return this.canEdit[columnIndex];
/* 483:    */       }
/* 484:431 */     });
/* 485:432 */     this.jScrollPane5.setViewportView(this.tblRegistro_contratos);
/* 486:433 */     if (this.tblRegistro_contratos.getColumnModel().getColumnCount() > 0)
/* 487:    */     {
/* 488:434 */       this.tblRegistro_contratos.getColumnModel().getColumn(0).setMinWidth(60);
/* 489:435 */       this.tblRegistro_contratos.getColumnModel().getColumn(0).setPreferredWidth(60);
/* 490:436 */       this.tblRegistro_contratos.getColumnModel().getColumn(0).setMaxWidth(60);
/* 491:437 */       this.tblRegistro_contratos.getColumnModel().getColumn(1).setMinWidth(80);
/* 492:438 */       this.tblRegistro_contratos.getColumnModel().getColumn(1).setPreferredWidth(80);
/* 493:439 */       this.tblRegistro_contratos.getColumnModel().getColumn(1).setMaxWidth(80);
/* 494:440 */       this.tblRegistro_contratos.getColumnModel().getColumn(3).setMinWidth(80);
/* 495:441 */       this.tblRegistro_contratos.getColumnModel().getColumn(3).setPreferredWidth(80);
/* 496:442 */       this.tblRegistro_contratos.getColumnModel().getColumn(3).setMaxWidth(80);
/* 497:443 */       this.tblRegistro_contratos.getColumnModel().getColumn(4).setMinWidth(80);
/* 498:444 */       this.tblRegistro_contratos.getColumnModel().getColumn(4).setPreferredWidth(80);
/* 499:445 */       this.tblRegistro_contratos.getColumnModel().getColumn(4).setMaxWidth(80);
/* 500:446 */       this.tblRegistro_contratos.getColumnModel().getColumn(5).setMinWidth(80);
/* 501:447 */       this.tblRegistro_contratos.getColumnModel().getColumn(5).setPreferredWidth(80);
/* 502:448 */       this.tblRegistro_contratos.getColumnModel().getColumn(5).setMaxWidth(80);
/* 503:    */     }
/* 504:451 */     this.tblPagosVencidos.addTab("Contratos", this.jScrollPane5);
/* 505:    */     
/* 506:453 */     this.btnPagar.setIcon(new ImageIcon(getClass().getResource("/icon/Money.png")));
/* 507:454 */     this.btnPagar.setText("P a g a r");
/* 508:    */     
/* 509:456 */     this.btnImprimir.setIcon(new ImageIcon(getClass().getResource("/icon/print-32.png")));
/* 510:457 */     this.btnImprimir.setText("I m p r i m i r");
/* 511:    */     
/* 512:459 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 513:460 */     this.jPanel1.setLayout(jPanel1Layout);
/* 514:461 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel13).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtBuscar, -2, 240, -2).addGap(55, 55, 55).addComponent(this.btnPagar, -2, 139, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnImprimir)).addComponent(this.jPanel3, -2, -1, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtn_contrado, -2, 92, -2).addGap(33, 33, 33).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(txtCliente, -2, 248, -2).addGap(43, 43, 43).addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(txtDNI, -2, 224, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnIr, -2, 34, -2)))).addGroup(jPanel1Layout.createSequentialGroup().addGap(123, 123, 123).addComponent(this.tblPagosVencidos, -2, 1015, -2))).addContainerGap(193, 32767)));
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
/* 529:    */ 
/* 530:    */ 
/* 531:    */ 
/* 532:    */ 
/* 533:    */ 
/* 534:    */ 
/* 535:    */ 
/* 536:    */ 
/* 537:    */ 
/* 538:    */ 
/* 539:    */ 
/* 540:    */ 
/* 541:    */ 
/* 542:    */ 
/* 543:    */ 
/* 544:    */ 
/* 545:    */ 
/* 546:    */ 
/* 547:    */ 
/* 548:    */ 
/* 549:    */ 
/* 550:497 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1).addGap(8, 8, 8).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(txtCliente, -2, -1, -2).addComponent(this.jLabel2).addComponent(this.jLabel3).addComponent(txtDNI, -2, -1, -2))).addComponent(this.txtn_contrado, -2, -1, -2).addComponent(this.btnIr, GroupLayout.Alignment.TRAILING)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE, false).addComponent(this.jLabel13).addComponent(this.txtBuscar, -2, -1, -2).addComponent(this.btnImprimir, -1, -1, 32767).addComponent(this.btnPagar, -2, 0, 32767)).addGap(18, 24, 32767).addComponent(this.tblPagosVencidos, -2, 289, -2).addGap(54, 54, 54)));
/* 551:    */     
/* 552:    */ 
/* 553:    */ 
/* 554:    */ 
/* 555:    */ 
/* 556:    */ 
/* 557:    */ 
/* 558:    */ 
/* 559:    */ 
/* 560:    */ 
/* 561:    */ 
/* 562:    */ 
/* 563:    */ 
/* 564:    */ 
/* 565:    */ 
/* 566:    */ 
/* 567:    */ 
/* 568:    */ 
/* 569:    */ 
/* 570:    */ 
/* 571:    */ 
/* 572:    */ 
/* 573:    */ 
/* 574:    */ 
/* 575:    */ 
/* 576:    */ 
/* 577:    */ 
/* 578:    */ 
/* 579:526 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 580:527 */     getContentPane().setLayout(layout);
/* 581:528 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/* 582:    */     
/* 583:    */ 
/* 584:    */ 
/* 585:532 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2));
/* 586:    */     
/* 587:    */ 
/* 588:    */ 
/* 589:    */ 
/* 590:537 */     pack();
/* 591:    */   }
/* 592:    */   
/* 593:    */   private void btnIrActionPerformed(ActionEvent evt)
/* 594:    */   {
/* 595:541 */     clienteDesk g = new clienteDesk();
/* 596:542 */     VentanaPrincipalGUI.desk.add(g);
/* 597:543 */     g.show();
/* 598:    */   }
/* 599:    */   
/* 600:    */   private void btnNuevoActionPerformed(ActionEvent evt) {}
/* 601:    */   
/* 602:    */   private void btnBuscarActionPerformed(ActionEvent evt)
/* 603:    */   {
/* 604:551 */     productoDesk g = new productoDesk();
/* 605:552 */     VentanaPrincipalGUI.desk.add(g);
/* 606:553 */     g.show();
/* 607:    */   }
/* 608:    */   
/* 609:    */   private void btnAcreditarActionPerformed(ActionEvent evt)
/* 610:    */   {
/* 611:557 */     String codigoCliente = "";
/* 612:558 */     String codigoProducto = "";
/* 613:559 */     contratoTO to = new contratoTO();
/* 614:    */     try
/* 615:    */     {
/* 616:561 */       to.setCodContrado(this.txtn_contrado.getText());
/* 617:562 */       codigoCliente = obtenerCodigo_cliente();
/* 618:563 */       to.setCodigocliente(codigoCliente);
/* 619:564 */       codigoProducto = obtenerCodigo_producto();
/* 620:565 */       to.setCodigoRegP(codigoProducto);
/* 621:    */       
/* 622:567 */       to.setCantidad(Integer.parseInt(txtCantidad.getText()));
/* 623:568 */       to.setPrecioActual(Double.parseDouble(txtPrecio_contado.getText()));
/* 624:569 */       to.setPrecioNuevo(Double.parseDouble(this.txtNuevoPrecio.getText()));
/* 625:570 */       to.setPeriodo(Integer.parseInt(this.txtPeriodo.getText()));
/* 626:571 */       to.setPago(Double.parseDouble(this.txtPagos.getText()));
/* 627:572 */       to.setLetra(Integer.parseInt(this.txtLetras.getText()));
/* 628:573 */       to.setFechapagos(this.txtFechaPagos.getText());
/* 629:574 */       this.oContrado.RegistrarCredito(to);
/* 630:    */       
/* 631:    */ 
/* 632:577 */       cargaNumContrato();
/* 633:578 */       limpiaControles();
/* 634:    */       
/* 635:580 */       cargaContratos();
/* 636:    */       
/* 637:582 */       JOptionPane.showMessageDialog(this.rootPane, "Credito registrado correctamente... ");
/* 638:    */     }
/* 639:    */     catch (Exception e)
/* 640:    */     {
/* 641:584 */       System.out.println(e);
/* 642:    */     }
/* 643:    */   }
/* 644:    */   
/* 645:    */   private String obtenerCodigo_cliente()
/* 646:    */   {
/* 647:640 */     String codigoCliente = null;
/* 648:    */     try
/* 649:    */     {
/* 650:643 */       this.result = this.oContrado.validarCliente();
/* 651:644 */       while (this.result.next()) {
/* 652:645 */         if (this.result.getString(3).equals(txtDNI.getText())) {
/* 653:646 */           codigoCliente = this.result.getString(1);
/* 654:    */         }
/* 655:    */       }
/* 656:    */     }
/* 657:    */     catch (Exception e) {}
/* 658:651 */     return codigoCliente;
/* 659:    */   }
/* 660:    */   
/* 661:    */   private String obtenerCodigo_producto()
/* 662:    */   {
/* 663:655 */     String codigoProducto = "";
/* 664:    */     try
/* 665:    */     {
/* 666:657 */       this.result = this.oContrado.validarProducto();
/* 667:658 */       while (this.result.next()) {
/* 668:659 */         if (this.result.getString(4).equals(txtCodigo_producto.getText())) {
/* 669:660 */           codigoProducto = this.result.getString(1);
/* 670:    */         }
/* 671:    */       }
/* 672:    */     }
/* 673:    */     catch (Exception e) {}
/* 674:666 */     return codigoProducto;
/* 675:    */   }
/* 676:    */   
/* 677:    */   private void cargaNumContrato()
/* 678:    */   {
/* 679:    */     try
/* 680:    */     {
/* 681:671 */       this.result = this.oContrado.devuelveNumContrato();
/* 682:672 */       while (this.result.next())
/* 683:    */       {
/* 684:673 */         int n = this.result.getInt(1);
/* 685:674 */         int nA = n + 1;
/* 686:675 */         this.txtn_contrado.setText(String.valueOf(nA));
/* 687:    */       }
/* 688:    */     }
/* 689:    */     catch (Exception e) {}
/* 690:    */   }
/* 691:    */   
/* 692:    */   private void limpiaControles()
/* 693:    */   {
/* 694:682 */     JTextField[] field = { txtCantidad, txtCliente, txtCodigo_producto, txtDNI, this.txtFechaPagos, this.txtLetras, txtMarca_serie, this.txtNuevoPrecio, this.txtPagos, this.txtPeriodo, txtPrecio_contado };
/* 695:686 */     for (JTextField txt : field) {
/* 696:687 */       txt.setText("");
/* 697:    */     }
/* 698:    */   }
/* 699:    */   
/* 700:    */   private void cargaContratos()
/* 701:    */   {
/* 702:692 */     this.model = ((DefaultTableModel)this.tblRegistro_contratos.getModel());
/* 703:    */     try
/* 704:    */     {
/* 705:694 */       this.result = this.oContrado.cargaRegistros_Contrato();
/* 706:695 */       while (this.result.next())
/* 707:    */       {
/* 708:696 */         Object[] registros = { this.result.getString(1), this.result.getString(2), this.result.getString(3), this.result.getString(4), this.result.getString(5), this.result.getString(6) };
/* 709:    */         
/* 710:    */ 
/* 711:    */ 
/* 712:    */ 
/* 713:    */ 
/* 714:    */ 
/* 715:    */ 
/* 716:704 */         this.model.addRow(registros);
/* 717:    */       }
/* 718:    */     }
/* 719:    */     catch (Exception e) {}
/* 720:    */   }
/* 721:    */ }



/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar

 * Qualified Name:     Desk.contratoDesk

 * JD-Core Version:    0.7.0.1

 */