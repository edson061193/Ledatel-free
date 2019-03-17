/*   1:    */ package Gui;
/*   2:    */
/*   3:    */ import Desk.balanceDesk;
/*   4:    */ import Desk.boletaDesk;
/*   5:    */ import Desk.cajaDesk;
/*   6:    */ import Desk.clienteDesk;
/*   7:    */ import Desk.comprasDesk;
/*   8:    */ import Desk.contratoDesk;
/*   9:    */ import Desk.empleadoDesk;
/*  10:    */ import Desk.graficoEstadisticosDesk;
/*  11:    */ import Desk.productoDesk;
/*  12:    */ import Desk.proveedorDesk;
/*  13:    */ import Desk.registroProductoDesk;
/*  14:    */ import Desk.reparacionesDesk;
/*  15:    */ import Desk.ventasDesk;
/*  16:    */ import Log.fondoPrincipal;
/*  17:    */ import Log.relojLog;
/*  18:    */ import java.awt.Color;
/*  19:    */ import java.awt.Container;
/*  20:    */ import java.awt.Cursor;
/*  21:    */ import java.awt.Dimension;
/*  22:    */ import java.awt.Font;
/*  23:    */ import java.awt.event.ActionEvent;
/*  24:    */ import java.awt.event.ActionListener;
/*  25:    */ import java.awt.event.MouseEvent;
/*  26:    */ import java.awt.event.MouseMotionAdapter;
/*  27:    */ import javax.swing.BorderFactory;
/*  28:    */ import javax.swing.GroupLayout;
/*  29:    */ import javax.swing.GroupLayout.Alignment;
/*  30:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  31:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  32:    */ import javax.swing.ImageIcon;
/*  33:    */ import javax.swing.JButton;
/*  34:    */ import javax.swing.JDesktopPane;
/*  35:    */ import javax.swing.JFrame;
/*  36:    */ import javax.swing.JLabel;
/*  37:    */ import javax.swing.JLayeredPane;
/*  38:    */ import javax.swing.JMenu;
/*  39:    */ import javax.swing.JMenuBar;
/*  40:    */ import javax.swing.JMenuItem;
/*  41:    */ import javax.swing.JOptionPane;
/*  42:    */ import javax.swing.JToolBar;
/*  43:    */ import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
/*  44:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  45:    */
/*  46:    */ public class VentanaPrincipalGUI
        /*  47:    */ extends JFrame /*  48:    */ {
    /*  49:    */ public static JButton btnBalance;
    /*  50:    */ public static JButton btnBalance2;
    /*  51:    */ private JButton btnBalance3;
    /*  52:    */ private JButton btnBoleta;
    /*  53:    */ public static JButton btnCaja;
    /*  54:    */ private JButton btnCerrarL;
    /*  55:    */ public static JButton btnCompras;
    /*  56:    */ private JButton btnProductos;
    /*  57:    */ public static JButton btnProveedor;
    /*  58:    */ private JButton btnReparaciones;
    /*  59:    */ private JButton btnReportes;
    /*  60:    */ private JButton btnSalir;
    /*  61:    */ private JButton btnVentas;
    /*  62:    */ public static JDesktopPane desk;
    /*  63:    */ private JLabel jLabel1;
    /*  64:    */ private JMenuBar jMenuBar1;
    /*  65:    */ private JMenuItem jMenuItem1;
    /*  66:    */ private JMenuItem jMenuItem2;
    /*  67:    */ private JMenuItem jMenuItem3;
    /*  68:    */ private JMenuItem jMenuItem4;
    /*  69:    */ private JToolBar jToolBar1;
    /*  70:    */ private JToolBar jToolBar2;
    /*  71:    */ public static JLabel lblEmpleado;
    /*  72:    */ public static JLabel lblReloj;
    /*  73:    */ public static JMenu menuRegistros;
    /*  74:    */ private JMenu menu_Archivo;
    /*  75:    */ private JMenu mnuConsultas;
    /*  76:    */ private JMenuItem mnuCredito;
    /*  77:    */
    /*  78:    */ public VentanaPrincipalGUI() /*  79:    */ {
        /*  80: 22 */ initComponents();
        /*  81: 23 */ desk.setBorder(new fondoPrincipal());
        /*  82: 24 */ setExtendedState(6);
        /*  83: 25 */ relojLog hilo = new relojLog(lblReloj);
        /*  84: 26 */ hilo.start();
        /*  85: 27 */ setLocationRelativeTo(this);
        /*  86: 28 */ setTitle(" L  E  D  A  T  E  L  -  B  A  R  R  A  N  C  A  ");
        /*  87:    */    }
    /*  88:    */
    /*  89:    */ private void initComponents() /*  90:    */ {
        /*  91: 36 */ this.jToolBar1 = new JToolBar();
        /*  92: 37 */ btnCaja = new JButton();
        /*  93: 38 */ this.btnBoleta = new JButton();
        /*  94: 39 */ this.btnProductos = new JButton();
        /*  95: 40 */ btnCompras = new JButton();
        /*  96: 41 */ this.btnReparaciones = new JButton();
        /*  97: 42 */ this.btnBalance3 = new JButton();
        /*  98: 43 */ this.btnVentas = new JButton();
        /*  99: 44 */ this.btnReportes = new JButton();
        /* 100: 45 */ btnBalance = new JButton();
        /* 101: 46 */ btnProveedor = new JButton();
        /* 102: 47 */ btnBalance2 = new JButton();
        /* 103: 48 */ this.btnSalir = new JButton();
        /* 104: 49 */ desk = new JDesktopPane();
        /* 105: 50 */ this.jToolBar2 = new JToolBar();
        /* 106: 51 */ this.jLabel1 = new JLabel();
        /* 107: 52 */ lblEmpleado = new JLabel();
        /* 108: 53 */ this.btnCerrarL = new JButton();
        /* 109: 54 */ lblReloj = new JLabel();
        /* 110: 55 */ this.jMenuBar1 = new JMenuBar();
        /* 111: 56 */ this.menu_Archivo = new JMenu();
        /* 112: 57 */ this.jMenuItem1 = new JMenuItem();
        /* 113: 58 */ menuRegistros = new JMenu();
        /* 114: 59 */ this.jMenuItem3 = new JMenuItem();
        /* 115: 60 */ this.jMenuItem4 = new JMenuItem();
        /* 116: 61 */ this.jMenuItem2 = new JMenuItem();
        /* 117: 62 */ this.mnuConsultas = new JMenu();
        /* 118: 63 */ this.mnuCredito = new JMenuItem();
        /* 119:    */
        /* 120: 65 */ setDefaultCloseOperation(3);
        /* 121: 66 */ setBackground(new Color(255, 255, 255));
        /* 122: 67 */ setIconImage(new ImageIcon(getClass().getResource("/Fondos/ld.png")).getImage());
        /* 123: 68 */ setName("FrmMenuPrincipal");
        /* 124: 69 */ setResizable(false);
        /* 125:    */
        /* 126: 71 */ this.jToolBar1.setBackground(new Color(255, 255, 153));
        /* 127: 72 */ this.jToolBar1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
        /* 128: 73 */ this.jToolBar1.setFloatable(false);
        /* 129: 74 */ this.jToolBar1.setRollover(true);
        /* 130: 75 */ this.jToolBar1.setOpaque(false);
        /* 131:    */
        /* 132: 77 */ btnCaja.setBackground(new Color(204, 204, 255));
        /* 133: 78 */ btnCaja.setForeground(new Color(0, 0, 153));
        /* 134: 79 */ btnCaja.setIcon(new ImageIcon(getClass().getResource("/icon/Money.png")));
        /* 135: 80 */ btnCaja.setText("CAJA");
        /* 136: 81 */ btnCaja.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        /* 137: 82 */ btnCaja.setContentAreaFilled(false);
        /* 138: 83 */ btnCaja.setFocusable(false);
        /* 139: 84 */ btnCaja.setHorizontalTextPosition(0);
        /* 140: 85 */ btnCaja.setMaximumSize(new Dimension(110, 70));
        /* 141: 86 */ btnCaja.setMinimumSize(new Dimension(110, 70));
        /* 142: 87 */ btnCaja.setOpaque(true);
        /* 143: 88 */ btnCaja.setPreferredSize(new Dimension(110, 70));
        /* 144: 89 */ btnCaja.setVerticalTextPosition(3);
        /* 145: 90 */ btnCaja.addActionListener(new ActionListener() /* 146:    */ {
            /* 147:    */ public void actionPerformed(ActionEvent evt) /* 148:    */ {
                /* 149: 92 */ VentanaPrincipalGUI.this.btnCajaActionPerformed(evt);
                /* 150:    */            }
            /* 151: 94 */        });
        /* 152: 95 */ this.jToolBar1.add(btnCaja);
        /* 153:    */
        /* 154: 97 */ this.btnBoleta.setBackground(new Color(204, 204, 255));
        /* 155: 98 */ this.btnBoleta.setForeground(new Color(0, 0, 255));
        /* 156: 99 */ this.btnBoleta.setIcon(new ImageIcon(getClass().getResource("/icon/basic3-017_invoice_bill-32.png")));
        /* 157:100 */ this.btnBoleta.setText("BOLETA");
        /* 158:101 */ this.btnBoleta.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        /* 159:102 */ this.btnBoleta.setContentAreaFilled(false);
        /* 160:103 */ this.btnBoleta.setFocusable(false);
        /* 161:104 */ this.btnBoleta.setHorizontalTextPosition(0);
        /* 162:105 */ this.btnBoleta.setMaximumSize(new Dimension(110, 70));
        /* 163:106 */ this.btnBoleta.setMinimumSize(new Dimension(110, 70));
        /* 164:107 */ this.btnBoleta.setOpaque(true);
        /* 165:108 */ this.btnBoleta.setPreferredSize(new Dimension(110, 70));
        /* 166:109 */ this.btnBoleta.setVerticalTextPosition(3);
        /* 167:110 */ this.btnBoleta.addActionListener(new ActionListener() /* 168:    */ {
            /* 169:    */ public void actionPerformed(ActionEvent evt) /* 170:    */ {
                /* 171:112 */ VentanaPrincipalGUI.this.btnBoletaActionPerformed(evt);
                /* 172:    */            }
            /* 173:114 */        });
        /* 174:115 */ this.jToolBar1.add(this.btnBoleta);
        /* 175:    */
        /* 176:117 */ this.btnProductos.setBackground(new Color(204, 204, 255));
        /* 177:118 */ this.btnProductos.setForeground(new Color(0, 0, 255));
        /* 178:119 */ this.btnProductos.setIcon(new ImageIcon(getClass().getResource("/icon/basic3-088_qr_code_scan_mobile-32.png")));
        /* 179:120 */ this.btnProductos.setText("PRODUCTOS");
        /* 180:121 */ this.btnProductos.setToolTipText("");
        /* 181:122 */ this.btnProductos.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        /* 182:123 */ this.btnProductos.setContentAreaFilled(false);
        /* 183:124 */ this.btnProductos.setFocusable(false);
        /* 184:125 */ this.btnProductos.setHorizontalTextPosition(0);
        /* 185:126 */ this.btnProductos.setMaximumSize(new Dimension(110, 70));
        /* 186:127 */ this.btnProductos.setMinimumSize(new Dimension(110, 70));
        /* 187:128 */ this.btnProductos.setOpaque(true);
        /* 188:129 */ this.btnProductos.setPreferredSize(new Dimension(110, 70));
        /* 189:130 */ this.btnProductos.setVerticalTextPosition(3);
        /* 190:131 */ this.btnProductos.addActionListener(new ActionListener() /* 191:    */ {
            /* 192:    */ public void actionPerformed(ActionEvent evt) /* 193:    */ {
                /* 194:133 */ VentanaPrincipalGUI.this.btnProductosActionPerformed(evt);
                /* 195:    */            }
            /* 196:135 */        });
        /* 197:136 */ this.jToolBar1.add(this.btnProductos);
        /* 198:    */
        /* 199:138 */ btnCompras.setBackground(new Color(204, 204, 255));
        /* 200:139 */ btnCompras.setForeground(new Color(0, 0, 255));
        /* 201:140 */ btnCompras.setIcon(new ImageIcon(getClass().getResource("/icon/Delivery.png")));
        /* 202:141 */ btnCompras.setText("COMPRAS");
        /* 203:142 */ btnCompras.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        /* 204:143 */ btnCompras.setContentAreaFilled(false);
        /* 205:144 */ btnCompras.setFocusable(false);
        /* 206:145 */ btnCompras.setHorizontalTextPosition(0);
        /* 207:146 */ btnCompras.setMaximumSize(new Dimension(110, 70));
        /* 208:147 */ btnCompras.setMinimumSize(new Dimension(110, 70));
        /* 209:148 */ btnCompras.setOpaque(true);
        /* 210:149 */ btnCompras.setPreferredSize(new Dimension(110, 70));
        /* 211:150 */ btnCompras.setVerticalTextPosition(3);
        /* 212:151 */ btnCompras.addActionListener(new ActionListener() /* 213:    */ {
            /* 214:    */ public void actionPerformed(ActionEvent evt) /* 215:    */ {
                /* 216:153 */ VentanaPrincipalGUI.this.btnComprasActionPerformed(evt);
                /* 217:    */            }
            /* 218:155 */        });
        /* 219:156 */ this.jToolBar1.add(btnCompras);
        /* 220:    */
        /* 221:158 */ this.btnReparaciones.setBackground(new Color(204, 204, 255));
        /* 222:159 */ this.btnReparaciones.setForeground(new Color(0, 0, 255));
        /* 223:160 */ this.btnReparaciones.setIcon(new ImageIcon(getClass().getResource("/icon/support_settings_maintanance-32.png")));
        /* 224:161 */ this.btnReparaciones.setText("REPARACIONES");
        /* 225:162 */ this.btnReparaciones.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        /* 226:163 */ this.btnReparaciones.setContentAreaFilled(false);
        /* 227:164 */ this.btnReparaciones.setFocusable(false);
        /* 228:165 */ this.btnReparaciones.setHorizontalTextPosition(0);
        /* 229:166 */ this.btnReparaciones.setMaximumSize(new Dimension(110, 70));
        /* 230:167 */ this.btnReparaciones.setMinimumSize(new Dimension(110, 70));
        /* 231:168 */ this.btnReparaciones.setOpaque(true);
        /* 232:169 */ this.btnReparaciones.setPreferredSize(new Dimension(110, 70));
        /* 233:170 */ this.btnReparaciones.setVerticalTextPosition(3);
        /* 234:171 */ this.btnReparaciones.addActionListener(new ActionListener() /* 235:    */ {
            /* 236:    */ public void actionPerformed(ActionEvent evt) /* 237:    */ {
                /* 238:173 */ VentanaPrincipalGUI.this.btnReparacionesActionPerformed(evt);
                /* 239:    */            }
            /* 240:175 */        });
        /* 241:176 */ this.jToolBar1.add(this.btnReparaciones);
        /* 242:    */
        /* 243:178 */ this.btnBalance3.setBackground(new Color(204, 204, 255));
        /* 244:179 */ this.btnBalance3.setForeground(new Color(0, 0, 255));
        /* 245:180 */ this.btnBalance3.setIcon(new ImageIcon(getClass().getResource("/icon/audience_targeting-32.png")));
        /* 246:181 */ this.btnBalance3.setText("CLIENTES");
        /* 247:182 */ this.btnBalance3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        /* 248:183 */ this.btnBalance3.setContentAreaFilled(false);
        /* 249:184 */ this.btnBalance3.setFocusable(false);
        /* 250:185 */ this.btnBalance3.setHorizontalTextPosition(0);
        /* 251:186 */ this.btnBalance3.setMaximumSize(new Dimension(110, 70));
        /* 252:187 */ this.btnBalance3.setMinimumSize(new Dimension(110, 70));
        /* 253:188 */ this.btnBalance3.setOpaque(true);
        /* 254:189 */ this.btnBalance3.setPreferredSize(new Dimension(110, 70));
        /* 255:190 */ this.btnBalance3.setVerticalTextPosition(3);
        /* 256:191 */ this.btnBalance3.addActionListener(new ActionListener() /* 257:    */ {
            /* 258:    */ public void actionPerformed(ActionEvent evt) /* 259:    */ {
                /* 260:193 */ VentanaPrincipalGUI.this.btnBalance3ActionPerformed(evt);
                /* 261:    */            }
            /* 262:195 */        });
        /* 263:196 */ this.jToolBar1.add(this.btnBalance3);
        /* 264:    */
        /* 265:198 */ this.btnVentas.setBackground(new Color(204, 204, 255));
        /* 266:199 */ this.btnVentas.setForeground(new Color(0, 0, 255));
        /* 267:200 */ this.btnVentas.setIcon(new ImageIcon(getClass().getResource("/icon/invetment_return-32.png")));
        /* 268:201 */ this.btnVentas.setText("VENTAS");
        /* 269:202 */ this.btnVentas.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        /* 270:203 */ this.btnVentas.setContentAreaFilled(false);
        /* 271:204 */ this.btnVentas.setFocusable(false);
        /* 272:205 */ this.btnVentas.setHorizontalTextPosition(0);
        /* 273:206 */ this.btnVentas.setMaximumSize(new Dimension(110, 70));
        /* 274:207 */ this.btnVentas.setMinimumSize(new Dimension(110, 70));
        /* 275:208 */ this.btnVentas.setOpaque(true);
        /* 276:209 */ this.btnVentas.setPreferredSize(new Dimension(110, 70));
        /* 277:210 */ this.btnVentas.setVerticalTextPosition(3);
        /* 278:211 */ this.btnVentas.addActionListener(new ActionListener() /* 279:    */ {
            /* 280:    */ public void actionPerformed(ActionEvent evt) /* 281:    */ {
                /* 282:213 */ VentanaPrincipalGUI.this.btnVentasActionPerformed(evt);
                /* 283:    */            }
            /* 284:215 */        });
        /* 285:216 */ this.jToolBar1.add(this.btnVentas);
        /* 286:    */
        /* 287:218 */ this.btnReportes.setBackground(new Color(204, 204, 255));
        /* 288:219 */ this.btnReportes.setForeground(new Color(0, 0, 255));
        /* 289:220 */ this.btnReportes.setIcon(new ImageIcon(getClass().getResource("/icon/Script_Code_Html_Macro_Source_Command_Batch_Shell_Procedure_Function_Php_Css_Javascript_Roll_Scroll_Text_Document_Ok_Confirm_Complete_Accept_Check_Allow_Available-32.png")));
        /* 290:221 */ this.btnReportes.setText("REPORTES");
        /* 291:222 */ this.btnReportes.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        /* 292:223 */ this.btnReportes.setContentAreaFilled(false);
        /* 293:224 */ this.btnReportes.setFocusable(false);
        /* 294:225 */ this.btnReportes.setHorizontalTextPosition(0);
        /* 295:226 */ this.btnReportes.setMaximumSize(new Dimension(110, 70));
        /* 296:227 */ this.btnReportes.setMinimumSize(new Dimension(110, 70));
        /* 297:228 */ this.btnReportes.setOpaque(true);
        /* 298:229 */ this.btnReportes.setPreferredSize(new Dimension(110, 70));
        /* 299:230 */ this.btnReportes.setVerticalTextPosition(3);
        /* 300:231 */ this.btnReportes.addActionListener(new ActionListener() /* 301:    */ {
            /* 302:    */ public void actionPerformed(ActionEvent evt) /* 303:    */ {
                /* 304:233 */ VentanaPrincipalGUI.this.btnReportesActionPerformed(evt);
                /* 305:    */            }
            /* 306:235 */        });
        /* 307:236 */ this.jToolBar1.add(this.btnReportes);
        /* 308:    */
        /* 309:238 */ btnBalance.setBackground(new Color(204, 204, 255));
        /* 310:239 */ btnBalance.setForeground(new Color(0, 0, 255));
        /* 311:240 */ btnBalance.setIcon(new ImageIcon(getClass().getResource("/icon/Calendar_black-32.png")));
        /* 312:241 */ btnBalance.setText("BALANCE");
        /* 313:242 */ btnBalance.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        /* 314:243 */ btnBalance.setContentAreaFilled(false);
        /* 315:244 */ btnBalance.setFocusable(false);
        /* 316:245 */ btnBalance.setHorizontalTextPosition(0);
        /* 317:246 */ btnBalance.setMaximumSize(new Dimension(110, 70));
        /* 318:247 */ btnBalance.setMinimumSize(new Dimension(110, 70));
        /* 319:248 */ btnBalance.setOpaque(true);
        /* 320:249 */ btnBalance.setPreferredSize(new Dimension(110, 70));
        /* 321:250 */ btnBalance.setVerticalTextPosition(3);
        /* 322:251 */ btnBalance.addActionListener(new ActionListener() /* 323:    */ {
            /* 324:    */ public void actionPerformed(ActionEvent evt) /* 325:    */ {
                /* 326:253 */ VentanaPrincipalGUI.this.btnBalanceActionPerformed(evt);
                /* 327:    */            }
            /* 328:255 */        });
        /* 329:256 */ this.jToolBar1.add(btnBalance);
        /* 330:    */
        /* 331:258 */ btnProveedor.setBackground(new Color(204, 204, 255));
        /* 332:259 */ btnProveedor.setForeground(new Color(0, 0, 255));
        /* 333:260 */ btnProveedor.setIcon(new ImageIcon(getClass().getResource("/icon/Company-32.png")));
        /* 334:261 */ btnProveedor.setText("PROVEEDOR");
        /* 335:262 */ btnProveedor.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        /* 336:263 */ btnProveedor.setContentAreaFilled(false);
        /* 337:264 */ btnProveedor.setFocusable(false);
        /* 338:265 */ btnProveedor.setHorizontalTextPosition(0);
        /* 339:266 */ btnProveedor.setMaximumSize(new Dimension(110, 70));
        /* 340:267 */ btnProveedor.setMinimumSize(new Dimension(110, 70));
        /* 341:268 */ btnProveedor.setOpaque(true);
        /* 342:269 */ btnProveedor.setPreferredSize(new Dimension(110, 70));
        /* 343:270 */ btnProveedor.setVerticalTextPosition(3);
        /* 344:271 */ btnProveedor.addActionListener(new ActionListener() /* 345:    */ {
            /* 346:    */ public void actionPerformed(ActionEvent evt) /* 347:    */ {
                /* 348:273 */ VentanaPrincipalGUI.this.btnProveedorActionPerformed(evt);
                /* 349:    */            }
            /* 350:275 */        });
        /* 351:276 */ this.jToolBar1.add(btnProveedor);
        /* 352:    */
        /* 353:278 */ btnBalance2.setBackground(new Color(204, 204, 255));
        /* 354:279 */ btnBalance2.setForeground(new Color(0, 0, 255));
        /* 355:280 */ btnBalance2.setIcon(new ImageIcon(getClass().getResource("/icon/support_help_talk-32.png")));
        /* 356:281 */ btnBalance2.setText("PEDIDOS");
        /* 357:282 */ btnBalance2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        /* 358:283 */ btnBalance2.setContentAreaFilled(false);
        /* 359:284 */ btnBalance2.setFocusable(false);
        /* 360:285 */ btnBalance2.setHorizontalTextPosition(0);
        /* 361:286 */ btnBalance2.setMaximumSize(new Dimension(110, 70));
        /* 362:287 */ btnBalance2.setMinimumSize(new Dimension(110, 70));
        /* 363:288 */ btnBalance2.setOpaque(true);
        /* 364:289 */ btnBalance2.setPreferredSize(new Dimension(110, 70));
        /* 365:290 */ btnBalance2.setVerticalTextPosition(3);
        /* 366:291 */ btnBalance2.addActionListener(new ActionListener() /* 367:    */ {
            /* 368:    */ public void actionPerformed(ActionEvent evt) /* 369:    */ {
                /* 370:293 */ VentanaPrincipalGUI.this.btnBalance2ActionPerformed(evt);
                /* 371:    */            }
            /* 372:295 */        });
        /* 373:296 */ this.jToolBar1.add(btnBalance2);
        /* 374:    */
        /* 375:298 */ this.btnSalir.setBackground(new Color(204, 204, 255));
        /* 376:299 */ this.btnSalir.setFont(new Font("sansserif", 1, 14));
        /* 377:300 */ this.btnSalir.setForeground(new Color(204, 0, 51));
        /* 378:301 */ this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/icon/arrow-back-outline-32.png")));
        /* 379:302 */ this.btnSalir.setText("SALIR");
        /* 380:303 */ this.btnSalir.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        /* 381:304 */ this.btnSalir.setMaximumSize(new Dimension(110, 70));
        /* 382:305 */ this.btnSalir.setMinimumSize(new Dimension(110, 70));
        /* 383:306 */ this.btnSalir.setPreferredSize(new Dimension(150, 70));
        /* 384:307 */ this.btnSalir.addMouseMotionListener(new MouseMotionAdapter() /* 385:    */ {
            /* 386:    */ public void mouseMoved(MouseEvent evt) /* 387:    */ {
                /* 388:309 */ VentanaPrincipalGUI.this.btnSalirMouseMoved(evt);
                /* 389:    */            }
            /* 390:311 */        });
        /* 391:312 */ this.btnSalir.addActionListener(new ActionListener() /* 392:    */ {
            /* 393:    */ public void actionPerformed(ActionEvent evt) /* 394:    */ {
                /* 395:314 */ VentanaPrincipalGUI.this.btnSalirActionPerformed(evt);
                /* 396:    */            }
            /* 397:316 */        });
        /* 398:317 */ this.jToolBar1.add(this.btnSalir);
        /* 399:    */
        /* 400:319 */ desk.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 5));
        /* 401:320 */ desk.setPreferredSize(new Dimension(1000, 696));
        /* 402:321 */ desk.setRequestFocusEnabled(false);
        /* 403:    */
        /* 404:323 */ this.jToolBar2.setBorder(null);
        /* 405:324 */ this.jToolBar2.setFloatable(false);
        /* 406:325 */ this.jToolBar2.setOrientation(1);
        /* 407:326 */ this.jToolBar2.setRollover(true);
        /* 408:    */
        /* 409:328 */ this.jLabel1.setFont(new Font("sansserif", 1, 18));
        /* 410:329 */ this.jLabel1.setForeground(new Color(255, 255, 255));
        /* 411:330 */ this.jLabel1.setText("Bienvenido:");
        /* 412:331 */ this.jLabel1.setMaximumSize(new Dimension(110, 70));
        /* 413:332 */ this.jLabel1.setMinimumSize(new Dimension(110, 70));
        /* 414:333 */ this.jToolBar2.add(this.jLabel1);
        /* 415:    */
        /* 416:335 */ lblEmpleado.setBackground(new Color(255, 255, 153));
        /* 417:336 */ lblEmpleado.setFont(new Font("Arial", 1, 11));
        /* 418:337 */ lblEmpleado.setForeground(new Color(255, 204, 102));
        /* 419:338 */ lblEmpleado.setHorizontalAlignment(0);
        /* 420:339 */ lblEmpleado.setMaximumSize(new Dimension(110, 70));
        /* 421:340 */ lblEmpleado.setMinimumSize(new Dimension(110, 70));
        /* 422:341 */ lblEmpleado.setPreferredSize(new Dimension(110, 40));
        /* 423:342 */ this.jToolBar2.add(lblEmpleado);
        /* 424:    */
        /* 425:344 */ this.btnCerrarL.setFont(new Font("sansserif", 2, 12));
        /* 426:345 */ this.btnCerrarL.setForeground(new Color(0, 204, 204));
        /* 427:346 */ this.btnCerrarL.setText("Cerrar Sessión");
        /* 428:347 */ this.btnCerrarL.setBorder(BorderFactory.createTitledBorder(null, "", 2, 5, null, new Color(204, 0, 0)));
        /* 429:348 */ this.btnCerrarL.addActionListener(new ActionListener() /* 430:    */ {
            /* 431:    */ public void actionPerformed(ActionEvent evt) /* 432:    */ {
                /* 433:350 */ VentanaPrincipalGUI.this.btnCerrarLActionPerformed(evt);
                /* 434:    */            }
            /* 435:352 */        });
        /* 436:353 */ this.jToolBar2.add(this.btnCerrarL);
        /* 437:    */
        /* 438:355 */ lblReloj.setFont(new Font("sansserif", 1, 18));
        /* 439:356 */ lblReloj.setForeground(new Color(204, 255, 102));
        /* 440:357 */ lblReloj.setHorizontalAlignment(0);
        /* 441:358 */ lblReloj.setText("hh:mm:ss");
        /* 442:359 */ lblReloj.setHorizontalTextPosition(0);
        /* 443:360 */ lblReloj.setMaximumSize(new Dimension(102, 36));
        /* 444:361 */ lblReloj.setMinimumSize(new Dimension(102, 36));
        /* 445:362 */ lblReloj.setPreferredSize(new Dimension(102, 36));
        /* 446:363 */ this.jToolBar2.add(lblReloj);
        /* 447:    */
        /* 448:365 */ GroupLayout deskLayout = new GroupLayout(desk);
        /* 449:366 */ desk.setLayout(deskLayout);
        /* 450:367 */ deskLayout.setHorizontalGroup(deskLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(deskLayout.createSequentialGroup().addGap(1235, 1235, 1235).addComponent(this.jToolBar2, -2, 123, -2)));
        /* 451:    */
        /* 452:    */
        /* 453:    */
        /* 454:    */
        /* 455:    */
        /* 456:373 */ deskLayout.setVerticalGroup(deskLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(deskLayout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jToolBar2, -2, 193, -2)));
        /* 457:    */
        /* 458:    */
        /* 459:    */
        /* 460:    */
        /* 461:    */
        /* 462:379 */ desk.setLayer(this.jToolBar2, JLayeredPane.DEFAULT_LAYER.intValue());
        /* 463:    */
        /* 464:381 */ this.jMenuBar1.setBackground(new Color(102, 255, 0));
        /* 465:382 */ this.jMenuBar1.setCursor(new Cursor(12));
        /* 466:    */
        /* 467:384 */ this.menu_Archivo.setBackground(new Color(204, 204, 255));
        /* 468:385 */ this.menu_Archivo.setForeground(new Color(51, 51, 255));
        /* 469:386 */ this.menu_Archivo.setText("a r c h i v o  ");
        /* 470:    */
        /* 471:388 */ this.jMenuItem1.setIcon(new ImageIcon(getClass().getResource("/icon/logout-32.png")));
        /* 472:389 */ this.jMenuItem1.setText("Cerrar Sesión");
        /* 473:390 */ this.jMenuItem1.addActionListener(new ActionListener() /* 474:    */ {
            /* 475:    */ public void actionPerformed(ActionEvent evt) /* 476:    */ {
                /* 477:392 */ VentanaPrincipalGUI.this.jMenuItem1ActionPerformed(evt);
                /* 478:    */            }
            /* 479:394 */        });
        /* 480:395 */ this.menu_Archivo.add(this.jMenuItem1);
        /* 481:    */
        /* 482:397 */ this.jMenuBar1.add(this.menu_Archivo);
        /* 483:    */
        /* 484:399 */ menuRegistros.setBackground(new Color(204, 255, 204));
        /* 485:400 */ menuRegistros.setText("  r e g i s t r o s  ");
        /* 486:401 */ menuRegistros.setAlignmentX(0.9F);
        /* 487:    */
        /* 488:403 */ this.jMenuItem3.setAccelerator(KeyStroke.getKeyStroke(48, 1));
        /* 489:404 */ this.jMenuItem3.setBackground(new Color(51, 51, 51));
        /* 490:405 */ this.jMenuItem3.setFont(new Font("sansserif", 0, 13));
        /* 491:406 */ this.jMenuItem3.setForeground(new Color(51, 51, 0));
        /* 492:407 */ this.jMenuItem3.setText("P r o d u c t o                                  ");
        /* 493:408 */ this.jMenuItem3.setAlignmentX(0.9F);
        /* 494:409 */ this.jMenuItem3.setAlignmentY(0.9F);
        /* 495:410 */ this.jMenuItem3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        /* 496:411 */ this.jMenuItem3.addActionListener(new ActionListener() /* 497:    */ {
            /* 498:    */ public void actionPerformed(ActionEvent evt) /* 499:    */ {
                /* 500:413 */ VentanaPrincipalGUI.this.jMenuItem3ActionPerformed(evt);
                /* 501:    */            }
            /* 502:415 */        });
        /* 503:416 */ menuRegistros.add(this.jMenuItem3);
        /* 504:    */
        /* 505:418 */ this.jMenuItem4.setAccelerator(KeyStroke.getKeyStroke(49, 1));
        /* 506:419 */ this.jMenuItem4.setBackground(new Color(51, 51, 51));
        /* 507:420 */ this.jMenuItem4.setFont(new Font("sansserif", 0, 13));
        /* 508:421 */ this.jMenuItem4.setForeground(new Color(51, 51, 0));
        /* 509:422 */ this.jMenuItem4.setText("P r o v e e d o r");
        /* 510:423 */ this.jMenuItem4.setAlignmentX(0.9F);
        /* 511:424 */ this.jMenuItem4.setAlignmentY(0.9F);
        /* 512:425 */ this.jMenuItem4.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        /* 513:426 */ this.jMenuItem4.addActionListener(new ActionListener() /* 514:    */ {
            /* 515:    */ public void actionPerformed(ActionEvent evt) /* 516:    */ {
                /* 517:428 */ VentanaPrincipalGUI.this.jMenuItem4ActionPerformed(evt);
                /* 518:    */            }
            /* 519:430 */        });
        /* 520:431 */ menuRegistros.add(this.jMenuItem4);
        /* 521:    */
        /* 522:433 */ this.jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(50, 1));
        /* 523:434 */ this.jMenuItem2.setBackground(new Color(51, 51, 51));
        /* 524:435 */ this.jMenuItem2.setFont(new Font("sansserif", 0, 13));
        /* 525:436 */ this.jMenuItem2.setForeground(new Color(51, 51, 0));
        /* 526:437 */ this.jMenuItem2.setText("E m p l e a d o");
        /* 527:438 */ this.jMenuItem2.setAlignmentX(0.9F);
        /* 528:439 */ this.jMenuItem2.setAlignmentY(0.9F);
        /* 529:440 */ this.jMenuItem2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        /* 530:441 */ this.jMenuItem2.setPressedIcon(new ImageIcon(getClass().getResource("/Iconos/ADD.PNG")));
        /* 531:442 */ this.jMenuItem2.setRolloverIcon(new ImageIcon(getClass().getResource("/Iconos/Atraz.PNG")));
        /* 532:443 */ this.jMenuItem2.addActionListener(new ActionListener() /* 533:    */ {
            /* 534:    */ public void actionPerformed(ActionEvent evt) /* 535:    */ {
                /* 536:445 */ VentanaPrincipalGUI.this.jMenuItem2ActionPerformed(evt);
                /* 537:    */            }
            /* 538:447 */        });
        /* 539:448 */ menuRegistros.add(this.jMenuItem2);
        /* 540:    */
        /* 541:450 */ this.jMenuBar1.add(menuRegistros);
        /* 542:    */
        /* 543:452 */ this.mnuConsultas.setText("  c o n s u l t a s  ");
        /* 544:453 */ this.mnuConsultas.addActionListener(new ActionListener() /* 545:    */ {
            /* 546:    */ public void actionPerformed(ActionEvent evt) /* 547:    */ {
                /* 548:455 */ VentanaPrincipalGUI.this.mnuConsultasActionPerformed(evt);
                /* 549:    */            }
            /* 550:458 */        });
        /* 551:459 */ this.mnuCredito.setText("c r e d i t o s");
        /* 552:460 */ this.mnuCredito.addActionListener(new ActionListener() /* 553:    */ {
            /* 554:    */ public void actionPerformed(ActionEvent evt) /* 555:    */ {
                /* 556:462 */ VentanaPrincipalGUI.this.mnuCreditoActionPerformed(evt);
                /* 557:    */            }
            /* 558:464 */        });
        /* 559:465 */ this.mnuConsultas.add(this.mnuCredito);
        /* 560:    */
        /* 561:467 */ this.jMenuBar1.add(this.mnuConsultas);
        /* 562:    */
        /* 563:469 */ setJMenuBar(this.jMenuBar1);
        /* 564:    */
        /* 565:471 */ GroupLayout layout = new GroupLayout(getContentPane());
        /* 566:472 */ getContentPane().setLayout(layout);
        /* 567:473 */ layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(desk, -1, 1367, 32767).addComponent(this.jToolBar1, -1, 1367, 32767))));
        /* 575:481 */ layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jToolBar1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(desk, -1, 569, 32767)));
        pack();
        /* 585:    */    }
    /* 586:    */
    /* 587:    */ private void btnBoletaActionPerformed(ActionEvent evt) /* 588:    */ {
        /* 589:494 */ boletaDesk g = boletaDesk.getForm();
        /* 590:495 */ if (!desk.isAncestorOf(g)) /* 591:    */ {
            /* 592:496 */ desk.add(g);
            /* 593:497 */ g.setVisible(true);
            /* 594:    */        } /* 595:    */ else /* 596:    */ {
            /* 597:499 */ g.setVisible(true);
            /* 598:    */        }
        /* 599:    */    }
    /* 600:    */
    /* 601:    */ private void btnSalirActionPerformed(ActionEvent evt) /* 602:    */ {
        /* 603:504 */ int opc = JOptionPane.showConfirmDialog(this.rootPane, "Desea salir del sistema", "Cuadro de advertencia", 0, 3);
        /* 604:505 */ if (opc == 0) {
            /* 605:506 */ System.exit(0);
            /* 606:    */        }
        /* 607:    */    }
    /* 608:    */
    /* 609:    */ private void btnCajaActionPerformed(ActionEvent evt) /* 610:    */ {
        /* 611:511 */ cajaDesk g = new cajaDesk();
        /* 612:    */
        /* 613:513 */ desk.add(g);
        /* 614:    */
        /* 615:515 */ g.setVisible(true);
        /* 616:516 */ g.show();
        /* 617:    */
        /* 618:518 */ btnCaja.setEnabled(false);
        /* 619:    */    }
    /* 620:    */
    /* 621:    */ private void btnProductosActionPerformed(ActionEvent evt) /* 622:    */ {
        /* 623:524 */ productoDesk g = productoDesk.getForm();
        /* 624:525 */ if (!desk.isAncestorOf(g)) /* 625:    */ {
            /* 626:526 */ desk.add(g);
            /* 627:527 */ g.setVisible(true);
            /* 628:    */        } /* 629:    */ else /* 630:    */ {
            /* 631:529 */ g.setVisible(true);
            /* 632:    */        }
        /* 633:    */    }
    /* 634:    */
    /* 635:    */ private void btnComprasActionPerformed(ActionEvent evt) /* 636:    */ {
        /* 637:534 */ comprasDesk g = new comprasDesk();
        /* 638:535 */ desk.add(g);
        /* 639:536 */ g.show();
        /* 640:    */    }
    /* 641:    */
    /* 642:    */ private void btnReparacionesActionPerformed(ActionEvent evt) /* 643:    */ {
        /* 644:548 */ reparacionesDesk g = new reparacionesDesk();
        /* 645:    */
        /* 646:550 */ desk.add(g);
        /* 647:551 */ g.show();
        /* 648:    */    }
    /* 649:    */
    /* 650:    */ private void btnVentasActionPerformed(ActionEvent evt) /* 651:    */ {
        /* 652:556 */ ventasDesk g = new ventasDesk();
        /* 653:    */
        /* 654:558 */ desk.add(g);
        /* 655:559 */ g.show();
        /* 656:    */    }
    /* 657:    */
    /* 658:    */ private void btnReportesActionPerformed(ActionEvent evt) /* 659:    */ {
        /* 660:563 */ graficoEstadisticosDesk g = new graficoEstadisticosDesk();
        /* 661:564 */ desk.add(g);
        /* 662:565 */ g.show();
        /* 663:    */    }
    /* 664:    */
    /* 665:    */ private void btnSalirMouseMoved(MouseEvent evt) /* 666:    */ {
        /* 667:569 */ this.btnSalir.setForeground(new Color(255, 51, 51));
        /* 668:    */    }
    /* 669:    */
    /* 670:    */ private void jMenuItem1ActionPerformed(ActionEvent evt) /* 671:    */ {
        /* 672:573 */ LogeoGUI log = new LogeoGUI();
        /* 673:574 */ log.setVisible(true);
        /* 674:575 */ log.setLocationRelativeTo(this);
        /* 675:576 */ log.setTitle("L E D A T E L  V1.0");
        /* 676:577 */ dispose();
        /* 677:    */    }
    /* 678:    */
    /* 679:    */ private void jMenuItem2ActionPerformed(ActionEvent evt) /* 680:    */ {
        /* 681:581 */ empleadoDesk g = new empleadoDesk();
        /* 682:    */
        /* 683:583 */ desk.add(g);
        /* 684:584 */ g.show();
        /* 685:    */    }
    /* 686:    */
    /* 687:    */ private void btnCerrarLActionPerformed(ActionEvent evt) /* 688:    */ {
        /* 689:589 */ dispose();
        /* 690:590 */ new LogeoGUI().setVisible(true);
        /* 691:    */    }
    /* 692:    */
    /* 693:    */ private void jMenuItem4ActionPerformed(ActionEvent evt) /* 694:    */ {
        /* 695:594 */ proveedorDesk g = new proveedorDesk();
        /* 696:    */
        /* 697:596 */ desk.add(g);
        /* 698:597 */ g.show();
        /* 699:    */    }
    /* 700:    */
    /* 701:    */ private void btnProveedorActionPerformed(ActionEvent evt) /* 702:    */ {
        /* 703:601 */ proveedorDesk g = proveedorDesk.getForm();
        /* 704:602 */ if (!desk.isAncestorOf(g)) /* 705:    */ {
            /* 706:603 */ desk.add(g);
            /* 707:604 */ g.setVisible(true);
            /* 708:    */        } /* 709:    */ else /* 710:    */ {
            /* 711:606 */ g.setVisible(true);
            /* 712:    */        }
        /* 713:    */    }
    /* 714:    */
    /* 715:    */ private void btnBalance2ActionPerformed(ActionEvent evt) {
    }
    /* 716:    */
    /* 717:    */ private void btnBalance3ActionPerformed(ActionEvent evt) /* 718:    */ {
        /* 719:615 */ clienteDesk g = clienteDesk.getForm();
        /* 720:616 */ if (!desk.isAncestorOf(g)) /* 721:    */ {
            /* 722:617 */ desk.add(g);
            /* 723:618 */ g.setVisible(true);
            /* 724:    */        } /* 725:    */ else /* 726:    */ {
            /* 727:620 */ g.setVisible(true);
            /* 728:    */        }
        /* 729:    */    }
    /* 730:    */
    /* 731:    */ private void jMenuItem3ActionPerformed(ActionEvent evt) /* 732:    */ {
        /* 733:625 */ registroProductoDesk g = registroProductoDesk.getForm();
        /* 734:626 */ if (!desk.isAncestorOf(g)) /* 735:    */ {
            /* 736:627 */ desk.add(g);
            /* 737:628 */ g.setVisible(true);
            /* 738:    */        } /* 739:    */ else /* 740:    */ {
            /* 741:630 */ g.setVisible(true);
            /* 742:    */        }
        /* 743:    */    }
    /* 744:    */
    /* 745:    */ private void mnuCreditoActionPerformed(ActionEvent evt) /* 746:    */ {
        /* 747:635 */ contratoDesk g = new contratoDesk();
        /* 748:636 */ desk.add(g);
        /* 749:637 */ g.show();
        /* 750:    */    }
    /* 751:    */
    /* 752:    */ private void mnuConsultasActionPerformed(ActionEvent evt) {
    }
    /* 753:    */
    /* 754:    */ private void btnBalanceActionPerformed(ActionEvent evt) /* 755:    */ {
        /* 756:645 */ balanceDesk g = balanceDesk.getForm();
        /* 757:646 */ if (!desk.isAncestorOf(g)) /* 758:    */ {
            /* 759:647 */ desk.add(g);
            /* 760:648 */ g.setVisible(true);
            /* 761:    */        } /* 762:    */ else /* 763:    */ {
            /* 764:650 */ g.setVisible(true);
            /* 765:    */        }
        /* 766:    */    }
    /* 767:    */ }

/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar

 * Qualified Name:     Gui.VentanaPrincipalGUI

 * JD-Core Version:    0.7.0.1

 */
