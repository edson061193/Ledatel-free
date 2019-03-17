/*   1:    */ package Desk;
/*   2:    */ 
/*   3:    */ import Dao.productoDao;
/*   4:    */ import Gui.VentanaPrincipalGUI;
/*   5:    */ import java.awt.Color;
/*   6:    */ import java.awt.Container;
/*   7:    */ import java.awt.Dimension;
/*   8:    */ import java.awt.Font;
/*   9:    */ import java.awt.event.ActionEvent;
/*  10:    */ import java.awt.event.ActionListener;
/*  11:    */ import java.awt.event.KeyAdapter;
/*  12:    */ import java.awt.event.KeyEvent;
/*  13:    */ import java.awt.event.MouseAdapter;
/*  14:    */ import java.awt.event.MouseEvent;
/*  15:    */ import java.io.PrintStream;
/*  16:    */ import java.sql.ResultSet;
/*  17:    */ import javax.swing.BorderFactory;
/*  18:    */ import javax.swing.GroupLayout;
/*  19:    */ import javax.swing.GroupLayout.Alignment;
/*  20:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  21:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  22:    */ import javax.swing.ImageIcon;
/*  23:    */ import javax.swing.JButton;
/*  24:    */ import javax.swing.JComboBox;
/*  25:    */ import javax.swing.JDesktopPane;
/*  26:    */ import javax.swing.JInternalFrame;
/*  27:    */ import javax.swing.JLabel;
/*  28:    */ import javax.swing.JMenuItem;
/*  29:    */ import javax.swing.JOptionPane;
/*  30:    */ import javax.swing.JPanel;
/*  31:    */ import javax.swing.JPopupMenu;
/*  32:    */ import javax.swing.JPopupMenu.Separator;
/*  33:    */ import javax.swing.JScrollPane;
/*  34:    */ import javax.swing.JTable;
/*  35:    */ import javax.swing.JTextArea;
/*  36:    */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*  37:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  38:    */ import javax.swing.event.AncestorEvent;
/*  39:    */ import javax.swing.event.AncestorListener;
/*  40:    */ import javax.swing.table.DefaultTableModel;
/*  41:    */ import javax.swing.table.TableColumn;
/*  42:    */ import javax.swing.table.TableColumnModel;
/*  43:    */ 
/*  44:    */ public class productoDesk
/*  45:    */   extends JInternalFrame
/*  46:    */ {
/*  47: 21 */   private static productoDesk fromProducto = null;
/*  48:    */   
/*  49:    */   public static productoDesk getForm()
/*  50:    */   {
/*  51: 24 */     if (fromProducto == null) {
/*  52: 25 */       fromProducto = new productoDesk();
/*  53:    */     }
/*  54: 27 */     return fromProducto;
/*  55:    */   }
/*  56:    */   
/*  57: 30 */   String modelo = "";
/*  58: 31 */   String marca = "";
/*  59:    */   ResultSet rs;
/*  60: 33 */   String codigoProducto = "";
/*  61:    */   DefaultTableModel model;
/*  62: 35 */   productoDao oProductoDao = new productoDao();
/*  63:    */   private JPopupMenu PopupEnviar;
/*  64:    */   private JTextArea areaObservacionn;
/*  65:    */   private JButton btnBuscar;
/*  66:    */   private JComboBox cboMarca;
/*  67:    */   private JLabel jLabel1;
/*  68:    */   private JLabel jLabel2;
/*  69:    */   private JPanel jPanel1;
/*  70:    */   private JScrollPane jScrollPane1;
/*  71:    */   private JScrollPane jScrollPane2;
/*  72:    */   private JPopupMenu.Separator jSeparator1;
/*  73:    */   private JLabel lblImg;
/*  74:    */   private JMenuItem menuEnviarA_reparaciones;
/*  75:    */   private JMenuItem menuEnviarA_ventas;
/*  76:    */   private JMenuItem mnuCreditos;
/*  77:    */   private JMenuItem mnuInformacion;
/*  78:    */   private JTable tblRegistros;
/*  79:    */   private JTextField txtBuscar;
/*  80:    */   
/*  81:    */   public productoDesk()
/*  82:    */   {
/*  83: 38 */     initComponents();
/*  84: 39 */     cargaMarca();
/*  85:    */   }
/*  86:    */   
/*  87:    */   private void initComponents()
/*  88:    */   {
/*  89: 46 */     this.PopupEnviar = new JPopupMenu();
/*  90: 47 */     this.menuEnviarA_ventas = new JMenuItem();
/*  91: 48 */     this.menuEnviarA_reparaciones = new JMenuItem();
/*  92: 49 */     this.jSeparator1 = new JPopupMenu.Separator();
/*  93: 50 */     this.mnuCreditos = new JMenuItem();
/*  94: 51 */     this.mnuInformacion = new JMenuItem();
/*  95: 52 */     this.jPanel1 = new JPanel();
/*  96: 53 */     this.jLabel1 = new JLabel();
/*  97: 54 */     this.cboMarca = new JComboBox();
/*  98: 55 */     this.btnBuscar = new JButton();
/*  99: 56 */     this.jScrollPane1 = new JScrollPane();
/* 100: 57 */     this.tblRegistros = new JTable();
/* 101: 58 */     this.jLabel2 = new JLabel();
/* 102: 59 */     this.txtBuscar = new JTextField();
/* 103: 60 */     this.lblImg = new JLabel();
/* 104: 61 */     this.jScrollPane2 = new JScrollPane();
/* 105: 62 */     this.areaObservacionn = new JTextArea();
/* 106:    */     
/* 107: 64 */     this.menuEnviarA_ventas.setText("ENVIAR A BOLETA DE VENTAS");
/* 108: 65 */     this.menuEnviarA_ventas.setMaximumSize(new Dimension(500, 50));
/* 109: 66 */     this.menuEnviarA_ventas.addActionListener(new ActionListener()
/* 110:    */     {
/* 111:    */       public void actionPerformed(ActionEvent evt)
/* 112:    */       {
/* 113: 68 */         productoDesk.this.menuEnviarA_ventasActionPerformed(evt);
/* 114:    */       }
/* 115: 70 */     });
/* 116: 71 */     this.PopupEnviar.add(this.menuEnviarA_ventas);
/* 117:    */     
/* 118: 73 */     this.menuEnviarA_reparaciones.setText("ENVIAR A BOLETA DE REPARACIONES");
/* 119: 74 */     this.menuEnviarA_reparaciones.setMaximumSize(new Dimension(500, 50));
/* 120: 75 */     this.menuEnviarA_reparaciones.addActionListener(new ActionListener()
/* 121:    */     {
/* 122:    */       public void actionPerformed(ActionEvent evt)
/* 123:    */       {
/* 124: 77 */         productoDesk.this.menuEnviarA_reparacionesActionPerformed(evt);
/* 125:    */       }
/* 126: 79 */     });
/* 127: 80 */     this.PopupEnviar.add(this.menuEnviarA_reparaciones);
/* 128:    */     
/* 129: 82 */     this.jSeparator1.setMaximumSize(new Dimension(500, 1));
/* 130: 83 */     this.PopupEnviar.add(this.jSeparator1);
/* 131:    */     
/* 132: 85 */     this.mnuCreditos.setText("ENVIAR A CREDITOS");
/* 133: 86 */     this.mnuCreditos.addActionListener(new ActionListener()
/* 134:    */     {
/* 135:    */       public void actionPerformed(ActionEvent evt)
/* 136:    */       {
/* 137: 88 */         productoDesk.this.mnuCreditosActionPerformed(evt);
/* 138:    */       }
/* 139: 90 */     });
/* 140: 91 */     this.PopupEnviar.add(this.mnuCreditos);
/* 141:    */     
/* 142: 93 */     this.mnuInformacion.setText("INFORMACIÓN");
/* 143: 94 */     this.mnuInformacion.addActionListener(new ActionListener()
/* 144:    */     {
/* 145:    */       public void actionPerformed(ActionEvent evt)
/* 146:    */       {
/* 147: 96 */         productoDesk.this.mnuInformacionActionPerformed(evt);
/* 148:    */       }
/* 149: 98 */     });
/* 150: 99 */     this.PopupEnviar.add(this.mnuInformacion);
/* 151:    */     
/* 152:101 */     setClosable(true);
/* 153:102 */     setIconifiable(true);
/* 154:103 */     setMaximizable(true);
/* 155:104 */     setTitle("Lista de productos en stock ");
/* 156:105 */     setFrameIcon(new ImageIcon(getClass().getResource("/Fondos/ld.png")));
/* 157:106 */     setMinimumSize(new Dimension(1343, 621));
/* 158:107 */     setPreferredSize(new Dimension(1343, 621));
/* 159:    */     
/* 160:109 */     this.jPanel1.setBackground(new Color(102, 102, 102));
/* 161:110 */     this.jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
/* 162:    */     
/* 163:112 */     this.jLabel1.setFont(new Font("sansserif", 1, 14));
/* 164:113 */     this.jLabel1.setForeground(new Color(255, 255, 255));
/* 165:114 */     this.jLabel1.setText("MARCA:");
/* 166:    */     
/* 167:116 */     this.cboMarca.setBackground(new Color(102, 102, 102));
/* 168:117 */     this.cboMarca.setForeground(new Color(0, 0, 102));
/* 169:118 */     this.cboMarca.addActionListener(new ActionListener()
/* 170:    */     {
/* 171:    */       public void actionPerformed(ActionEvent evt)
/* 172:    */       {
/* 173:120 */         productoDesk.this.cboMarcaActionPerformed(evt);
/* 174:    */       }
/* 175:123 */     });
/* 176:124 */     this.btnBuscar.setBackground(new Color(153, 204, 255));
/* 177:125 */     this.btnBuscar.setIcon(new ImageIcon(getClass().getResource("/icon/search-32.png")));
/* 178:126 */     this.btnBuscar.setText("buscar");
/* 179:127 */     this.btnBuscar.addActionListener(new ActionListener()
/* 180:    */     {
/* 181:    */       public void actionPerformed(ActionEvent evt)
/* 182:    */       {
/* 183:129 */         productoDesk.this.btnBuscarActionPerformed(evt);
/* 184:    */       }
/* 185:132 */     });
/* 186:133 */     this.tblRegistros.setBackground(new Color(204, 204, 255));
/* 187:134 */     this.tblRegistros.setFont(new Font("Arial", 0, 14));
/* 188:135 */     this.tblRegistros.setModel(new DefaultTableModel(new Object[0][], new String[] { "TIPO", "CODIGO", "MARCA", "SERIE", "PRECIO", "CANTIDAD", "OBSERVACION", "ESTADO" })
/* 189:    */     {
/* 190:143 */       Class[] types = { String.class, String.class, String.class, String.class, Double.class, Integer.class, String.class, String.class };
/* 191:146 */       boolean[] canEdit = { false, false, true, true, false, false, true, false };
/* 192:    */       
/* 193:    */       public Class getColumnClass(int columnIndex)
/* 194:    */       {
/* 195:151 */         return this.types[columnIndex];
/* 196:    */       }
/* 197:    */       
/* 198:    */       public boolean isCellEditable(int rowIndex, int columnIndex)
/* 199:    */       {
/* 200:155 */         return this.canEdit[columnIndex];
/* 201:    */       }
/* 202:157 */     });
/* 203:158 */     this.tblRegistros.setComponentPopupMenu(this.PopupEnviar);
/* 204:159 */     this.tblRegistros.setSelectionBackground(new Color(153, 153, 255));
/* 205:160 */     this.tblRegistros.setSelectionForeground(new Color(0, 0, 0));
/* 206:161 */     this.tblRegistros.addMouseListener(new MouseAdapter()
/* 207:    */     {
/* 208:    */       public void mouseClicked(MouseEvent evt)
/* 209:    */       {
/* 210:163 */         productoDesk.this.tblRegistrosMouseClicked(evt);
/* 211:    */       }
/* 212:165 */     });
/* 213:166 */     this.tblRegistros.addAncestorListener(new AncestorListener()
/* 214:    */     {
/* 215:    */       public void ancestorMoved(AncestorEvent evt) {}
/* 216:    */       
/* 217:    */       public void ancestorAdded(AncestorEvent evt)
/* 218:    */       {
/* 219:170 */         productoDesk.this.tblRegistrosAncestorAdded(evt);
/* 220:    */       }
/* 221:    */       
/* 222:    */       public void ancestorRemoved(AncestorEvent evt) {}
/* 223:174 */     });
/* 224:175 */     this.jScrollPane1.setViewportView(this.tblRegistros);
/* 225:176 */     if (this.tblRegistros.getColumnModel().getColumnCount() > 0)
/* 226:    */     {
/* 227:177 */       this.tblRegistros.getColumnModel().getColumn(0).setMinWidth(100);
/* 228:178 */       this.tblRegistros.getColumnModel().getColumn(0).setPreferredWidth(100);
/* 229:179 */       this.tblRegistros.getColumnModel().getColumn(0).setMaxWidth(100);
/* 230:180 */       this.tblRegistros.getColumnModel().getColumn(1).setMinWidth(80);
/* 231:181 */       this.tblRegistros.getColumnModel().getColumn(1).setPreferredWidth(80);
/* 232:182 */       this.tblRegistros.getColumnModel().getColumn(1).setMaxWidth(80);
/* 233:183 */       this.tblRegistros.getColumnModel().getColumn(3).setMinWidth(70);
/* 234:184 */       this.tblRegistros.getColumnModel().getColumn(3).setPreferredWidth(70);
/* 235:185 */       this.tblRegistros.getColumnModel().getColumn(3).setMaxWidth(70);
/* 236:186 */       this.tblRegistros.getColumnModel().getColumn(4).setMinWidth(80);
/* 237:187 */       this.tblRegistros.getColumnModel().getColumn(4).setPreferredWidth(80);
/* 238:188 */       this.tblRegistros.getColumnModel().getColumn(4).setMaxWidth(80);
/* 239:189 */       this.tblRegistros.getColumnModel().getColumn(5).setMinWidth(70);
/* 240:190 */       this.tblRegistros.getColumnModel().getColumn(5).setPreferredWidth(70);
/* 241:191 */       this.tblRegistros.getColumnModel().getColumn(5).setMaxWidth(70);
/* 242:192 */       this.tblRegistros.getColumnModel().getColumn(7).setMinWidth(100);
/* 243:193 */       this.tblRegistros.getColumnModel().getColumn(7).setPreferredWidth(100);
/* 244:194 */       this.tblRegistros.getColumnModel().getColumn(7).setMaxWidth(100);
/* 245:    */     }
/* 246:197 */     this.jLabel2.setFont(new Font("sansserif", 1, 14));
/* 247:198 */     this.jLabel2.setForeground(new Color(255, 255, 255));
/* 248:199 */     this.jLabel2.setText("Filtrar productos en stock:");
/* 249:    */     
/* 250:201 */     this.txtBuscar.setFont(new Font("Tahoma", 0, 14));
/* 251:202 */     this.txtBuscar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 252:203 */     this.txtBuscar.addKeyListener(new KeyAdapter()
/* 253:    */     {
/* 254:    */       public void keyReleased(KeyEvent evt)
/* 255:    */       {
/* 256:205 */         productoDesk.this.txtBuscarKeyReleased(evt);
/* 257:    */       }
/* 258:208 */     });
/* 259:209 */     this.lblImg.setBackground(new Color(153, 153, 255));
/* 260:210 */     this.lblImg.setHorizontalAlignment(0);
/* 261:211 */     this.lblImg.setOpaque(true);
/* 262:    */     
/* 263:213 */     this.areaObservacionn.setEditable(false);
/* 264:214 */     this.areaObservacionn.setBackground(new Color(204, 204, 204));
/* 265:215 */     this.areaObservacionn.setColumns(20);
/* 266:216 */     this.areaObservacionn.setFont(new Font("Arial", 0, 14));
/* 267:217 */     this.areaObservacionn.setRows(5);
/* 268:218 */     this.jScrollPane2.setViewportView(this.areaObservacionn);
/* 269:    */     
/* 270:220 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 271:221 */     this.jPanel1.setLayout(jPanel1Layout);
/* 272:222 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1).addGap(27, 27, 27).addComponent(this.cboMarca, -2, 225, -2).addGap(54, 54, 54).addComponent(this.btnBuscar, -2, 159, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.lblImg, -2, 276, -2).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -2, 1014, -2).addComponent(this.jScrollPane2, -2, 859, -2)))).addGap(55, 55, 55)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2).addGap(18, 18, 18).addComponent(this.txtBuscar, -2, 386, -2).addContainerGap(354, 32767))));
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
/* 292:    */ 
/* 293:    */ 
/* 294:    */ 
/* 295:    */ 
/* 296:    */ 
/* 297:    */ 
/* 298:248 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnBuscar).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel1).addComponent(this.cboMarca, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.lblImg, -1, -1, 32767).addComponent(this.jScrollPane1, -1, 312, 32767)).addGap(56, 56, 56).addComponent(this.jScrollPane2, -2, -1, -2).addContainerGap(74, 32767)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addGroup(jPanel1Layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.txtBuscar, -2, 27, -2))).addContainerGap(550, 32767))));
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
/* 325:275 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 326:276 */     getContentPane().setLayout(layout);
/* 327:277 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/* 328:    */     
/* 329:    */ 
/* 330:    */ 
/* 331:281 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2));
/* 332:    */     
/* 333:    */ 
/* 334:    */ 
/* 335:    */ 
/* 336:286 */     pack();
/* 337:    */   }
/* 338:    */   
/* 339:    */   private void cboMarcaActionPerformed(ActionEvent evt)
/* 340:    */   {
/* 341:290 */     this.model = ((DefaultTableModel)this.tblRegistros.getModel());
/* 342:291 */     int filas = this.tblRegistros.getRowCount();
/* 343:292 */     for (int i = 0; filas > i; i++) {
/* 344:293 */       this.model.removeRow(0);
/* 345:    */     }
/* 346:295 */     this.btnBuscar.setEnabled(true);
/* 347:    */   }
/* 348:    */   
/* 349:    */   private void btnBuscarActionPerformed(ActionEvent evt)
/* 350:    */   {
/* 351:    */     try
/* 352:    */     {
/* 353:300 */       this.marca = this.cboMarca.getSelectedItem().toString();
/* 354:301 */       this.rs = this.oProductoDao.buscaPorMarca(this.marca);
/* 355:302 */       cargaTABLE();
/* 356:    */     }
/* 357:    */     catch (Exception e) {}
/* 358:    */   }
/* 359:    */   
/* 360:    */   private void tblRegistrosMouseClicked(MouseEvent evt)
/* 361:    */   {
/* 362:309 */     muestraImagen();
/* 363:310 */     this.areaObservacionn.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 6).toString());
/* 364:    */   }
/* 365:    */   
/* 366:    */   private void txtBuscarKeyReleased(KeyEvent evt)
/* 367:    */   {
/* 368:    */     try
/* 369:    */     {
/* 370:315 */       this.marca = this.txtBuscar.getText().toLowerCase();
/* 371:316 */       this.modelo = this.txtBuscar.getText().toLowerCase();
/* 372:317 */       this.model = ((DefaultTableModel)this.tblRegistros.getModel());
/* 373:318 */       this.rs = this.oProductoDao.buscarProductoVentas(this.marca, this.modelo);
/* 374:319 */       while (this.tblRegistros.getRowCount() > 0) {
/* 375:320 */         this.model.removeRow(0);
/* 376:    */       }
/* 377:322 */       if (!this.txtBuscar.getText().isEmpty()) {
/* 378:325 */         cargaTABLE();
/* 379:    */       }
/* 380:    */     }
/* 381:    */     catch (Exception e) {}
/* 382:    */   }
/* 383:    */   
/* 384:    */   private void menuEnviarA_ventasActionPerformed(ActionEvent evt)
/* 385:    */   {
/* 386:332 */     enviarBoletadeventas();
/* 387:    */   }
/* 388:    */   
/* 389:    */   private void tblRegistrosAncestorAdded(AncestorEvent evt) {}
/* 390:    */   
/* 391:    */   private void menuEnviarA_reparacionesActionPerformed(ActionEvent evt)
/* 392:    */   {
/* 393:340 */     enviarBoletadeReparaciones();
/* 394:    */   }
/* 395:    */   
/* 396:    */   private void mnuCreditosActionPerformed(ActionEvent evt)
/* 397:    */   {
/* 398:344 */     int cantidad = Integer.parseInt(JOptionPane.showInputDialog(this.rootPane, "ingrese cantidad a enviar..."));
/* 399:345 */     int enviar = Integer.parseInt(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 5).toString());
/* 400:346 */     if (enviar < cantidad)
/* 401:    */     {
/* 402:347 */       JOptionPane.showMessageDialog(this.rootPane, "Producto fuera de Stock...");
/* 403:    */     }
/* 404:    */     else
/* 405:    */     {
/* 406:349 */       contratoDesk.txtCodigo_producto.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 1).toString());
/* 407:350 */       contratoDesk.txtMarca_serie.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 2).toString() + "  " + this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 3).toString());
/* 408:351 */       contratoDesk.txtCantidad.setText(String.valueOf(cantidad));
/* 409:352 */       double precio = Double.parseDouble(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 4).toString());
/* 410:353 */       double total_pagar = precio * cantidad;
/* 411:354 */       contratoDesk.txtPrecio_contado.setText(String.valueOf(total_pagar));
/* 412:355 */       dispose();
/* 413:    */     }
/* 414:    */   }
/* 415:    */   
/* 416:    */   private void mnuInformacionActionPerformed(ActionEvent evt)
/* 417:    */   {
/* 418:362 */     informacion_productoDesk g = new informacion_productoDesk();
/* 419:363 */     VentanaPrincipalGUI.desk.add(g);
/* 420:364 */     g.show();
/* 421:    */   }
/* 422:    */   
/* 423:    */   private void muestraImagen()
/* 424:    */   {
/* 425:369 */     String cod_producto = this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 1).toString();
/* 426:370 */     ImageIcon imagen = new ImageIcon("C:/LEDATEL/IMAGENES LEDATEL/" + cod_producto + ".jpg");
/* 427:371 */     this.lblImg.setIcon(imagen);
/* 428:    */   }
/* 429:    */   
/* 430:    */   private void cargaTABLE()
/* 431:    */   {
/* 432:    */     try
/* 433:    */     {
/* 434:397 */       while (this.rs.next())
/* 435:    */       {
/* 436:398 */         Object[] regi = { this.rs.getString(1), this.rs.getString(2), this.rs.getString(3), this.rs.getString(4), Double.valueOf(this.rs.getDouble(5)), Integer.valueOf(this.rs.getInt(6)), this.rs.getString(7), this.rs.getString(8) };
/* 437:    */         
/* 438:    */ 
/* 439:    */ 
/* 440:402 */         this.model.addRow(regi);
/* 441:    */       }
/* 442:    */     }
/* 443:    */     catch (Exception e)
/* 444:    */     {
/* 445:405 */       System.out.println(e);
/* 446:    */     }
/* 447:    */   }
/* 448:    */   
/* 449:    */   private void cargaMarca()
/* 450:    */   {
/* 451:    */     try
/* 452:    */     {
/* 453:411 */       this.rs = this.oProductoDao.cargaMarca();
/* 454:412 */       while (this.rs.next()) {
/* 455:413 */         this.cboMarca.addItem(this.rs.getString(5));
/* 456:    */       }
/* 457:    */     }
/* 458:    */     catch (Exception e) {}
/* 459:    */   }
/* 460:    */   
/* 461:    */   private void enviarBoletadeventas()
/* 462:    */   {
/* 463:421 */     int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a Enviar..."));
/* 464:422 */     int stock = Integer.parseInt(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 5).toString());
/* 465:423 */     if (stock >= cantidad)
/* 466:    */     {
/* 467:424 */       boletaDesk.txtcod_prod.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 1).toString());
/* 468:425 */       this.marca = this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 2).toString();
/* 469:426 */       this.modelo = this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 3).toString();
/* 470:427 */       boletaDesk.txtMarca_modelo.setText(this.marca + " " + this.modelo);
/* 471:428 */       boletaDesk.txtPrecio.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 4).toString());
/* 472:429 */       boletaDesk.txtCantidad.setText(String.valueOf(cantidad));
/* 473:430 */       boletaDesk.txtCantidad.grabFocus();
/* 474:431 */       dispose();
/* 475:    */     }
/* 476:    */     else
/* 477:    */     {
/* 478:433 */       JOptionPane.showMessageDialog(this.rootPane, this.marca + " " + this.modelo + " -->PRODUCTO FUERA DE STOCK...");
/* 479:    */     }
/* 480:    */   }
/* 481:    */   
/* 482:    */   private void enviarBoletadeReparaciones()
/* 483:    */   {
/* 484:439 */     int cantidad = 0;
/* 485:440 */     cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a Enviar..."));
/* 486:441 */     int stock = Integer.parseInt(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 5).toString());
/* 487:442 */     if (stock >= cantidad)
/* 488:    */     {
/* 489:443 */       reparacionesDesk.txtcod_prod.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 1).toString());
/* 490:444 */       this.marca = this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 2).toString();
/* 491:445 */       this.modelo = this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 3).toString();
/* 492:446 */       reparacionesDesk.txtMarca_modelo.setText(this.marca + " " + this.modelo);
/* 493:447 */       reparacionesDesk.txtPrecio.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 4).toString());
/* 494:448 */       reparacionesDesk.txtCantidad.setText(String.valueOf(cantidad));
/* 495:449 */       reparacionesDesk.txtCantidad.grabFocus();
/* 496:450 */       dispose();
/* 497:    */     }
/* 498:    */     else
/* 499:    */     {
/* 500:452 */       JOptionPane.showMessageDialog(this.rootPane, this.marca + " " + this.modelo + " -->PRODUCTO FUERA DE STOCK...");
/* 501:    */     }
/* 502:    */   }
/* 503:    */ }



/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar

 * Qualified Name:     Desk.productoDesk

 * JD-Core Version:    0.7.0.1

 */