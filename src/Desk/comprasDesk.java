/*   1:    */ package Desk;
/*   2:    */ 
/*   3:    */ import Dao.productoDao;
/*   4:    */ import Dao.proveedorDao;
/*   5:    */ import Gui.VentanaPrincipalGUI;
/*   6:    */ import Log_Reporte.reporte_Compras;
/*   7:    */ import To.producto_TO;
/*   8:    */ import datechooser.beans.DateChooserCombo;
/*   9:    */ import datechooser.events.CommitEvent;
/*  10:    */ import datechooser.events.CommitListener;
/*  11:    */ import datechooser.view.BackRenderer;
/*  12:    */ import datechooser.view.appearance.AppearancesList;
/*  13:    */ import datechooser.view.appearance.ViewAppearance;
/*  14:    */ import datechooser.view.appearance.swing.ButtonPainter;
/*  15:    */ import datechooser.view.appearance.swing.LabelPainter;
/*  16:    */ import datechooser.view.appearance.swing.SwingCellAppearance;
/*  17:    */ import java.awt.Color;
/*  18:    */ import java.awt.Container;
/*  19:    */ import java.awt.Cursor;
/*  20:    */ import java.awt.Dimension;
/*  21:    */ import java.awt.Font;
/*  22:    */ import java.awt.event.ActionEvent;
/*  23:    */ import java.awt.event.ActionListener;
/*  24:    */ import java.awt.event.KeyAdapter;
/*  25:    */ import java.awt.event.KeyEvent;
/*  26:    */ import java.awt.event.MouseAdapter;
/*  27:    */ import java.awt.event.MouseEvent;
/*  28:    */ import java.awt.event.MouseMotionAdapter;
/*  29:    */ import java.io.PrintStream;
/*  30:    */ import java.sql.ResultSet;
/*  31:    */ import java.util.ArrayList;
/*  32:    */ import java.util.Calendar;
/*  33:    */ import java.util.HashMap;
/*  34:    */ import java.util.List;
/*  35:    */ import java.util.Locale;
/*  36:    */ import java.util.Map;
/*  37:    */ import javax.swing.BorderFactory;
/*  38:    */ import javax.swing.DefaultComboBoxModel;
/*  39:    */ import javax.swing.GroupLayout;
/*  40:    */ import javax.swing.GroupLayout.Alignment;
/*  41:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  42:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  43:    */ import javax.swing.ImageIcon;
/*  44:    */ import javax.swing.JButton;
/*  45:    */ import javax.swing.JComboBox;
/*  46:    */ import javax.swing.JDesktopPane;
/*  47:    */ import javax.swing.JInternalFrame;
/*  48:    */ import javax.swing.JLabel;
/*  49:    */ import javax.swing.JOptionPane;
/*  50:    */ import javax.swing.JPanel;
/*  51:    */ import javax.swing.JScrollPane;
/*  52:    */ import javax.swing.JTable;
/*  53:    */ import javax.swing.JTextArea;
/*  54:    */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*  55:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  56:    */ import javax.swing.table.DefaultTableModel;
/*  57:    */ import javax.swing.table.TableColumn;
/*  58:    */ import javax.swing.table.TableColumnModel;
/*  59:    */ import net.sf.jasperreports.engine.JasperFillManager;
/*  60:    */ import net.sf.jasperreports.engine.JasperPrint;
/*  61:    */ import net.sf.jasperreports.engine.JasperReport;
/*  62:    */ import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
/*  63:    */ import net.sf.jasperreports.engine.util.JRLoader;
/*  64:    */ import net.sf.jasperreports.view.JasperViewer;
/*  65:    */ 
/*  66:    */ public class comprasDesk
/*  67:    */   extends JInternalFrame
/*  68:    */ {
/*  69: 35 */   private static comprasDesk fromCompras = null;
/*  70:    */   
/*  71:    */   public static comprasDesk getForm()
/*  72:    */   {
/*  73: 38 */     if (fromCompras == null) {
/*  74: 39 */       fromCompras = new comprasDesk();
/*  75:    */     }
/*  76: 41 */     return fromCompras;
/*  77:    */   }
/*  78:    */   
/*  79: 43 */   productoDao oProducto = new productoDao();
/*  80:    */   ResultSet rs;
/*  81:    */   DefaultTableModel model;
/*  82:    */   String cod_Proveedor;
/*  83:    */   double gastos;
/*  84:    */   int stock;
/*  85:    */   private JButton btnBuscar;
/*  86:    */   private JButton btnCancelar;
/*  87:    */   private JButton btnGuardar;
/*  88:    */   private JButton btnImprimir;
/*  89:    */   private JButton btnLimpiar;
/*  90:    */   private JButton btnMore;
/*  91:    */   private JButton btnNuevo;
/*  92:    */   private JButton btnSalir;
/*  93:    */   private JComboBox cboEstado;
/*  94:    */   private JComboBox cboTIPO;
/*  95:    */   private DateChooserCombo dateFechaFinal;
/*  96:    */   private DateChooserCombo dateFechaInicial;
/*  97:    */   private JLabel jLabel1;
/*  98:    */   private JLabel jLabel10;
/*  99:    */   private JLabel jLabel11;
/* 100:    */   private JLabel jLabel12;
/* 101:    */   private JLabel jLabel13;
/* 102:    */   private JLabel jLabel2;
/* 103:    */   private JLabel jLabel3;
/* 104:    */   private JLabel jLabel4;
/* 105:    */   private JLabel jLabel5;
/* 106:    */   private JLabel jLabel6;
/* 107:    */   private JLabel jLabel7;
/* 108:    */   private JLabel jLabel8;
/* 109:    */   private JLabel jLabel9;
/* 110:    */   private JPanel jPanel1;
/* 111:    */   private JPanel jPanel2;
/* 112:    */   private JPanel jPanel3;
/* 113:    */   private JScrollPane jScrollPane1;
/* 114:    */   private JScrollPane jScrollPane2;
/* 115:    */   private JLabel lblFechaActual;
/* 116:    */   private JTable tblControlCompras;
/* 117:    */   public static JTextField txtCod_proveedor;
/* 118:    */   private JTextField txtCodigo_producto;
/* 119:    */   private JTextArea txtDescripcion;
/* 120:    */   private JTextField txtGastos;
/* 121:    */   private JTextField txtMarca;
/* 122:    */   private JTextField txtPrecio_Compra;
/* 123:    */   private JTextField txtPrecio_venta;
/* 124:    */   private JTextField txtSerie;
/* 125:    */   private JTextField txtStock;
/* 126:    */   
/* 127:    */   public comprasDesk()
/* 128:    */   {
/* 129: 51 */     initComponents();
/* 130: 52 */     calendario();
/* 131:    */   }
/* 132:    */   
/* 133:    */   private void initComponents()
/* 134:    */   {
/* 135: 59 */     this.jPanel1 = new JPanel();
/* 136: 60 */     this.dateFechaInicial = new DateChooserCombo();
/* 137: 61 */     this.jLabel8 = new JLabel();
/* 138: 62 */     this.jLabel6 = new JLabel();
/* 139: 63 */     this.btnBuscar = new JButton();
/* 140: 64 */     this.jScrollPane1 = new JScrollPane();
/* 141: 65 */     this.tblControlCompras = new JTable();
/* 142: 66 */     this.btnLimpiar = new JButton();
/* 143: 67 */     this.btnImprimir = new JButton();
/* 144: 68 */     this.jPanel2 = new JPanel();
/* 145: 69 */     this.lblFechaActual = new JLabel();
/* 146: 70 */     this.btnSalir = new JButton();
/* 147: 71 */     this.jLabel1 = new JLabel();
/* 148: 72 */     this.jLabel2 = new JLabel();
/* 149: 73 */     this.jLabel3 = new JLabel();
/* 150: 74 */     this.jLabel4 = new JLabel();
/* 151: 75 */     this.jLabel5 = new JLabel();
/* 152: 76 */     this.jLabel7 = new JLabel();
/* 153: 77 */     this.jLabel10 = new JLabel();
/* 154: 78 */     this.jLabel11 = new JLabel();
/* 155: 79 */     this.txtCodigo_producto = new JTextField();
/* 156: 80 */     this.txtMarca = new JTextField();
/* 157: 81 */     this.txtSerie = new JTextField();
/* 158: 82 */     this.txtPrecio_Compra = new JTextField();
/* 159: 83 */     this.dateFechaFinal = new DateChooserCombo();
/* 160: 84 */     this.txtPrecio_venta = new JTextField();
/* 161: 85 */     this.txtStock = new JTextField();
/* 162: 86 */     txtCod_proveedor = new JTextField();
/* 163: 87 */     this.btnMore = new JButton();
/* 164: 88 */     this.btnNuevo = new JButton();
/* 165: 89 */     this.btnGuardar = new JButton();
/* 166: 90 */     this.btnCancelar = new JButton();
/* 167: 91 */     this.jPanel3 = new JPanel();
/* 168: 92 */     this.jLabel12 = new JLabel();
/* 169: 93 */     this.txtGastos = new JTextField();
/* 170: 94 */     this.jLabel9 = new JLabel();
/* 171: 95 */     this.cboTIPO = new JComboBox();
/* 172: 96 */     this.jLabel13 = new JLabel();
/* 173: 97 */     this.cboEstado = new JComboBox();
/* 174: 98 */     this.jScrollPane2 = new JScrollPane();
/* 175: 99 */     this.txtDescripcion = new JTextArea();
/* 176:    */     
/* 177:101 */     setClosable(true);
/* 178:102 */     setIconifiable(true);
/* 179:103 */     setMaximizable(true);
/* 180:104 */     setTitle("Registrosmy control de compra de productos");
/* 181:105 */     setMinimumSize(new Dimension(1350, 620));
/* 182:106 */     setPreferredSize(new Dimension(1350, 620));
/* 183:    */     
/* 184:108 */     this.jPanel1.setBackground(new Color(102, 102, 102));
/* 185:    */     
/* 186:110 */     this.dateFechaInicial.setCurrentView(new AppearancesList("Grey", new ViewAppearance[] { new ViewAppearance("custom", new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 0), new Color(0, 0, 255), false, true, new ButtonPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 0), new Color(0, 0, 255), true, true, new ButtonPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 255), new Color(0, 0, 255), false, true, new ButtonPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(128, 128, 128), new Color(0, 0, 255), false, true, new LabelPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 0), new Color(0, 0, 255), false, true, new LabelPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 0), new Color(255, 0, 0), false, false, new ButtonPainter()), (BackRenderer)null, false, true) }));
/* 187:    */     
/* 188:    */ 
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
/* 199:    */ 
/* 200:    */ 
/* 201:    */ 
/* 202:    */ 
/* 203:    */ 
/* 204:    */ 
/* 205:    */ 
/* 206:    */ 
/* 207:    */ 
/* 208:    */ 
/* 209:    */ 
/* 210:    */ 
/* 211:    */ 
/* 212:    */ 
/* 213:    */ 
/* 214:    */ 
/* 215:    */ 
/* 216:    */ 
/* 217:    */ 
/* 218:    */ 
/* 219:    */ 
/* 220:    */ 
/* 221:    */ 
/* 222:    */ 
/* 223:    */ 
/* 224:    */ 
/* 225:    */ 
/* 226:    */ 
/* 227:151 */     this.dateFechaInicial.setCalendarBackground(new Color(204, 255, 255));
/* 228:152 */     this.dateFechaInicial.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 229:153 */     this.dateFechaInicial.setCalendarPreferredSize(new Dimension(441, 270));
/* 230:154 */     this.dateFechaInicial.setNothingAllowed(false);
/* 231:155 */     this.dateFechaInicial.setLocale(new Locale("pt", "BR", ""));
/* 232:156 */     this.dateFechaInicial.addCommitListener(new CommitListener()
/* 233:    */     {
/* 234:    */       public void onCommit(CommitEvent evt)
/* 235:    */       {
/* 236:158 */         comprasDesk.this.dateFechaInicialOnCommit(evt);
/* 237:    */       }
/* 238:161 */     });
/* 239:162 */     this.jLabel8.setFont(new Font("sansserif", 1, 14));
/* 240:163 */     this.jLabel8.setForeground(new Color(255, 255, 255));
/* 241:164 */     this.jLabel8.setText("F E C H A   F I N A L :");
/* 242:    */     
/* 243:166 */     this.jLabel6.setFont(new Font("sansserif", 1, 14));
/* 244:167 */     this.jLabel6.setForeground(new Color(255, 255, 255));
/* 245:168 */     this.jLabel6.setText("F E C H A   I N I C I A L :");
/* 246:    */     
/* 247:170 */     this.btnBuscar.setBackground(new Color(153, 204, 255));
/* 248:171 */     this.btnBuscar.setIcon(new ImageIcon(getClass().getResource("/icon/search-32.png")));
/* 249:172 */     this.btnBuscar.setText("Buscar");
/* 250:173 */     this.btnBuscar.addActionListener(new ActionListener()
/* 251:    */     {
/* 252:    */       public void actionPerformed(ActionEvent evt)
/* 253:    */       {
/* 254:175 */         comprasDesk.this.btnBuscarActionPerformed(evt);
/* 255:    */       }
/* 256:178 */     });
/* 257:179 */     this.tblControlCompras.setBackground(new Color(153, 153, 255));
/* 258:180 */     this.tblControlCompras.setModel(new DefaultTableModel(new Object[0][], new String[] { "CODIGO", "MARCA", "S E R I E", "PREC. COMPRA", "PREC. VENTA", "STOCK", "FECHA", "PROVEEDOR", "ESTADO" })
/* 259:    */     {
/* 260:188 */       Class[] types = { String.class, String.class, String.class, Double.class, Double.class, Integer.class, String.class, String.class, Object.class };
/* 261:191 */       boolean[] canEdit = { false, false, false, false, true, false, false, false, true };
/* 262:    */       
/* 263:    */       public Class getColumnClass(int columnIndex)
/* 264:    */       {
/* 265:196 */         return this.types[columnIndex];
/* 266:    */       }
/* 267:    */       
/* 268:    */       public boolean isCellEditable(int rowIndex, int columnIndex)
/* 269:    */       {
/* 270:200 */         return this.canEdit[columnIndex];
/* 271:    */       }
/* 272:202 */     });
/* 273:203 */     this.tblControlCompras.setOpaque(false);
/* 274:204 */     this.tblControlCompras.setSelectionBackground(new Color(153, 255, 0));
/* 275:205 */     this.tblControlCompras.setSelectionForeground(new Color(0, 0, 0));
/* 276:206 */     this.tblControlCompras.addMouseListener(new MouseAdapter()
/* 277:    */     {
/* 278:    */       public void mouseClicked(MouseEvent evt)
/* 279:    */       {
/* 280:208 */         comprasDesk.this.tblControlComprasMouseClicked(evt);
/* 281:    */       }
/* 282:210 */     });
/* 283:211 */     this.jScrollPane1.setViewportView(this.tblControlCompras);
/* 284:212 */     if (this.tblControlCompras.getColumnModel().getColumnCount() > 0)
/* 285:    */     {
/* 286:213 */       this.tblControlCompras.getColumnModel().getColumn(0).setMinWidth(70);
/* 287:214 */       this.tblControlCompras.getColumnModel().getColumn(0).setPreferredWidth(70);
/* 288:215 */       this.tblControlCompras.getColumnModel().getColumn(0).setMaxWidth(70);
/* 289:    */     }
/* 290:218 */     this.btnLimpiar.setBackground(new Color(153, 204, 255));
/* 291:219 */     this.btnLimpiar.setIcon(new ImageIcon(getClass().getResource("/icon/trash_recycle_bin_garbage.png")));
/* 292:220 */     this.btnLimpiar.setText("Limpiar");
/* 293:221 */     this.btnLimpiar.addActionListener(new ActionListener()
/* 294:    */     {
/* 295:    */       public void actionPerformed(ActionEvent evt)
/* 296:    */       {
/* 297:223 */         comprasDesk.this.btnLimpiarActionPerformed(evt);
/* 298:    */       }
/* 299:226 */     });
/* 300:227 */     this.btnImprimir.setBackground(new Color(153, 204, 255));
/* 301:228 */     this.btnImprimir.setIcon(new ImageIcon(getClass().getResource("/icon/print-32.png")));
/* 302:229 */     this.btnImprimir.setText("Imprimir");
/* 303:230 */     this.btnImprimir.addActionListener(new ActionListener()
/* 304:    */     {
/* 305:    */       public void actionPerformed(ActionEvent evt)
/* 306:    */       {
/* 307:232 */         comprasDesk.this.btnImprimirActionPerformed(evt);
/* 308:    */       }
/* 309:235 */     });
/* 310:236 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/* 311:237 */     this.jPanel2.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204), 8));
/* 312:    */     
/* 313:239 */     this.lblFechaActual.setFont(new Font("sansserif", 1, 30));
/* 314:240 */     this.lblFechaActual.setForeground(new Color(255, 255, 255));
/* 315:241 */     this.lblFechaActual.setHorizontalAlignment(0);
/* 316:242 */     this.lblFechaActual.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)), "Fecha Actual:"));
/* 317:    */     
/* 318:244 */     this.btnSalir.setBackground(new Color(153, 204, 255));
/* 319:245 */     this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/icon/logout-32.png")));
/* 320:246 */     this.btnSalir.setText("Salir");
/* 321:247 */     this.btnSalir.addActionListener(new ActionListener()
/* 322:    */     {
/* 323:    */       public void actionPerformed(ActionEvent evt)
/* 324:    */       {
/* 325:249 */         comprasDesk.this.btnSalirActionPerformed(evt);
/* 326:    */       }
/* 327:252 */     });
/* 328:253 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 329:254 */     this.jPanel2.setLayout(jPanel2Layout);
/* 330:255 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.lblFechaActual, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btnSalir, -2, 129, -2).addContainerGap()));
/* 331:    */     
/* 332:    */ 
/* 333:    */ 
/* 334:    */ 
/* 335:    */ 
/* 336:    */ 
/* 337:    */ 
/* 338:    */ 
/* 339:264 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.lblFechaActual, -2, 68, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.btnSalir, -2, 56, -2).addContainerGap()));
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
/* 350:275 */     this.jLabel1.setFont(new Font("sansserif", 1, 14));
/* 351:276 */     this.jLabel1.setForeground(new Color(255, 255, 255));
/* 352:277 */     this.jLabel1.setText("C Ó D I G O :");
/* 353:    */     
/* 354:279 */     this.jLabel2.setFont(new Font("sansserif", 1, 14));
/* 355:280 */     this.jLabel2.setForeground(new Color(255, 255, 255));
/* 356:281 */     this.jLabel2.setText("M A R C A :");
/* 357:    */     
/* 358:283 */     this.jLabel3.setFont(new Font("sansserif", 1, 14));
/* 359:284 */     this.jLabel3.setForeground(new Color(255, 255, 255));
/* 360:285 */     this.jLabel3.setText("S E R I E :");
/* 361:    */     
/* 362:287 */     this.jLabel4.setFont(new Font("sansserif", 1, 14));
/* 363:288 */     this.jLabel4.setForeground(new Color(255, 255, 255));
/* 364:289 */     this.jLabel4.setText("PREC. C O M P R A :");
/* 365:    */     
/* 366:291 */     this.jLabel5.setFont(new Font("sansserif", 1, 14));
/* 367:292 */     this.jLabel5.setForeground(new Color(255, 255, 255));
/* 368:293 */     this.jLabel5.setText("PREC. V E N T A :");
/* 369:    */     
/* 370:295 */     this.jLabel7.setFont(new Font("sansserif", 1, 14));
/* 371:296 */     this.jLabel7.setForeground(new Color(255, 255, 255));
/* 372:297 */     this.jLabel7.setText("D E S C R I P C I Ó N :");
/* 373:    */     
/* 374:299 */     this.jLabel10.setFont(new Font("sansserif", 1, 14));
/* 375:300 */     this.jLabel10.setForeground(new Color(255, 255, 255));
/* 376:301 */     this.jLabel10.setText("P R O V E E D O R :");
/* 377:    */     
/* 378:303 */     this.jLabel11.setFont(new Font("sansserif", 1, 14));
/* 379:304 */     this.jLabel11.setForeground(new Color(255, 255, 255));
/* 380:305 */     this.jLabel11.setText("S T O C K :");
/* 381:    */     
/* 382:307 */     this.txtCodigo_producto.setEditable(false);
/* 383:308 */     this.txtCodigo_producto.setHorizontalAlignment(0);
/* 384:309 */     this.txtCodigo_producto.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 385:    */     
/* 386:311 */     this.txtMarca.setEditable(false);
/* 387:312 */     this.txtMarca.setHorizontalAlignment(0);
/* 388:313 */     this.txtMarca.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 389:    */     
/* 390:315 */     this.txtSerie.setEditable(false);
/* 391:316 */     this.txtSerie.setHorizontalAlignment(0);
/* 392:317 */     this.txtSerie.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 393:    */     
/* 394:319 */     this.txtPrecio_Compra.setEditable(false);
/* 395:320 */     this.txtPrecio_Compra.setHorizontalAlignment(0);
/* 396:321 */     this.txtPrecio_Compra.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 397:    */     
/* 398:323 */     this.dateFechaFinal.setCurrentView(new AppearancesList("Grey", new ViewAppearance[] { new ViewAppearance("custom", new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 0), new Color(0, 0, 255), false, true, new ButtonPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 0), new Color(0, 0, 255), true, true, new ButtonPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 255), new Color(0, 0, 255), false, true, new ButtonPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(128, 128, 128), new Color(0, 0, 255), false, true, new LabelPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 0), new Color(0, 0, 255), false, true, new LabelPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 0), new Color(255, 0, 0), false, false, new ButtonPainter()), (BackRenderer)null, false, true) }));
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
/* 412:    */ 
/* 413:    */ 
/* 414:    */ 
/* 415:    */ 
/* 416:    */ 
/* 417:    */ 
/* 418:    */ 
/* 419:    */ 
/* 420:    */ 
/* 421:    */ 
/* 422:    */ 
/* 423:    */ 
/* 424:    */ 
/* 425:    */ 
/* 426:    */ 
/* 427:    */ 
/* 428:    */ 
/* 429:    */ 
/* 430:    */ 
/* 431:    */ 
/* 432:    */ 
/* 433:    */ 
/* 434:    */ 
/* 435:    */ 
/* 436:    */ 
/* 437:    */ 
/* 438:    */ 
/* 439:364 */     this.dateFechaFinal.setCalendarBackground(new Color(204, 255, 255));
/* 440:365 */     this.dateFechaFinal.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)), "", 0, 0, null, new Color(0, 0, 0)));
/* 441:366 */     this.dateFechaFinal.setCalendarPreferredSize(new Dimension(441, 270));
/* 442:367 */     this.dateFechaFinal.setNothingAllowed(false);
/* 443:368 */     this.dateFechaFinal.setLocale(new Locale("pt", "BR", ""));
/* 444:369 */     this.dateFechaFinal.addCommitListener(new CommitListener()
/* 445:    */     {
/* 446:    */       public void onCommit(CommitEvent evt)
/* 447:    */       {
/* 448:371 */         comprasDesk.this.dateFechaFinalOnCommit(evt);
/* 449:    */       }
/* 450:374 */     });
/* 451:375 */     this.txtPrecio_venta.setEditable(false);
/* 452:376 */     this.txtPrecio_venta.setHorizontalAlignment(0);
/* 453:377 */     this.txtPrecio_venta.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 454:    */     
/* 455:379 */     this.txtStock.setEditable(false);
/* 456:380 */     this.txtStock.setHorizontalAlignment(0);
/* 457:381 */     this.txtStock.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 458:382 */     this.txtStock.addKeyListener(new KeyAdapter()
/* 459:    */     {
/* 460:    */       public void keyReleased(KeyEvent evt)
/* 461:    */       {
/* 462:384 */         comprasDesk.this.txtStockKeyReleased(evt);
/* 463:    */       }
/* 464:387 */     });
/* 465:388 */     txtCod_proveedor.setEditable(false);
/* 466:389 */     txtCod_proveedor.setHorizontalAlignment(0);
/* 467:390 */     txtCod_proveedor.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 468:391 */     txtCod_proveedor.addKeyListener(new KeyAdapter()
/* 469:    */     {
/* 470:    */       public void keyReleased(KeyEvent evt)
/* 471:    */       {
/* 472:393 */         comprasDesk.this.txtCod_proveedorKeyReleased(evt);
/* 473:    */       }
/* 474:396 */     });
/* 475:397 */     this.btnMore.setBackground(new Color(204, 204, 204));
/* 476:398 */     this.btnMore.setFont(new Font("sansserif", 1, 18));
/* 477:399 */     this.btnMore.setText("+");
/* 478:400 */     this.btnMore.setEnabled(false);
/* 479:401 */     this.btnMore.addActionListener(new ActionListener()
/* 480:    */     {
/* 481:    */       public void actionPerformed(ActionEvent evt)
/* 482:    */       {
/* 483:403 */         comprasDesk.this.btnMoreActionPerformed(evt);
/* 484:    */       }
/* 485:406 */     });
/* 486:407 */     this.btnNuevo.setBackground(new Color(153, 204, 255));
/* 487:408 */     this.btnNuevo.setIcon(new ImageIcon(getClass().getResource("/Iconos/ADD.PNG")));
/* 488:409 */     this.btnNuevo.setText("Nuevo");
/* 489:410 */     this.btnNuevo.addActionListener(new ActionListener()
/* 490:    */     {
/* 491:    */       public void actionPerformed(ActionEvent evt)
/* 492:    */       {
/* 493:412 */         comprasDesk.this.btnNuevoActionPerformed(evt);
/* 494:    */       }
/* 495:415 */     });
/* 496:416 */     this.btnGuardar.setBackground(new Color(153, 204, 255));
/* 497:417 */     this.btnGuardar.setIcon(new ImageIcon(getClass().getResource("/Iconos/GUARDAR.PNG")));
/* 498:418 */     this.btnGuardar.setText("Registrar");
/* 499:419 */     this.btnGuardar.setEnabled(false);
/* 500:420 */     this.btnGuardar.addActionListener(new ActionListener()
/* 501:    */     {
/* 502:    */       public void actionPerformed(ActionEvent evt)
/* 503:    */       {
/* 504:422 */         comprasDesk.this.btnGuardarActionPerformed(evt);
/* 505:    */       }
/* 506:425 */     });
/* 507:426 */     this.btnCancelar.setBackground(new Color(153, 204, 255));
/* 508:427 */     this.btnCancelar.setIcon(new ImageIcon(getClass().getResource("/Iconos/CANCELAR.PNG")));
/* 509:428 */     this.btnCancelar.setText("Cancelar");
/* 510:429 */     this.btnCancelar.addActionListener(new ActionListener()
/* 511:    */     {
/* 512:    */       public void actionPerformed(ActionEvent evt)
/* 513:    */       {
/* 514:431 */         comprasDesk.this.btnCancelarActionPerformed(evt);
/* 515:    */       }
/* 516:434 */     });
/* 517:435 */     this.jPanel3.setBackground(new Color(0, 0, 0));
/* 518:    */     
/* 519:437 */     this.jLabel12.setFont(new Font("Arial Black", 2, 24));
/* 520:438 */     this.jLabel12.setForeground(new Color(255, 255, 255));
/* 521:439 */     this.jLabel12.setText("Gastos:");
/* 522:    */     
/* 523:441 */     this.txtGastos.setFont(new Font("sansserif", 1, 18));
/* 524:442 */     this.txtGastos.setHorizontalAlignment(0);
/* 525:443 */     this.txtGastos.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 204)));
/* 526:    */     
/* 527:445 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 528:446 */     this.jPanel3.setLayout(jPanel3Layout);
/* 529:447 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(87, 87, 87).addComponent(this.jLabel12).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtGastos, -2, 202, -2).addContainerGap(100, 32767)));
/* 530:    */     
/* 531:    */ 
/* 532:    */ 
/* 533:    */ 
/* 534:    */ 
/* 535:    */ 
/* 536:    */ 
/* 537:    */ 
/* 538:456 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(25, 25, 25).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel12).addComponent(this.txtGastos, -2, 35, -2)).addContainerGap(25, 32767)));
/* 539:    */     
/* 540:    */ 
/* 541:    */ 
/* 542:    */ 
/* 543:    */ 
/* 544:    */ 
/* 545:    */ 
/* 546:    */ 
/* 547:    */ 
/* 548:466 */     this.jLabel9.setFont(new Font("sansserif", 1, 14));
/* 549:467 */     this.jLabel9.setForeground(new Color(255, 255, 255));
/* 550:468 */     this.jLabel9.setText("T I P O   P R O D U C T O :");
/* 551:    */     
/* 552:470 */     this.cboTIPO.setBackground(new Color(51, 51, 51));
/* 553:471 */     this.cboTIPO.setFont(new Font("sansserif", 1, 12));
/* 554:472 */     this.cboTIPO.setForeground(new Color(255, 255, 255));
/* 555:473 */     this.cboTIPO.setModel(new DefaultComboBoxModel(new String[] { "MOVIL", "CARGADOR", "CARCASA", "BATERIA", "CABLE DE DATO", "PANTALLA", "AUDIO" }));
/* 556:474 */     this.cboTIPO.setBorder(null);
/* 557:475 */     this.cboTIPO.setCursor(new Cursor(12));
/* 558:476 */     this.cboTIPO.addMouseMotionListener(new MouseMotionAdapter()
/* 559:    */     {
/* 560:    */       public void mouseMoved(MouseEvent evt)
/* 561:    */       {
/* 562:478 */         comprasDesk.this.cboTIPOMouseMoved(evt);
/* 563:    */       }
/* 564:480 */     });
/* 565:481 */     this.cboTIPO.addActionListener(new ActionListener()
/* 566:    */     {
/* 567:    */       public void actionPerformed(ActionEvent evt)
/* 568:    */       {
/* 569:483 */         comprasDesk.this.cboTIPOActionPerformed(evt);
/* 570:    */       }
/* 571:486 */     });
/* 572:487 */     this.jLabel13.setFont(new Font("sansserif", 1, 14));
/* 573:488 */     this.jLabel13.setForeground(new Color(255, 255, 255));
/* 574:489 */     this.jLabel13.setText("E S T A D O :");
/* 575:    */     
/* 576:491 */     this.cboEstado.setBackground(new Color(51, 51, 51));
/* 577:492 */     this.cboEstado.setForeground(new Color(255, 255, 255));
/* 578:493 */     this.cboEstado.setModel(new DefaultComboBoxModel(new String[] { "NUEVO", "BUENO", "MALO", "MANTENIMIENTO" }));
/* 579:    */     
/* 580:495 */     this.txtDescripcion.setEditable(false);
/* 581:496 */     this.txtDescripcion.setColumns(20);
/* 582:497 */     this.txtDescripcion.setRows(5);
/* 583:498 */     this.jScrollPane2.setViewportView(this.txtDescripcion);
/* 584:    */     
/* 585:500 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 586:501 */     this.jPanel1.setLayout(jPanel1Layout);
/* 587:502 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(53, 53, 53).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel6).addGap(18, 18, 18).addComponent(this.dateFechaInicial, -2, 236, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel8).addGap(18, 18, 18).addComponent(this.dateFechaFinal, -2, 236, -2)))).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.btnBuscar, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnImprimir, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnLimpiar)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel9).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.cboTIPO, 0, -1, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.btnNuevo, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnGuardar, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnCancelar, -2, 132, -2)))).addGap(13, 13, 13)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2, -2, 81, -2).addComponent(this.jLabel3)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtMarca, -2, 219, -2).addGap(8, 8, 8)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtSerie).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel7).addGroup(jPanel1Layout.createSequentialGroup().addGap(31, 31, 31).addComponent(this.jLabel5)))).addComponent(this.jPanel3, -2, -1, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtCodigo_producto, -2, 215, -2).addGap(18, 18, 18).addComponent(this.jLabel4))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane2, -2, 827, -2).addContainerGap(-1, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtPrecio_Compra).addGap(573, 573, 573).addComponent(this.btnMore, -2, 49, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtPrecio_venta).addGap(55, 55, 55).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel10).addComponent(this.jLabel11)).addGap(33, 33, 33).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(txtCod_proveedor, -2, 346, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtStock, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel13).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.cboEstado, -2, 206, -2))))).addGap(14, 14, 14)))))));
/* 588:    */     
/* 589:    */ 
/* 590:    */ 
/* 591:    */ 
/* 592:    */ 
/* 593:    */ 
/* 594:    */ 
/* 595:    */ 
/* 596:    */ 
/* 597:    */ 
/* 598:    */ 
/* 599:    */ 
/* 600:    */ 
/* 601:    */ 
/* 602:    */ 
/* 603:    */ 
/* 604:    */ 
/* 605:    */ 
/* 606:    */ 
/* 607:    */ 
/* 608:    */ 
/* 609:    */ 
/* 610:    */ 
/* 611:    */ 
/* 612:    */ 
/* 613:    */ 
/* 614:    */ 
/* 615:    */ 
/* 616:    */ 
/* 617:    */ 
/* 618:    */ 
/* 619:    */ 
/* 620:    */ 
/* 621:    */ 
/* 622:    */ 
/* 623:    */ 
/* 624:    */ 
/* 625:    */ 
/* 626:    */ 
/* 627:    */ 
/* 628:    */ 
/* 629:    */ 
/* 630:    */ 
/* 631:    */ 
/* 632:    */ 
/* 633:    */ 
/* 634:    */ 
/* 635:    */ 
/* 636:    */ 
/* 637:    */ 
/* 638:    */ 
/* 639:    */ 
/* 640:    */ 
/* 641:    */ 
/* 642:    */ 
/* 643:    */ 
/* 644:    */ 
/* 645:    */ 
/* 646:    */ 
/* 647:    */ 
/* 648:    */ 
/* 649:    */ 
/* 650:    */ 
/* 651:    */ 
/* 652:    */ 
/* 653:    */ 
/* 654:    */ 
/* 655:    */ 
/* 656:    */ 
/* 657:    */ 
/* 658:    */ 
/* 659:    */ 
/* 660:    */ 
/* 661:    */ 
/* 662:    */ 
/* 663:    */ 
/* 664:    */ 
/* 665:    */ 
/* 666:    */ 
/* 667:    */ 
/* 668:    */ 
/* 669:    */ 
/* 670:    */ 
/* 671:    */ 
/* 672:    */ 
/* 673:    */ 
/* 674:    */ 
/* 675:    */ 
/* 676:    */ 
/* 677:    */ 
/* 678:    */ 
/* 679:    */ 
/* 680:595 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(16, 16, 16).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.dateFechaInicial, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.dateFechaFinal, -2, -1, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel6).addGap(18, 18, 18).addComponent(this.jLabel8))).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnBuscar, -2, 59, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnImprimir, -2, 62, -2).addComponent(this.btnLimpiar, -2, 62, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnNuevo).addComponent(this.btnGuardar, -1, -1, 32767).addComponent(this.btnCancelar)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel9).addComponent(this.cboTIPO, -2, -1, -2)).addGap(9, 9, 9)).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 279, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.txtCodigo_producto, -2, -1, -2).addComponent(this.jLabel4).addComponent(this.txtPrecio_Compra, -2, -1, -2).addComponent(this.jLabel10).addComponent(txtCod_proveedor, -2, -1, -2).addComponent(this.btnMore, -2, 25, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.txtMarca, -2, -1, -2).addComponent(this.jLabel5).addComponent(this.txtPrecio_venta, -2, -1, -2).addComponent(this.jLabel11).addComponent(this.txtStock, -2, -1, -2).addComponent(this.jLabel13).addComponent(this.cboEstado, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.txtSerie, -2, -1, -2).addComponent(this.jLabel3)).addGap(18, 18, 18).addComponent(this.jPanel3, -2, -1, -2)).addComponent(this.jScrollPane2, -2, 121, -2)).addContainerGap()));
/* 681:    */     
/* 682:    */ 
/* 683:    */ 
/* 684:    */ 
/* 685:    */ 
/* 686:    */ 
/* 687:    */ 
/* 688:    */ 
/* 689:    */ 
/* 690:    */ 
/* 691:    */ 
/* 692:    */ 
/* 693:    */ 
/* 694:    */ 
/* 695:    */ 
/* 696:    */ 
/* 697:    */ 
/* 698:    */ 
/* 699:    */ 
/* 700:    */ 
/* 701:    */ 
/* 702:    */ 
/* 703:    */ 
/* 704:    */ 
/* 705:    */ 
/* 706:    */ 
/* 707:    */ 
/* 708:    */ 
/* 709:    */ 
/* 710:    */ 
/* 711:    */ 
/* 712:    */ 
/* 713:    */ 
/* 714:    */ 
/* 715:    */ 
/* 716:    */ 
/* 717:    */ 
/* 718:    */ 
/* 719:    */ 
/* 720:    */ 
/* 721:    */ 
/* 722:    */ 
/* 723:    */ 
/* 724:    */ 
/* 725:    */ 
/* 726:    */ 
/* 727:    */ 
/* 728:    */ 
/* 729:    */ 
/* 730:    */ 
/* 731:    */ 
/* 732:    */ 
/* 733:    */ 
/* 734:    */ 
/* 735:    */ 
/* 736:    */ 
/* 737:    */ 
/* 738:    */ 
/* 739:    */ 
/* 740:    */ 
/* 741:    */ 
/* 742:    */ 
/* 743:    */ 
/* 744:    */ 
/* 745:    */ 
/* 746:    */ 
/* 747:662 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 748:663 */     getContentPane().setLayout(layout);
/* 749:664 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/* 750:    */     
/* 751:    */ 
/* 752:    */ 
/* 753:668 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/* 754:    */     
/* 755:    */ 
/* 756:    */ 
/* 757:    */ 
/* 758:673 */     pack();
/* 759:    */   }
/* 760:    */   
/* 761:    */   private void dateFechaInicialOnCommit(CommitEvent evt)
/* 762:    */   {
/* 763:677 */     hablitaLimpia(true);
/* 764:    */   }
/* 765:    */   
/* 766:    */   private void btnBuscarActionPerformed(ActionEvent evt)
/* 767:    */   {
/* 768:    */     try
/* 769:    */     {
/* 770:682 */       this.model = ((DefaultTableModel)this.tblControlCompras.getModel());
/* 771:    */       
/* 772:684 */       String nuevoAño = "";
/* 773:685 */       String año = this.dateFechaInicial.getText().substring(6);
/* 774:686 */       String mes = this.dateFechaInicial.getText().substring(3, 5);
/* 775:687 */       String dia = this.dateFechaInicial.getText().substring(0, 2);
/* 776:688 */       if (año.equals("00")) {
/* 777:689 */         nuevoAño = "2000-";
/* 778:    */       }
/* 779:691 */       nuevoAño = "20" + año + "-";
/* 780:692 */       String nuevomes = mes + "-";
/* 781:    */       
/* 782:694 */       String año2 = this.dateFechaFinal.getText().substring(6);
/* 783:695 */       String mes2 = this.dateFechaFinal.getText().substring(3, 5);
/* 784:696 */       String dia2 = this.dateFechaFinal.getText().substring(0, 2);
/* 785:697 */       String nuevoAño2 = "20" + año2 + "-";
/* 786:698 */       String nuevomes2 = mes2 + "-";
/* 787:699 */       String fechaIcinio = nuevoAño + nuevomes + dia;
/* 788:700 */       String fechaFinal = nuevoAño2 + nuevomes2 + dia2;
/* 789:    */       
/* 790:702 */       this.rs = this.oProducto.reportarCompras(fechaIcinio, fechaFinal);
/* 791:703 */       while (this.rs.next())
/* 792:    */       {
/* 793:704 */         Object[] reg = { this.rs.getString(1), this.rs.getString(2), this.rs.getString(3), Double.valueOf(this.rs.getDouble(4)), Double.valueOf(this.rs.getDouble(5)), Integer.valueOf(this.rs.getInt(6)), this.rs.getString(7), this.rs.getString(8), this.rs.getString(9) };
/* 794:    */         
/* 795:    */ 
/* 796:    */ 
/* 797:    */ 
/* 798:    */ 
/* 799:    */ 
/* 800:    */ 
/* 801:    */ 
/* 802:    */ 
/* 803:    */ 
/* 804:    */ 
/* 805:716 */         this.model.addRow(reg);
/* 806:    */       }
/* 807:719 */       this.btnBuscar.setEnabled(false);
/* 808:    */     }
/* 809:    */     catch (Exception e)
/* 810:    */     {
/* 811:721 */       System.out.println(e);
/* 812:    */     }
/* 813:    */   }
/* 814:    */   
/* 815:    */   private void btnSalirActionPerformed(ActionEvent evt)
/* 816:    */   {
/* 817:726 */     int opc = JOptionPane.showConfirmDialog(null, "desea salir de la ventana ?...", "cuadro de  advertencia", 2, 3);
/* 818:727 */     if (opc == 0) {
/* 819:728 */       dispose();
/* 820:    */     }
/* 821:    */   }
/* 822:    */   
/* 823:    */   private void btnLimpiarActionPerformed(ActionEvent evt)
/* 824:    */   {
/* 825:733 */     hablitaLimpia(true);
/* 826:734 */     limpiaControles();
/* 827:    */   }
/* 828:    */   
/* 829:    */   private void hablitaLimpia(boolean b)
/* 830:    */   {
/* 831:738 */     this.model = ((DefaultTableModel)this.tblControlCompras.getModel());
/* 832:739 */     this.btnBuscar.setEnabled(b);
/* 833:740 */     int filas = this.tblControlCompras.getRowCount();
/* 834:742 */     for (int i = 0; filas > i; i++) {
/* 835:743 */       this.model.removeRow(0);
/* 836:    */     }
/* 837:    */   }
/* 838:    */   
/* 839:    */   private void btnImprimirActionPerformed(ActionEvent evt)
/* 840:    */   {
/* 841:748 */     List lista = new ArrayList();
/* 842:749 */     for (int i = 0; i < this.tblControlCompras.getRowCount(); i++)
/* 843:    */     {
/* 844:750 */       reporte_Compras listac = new reporte_Compras(this.tblControlCompras.getValueAt(i, 0).toString(), this.tblControlCompras.getValueAt(i, 1).toString(), this.tblControlCompras.getValueAt(i, 2).toString(), Double.parseDouble(this.tblControlCompras.getValueAt(i, 3).toString()), Double.parseDouble(this.tblControlCompras.getValueAt(i, 4).toString()), Integer.parseInt(this.tblControlCompras.getValueAt(i, 5).toString()), this.tblControlCompras.getValueAt(i, 6).toString(), this.tblControlCompras.getValueAt(i, 7).toString(), this.tblControlCompras.getValueAt(i, 8).toString());
/* 845:    */       
/* 846:    */ 
/* 847:    */ 
/* 848:    */ 
/* 849:    */ 
/* 850:    */ 
/* 851:    */ 
/* 852:    */ 
/* 853:    */ 
/* 854:    */ 
/* 855:761 */       lista.add(listac);
/* 856:    */     }
/* 857:    */     try
/* 858:    */     {
/* 859:764 */       JasperReport report = (JasperReport)JRLoader.loadObject("C:\\Ledatel\\reportes\\reporte_compras.jasper");
/* 860:765 */       Map parametro = new HashMap();
/* 861:766 */       parametro.put("FechaInicial", this.dateFechaInicial.getText());
/* 862:767 */       parametro.put("FechaFinal", this.dateFechaFinal.getText());
/* 863:768 */       JasperPrint print = JasperFillManager.fillReport(report, parametro, new JRBeanCollectionDataSource(lista));
/* 864:769 */       JasperViewer.viewReport(print, false);
/* 865:    */     }
/* 866:    */     catch (Exception e)
/* 867:    */     {
/* 868:772 */       System.out.println(e);
/* 869:    */     }
/* 870:    */   }
/* 871:    */   
/* 872:    */   private void dateFechaFinalOnCommit(CommitEvent evt) {}
/* 873:    */   
/* 874:    */   private void tblControlComprasMouseClicked(MouseEvent evt)
/* 875:    */   {
/* 876:781 */     this.txtCodigo_producto.setText(this.tblControlCompras.getValueAt(this.tblControlCompras.getSelectedRow(), 0).toString());
/* 877:782 */     this.txtMarca.setText(this.tblControlCompras.getValueAt(this.tblControlCompras.getSelectedRow(), 1).toString());
/* 878:783 */     this.txtSerie.setText(this.tblControlCompras.getValueAt(this.tblControlCompras.getSelectedRow(), 2).toString());
/* 879:784 */     this.txtPrecio_Compra.setText(this.tblControlCompras.getValueAt(this.tblControlCompras.getSelectedRow(), 3).toString());
/* 880:785 */     this.txtStock.setText(this.tblControlCompras.getValueAt(this.tblControlCompras.getSelectedRow(), 5).toString());
/* 881:786 */     txtCod_proveedor.setText(this.tblControlCompras.getValueAt(this.tblControlCompras.getSelectedRow(), 7).toString());
/* 882:    */   }
/* 883:    */   
/* 884:    */   private void txtStockKeyReleased(KeyEvent evt)
/* 885:    */   {
/* 886:    */     try
/* 887:    */     {
/* 888:792 */       double precioCompra = Double.parseDouble(this.txtPrecio_Compra.getText());
/* 889:793 */       double precioVenta = Double.parseDouble(this.txtPrecio_venta.getText());
/* 890:794 */       this.stock = Integer.parseInt(this.txtStock.getText());
/* 891:795 */       this.gastos = (precioCompra * this.stock);
/* 892:796 */       this.txtGastos.setText(String.valueOf(this.gastos));
/* 893:    */     }
/* 894:    */     catch (Exception e)
/* 895:    */     {
/* 896:799 */       System.out.println("Solo numeros !!!! -> suarez l");
/* 897:    */     }
/* 898:    */   }
/* 899:    */   
/* 900:    */   private void txtCod_proveedorKeyReleased(KeyEvent evt) {}
/* 901:    */   
/* 902:    */   private void btnMoreActionPerformed(ActionEvent evt)
/* 903:    */   {
/* 904:809 */     proveedorDesk g = new proveedorDesk();
/* 905:810 */     VentanaPrincipalGUI.desk.add(g);
/* 906:811 */     g.show();
/* 907:    */   }
/* 908:    */   
/* 909:    */   private void btnCancelarActionPerformed(ActionEvent evt)
/* 910:    */   {
/* 911:815 */     limpiaControles();
/* 912:816 */     habilitaControles(false);
/* 913:    */   }
/* 914:    */   
/* 915:    */   private void btnNuevoActionPerformed(ActionEvent evt)
/* 916:    */   {
/* 917:820 */     habilitaControles(true);
/* 918:821 */     limpiaControles();
/* 919:    */   }
/* 920:    */   
/* 921:    */   private void btnGuardarActionPerformed(ActionEvent evt)
/* 922:    */   {
/* 923:    */     try
/* 924:    */     {
/* 925:826 */       producto_TO to = new producto_TO();
/* 926:827 */       to.setCodigoProd(this.txtCodigo_producto.getText());
/* 927:    */       
/* 928:829 */       this.cod_Proveedor = ObtenerCodigo_proveedor();
/* 929:830 */       to.setProveedor(this.cod_Proveedor);
/* 930:831 */       to.setTipo(this.cboTIPO.getSelectedItem().toString());
/* 931:832 */       to.setCodigoProd(this.txtCodigo_producto.getText().toUpperCase());
/* 932:833 */       to.setMarca(this.txtMarca.getText().toUpperCase());
/* 933:834 */       to.setModelo(this.txtSerie.getText().toUpperCase());
/* 934:835 */       to.setPrecioCpmpra(Double.parseDouble(this.txtPrecio_Compra.getText()));
/* 935:836 */       to.setPrecioVenta(Double.parseDouble(this.txtPrecio_venta.getText()));
/* 936:837 */       to.setStock(Integer.parseInt(this.txtStock.getText()));
/* 937:838 */       to.setDescripcion(this.txtDescripcion.getText().toUpperCase());
/* 938:839 */       to.setEstado(this.cboEstado.getSelectedItem().toString());
/* 939:    */       
/* 940:841 */       this.oProducto.registrar_Producto(to);
/* 941:    */       
/* 942:843 */       String codigpProducto = this.oProducto.obtenerCodProducto();
/* 943:844 */       this.oProducto.RegistrarComprar(codigpProducto, this.stock, this.gastos);
/* 944:845 */       JOptionPane.showMessageDialog(this.rootPane, "Producto Registrado y Add a Stock correctamente");
/* 945:846 */       habilitaControles(false);
/* 946:    */     }
/* 947:    */     catch (Exception e)
/* 948:    */     {
/* 949:848 */       System.out.println(e);
/* 950:    */     }
/* 951:    */   }
/* 952:    */   
/* 953:    */   private void cboTIPOActionPerformed(ActionEvent evt) {}
/* 954:    */   
/* 955:    */   private void cboTIPOMouseMoved(MouseEvent evt) {}
/* 956:    */   
/* 957:    */   private void calendario()
/* 958:    */   {
/* 959:905 */     Calendar cal1 = Calendar.getInstance();
/* 960:906 */     String mesInt = "";
/* 961:    */     
/* 962:908 */     int mes = cal1.get(2);
/* 963:909 */     int mesActual = mes + 1;
/* 964:910 */     if (mesActual < 9) {
/* 965:911 */       mesInt = "0" + mesActual + "/";
/* 966:    */     } else {
/* 967:913 */       mesInt = mesActual + "/";
/* 968:    */     }
/* 969:916 */     int dia = cal1.get(5);
/* 970:917 */     String diaInt = "";
/* 971:918 */     if (dia < 10) {
/* 972:919 */       diaInt = "0" + dia + "/";
/* 973:    */     } else {
/* 974:921 */       diaInt = dia + "/";
/* 975:    */     }
/* 976:923 */     int año = cal1.get(1);
/* 977:924 */     int añoAc = año - 2000;
/* 978:925 */     this.lblFechaActual.setText("" + diaInt + mesInt + añoAc);
/* 979:    */   }
/* 980:    */   
/* 981:    */   private void habilitaControles(boolean b)
/* 982:    */   {
/* 983:930 */     JTextField[] txt = { this.txtCodigo_producto, this.txtMarca, this.txtSerie, this.txtPrecio_Compra, this.txtPrecio_venta, this.txtStock };
/* 984:    */     
/* 985:    */ 
/* 986:933 */     this.txtDescripcion.setEditable(b);
/* 987:934 */     for (JTextField field : txt)
/* 988:    */     {
/* 989:935 */       field.setEditable(b);
/* 990:936 */       this.txtCodigo_producto.grabFocus();
/* 991:    */     }
/* 992:938 */     this.btnGuardar.setEnabled(b);
/* 993:939 */     this.btnNuevo.setEnabled(!b);
/* 994:940 */     this.btnMore.setEnabled(b);
/* 995:    */   }
/* 996:    */   
/* 997:    */   private void limpiaControles()
/* 998:    */   {
/* 999:944 */     JTextField[] txt = { this.txtCodigo_producto, this.txtMarca, this.txtSerie, this.txtPrecio_Compra, this.txtPrecio_venta, this.txtStock, txtCod_proveedor };
/* :00:    */     
/* :01:    */ 
/* :02:947 */     this.txtDescripcion.setText("");
/* :03:948 */     for (JTextField field : txt)
/* :04:    */     {
/* :05:949 */       field.setText("");
/* :06:950 */       this.txtCodigo_producto.grabFocus();
/* :07:    */     }
/* :08:    */   }
/* :09:    */   
/* :10:    */   private String ObtenerCodigo_proveedor()
/* :11:    */   {
/* :12:    */     try
/* :13:    */     {
/* :14:957 */       String nombre_empresa = txtCod_proveedor.getText();
/* :15:958 */       proveedorDao oProveedor = new proveedorDao();
/* :16:959 */       this.rs = oProveedor.cargarProveedor();
/* :17:960 */       while (this.rs.next()) {
/* :18:961 */         if (nombre_empresa.equals(this.rs.getString(2))) {
/* :19:962 */           this.cod_Proveedor = this.rs.getString(1);
/* :20:    */         }
/* :21:    */       }
/* :22:    */     }
/* :23:    */     catch (Exception e) {}
/* :24:967 */     return this.cod_Proveedor;
/* :25:    */   }
/* :26:    */ }



/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar

 * Qualified Name:     Desk.comprasDesk

 * JD-Core Version:    0.7.0.1

 */