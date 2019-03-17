/*   1:    */ package Desk;
/*   2:    */ 
/*   3:    */ import Dao.proveedorDao;
/*   4:    */ import To.proveedor_TO;
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
/*  15:    */ import java.awt.event.MouseMotionAdapter;
/*  16:    */ import java.io.PrintStream;
/*  17:    */ import java.sql.ResultSet;
/*  18:    */ import javax.swing.BorderFactory;
/*  19:    */ import javax.swing.DefaultComboBoxModel;
/*  20:    */ import javax.swing.GroupLayout;
/*  21:    */ import javax.swing.GroupLayout.Alignment;
/*  22:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  23:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  24:    */ import javax.swing.ImageIcon;
/*  25:    */ import javax.swing.JButton;
/*  26:    */ import javax.swing.JComboBox;
/*  27:    */ import javax.swing.JInternalFrame;
/*  28:    */ import javax.swing.JLabel;
/*  29:    */ import javax.swing.JOptionPane;
/*  30:    */ import javax.swing.JPanel;
/*  31:    */ import javax.swing.JScrollPane;
/*  32:    */ import javax.swing.JTable;
/*  33:    */ import javax.swing.JTextArea;
/*  34:    */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*  35:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  36:    */ import javax.swing.table.DefaultTableModel;
/*  37:    */ import javax.swing.table.TableColumn;
/*  38:    */ import javax.swing.table.TableColumnModel;
/*  39:    */ 
/*  40:    */ public class proveedorDesk
/*  41:    */   extends JInternalFrame
/*  42:    */ {
/*  43: 22 */   private static proveedorDesk fromProveedor = null;
/*  44:    */   DefaultTableModel model;
/*  45:    */   ResultSet rs;
/*  46:    */   boolean log;
/*  47:    */   
/*  48:    */   public static proveedorDesk getForm()
/*  49:    */   {
/*  50: 25 */     if (fromProveedor == null) {
/*  51: 26 */       fromProveedor = new proveedorDesk();
/*  52:    */     }
/*  53: 28 */     return fromProveedor;
/*  54:    */   }
/*  55:    */   
/*  56: 33 */   proveedorDao Oproveedor = new proveedorDao();
/*  57:    */   private JButton bntVer;
/*  58:    */   private JButton btnCancelar;
/*  59:    */   private JButton btnEditar;
/*  60:    */   private JButton btnEliminar;
/*  61:    */   private JButton btnLimpiar;
/*  62:    */   private JButton btnNuevo;
/*  63:    */   private JButton btnRegistrar;
/*  64:    */   private JComboBox cboTipo;
/*  65:    */   private JLabel jLabel1;
/*  66:    */   private JLabel jLabel2;
/*  67:    */   private JLabel jLabel3;
/*  68:    */   private JLabel jLabel4;
/*  69:    */   private JLabel jLabel5;
/*  70:    */   private JLabel jLabel7;
/*  71:    */   private JLabel jLabel8;
/*  72:    */   private JLabel jLabel9;
/*  73:    */   private JPanel jPanel1;
/*  74:    */   private JPanel jPanel2;
/*  75:    */   private JScrollPane jScrollPane1;
/*  76:    */   private JScrollPane jScrollPane2;
/*  77:    */   private JLabel lblCodigo;
/*  78:    */   private JTable tblRegistros;
/*  79:    */   private JTextField txtBuscar;
/*  80:    */   private JTextField txtCelular;
/*  81:    */   private JTextField txtDireccion;
/*  82:    */   private JTextField txtEmail;
/*  83:    */   private JTextField txtRepresentante;
/*  84:    */   private JTextArea txtServicios;
/*  85:    */   private JTextField txtSociedad;
/*  86:    */   
/*  87:    */   public proveedorDesk()
/*  88:    */   {
/*  89: 36 */     initComponents();
/*  90:    */   }
/*  91:    */   
/*  92:    */   private void initComponents()
/*  93:    */   {
/*  94: 49 */     this.jPanel1 = new JPanel();
/*  95: 50 */     this.jPanel2 = new JPanel();
/*  96: 51 */     this.btnNuevo = new JButton();
/*  97: 52 */     this.btnRegistrar = new JButton();
/*  98: 53 */     this.btnEditar = new JButton();
/*  99: 54 */     this.btnCancelar = new JButton();
/* 100: 55 */     this.btnEliminar = new JButton();
/* 101: 56 */     this.jScrollPane1 = new JScrollPane();
/* 102: 57 */     this.tblRegistros = new JTable();
/* 103: 58 */     this.jLabel1 = new JLabel();
/* 104: 59 */     this.txtSociedad = new JTextField();
/* 105: 60 */     this.jLabel2 = new JLabel();
/* 106: 61 */     this.txtRepresentante = new JTextField();
/* 107: 62 */     this.jLabel4 = new JLabel();
/* 108: 63 */     this.txtCelular = new JTextField();
/* 109: 64 */     this.jLabel3 = new JLabel();
/* 110: 65 */     this.txtDireccion = new JTextField();
/* 111: 66 */     this.cboTipo = new JComboBox();
/* 112: 67 */     this.jLabel8 = new JLabel();
/* 113: 68 */     this.txtEmail = new JTextField();
/* 114: 69 */     this.jLabel7 = new JLabel();
/* 115: 70 */     this.jScrollPane2 = new JScrollPane();
/* 116: 71 */     this.txtServicios = new JTextArea();
/* 117: 72 */     this.jLabel9 = new JLabel();
/* 118: 73 */     this.jLabel5 = new JLabel();
/* 119: 74 */     this.txtBuscar = new JTextField();
/* 120: 75 */     this.lblCodigo = new JLabel();
/* 121: 76 */     this.bntVer = new JButton();
/* 122: 77 */     this.btnLimpiar = new JButton();
/* 123:    */     
/* 124: 79 */     setClosable(true);
/* 125: 80 */     setMinimumSize(new Dimension(1350, 620));
/* 126: 81 */     setPreferredSize(new Dimension(1350, 620));
/* 127:    */     
/* 128: 83 */     this.jPanel1.setBackground(new Color(102, 102, 102));
/* 129:    */     
/* 130: 85 */     this.jPanel2.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 51), 2));
/* 131: 86 */     this.jPanel2.setForeground(new Color(204, 255, 0));
/* 132: 87 */     this.jPanel2.setOpaque(false);
/* 133:    */     
/* 134: 89 */     this.btnNuevo.setBackground(new Color(153, 153, 255));
/* 135: 90 */     this.btnNuevo.setIcon(new ImageIcon(getClass().getResource("/Iconos/ADD.PNG")));
/* 136: 91 */     this.btnNuevo.setText("Nuevo");
/* 137: 92 */     this.btnNuevo.addMouseMotionListener(new MouseMotionAdapter()
/* 138:    */     {
/* 139:    */       public void mouseMoved(MouseEvent evt)
/* 140:    */       {
/* 141: 94 */         proveedorDesk.this.btnNuevoMouseMoved(evt);
/* 142:    */       }
/* 143: 96 */     });
/* 144: 97 */     this.btnNuevo.addActionListener(new ActionListener()
/* 145:    */     {
/* 146:    */       public void actionPerformed(ActionEvent evt)
/* 147:    */       {
/* 148: 99 */         proveedorDesk.this.btnNuevoActionPerformed(evt);
/* 149:    */       }
/* 150:102 */     });
/* 151:103 */     this.btnRegistrar.setBackground(new Color(153, 153, 255));
/* 152:104 */     this.btnRegistrar.setIcon(new ImageIcon(getClass().getResource("/icon/Manager.png")));
/* 153:105 */     this.btnRegistrar.setText("Registrar");
/* 154:106 */     this.btnRegistrar.setEnabled(false);
/* 155:107 */     this.btnRegistrar.addMouseMotionListener(new MouseMotionAdapter()
/* 156:    */     {
/* 157:    */       public void mouseMoved(MouseEvent evt)
/* 158:    */       {
/* 159:109 */         proveedorDesk.this.btnRegistrarMouseMoved(evt);
/* 160:    */       }
/* 161:111 */     });
/* 162:112 */     this.btnRegistrar.addActionListener(new ActionListener()
/* 163:    */     {
/* 164:    */       public void actionPerformed(ActionEvent evt)
/* 165:    */       {
/* 166:114 */         proveedorDesk.this.btnRegistrarActionPerformed(evt);
/* 167:    */       }
/* 168:117 */     });
/* 169:118 */     this.btnEditar.setBackground(new Color(153, 153, 255));
/* 170:119 */     this.btnEditar.setIcon(new ImageIcon(getClass().getResource("/icon/basic3-068_compose_new_document_write_edit-32.png")));
/* 171:120 */     this.btnEditar.setText("Editar");
/* 172:121 */     this.btnEditar.addMouseMotionListener(new MouseMotionAdapter()
/* 173:    */     {
/* 174:    */       public void mouseMoved(MouseEvent evt)
/* 175:    */       {
/* 176:123 */         proveedorDesk.this.btnEditarMouseMoved(evt);
/* 177:    */       }
/* 178:125 */     });
/* 179:126 */     this.btnEditar.addActionListener(new ActionListener()
/* 180:    */     {
/* 181:    */       public void actionPerformed(ActionEvent evt)
/* 182:    */       {
/* 183:128 */         proveedorDesk.this.btnEditarActionPerformed(evt);
/* 184:    */       }
/* 185:131 */     });
/* 186:132 */     this.btnCancelar.setBackground(new Color(153, 153, 255));
/* 187:133 */     this.btnCancelar.setIcon(new ImageIcon(getClass().getResource("/Iconos/CANCELAR.PNG")));
/* 188:134 */     this.btnCancelar.setText("Cancelar");
/* 189:135 */     this.btnCancelar.setEnabled(false);
/* 190:136 */     this.btnCancelar.addMouseMotionListener(new MouseMotionAdapter()
/* 191:    */     {
/* 192:    */       public void mouseMoved(MouseEvent evt)
/* 193:    */       {
/* 194:138 */         proveedorDesk.this.btnCancelarMouseMoved(evt);
/* 195:    */       }
/* 196:140 */     });
/* 197:141 */     this.btnCancelar.addActionListener(new ActionListener()
/* 198:    */     {
/* 199:    */       public void actionPerformed(ActionEvent evt)
/* 200:    */       {
/* 201:143 */         proveedorDesk.this.btnCancelarActionPerformed(evt);
/* 202:    */       }
/* 203:146 */     });
/* 204:147 */     this.btnEliminar.setBackground(new Color(153, 153, 255));
/* 205:148 */     this.btnEliminar.setIcon(new ImageIcon(getClass().getResource("/Iconos/ELIMINAR.PNG")));
/* 206:149 */     this.btnEliminar.setText("Eliminar");
/* 207:150 */     this.btnEliminar.addMouseMotionListener(new MouseMotionAdapter()
/* 208:    */     {
/* 209:    */       public void mouseMoved(MouseEvent evt)
/* 210:    */       {
/* 211:152 */         proveedorDesk.this.btnEliminarMouseMoved(evt);
/* 212:    */       }
/* 213:154 */     });
/* 214:155 */     this.btnEliminar.addActionListener(new ActionListener()
/* 215:    */     {
/* 216:    */       public void actionPerformed(ActionEvent evt)
/* 217:    */       {
/* 218:157 */         proveedorDesk.this.btnEliminarActionPerformed(evt);
/* 219:    */       }
/* 220:160 */     });
/* 221:161 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 222:162 */     this.jPanel2.setLayout(jPanel2Layout);
/* 223:163 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.btnNuevo, -2, 151, -2).addGap(21, 21, 21).addComponent(this.btnRegistrar, -2, 161, -2).addGap(33, 33, 33).addComponent(this.btnEditar, -2, 154, -2).addGap(18, 18, 18).addComponent(this.btnCancelar, -2, 151, -2).addGap(26, 26, 26).addComponent(this.btnEliminar, -2, 164, -2).addContainerGap(63, 32767)));
/* 224:    */     
/* 225:    */ 
/* 226:    */ 
/* 227:    */ 
/* 228:    */ 
/* 229:    */ 
/* 230:    */ 
/* 231:    */ 
/* 232:    */ 
/* 233:    */ 
/* 234:    */ 
/* 235:    */ 
/* 236:    */ 
/* 237:    */ 
/* 238:178 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnNuevo, -2, 53, -2).addComponent(this.btnRegistrar, -2, 53, -2).addComponent(this.btnEditar, -2, 53, -2).addComponent(this.btnCancelar, -2, 50, -2).addComponent(this.btnEliminar, -2, 52, -2)).addGap(113, 113, 113)));
/* 239:    */     
/* 240:    */ 
/* 241:    */ 
/* 242:    */ 
/* 243:    */ 
/* 244:    */ 
/* 245:    */ 
/* 246:    */ 
/* 247:    */ 
/* 248:    */ 
/* 249:    */ 
/* 250:    */ 
/* 251:191 */     this.tblRegistros.setModel(new DefaultTableModel(new Object[0][], new String[] { "Cod.", "S o c i e d a d", "R e p r e s e n t a n t e", "C e l u l a r", "D i r e c c i o n", "E - m a i l ", "T i p o P r o v e e d o r", "S e r v i c i o s" })
/* 252:    */     {
/* 253:199 */       boolean[] canEdit = { false, false, false, false, false, false, false, true };
/* 254:    */       
/* 255:    */       public boolean isCellEditable(int rowIndex, int columnIndex)
/* 256:    */       {
/* 257:204 */         return this.canEdit[columnIndex];
/* 258:    */       }
/* 259:206 */     });
/* 260:207 */     this.tblRegistros.addMouseListener(new MouseAdapter()
/* 261:    */     {
/* 262:    */       public void mouseClicked(MouseEvent evt)
/* 263:    */       {
/* 264:209 */         proveedorDesk.this.tblRegistrosMouseClicked(evt);
/* 265:    */       }
/* 266:211 */     });
/* 267:212 */     this.jScrollPane1.setViewportView(this.tblRegistros);
/* 268:213 */     if (this.tblRegistros.getColumnModel().getColumnCount() > 0)
/* 269:    */     {
/* 270:214 */       this.tblRegistros.getColumnModel().getColumn(0).setMinWidth(80);
/* 271:215 */       this.tblRegistros.getColumnModel().getColumn(0).setPreferredWidth(80);
/* 272:216 */       this.tblRegistros.getColumnModel().getColumn(0).setMaxWidth(80);
/* 273:217 */       this.tblRegistros.getColumnModel().getColumn(3).setMinWidth(80);
/* 274:218 */       this.tblRegistros.getColumnModel().getColumn(3).setPreferredWidth(80);
/* 275:219 */       this.tblRegistros.getColumnModel().getColumn(3).setMaxWidth(80);
/* 276:    */     }
/* 277:222 */     this.jLabel1.setFont(new Font("Bodoni MT Condensed", 1, 18));
/* 278:223 */     this.jLabel1.setForeground(new Color(255, 255, 255));
/* 279:224 */     this.jLabel1.setText("S o c i e d a d :");
/* 280:    */     
/* 281:226 */     this.txtSociedad.setEditable(false);
/* 282:227 */     this.txtSociedad.setHorizontalAlignment(0);
/* 283:228 */     this.txtSociedad.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 284:    */     
/* 285:230 */     this.jLabel2.setFont(new Font("Bodoni MT Condensed", 1, 18));
/* 286:231 */     this.jLabel2.setForeground(new Color(255, 255, 255));
/* 287:232 */     this.jLabel2.setText("R e p r e s e n t a n t e:");
/* 288:    */     
/* 289:234 */     this.txtRepresentante.setEditable(false);
/* 290:235 */     this.txtRepresentante.setHorizontalAlignment(0);
/* 291:236 */     this.txtRepresentante.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 292:    */     
/* 293:238 */     this.jLabel4.setFont(new Font("Bodoni MT Condensed", 1, 18));
/* 294:239 */     this.jLabel4.setForeground(new Color(255, 255, 255));
/* 295:240 */     this.jLabel4.setText("C e l u l a r :");
/* 296:    */     
/* 297:242 */     this.txtCelular.setEditable(false);
/* 298:243 */     this.txtCelular.setHorizontalAlignment(0);
/* 299:244 */     this.txtCelular.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 300:    */     
/* 301:246 */     this.jLabel3.setFont(new Font("Bodoni MT Condensed", 1, 18));
/* 302:247 */     this.jLabel3.setForeground(new Color(255, 255, 255));
/* 303:248 */     this.jLabel3.setText("D i r e c c i ó n :");
/* 304:    */     
/* 305:250 */     this.txtDireccion.setEditable(false);
/* 306:251 */     this.txtDireccion.setHorizontalAlignment(0);
/* 307:252 */     this.txtDireccion.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 308:    */     
/* 309:254 */     this.cboTipo.setBackground(new Color(102, 102, 102));
/* 310:255 */     this.cboTipo.setModel(new DefaultComboBoxModel(new String[] { "PROVEEDOR ESTABLE", "PROVEEDOR PUBLICO", "PROVEEDOR ASOCIADO" }));
/* 311:    */     
/* 312:257 */     this.jLabel8.setFont(new Font("Bodoni MT Condensed", 1, 18));
/* 313:258 */     this.jLabel8.setForeground(new Color(255, 255, 255));
/* 314:259 */     this.jLabel8.setText("E - m a i l :");
/* 315:    */     
/* 316:261 */     this.txtEmail.setEditable(false);
/* 317:262 */     this.txtEmail.setHorizontalAlignment(0);
/* 318:263 */     this.txtEmail.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 319:    */     
/* 320:265 */     this.jLabel7.setFont(new Font("Bodoni MT Condensed", 1, 18));
/* 321:266 */     this.jLabel7.setForeground(new Color(255, 255, 255));
/* 322:267 */     this.jLabel7.setText("S e r v i c i o s :");
/* 323:    */     
/* 324:269 */     this.txtServicios.setColumns(20);
/* 325:270 */     this.txtServicios.setRows(5);
/* 326:271 */     this.jScrollPane2.setViewportView(this.txtServicios);
/* 327:    */     
/* 328:273 */     this.jLabel9.setFont(new Font("Bodoni MT Condensed", 1, 18));
/* 329:274 */     this.jLabel9.setForeground(new Color(255, 255, 255));
/* 330:275 */     this.jLabel9.setText("Tipo Proveedor:");
/* 331:    */     
/* 332:277 */     this.jLabel5.setFont(new Font("Bodoni MT Condensed", 1, 18));
/* 333:278 */     this.jLabel5.setForeground(new Color(255, 255, 255));
/* 334:279 */     this.jLabel5.setText("S o c i e d a d/ S e r v i c i o s :");
/* 335:    */     
/* 336:281 */     this.txtBuscar.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
/* 337:282 */     this.txtBuscar.addKeyListener(new KeyAdapter()
/* 338:    */     {
/* 339:    */       public void keyReleased(KeyEvent evt)
/* 340:    */       {
/* 341:284 */         proveedorDesk.this.txtBuscarKeyReleased(evt);
/* 342:    */       }
/* 343:287 */     });
/* 344:288 */     this.lblCodigo.setFont(new Font("sansserif", 1, 24));
/* 345:289 */     this.lblCodigo.setForeground(new Color(255, 255, 255));
/* 346:290 */     this.lblCodigo.setHorizontalAlignment(0);
/* 347:291 */     this.lblCodigo.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
/* 348:    */     
/* 349:293 */     this.bntVer.setText("V ER   T O D O S");
/* 350:294 */     this.bntVer.addActionListener(new ActionListener()
/* 351:    */     {
/* 352:    */       public void actionPerformed(ActionEvent evt)
/* 353:    */       {
/* 354:296 */         proveedorDesk.this.bntVerActionPerformed(evt);
/* 355:    */       }
/* 356:299 */     });
/* 357:300 */     this.btnLimpiar.setText("L I M P I A R");
/* 358:    */     
/* 359:302 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 360:303 */     this.jPanel1.setLayout(jPanel1Layout);
/* 361:304 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(271, 271, 271).addComponent(this.jLabel5).addGap(43, 43, 43).addComponent(this.txtBuscar, -2, 471, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btnLimpiar, -2, 122, -2).addGap(18, 18, 18).addComponent(this.bntVer).addGap(65, 65, 65)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel4).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(50, 50, 50).addComponent(this.jLabel1)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2)))).addGap(35, 35, 35).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtSociedad, -1, 211, 32767).addComponent(this.txtRepresentante).addComponent(this.txtCelular)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(217, 217, 217).addComponent(this.jLabel8)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(185, 185, 185).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel3, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel9, GroupLayout.Alignment.TRAILING)))).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtDireccion).addComponent(this.txtEmail).addComponent(this.cboTipo, 0, 211, 32767)).addGap(52, 52, 52).addComponent(this.jLabel7)).addGroup(jPanel1Layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.jPanel2, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblCodigo, -1, -1, 32767).addComponent(this.jScrollPane2))).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(31, 32767).addComponent(this.jScrollPane1, -2, 1309, -2))).addGap(24, 24, 24)));
/* 362:    */     
/* 363:    */ 
/* 364:    */ 
/* 365:    */ 
/* 366:    */ 
/* 367:    */ 
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
/* 412:    */ 
/* 413:    */ 
/* 414:    */ 
/* 415:    */ 
/* 416:    */ 
/* 417:    */ 
/* 418:    */ 
/* 419:    */ 
/* 420:363 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(40, 40, 40).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.txtBuscar, -2, 22, -2))).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.bntVer, -2, 57, -2).addComponent(this.btnLimpiar, -2, 57, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -2, 305, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -2, -1, -2).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.txtSociedad, -2, 25, -2).addComponent(this.jLabel7).addComponent(this.jLabel3).addComponent(this.txtDireccion, -2, 23, -2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.txtRepresentante, -2, 25, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.txtCelular, -2, 23, -2))).addGroup(jPanel1Layout.createSequentialGroup().addGap(1, 1, 1).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel8).addComponent(this.txtEmail, -2, 21, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboTipo, -2, -1, -2).addComponent(this.jLabel9)))))).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.lblCodigo, -2, 52, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.jPanel2, -2, 71, -2))).addContainerGap(7, 32767)));
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
/* 474:417 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 475:418 */     getContentPane().setLayout(layout);
/* 476:419 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/* 477:    */     
/* 478:    */ 
/* 479:    */ 
/* 480:423 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/* 481:    */     
/* 482:    */ 
/* 483:    */ 
/* 484:    */ 
/* 485:428 */     pack();
/* 486:    */   }
/* 487:    */   
/* 488:    */   private void tblRegistrosMouseClicked(MouseEvent evt)
/* 489:    */   {
/* 490:432 */     muestraRegistros();
/* 491:433 */     if (evt.getClickCount() == 2)
/* 492:    */     {
/* 493:434 */       comprasDesk.txtCod_proveedor.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 1).toString());
/* 494:435 */       dispose();
/* 495:    */     }
/* 496:    */   }
/* 497:    */   
/* 498:    */   private void btnNuevoMouseMoved(MouseEvent evt)
/* 499:    */   {
/* 500:440 */     todosLosColores();
/* 501:441 */     this.btnNuevo.setBackground(new Color(204, 255, 0));
/* 502:    */   }
/* 503:    */   
/* 504:    */   private void btnNuevoActionPerformed(ActionEvent evt)
/* 505:    */   {
/* 506:445 */     habilitaControles(true);
/* 507:446 */     limpiaControles();
/* 508:447 */     this.log = true;
/* 509:    */   }
/* 510:    */   
/* 511:    */   private void btnRegistrarMouseMoved(MouseEvent evt)
/* 512:    */   {
/* 513:451 */     todosLosColores();
/* 514:452 */     this.btnRegistrar.setBackground(new Color(204, 255, 0));
/* 515:    */   }
/* 516:    */   
/* 517:    */   private void btnRegistrarActionPerformed(ActionEvent evt)
/* 518:    */   {
/* 519:    */     try
/* 520:    */     {
/* 521:457 */       String mensaje = "";
/* 522:458 */       proveedor_TO to = new proveedor_TO();
/* 523:459 */       to.setEmpresa(this.txtSociedad.getText().toUpperCase());
/* 524:460 */       to.setContacto(this.txtRepresentante.getText().toUpperCase());
/* 525:461 */       to.setTelefono(this.txtCelular.getText().toUpperCase());
/* 526:462 */       to.setDireccion(this.txtDireccion.getText().toUpperCase());
/* 527:463 */       to.setEmail(this.txtEmail.getText().toUpperCase());
/* 528:464 */       to.setTipo(this.cboTipo.getSelectedItem().toString());
/* 529:465 */       to.setServicios(this.txtServicios.getText().toUpperCase());
/* 530:466 */       if (this.log)
/* 531:    */       {
/* 532:467 */         this.Oproveedor.registrarProveedor(to);
/* 533:468 */         limpiaControles();
/* 534:469 */         habilitaControles(false);
/* 535:470 */         cargaRegistros();
/* 536:471 */         mensaje = "se registro correctamente al proveedor..";
/* 537:    */       }
/* 538:    */       else
/* 539:    */       {
/* 540:473 */         to.setCodigo(this.lblCodigo.getText());
/* 541:474 */         this.Oproveedor.EditarProveedor(to);
/* 542:475 */         limpiaControles();
/* 543:476 */         habilitaControles(true);
/* 544:477 */         cargaRegistros();
/* 545:478 */         mensaje = "se Modifico correctamente al proveedor..";
/* 546:    */       }
/* 547:480 */       JOptionPane.showMessageDialog(this.rootPane, mensaje);
/* 548:    */     }
/* 549:    */     catch (Exception e)
/* 550:    */     {
/* 551:483 */       System.out.println(e + " en  registro de proveedor");
/* 552:    */     }
/* 553:    */   }
/* 554:    */   
/* 555:    */   private void btnEditarMouseMoved(MouseEvent evt)
/* 556:    */   {
/* 557:488 */     todosLosColores();
/* 558:489 */     this.btnEditar.setBackground(new Color(204, 255, 0));
/* 559:    */   }
/* 560:    */   
/* 561:    */   private void btnEditarActionPerformed(ActionEvent evt)
/* 562:    */   {
/* 563:493 */     habilitaControles(true);
/* 564:494 */     this.log = false;
/* 565:    */   }
/* 566:    */   
/* 567:    */   private void btnCancelarMouseMoved(MouseEvent evt)
/* 568:    */   {
/* 569:498 */     todosLosColores();
/* 570:499 */     this.btnCancelar.setBackground(new Color(204, 255, 0));
/* 571:    */   }
/* 572:    */   
/* 573:    */   private void btnCancelarActionPerformed(ActionEvent evt)
/* 574:    */   {
/* 575:503 */     habilitaControles(false);
/* 576:504 */     muestraRegistros();
/* 577:    */   }
/* 578:    */   
/* 579:    */   private void btnEliminarMouseMoved(MouseEvent evt)
/* 580:    */   {
/* 581:508 */     todosLosColores();
/* 582:509 */     this.btnEliminar.setBackground(new Color(204, 255, 0));
/* 583:    */   }
/* 584:    */   
/* 585:    */   private void btnEliminarActionPerformed(ActionEvent evt)
/* 586:    */   {
/* 587:    */     try
/* 588:    */     {
/* 589:514 */       int opc = JOptionPane.showConfirmDialog(this.rootPane, "Desea Eliminar al Proveedor", "Cuadro de Advertencia", 0, 3);
/* 590:515 */       if (opc == 0)
/* 591:    */       {
/* 592:516 */         proveedor_TO to = new proveedor_TO();
/* 593:517 */         to.setCodigo(this.lblCodigo.getText());
/* 594:518 */         this.Oproveedor.EliminarProveedor(to);
/* 595:519 */         JOptionPane.showMessageDialog(this.rootPane, "Se elimino correctamente ...");
/* 596:    */       }
/* 597:521 */       limpiaControles();
/* 598:522 */       habilitaControles(true);
/* 599:523 */       cargaRegistros();
/* 600:    */     }
/* 601:    */     catch (Exception e)
/* 602:    */     {
/* 603:525 */       System.out.println(e + "en elminar");
/* 604:    */     }
/* 605:    */   }
/* 606:    */   
/* 607:    */   private void bntVerActionPerformed(ActionEvent evt)
/* 608:    */   {
/* 609:530 */     cargaRegistros();
/* 610:    */   }
/* 611:    */   
/* 612:    */   private void txtBuscarKeyReleased(KeyEvent evt)
/* 613:    */   {
/* 614:534 */     buscar();
/* 615:    */   }
/* 616:    */   
/* 617:    */   private void todosLosColores()
/* 618:    */   {
/* 619:570 */     JButton[] btn = { this.btnCancelar, this.btnEditar, this.btnNuevo, this.btnRegistrar, this.btnEliminar };
/* 620:573 */     for (JButton button : btn) {
/* 621:574 */       button.setBackground(new Color(214, 217, 223));
/* 622:    */     }
/* 623:    */   }
/* 624:    */   
/* 625:    */   private void habilitaControles(boolean b)
/* 626:    */   {
/* 627:580 */     JTextField[] txt = { this.txtDireccion, this.txtEmail, this.txtSociedad, this.txtCelular, this.txtRepresentante };
/* 628:    */     
/* 629:    */ 
/* 630:    */ 
/* 631:    */ 
/* 632:585 */     this.txtServicios.setEditable(b);
/* 633:586 */     for (JTextField field : txt) {
/* 634:587 */       field.setEditable(b);
/* 635:    */     }
/* 636:589 */     this.txtSociedad.grabFocus();
/* 637:590 */     this.btnRegistrar.setEnabled(b);
/* 638:591 */     this.btnCancelar.setEnabled(b);
/* 639:592 */     this.btnNuevo.setEnabled(!b);
/* 640:593 */     this.btnEditar.setEnabled(!b);
/* 641:594 */     this.btnEliminar.setEnabled(!b);
/* 642:595 */     this.cboTipo.removeAllItems();
/* 643:596 */     this.cboTipo.addItem("PROVEEDOR ESTABLE");
/* 644:597 */     this.cboTipo.addItem("PROVEEDOR PUBLICO");
/* 645:598 */     this.cboTipo.addItem("PROVEEDOR ASOCIADO");
/* 646:    */   }
/* 647:    */   
/* 648:    */   private void limpiaControles()
/* 649:    */   {
/* 650:602 */     JTextField[] txt = { this.txtDireccion, this.txtEmail, this.txtSociedad, this.txtCelular, this.txtRepresentante };
/* 651:    */     
/* 652:    */ 
/* 653:605 */     this.txtServicios.setText("");
/* 654:606 */     for (JTextField field : txt) {
/* 655:607 */       field.setText("");
/* 656:    */     }
/* 657:    */   }
/* 658:    */   
/* 659:    */   private void cargaRegistros()
/* 660:    */   {
/* 661:    */     try
/* 662:    */     {
/* 663:614 */       this.model = ((DefaultTableModel)this.tblRegistros.getModel());
/* 664:615 */       int filas = this.tblRegistros.getRowCount();
/* 665:616 */       for (int i = 0; filas > i; i++) {
/* 666:617 */         this.model.removeRow(0);
/* 667:    */       }
/* 668:619 */       this.rs = this.Oproveedor.cargarProveedor();
/* 669:620 */       while (this.rs.next())
/* 670:    */       {
/* 671:621 */         Object[] registros = { this.rs.getString(1), this.rs.getString(2), this.rs.getString(3), this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), this.rs.getString(7), this.rs.getString(8) };
/* 672:    */         
/* 673:    */ 
/* 674:    */ 
/* 675:    */ 
/* 676:    */ 
/* 677:    */ 
/* 678:    */ 
/* 679:    */ 
/* 680:    */ 
/* 681:631 */         this.model.addRow(registros);
/* 682:    */       }
/* 683:    */     }
/* 684:    */     catch (Exception e) {}
/* 685:    */   }
/* 686:    */   
/* 687:    */   private void muestraRegistros()
/* 688:    */   {
/* 689:639 */     this.lblCodigo.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 0).toString());
/* 690:640 */     this.txtSociedad.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 1).toString());
/* 691:641 */     this.txtRepresentante.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 2).toString());
/* 692:642 */     this.txtCelular.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 3).toString());
/* 693:643 */     this.txtDireccion.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 4).toString());
/* 694:644 */     this.txtEmail.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 5).toString());
/* 695:645 */     this.cboTipo.removeAllItems();
/* 696:646 */     this.cboTipo.addItem(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 6));
/* 697:647 */     this.txtServicios.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 7).toString());
/* 698:    */   }
/* 699:    */   
/* 700:    */   private void buscar()
/* 701:    */   {
/* 702:    */     try
/* 703:    */     {
/* 704:653 */       String sociedad = this.txtBuscar.getText();
/* 705:654 */       String servicios = this.txtBuscar.getText();
/* 706:655 */       this.model = ((DefaultTableModel)this.tblRegistros.getModel());
/* 707:656 */       int filas = this.tblRegistros.getRowCount();
/* 708:657 */       for (int i = 0; filas > i; i++) {
/* 709:658 */         this.model.removeRow(0);
/* 710:    */       }
/* 711:660 */       this.rs = this.Oproveedor.buscaProveedor(sociedad, servicios);
/* 712:661 */       while (this.rs.next())
/* 713:    */       {
/* 714:662 */         Object[] registros = { this.rs.getString(1), this.rs.getString(2), this.rs.getString(3), this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), this.rs.getString(7), this.rs.getString(8) };
/* 715:    */         
/* 716:    */ 
/* 717:    */ 
/* 718:    */ 
/* 719:    */ 
/* 720:    */ 
/* 721:    */ 
/* 722:    */ 
/* 723:    */ 
/* 724:672 */         this.model.addRow(registros);
/* 725:    */       }
/* 726:    */     }
/* 727:    */     catch (Exception e)
/* 728:    */     {
/* 729:675 */       System.out.println(e);
/* 730:    */     }
/* 731:    */   }
/* 732:    */ }



/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar

 * Qualified Name:     Desk.proveedorDesk

 * JD-Core Version:    0.7.0.1

 */