/*   1:    */ package Desk;
/*   2:    */ 
/*   3:    */ import Conexion.conexion;
/*   4:    */ import Dao.productoDao;
/*   5:    */ import Gui.VentanaPrincipalGUI;
/*   6:    */ import To.producto_TO;
/*   7:    */ import java.awt.Color;
/*   8:    */ import java.awt.Container;
/*   9:    */ import java.awt.Cursor;
/*  10:    */ import java.awt.Dimension;
/*  11:    */ import java.awt.Font;
/*  12:    */ import java.awt.event.ActionEvent;
/*  13:    */ import java.awt.event.ActionListener;
/*  14:    */ import java.awt.event.KeyAdapter;
/*  15:    */ import java.awt.event.KeyEvent;
/*  16:    */ import java.awt.event.MouseAdapter;
/*  17:    */ import java.awt.event.MouseEvent;
/*  18:    */ import java.io.PrintStream;
/*  19:    */ import java.sql.Connection;
/*  20:    */ import java.sql.ResultSet;
/*  21:    */ import javax.swing.BorderFactory;
/*  22:    */ import javax.swing.DefaultComboBoxModel;
/*  23:    */ import javax.swing.GroupLayout;
/*  24:    */ import javax.swing.GroupLayout.Alignment;
/*  25:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  26:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  27:    */ import javax.swing.ImageIcon;
/*  28:    */ import javax.swing.JButton;
/*  29:    */ import javax.swing.JComboBox;
/*  30:    */ import javax.swing.JDesktopPane;
/*  31:    */ import javax.swing.JInternalFrame;
/*  32:    */ import javax.swing.JLabel;
/*  33:    */ import javax.swing.JMenuItem;
/*  34:    */ import javax.swing.JOptionPane;
/*  35:    */ import javax.swing.JPanel;
/*  36:    */ import javax.swing.JPopupMenu;
/*  37:    */ import javax.swing.JPopupMenu.Separator;
/*  38:    */ import javax.swing.JScrollPane;
/*  39:    */ import javax.swing.JTable;
/*  40:    */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*  41:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  42:    */ import javax.swing.table.DefaultTableModel;
/*  43:    */ import javax.swing.table.TableColumn;
/*  44:    */ import javax.swing.table.TableColumnModel;
/*  45:    */ import net.sf.jasperreports.engine.JasperFillManager;
/*  46:    */ import net.sf.jasperreports.engine.JasperPrint;
/*  47:    */ import net.sf.jasperreports.engine.JasperReport;
/*  48:    */ import net.sf.jasperreports.engine.util.JRLoader;
/*  49:    */ import net.sf.jasperreports.view.JasperViewer;
/*  50:    */ 
/*  51:    */ public class registroProductoDesk
/*  52:    */   extends JInternalFrame
/*  53:    */ {
/*  54:    */   boolean alt;
/*  55:    */   ResultSet rs;
/*  56:    */   DefaultTableModel model;
/*  57: 27 */   productoDao oProducto = new productoDao();
/*  58:    */   String marca;
/*  59:    */   String modelo;
/*  60: 29 */   private static registroProductoDesk fromRegistros = null;
/*  61:    */   private JButton btnCancelar;
/*  62:    */   private JButton btnEditar;
/*  63:    */   private JButton btnImprimir;
/*  64:    */   private JButton btnNuevo;
/*  65:    */   private JButton btnRegistrar;
/*  66:    */   private JComboBox cboTipoProducto;
/*  67:    */   private JLabel jLabel1;
/*  68:    */   private JLabel jLabel2;
/*  69:    */   private JLabel jLabel3;
/*  70:    */   private JLabel jLabel4;
/*  71:    */   private JLabel jLabel5;
/*  72:    */   private JLabel jLabel6;
/*  73:    */   private JLabel jLabel7;
/*  74:    */   private JLabel jLabel8;
/*  75:    */   private JLabel jLabel9;
/*  76:    */   private JPanel jPanel1;
/*  77:    */   private JPanel jPanel2;
/*  78:    */   private JScrollPane jScrollPane1;
/*  79:    */   private JPopupMenu.Separator jSeparator2;
/*  80:    */   private JPopupMenu.Separator jSeparator4;
/*  81:    */   private JMenuItem mnuEditar;
/*  82:    */   public static JMenuItem mnuInformacion;
/*  83:    */   private JPopupMenu popInformacion;
/*  84:    */   private JTable tblRegistros;
/*  85:    */   private JTextField txtBuscar;
/*  86:    */   private JTextField txtCantidad;
/*  87:    */   private JTextField txtCodigo;
/*  88:    */   private JTextField txtEstado;
/*  89:    */   private JTextField txtMarca;
/*  90:    */   private JTextField txtObservacion;
/*  91:    */   private JTextField txtPrecio;
/*  92:    */   private JTextField txtSerie;
/*  93:    */   
/*  94:    */   public static registroProductoDesk getForm()
/*  95:    */   {
/*  96: 32 */     if (fromRegistros == null) {
/*  97: 33 */       fromRegistros = new registroProductoDesk();
/*  98:    */     }
/*  99: 35 */     return fromRegistros;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public registroProductoDesk()
/* 103:    */   {
/* 104: 39 */     initComponents();
/* 105:    */   }
/* 106:    */   
/* 107:    */   private void initComponents()
/* 108:    */   {
/* 109: 51 */     this.popInformacion = new JPopupMenu();
/* 110: 52 */     this.jSeparator2 = new JPopupMenu.Separator();
/* 111: 53 */     mnuInformacion = new JMenuItem();
/* 112: 54 */     this.mnuEditar = new JMenuItem();
/* 113: 55 */     this.jSeparator4 = new JPopupMenu.Separator();
/* 114: 56 */     this.jPanel1 = new JPanel();
/* 115: 57 */     this.jScrollPane1 = new JScrollPane();
/* 116: 58 */     this.tblRegistros = new JTable();
/* 117: 59 */     this.jPanel2 = new JPanel();
/* 118: 60 */     this.jLabel1 = new JLabel();
/* 119: 61 */     this.jLabel2 = new JLabel();
/* 120: 62 */     this.jLabel3 = new JLabel();
/* 121: 63 */     this.jLabel4 = new JLabel();
/* 122: 64 */     this.jLabel5 = new JLabel();
/* 123: 65 */     this.jLabel6 = new JLabel();
/* 124: 66 */     this.jLabel7 = new JLabel();
/* 125: 67 */     this.jLabel8 = new JLabel();
/* 126: 68 */     this.txtPrecio = new JTextField();
/* 127: 69 */     this.txtCantidad = new JTextField();
/* 128: 70 */     this.txtObservacion = new JTextField();
/* 129: 71 */     this.txtEstado = new JTextField();
/* 130: 72 */     this.txtCodigo = new JTextField();
/* 131: 73 */     this.txtMarca = new JTextField();
/* 132: 74 */     this.txtSerie = new JTextField();
/* 133: 75 */     this.cboTipoProducto = new JComboBox();
/* 134: 76 */     this.btnNuevo = new JButton();
/* 135: 77 */     this.btnEditar = new JButton();
/* 136: 78 */     this.btnImprimir = new JButton();
/* 137: 79 */     this.btnCancelar = new JButton();
/* 138: 80 */     this.btnRegistrar = new JButton();
/* 139: 81 */     this.txtBuscar = new JTextField();
/* 140: 82 */     this.jLabel9 = new JLabel();
/* 141:    */     
/* 142: 84 */     this.popInformacion.add(this.jSeparator2);
/* 143:    */     
/* 144: 86 */     mnuInformacion.setBackground(new Color(0, 51, 204));
/* 145: 87 */     mnuInformacion.setText("ver informacón");
/* 146: 88 */     mnuInformacion.addActionListener(new ActionListener()
/* 147:    */     {
/* 148:    */       public void actionPerformed(ActionEvent evt)
/* 149:    */       {
/* 150: 90 */         registroProductoDesk.this.mnuInformacionActionPerformed(evt);
/* 151:    */       }
/* 152: 92 */     });
/* 153: 93 */     this.popInformacion.add(mnuInformacion);
/* 154:    */     
/* 155: 95 */     this.mnuEditar.setBackground(new Color(0, 51, 204));
/* 156: 96 */     this.mnuEditar.setText("Modificar");
/* 157: 97 */     this.mnuEditar.addActionListener(new ActionListener()
/* 158:    */     {
/* 159:    */       public void actionPerformed(ActionEvent evt)
/* 160:    */       {
/* 161: 99 */         registroProductoDesk.this.mnuEditarActionPerformed(evt);
/* 162:    */       }
/* 163:101 */     });
/* 164:102 */     this.popInformacion.add(this.mnuEditar);
/* 165:103 */     this.popInformacion.add(this.jSeparator4);
/* 166:    */     
/* 167:105 */     setBackground(new Color(102, 102, 102));
/* 168:106 */     setClosable(true);
/* 169:107 */     setFrameIcon(new ImageIcon(getClass().getResource("/Fondos/ld.png")));
/* 170:108 */     setMinimumSize(new Dimension(1350, 620));
/* 171:109 */     setPreferredSize(new Dimension(1350, 620));
/* 172:    */     
/* 173:111 */     this.jPanel1.setBackground(new Color(102, 102, 102));
/* 174:    */     
/* 175:113 */     this.tblRegistros.setBackground(new Color(255, 255, 204));
/* 176:114 */     this.tblRegistros.setForeground(new Color(0, 0, 204));
/* 177:115 */     this.tblRegistros.setModel(new DefaultTableModel(new Object[0][], new String[] { "TIPO", "CODIGO", "MARCA", "SERIE", "PRECIO", "CANTIDAD", "OBSERVACION", "ESTADO" })
/* 178:    */     {
/* 179:123 */       Class[] types = { Object.class, Object.class, Object.class, Object.class, Double.class, Integer.class, Object.class, Object.class };
/* 180:126 */       boolean[] canEdit = { false, false, false, false, true, true, false, true };
/* 181:    */       
/* 182:    */       public Class getColumnClass(int columnIndex)
/* 183:    */       {
/* 184:131 */         return this.types[columnIndex];
/* 185:    */       }
/* 186:    */       
/* 187:    */       public boolean isCellEditable(int rowIndex, int columnIndex)
/* 188:    */       {
/* 189:135 */         return this.canEdit[columnIndex];
/* 190:    */       }
/* 191:137 */     });
/* 192:138 */     this.tblRegistros.setComponentPopupMenu(this.popInformacion);
/* 193:139 */     this.tblRegistros.setSelectionBackground(new Color(0, 0, 0));
/* 194:140 */     this.tblRegistros.setSelectionForeground(new Color(153, 255, 0));
/* 195:141 */     this.tblRegistros.addMouseListener(new MouseAdapter()
/* 196:    */     {
/* 197:    */       public void mouseClicked(MouseEvent evt)
/* 198:    */       {
/* 199:143 */         registroProductoDesk.this.tblRegistrosMouseClicked(evt);
/* 200:    */       }
/* 201:145 */     });
/* 202:146 */     this.jScrollPane1.setViewportView(this.tblRegistros);
/* 203:147 */     if (this.tblRegistros.getColumnModel().getColumnCount() > 0)
/* 204:    */     {
/* 205:148 */       this.tblRegistros.getColumnModel().getColumn(0).setMinWidth(120);
/* 206:149 */       this.tblRegistros.getColumnModel().getColumn(0).setPreferredWidth(120);
/* 207:150 */       this.tblRegistros.getColumnModel().getColumn(0).setMaxWidth(120);
/* 208:151 */       this.tblRegistros.getColumnModel().getColumn(1).setMinWidth(80);
/* 209:152 */       this.tblRegistros.getColumnModel().getColumn(1).setPreferredWidth(80);
/* 210:153 */       this.tblRegistros.getColumnModel().getColumn(1).setMaxWidth(80);
/* 211:154 */       this.tblRegistros.getColumnModel().getColumn(2).setMinWidth(100);
/* 212:155 */       this.tblRegistros.getColumnModel().getColumn(2).setPreferredWidth(100);
/* 213:156 */       this.tblRegistros.getColumnModel().getColumn(2).setMaxWidth(100);
/* 214:157 */       this.tblRegistros.getColumnModel().getColumn(3).setMinWidth(90);
/* 215:158 */       this.tblRegistros.getColumnModel().getColumn(3).setPreferredWidth(90);
/* 216:159 */       this.tblRegistros.getColumnModel().getColumn(3).setMaxWidth(90);
/* 217:160 */       this.tblRegistros.getColumnModel().getColumn(4).setMinWidth(60);
/* 218:161 */       this.tblRegistros.getColumnModel().getColumn(4).setPreferredWidth(60);
/* 219:162 */       this.tblRegistros.getColumnModel().getColumn(4).setMaxWidth(60);
/* 220:163 */       this.tblRegistros.getColumnModel().getColumn(5).setMinWidth(70);
/* 221:164 */       this.tblRegistros.getColumnModel().getColumn(5).setPreferredWidth(70);
/* 222:165 */       this.tblRegistros.getColumnModel().getColumn(5).setMaxWidth(70);
/* 223:166 */       this.tblRegistros.getColumnModel().getColumn(7).setMinWidth(120);
/* 224:167 */       this.tblRegistros.getColumnModel().getColumn(7).setPreferredWidth(120);
/* 225:168 */       this.tblRegistros.getColumnModel().getColumn(7).setMaxWidth(120);
/* 226:    */     }
/* 227:171 */     this.jLabel1.setText("T I P O :");
/* 228:    */     
/* 229:173 */     this.jLabel2.setText("C O D I G O :");
/* 230:    */     
/* 231:175 */     this.jLabel3.setText("M A R C A :");
/* 232:    */     
/* 233:177 */     this.jLabel4.setText("S E R I E :");
/* 234:    */     
/* 235:179 */     this.jLabel5.setText("P R E C I O :");
/* 236:    */     
/* 237:181 */     this.jLabel6.setText("C A N T I D A D :");
/* 238:    */     
/* 239:183 */     this.jLabel7.setText("O B S E R V A C I O N :");
/* 240:    */     
/* 241:185 */     this.jLabel8.setText("E S T A D O :");
/* 242:    */     
/* 243:187 */     this.txtPrecio.setEditable(false);
/* 244:188 */     this.txtPrecio.setFont(new Font("sansserif", 0, 14));
/* 245:189 */     this.txtPrecio.setHorizontalAlignment(0);
/* 246:190 */     this.txtPrecio.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 247:    */     
/* 248:192 */     this.txtCantidad.setEditable(false);
/* 249:193 */     this.txtCantidad.setFont(new Font("sansserif", 0, 14));
/* 250:194 */     this.txtCantidad.setHorizontalAlignment(0);
/* 251:195 */     this.txtCantidad.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 252:    */     
/* 253:197 */     this.txtObservacion.setEditable(false);
/* 254:198 */     this.txtObservacion.setFont(new Font("sansserif", 0, 14));
/* 255:199 */     this.txtObservacion.setHorizontalAlignment(0);
/* 256:200 */     this.txtObservacion.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 257:    */     
/* 258:202 */     this.txtEstado.setEditable(false);
/* 259:203 */     this.txtEstado.setFont(new Font("sansserif", 0, 14));
/* 260:204 */     this.txtEstado.setHorizontalAlignment(0);
/* 261:205 */     this.txtEstado.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 262:    */     
/* 263:207 */     this.txtCodigo.setEditable(false);
/* 264:208 */     this.txtCodigo.setFont(new Font("sansserif", 0, 14));
/* 265:209 */     this.txtCodigo.setHorizontalAlignment(0);
/* 266:210 */     this.txtCodigo.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 267:    */     
/* 268:212 */     this.txtMarca.setEditable(false);
/* 269:213 */     this.txtMarca.setFont(new Font("sansserif", 0, 14));
/* 270:214 */     this.txtMarca.setHorizontalAlignment(0);
/* 271:215 */     this.txtMarca.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 272:    */     
/* 273:217 */     this.txtSerie.setEditable(false);
/* 274:218 */     this.txtSerie.setFont(new Font("sansserif", 0, 14));
/* 275:219 */     this.txtSerie.setHorizontalAlignment(0);
/* 276:220 */     this.txtSerie.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 277:    */     
/* 278:222 */     this.cboTipoProducto.setBackground(new Color(51, 51, 51));
/* 279:223 */     this.cboTipoProducto.setForeground(new Color(0, 102, 204));
/* 280:224 */     this.cboTipoProducto.setModel(new DefaultComboBoxModel(new String[] { "MOVIL", "BATERIAS", "CARGASA", "CARGADORES", "PANTALLA" }));
/* 281:225 */     this.cboTipoProducto.setCursor(new Cursor(12));
/* 282:226 */     this.cboTipoProducto.setName("SELECIONE UN TIPO");
/* 283:    */     
/* 284:228 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 285:229 */     this.jPanel2.setLayout(jPanel2Layout);
/* 286:230 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jLabel1, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel3, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel4, GroupLayout.Alignment.TRAILING)).addGap(36, 36, 36).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.txtSerie, -2, 249, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel8)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.txtMarca, -2, 249, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 197, 32767).addComponent(this.jLabel7)).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.cboTipoProducto, 0, 249, 32767).addComponent(this.txtCodigo)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel6, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel5, GroupLayout.Alignment.TRAILING)))).addGap(76, 76, 76).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtPrecio, -2, 249, -2).addComponent(this.txtCantidad, -2, 249, -2).addComponent(this.txtObservacion, -2, 249, -2).addComponent(this.txtEstado, -2, 249, -2)).addGap(176, 176, 176)));
/* 287:    */     
/* 288:    */ 
/* 289:    */ 
/* 290:    */ 
/* 291:    */ 
/* 292:    */ 
/* 293:    */ 
/* 294:    */ 
/* 295:    */ 
/* 296:    */ 
/* 297:    */ 
/* 298:    */ 
/* 299:    */ 
/* 300:    */ 
/* 301:    */ 
/* 302:    */ 
/* 303:    */ 
/* 304:    */ 
/* 305:    */ 
/* 306:    */ 
/* 307:    */ 
/* 308:    */ 
/* 309:    */ 
/* 310:    */ 
/* 311:    */ 
/* 312:    */ 
/* 313:    */ 
/* 314:    */ 
/* 315:    */ 
/* 316:    */ 
/* 317:    */ 
/* 318:    */ 
/* 319:    */ 
/* 320:    */ 
/* 321:265 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(6, 6, 6).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jLabel5).addComponent(this.txtPrecio, -2, -1, -2).addComponent(this.cboTipoProducto, -1, -1, -2)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jLabel6).addComponent(this.txtCantidad, -2, -1, -2).addComponent(this.txtCodigo, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jLabel7).addComponent(this.txtObservacion, -2, -1, -2).addComponent(this.txtMarca, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jLabel8).addComponent(this.txtEstado, -2, -1, -2).addComponent(this.txtSerie, -2, -1, -2)).addContainerGap(63, 32767)));
/* 322:    */     
/* 323:    */ 
/* 324:    */ 
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
/* 351:295 */     this.btnNuevo.setBackground(new Color(153, 153, 255));
/* 352:296 */     this.btnNuevo.setIcon(new ImageIcon(getClass().getResource("/Iconos/NUEVO.PNG")));
/* 353:297 */     this.btnNuevo.setText("NUEVO");
/* 354:298 */     this.btnNuevo.setBorderPainted(false);
/* 355:299 */     this.btnNuevo.setHorizontalTextPosition(0);
/* 356:300 */     this.btnNuevo.setVerticalTextPosition(3);
/* 357:301 */     this.btnNuevo.addActionListener(new ActionListener()
/* 358:    */     {
/* 359:    */       public void actionPerformed(ActionEvent evt)
/* 360:    */       {
/* 361:303 */         registroProductoDesk.this.btnNuevoActionPerformed(evt);
/* 362:    */       }
/* 363:306 */     });
/* 364:307 */     this.btnEditar.setBackground(new Color(153, 153, 255));
/* 365:308 */     this.btnEditar.setIcon(new ImageIcon(getClass().getResource("/Iconos/EDITAR.PNG")));
/* 366:309 */     this.btnEditar.setText("EDITAR");
/* 367:310 */     this.btnEditar.setBorderPainted(false);
/* 368:311 */     this.btnEditar.setHorizontalTextPosition(0);
/* 369:312 */     this.btnEditar.setVerticalTextPosition(3);
/* 370:313 */     this.btnEditar.addActionListener(new ActionListener()
/* 371:    */     {
/* 372:    */       public void actionPerformed(ActionEvent evt)
/* 373:    */       {
/* 374:315 */         registroProductoDesk.this.btnEditarActionPerformed(evt);
/* 375:    */       }
/* 376:318 */     });
/* 377:319 */     this.btnImprimir.setBackground(new Color(153, 153, 255));
/* 378:320 */     this.btnImprimir.setIcon(new ImageIcon(getClass().getResource("/icon/print-32.png")));
/* 379:321 */     this.btnImprimir.setText("IMPRIMIR");
/* 380:322 */     this.btnImprimir.setBorderPainted(false);
/* 381:323 */     this.btnImprimir.setHorizontalTextPosition(0);
/* 382:324 */     this.btnImprimir.setVerticalTextPosition(3);
/* 383:325 */     this.btnImprimir.addActionListener(new ActionListener()
/* 384:    */     {
/* 385:    */       public void actionPerformed(ActionEvent evt)
/* 386:    */       {
/* 387:327 */         registroProductoDesk.this.btnImprimirActionPerformed(evt);
/* 388:    */       }
/* 389:330 */     });
/* 390:331 */     this.btnCancelar.setBackground(new Color(153, 153, 255));
/* 391:332 */     this.btnCancelar.setIcon(new ImageIcon(getClass().getResource("/Iconos/CANCELAR.PNG")));
/* 392:333 */     this.btnCancelar.setText("CANCELAR");
/* 393:334 */     this.btnCancelar.setBorderPainted(false);
/* 394:335 */     this.btnCancelar.setEnabled(false);
/* 395:336 */     this.btnCancelar.setHorizontalTextPosition(0);
/* 396:337 */     this.btnCancelar.setVerticalTextPosition(3);
/* 397:338 */     this.btnCancelar.addActionListener(new ActionListener()
/* 398:    */     {
/* 399:    */       public void actionPerformed(ActionEvent evt)
/* 400:    */       {
/* 401:340 */         registroProductoDesk.this.btnCancelarActionPerformed(evt);
/* 402:    */       }
/* 403:343 */     });
/* 404:344 */     this.btnRegistrar.setBackground(new Color(153, 153, 255));
/* 405:345 */     this.btnRegistrar.setIcon(new ImageIcon(getClass().getResource("/Iconos/GUARDAR.PNG")));
/* 406:346 */     this.btnRegistrar.setText("REGISTRAR");
/* 407:347 */     this.btnRegistrar.setBorderPainted(false);
/* 408:348 */     this.btnRegistrar.setEnabled(false);
/* 409:349 */     this.btnRegistrar.setHorizontalTextPosition(0);
/* 410:350 */     this.btnRegistrar.setPressedIcon(new ImageIcon(getClass().getResource("/Iconos/GUARDARpre.PNG")));
/* 411:351 */     this.btnRegistrar.setRolloverIcon(new ImageIcon(getClass().getResource("/Iconos/GUARDAR.PNG")));
/* 412:352 */     this.btnRegistrar.setVerticalTextPosition(3);
/* 413:353 */     this.btnRegistrar.addActionListener(new ActionListener()
/* 414:    */     {
/* 415:    */       public void actionPerformed(ActionEvent evt)
/* 416:    */       {
/* 417:355 */         registroProductoDesk.this.btnRegistrarActionPerformed(evt);
/* 418:    */       }
/* 419:358 */     });
/* 420:359 */     this.txtBuscar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 421:360 */     this.txtBuscar.addKeyListener(new KeyAdapter()
/* 422:    */     {
/* 423:    */       public void keyReleased(KeyEvent evt)
/* 424:    */       {
/* 425:362 */         registroProductoDesk.this.txtBuscarKeyReleased(evt);
/* 426:    */       }
/* 427:365 */     });
/* 428:366 */     this.jLabel9.setFont(new Font("sansserif", 1, 14));
/* 429:367 */     this.jLabel9.setForeground(new Color(255, 255, 255));
/* 430:368 */     this.jLabel9.setText("Filtrar productos en stock:");
/* 431:    */     
/* 432:370 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 433:371 */     this.jPanel1.setLayout(jPanel1Layout);
/* 434:372 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane1).addComponent(this.jPanel2, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnNuevo, -1, -1, 32767).addComponent(this.btnEditar, -1, -1, 32767).addComponent(this.btnImprimir, -1, -1, 32767).addComponent(this.btnCancelar, -1, -1, 32767).addComponent(this.btnRegistrar, -1, 107, 32767)).addGap(21, 21, 21)).addGroup(jPanel1Layout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.jLabel9).addGap(18, 18, 18).addComponent(this.txtBuscar, -2, 386, -2).addContainerGap(-1, 32767)));
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
/* 456:394 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(11, 11, 11).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel9).addGroup(jPanel1Layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.txtBuscar, -2, 27, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.btnNuevo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnRegistrar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnEditar).addGap(18, 18, 18).addComponent(this.btnImprimir).addGap(18, 18, 18).addComponent(this.btnCancelar).addContainerGap(-1, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 298, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, 32767).addComponent(this.jPanel2, -2, -1, -2).addContainerGap(17, 32767)))));
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
/* 476:    */ 
/* 477:    */ 
/* 478:    */ 
/* 479:    */ 
/* 480:    */ 
/* 481:    */ 
/* 482:    */ 
/* 483:    */ 
/* 484:    */ 
/* 485:423 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 486:424 */     getContentPane().setLayout(layout);
/* 487:425 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/* 488:    */     
/* 489:    */ 
/* 490:    */ 
/* 491:429 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/* 492:    */     
/* 493:    */ 
/* 494:    */ 
/* 495:    */ 
/* 496:434 */     pack();
/* 497:    */   }
/* 498:    */   
/* 499:    */   private void btnNuevoActionPerformed(ActionEvent evt)
/* 500:    */   {
/* 501:438 */     habilitaControles(true);
/* 502:439 */     limpiaControles();
/* 503:440 */     this.alt = true;
/* 504:    */   }
/* 505:    */   
/* 506:    */   private void btnEditarActionPerformed(ActionEvent evt)
/* 507:    */   {
/* 508:444 */     habilitaControles(true);
/* 509:    */     
/* 510:446 */     this.alt = false;
/* 511:    */   }
/* 512:    */   
/* 513:    */   private void btnImprimirActionPerformed(ActionEvent evt)
/* 514:    */   {
/* 515:    */     try
/* 516:    */     {
/* 517:451 */       Connection con = conexion.getInstance().getConnection();
/* 518:452 */       JasperReport report = (JasperReport)JRLoader.loadObject("C:\\LEDATEL\\reportes\\reporte_productos.jasper");
/* 519:453 */       JasperPrint print = JasperFillManager.fillReport(report, null, con);
/* 520:454 */       JasperViewer.viewReport(print, false);
/* 521:    */     }
/* 522:    */     catch (Exception e)
/* 523:    */     {
/* 524:456 */       System.out.println(e);
/* 525:    */     }
/* 526:    */   }
/* 527:    */   
/* 528:    */   private void btnCancelarActionPerformed(ActionEvent evt)
/* 529:    */   {
/* 530:461 */     cargaRegistros();
/* 531:462 */     habilitaControles(false);
/* 532:    */   }
/* 533:    */   
/* 534:    */   private void btnRegistrarActionPerformed(ActionEvent evt)
/* 535:    */   {
/* 536:    */     try
/* 537:    */     {
/* 538:468 */       producto_TO to = new producto_TO();
/* 539:469 */       to.setProveedor("PRV000");
/* 540:470 */       to.setTipo(this.cboTipoProducto.getSelectedItem().toString());
/* 541:471 */       to.setCodigoProd(this.txtCodigo.getText().toLowerCase().trim());
/* 542:472 */       to.setMarca(this.txtMarca.getText().toLowerCase().trim());
/* 543:473 */       to.setModelo(this.txtSerie.getText().toUpperCase());
/* 544:474 */       to.setPrecioCpmpra(0.0D);
/* 545:475 */       to.setPrecioVenta(Double.parseDouble(this.txtPrecio.getText()));
/* 546:476 */       to.setStock(Integer.parseInt(this.txtCantidad.getText()));
/* 547:477 */       to.setDescripcion(this.txtObservacion.getText());
/* 548:478 */       to.setEstado(this.txtEstado.getText().toUpperCase().trim());
/* 549:479 */       if (this.alt)
/* 550:    */       {
/* 551:480 */         this.oProducto.registrar_Producto(to);
/* 552:    */       }
/* 553:    */       else
/* 554:    */       {
/* 555:482 */         this.rs = this.oProducto.obternerCodigo();
/* 556:483 */         while (this.rs.next()) {
/* 557:484 */           if (this.txtCodigo.getText().equals(this.rs.getString(2)))
/* 558:    */           {
/* 559:485 */             System.out.println(this.rs.getString(1));
/* 560:486 */             to.setCodigoProd(this.rs.getString(1));
/* 561:487 */             to.setPrecioVenta(Double.parseDouble(this.txtPrecio.getText()));
/* 562:488 */             to.setStock(Integer.parseInt(this.txtCantidad.getText()));
/* 563:489 */             to.setEstado(this.txtEstado.getText().toUpperCase().trim());
/* 564:    */           }
/* 565:    */         }
/* 566:493 */         this.oProducto.modificar_Producto(to);
/* 567:494 */         JOptionPane.showMessageDialog(this.rootPane, "registros modificados...");
/* 568:    */       }
/* 569:    */     }
/* 570:    */     catch (Exception e)
/* 571:    */     {
/* 572:497 */       System.out.println(e);
/* 573:    */     }
/* 574:500 */     habilitaControles(false);
/* 575:    */   }
/* 576:    */   
/* 577:    */   private void mnuInformacionActionPerformed(ActionEvent evt)
/* 578:    */   {
/* 579:504 */     informacion_productoDesk g = new informacion_productoDesk();
/* 580:505 */     VentanaPrincipalGUI.desk.add(g);
/* 581:506 */     g.show();
/* 582:507 */     informacion_productoDesk.txtCodigo.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 1).toString());
/* 583:    */   }
/* 584:    */   
/* 585:    */   private void txtBuscarKeyReleased(KeyEvent evt)
/* 586:    */   {
/* 587:    */     try
/* 588:    */     {
/* 589:512 */       this.marca = this.txtBuscar.getText().toLowerCase();
/* 590:513 */       this.modelo = this.txtBuscar.getText().toLowerCase();
/* 591:514 */       this.model = ((DefaultTableModel)this.tblRegistros.getModel());
/* 592:515 */       this.rs = this.oProducto.buscarProductoVentas(this.marca, this.modelo);
/* 593:516 */       while (this.tblRegistros.getRowCount() > 0) {
/* 594:517 */         this.model.removeRow(0);
/* 595:    */       }
/* 596:519 */       if (!this.txtBuscar.getText().isEmpty()) {
/* 597:522 */         cargaTABLE();
/* 598:    */       }
/* 599:    */     }
/* 600:    */     catch (Exception e) {}
/* 601:    */   }
/* 602:    */   
/* 603:    */   private void tblRegistrosMouseClicked(MouseEvent evt)
/* 604:    */   {
/* 605:529 */     cargaRegistros();
/* 606:    */   }
/* 607:    */   
/* 608:    */   private void mnuEditarActionPerformed(ActionEvent evt)
/* 609:    */   {
/* 610:    */     try
/* 611:    */     {
/* 612:534 */       this.model = ((DefaultTableModel)this.tblRegistros.getModel());
/* 613:535 */       producto_TO to = new producto_TO();
/* 614:536 */       this.rs = this.oProducto.obternerCodigo();
/* 615:537 */       for (int i = 0; i < this.model.getRowCount(); i++)
/* 616:    */       {
/* 617:538 */         while (this.rs.next()) {
/* 618:539 */           if (this.tblRegistros.getValueAt(i, 1).toString().equals(this.rs.getString(2)))
/* 619:    */           {
/* 620:540 */             to.setCodigoProd(this.rs.getString(1));
/* 621:541 */             System.out.println(this.rs.getString(1));
/* 622:542 */             to.setPrecioVenta(Double.parseDouble(this.tblRegistros.getValueAt(i, 4).toString()));
/* 623:543 */             to.setStock(Integer.parseInt(this.tblRegistros.getValueAt(i, 5).toString()));
/* 624:544 */             to.setEstado(this.tblRegistros.getValueAt(i, 7).toString().toUpperCase().trim());
/* 625:    */           }
/* 626:    */         }
/* 627:548 */         this.oProducto.modificar_Producto(to);
/* 628:    */       }
/* 629:550 */       JOptionPane.showMessageDialog(null, "Producto modificado");
/* 630:    */     }
/* 631:    */     catch (Exception e)
/* 632:    */     {
/* 633:552 */       System.out.println(e);
/* 634:    */     }
/* 635:    */   }
/* 636:    */   
/* 637:    */   private void habilitaControles(boolean b)
/* 638:    */   {
/* 639:594 */     JTextField[] field = { this.txtCantidad, this.txtCodigo, this.txtEstado, this.txtMarca, this.txtObservacion, this.txtPrecio, this.txtSerie };
/* 640:597 */     for (JTextField txt : field) {
/* 641:598 */       txt.setEditable(b);
/* 642:    */     }
/* 643:600 */     JButton[] btn = { this.btnEditar, this.btnImprimir, this.btnNuevo };
/* 644:603 */     for (JButton button : btn) {
/* 645:604 */       button.setEnabled(!b);
/* 646:    */     }
/* 647:606 */     this.btnRegistrar.setEnabled(b);
/* 648:607 */     this.btnCancelar.setEnabled(b);
/* 649:608 */     this.txtCodigo.grabFocus();
/* 650:    */   }
/* 651:    */   
/* 652:    */   private void limpiaControles()
/* 653:    */   {
/* 654:613 */     JTextField[] field = { this.txtCantidad, this.txtCodigo, this.txtEstado, this.txtMarca, this.txtObservacion, this.txtPrecio, this.txtSerie };
/* 655:616 */     for (JTextField txt : field) {
/* 656:617 */       txt.setText("");
/* 657:    */     }
/* 658:    */   }
/* 659:    */   
/* 660:    */   private void cargaTABLE()
/* 661:    */   {
/* 662:    */     try
/* 663:    */     {
/* 664:623 */       while (this.rs.next())
/* 665:    */       {
/* 666:624 */         Object[] regi = { this.rs.getString(1), this.rs.getString(2), this.rs.getString(3), this.rs.getString(4), Double.valueOf(this.rs.getDouble(5)), Integer.valueOf(this.rs.getInt(6)), this.rs.getString(7), this.rs.getString(8) };
/* 667:    */         
/* 668:    */ 
/* 669:    */ 
/* 670:628 */         this.model.addRow(regi);
/* 671:    */       }
/* 672:    */     }
/* 673:    */     catch (Exception e)
/* 674:    */     {
/* 675:631 */       System.out.println(e);
/* 676:    */     }
/* 677:    */   }
/* 678:    */   
/* 679:    */   private void cargaRegistros()
/* 680:    */   {
/* 681:636 */     this.cboTipoProducto.removeAllItems();
/* 682:637 */     this.cboTipoProducto.addItem(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 0).toString());
/* 683:638 */     this.txtCodigo.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 1).toString());
/* 684:639 */     this.txtMarca.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 2).toString());
/* 685:640 */     this.txtSerie.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 3).toString());
/* 686:641 */     this.txtPrecio.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 4).toString());
/* 687:642 */     this.txtCantidad.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 5).toString());
/* 688:643 */     this.txtObservacion.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 6).toString());
/* 689:644 */     this.txtEstado.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 7).toString());
/* 690:    */   }
/* 691:    */ }



/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar

 * Qualified Name:     Desk.registroProductoDesk

 * JD-Core Version:    0.7.0.1

 */