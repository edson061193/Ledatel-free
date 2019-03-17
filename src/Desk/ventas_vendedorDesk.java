/*   1:    */ package Desk;
/*   2:    */ 
/*   3:    */ import Dao.empleadoDao;
/*   4:    */ import Log_Reporte.ventas_vendedorReport;
/*   5:    */ import datechooser.beans.DateChooserCombo;
/*   6:    */ import datechooser.events.CommitEvent;
/*   7:    */ import datechooser.events.CommitListener;
/*   8:    */ import java.awt.Color;
/*   9:    */ import java.awt.Container;
/*  10:    */ import java.awt.Dimension;
/*  11:    */ import java.awt.Font;
/*  12:    */ import java.awt.event.ActionEvent;
/*  13:    */ import java.awt.event.ActionListener;
/*  14:    */ import java.io.PrintStream;
/*  15:    */ import java.sql.ResultSet;
/*  16:    */ import java.util.ArrayList;
/*  17:    */ import java.util.HashMap;
/*  18:    */ import java.util.List;
/*  19:    */ import java.util.Locale;
/*  20:    */ import java.util.Map;
/*  21:    */ import javax.swing.BorderFactory;
/*  22:    */ import javax.swing.GroupLayout;
/*  23:    */ import javax.swing.GroupLayout.Alignment;
/*  24:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  25:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  26:    */ import javax.swing.ImageIcon;
/*  27:    */ import javax.swing.JButton;
/*  28:    */ import javax.swing.JInternalFrame;
/*  29:    */ import javax.swing.JLabel;
/*  30:    */ import javax.swing.JPanel;
/*  31:    */ import javax.swing.JScrollPane;
/*  32:    */ import javax.swing.JTable;
/*  33:    */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*  34:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  35:    */ import javax.swing.table.DefaultTableModel;
/*  36:    */ import javax.swing.table.TableColumn;
/*  37:    */ import javax.swing.table.TableColumnModel;
/*  38:    */ import net.sf.jasperreports.engine.JasperFillManager;
/*  39:    */ import net.sf.jasperreports.engine.JasperPrint;
/*  40:    */ import net.sf.jasperreports.engine.JasperReport;
/*  41:    */ import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
/*  42:    */ import net.sf.jasperreports.engine.util.JRLoader;
/*  43:    */ import net.sf.jasperreports.view.JasperViewer;
/*  44:    */ 
/*  45:    */ public class ventas_vendedorDesk
/*  46:    */   extends JInternalFrame
/*  47:    */ {
/*  48:    */   DefaultTableModel model;
/*  49:    */   ResultSet rs;
/*  50: 22 */   empleadoDao OempleadoDao = new empleadoDao();
/*  51:    */   private JButton btnBuscar;
/*  52:    */   private JButton btnImprimir;
/*  53:    */   private DateChooserCombo dateFechaFinal;
/*  54:    */   private DateChooserCombo dateFechaInicial;
/*  55:    */   private JLabel jLabel1;
/*  56:    */   private JLabel jLabel12;
/*  57:    */   private JLabel jLabel3;
/*  58:    */   private JLabel jLabel4;
/*  59:    */   private JLabel jLabel5;
/*  60:    */   private JPanel jPanel1;
/*  61:    */   private JPanel jPanel2;
/*  62:    */   private JPanel jPanel3;
/*  63:    */   private JScrollPane jScrollPane1;
/*  64:    */   public static JLabel lblCodigo_vendedor;
/*  65:    */   private JTable tblRegistros_Vendedor;
/*  66:    */   public static JTextField txtApellidos_Nombres;
/*  67:    */   
/*  68:    */   public ventas_vendedorDesk()
/*  69:    */   {
/*  70: 25 */     initComponents();
/*  71:    */   }
/*  72:    */   
/*  73:    */   private void initComponents()
/*  74:    */   {
/*  75: 32 */     this.jPanel1 = new JPanel();
/*  76: 33 */     this.jLabel1 = new JLabel();
/*  77: 34 */     lblCodigo_vendedor = new JLabel();
/*  78: 35 */     this.jLabel3 = new JLabel();
/*  79: 36 */     txtApellidos_Nombres = new JTextField();
/*  80: 37 */     this.jPanel2 = new JPanel();
/*  81: 38 */     this.jLabel4 = new JLabel();
/*  82: 39 */     this.dateFechaInicial = new DateChooserCombo();
/*  83: 40 */     this.dateFechaFinal = new DateChooserCombo();
/*  84: 41 */     this.jLabel5 = new JLabel();
/*  85: 42 */     this.btnBuscar = new JButton();
/*  86: 43 */     this.jPanel3 = new JPanel();
/*  87: 44 */     this.jScrollPane1 = new JScrollPane();
/*  88: 45 */     this.tblRegistros_Vendedor = new JTable();
/*  89: 46 */     this.btnImprimir = new JButton();
/*  90: 47 */     this.jLabel12 = new JLabel();
/*  91:    */     
/*  92: 49 */     setBackground(new Color(153, 153, 153));
/*  93: 50 */     setClosable(true);
/*  94: 51 */     setIconifiable(true);
/*  95: 52 */     setMaximizable(true);
/*  96: 53 */     setTitle("ventana de ventas de los  vendores Ledatel");
/*  97: 54 */     setFrameIcon(null);
/*  98: 55 */     setMinimumSize(new Dimension(1343, 640));
/*  99: 56 */     setPreferredSize(new Dimension(1343, 640));
/* 100:    */     
/* 101: 58 */     this.jPanel1.setBackground(new Color(102, 102, 102));
/* 102:    */     
/* 103: 60 */     this.jLabel1.setText("Código vendedor");
/* 104:    */     
/* 105: 62 */     lblCodigo_vendedor.setFont(new Font("sansserif", 1, 24));
/* 106:    */     
/* 107: 64 */     this.jLabel3.setText("Apellidos/Nombres:");
/* 108:    */     
/* 109: 66 */     txtApellidos_Nombres.setFont(new Font("Tahoma", 0, 12));
/* 110: 67 */     txtApellidos_Nombres.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 111:    */     
/* 112: 69 */     this.jPanel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 255), 2), "Periodo de ventas ", 2, 2, null, Color.black));
/* 113: 70 */     this.jPanel2.setOpaque(false);
/* 114:    */     
/* 115: 72 */     this.jLabel4.setText("Fecha Incial :");
/* 116:    */     
/* 117: 74 */     this.dateFechaInicial.setCalendarBackground(new Color(204, 255, 255));
/* 118: 75 */     this.dateFechaInicial.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 119: 76 */     this.dateFechaInicial.setCalendarPreferredSize(new Dimension(441, 270));
/* 120: 77 */     this.dateFechaInicial.setNothingAllowed(false);
/* 121: 78 */     this.dateFechaInicial.setLocale(new Locale("pt", "BR", ""));
/* 122: 79 */     this.dateFechaInicial.addCommitListener(new CommitListener()
/* 123:    */     {
/* 124:    */       public void onCommit(CommitEvent evt)
/* 125:    */       {
/* 126: 81 */         ventas_vendedorDesk.this.dateFechaInicialOnCommit(evt);
/* 127:    */       }
/* 128: 84 */     });
/* 129: 85 */     this.dateFechaFinal.setCalendarBackground(new Color(204, 255, 255));
/* 130: 86 */     this.dateFechaFinal.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 131: 87 */     this.dateFechaFinal.setCalendarPreferredSize(new Dimension(441, 270));
/* 132: 88 */     this.dateFechaFinal.setNothingAllowed(false);
/* 133: 89 */     this.dateFechaFinal.setLocale(new Locale("pt", "BR", ""));
/* 134: 90 */     this.dateFechaFinal.addCommitListener(new CommitListener()
/* 135:    */     {
/* 136:    */       public void onCommit(CommitEvent evt)
/* 137:    */       {
/* 138: 92 */         ventas_vendedorDesk.this.dateFechaFinalOnCommit(evt);
/* 139:    */       }
/* 140: 95 */     });
/* 141: 96 */     this.jLabel5.setText("Fecha Final:");
/* 142:    */     
/* 143: 98 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 144: 99 */     this.jPanel2.setLayout(jPanel2Layout);
/* 145:100 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.dateFechaInicial, -2, 211, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 40, 32767).addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.dateFechaFinal, -2, 188, -2)));
/* 146:    */     
/* 147:    */ 
/* 148:    */ 
/* 149:    */ 
/* 150:    */ 
/* 151:    */ 
/* 152:    */ 
/* 153:    */ 
/* 154:    */ 
/* 155:    */ 
/* 156:    */ 
/* 157:112 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.dateFechaFinal, -2, -1, -2).addComponent(this.dateFechaInicial, -2, -1, -2).addComponent(this.jLabel4).addComponent(this.jLabel5)).addContainerGap(-1, 32767)));
/* 158:    */     
/* 159:    */ 
/* 160:    */ 
/* 161:    */ 
/* 162:    */ 
/* 163:    */ 
/* 164:    */ 
/* 165:    */ 
/* 166:    */ 
/* 167:    */ 
/* 168:    */ 
/* 169:124 */     this.btnBuscar.setBackground(new Color(204, 204, 255));
/* 170:125 */     this.btnBuscar.setIcon(new ImageIcon(getClass().getResource("/icon/search-32.png")));
/* 171:126 */     this.btnBuscar.setText("B U S C A R");
/* 172:127 */     this.btnBuscar.addActionListener(new ActionListener()
/* 173:    */     {
/* 174:    */       public void actionPerformed(ActionEvent evt)
/* 175:    */       {
/* 176:129 */         ventas_vendedorDesk.this.btnBuscarActionPerformed(evt);
/* 177:    */       }
/* 178:132 */     });
/* 179:133 */     this.jPanel3.setBackground(new Color(0, 0, 0));
/* 180:    */     
/* 181:135 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 182:136 */     this.jPanel3.setLayout(jPanel3Layout);
/* 183:137 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
/* 184:    */     
/* 185:    */ 
/* 186:    */ 
/* 187:141 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 9, 32767));
/* 188:    */     
/* 189:    */ 
/* 190:    */ 
/* 191:    */ 
/* 192:146 */     this.tblRegistros_Vendedor.setModel(new DefaultTableModel(new Object[0][], new String[] { "Fecha venta", "Factura N°", "Estad.Factu", "Cod.Producto", "Marca", "Modelo", "Precio $", "Cantidad", "Importe", "Cliente" })
/* 193:    */     {
/* 194:154 */       Class[] types = { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Double.class, Integer.class, Double.class, Object.class };
/* 195:157 */       boolean[] canEdit = { false, false, false, false, false, false, false, false, false, false };
/* 196:    */       
/* 197:    */       public Class getColumnClass(int columnIndex)
/* 198:    */       {
/* 199:162 */         return this.types[columnIndex];
/* 200:    */       }
/* 201:    */       
/* 202:    */       public boolean isCellEditable(int rowIndex, int columnIndex)
/* 203:    */       {
/* 204:166 */         return this.canEdit[columnIndex];
/* 205:    */       }
/* 206:168 */     });
/* 207:169 */     this.jScrollPane1.setViewportView(this.tblRegistros_Vendedor);
/* 208:170 */     if (this.tblRegistros_Vendedor.getColumnModel().getColumnCount() > 0)
/* 209:    */     {
/* 210:171 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(0).setMinWidth(100);
/* 211:172 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(0).setPreferredWidth(100);
/* 212:173 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(0).setMaxWidth(100);
/* 213:174 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(1).setMinWidth(80);
/* 214:175 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(1).setPreferredWidth(80);
/* 215:176 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(1).setMaxWidth(80);
/* 216:177 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(2).setMinWidth(100);
/* 217:178 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(2).setPreferredWidth(100);
/* 218:179 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(2).setMaxWidth(100);
/* 219:180 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(3).setMinWidth(100);
/* 220:181 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(3).setPreferredWidth(100);
/* 221:182 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(3).setMaxWidth(100);
/* 222:183 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(4).setMinWidth(100);
/* 223:184 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(4).setPreferredWidth(100);
/* 224:185 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(4).setMaxWidth(100);
/* 225:186 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(5).setMinWidth(100);
/* 226:187 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(5).setPreferredWidth(100);
/* 227:188 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(5).setMaxWidth(100);
/* 228:189 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(6).setMinWidth(70);
/* 229:190 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(6).setPreferredWidth(70);
/* 230:191 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(6).setMaxWidth(70);
/* 231:192 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(7).setMinWidth(60);
/* 232:193 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(7).setPreferredWidth(60);
/* 233:194 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(7).setMaxWidth(60);
/* 234:195 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(8).setMinWidth(70);
/* 235:196 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(8).setPreferredWidth(70);
/* 236:197 */       this.tblRegistros_Vendedor.getColumnModel().getColumn(8).setMaxWidth(70);
/* 237:    */     }
/* 238:200 */     this.btnImprimir.setBackground(new Color(204, 204, 255));
/* 239:201 */     this.btnImprimir.setIcon(new ImageIcon(getClass().getResource("/icon/print-32.png")));
/* 240:202 */     this.btnImprimir.setText("Imprimir");
/* 241:203 */     this.btnImprimir.addActionListener(new ActionListener()
/* 242:    */     {
/* 243:    */       public void actionPerformed(ActionEvent evt)
/* 244:    */       {
/* 245:205 */         ventas_vendedorDesk.this.btnImprimirActionPerformed(evt);
/* 246:    */       }
/* 247:208 */     });
/* 248:209 */     this.jLabel12.setFont(new Font("sansserif", 1, 12));
/* 249:210 */     this.jLabel12.setText("Ledatel servicio en venta , reparaciones y compra de articulos moviles.");
/* 250:211 */     this.jLabel12.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 251:    */     
/* 252:213 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 253:214 */     this.jPanel1.setLayout(jPanel1Layout);
/* 254:215 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1327, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnImprimir)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addGap(145, 145, 145).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(txtApellidos_Nombres, -2, 203, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(119, 119, 119).addComponent(this.btnBuscar, -2, 180, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jPanel2, -2, -1, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel12, -1, 908, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(147, 147, 147).addComponent(this.jLabel1)).addGroup(jPanel1Layout.createSequentialGroup().addGap(117, 117, 117).addComponent(lblCodigo_vendedor, -2, 152, -2))))).addGap(130, 130, 130))).addContainerGap())));
/* 255:    */     
/* 256:    */ 
/* 257:    */ 
/* 258:    */ 
/* 259:    */ 
/* 260:    */ 
/* 261:    */ 
/* 262:    */ 
/* 263:    */ 
/* 264:    */ 
/* 265:    */ 
/* 266:    */ 
/* 267:    */ 
/* 268:    */ 
/* 269:    */ 
/* 270:    */ 
/* 271:    */ 
/* 272:    */ 
/* 273:    */ 
/* 274:    */ 
/* 275:    */ 
/* 276:    */ 
/* 277:    */ 
/* 278:    */ 
/* 279:    */ 
/* 280:    */ 
/* 281:    */ 
/* 282:    */ 
/* 283:    */ 
/* 284:    */ 
/* 285:    */ 
/* 286:    */ 
/* 287:    */ 
/* 288:    */ 
/* 289:    */ 
/* 290:    */ 
/* 291:    */ 
/* 292:253 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 598, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(lblCodigo_vendedor, -2, 38, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(0, 61, 32767).addComponent(this.jLabel12, -2, 64, -2))).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(txtApellidos_Nombres, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnBuscar, -1, -1, 32767)).addComponent(this.jPanel2, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnImprimir, -2, 80, -2).addComponent(this.jScrollPane1, -2, 343, -2)).addContainerGap())));
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
/* 321:    */ 
/* 322:    */ 
/* 323:    */ 
/* 324:    */ 
/* 325:286 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 326:287 */     getContentPane().setLayout(layout);
/* 327:288 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jPanel1, -2, -1, -2).addGap(0, 0, 32767)));
/* 328:    */     
/* 329:    */ 
/* 330:    */ 
/* 331:    */ 
/* 332:    */ 
/* 333:    */ 
/* 334:295 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jPanel1, -2, -1, -2).addGap(0, 0, 32767)));
/* 335:    */     
/* 336:    */ 
/* 337:    */ 
/* 338:    */ 
/* 339:    */ 
/* 340:    */ 
/* 341:    */ 
/* 342:303 */     pack();
/* 343:    */   }
/* 344:    */   
/* 345:    */   private void dateFechaInicialOnCommit(CommitEvent evt)
/* 346:    */   {
/* 347:307 */     hablitaLimpia(true);
/* 348:    */   }
/* 349:    */   
/* 350:    */   private void dateFechaFinalOnCommit(CommitEvent evt)
/* 351:    */   {
/* 352:311 */     hablitaLimpia(true);
/* 353:    */   }
/* 354:    */   
/* 355:    */   private void btnBuscarActionPerformed(ActionEvent evt)
/* 356:    */   {
/* 357:315 */     hablitaLimpia(true);
/* 358:    */     try
/* 359:    */     {
/* 360:317 */       this.model = ((DefaultTableModel)this.tblRegistros_Vendedor.getModel());
/* 361:318 */       String nuevoAño = "";
/* 362:319 */       String año = this.dateFechaInicial.getText().substring(6);
/* 363:320 */       String mes = this.dateFechaInicial.getText().substring(3, 5);
/* 364:321 */       String dia = this.dateFechaInicial.getText().substring(0, 2);
/* 365:322 */       if (año.equals("00")) {
/* 366:323 */         nuevoAño = "2000-";
/* 367:    */       }
/* 368:325 */       nuevoAño = "20" + año + "-";
/* 369:326 */       String nuevomes = mes + "-";
/* 370:327 */       String año2 = this.dateFechaFinal.getText().substring(6);
/* 371:328 */       String mes2 = this.dateFechaFinal.getText().substring(3, 5);
/* 372:329 */       String dia2 = this.dateFechaFinal.getText().substring(0, 2);
/* 373:330 */       String nuevoAño2 = "20" + año2 + "-";
/* 374:331 */       String nuevomes2 = mes2 + "-";
/* 375:332 */       String fechaInicial = nuevoAño + nuevomes + dia;
/* 376:333 */       String fechaFinal = nuevoAño2 + nuevomes2 + dia2;
/* 377:334 */       String codigo = lblCodigo_vendedor.getText();
/* 378:335 */       this.rs = this.OempleadoDao.ventasEmpleados(fechaInicial, fechaFinal, codigo);
/* 379:336 */       while (this.rs.next())
/* 380:    */       {
/* 381:337 */         Object[] reg_vendedor = { this.rs.getString(1), this.rs.getString(2), this.rs.getString(3), this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), Double.valueOf(this.rs.getDouble(7)), Integer.valueOf(this.rs.getInt(8)), Double.valueOf(this.rs.getDouble(9)), this.rs.getString(10) };
/* 382:338 */         this.model.addRow(reg_vendedor);
/* 383:    */       }
/* 384:    */     }
/* 385:    */     catch (Exception e)
/* 386:    */     {
/* 387:341 */       System.out.println(e);
/* 388:    */     }
/* 389:    */   }
/* 390:    */   
/* 391:    */   private void btnImprimirActionPerformed(ActionEvent evt)
/* 392:    */   {
/* 393:346 */     List lista = new ArrayList();
/* 394:347 */     for (int i = 0; i < this.tblRegistros_Vendedor.getRowCount(); i++)
/* 395:    */     {
/* 396:348 */       ventas_vendedorReport listac = new ventas_vendedorReport(this.tblRegistros_Vendedor.getValueAt(i, 0).toString(), this.tblRegistros_Vendedor.getValueAt(i, 1).toString(), this.tblRegistros_Vendedor.getValueAt(i, 2).toString(), this.tblRegistros_Vendedor.getValueAt(i, 3).toString(), this.tblRegistros_Vendedor.getValueAt(i, 4).toString(), this.tblRegistros_Vendedor.getValueAt(i, 5).toString(), Double.parseDouble(this.tblRegistros_Vendedor.getValueAt(i, 6).toString()), Integer.parseInt(this.tblRegistros_Vendedor.getValueAt(i, 7).toString()), Double.parseDouble(this.tblRegistros_Vendedor.getValueAt(i, 8).toString()), this.tblRegistros_Vendedor.getValueAt(i, 9).toString());
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
/* 407:359 */       lista.add(listac);
/* 408:    */     }
/* 409:    */     try
/* 410:    */     {
/* 411:363 */       JasperReport report = (JasperReport)JRLoader.loadObject("C:\\LEDATEL\\reportes\\ventas_vendedorReport.jasper");
/* 412:    */       
/* 413:365 */       Map parametro = new HashMap();
/* 414:    */       
/* 415:367 */       parametro.put("CodigoVendedor", lblCodigo_vendedor.getText());
/* 416:368 */       parametro.put("datosVendedeor", txtApellidos_Nombres.getText());
/* 417:369 */       parametro.put("FechaIniclal", this.dateFechaInicial.getText());
/* 418:370 */       parametro.put("FechaFinal", this.dateFechaFinal.getText());
/* 419:371 */       JasperPrint print = JasperFillManager.fillReport(report, parametro, new JRBeanCollectionDataSource(lista));
/* 420:372 */       JasperViewer.viewReport(print, false);
/* 421:    */     }
/* 422:    */     catch (Exception e)
/* 423:    */     {
/* 424:375 */       System.out.println(e.getMessage());
/* 425:    */     }
/* 426:    */   }
/* 427:    */   
/* 428:    */   private void hablitaLimpia(boolean b)
/* 429:    */   {
/* 430:400 */     this.model = ((DefaultTableModel)this.tblRegistros_Vendedor.getModel());
/* 431:401 */     this.btnBuscar.setEnabled(b);
/* 432:402 */     int filas = this.tblRegistros_Vendedor.getRowCount();
/* 433:403 */     for (int i = 0; filas > i; i++) {
/* 434:404 */       this.model.removeRow(0);
/* 435:    */     }
/* 436:    */   }
/* 437:    */ }



/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar

 * Qualified Name:     Desk.ventas_vendedorDesk

 * JD-Core Version:    0.7.0.1

 */