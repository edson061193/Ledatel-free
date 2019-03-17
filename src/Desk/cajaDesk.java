/*   1:    */ package Desk;
/*   2:    */ 
/*   3:    */ import Dao.boletaDao;
/*   4:    */ import Dao.cajeroDao;
/*   5:    */ import Gui.VentanaPrincipalGUI;
/*   6:    */ import Log_Reporte.reporte_cajaCompras;
/*   7:    */ import Log_Reporte.reporte_cajaReparaciones;
/*   8:    */ import Log_Reporte.reporte_cajaVentas;
/*   9:    */ import To.cajero_TO;
/*  10:    */ import java.awt.Color;
/*  11:    */ import java.awt.Container;
/*  12:    */ import java.awt.Dimension;
/*  13:    */ import java.awt.Font;
/*  14:    */ import java.awt.event.ActionEvent;
/*  15:    */ import java.awt.event.ActionListener;
/*  16:    */ import java.awt.event.MouseAdapter;
/*  17:    */ import java.awt.event.MouseEvent;
/*  18:    */ import java.io.PrintStream;
/*  19:    */ import java.sql.ResultSet;
/*  20:    */ import java.util.ArrayList;
/*  21:    */ import java.util.Calendar;
/*  22:    */ import java.util.HashMap;
/*  23:    */ import java.util.List;
/*  24:    */ import java.util.Map;
/*  25:    */ import javax.swing.BorderFactory;
/*  26:    */ import javax.swing.ButtonGroup;
/*  27:    */ import javax.swing.GroupLayout;
/*  28:    */ import javax.swing.GroupLayout.Alignment;
/*  29:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  30:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  31:    */ import javax.swing.ImageIcon;
/*  32:    */ import javax.swing.JButton;
/*  33:    */ import javax.swing.JInternalFrame;
/*  34:    */ import javax.swing.JLabel;
/*  35:    */ import javax.swing.JOptionPane;
/*  36:    */ import javax.swing.JPanel;
/*  37:    */ import javax.swing.JRadioButton;
/*  38:    */ import javax.swing.JScrollPane;
/*  39:    */ import javax.swing.JTabbedPane;
/*  40:    */ import javax.swing.JTable;
/*  41:    */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*  42:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  43:    */ import javax.swing.table.DefaultTableModel;
/*  44:    */ import javax.swing.table.TableColumn;
/*  45:    */ import javax.swing.table.TableColumnModel;
/*  46:    */ import net.sf.jasperreports.engine.JasperFillManager;
/*  47:    */ import net.sf.jasperreports.engine.JasperPrint;
/*  48:    */ import net.sf.jasperreports.engine.JasperReport;
/*  49:    */ import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
/*  50:    */ import net.sf.jasperreports.engine.util.JRLoader;
/*  51:    */ import net.sf.jasperreports.view.JasperViewer;
/*  52:    */ 
/*  53:    */ public class cajaDesk
/*  54:    */   extends JInternalFrame
/*  55:    */ {
/*  56: 32 */   public static cajaDesk fromCaja = null;
/*  57:    */   DefaultTableModel model;
/*  58: 41 */   boletaDao oBoleta = new boletaDao();
/*  59:    */   String fechaIcinio;
/*  60: 45 */   cajeroDao oCajero = new cajeroDao();
/*  61:    */   ResultSet rs0;
/*  62:    */   ResultSet rs1;
/*  63:    */   ResultSet rs2;
/*  64:    */   ResultSet rsFecha;
/*  65:    */   private JButton btnAbrir;
/*  66:    */   private JButton btnCalcular;
/*  67:    */   private JButton btnCerrar;
/*  68:    */   private JButton btnImprimir;
/*  69:    */   private ButtonGroup btngImprimir;
/*  70:    */   private JButton jButton1;
/*  71:    */   private JLabel jLabel2;
/*  72:    */   private JLabel jLabel3;
/*  73:    */   private JLabel jLabel4;
/*  74:    */   private JLabel jLabel5;
/*  75:    */   private JLabel jLabel6;
/*  76:    */   private JLabel jLabel8;
/*  77:    */   private JPanel jPanel1;
/*  78:    */   private JPanel jPanel2;
/*  79:    */   private JScrollPane jScrollPane1;
/*  80:    */   private JScrollPane jScrollPane2;
/*  81:    */   private JScrollPane jScrollPane3;
/*  82:    */   private JTabbedPane jTabbedPane1;
/*  83:    */   private JLabel lblFechaActual;
/*  84:    */   private JRadioButton rdCompras;
/*  85:    */   private JRadioButton rdReparaciones;
/*  86:    */   private JRadioButton rdVentas;
/*  87:    */   private JTable tblRegistroDeCompas;
/*  88:    */   private JTable tblRegistroVentas;
/*  89:    */   private JTable tblRegistro_reparaciones;
/*  90:    */   private JTextField txtCompras;
/*  91:    */   private JTextField txtInicio;
/*  92:    */   private JTextField txtReparaciones;
/*  93:    */   private JTextField txtTotal;
/*  94:    */   private JTextField txtVentas;
/*  95:    */   
/*  96:    */   public cajaDesk()
/*  97:    */   {
/*  98: 49 */     initComponents();
/*  99: 50 */     calendario();
/* 100: 51 */     abrirCaja();
/* 101: 52 */     verVentas();
/* 102: 53 */     cargaRegistros_Compras();
/* 103: 54 */     cargaRegistro_Reparaciones();
/* 104:    */   }
/* 105:    */   
/* 106:    */   private void initComponents()
/* 107:    */   {
/* 108: 62 */     this.btngImprimir = new ButtonGroup();
/* 109: 63 */     this.jPanel1 = new JPanel();
/* 110: 64 */     this.jPanel2 = new JPanel();
/* 111: 65 */     this.jLabel8 = new JLabel();
/* 112: 66 */     this.lblFechaActual = new JLabel();
/* 113: 67 */     this.jButton1 = new JButton();
/* 114: 68 */     this.jLabel2 = new JLabel();
/* 115: 69 */     this.jLabel3 = new JLabel();
/* 116: 70 */     this.jLabel4 = new JLabel();
/* 117: 71 */     this.jLabel5 = new JLabel();
/* 118: 72 */     this.txtInicio = new JTextField();
/* 119: 73 */     this.txtCompras = new JTextField();
/* 120: 74 */     this.txtVentas = new JTextField();
/* 121: 75 */     this.txtReparaciones = new JTextField();
/* 122: 76 */     this.txtTotal = new JTextField();
/* 123: 77 */     this.jLabel6 = new JLabel();
/* 124: 78 */     this.btnCalcular = new JButton();
/* 125: 79 */     this.btnImprimir = new JButton();
/* 126: 80 */     this.btnCerrar = new JButton();
/* 127: 81 */     this.btnAbrir = new JButton();
/* 128: 82 */     this.jTabbedPane1 = new JTabbedPane();
/* 129: 83 */     this.jScrollPane1 = new JScrollPane();
/* 130: 84 */     this.tblRegistroVentas = new JTable();
/* 131: 85 */     this.jScrollPane2 = new JScrollPane();
/* 132: 86 */     this.tblRegistroDeCompas = new JTable();
/* 133: 87 */     this.jScrollPane3 = new JScrollPane();
/* 134: 88 */     this.tblRegistro_reparaciones = new JTable();
/* 135: 89 */     this.rdVentas = new JRadioButton();
/* 136: 90 */     this.rdReparaciones = new JRadioButton();
/* 137: 91 */     this.rdCompras = new JRadioButton();
/* 138:    */     
/* 139: 93 */     setIconifiable(true);
/* 140: 94 */     setMaximizable(true);
/* 141: 95 */     setTitle("Control de entrada y salida de efecivo(CAJA)");
/* 142: 96 */     setMinimumSize(new Dimension(1343, 640));
/* 143: 97 */     setPreferredSize(new Dimension(1343, 640));
/* 144: 98 */     addMouseListener(new MouseAdapter()
/* 145:    */     {
/* 146:    */       public void mouseClicked(MouseEvent evt)
/* 147:    */       {
/* 148:100 */         cajaDesk.this.formMouseClicked(evt);
/* 149:    */       }
/* 150:103 */     });
/* 151:104 */     this.jPanel1.setBackground(new Color(153, 153, 153));
/* 152:    */     
/* 153:106 */     this.jPanel2.setBackground(new Color(51, 51, 51));
/* 154:107 */     this.jPanel2.setBorder(BorderFactory.createLineBorder(new Color(51, 0, 0), 4));
/* 155:    */     
/* 156:109 */     this.jLabel8.setFont(new Font("Tahoma", 1, 18));
/* 157:110 */     this.jLabel8.setForeground(new Color(255, 255, 51));
/* 158:111 */     this.jLabel8.setHorizontalAlignment(0);
/* 159:112 */     this.jLabel8.setText("E F E C T I V O S              E/S");
/* 160:    */     
/* 161:114 */     this.lblFechaActual.setFont(new Font("sansserif", 1, 30));
/* 162:115 */     this.lblFechaActual.setForeground(new Color(255, 255, 255));
/* 163:116 */     this.lblFechaActual.setHorizontalAlignment(0);
/* 164:117 */     this.lblFechaActual.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)), "Fecha Actual:"));
/* 165:    */     
/* 166:119 */     this.jButton1.setBackground(new Color(255, 0, 0));
/* 167:120 */     this.jButton1.setFont(new Font("sansserif", 3, 14));
/* 168:121 */     this.jButton1.setText("X");
/* 169:122 */     this.jButton1.addActionListener(new ActionListener()
/* 170:    */     {
/* 171:    */       public void actionPerformed(ActionEvent evt)
/* 172:    */       {
/* 173:124 */         cajaDesk.this.jButton1ActionPerformed(evt);
/* 174:    */       }
/* 175:127 */     });
/* 176:128 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 177:129 */     this.jPanel2.setLayout(jPanel2Layout);
/* 178:130 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.lblFechaActual, -2, 168, -2).addGap(50, 50, 50).addComponent(this.jLabel8, -2, 424, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton1)));
/* 179:    */     
/* 180:    */ 
/* 181:    */ 
/* 182:    */ 
/* 183:    */ 
/* 184:    */ 
/* 185:    */ 
/* 186:    */ 
/* 187:    */ 
/* 188:140 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel8, -1, -1, 32767).addComponent(this.jButton1)).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.lblFechaActual, -2, 56, -2).addContainerGap(-1, 32767)));
/* 189:    */     
/* 190:    */ 
/* 191:    */ 
/* 192:    */ 
/* 193:    */ 
/* 194:    */ 
/* 195:    */ 
/* 196:    */ 
/* 197:    */ 
/* 198:    */ 
/* 199:151 */     this.jLabel2.setFont(new Font("sansserif", 1, 14));
/* 200:152 */     this.jLabel2.setForeground(new Color(255, 255, 255));
/* 201:153 */     this.jLabel2.setText("COMPRAS S/.");
/* 202:    */     
/* 203:155 */     this.jLabel3.setFont(new Font("sansserif", 1, 14));
/* 204:156 */     this.jLabel3.setForeground(new Color(255, 255, 255));
/* 205:157 */     this.jLabel3.setText("VENTAS S/.");
/* 206:    */     
/* 207:159 */     this.jLabel4.setFont(new Font("sansserif", 1, 14));
/* 208:160 */     this.jLabel4.setForeground(new Color(255, 255, 255));
/* 209:161 */     this.jLabel4.setText("SERVICIOS S/.");
/* 210:    */     
/* 211:163 */     this.jLabel5.setFont(new Font("sansserif", 1, 14));
/* 212:164 */     this.jLabel5.setForeground(new Color(255, 255, 255));
/* 213:165 */     this.jLabel5.setText("TOTAL EF S/.");
/* 214:    */     
/* 215:167 */     this.txtInicio.setFont(new Font("sansserif", 1, 14));
/* 216:168 */     this.txtInicio.setForeground(new Color(0, 0, 102));
/* 217:169 */     this.txtInicio.setHorizontalAlignment(4);
/* 218:170 */     this.txtInicio.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 219:171 */     this.txtInicio.addActionListener(new ActionListener()
/* 220:    */     {
/* 221:    */       public void actionPerformed(ActionEvent evt)
/* 222:    */       {
/* 223:173 */         cajaDesk.this.txtInicioActionPerformed(evt);
/* 224:    */       }
/* 225:176 */     });
/* 226:177 */     this.txtCompras.setFont(new Font("sansserif", 1, 14));
/* 227:178 */     this.txtCompras.setForeground(new Color(0, 0, 102));
/* 228:179 */     this.txtCompras.setHorizontalAlignment(4);
/* 229:180 */     this.txtCompras.setText("0.00");
/* 230:181 */     this.txtCompras.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 231:    */     
/* 232:183 */     this.txtVentas.setFont(new Font("sansserif", 1, 14));
/* 233:184 */     this.txtVentas.setForeground(new Color(0, 0, 102));
/* 234:185 */     this.txtVentas.setHorizontalAlignment(4);
/* 235:186 */     this.txtVentas.setText("0.00");
/* 236:187 */     this.txtVentas.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 237:    */     
/* 238:189 */     this.txtReparaciones.setFont(new Font("sansserif", 1, 14));
/* 239:190 */     this.txtReparaciones.setForeground(new Color(0, 0, 102));
/* 240:191 */     this.txtReparaciones.setHorizontalAlignment(4);
/* 241:192 */     this.txtReparaciones.setText("0.00");
/* 242:193 */     this.txtReparaciones.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 243:    */     
/* 244:195 */     this.txtTotal.setFont(new Font("sansserif", 1, 14));
/* 245:196 */     this.txtTotal.setForeground(new Color(0, 0, 102));
/* 246:197 */     this.txtTotal.setHorizontalAlignment(4);
/* 247:198 */     this.txtTotal.setText("0.00");
/* 248:199 */     this.txtTotal.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 249:    */     
/* 250:201 */     this.jLabel6.setFont(new Font("sansserif", 1, 14));
/* 251:202 */     this.jLabel6.setForeground(new Color(255, 255, 255));
/* 252:203 */     this.jLabel6.setText("INICIAR S/.");
/* 253:    */     
/* 254:205 */     this.btnCalcular.setBackground(new Color(153, 204, 255));
/* 255:206 */     this.btnCalcular.setIcon(new ImageIcon(getClass().getResource("/icon/Money.png")));
/* 256:207 */     this.btnCalcular.setText("CALCULAR");
/* 257:208 */     this.btnCalcular.addActionListener(new ActionListener()
/* 258:    */     {
/* 259:    */       public void actionPerformed(ActionEvent evt)
/* 260:    */       {
/* 261:210 */         cajaDesk.this.btnCalcularActionPerformed(evt);
/* 262:    */       }
/* 263:213 */     });
/* 264:214 */     this.btnImprimir.setBackground(new Color(153, 204, 255));
/* 265:215 */     this.btnImprimir.setIcon(new ImageIcon(getClass().getResource("/icon/print-32.png")));
/* 266:216 */     this.btnImprimir.setText("IMPRIMIR");
/* 267:217 */     this.btnImprimir.addActionListener(new ActionListener()
/* 268:    */     {
/* 269:    */       public void actionPerformed(ActionEvent evt)
/* 270:    */       {
/* 271:219 */         cajaDesk.this.btnImprimirActionPerformed(evt);
/* 272:    */       }
/* 273:222 */     });
/* 274:223 */     this.btnCerrar.setBackground(new Color(153, 204, 255));
/* 275:224 */     this.btnCerrar.setIcon(new ImageIcon(getClass().getResource("/icon/document_text_cancel-32.png")));
/* 276:225 */     this.btnCerrar.setText("CERRAR CAJA");
/* 277:226 */     this.btnCerrar.setEnabled(false);
/* 278:227 */     this.btnCerrar.addActionListener(new ActionListener()
/* 279:    */     {
/* 280:    */       public void actionPerformed(ActionEvent evt)
/* 281:    */       {
/* 282:229 */         cajaDesk.this.btnCerrarActionPerformed(evt);
/* 283:    */       }
/* 284:232 */     });
/* 285:233 */     this.btnAbrir.setBackground(new Color(153, 204, 255));
/* 286:234 */     this.btnAbrir.setIcon(new ImageIcon(getClass().getResource("/icon/basic3-017_invoice_bill-32.png")));
/* 287:235 */     this.btnAbrir.setText("ABRIR CAJA");
/* 288:236 */     this.btnAbrir.addActionListener(new ActionListener()
/* 289:    */     {
/* 290:    */       public void actionPerformed(ActionEvent evt)
/* 291:    */       {
/* 292:238 */         cajaDesk.this.btnAbrirActionPerformed(evt);
/* 293:    */       }
/* 294:241 */     });
/* 295:242 */     this.jTabbedPane1.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
/* 296:    */     
/* 297:244 */     this.tblRegistroVentas.setBackground(new Color(153, 153, 255));
/* 298:245 */     this.tblRegistroVentas.setModel(new DefaultTableModel(new Object[0][], new String[] { "BOLETA", "CODIGO", "MARCA", "SERIE", "CANT.", "PRECIO", "IMPORTE", "ESTADO" })
/* 299:    */     {
/* 300:253 */       boolean[] canEdit = { false, false, false, false, false, false, false, false };
/* 301:    */       
/* 302:    */       public boolean isCellEditable(int rowIndex, int columnIndex)
/* 303:    */       {
/* 304:258 */         return this.canEdit[columnIndex];
/* 305:    */       }
/* 306:260 */     });
/* 307:261 */     this.tblRegistroVentas.setOpaque(false);
/* 308:262 */     this.tblRegistroVentas.setSelectionBackground(new Color(0, 0, 0));
/* 309:263 */     this.tblRegistroVentas.setSelectionForeground(new Color(153, 255, 0));
/* 310:264 */     this.jScrollPane1.setViewportView(this.tblRegistroVentas);
/* 311:265 */     if (this.tblRegistroVentas.getColumnModel().getColumnCount() > 0)
/* 312:    */     {
/* 313:266 */       this.tblRegistroVentas.getColumnModel().getColumn(0).setMinWidth(70);
/* 314:267 */       this.tblRegistroVentas.getColumnModel().getColumn(0).setPreferredWidth(70);
/* 315:268 */       this.tblRegistroVentas.getColumnModel().getColumn(0).setMaxWidth(70);
/* 316:269 */       this.tblRegistroVentas.getColumnModel().getColumn(1).setMinWidth(80);
/* 317:270 */       this.tblRegistroVentas.getColumnModel().getColumn(1).setPreferredWidth(80);
/* 318:271 */       this.tblRegistroVentas.getColumnModel().getColumn(1).setMaxWidth(80);
/* 319:272 */       this.tblRegistroVentas.getColumnModel().getColumn(4).setMinWidth(50);
/* 320:273 */       this.tblRegistroVentas.getColumnModel().getColumn(4).setPreferredWidth(50);
/* 321:274 */       this.tblRegistroVentas.getColumnModel().getColumn(4).setMaxWidth(50);
/* 322:    */     }
/* 323:277 */     this.jTabbedPane1.addTab("CONTROL DE VENTAS", this.jScrollPane1);
/* 324:    */     
/* 325:279 */     this.tblRegistroDeCompas.setBackground(new Color(153, 204, 255));
/* 326:280 */     this.tblRegistroDeCompas.setModel(new DefaultTableModel(new Object[0][], new String[] { "CODIGO PRODUCTO", "MARCA", "SERIE", "COSTO", "CANTIDAD", "SOCIEDAD", "ESTADO" })
/* 327:    */     {
/* 328:288 */       Class[] types = { String.class, String.class, String.class, String.class, String.class, String.class, String.class };
/* 329:291 */       boolean[] canEdit = { false, false, false, false, false, false, false };
/* 330:    */       
/* 331:    */       public Class getColumnClass(int columnIndex)
/* 332:    */       {
/* 333:296 */         return this.types[columnIndex];
/* 334:    */       }
/* 335:    */       
/* 336:    */       public boolean isCellEditable(int rowIndex, int columnIndex)
/* 337:    */       {
/* 338:300 */         return this.canEdit[columnIndex];
/* 339:    */       }
/* 340:302 */     });
/* 341:303 */     this.tblRegistroDeCompas.setOpaque(false);
/* 342:304 */     this.tblRegistroDeCompas.setSelectionBackground(new Color(102, 153, 255));
/* 343:305 */     this.tblRegistroDeCompas.setSelectionForeground(new Color(51, 0, 51));
/* 344:306 */     this.jScrollPane2.setViewportView(this.tblRegistroDeCompas);
/* 345:307 */     if (this.tblRegistroDeCompas.getColumnModel().getColumnCount() > 0)
/* 346:    */     {
/* 347:308 */       this.tblRegistroDeCompas.getColumnModel().getColumn(0).setMinWidth(80);
/* 348:309 */       this.tblRegistroDeCompas.getColumnModel().getColumn(0).setPreferredWidth(80);
/* 349:310 */       this.tblRegistroDeCompas.getColumnModel().getColumn(0).setMaxWidth(80);
/* 350:311 */       this.tblRegistroDeCompas.getColumnModel().getColumn(1).setMinWidth(90);
/* 351:312 */       this.tblRegistroDeCompas.getColumnModel().getColumn(1).setPreferredWidth(90);
/* 352:313 */       this.tblRegistroDeCompas.getColumnModel().getColumn(1).setMaxWidth(90);
/* 353:314 */       this.tblRegistroDeCompas.getColumnModel().getColumn(2).setMinWidth(150);
/* 354:315 */       this.tblRegistroDeCompas.getColumnModel().getColumn(2).setPreferredWidth(150);
/* 355:316 */       this.tblRegistroDeCompas.getColumnModel().getColumn(2).setMaxWidth(150);
/* 356:317 */       this.tblRegistroDeCompas.getColumnModel().getColumn(3).setMinWidth(90);
/* 357:318 */       this.tblRegistroDeCompas.getColumnModel().getColumn(3).setPreferredWidth(90);
/* 358:319 */       this.tblRegistroDeCompas.getColumnModel().getColumn(3).setMaxWidth(90);
/* 359:320 */       this.tblRegistroDeCompas.getColumnModel().getColumn(4).setMinWidth(90);
/* 360:321 */       this.tblRegistroDeCompas.getColumnModel().getColumn(4).setPreferredWidth(90);
/* 361:322 */       this.tblRegistroDeCompas.getColumnModel().getColumn(4).setMaxWidth(90);
/* 362:    */     }
/* 363:325 */     this.jTabbedPane1.addTab("CONTROL DE COMPRAS", this.jScrollPane2);
/* 364:    */     
/* 365:327 */     this.tblRegistro_reparaciones.setBackground(new Color(153, 204, 255));
/* 366:328 */     this.tblRegistro_reparaciones.setModel(new DefaultTableModel(new Object[0][], new String[] { "FACTURA", "TIPO", "CODIGO PRODUCTO", "MARCA", "SERIE", "OBSERVACION", "COSTO", "CANTIDAD", "IMPORTE" })
/* 367:    */     {
/* 368:336 */       Class[] types = { String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class };
/* 369:339 */       boolean[] canEdit = { false, false, false, false, false, false, false, false, false };
/* 370:    */       
/* 371:    */       public Class getColumnClass(int columnIndex)
/* 372:    */       {
/* 373:344 */         return this.types[columnIndex];
/* 374:    */       }
/* 375:    */       
/* 376:    */       public boolean isCellEditable(int rowIndex, int columnIndex)
/* 377:    */       {
/* 378:348 */         return this.canEdit[columnIndex];
/* 379:    */       }
/* 380:350 */     });
/* 381:351 */     this.tblRegistro_reparaciones.setOpaque(false);
/* 382:352 */     this.tblRegistro_reparaciones.setSelectionBackground(new Color(102, 153, 255));
/* 383:353 */     this.tblRegistro_reparaciones.setSelectionForeground(new Color(51, 0, 51));
/* 384:354 */     this.jScrollPane3.setViewportView(this.tblRegistro_reparaciones);
/* 385:355 */     if (this.tblRegistro_reparaciones.getColumnModel().getColumnCount() > 0)
/* 386:    */     {
/* 387:356 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(0).setMinWidth(80);
/* 388:357 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(0).setPreferredWidth(80);
/* 389:358 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(0).setMaxWidth(80);
/* 390:359 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(1).setMinWidth(90);
/* 391:360 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(1).setPreferredWidth(90);
/* 392:361 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(1).setMaxWidth(90);
/* 393:362 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(2).setMinWidth(150);
/* 394:363 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(2).setPreferredWidth(150);
/* 395:364 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(2).setMaxWidth(150);
/* 396:365 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(3).setMinWidth(90);
/* 397:366 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(3).setPreferredWidth(90);
/* 398:367 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(3).setMaxWidth(90);
/* 399:368 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(4).setMinWidth(90);
/* 400:369 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(4).setPreferredWidth(90);
/* 401:370 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(4).setMaxWidth(90);
/* 402:371 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(6).setMinWidth(80);
/* 403:372 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(6).setPreferredWidth(80);
/* 404:373 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(6).setMaxWidth(80);
/* 405:374 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(7).setMinWidth(80);
/* 406:375 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(7).setPreferredWidth(80);
/* 407:376 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(7).setMaxWidth(80);
/* 408:377 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(8).setMinWidth(80);
/* 409:378 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(8).setPreferredWidth(80);
/* 410:379 */       this.tblRegistro_reparaciones.getColumnModel().getColumn(8).setMaxWidth(80);
/* 411:    */     }
/* 412:382 */     this.jTabbedPane1.addTab("CONTROL DE REPARACIONES", this.jScrollPane3);
/* 413:    */     
/* 414:384 */     this.btngImprimir.add(this.rdVentas);
/* 415:385 */     this.rdVentas.setText("ventas");
/* 416:    */     
/* 417:387 */     this.btngImprimir.add(this.rdReparaciones);
/* 418:388 */     this.rdReparaciones.setText("reparaciones");
/* 419:    */     
/* 420:390 */     this.btngImprimir.add(this.rdCompras);
/* 421:391 */     this.rdCompras.setText("compras");
/* 422:392 */     this.rdCompras.addActionListener(new ActionListener()
/* 423:    */     {
/* 424:    */       public void actionPerformed(ActionEvent evt)
/* 425:    */       {
/* 426:394 */         cajaDesk.this.rdComprasActionPerformed(evt);
/* 427:    */       }
/* 428:397 */     });
/* 429:398 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 430:399 */     this.jPanel1.setLayout(jPanel1Layout);
/* 431:400 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel6).addComponent(this.jLabel2).addComponent(this.jLabel3)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.txtCompras, -2, 110, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.txtVentas)).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.txtInicio, -2, 110, -2)))).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.txtTotal, -2, 112, -2)).addComponent(this.btnAbrir, -1, -1, 32767).addComponent(this.btnCalcular, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtReparaciones, -2, 112, -2)).addComponent(this.btnCerrar, -1, -1, 32767).addComponent(this.btnImprimir, -1, -1, 32767))).addGroup(jPanel1Layout.createSequentialGroup().addGap(38, 38, 38).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.rdReparaciones).addComponent(this.rdVentas).addComponent(this.rdCompras)))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTabbedPane1, -2, 1081, -2).addContainerGap(-1, 32767)));
/* 432:    */     
/* 433:    */ 
/* 434:    */ 
/* 435:    */ 
/* 436:    */ 
/* 437:    */ 
/* 438:    */ 
/* 439:    */ 
/* 440:    */ 
/* 441:    */ 
/* 442:    */ 
/* 443:    */ 
/* 444:    */ 
/* 445:    */ 
/* 446:    */ 
/* 447:    */ 
/* 448:    */ 
/* 449:    */ 
/* 450:    */ 
/* 451:    */ 
/* 452:    */ 
/* 453:    */ 
/* 454:    */ 
/* 455:    */ 
/* 456:    */ 
/* 457:    */ 
/* 458:    */ 
/* 459:    */ 
/* 460:    */ 
/* 461:    */ 
/* 462:    */ 
/* 463:    */ 
/* 464:    */ 
/* 465:    */ 
/* 466:    */ 
/* 467:    */ 
/* 468:    */ 
/* 469:    */ 
/* 470:    */ 
/* 471:    */ 
/* 472:    */ 
/* 473:    */ 
/* 474:    */ 
/* 475:    */ 
/* 476:445 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addGap(13, 13, 13).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jTabbedPane1, -2, 411, -2).addContainerGap(-1, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.txtInicio, -2, -1, -2)).addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.txtCompras, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.txtVentas, -2, -1, -2)).addGap(21, 21, 21).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.txtReparaciones, -2, -1, -2)).addGap(17, 17, 17).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtTotal, -2, -1, -2).addComponent(this.jLabel5)).addGap(29, 29, 29).addComponent(this.btnAbrir).addGap(0, 0, 0).addComponent(this.btnCalcular, -2, 44, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnCerrar).addGap(18, 18, 18).addComponent(this.rdVentas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.rdReparaciones).addGap(3, 3, 3).addComponent(this.rdCompras).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnImprimir).addGap(67, 67, 67)))));
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
/* 503:    */ 
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
/* 523:492 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 524:493 */     getContentPane().setLayout(layout);
/* 525:494 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/* 526:    */     
/* 527:    */ 
/* 528:    */ 
/* 529:498 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/* 530:    */     
/* 531:    */ 
/* 532:    */ 
/* 533:    */ 
/* 534:503 */     pack();
/* 535:    */   }
/* 536:    */   
/* 537:    */   private void btnAbrirActionPerformed(ActionEvent evt)
/* 538:    */   {
/* 539:    */     try
/* 540:    */     {
/* 541:508 */       this.fechaIcinio = this.lblFechaActual.getText();
/* 542:509 */       double inicio = Double.parseDouble(this.txtInicio.getText());
/* 543:510 */       String hrInicio = VentanaPrincipalGUI.lblReloj.getText();
/* 544:    */       
/* 545:512 */       this.oBoleta.registrarCaja(this.fechaIcinio, inicio, 0.0D, 0.0D, 0.0D, 0.0D, hrInicio, "hh:mm:ss");
/* 546:513 */       JOptionPane.showMessageDialog(this.rootPane, "Ud. Abrio la caja correctamente...");
/* 547:    */     }
/* 548:    */     catch (Exception e)
/* 549:    */     {
/* 550:516 */       System.out.println(e);
/* 551:517 */       JOptionPane.showMessageDialog(this.rootPane, "La caja ya fue iniciada Error...");
/* 552:    */     }
/* 553:    */   }
/* 554:    */   
/* 555:    */   private void btnCerrarActionPerformed(ActionEvent evt)
/* 556:    */   {
/* 557:    */     try
/* 558:    */     {
/* 559:523 */       cajero_TO to = new cajero_TO();
/* 560:    */       
/* 561:525 */       to.setFecha(this.lblFechaActual.getText());
/* 562:526 */       to.setIncio(Double.parseDouble(this.txtInicio.getText()));
/* 563:527 */       to.setCompras(Double.parseDouble(this.txtCompras.getText()));
/* 564:528 */       to.setVentas(Double.parseDouble(this.txtVentas.getText()));
/* 565:529 */       to.setReparaciones(Double.parseDouble(this.txtReparaciones.getText()));
/* 566:530 */       to.setNuevoSaldo(Double.parseDouble(this.txtTotal.getText()));
/* 567:531 */       to.setHrFinal(VentanaPrincipalGUI.lblReloj.getText());
/* 568:532 */       this.oCajero.cerraCaja(to);
/* 569:533 */       JOptionPane.showMessageDialog(this.rootPane, "Cierre de caja realizada");
/* 570:    */     }
/* 571:    */     catch (Exception e)
/* 572:    */     {
/* 573:535 */       System.out.println(e);
/* 574:    */     }
/* 575:    */   }
/* 576:    */   
/* 577:    */   private void btnCalcularActionPerformed(ActionEvent evt)
/* 578:    */   {
/* 579:540 */     calculo();
/* 580:541 */     this.btnCerrar.setEnabled(true);
/* 581:    */   }
/* 582:    */   
/* 583:    */   private void txtInicioActionPerformed(ActionEvent evt) {}
/* 584:    */   
/* 585:    */   private void formMouseClicked(MouseEvent evt) {}
/* 586:    */   
/* 587:    */   private void jButton1ActionPerformed(ActionEvent evt)
/* 588:    */   {
/* 589:553 */     dispose();
/* 590:554 */     VentanaPrincipalGUI.btnCaja.setEnabled(true);
/* 591:    */   }
/* 592:    */   
/* 593:    */   private void btnImprimirActionPerformed(ActionEvent evt)
/* 594:    */   {
/* 595:558 */     if (this.rdCompras.isSelected()) {
/* 596:559 */       imprimirControlCompras();
/* 597:561 */     } else if (this.rdReparaciones.isSelected()) {
/* 598:562 */       imprimirControlReparaciones();
/* 599:564 */     } else if (this.rdVentas.isSelected()) {
/* 600:565 */       imprimirControlVentas();
/* 601:    */     } else {
/* 602:567 */       JOptionPane.showMessageDialog(this.rdCompras, "Elija una opción para imprimir..");
/* 603:    */     }
/* 604:    */   }
/* 605:    */   
/* 606:    */   private void rdComprasActionPerformed(ActionEvent evt) {}
/* 607:    */   
/* 608:    */   private void calendario()
/* 609:    */   {
/* 610:613 */     Calendar cal1 = Calendar.getInstance();
/* 611:614 */     String mesInt = "";
/* 612:    */     
/* 613:616 */     int mes = cal1.get(2);
/* 614:617 */     int mesActual = mes + 1;
/* 615:618 */     if (mesActual < 10) {
/* 616:619 */       mesInt = "-0" + mesActual;
/* 617:    */     } else {
/* 618:621 */       mesInt = "-" + mesActual;
/* 619:    */     }
/* 620:624 */     int dia = cal1.get(5);
/* 621:625 */     String diaInt = "";
/* 622:626 */     if (dia < 10) {
/* 623:627 */       diaInt = "-0" + dia;
/* 624:    */     } else {
/* 625:629 */       diaInt = "-" + dia;
/* 626:    */     }
/* 627:631 */     int año = cal1.get(1);
/* 628:    */     
/* 629:633 */     this.lblFechaActual.setText(año + mesInt + diaInt);
/* 630:    */   }
/* 631:    */   
/* 632:    */   private void abrirCaja()
/* 633:    */   {
/* 634:    */     try
/* 635:    */     {
/* 636:639 */       String fecha = this.lblFechaActual.getText();
/* 637:    */       
/* 638:641 */       this.rs0 = this.oCajero.iniciaCajero(fecha);
/* 639:642 */       while (this.rs0.next()) {
/* 640:644 */         this.txtInicio.setText(this.rs0.getString(1));
/* 641:    */       }
/* 642:646 */       this.rsFecha = this.oCajero.Cajero_Fecha();
/* 643:647 */       while (this.rsFecha.next()) {
/* 644:648 */         if (fecha.equals(this.rsFecha.getString(1)))
/* 645:    */         {
/* 646:649 */           this.rs1 = this.oCajero.Cajero_compras(fecha);
/* 647:650 */           while (this.rs1.next()) {
/* 648:651 */             if (this.rs1.getString(1) != null) {
/* 649:652 */               this.txtCompras.setText(this.rs1.getString(1));
/* 650:    */             } else {
/* 651:654 */               this.txtCompras.setText("0.00");
/* 652:    */             }
/* 653:    */           }
/* 654:657 */           this.rs2 = this.oCajero.Cajero_ventas(fecha);
/* 655:658 */           while (this.rs2.next()) {
/* 656:659 */             if (this.rs2.getString(1) != null) {
/* 657:660 */               this.txtVentas.setText(this.rs2.getString(1));
/* 658:    */             } else {
/* 659:662 */               this.txtVentas.setText("0.00");
/* 660:    */             }
/* 661:    */           }
/* 662:665 */           this.rs1 = this.oCajero.Cajero_reparaciones(fecha);
/* 663:666 */           while (this.rs1.next()) {
/* 664:667 */             if (this.rs1.getString(1) != null) {
/* 665:668 */               this.txtReparaciones.setText(this.rs1.getString(1));
/* 666:    */             } else {
/* 667:670 */               this.txtReparaciones.setText("0.00");
/* 668:    */             }
/* 669:    */           }
/* 670:    */         }
/* 671:    */       }
/* 672:    */     }
/* 673:    */     catch (Exception e)
/* 674:    */     {
/* 675:678 */       System.out.println(e);
/* 676:    */     }
/* 677:    */   }
/* 678:    */   
/* 679:    */   private void calculo()
/* 680:    */   {
/* 681:685 */     double ini = Double.parseDouble(this.txtInicio.getText());
/* 682:686 */     double comp = Double.parseDouble(this.txtCompras.getText());
/* 683:687 */     double vent = Double.parseDouble(this.txtVentas.getText());
/* 684:688 */     double rep = Double.parseDouble(this.txtReparaciones.getText());
/* 685:    */     
/* 686:690 */     double nuevoSaldo = rep + vent + ini - comp;
/* 687:691 */     this.txtTotal.setText(String.valueOf(nuevoSaldo));
/* 688:    */   }
/* 689:    */   
/* 690:    */   private void cargaRegistros_Compras()
/* 691:    */   {
/* 692:    */     try
/* 693:    */     {
/* 694:697 */       String fecha = this.lblFechaActual.getText();
/* 695:698 */       this.rs0 = this.oCajero.Cajero_compras_detalle(fecha);
/* 696:699 */       this.model = ((DefaultTableModel)this.tblRegistroDeCompas.getModel());
/* 697:700 */       while (this.rs0.next())
/* 698:    */       {
/* 699:701 */         Object[] registros = { this.rs0.getString(1), this.rs0.getString(2), this.rs0.getString(3), this.rs0.getString(4), this.rs0.getString(5), this.rs0.getString(7), this.rs0.getString(8) };
/* 700:    */         
/* 701:    */ 
/* 702:    */ 
/* 703:    */ 
/* 704:    */ 
/* 705:    */ 
/* 706:    */ 
/* 707:    */ 
/* 708:710 */         this.model.addRow(registros);
/* 709:    */       }
/* 710:    */     }
/* 711:    */     catch (Exception e)
/* 712:    */     {
/* 713:713 */       System.out.println(e);
/* 714:    */     }
/* 715:    */   }
/* 716:    */   
/* 717:    */   private void limpiaTabla()
/* 718:    */   {
/* 719:719 */     this.model = ((DefaultTableModel)this.tblRegistroDeCompas.getModel());
/* 720:720 */     int filas = this.tblRegistroDeCompas.getRowCount();
/* 721:722 */     for (int i = 0; filas > i; i++) {
/* 722:723 */       this.model.removeRow(0);
/* 723:    */     }
/* 724:    */   }
/* 725:    */   
/* 726:    */   private void verVentas()
/* 727:    */   {
/* 728:    */     try
/* 729:    */     {
/* 730:729 */       this.model = ((DefaultTableModel)this.tblRegistroVentas.getModel());
/* 731:730 */       String fecha = this.lblFechaActual.getText();
/* 732:731 */       this.rs0 = this.oCajero.verVentas(fecha);
/* 733:732 */       while (this.rs0.next())
/* 734:    */       {
/* 735:733 */         Object[] registrosVentas = { this.rs0.getString(1), this.rs0.getString(2), this.rs0.getString(3), this.rs0.getString(4), this.rs0.getString(5), this.rs0.getString(6), this.rs0.getString(7), this.rs0.getString(9) };
/* 736:    */         
/* 737:    */ 
/* 738:    */ 
/* 739:    */ 
/* 740:    */ 
/* 741:    */ 
/* 742:    */ 
/* 743:    */ 
/* 744:    */ 
/* 745:743 */         this.model.addRow(registrosVentas);
/* 746:    */       }
/* 747:    */     }
/* 748:    */     catch (Exception e) {}
/* 749:    */   }
/* 750:    */   
/* 751:    */   private void cargaRegistro_Reparaciones()
/* 752:    */   {
/* 753:751 */     String fecha = this.lblFechaActual.getText();
/* 754:752 */     this.model = ((DefaultTableModel)this.tblRegistro_reparaciones.getModel());
/* 755:    */     try
/* 756:    */     {
/* 757:754 */       this.rs1 = this.oCajero.ver_reparaciones(fecha);
/* 758:755 */       while (this.rs1.next())
/* 759:    */       {
/* 760:756 */         Object[] reg = { this.rs1.getString(1), this.rs1.getString(2), this.rs1.getString(3), this.rs1.getString(4), this.rs1.getString(5), this.rs1.getString(6), this.rs1.getString(7), this.rs1.getString(8), this.rs1.getString(9) };
/* 761:    */         
/* 762:    */ 
/* 763:    */ 
/* 764:    */ 
/* 765:    */ 
/* 766:    */ 
/* 767:    */ 
/* 768:    */ 
/* 769:    */ 
/* 770:    */ 
/* 771:767 */         this.model.addRow(reg);
/* 772:    */       }
/* 773:    */     }
/* 774:    */     catch (Exception e)
/* 775:    */     {
/* 776:770 */       System.out.println(e);
/* 777:    */     }
/* 778:    */   }
/* 779:    */   
/* 780:    */   private void imprimirControlVentas()
/* 781:    */   {
/* 782:775 */     List lista = new ArrayList();
/* 783:776 */     for (int i = 0; i < this.tblRegistroVentas.getRowCount(); i++)
/* 784:    */     {
/* 785:777 */       reporte_cajaVentas listaventas = new reporte_cajaVentas(this.tblRegistroVentas.getValueAt(i, 0).toString(), this.tblRegistroVentas.getValueAt(i, 1).toString(), this.tblRegistroVentas.getValueAt(i, 2).toString(), this.tblRegistroVentas.getValueAt(i, 3).toString(), Integer.parseInt(this.tblRegistroVentas.getValueAt(i, 4).toString()), Double.parseDouble(this.tblRegistroVentas.getValueAt(i, 5).toString()), Double.parseDouble(this.tblRegistroVentas.getValueAt(i, 6).toString()), this.tblRegistroVentas.getValueAt(i, 7).toString());
/* 786:    */       
/* 787:    */ 
/* 788:    */ 
/* 789:    */ 
/* 790:    */ 
/* 791:    */ 
/* 792:    */ 
/* 793:    */ 
/* 794:    */ 
/* 795:787 */       lista.add(listaventas);
/* 796:    */     }
/* 797:    */     try
/* 798:    */     {
/* 799:791 */       JasperReport report = (JasperReport)JRLoader.loadObject("C:\\LEDATEL\\reportes\\reporteCaja_ventas.jasper");
/* 800:792 */       Map parametro = new HashMap();
/* 801:793 */       parametro.put("fecha", this.lblFechaActual.getText());
/* 802:    */       
/* 803:795 */       JasperPrint print = JasperFillManager.fillReport(report, parametro, new JRBeanCollectionDataSource(lista));
/* 804:796 */       JasperViewer.viewReport(print, false);
/* 805:    */     }
/* 806:    */     catch (Exception e)
/* 807:    */     {
/* 808:799 */       System.out.println(e.getMessage());
/* 809:    */     }
/* 810:    */   }
/* 811:    */   
/* 812:    */   private void imprimirControlReparaciones()
/* 813:    */   {
/* 814:805 */     List lista = new ArrayList();
/* 815:806 */     for (int i = 0; i < this.tblRegistro_reparaciones.getRowCount(); i++)
/* 816:    */     {
/* 817:807 */       reporte_cajaReparaciones listaReparaciones = new reporte_cajaReparaciones(this.tblRegistro_reparaciones.getValueAt(i, 0).toString(), this.tblRegistro_reparaciones.getValueAt(i, 1).toString(), this.tblRegistro_reparaciones.getValueAt(i, 2).toString(), this.tblRegistro_reparaciones.getValueAt(i, 3).toString(), this.tblRegistro_reparaciones.getValueAt(i, 4).toString(), this.tblRegistro_reparaciones.getValueAt(i, 5).toString(), Double.parseDouble(this.tblRegistro_reparaciones.getValueAt(i, 6).toString()), Integer.parseInt(this.tblRegistro_reparaciones.getValueAt(i, 7).toString()), Double.parseDouble(this.tblRegistro_reparaciones.getValueAt(i, 8).toString()));
/* 818:    */       
/* 819:    */ 
/* 820:    */ 
/* 821:    */ 
/* 822:    */ 
/* 823:    */ 
/* 824:    */ 
/* 825:    */ 
/* 826:    */ 
/* 827:    */ 
/* 828:818 */       lista.add(listaReparaciones);
/* 829:    */     }
/* 830:    */     try
/* 831:    */     {
/* 832:822 */       JasperReport report = (JasperReport)JRLoader.loadObject("C:\\LEDATEL\\reportes\\reporteCaja_reparaciones.jasper");
/* 833:823 */       Map parametro = new HashMap();
/* 834:824 */       parametro.put("fecha", this.lblFechaActual.getText());
/* 835:    */       
/* 836:826 */       JasperPrint print = JasperFillManager.fillReport(report, parametro, new JRBeanCollectionDataSource(lista));
/* 837:827 */       JasperViewer.viewReport(print, false);
/* 838:    */     }
/* 839:    */     catch (Exception e)
/* 840:    */     {
/* 841:830 */       System.out.println(e.getMessage());
/* 842:    */     }
/* 843:    */   }
/* 844:    */   
/* 845:    */   private void imprimirControlCompras()
/* 846:    */   {
/* 847:836 */     List lista = new ArrayList();
/* 848:837 */     for (int i = 0; i < this.tblRegistroDeCompas.getRowCount(); i++)
/* 849:    */     {
/* 850:838 */       reporte_cajaCompras listaCompras = new reporte_cajaCompras(this.tblRegistroDeCompas.getValueAt(i, 0).toString(), this.tblRegistroDeCompas.getValueAt(i, 1).toString(), this.tblRegistroDeCompas.getValueAt(i, 2).toString(), Double.parseDouble(this.tblRegistroDeCompas.getValueAt(i, 3).toString()), Integer.parseInt(this.tblRegistroDeCompas.getValueAt(i, 4).toString()), this.tblRegistroDeCompas.getValueAt(i, 5).toString(), this.tblRegistroDeCompas.getValueAt(i, 6).toString());
/* 851:    */       
/* 852:    */ 
/* 853:    */ 
/* 854:    */ 
/* 855:    */ 
/* 856:    */ 
/* 857:    */ 
/* 858:    */ 
/* 859:847 */       lista.add(listaCompras);
/* 860:    */     }
/* 861:    */     try
/* 862:    */     {
/* 863:851 */       JasperReport report = (JasperReport)JRLoader.loadObject("C:\\LEDATEL\\reportes\\reporte_controlCompras.jasper");
/* 864:852 */       Map parametro = new HashMap();
/* 865:853 */       parametro.put("fecha", this.lblFechaActual.getText());
/* 866:    */       
/* 867:855 */       JasperPrint print = JasperFillManager.fillReport(report, parametro, new JRBeanCollectionDataSource(lista));
/* 868:856 */       JasperViewer.viewReport(print, false);
/* 869:    */     }
/* 870:    */     catch (Exception e)
/* 871:    */     {
/* 872:859 */       System.out.println(e.getMessage());
/* 873:    */     }
/* 874:    */   }
/* 875:    */ }



/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar

 * Qualified Name:     Desk.cajaDesk

 * JD-Core Version:    0.7.0.1

 */