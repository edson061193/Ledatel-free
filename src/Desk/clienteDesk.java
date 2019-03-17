/*   1:    */ package Desk;
/*   2:    */ 
/*   3:    */ import Conexion.conexion;
/*   4:    */ import Dao.clienteDao;
/*   5:    */ import To.cliente_TO;
/*   6:    */ import java.awt.Color;
/*   7:    */ import java.awt.Container;
/*   8:    */ import java.awt.Dimension;
/*   9:    */ import java.awt.Font;
/*  10:    */ import java.awt.event.ActionEvent;
/*  11:    */ import java.awt.event.ActionListener;
/*  12:    */ import java.awt.event.KeyAdapter;
/*  13:    */ import java.awt.event.KeyEvent;
/*  14:    */ import java.awt.event.MouseAdapter;
/*  15:    */ import java.awt.event.MouseEvent;
/*  16:    */ import java.io.PrintStream;
/*  17:    */ import java.sql.Connection;
/*  18:    */ import java.sql.ResultSet;
/*  19:    */ import javax.swing.BorderFactory;
/*  20:    */ import javax.swing.GroupLayout;
/*  21:    */ import javax.swing.GroupLayout.Alignment;
/*  22:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  23:    */ import javax.swing.ImageIcon;
/*  24:    */ import javax.swing.JButton;
/*  25:    */ import javax.swing.JComboBox;
/*  26:    */ import javax.swing.JInternalFrame;
/*  27:    */ import javax.swing.JLabel;
/*  28:    */ import javax.swing.JMenuItem;
/*  29:    */ import javax.swing.JOptionPane;
/*  30:    */ import javax.swing.JPanel;
/*  31:    */ import javax.swing.JPopupMenu;
/*  32:    */ import javax.swing.JScrollPane;
/*  33:    */ import javax.swing.JTable;
/*  34:    */ import javax.swing.JTextField;
/*  35:    */ import javax.swing.event.AncestorEvent;
/*  36:    */ import javax.swing.event.AncestorListener;
/*  37:    */ import javax.swing.table.DefaultTableModel;
/*  38:    */ import javax.swing.table.TableColumn;
/*  39:    */ import javax.swing.table.TableColumnModel;
/*  40:    */ import net.sf.jasperreports.engine.JasperFillManager;
/*  41:    */ import net.sf.jasperreports.engine.JasperPrint;
/*  42:    */ import net.sf.jasperreports.engine.JasperReport;
/*  43:    */ import net.sf.jasperreports.engine.util.JRLoader;
/*  44:    */ import net.sf.jasperreports.view.JasperViewer;
/*  45:    */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*  46:    */ import org.netbeans.lib.awtextra.AbsoluteLayout;
/*  47:    */ 
/*  48:    */ public class clienteDesk
/*  49:    */   extends JInternalFrame
/*  50:    */ {
/*  51: 34 */   private static clienteDesk fromCliente = null;
/*  52:    */   DefaultTableModel model;
/*  53:    */   
/*  54:    */   public static clienteDesk getForm()
/*  55:    */   {
/*  56: 37 */     if (fromCliente == null) {
/*  57: 38 */       fromCliente = new clienteDesk();
/*  58:    */     }
/*  59: 40 */     return fromCliente;
/*  60:    */   }
/*  61:    */   
/*  62: 43 */   boolean vf = true;
/*  63:    */   ResultSet rs;
/*  64: 45 */   clienteDao oCliente = new clienteDao();
/*  65:    */   private JPopupMenu PopupEnviar;
/*  66:    */   private JButton btnCancelar;
/*  67:    */   private JButton btnImprimir;
/*  68:    */   private JButton btnModificar;
/*  69:    */   private JButton btnNuevo;
/*  70:    */   private JButton btnRegistrar;
/*  71:    */   private JComboBox cboTipoCliente;
/*  72:    */   private JLabel jLabel1;
/*  73:    */   private JLabel jLabel2;
/*  74:    */   private JLabel jLabel3;
/*  75:    */   private JLabel jLabel4;
/*  76:    */   private JLabel jLabel5;
/*  77:    */   private JLabel jLabel6;
/*  78:    */   private JLabel jLabel7;
/*  79:    */   private JPanel jPanel1;
/*  80:    */   private JScrollPane jScrollPane1;
/*  81:    */   private JMenuItem menuEnviarA_reparaciones;
/*  82:    */   private JMenuItem menuEnviarA_ventas;
/*  83:    */   private JMenuItem mnuCreditos;
/*  84:    */   private JTable tblRegistroClientes;
/*  85:    */   private JTextField txtApellidosNombres;
/*  86:    */   private JTextField txtBuscar;
/*  87:    */   private JTextField txtCelular;
/*  88:    */   private JTextField txtDNI;
/*  89:    */   private JTextField txtDireccion;
/*  90:    */   private JTextField txtEmail;
/*  91:    */   
/*  92:    */   public clienteDesk()
/*  93:    */   {
/*  94: 48 */     initComponents();
/*  95: 49 */     cargaRegistrosCliente();
/*  96:    */   }
/*  97:    */   
/*  98:    */   private void initComponents()
/*  99:    */   {
/* 100: 61 */     this.PopupEnviar = new JPopupMenu();
/* 101: 62 */     this.menuEnviarA_ventas = new JMenuItem();
/* 102: 63 */     this.menuEnviarA_reparaciones = new JMenuItem();
/* 103: 64 */     this.mnuCreditos = new JMenuItem();
/* 104: 65 */     this.jPanel1 = new JPanel();
/* 105: 66 */     this.jLabel1 = new JLabel();
/* 106: 67 */     this.txtBuscar = new JTextField();
/* 107: 68 */     this.jScrollPane1 = new JScrollPane();
/* 108: 69 */     this.tblRegistroClientes = new JTable();
/* 109: 70 */     this.jLabel2 = new JLabel();
/* 110: 71 */     this.cboTipoCliente = new JComboBox();
/* 111: 72 */     this.jLabel3 = new JLabel();
/* 112: 73 */     this.txtApellidosNombres = new JTextField();
/* 113: 74 */     this.jLabel4 = new JLabel();
/* 114: 75 */     this.txtDireccion = new JTextField();
/* 115: 76 */     this.jLabel5 = new JLabel();
/* 116: 77 */     this.jLabel6 = new JLabel();
/* 117: 78 */     this.jLabel7 = new JLabel();
/* 118: 79 */     this.txtEmail = new JTextField();
/* 119: 80 */     this.txtCelular = new JTextField();
/* 120: 81 */     this.btnNuevo = new JButton();
/* 121: 82 */     this.btnRegistrar = new JButton();
/* 122: 83 */     this.btnCancelar = new JButton();
/* 123: 84 */     this.btnImprimir = new JButton();
/* 124: 85 */     this.btnModificar = new JButton();
/* 125: 86 */     this.txtDNI = new JTextField();
/* 126:    */     
/* 127: 88 */     this.PopupEnviar.addAncestorListener(new AncestorListener()
/* 128:    */     {
/* 129:    */       public void ancestorMoved(AncestorEvent evt) {}
/* 130:    */       
/* 131:    */       public void ancestorAdded(AncestorEvent evt)
/* 132:    */       {
/* 133: 92 */         clienteDesk.this.PopupEnviarAncestorAdded(evt);
/* 134:    */       }
/* 135:    */       
/* 136:    */       public void ancestorRemoved(AncestorEvent evt) {}
/* 137: 97 */     });
/* 138: 98 */     this.menuEnviarA_ventas.setText("ENVIAR A BOLETA DE VENTAS");
/* 139: 99 */     this.menuEnviarA_ventas.setMaximumSize(new Dimension(500, 50));
/* 140:100 */     this.menuEnviarA_ventas.addActionListener(new ActionListener()
/* 141:    */     {
/* 142:    */       public void actionPerformed(ActionEvent evt)
/* 143:    */       {
/* 144:102 */         clienteDesk.this.menuEnviarA_ventasActionPerformed(evt);
/* 145:    */       }
/* 146:104 */     });
/* 147:105 */     this.PopupEnviar.add(this.menuEnviarA_ventas);
/* 148:    */     
/* 149:107 */     this.menuEnviarA_reparaciones.setText("ENVIAR A BOLETA DE REPARACIONES");
/* 150:108 */     this.menuEnviarA_reparaciones.setMaximumSize(new Dimension(500, 50));
/* 151:109 */     this.menuEnviarA_reparaciones.addActionListener(new ActionListener()
/* 152:    */     {
/* 153:    */       public void actionPerformed(ActionEvent evt)
/* 154:    */       {
/* 155:111 */         clienteDesk.this.menuEnviarA_reparacionesActionPerformed(evt);
/* 156:    */       }
/* 157:113 */     });
/* 158:114 */     this.PopupEnviar.add(this.menuEnviarA_reparaciones);
/* 159:    */     
/* 160:116 */     this.mnuCreditos.setText("ENVIAR A CREDITOS");
/* 161:117 */     this.mnuCreditos.addActionListener(new ActionListener()
/* 162:    */     {
/* 163:    */       public void actionPerformed(ActionEvent evt)
/* 164:    */       {
/* 165:119 */         clienteDesk.this.mnuCreditosActionPerformed(evt);
/* 166:    */       }
/* 167:121 */     });
/* 168:122 */     this.PopupEnviar.add(this.mnuCreditos);
/* 169:    */     
/* 170:124 */     setClosable(true);
/* 171:125 */     setFrameIcon(new ImageIcon(getClass().getResource("/Fondos/ld.png")));
/* 172:    */     
/* 173:127 */     this.jPanel1.setBackground(new Color(102, 102, 102));
/* 174:128 */     this.jPanel1.setLayout(new AbsoluteLayout());
/* 175:    */     
/* 176:130 */     this.jLabel1.setText("B U S C A R    C L I E N T E :");
/* 177:131 */     this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(134, 11, -1, -1));
/* 178:    */     
/* 179:133 */     this.txtBuscar.setFont(new Font("sansserif", 0, 14));
/* 180:134 */     this.txtBuscar.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 51)));
/* 181:135 */     this.txtBuscar.addKeyListener(new KeyAdapter()
/* 182:    */     {
/* 183:    */       public void keyReleased(KeyEvent evt)
/* 184:    */       {
/* 185:137 */         clienteDesk.this.txtBuscarKeyReleased(evt);
/* 186:    */       }
/* 187:139 */     });
/* 188:140 */     this.jPanel1.add(this.txtBuscar, new AbsoluteConstraints(304, 8, 356, -1));
/* 189:    */     
/* 190:142 */     this.tblRegistroClientes.setBackground(new Color(0, 0, 0));
/* 191:143 */     this.tblRegistroClientes.setForeground(new Color(153, 153, 255));
/* 192:144 */     this.tblRegistroClientes.setModel(new DefaultTableModel(new Object[0][], new String[] { "D N I", "D A T O S", "D I R E C C I Ó N", "C E L U L A R", "E - M A I L", "T  I  P  O" })
/* 193:    */     {
/* 194:152 */       boolean[] canEdit = { false, false, false, false, false, false };
/* 195:    */       
/* 196:    */       public boolean isCellEditable(int rowIndex, int columnIndex)
/* 197:    */       {
/* 198:157 */         return this.canEdit[columnIndex];
/* 199:    */       }
/* 200:159 */     });
/* 201:160 */     this.tblRegistroClientes.setComponentPopupMenu(this.PopupEnviar);
/* 202:161 */     this.tblRegistroClientes.setSelectionBackground(new Color(153, 255, 51));
/* 203:162 */     this.tblRegistroClientes.setSelectionForeground(new Color(0, 0, 102));
/* 204:163 */     this.tblRegistroClientes.addMouseListener(new MouseAdapter()
/* 205:    */     {
/* 206:    */       public void mouseClicked(MouseEvent evt)
/* 207:    */       {
/* 208:165 */         clienteDesk.this.tblRegistroClientesMouseClicked(evt);
/* 209:    */       }
/* 210:167 */     });
/* 211:168 */     this.jScrollPane1.setViewportView(this.tblRegistroClientes);
/* 212:169 */     if (this.tblRegistroClientes.getColumnModel().getColumnCount() > 0)
/* 213:    */     {
/* 214:170 */       this.tblRegistroClientes.getColumnModel().getColumn(0).setMinWidth(80);
/* 215:171 */       this.tblRegistroClientes.getColumnModel().getColumn(0).setPreferredWidth(80);
/* 216:172 */       this.tblRegistroClientes.getColumnModel().getColumn(0).setMaxWidth(80);
/* 217:173 */       this.tblRegistroClientes.getColumnModel().getColumn(3).setMinWidth(90);
/* 218:174 */       this.tblRegistroClientes.getColumnModel().getColumn(3).setPreferredWidth(90);
/* 219:175 */       this.tblRegistroClientes.getColumnModel().getColumn(3).setMaxWidth(90);
/* 220:    */     }
/* 221:178 */     this.jPanel1.add(this.jScrollPane1, new AbsoluteConstraints(0, 47, 975, 264));
/* 222:    */     
/* 223:180 */     this.jLabel2.setText("T I P O   C L I E N T E :");
/* 224:181 */     this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(66, 336, -1, -1));
/* 225:    */     
/* 226:183 */     this.cboTipoCliente.setBackground(new Color(102, 102, 102));
/* 227:184 */     this.cboTipoCliente.setFont(new Font("sansserif", 2, 14));
/* 228:185 */     this.jPanel1.add(this.cboTipoCliente, new AbsoluteConstraints(192, 329, 280, -1));
/* 229:    */     
/* 230:187 */     this.jLabel3.setText("A P E L L I D O S/N O M B R E S :");
/* 231:188 */     this.jPanel1.add(this.jLabel3, new AbsoluteConstraints(10, 410, -1, -1));
/* 232:    */     
/* 233:190 */     this.txtApellidosNombres.setEditable(false);
/* 234:191 */     this.txtApellidosNombres.setFont(new Font("sansserif", 0, 14));
/* 235:192 */     this.txtApellidosNombres.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 51)));
/* 236:193 */     this.jPanel1.add(this.txtApellidosNombres, new AbsoluteConstraints(200, 410, 229, -1));
/* 237:    */     
/* 238:195 */     this.jLabel4.setText(" D I R E C C I Ó N :");
/* 239:196 */     this.jPanel1.add(this.jLabel4, new AbsoluteConstraints(90, 440, -1, -1));
/* 240:    */     
/* 241:198 */     this.txtDireccion.setEditable(false);
/* 242:199 */     this.txtDireccion.setFont(new Font("sansserif", 0, 14));
/* 243:200 */     this.txtDireccion.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 51)));
/* 244:201 */     this.jPanel1.add(this.txtDireccion, new AbsoluteConstraints(200, 440, 229, -1));
/* 245:    */     
/* 246:203 */     this.jLabel5.setText("C E L U L A R :");
/* 247:204 */     this.jPanel1.add(this.jLabel5, new AbsoluteConstraints(110, 470, -1, -1));
/* 248:    */     
/* 249:206 */     this.jLabel6.setText("E - M A I L :");
/* 250:207 */     this.jPanel1.add(this.jLabel6, new AbsoluteConstraints(130, 500, -1, -1));
/* 251:    */     
/* 252:209 */     this.jLabel7.setText("D N I :");
/* 253:210 */     this.jPanel1.add(this.jLabel7, new AbsoluteConstraints(153, 376, -1, -1));
/* 254:    */     
/* 255:212 */     this.txtEmail.setEditable(false);
/* 256:213 */     this.txtEmail.setFont(new Font("sansserif", 0, 14));
/* 257:214 */     this.txtEmail.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 51)));
/* 258:215 */     this.jPanel1.add(this.txtEmail, new AbsoluteConstraints(200, 500, 229, -1));
/* 259:    */     
/* 260:217 */     this.txtCelular.setEditable(false);
/* 261:218 */     this.txtCelular.setFont(new Font("sansserif", 0, 14));
/* 262:219 */     this.txtCelular.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 51)));
/* 263:220 */     this.txtCelular.addKeyListener(new KeyAdapter()
/* 264:    */     {
/* 265:    */       public void keyTyped(KeyEvent evt)
/* 266:    */       {
/* 267:222 */         clienteDesk.this.txtCelularKeyTyped(evt);
/* 268:    */       }
/* 269:224 */     });
/* 270:225 */     this.jPanel1.add(this.txtCelular, new AbsoluteConstraints(200, 470, 229, -1));
/* 271:    */     
/* 272:227 */     this.btnNuevo.setBackground(new Color(153, 204, 255));
/* 273:228 */     this.btnNuevo.setFont(new Font("sansserif", 1, 12));
/* 274:229 */     this.btnNuevo.setIcon(new ImageIcon(getClass().getResource("/Iconos/ADD.PNG")));
/* 275:230 */     this.btnNuevo.setText("N U E V O");
/* 276:231 */     this.btnNuevo.addActionListener(new ActionListener()
/* 277:    */     {
/* 278:    */       public void actionPerformed(ActionEvent evt)
/* 279:    */       {
/* 280:233 */         clienteDesk.this.btnNuevoActionPerformed(evt);
/* 281:    */       }
/* 282:235 */     });
/* 283:236 */     this.jPanel1.add(this.btnNuevo, new AbsoluteConstraints(620, 341, 122, 50));
/* 284:    */     
/* 285:238 */     this.btnRegistrar.setBackground(new Color(153, 204, 255));
/* 286:239 */     this.btnRegistrar.setFont(new Font("sansserif", 1, 12));
/* 287:240 */     this.btnRegistrar.setIcon(new ImageIcon(getClass().getResource("/icon/document_text_accept-32.png")));
/* 288:241 */     this.btnRegistrar.setText("G R A B A R");
/* 289:242 */     this.btnRegistrar.setEnabled(false);
/* 290:243 */     this.btnRegistrar.addActionListener(new ActionListener()
/* 291:    */     {
/* 292:    */       public void actionPerformed(ActionEvent evt)
/* 293:    */       {
/* 294:245 */         clienteDesk.this.btnRegistrarActionPerformed(evt);
/* 295:    */       }
/* 296:247 */     });
/* 297:248 */     this.jPanel1.add(this.btnRegistrar, new AbsoluteConstraints(748, 341, -1, 50));
/* 298:    */     
/* 299:250 */     this.btnCancelar.setBackground(new Color(153, 204, 255));
/* 300:251 */     this.btnCancelar.setFont(new Font("sansserif", 1, 12));
/* 301:252 */     this.btnCancelar.setIcon(new ImageIcon(getClass().getResource("/icon/cancel-32.png")));
/* 302:253 */     this.btnCancelar.setText("C A N C E L");
/* 303:254 */     this.btnCancelar.setEnabled(false);
/* 304:255 */     this.btnCancelar.addActionListener(new ActionListener()
/* 305:    */     {
/* 306:    */       public void actionPerformed(ActionEvent evt)
/* 307:    */       {
/* 308:257 */         clienteDesk.this.btnCancelarActionPerformed(evt);
/* 309:    */       }
/* 310:259 */     });
/* 311:260 */     this.jPanel1.add(this.btnCancelar, new AbsoluteConstraints(746, 407, 129, 50));
/* 312:    */     
/* 313:262 */     this.btnImprimir.setBackground(new Color(153, 204, 255));
/* 314:263 */     this.btnImprimir.setFont(new Font("sansserif", 1, 12));
/* 315:264 */     this.btnImprimir.setIcon(new ImageIcon(getClass().getResource("/icon/print-32.png")));
/* 316:265 */     this.btnImprimir.setText("I M P R I M I R        T O D O S");
/* 317:266 */     this.btnImprimir.addActionListener(new ActionListener()
/* 318:    */     {
/* 319:    */       public void actionPerformed(ActionEvent evt)
/* 320:    */       {
/* 321:268 */         clienteDesk.this.btnImprimirActionPerformed(evt);
/* 322:    */       }
/* 323:270 */     });
/* 324:271 */     this.jPanel1.add(this.btnImprimir, new AbsoluteConstraints(620, 478, 255, 50));
/* 325:    */     
/* 326:273 */     this.btnModificar.setBackground(new Color(153, 204, 255));
/* 327:274 */     this.btnModificar.setFont(new Font("sansserif", 1, 12));
/* 328:275 */     this.btnModificar.setIcon(new ImageIcon(getClass().getResource("/icon/edit-32.png")));
/* 329:276 */     this.btnModificar.setText("E D I T A R");
/* 330:277 */     this.btnModificar.addActionListener(new ActionListener()
/* 331:    */     {
/* 332:    */       public void actionPerformed(ActionEvent evt)
/* 333:    */       {
/* 334:279 */         clienteDesk.this.btnModificarActionPerformed(evt);
/* 335:    */       }
/* 336:281 */     });
/* 337:282 */     this.jPanel1.add(this.btnModificar, new AbsoluteConstraints(620, 407, -1, 50));
/* 338:    */     
/* 339:284 */     this.txtDNI.setEditable(false);
/* 340:285 */     this.txtDNI.setFont(new Font("sansserif", 0, 14));
/* 341:286 */     this.txtDNI.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
/* 342:287 */     this.txtDNI.addKeyListener(new KeyAdapter()
/* 343:    */     {
/* 344:    */       public void keyTyped(KeyEvent evt)
/* 345:    */       {
/* 346:289 */         clienteDesk.this.txtDNIKeyTyped(evt);
/* 347:    */       }
/* 348:291 */     });
/* 349:292 */     this.jPanel1.add(this.txtDNI, new AbsoluteConstraints(200, 380, 232, -1));
/* 350:    */     
/* 351:294 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 352:295 */     getContentPane().setLayout(layout);
/* 353:296 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/* 354:    */     
/* 355:    */ 
/* 356:    */ 
/* 357:300 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, 673, 32767));
/* 358:    */     
/* 359:    */ 
/* 360:    */ 
/* 361:    */ 
/* 362:305 */     pack();
/* 363:    */   }
/* 364:    */   
/* 365:    */   private void btnRegistrarActionPerformed(ActionEvent evt)
/* 366:    */   {
/* 367:    */     try
/* 368:    */     {
/* 369:310 */       cliente_TO toCliente = new cliente_TO();
/* 370:311 */       if (this.vf)
/* 371:    */       {
/* 372:312 */         toCliente.setTipo(this.cboTipoCliente.getSelectedItem().toString());
/* 373:313 */         toCliente.setDni(this.txtDNI.getText());
/* 374:314 */         toCliente.setDatos(this.txtApellidosNombres.getText().toUpperCase());
/* 375:315 */         toCliente.setDireccion(this.txtDireccion.getText().toUpperCase());
/* 376:316 */         toCliente.setCelular(this.txtCelular.getText());
/* 377:317 */         toCliente.setEmail(this.txtEmail.getText().toUpperCase());
/* 378:318 */         toCliente.setEstado("1");
/* 379:319 */         this.oCliente.registrarClienteFactura(toCliente);
/* 380:320 */         JOptionPane.showMessageDialog(this.rootPane, this.txtApellidosNombres.getText() + " AHORA ES UN CLIENTE " + this.cboTipoCliente.getSelectedItem().toString());
/* 381:321 */         cargaRegistrosCliente();
/* 382:    */       }
/* 383:    */       else
/* 384:    */       {
/* 385:323 */         toCliente.setTipo(this.cboTipoCliente.getSelectedItem().toString());
/* 386:324 */         toCliente.setDireccion(this.txtDireccion.getText());
/* 387:325 */         toCliente.setCelular(this.txtCelular.getText());
/* 388:326 */         toCliente.setEmail(this.txtEmail.getText());
/* 389:327 */         toCliente.setCodigo(codigoCliente());
/* 390:328 */         this.oCliente.modificarCliente(toCliente);
/* 391:329 */         JOptionPane.showMessageDialog(this.rootPane, "se  modificaron correctamente los registros ...");
/* 392:    */       }
/* 393:331 */       limpiaControles();
/* 394:332 */       habilitaControles(false);
/* 395:    */     }
/* 396:    */     catch (Exception e)
/* 397:    */     {
/* 398:334 */       JOptionPane.showMessageDialog(this.rootPane, "Cliente existente o datos incorrectos REINTENTE !!");
/* 399:335 */       limpiaControles();
/* 400:336 */       System.out.println(e);
/* 401:    */     }
/* 402:    */   }
/* 403:    */   
/* 404:    */   private void btnNuevoActionPerformed(ActionEvent evt)
/* 405:    */   {
/* 406:341 */     limpiaControles();
/* 407:342 */     habilitaControles(true);
/* 408:343 */     this.vf = true;
/* 409:344 */     this.cboTipoCliente.removeAllItems();
/* 410:345 */     this.cboTipoCliente.addItem("GENERAL");
/* 411:346 */     this.cboTipoCliente.addItem("JURIDICO");
/* 412:    */   }
/* 413:    */   
/* 414:    */   private void btnModificarActionPerformed(ActionEvent evt)
/* 415:    */   {
/* 416:350 */     habilitaControles(true);
/* 417:351 */     this.vf = false;
/* 418:352 */     this.cboTipoCliente.removeAllItems();
/* 419:353 */     this.cboTipoCliente.addItem("GENERAL");
/* 420:354 */     this.cboTipoCliente.addItem("JURIDICO");
/* 421:    */   }
/* 422:    */   
/* 423:    */   private void txtBuscarKeyReleased(KeyEvent evt)
/* 424:    */   {
/* 425:    */     try
/* 426:    */     {
/* 427:359 */       this.model = ((DefaultTableModel)this.tblRegistroClientes.getModel());
/* 428:360 */       String DNI = this.txtBuscar.getText();
/* 429:361 */       String Datos = this.txtBuscar.getText();
/* 430:362 */       this.rs = this.oCliente.buscaCliente(DNI, Datos);
/* 431:363 */       limpiarTabla();
/* 432:364 */       while (this.rs.next())
/* 433:    */       {
/* 434:365 */         Object[] reg = { this.rs.getString(1), this.rs.getString(2), this.rs.getString(3), this.rs.getString(4), this.rs.getString(5), this.rs.getString(6) };
/* 435:    */         
/* 436:    */ 
/* 437:    */ 
/* 438:    */ 
/* 439:    */ 
/* 440:    */ 
/* 441:    */ 
/* 442:    */ 
/* 443:374 */         this.model.addRow(reg);
/* 444:    */       }
/* 445:    */     }
/* 446:    */     catch (Exception e) {}
/* 447:    */   }
/* 448:    */   
/* 449:    */   private void tblRegistroClientesMouseClicked(MouseEvent evt)
/* 450:    */   {
/* 451:381 */     muestraRegistros();
/* 452:    */   }
/* 453:    */   
/* 454:    */   private void menuEnviarA_ventasActionPerformed(ActionEvent evt)
/* 455:    */   {
/* 456:385 */     enviar_boletaVenta();
/* 457:    */   }
/* 458:    */   
/* 459:    */   private void menuEnviarA_reparacionesActionPerformed(ActionEvent evt)
/* 460:    */   {
/* 461:389 */     enviar_boletaReparaciones();
/* 462:    */   }
/* 463:    */   
/* 464:    */   private void PopupEnviarAncestorAdded(AncestorEvent evt) {}
/* 465:    */   
/* 466:    */   private void mnuCreditosActionPerformed(ActionEvent evt)
/* 467:    */   {
/* 468:397 */     contratoDesk.txtCliente.setText(this.tblRegistroClientes.getValueAt(this.tblRegistroClientes.getSelectedRow(), 1).toString());
/* 469:398 */     contratoDesk.txtDNI.setText(this.tblRegistroClientes.getValueAt(this.tblRegistroClientes.getSelectedRow(), 0).toString());
/* 470:399 */     dispose();
/* 471:    */   }
/* 472:    */   
/* 473:    */   private void txtDNIKeyTyped(KeyEvent evt)
/* 474:    */   {
/* 475:404 */     char c = evt.getKeyChar();
/* 476:405 */     if ((c < '0') || (c > '9')) {
/* 477:406 */       evt.consume();
/* 478:    */     }
/* 479:    */   }
/* 480:    */   
/* 481:    */   private void txtCelularKeyTyped(KeyEvent evt)
/* 482:    */   {
/* 483:411 */     char c = evt.getKeyChar();
/* 484:412 */     if ((c < '0') || (c > '9')) {
/* 485:413 */       evt.consume();
/* 486:    */     }
/* 487:    */   }
/* 488:    */   
/* 489:    */   private void btnCancelarActionPerformed(ActionEvent evt)
/* 490:    */   {
/* 491:418 */     habilitaControles(true);
/* 492:419 */     muestraRegistros();
/* 493:420 */     this.cboTipoCliente.removeAllItems();
/* 494:421 */     this.cboTipoCliente.addItem("GENERAL");
/* 495:422 */     this.cboTipoCliente.addItem("JURIDICO");
/* 496:    */   }
/* 497:    */   
/* 498:    */   private void btnImprimirActionPerformed(ActionEvent evt)
/* 499:    */   {
/* 500:    */     try
/* 501:    */     {
/* 502:427 */       Connection con = conexion.getInstance().getConnection();
/* 503:428 */       JasperReport report = (JasperReport)JRLoader.loadObject("C:\\LEDATEL\\reportes\\reporte_cliente.jasper");
/* 504:429 */       JasperPrint print = JasperFillManager.fillReport(report, null, con);
/* 505:430 */       JasperViewer.viewReport(print, false);
/* 506:    */     }
/* 507:    */     catch (Exception e)
/* 508:    */     {
/* 509:432 */       System.out.println(e);
/* 510:    */     }
/* 511:    */   }
/* 512:    */   
/* 513:    */   private void limpiaControles()
/* 514:    */   {
/* 515:467 */     JTextField[] txt = { this.txtApellidosNombres, this.txtBuscar, this.txtCelular, this.txtDNI, this.txtDireccion, this.txtEmail };
/* 516:470 */     for (JTextField field : txt) {
/* 517:471 */       field.setText("");
/* 518:    */     }
/* 519:    */   }
/* 520:    */   
/* 521:    */   private void habilitaControles(boolean b)
/* 522:    */   {
/* 523:476 */     JTextField[] txt = { this.txtApellidosNombres, this.txtCelular, this.txtDNI, this.txtDireccion, this.txtEmail };
/* 524:479 */     for (JTextField field : txt) {
/* 525:480 */       field.setEditable(b);
/* 526:    */     }
/* 527:482 */     this.btnRegistrar.setEnabled(b);
/* 528:483 */     this.btnCancelar.setEnabled(b);
/* 529:484 */     this.btnNuevo.setEnabled(!b);
/* 530:485 */     this.btnModificar.setEnabled(!b);
/* 531:    */   }
/* 532:    */   
/* 533:    */   private void cargaRegistrosCliente()
/* 534:    */   {
/* 535:    */     try
/* 536:    */     {
/* 537:490 */       this.model = ((DefaultTableModel)this.tblRegistroClientes.getModel());
/* 538:491 */       this.rs = this.oCliente.garcaCliente();
/* 539:492 */       limpiarTabla();
/* 540:493 */       while (this.rs.next())
/* 541:    */       {
/* 542:494 */         Object[] reg = { this.rs.getString(1), this.rs.getString(2), this.rs.getString(3), this.rs.getString(4), this.rs.getString(5), this.rs.getString(6) };
/* 543:    */         
/* 544:    */ 
/* 545:    */ 
/* 546:    */ 
/* 547:    */ 
/* 548:    */ 
/* 549:    */ 
/* 550:502 */         this.model.addRow(reg);
/* 551:    */       }
/* 552:    */     }
/* 553:    */     catch (Exception e) {}
/* 554:    */   }
/* 555:    */   
/* 556:    */   private void limpiarTabla()
/* 557:    */   {
/* 558:510 */     int filas = this.tblRegistroClientes.getRowCount();
/* 559:511 */     for (int i = 0; filas > i; i++) {
/* 560:512 */       this.model.removeRow(0);
/* 561:    */     }
/* 562:    */   }
/* 563:    */   
/* 564:    */   private void enviar_boletaVenta()
/* 565:    */   {
/* 566:517 */     boletaDesk.txtDNI.setText(this.tblRegistroClientes.getValueAt(this.tblRegistroClientes.getSelectedRow(), 0).toString());
/* 567:518 */     boletaDesk.txtDatos.setText(this.tblRegistroClientes.getValueAt(this.tblRegistroClientes.getSelectedRow(), 1).toString());
/* 568:519 */     boletaDesk.txtDireccion.setText(this.tblRegistroClientes.getValueAt(this.tblRegistroClientes.getSelectedRow(), 2).toString());
/* 569:520 */     dispose();
/* 570:    */   }
/* 571:    */   
/* 572:    */   private void enviar_boletaReparaciones()
/* 573:    */   {
/* 574:525 */     reparacionesDesk.txtDNI.setText(this.tblRegistroClientes.getValueAt(this.tblRegistroClientes.getSelectedRow(), 0).toString());
/* 575:526 */     reparacionesDesk.txtDatos.setText(this.tblRegistroClientes.getValueAt(this.tblRegistroClientes.getSelectedRow(), 1).toString());
/* 576:527 */     reparacionesDesk.txtDireccion.setText(this.tblRegistroClientes.getValueAt(this.tblRegistroClientes.getSelectedRow(), 2).toString());
/* 577:528 */     dispose();
/* 578:    */   }
/* 579:    */   
/* 580:    */   private void muestraRegistros()
/* 581:    */   {
/* 582:532 */     this.txtDNI.setText(this.tblRegistroClientes.getValueAt(this.tblRegistroClientes.getSelectedRow(), 0).toString());
/* 583:533 */     this.txtApellidosNombres.setText(this.tblRegistroClientes.getValueAt(this.tblRegistroClientes.getSelectedRow(), 1).toString());
/* 584:534 */     this.txtDireccion.setText(this.tblRegistroClientes.getValueAt(this.tblRegistroClientes.getSelectedRow(), 2).toString());
/* 585:535 */     this.txtCelular.setText(this.tblRegistroClientes.getValueAt(this.tblRegistroClientes.getSelectedRow(), 3).toString());
/* 586:536 */     this.txtEmail.setText(this.tblRegistroClientes.getValueAt(this.tblRegistroClientes.getSelectedRow(), 4).toString());
/* 587:537 */     this.cboTipoCliente.removeAllItems();
/* 588:538 */     this.cboTipoCliente.addItem(this.tblRegistroClientes.getValueAt(this.tblRegistroClientes.getSelectedRow(), 5).toString());
/* 589:    */   }
/* 590:    */   
/* 591:    */   private String codigoCliente()
/* 592:    */   {
/* 593:542 */     String codigoCliente = null;
/* 594:543 */     String dni = this.tblRegistroClientes.getValueAt(this.tblRegistroClientes.getSelectedRow(), 0).toString();
/* 595:    */     try
/* 596:    */     {
/* 597:545 */       this.rs = this.oCliente.garcaCliente();
/* 598:546 */       while (this.rs.next()) {
/* 599:547 */         if (this.rs.getString(1).equals(dni))
/* 600:    */         {
/* 601:548 */           codigoCliente = this.rs.getString(7);
/* 602:549 */           System.out.println(codigoCliente);
/* 603:    */         }
/* 604:    */       }
/* 605:    */     }
/* 606:    */     catch (Exception e) {}
/* 607:554 */     return codigoCliente;
/* 608:    */   }
/* 609:    */ }


/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar
 * Qualified Name:     Desk.clienteDesk
 * JD-Core Version:    0.7.0.1
 */