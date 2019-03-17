/*   1:    */ package Gui;
/*   2:    */ 
/*   3:    */ import Dao.accesoDAO;
/*   4:    */ import java.awt.Color;

/*   6:    */ import java.awt.Cursor;
/*   7:    */ import java.awt.Font;
/*   8:    */ import java.awt.event.ActionEvent;
/*   9:    */ import java.awt.event.ActionListener;
/*  11:    */ import java.sql.ResultSet;
/*  12:    */ import javax.swing.BorderFactory;
/*  13:    */ import javax.swing.DefaultComboBoxModel;
/*  14:    */ import javax.swing.ImageIcon;
/*  15:    */ import javax.swing.JButton;
/*  16:    */ import javax.swing.JComboBox;
/*  17:    */ import javax.swing.JFrame;
/*  18:    */ import javax.swing.JLabel;
/*  19:    */ import javax.swing.JMenu;
/*  20:    */ import javax.swing.JMenuBar;
/*  21:    */ import javax.swing.JMenuItem;
/*  22:    */ import javax.swing.JOptionPane;
/*  23:    */ import javax.swing.JPanel;
/*  24:    */ import javax.swing.JPasswordField;

/*  27:    */ import javax.swing.JTextField;
/*  28:    */ import javax.swing.border.LineBorder;
/*  29:    */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*  30:    */ import org.netbeans.lib.awtextra.AbsoluteLayout;
/*  31:    */ 
/*  32:    */ public class LogeoGUI
/*  33:    */   extends JFrame
/*  34:    */ {
/*  35:    */   private SplashGUI splash;
/*  36: 15 */   accesoDAO aO = new accesoDAO();
/*  37:    */   public static JButton btnEntrar;
/*  38:    */   private JComboBox cboCategoria;
/*  39:    */   private JMenu jMenu1;
/*  40:    */   private JMenu jMenu2;
/*  41:    */   private JMenu jMenu3;
/*  42:    */   private JMenu jMenu4;
/*  43:    */   private JMenuBar jMenuBar1;
/*  44:    */   private JMenuItem jMenuItem1;
/*  45:    */   private JMenuItem jMenuItem2;
/*  46:    */   private JMenuItem jMenuItem3;
/*  47:    */   private JMenuItem jMenuItem4;
/*  48:    */   private JMenuItem jMenuItem5;
/*  49:    */   private JPanel jPanel4;
/*  50:    */   private JLabel lblContraseña2;
/*  51:    */   private JLabel lblImg;
/*  52:    */   private JLabel lblUsuario;
/*  53:    */   private JPasswordField txtPassVendedor;
/*  54:    */   private JTextField txtUsuario;
/*  55:    */   
/*  56:    */   public LogeoGUI()
/*  57:    */   {
/*  58: 18 */     initComponents();
/*  59: 19 */     setLocationRelativeTo(this);
/*  60: 20 */     setSize(399, 710);
/*  61: 21 */     setResizable(false);
/*  62:    */   }
/*  63:    */   
/*  64:    */   public LogeoGUI(SplashGUI splashGUI)
/*  65:    */   {
/*  66: 25 */     this.splash = splashGUI;
/*  67: 26 */     setProgressB(0, "cargando componentes...");
/*  68:    */     
/*  69: 28 */     initComponents();
/*  70: 29 */     setTitle("L E D A T E L   V1.0");
/*  71: 30 */     setLocationRelativeTo(this);
/*  72: 31 */     setSize(399, 710);
/*  73: 32 */     setResizable(false);
/*  74: 33 */     setProgressB(5, "iniciando software...");
/*  75: 34 */     setProgressB(10, "conectando a la base de datos...");
/*  76: 35 */     setProgressB(15, "conectando a la base de datos...");
/*  77: 36 */     setProgressB(20, "cargando interfacez de usuario...");
/*  78: 37 */     setProgressB(30, "cargando reportes...");
/*  79: 38 */     setProgressB(40, "compilando ...");
/*  80: 39 */     setProgressB(50, "verificando al administrador...");
/*  81: 40 */     setProgressB(55, "verificando usuarios...");
/*  82: 41 */     setProgressB(57, "verificando usuarios...");
/*  83: 42 */     setProgressB(61, "verificando usuarios...");
/*  84: 43 */     setProgressB(70, "cargando listas...");
/*  85: 44 */     setProgressB(90, "espere unos segundos...");
/*  86:    */     
/*  87: 46 */     setProgressB(96, "programa desarrollado por Suarez Loli , Edson");
/*  90: 49 */     setProgressB(100, "Bienvenidos a nuestro sistema");
/*  91:    */   }
/*  92:    */   
/*  93:    */   private void setProgressB(int login, String mens)
/*  94:    */   {
/*  95: 53 */     this.splash.getLabel().setText(mens);
/*  96: 54 */     this.splash.getProgressBar().setValue(login);
/*  97:    */     try
/*  98:    */     {
/*  99: 56 */       Thread.sleep(1000L);
/* 100:    */     }
/* 101:    */     catch (InterruptedException e)
/* 102:    */     {
/* 103: 59 */       System.out.println(e);
/* 104:    */     }
/* 105:    */   }
/* 106:    */   
/* 107:    */   private void initComponents()
/* 108:    */   {
/* 109: 67 */     this.jPanel4 = new JPanel();
/* 110: 68 */     this.lblUsuario = new JLabel();
/* 111: 69 */     this.lblContraseña2 = new JLabel();
/* 112: 70 */     this.txtPassVendedor = new JPasswordField();
/* 113: 71 */     this.txtUsuario = new JTextField();
/* 114: 72 */     this.cboCategoria = new JComboBox();
/* 115: 73 */     btnEntrar = new JButton();
/* 116: 74 */     this.lblImg = new JLabel();
/* 117: 75 */     this.jMenuBar1 = new JMenuBar();
/* 118: 76 */     this.jMenu1 = new JMenu();
/* 119: 77 */     this.jMenuItem5 = new JMenuItem();
/* 120: 78 */     this.jMenu2 = new JMenu();
/* 121: 79 */     this.jMenu4 = new JMenu();
/* 122: 80 */     this.jMenuItem1 = new JMenuItem();
/* 123: 81 */     this.jMenuItem2 = new JMenuItem();
/* 124: 82 */     this.jMenuItem3 = new JMenuItem();
/* 125: 83 */     this.jMenu3 = new JMenu();
/* 126: 84 */     this.jMenuItem4 = new JMenuItem();
/* 127:    */     
/* 128: 86 */     setDefaultCloseOperation(3);
/* 129: 87 */     setIconImage(new ImageIcon(getClass().getResource("/Fondos/ld.png")).getImage());
/* 130: 88 */     getContentPane().setLayout(new AbsoluteLayout());
/* 131:    */     
/* 132: 90 */     this.jPanel4.setBackground(new Color(51, 51, 51));
/* 133: 91 */     this.jPanel4.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 4));
/* 134: 92 */     this.jPanel4.setLayout(new AbsoluteLayout());
/* 135:    */     
/* 136: 94 */     this.lblUsuario.setFont(new Font("sansserif", 1, 16));
/* 137: 95 */     this.lblUsuario.setForeground(new Color(153, 255, 255));
/* 138: 96 */     this.lblUsuario.setText("U s u a r i o :");
/* 139: 97 */     this.jPanel4.add(this.lblUsuario, new AbsoluteConstraints(30, 390, -1, -1));
/* 140:    */     
/* 141: 99 */     this.lblContraseña2.setFont(new Font("sansserif", 1, 16));
/* 142:100 */     this.lblContraseña2.setForeground(new Color(153, 255, 255));
/* 143:101 */     this.lblContraseña2.setText("C o n t r a s e ñ a :");
/* 144:102 */     this.jPanel4.add(this.lblContraseña2, new AbsoluteConstraints(30, 460, -1, -1));
/* 145:    */     
/* 146:104 */     this.txtPassVendedor.setFont(new Font("sansserif", 1, 16));
/* 147:105 */     this.txtPassVendedor.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 0));
/* 148:106 */     this.txtPassVendedor.setEchoChar('™');
/* 149:107 */     this.txtPassVendedor.addActionListener(new ActionListener()
/* 150:    */     {
/* 151:    */       public void actionPerformed(ActionEvent evt)
/* 152:    */       {
/* 153:109 */         LogeoGUI.this.txtPassVendedorActionPerformed(evt);
/* 154:    */       }
/* 155:111 */     });
/* 156:112 */     this.jPanel4.add(this.txtPassVendedor, new AbsoluteConstraints(100, 480, 220, 30));
/* 157:    */     
/* 158:114 */     this.txtUsuario.setFont(new Font("sansserif", 1, 16));
/* 159:115 */     this.txtUsuario.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 0));
/* 160:116 */     this.jPanel4.add(this.txtUsuario, new AbsoluteConstraints(100, 420, 220, 30));
/* 161:    */     
/* 162:118 */     this.cboCategoria.setBackground(new Color(0, 51, 51));
/* 163:119 */     this.cboCategoria.setModel(new DefaultComboBoxModel(new String[] { "ADMINISTRADOR", "VENDEDOR" }));
/* 164:120 */     this.cboCategoria.setBorder(null);
/* 165:121 */     this.cboCategoria.setCursor(new Cursor(12));
/* 166:122 */     this.cboCategoria.addActionListener(new ActionListener()
/* 167:    */     {
/* 168:    */       public void actionPerformed(ActionEvent evt)
/* 169:    */       {
/* 170:124 */         LogeoGUI.this.cboCategoriaActionPerformed(evt);
/* 171:    */       }
/* 172:126 */     });
/* 173:127 */     this.jPanel4.add(this.cboCategoria, new AbsoluteConstraints(80, 330, 240, 30));
/* 174:    */     
/* 175:129 */     btnEntrar.setBackground(new Color(153, 204, 255));
/* 176:130 */     btnEntrar.setFont(new Font("sansserif", 0, 18));
/* 177:131 */     btnEntrar.setIcon(new ImageIcon(getClass().getResource("/Iconos/LOGIN.PNG")));
/* 178:132 */     btnEntrar.setText("E n t r a r");
/* 179:133 */     btnEntrar.addActionListener(new ActionListener()
/* 180:    */     {
/* 181:    */       public void actionPerformed(ActionEvent evt)
/* 182:    */       {
/* 183:135 */         LogeoGUI.this.btnEntrarActionPerformed(evt);
/* 184:    */       }
/* 185:137 */     });
/* 186:138 */     this.jPanel4.add(btnEntrar, new AbsoluteConstraints(80, 560, 230, 50));
/* 187:    */     
/* 188:140 */     this.lblImg.setHorizontalAlignment(0);
/* 189:141 */     this.lblImg.setIcon(new ImageIcon(getClass().getResource("/Fondos/seguridad.png")));
/* 190:142 */     this.lblImg.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/* 191:143 */     this.jPanel4.add(this.lblImg, new AbsoluteConstraints(110, 100, 180, 190));
/* 192:    */     
/* 193:145 */     getContentPane().add(this.jPanel4, new AbsoluteConstraints(0, 0, 400, 680));
/* 194:    */     
/* 195:147 */     this.jMenu1.setText("Archivo");
/* 196:    */     
/* 197:149 */     this.jMenuItem5.setIcon(new ImageIcon(getClass().getResource("/icon/delete-32.png")));
/* 198:150 */     this.jMenuItem5.setText("s  a  l  i  r");
/* 199:151 */     this.jMenuItem5.addActionListener(new ActionListener()
/* 200:    */     {
/* 201:    */       public void actionPerformed(ActionEvent evt)
/* 202:    */       {
/* 203:153 */         LogeoGUI.this.jMenuItem5ActionPerformed(evt);
/* 204:    */       }
/* 205:155 */     });
/* 206:156 */     this.jMenu1.add(this.jMenuItem5);
/* 207:    */     
/* 208:158 */     this.jMenuBar1.add(this.jMenu1);
/* 209:    */     
/* 210:160 */     this.jMenu2.setText("Opciones");
/* 211:    */     
/* 212:162 */     this.jMenu4.setText("Backbround");
/* 213:    */     
/* 214:164 */     this.jMenuItem1.setText("blue");
/* 215:165 */     this.jMenu4.add(this.jMenuItem1);
/* 216:    */     
/* 217:167 */     this.jMenuItem2.setText("black");
/* 218:168 */     this.jMenu4.add(this.jMenuItem2);
/* 219:    */     
/* 220:170 */     this.jMenuItem3.setText("write");
/* 221:171 */     this.jMenu4.add(this.jMenuItem3);
/* 222:    */     
/* 223:173 */     this.jMenu2.add(this.jMenu4);
/* 224:    */     
/* 225:175 */     this.jMenuBar1.add(this.jMenu2);
/* 226:    */     
/* 227:177 */     this.jMenu3.setText("Ayuda");
/* 228:    */     
/* 229:179 */     this.jMenuItem4.setText("acerca de");
/* 230:180 */     this.jMenu3.add(this.jMenuItem4);
/* 231:    */     
/* 232:182 */     this.jMenuBar1.add(this.jMenu3);
/* 233:    */     
/* 234:184 */     setJMenuBar(this.jMenuBar1);
/* 235:    */     
/* 236:186 */     pack();
/* 237:    */   }
/* 238:    */   
/* 239:    */   private void cboCategoriaActionPerformed(ActionEvent evt)
/* 240:    */   {
/* 241:190 */     ImageIcon imagen = new ImageIcon();
/* 242:191 */     String opc = this.cboCategoria.getSelectedItem().toString();
/* 243:192 */     if (opc.equals("ADMINISTRADOR")) {
/* 244:193 */       imagen = new ImageIcon("C:\\LEDATEL\\src\\icon\\ColumnChart.png");
/* 245:    */     }
/* 246:195 */     if (opc.equals("VENDEDOR")) {
/* 247:196 */       imagen = new ImageIcon("C:\\LEDATEL\\src\\icon\\User.png");
/* 248:    */     }
/* 249:198 */     this.lblImg.setIcon(imagen);
/* 250:199 */     getRootPane().setDefaultButton(btnEntrar);
/* 251:    */   }
/* 252:    */   
/* 253:    */   private void btnEntrarActionPerformed(ActionEvent evt)
/* 254:    */   {
/* 255:    */     try
/* 256:    */     {
/* 257:204 */       String opc = this.cboCategoria.getSelectedItem().toString();
/* 258:205 */       String mensaje = "";
/* 259:206 */       String usuario = this.txtUsuario.getText().toLowerCase();
/* 260:207 */       String contraseña = this.txtPassVendedor.getText().toLowerCase();
/* 261:211 */       if (opc.equals("ADMINISTRADOR"))
/* 262:    */       {
/* 263:213 */         boolean estado = this.aO.validarAccesoAdmin(usuario, contraseña);
/* 264:214 */         if (estado == true)
/* 265:    */         {
/* 266:215 */           new VentanaPrincipalGUI().setVisible(true);
/* 267:    */           
/* 268:217 */           VentanaPrincipalGUI.lblEmpleado.setText("|ADMINISTRADOR|");
/* 269:    */           
/* 270:219 */           dispose();
/* 271:    */         }
/* 272:    */         else
/* 273:    */         {
/* 274:221 */           mensaje = "Contraseña del Administrador errada...";
/* 275:222 */           JOptionPane.showMessageDialog(this.rootPane, mensaje);
/* 276:    */         }
/* 277:224 */         restring(true);
/* 278:    */       }
/* 279:229 */       boolean u = false;
/* 280:230 */       if (opc.equals("VENDEDOR"))
/* 281:    */       {
/* 282:232 */         u = this.aO.validarAccesoEmpl(usuario, contraseña);
/* 283:233 */         if (u == true)
/* 284:    */         {
/* 285:234 */           new VentanaPrincipalGUI().setVisible(true);
/* 286:    */           
/* 287:236 */           dispose();
/* 288:237 */           ResultSet rs = this.aO.caragAccesoEmpl(usuario, contraseña);
/* 289:238 */           while (rs.next()) {
/* 290:239 */             VentanaPrincipalGUI.lblEmpleado.setText(rs.getString(4) + " " + rs.getString(5));
/* 291:    */           }
/* 292:    */         }
/* 293:243 */         mensaje = "Contraseña del Vendedor errada...";
/* 294:244 */         JOptionPane.showMessageDialog(this.rootPane, mensaje);
/* 295:    */         
/* 296:246 */         restring(false);
/* 297:    */       }
/* 298:    */     }
/* 299:    */     catch (Exception e)
/* 300:    */     {
/* 301:250 */       JOptionPane.showMessageDialog(this.rootPane, e);
/* 302:    */     }
/* 303:    */   }
/* 304:    */   
/* 305:    */   private void txtPassVendedorActionPerformed(ActionEvent evt) {}
/* 306:    */   
/* 307:    */   private void jMenuItem5ActionPerformed(ActionEvent evt)
/* 308:    */   {
/* 309:259 */     System.exit(0);
/* 310:    */   }
/* 311:    */   
/* 312:    */   private void restring(boolean b)
/* 313:    */   {
/* 314:286 */     VentanaPrincipalGUI.btnBalance2.setEnabled(b);
/* 315:287 */     VentanaPrincipalGUI.btnCompras.setEnabled(b);
/* 316:288 */     VentanaPrincipalGUI.btnProveedor.setEnabled(b);
/* 317:289 */     VentanaPrincipalGUI.menuRegistros.setEnabled(b);
/* 318:    */   }
/* 319:    */ }



/* AUTOR:           EDSON J SUAREZ LOLI
 */