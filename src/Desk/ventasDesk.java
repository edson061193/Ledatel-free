/*   1:    */ package Desk;
/*   2:    */ 
/*   3:    */ import Dao.boletaDao;
/*   4:    */ import Gui.VentanaPrincipalGUI;
/*   5:    */ import Log_Reporte.ventasReport;
/*   6:    */ import datechooser.beans.DateChooserCombo;
/*   7:    */ import datechooser.events.CommitEvent;
/*   8:    */ import datechooser.events.CommitListener;
/*   9:    */ import datechooser.view.BackRenderer;
/*  10:    */ import datechooser.view.appearance.AppearancesList;
/*  11:    */ import datechooser.view.appearance.ViewAppearance;
/*  12:    */ import datechooser.view.appearance.swing.ButtonPainter;
/*  13:    */ import datechooser.view.appearance.swing.LabelPainter;
/*  14:    */ import datechooser.view.appearance.swing.SwingCellAppearance;
/*  15:    */ import java.awt.Color;
/*  16:    */ import java.awt.Container;
/*  17:    */ import java.awt.Dimension;
/*  18:    */ import java.awt.Font;
/*  19:    */ import java.awt.event.ActionEvent;
/*  20:    */ import java.awt.event.ActionListener;
/*  21:    */ import java.awt.event.MouseAdapter;
/*  22:    */ import java.awt.event.MouseEvent;
/*  23:    */ import java.io.PrintStream;
/*  24:    */ import java.sql.ResultSet;
/*  25:    */ import java.util.ArrayList;
/*  26:    */ import java.util.HashMap;
/*  27:    */ import java.util.List;
/*  28:    */ import java.util.Locale;
/*  29:    */ import java.util.Map;
/*  30:    */ import javax.swing.BorderFactory;
/*  31:    */ import javax.swing.GroupLayout;
/*  32:    */ import javax.swing.GroupLayout.Alignment;
/*  33:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  34:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  35:    */ import javax.swing.ImageIcon;
/*  36:    */ import javax.swing.JButton;
/*  37:    */ import javax.swing.JDesktopPane;
/*  38:    */ import javax.swing.JInternalFrame;
/*  39:    */ import javax.swing.JLabel;
/*  40:    */ import javax.swing.JPanel;
/*  41:    */ import javax.swing.JScrollPane;
/*  42:    */ import javax.swing.JTable;
/*  43:    */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*  44:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  45:    */ import javax.swing.table.DefaultTableModel;
/*  46:    */ import javax.swing.table.TableColumn;
/*  47:    */ import javax.swing.table.TableColumnModel;
/*  48:    */ import net.sf.jasperreports.engine.JasperFillManager;
/*  49:    */ import net.sf.jasperreports.engine.JasperPrint;
/*  50:    */ import net.sf.jasperreports.engine.JasperReport;
/*  51:    */ import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
/*  52:    */ import net.sf.jasperreports.engine.util.JRLoader;
/*  53:    */ import net.sf.jasperreports.view.JasperViewer;
/*  54:    */ 
/*  55:    */ public class ventasDesk
/*  56:    */   extends JInternalFrame
/*  57:    */ {
/*  58: 25 */   private static ventasDesk fromVenta = null;
/*  59:    */   DefaultTableModel model;
/*  60:    */   ResultSet rs;
/*  61:    */   
/*  62:    */   public static ventasDesk getForm()
/*  63:    */   {
/*  64: 28 */     if (fromVenta == null) {
/*  65: 29 */       fromVenta = new ventasDesk();
/*  66:    */     }
/*  67: 31 */     return fromVenta;
/*  68:    */   }
/*  69:    */   
/*  70: 35 */   boletaDao oBoleta = new boletaDao();
/*  71:    */   private JPanel Contenedor;
/*  72:    */   private JButton btnBuscar;
/*  73:    */   public static JButton btnDetalle;
/*  74:    */   private JButton btnImprimir;
/*  75:    */   private DateChooserCombo dateFechaFinal;
/*  76:    */   private DateChooserCombo dateFechaInicial;
/*  77:    */   private JLabel jLabel2;
/*  78:    */   private JLabel jLabel3;
/*  79:    */   private JScrollPane jScrollPane1;
/*  80:    */   private JTable tblDetalleFact;
/*  81:    */   
/*  82:    */   public ventasDesk()
/*  83:    */   {
/*  84: 38 */     initComponents();
/*  85:    */   }
/*  86:    */   
/*  87:    */   private void initComponents()
/*  88:    */   {
/*  89: 51 */     this.Contenedor = new JPanel();
/*  90: 52 */     this.dateFechaInicial = new DateChooserCombo();
/*  91: 53 */     this.jLabel2 = new JLabel();
/*  92: 54 */     this.jLabel3 = new JLabel();
/*  93: 55 */     btnDetalle = new JButton();
/*  94: 56 */     this.btnBuscar = new JButton();
/*  95: 57 */     this.jScrollPane1 = new JScrollPane();
/*  96: 58 */     this.tblDetalleFact = new JTable();
/*  97: 59 */     this.btnImprimir = new JButton();
/*  98: 60 */     this.dateFechaFinal = new DateChooserCombo();
/*  99:    */     
/* 100: 62 */     setClosable(true);
/* 101: 63 */     setIconifiable(true);
/* 102: 64 */     setTitle("control de ventas segun las fechas");
/* 103: 65 */     setMinimumSize(new Dimension(1350, 620));
/* 104: 66 */     setPreferredSize(new Dimension(1350, 620));
/* 105:    */     
/* 106: 68 */     this.Contenedor.setBackground(new Color(0, 0, 0));
/* 107: 69 */     this.Contenedor.setBorder(BorderFactory.createLineBorder(new Color(204, 255, 0), 3));
/* 108:    */     
/* 109: 71 */     this.dateFechaInicial.setCurrentView(new AppearancesList("Grey", new ViewAppearance[] { new ViewAppearance("custom", new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 0), new Color(0, 0, 255), false, true, new ButtonPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 0), new Color(0, 0, 255), true, true, new ButtonPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 255), new Color(0, 0, 255), false, true, new ButtonPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(128, 128, 128), new Color(0, 0, 255), false, true, new LabelPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 0), new Color(0, 0, 255), false, true, new LabelPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 0), new Color(255, 0, 0), false, false, new ButtonPainter()), (BackRenderer)null, false, true) }));
/* 110:    */     
/* 111:    */ 
/* 112:    */ 
/* 113:    */ 
/* 114:    */ 
/* 115:    */ 
/* 116:    */ 
/* 117:    */ 
/* 118:    */ 
/* 119:    */ 
/* 120:    */ 
/* 121:    */ 
/* 122:    */ 
/* 123:    */ 
/* 124:    */ 
/* 125:    */ 
/* 126:    */ 
/* 127:    */ 
/* 128:    */ 
/* 129:    */ 
/* 130:    */ 
/* 131:    */ 
/* 132:    */ 
/* 133:    */ 
/* 134:    */ 
/* 135:    */ 
/* 136:    */ 
/* 137:    */ 
/* 138:    */ 
/* 139:    */ 
/* 140:    */ 
/* 141:    */ 
/* 142:    */ 
/* 143:    */ 
/* 144:    */ 
/* 145:    */ 
/* 146:    */ 
/* 147:    */ 
/* 148:    */ 
/* 149:    */ 
/* 150:112 */     this.dateFechaInicial.setCalendarBackground(new Color(204, 255, 255));
/* 151:113 */     this.dateFechaInicial.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 152:114 */     this.dateFechaInicial.setCalendarPreferredSize(new Dimension(441, 270));
/* 153:115 */     this.dateFechaInicial.setNothingAllowed(false);
/* 154:116 */     this.dateFechaInicial.setLocale(new Locale("pt", "BR", ""));
/* 155:117 */     this.dateFechaInicial.addCommitListener(new CommitListener()
/* 156:    */     {
/* 157:    */       public void onCommit(CommitEvent evt)
/* 158:    */       {
/* 159:119 */         ventasDesk.this.dateFechaInicialOnCommit(evt);
/* 160:    */       }
/* 161:122 */     });
/* 162:123 */     this.jLabel2.setFont(new Font("sansserif", 1, 14));
/* 163:124 */     this.jLabel2.setForeground(new Color(255, 255, 255));
/* 164:125 */     this.jLabel2.setText("Fecha Incial :");
/* 165:    */     
/* 166:127 */     this.jLabel3.setFont(new Font("sansserif", 1, 14));
/* 167:128 */     this.jLabel3.setForeground(new Color(255, 255, 255));
/* 168:129 */     this.jLabel3.setText("Fecha Final:");
/* 169:    */     
/* 170:131 */     btnDetalle.setBackground(new Color(204, 204, 255));
/* 171:132 */     btnDetalle.setFont(new Font("sansserif", 1, 14));
/* 172:133 */     btnDetalle.setIcon(new ImageIcon(getClass().getResource("/icon/basic3-017_invoice_bill-32.png")));
/* 173:134 */     btnDetalle.setText("Detalle");
/* 174:135 */     btnDetalle.addActionListener(new ActionListener()
/* 175:    */     {
/* 176:    */       public void actionPerformed(ActionEvent evt)
/* 177:    */       {
/* 178:137 */         ventasDesk.this.btnDetalleActionPerformed(evt);
/* 179:    */       }
/* 180:140 */     });
/* 181:141 */     this.btnBuscar.setBackground(new Color(204, 204, 255));
/* 182:142 */     this.btnBuscar.setFont(new Font("sansserif", 1, 14));
/* 183:143 */     this.btnBuscar.setIcon(new ImageIcon(getClass().getResource("/icon/search-32.png")));
/* 184:144 */     this.btnBuscar.setText("Buscar");
/* 185:145 */     this.btnBuscar.addActionListener(new ActionListener()
/* 186:    */     {
/* 187:    */       public void actionPerformed(ActionEvent evt)
/* 188:    */       {
/* 189:147 */         ventasDesk.this.btnBuscarActionPerformed(evt);
/* 190:    */       }
/* 191:150 */     });
/* 192:151 */     this.tblDetalleFact.setBackground(new Color(255, 255, 204));
/* 193:152 */     this.tblDetalleFact.setModel(new DefaultTableModel(new Object[0][], new String[] { "Boleta", "Cliente", "Fecha", "IGV", "Subtotal", "Total" })
/* 194:    */     {
/* 195:160 */       Class[] types = { String.class, String.class, String.class, Double.class, Double.class, Double.class };
/* 196:163 */       boolean[] canEdit = { false, false, false, false, false, false };
/* 197:    */       
/* 198:    */       public Class getColumnClass(int columnIndex)
/* 199:    */       {
/* 200:168 */         return this.types[columnIndex];
/* 201:    */       }
/* 202:    */       
/* 203:    */       public boolean isCellEditable(int rowIndex, int columnIndex)
/* 204:    */       {
/* 205:172 */         return this.canEdit[columnIndex];
/* 206:    */       }
/* 207:174 */     });
/* 208:175 */     this.tblDetalleFact.setSelectionBackground(new Color(0, 0, 153));
/* 209:176 */     this.tblDetalleFact.setSelectionForeground(new Color(255, 255, 0));
/* 210:177 */     this.tblDetalleFact.addMouseListener(new MouseAdapter()
/* 211:    */     {
/* 212:    */       public void mouseClicked(MouseEvent evt)
/* 213:    */       {
/* 214:179 */         ventasDesk.this.tblDetalleFactMouseClicked(evt);
/* 215:    */       }
/* 216:181 */     });
/* 217:182 */     this.jScrollPane1.setViewportView(this.tblDetalleFact);
/* 218:183 */     if (this.tblDetalleFact.getColumnModel().getColumnCount() > 0)
/* 219:    */     {
/* 220:184 */       this.tblDetalleFact.getColumnModel().getColumn(0).setMinWidth(120);
/* 221:185 */       this.tblDetalleFact.getColumnModel().getColumn(0).setPreferredWidth(120);
/* 222:186 */       this.tblDetalleFact.getColumnModel().getColumn(0).setMaxWidth(120);
/* 223:187 */       this.tblDetalleFact.getColumnModel().getColumn(2).setMinWidth(100);
/* 224:188 */       this.tblDetalleFact.getColumnModel().getColumn(2).setPreferredWidth(100);
/* 225:189 */       this.tblDetalleFact.getColumnModel().getColumn(2).setMaxWidth(100);
/* 226:190 */       this.tblDetalleFact.getColumnModel().getColumn(3).setMinWidth(100);
/* 227:191 */       this.tblDetalleFact.getColumnModel().getColumn(3).setPreferredWidth(100);
/* 228:192 */       this.tblDetalleFact.getColumnModel().getColumn(3).setMaxWidth(100);
/* 229:193 */       this.tblDetalleFact.getColumnModel().getColumn(4).setMinWidth(100);
/* 230:194 */       this.tblDetalleFact.getColumnModel().getColumn(4).setPreferredWidth(100);
/* 231:195 */       this.tblDetalleFact.getColumnModel().getColumn(4).setMaxWidth(100);
/* 232:196 */       this.tblDetalleFact.getColumnModel().getColumn(5).setMinWidth(120);
/* 233:197 */       this.tblDetalleFact.getColumnModel().getColumn(5).setPreferredWidth(120);
/* 234:198 */       this.tblDetalleFact.getColumnModel().getColumn(5).setMaxWidth(120);
/* 235:    */     }
/* 236:201 */     this.btnImprimir.setBackground(new Color(204, 204, 255));
/* 237:202 */     this.btnImprimir.setFont(new Font("sansserif", 1, 14));
/* 238:203 */     this.btnImprimir.setIcon(new ImageIcon(getClass().getResource("/icon/print-32.png")));
/* 239:204 */     this.btnImprimir.setText("Imprimir");
/* 240:205 */     this.btnImprimir.addActionListener(new ActionListener()
/* 241:    */     {
/* 242:    */       public void actionPerformed(ActionEvent evt)
/* 243:    */       {
/* 244:207 */         ventasDesk.this.btnImprimirActionPerformed(evt);
/* 245:    */       }
/* 246:210 */     });
/* 247:211 */     this.dateFechaFinal.setCurrentView(new AppearancesList("Grey", new ViewAppearance[] { new ViewAppearance("custom", new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 0), new Color(0, 0, 255), false, true, new ButtonPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 0), new Color(0, 0, 255), true, true, new ButtonPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 255), new Color(0, 0, 255), false, true, new ButtonPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(128, 128, 128), new Color(0, 0, 255), false, true, new LabelPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 0), new Color(0, 0, 255), false, true, new LabelPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 0), new Color(255, 0, 0), false, false, new ButtonPainter()), (BackRenderer)null, false, true) }));
/* 248:    */     
/* 249:    */ 
/* 250:    */ 
/* 251:    */ 
/* 252:    */ 
/* 253:    */ 
/* 254:    */ 
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
/* 288:252 */     this.dateFechaFinal.setCalendarBackground(new Color(204, 255, 255));
/* 289:253 */     this.dateFechaFinal.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 290:254 */     this.dateFechaFinal.setCalendarPreferredSize(new Dimension(441, 270));
/* 291:255 */     this.dateFechaFinal.setNothingAllowed(false);
/* 292:256 */     this.dateFechaFinal.setLocale(new Locale("pt", "BR", ""));
/* 293:257 */     this.dateFechaFinal.addCommitListener(new CommitListener()
/* 294:    */     {
/* 295:    */       public void onCommit(CommitEvent evt)
/* 296:    */       {
/* 297:259 */         ventasDesk.this.dateFechaFinalOnCommit(evt);
/* 298:    */       }
/* 299:262 */     });
/* 300:263 */     GroupLayout ContenedorLayout = new GroupLayout(this.Contenedor);
/* 301:264 */     this.Contenedor.setLayout(ContenedorLayout);
/* 302:265 */     ContenedorLayout.setHorizontalGroup(ContenedorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(ContenedorLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2).addGap(47, 47, 47).addComponent(this.dateFechaInicial, -2, 236, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 61, 32767).addComponent(this.jLabel3).addGap(18, 18, 18).addComponent(this.dateFechaFinal, -2, 236, -2).addGap(81, 81, 81).addComponent(this.btnBuscar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnImprimir).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnDetalle, -2, 135, -2).addGap(69, 69, 69)).addGroup(ContenedorLayout.createSequentialGroup().addComponent(this.jScrollPane1).addContainerGap()));
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
/* 324:287 */     ContenedorLayout.setVerticalGroup(ContenedorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(ContenedorLayout.createSequentialGroup().addGroup(ContenedorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(ContenedorLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(ContenedorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(ContenedorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnImprimir, -2, 62, -2).addComponent(btnDetalle, -2, 63, -2).addComponent(this.btnBuscar, -2, 62, -2)).addComponent(this.jLabel2).addComponent(this.dateFechaInicial, -2, -1, -2))).addGroup(ContenedorLayout.createSequentialGroup().addGap(12, 12, 12).addGroup(ContenedorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.dateFechaFinal, -2, -1, -2).addComponent(this.jLabel3)))).addGap(18, 18, 18).addComponent(this.jScrollPane1, -1, 487, 32767).addContainerGap()));
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
/* 347:310 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 348:311 */     getContentPane().setLayout(layout);
/* 349:312 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Contenedor, -1, -1, 32767));
/* 350:    */     
/* 351:    */ 
/* 352:    */ 
/* 353:316 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Contenedor, -1, -1, 32767));
/* 354:    */     
/* 355:    */ 
/* 356:    */ 
/* 357:    */ 
/* 358:321 */     pack();
/* 359:    */   }
/* 360:    */   
/* 361:    */   private void btnDetalleActionPerformed(ActionEvent evt)
/* 362:    */   {
/* 363:325 */     rDetalleDesk gui = new rDetalleDesk();
/* 364:326 */     VentanaPrincipalGUI.desk.add(gui);
/* 365:327 */     gui.show();
/* 366:328 */     rDetalleDesk.txtFactura.setText(this.tblDetalleFact.getValueAt(this.tblDetalleFact.getSelectedRow(), 0).toString());
/* 367:    */   }
/* 368:    */   
/* 369:    */   private void btnBuscarActionPerformed(ActionEvent evt)
/* 370:    */   {
/* 371:    */     try
/* 372:    */     {
/* 373:335 */       String nuevoAño = "";
/* 374:336 */       String año = this.dateFechaInicial.getText().substring(6);
/* 375:337 */       String mes = this.dateFechaInicial.getText().substring(3, 5);
/* 376:338 */       String dia = this.dateFechaInicial.getText().substring(0, 2);
/* 377:339 */       if (año.equals("00")) {
/* 378:340 */         nuevoAño = "2000-";
/* 379:    */       }
/* 380:342 */       nuevoAño = "20" + año + "-";
/* 381:343 */       String nuevomes = mes + "-";
/* 382:344 */       String año2 = this.dateFechaFinal.getText().substring(6);
/* 383:345 */       String mes2 = this.dateFechaFinal.getText().substring(3, 5);
/* 384:346 */       String dia2 = this.dateFechaFinal.getText().substring(0, 2);
/* 385:347 */       String nuevoAño2 = "20" + año2 + "-";
/* 386:348 */       String nuevomes2 = mes2 + "-";
/* 387:349 */       String fechaInicial = nuevoAño + nuevomes + dia;
/* 388:350 */       String fechaFinal = nuevoAño2 + nuevomes2 + dia2;
/* 389:351 */       this.rs = this.oBoleta.reportarVentas(fechaInicial, fechaFinal);
/* 390:352 */       while (this.rs.next())
/* 391:    */       {
/* 392:353 */         Object[] reg = { this.rs.getString(1), this.rs.getString(2), this.rs.getString(3), Double.valueOf(Math.round(this.rs.getDouble(4) * 100.0D) / 100.0D), Double.valueOf(Math.round(this.rs.getDouble(5) * 100.0D) / 100.0D), Double.valueOf(Math.round(this.rs.getDouble(6) * 100.0D) / 100.0D) };
/* 393:    */         
/* 394:    */ 
/* 395:    */ 
/* 396:    */ 
/* 397:    */ 
/* 398:    */ 
/* 399:    */ 
/* 400:    */ 
/* 401:362 */         this.model.addRow(reg);
/* 402:    */       }
/* 403:364 */       this.btnBuscar.setEnabled(false);
/* 404:    */     }
/* 405:    */     catch (Exception e)
/* 406:    */     {
/* 407:366 */       System.out.println(e.getMessage() + " en btn Buscar");
/* 408:    */     }
/* 409:    */   }
/* 410:    */   
/* 411:    */   private void tblDetalleFactMouseClicked(MouseEvent evt) {}
/* 412:    */   
/* 413:    */   private void btnImprimirActionPerformed(ActionEvent evt)
/* 414:    */   {
/* 415:377 */     List lista = new ArrayList();
/* 416:378 */     for (int i = 0; i < this.tblDetalleFact.getRowCount(); i++)
/* 417:    */     {
/* 418:379 */       ventasReport listaventas = new ventasReport(this.tblDetalleFact.getValueAt(i, 0).toString(), this.tblDetalleFact.getValueAt(i, 1).toString(), this.tblDetalleFact.getValueAt(i, 2).toString(), Double.parseDouble(this.tblDetalleFact.getValueAt(i, 3).toString()), Double.parseDouble(this.tblDetalleFact.getValueAt(i, 4).toString()), Double.parseDouble(this.tblDetalleFact.getValueAt(i, 5).toString()));
/* 419:    */       
/* 420:    */ 
/* 421:    */ 
/* 422:    */ 
/* 423:    */ 
/* 424:    */ 
/* 425:    */ 
/* 426:387 */       lista.add(listaventas);
/* 427:    */     }
/* 428:    */     try
/* 429:    */     {
/* 430:391 */       JasperReport report = (JasperReport)JRLoader.loadObject("C:\\LEDATEL\\reportes\\reporteVentas.jasper");
/* 431:392 */       Map parametro = new HashMap();
/* 432:393 */       parametro.put("fechaInicial", this.dateFechaInicial.getText());
/* 433:394 */       parametro.put("fechaFinal", this.dateFechaFinal.getText());
/* 434:395 */       JasperPrint print = JasperFillManager.fillReport(report, parametro, new JRBeanCollectionDataSource(lista));
/* 435:396 */       JasperViewer.viewReport(print, false);
/* 436:    */     }
/* 437:    */     catch (Exception e)
/* 438:    */     {
/* 439:399 */       System.out.println(e.getMessage());
/* 440:    */     }
/* 441:    */   }
/* 442:    */   
/* 443:    */   private void dateFechaInicialOnCommit(CommitEvent evt)
/* 444:    */   {
/* 445:404 */     hablitaLimpia(true);
/* 446:    */   }
/* 447:    */   
/* 448:    */   private void dateFechaFinalOnCommit(CommitEvent evt)
/* 449:    */   {
/* 450:408 */     hablitaLimpia(true);
/* 451:    */   }
/* 452:    */   
/* 453:    */   private void hablitaLimpia(boolean b)
/* 454:    */   {
/* 455:428 */     this.model = ((DefaultTableModel)this.tblDetalleFact.getModel());
/* 456:429 */     this.btnBuscar.setEnabled(b);
/* 457:430 */     int filas = this.tblDetalleFact.getRowCount();
/* 458:431 */     for (int i = 0; filas > i; i++) {
/* 459:432 */       this.model.removeRow(0);
/* 460:    */     }
/* 461:    */   }
/* 462:    */ }



/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar

 * Qualified Name:     Desk.ventasDesk

 * JD-Core Version:    0.7.0.1

 */