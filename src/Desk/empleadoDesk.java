/*    1:     */ package Desk;
/*    2:     */ 
/*    3:     */ import Dao.empleadoDao;
/*    4:     */ import Gui.VentanaPrincipalGUI;
/*    5:     */ import To.empleado_TO;
/*    6:     */ import java.awt.Color;
/*    7:     */ import java.awt.Container;
/*    8:     */ import java.awt.Dimension;
/*    9:     */ import java.awt.Font;
/*   10:     */ import java.awt.event.ActionEvent;
/*   11:     */ import java.awt.event.ActionListener;
/*   12:     */ import java.awt.event.KeyAdapter;
/*   13:     */ import java.awt.event.KeyEvent;
/*   14:     */ import java.awt.event.MouseAdapter;
/*   15:     */ import java.awt.event.MouseEvent;
/*   16:     */ import java.io.PrintStream;
/*   17:     */ import java.sql.ResultSet;
/*   18:     */ import javax.swing.BorderFactory;
/*   19:     */ import javax.swing.ButtonGroup;
/*   20:     */ import javax.swing.DefaultComboBoxModel;
/*   21:     */ import javax.swing.GroupLayout;
/*   22:     */ import javax.swing.GroupLayout.Alignment;
/*   23:     */ import javax.swing.GroupLayout.ParallelGroup;
/*   24:     */ import javax.swing.GroupLayout.SequentialGroup;
/*   25:     */ import javax.swing.ImageIcon;
/*   26:     */ import javax.swing.JButton;
/*   27:     */ import javax.swing.JComboBox;
/*   28:     */ import javax.swing.JDesktopPane;
/*   29:     */ import javax.swing.JInternalFrame;
/*   30:     */ import javax.swing.JLabel;
/*   31:     */ import javax.swing.JOptionPane;
/*   32:     */ import javax.swing.JPanel;
/*   33:     */ import javax.swing.JPasswordField;
/*   34:     */ import javax.swing.JRadioButton;
/*   35:     */ import javax.swing.JRootPane;
/*   36:     */ import javax.swing.JScrollPane;
/*   37:     */ import javax.swing.JTabbedPane;
/*   38:     */ import javax.swing.JTable;
/*   39:     */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*   40:     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*   41:     */ import javax.swing.table.DefaultTableModel;
/*   42:     */ import javax.swing.table.TableColumn;
/*   43:     */ import javax.swing.table.TableColumnModel;
/*   44:     */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*   45:     */ import org.netbeans.lib.awtextra.AbsoluteLayout;
/*   46:     */ 
/*   47:     */ public class empleadoDesk
/*   48:     */   extends JInternalFrame
/*   49:     */ {
/*   50:  24 */   private static empleadoDesk fromEmpleado = null;
/*   51:     */   ResultSet rs;
/*   52:     */   DefaultTableModel model;
/*   53:     */   DefaultTableModel model2;
/*   54:     */   
/*   55:     */   public static empleadoDesk getForm()
/*   56:     */   {
/*   57:  27 */     if (fromEmpleado == null) {
/*   58:  28 */       fromEmpleado = new empleadoDesk();
/*   59:     */     }
/*   60:  30 */     return fromEmpleado;
/*   61:     */   }
/*   62:     */   
/*   63:  34 */   empleadoDao oEmplaDao = new empleadoDao();
/*   64:     */   boolean sw;
/*   65:     */   private JButton btnCancelar;
/*   66:     */   private JButton btnEliminar;
/*   67:     */   private JButton btnExit;
/*   68:     */   private JButton btnGrabar;
/*   69:     */   private JButton btnModificar;
/*   70:     */   private JButton btnNuevo;
/*   71:     */   private JButton btnRegistrar;
/*   72:     */   private JButton btnSalir;
/*   73:     */   private JButton btnVerVentas;
/*   74:     */   private ButtonGroup btnrSEXO;
/*   75:     */   private JComboBox cboAreaTrb;
/*   76:     */   private JComboBox cboTipoUsuario;
/*   77:     */   private JLabel jLabel1;
/*   78:     */   private JLabel jLabel10;
/*   79:     */   private JLabel jLabel11;
/*   80:     */   private JLabel jLabel12;
/*   81:     */   private JLabel jLabel13;
/*   82:     */   private JLabel jLabel14;
/*   83:     */   private JLabel jLabel15;
/*   84:     */   private JLabel jLabel16;
/*   85:     */   private JLabel jLabel17;
/*   86:     */   private JLabel jLabel18;
/*   87:     */   private JLabel jLabel19;
/*   88:     */   private JLabel jLabel2;
/*   89:     */   private JLabel jLabel20;
/*   90:     */   private JLabel jLabel3;
/*   91:     */   private JLabel jLabel4;
/*   92:     */   private JLabel jLabel5;
/*   93:     */   private JLabel jLabel6;
/*   94:     */   private JLabel jLabel7;
/*   95:     */   private JLabel jLabel8;
/*   96:     */   private JLabel jLabel9;
/*   97:     */   private JPanel jPanel1;
/*   98:     */   private JPanel jPanel2;
/*   99:     */   private JPanel jPanel3;
/*  100:     */   private JPanel jPanel4;
/*  101:     */   private JPanel jPanel5;
/*  102:     */   private JPanel jPanel6;
/*  103:     */   private JPanel jPanel7;
/*  104:     */   private JScrollPane jScrollPane1;
/*  105:     */   private JScrollPane jScrollPane2;
/*  106:     */   private JLabel lblFoto;
/*  107:     */   private JPanel principal;
/*  108:     */   private JRadioButton rbFeme;
/*  109:     */   private JRadioButton rbMasc;
/*  110:     */   private JTabbedPane tbbRegistros;
/*  111:     */   private JTable tblRegistros;
/*  112:     */   private JTable tblRegistrosEmpl;
/*  113:     */   private JTextField txtApellidos;
/*  114:     */   private JTextField txtApellidos_R_empleado;
/*  115:     */   private JTextField txtBuscar;
/*  116:     */   private JTextField txtCodigo;
/*  117:     */   private JPasswordField txtContraseña_R;
/*  118:     */   private JPasswordField txtContraseña_V;
/*  119:     */   private JTextField txtDNI;
/*  120:     */   private JTextField txtDireccion;
/*  121:     */   private JTextField txtDireccion_R_empleado;
/*  122:     */   private JTextField txtDni;
/*  123:     */   private JTextField txtEmail;
/*  124:     */   private JTextField txtEmail_R_empleado;
/*  125:     */   private JTextField txtIDEusuario;
/*  126:     */   private JTextField txtNombres;
/*  127:     */   private JTextField txtNombres_R_empleado;
/*  128:     */   private JTextField txtSueldo;
/*  129:     */   private JTextField txtSueldo_R_empleado;
/*  130:     */   private JTextField txtTelefono;
/*  131:     */   private JTextField txtTelefono_R_empleado;
/*  132:     */   
/*  133:     */   public empleadoDesk()
/*  134:     */   {
/*  135:  38 */     initComponents();
/*  136:     */   }
/*  137:     */   
/*  138:     */   private void initComponents()
/*  139:     */   {
/*  140:  50 */     this.btnrSEXO = new ButtonGroup();
/*  141:  51 */     this.principal = new JPanel();
/*  142:  52 */     this.jPanel1 = new JPanel();
/*  143:  53 */     this.jLabel2 = new JLabel();
/*  144:  54 */     this.txtBuscar = new JTextField();
/*  145:  55 */     this.jLabel4 = new JLabel();
/*  146:  56 */     this.txtCodigo = new JTextField();
/*  147:  57 */     this.tbbRegistros = new JTabbedPane();
/*  148:  58 */     this.jPanel3 = new JPanel();
/*  149:  59 */     this.btnNuevo = new JButton();
/*  150:  60 */     this.btnExit = new JButton();
/*  151:  61 */     this.btnRegistrar = new JButton();
/*  152:  62 */     this.txtDNI = new JTextField();
/*  153:  63 */     this.jLabel12 = new JLabel();
/*  154:  64 */     this.txtApellidos_R_empleado = new JTextField();
/*  155:  65 */     this.jLabel13 = new JLabel();
/*  156:  66 */     this.txtNombres_R_empleado = new JTextField();
/*  157:  67 */     this.jLabel14 = new JLabel();
/*  158:  68 */     this.jPanel6 = new JPanel();
/*  159:  69 */     this.rbMasc = new JRadioButton();
/*  160:  70 */     this.rbFeme = new JRadioButton();
/*  161:  71 */     this.jLabel15 = new JLabel();
/*  162:  72 */     this.txtDireccion_R_empleado = new JTextField();
/*  163:  73 */     this.jLabel16 = new JLabel();
/*  164:  74 */     this.txtEmail_R_empleado = new JTextField();
/*  165:  75 */     this.jLabel17 = new JLabel();
/*  166:  76 */     this.txtTelefono_R_empleado = new JTextField();
/*  167:  77 */     this.jLabel18 = new JLabel();
/*  168:  78 */     this.jPanel7 = new JPanel();
/*  169:  79 */     this.txtIDEusuario = new JTextField();
/*  170:  80 */     this.txtContraseña_R = new JPasswordField();
/*  171:  81 */     this.txtContraseña_V = new JPasswordField();
/*  172:  82 */     this.jLabel20 = new JLabel();
/*  173:  83 */     this.cboTipoUsuario = new JComboBox();
/*  174:  84 */     this.txtSueldo_R_empleado = new JTextField();
/*  175:  85 */     this.jLabel19 = new JLabel();
/*  176:  86 */     this.jPanel4 = new JPanel();
/*  177:  87 */     this.jScrollPane2 = new JScrollPane();
/*  178:  88 */     this.tblRegistrosEmpl = new JTable();
/*  179:  89 */     this.lblFoto = new JLabel();
/*  180:  90 */     this.jLabel5 = new JLabel();
/*  181:  91 */     this.jLabel6 = new JLabel();
/*  182:  92 */     this.txtDni = new JTextField();
/*  183:  93 */     this.txtApellidos = new JTextField();
/*  184:  94 */     this.txtNombres = new JTextField();
/*  185:  95 */     this.jLabel7 = new JLabel();
/*  186:  96 */     this.jLabel10 = new JLabel();
/*  187:  97 */     this.jLabel9 = new JLabel();
/*  188:  98 */     this.jLabel8 = new JLabel();
/*  189:  99 */     this.txtDireccion = new JTextField();
/*  190: 100 */     this.txtEmail = new JTextField();
/*  191: 101 */     this.txtTelefono = new JTextField();
/*  192: 102 */     this.jLabel11 = new JLabel();
/*  193: 103 */     this.txtSueldo = new JTextField();
/*  194: 104 */     this.cboAreaTrb = new JComboBox();
/*  195: 105 */     this.jLabel3 = new JLabel();
/*  196: 106 */     this.jPanel2 = new JPanel();
/*  197: 107 */     this.btnCancelar = new JButton();
/*  198: 108 */     this.btnModificar = new JButton();
/*  199: 109 */     this.btnSalir = new JButton();
/*  200: 110 */     this.btnGrabar = new JButton();
/*  201: 111 */     this.btnEliminar = new JButton();
/*  202: 112 */     this.jPanel5 = new JPanel();
/*  203: 113 */     this.jScrollPane1 = new JScrollPane();
/*  204: 114 */     this.tblRegistros = new JTable();
/*  205: 115 */     this.btnVerVentas = new JButton();
/*  206: 116 */     this.jLabel1 = new JLabel();
/*  207:     */     
/*  208: 118 */     setClosable(true);
/*  209: 119 */     setIconifiable(true);
/*  210: 120 */     setMaximizable(true);
/*  211: 121 */     setMinimumSize(new Dimension(1343, 640));
/*  212: 122 */     setPreferredSize(new Dimension(1343, 640));
/*  213:     */     
/*  214: 124 */     this.principal.setBackground(new Color(51, 51, 51));
/*  215:     */     
/*  216: 126 */     this.jPanel1.setBackground(new Color(0, 0, 0));
/*  217: 127 */     this.jPanel1.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
/*  218:     */     
/*  219: 129 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  220: 130 */     this.jPanel1.setLayout(jPanel1Layout);
/*  221: 131 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1311, 32767));
/*  222:     */     
/*  223:     */ 
/*  224:     */ 
/*  225: 135 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 24, 32767));
/*  226:     */     
/*  227:     */ 
/*  228:     */ 
/*  229:     */ 
/*  230: 140 */     this.jLabel2.setFont(new Font("Bodoni MT Condensed", 1, 18));
/*  231: 141 */     this.jLabel2.setForeground(new Color(255, 255, 255));
/*  232: 142 */     this.jLabel2.setText("F I L T R A R  (B U S C A R ) :");
/*  233:     */     
/*  234: 144 */     this.txtBuscar.setFont(new Font("sansserif", 0, 16));
/*  235: 145 */     this.txtBuscar.setHorizontalAlignment(0);
/*  236: 146 */     this.txtBuscar.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 255)));
/*  237: 147 */     this.txtBuscar.addKeyListener(new KeyAdapter()
/*  238:     */     {
/*  239:     */       public void keyReleased(KeyEvent evt)
/*  240:     */       {
/*  241: 149 */         empleadoDesk.this.txtBuscarKeyReleased(evt);
/*  242:     */       }
/*  243: 152 */     });
/*  244: 153 */     this.jLabel4.setFont(new Font("Bodoni MT Condensed", 1, 18));
/*  245: 154 */     this.jLabel4.setForeground(new Color(255, 255, 255));
/*  246: 155 */     this.jLabel4.setText("C Ó D I GO   E M P L E A D O :");
/*  247:     */     
/*  248: 157 */     this.txtCodigo.setEditable(false);
/*  249: 158 */     this.txtCodigo.setFont(new Font("sansserif", 0, 16));
/*  250: 159 */     this.txtCodigo.setHorizontalAlignment(0);
/*  251: 160 */     this.txtCodigo.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 255)));
/*  252:     */     
/*  253: 162 */     this.tbbRegistros.setBackground(new Color(51, 51, 51));
/*  254: 163 */     this.tbbRegistros.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/*  255: 164 */     this.tbbRegistros.setTabLayoutPolicy(1);
/*  256: 165 */     this.tbbRegistros.setFont(new Font("sansserif", 1, 14));
/*  257: 166 */     this.tbbRegistros.setOpaque(true);
/*  258:     */     
/*  259: 168 */     this.jPanel3.setBackground(new Color(204, 204, 204));
/*  260:     */     
/*  261: 170 */     this.btnNuevo.setBackground(new Color(153, 204, 255));
/*  262: 171 */     this.btnNuevo.setIcon(new ImageIcon(getClass().getResource("/Iconos/Nu_Empl.png")));
/*  263: 172 */     this.btnNuevo.setText("Nuevo");
/*  264: 173 */     this.btnNuevo.addActionListener(new ActionListener()
/*  265:     */     {
/*  266:     */       public void actionPerformed(ActionEvent evt)
/*  267:     */       {
/*  268: 175 */         empleadoDesk.this.btnNuevoActionPerformed(evt);
/*  269:     */       }
/*  270: 178 */     });
/*  271: 179 */     this.btnExit.setBackground(new Color(153, 204, 255));
/*  272: 180 */     this.btnExit.setIcon(new ImageIcon(getClass().getResource("/icon/logout-32.png")));
/*  273: 181 */     this.btnExit.setText("Salir");
/*  274: 182 */     this.btnExit.addActionListener(new ActionListener()
/*  275:     */     {
/*  276:     */       public void actionPerformed(ActionEvent evt)
/*  277:     */       {
/*  278: 184 */         empleadoDesk.this.btnExitActionPerformed(evt);
/*  279:     */       }
/*  280: 187 */     });
/*  281: 188 */     this.btnRegistrar.setBackground(new Color(153, 204, 255));
/*  282: 189 */     this.btnRegistrar.setIcon(new ImageIcon(getClass().getResource("/Iconos/Re_Empl.png")));
/*  283: 190 */     this.btnRegistrar.setText("Registrar");
/*  284: 191 */     this.btnRegistrar.setEnabled(false);
/*  285: 192 */     this.btnRegistrar.addActionListener(new ActionListener()
/*  286:     */     {
/*  287:     */       public void actionPerformed(ActionEvent evt)
/*  288:     */       {
/*  289: 194 */         empleadoDesk.this.btnRegistrarActionPerformed(evt);
/*  290:     */       }
/*  291: 197 */     });
/*  292: 198 */     this.txtDNI.setEditable(false);
/*  293: 199 */     this.txtDNI.setHorizontalAlignment(0);
/*  294: 200 */     this.txtDNI.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  295: 201 */     this.txtDNI.addKeyListener(new KeyAdapter()
/*  296:     */     {
/*  297:     */       public void keyTyped(KeyEvent evt)
/*  298:     */       {
/*  299: 203 */         empleadoDesk.this.txtDNIKeyTyped(evt);
/*  300:     */       }
/*  301: 206 */     });
/*  302: 207 */     this.jLabel12.setBackground(new Color(0, 0, 51));
/*  303: 208 */     this.jLabel12.setForeground(new Color(255, 255, 255));
/*  304: 209 */     this.jLabel12.setHorizontalAlignment(0);
/*  305: 210 */     this.jLabel12.setText("Ingrese DNI del Empleado");
/*  306: 211 */     this.jLabel12.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  307: 212 */     this.jLabel12.setOpaque(true);
/*  308:     */     
/*  309: 214 */     this.txtApellidos_R_empleado.setEditable(false);
/*  310: 215 */     this.txtApellidos_R_empleado.setHorizontalAlignment(0);
/*  311: 216 */     this.txtApellidos_R_empleado.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  312:     */     
/*  313: 218 */     this.jLabel13.setBackground(new Color(0, 0, 51));
/*  314: 219 */     this.jLabel13.setForeground(new Color(255, 255, 255));
/*  315: 220 */     this.jLabel13.setHorizontalAlignment(0);
/*  316: 221 */     this.jLabel13.setText("Ingrese sus Apellidos");
/*  317: 222 */     this.jLabel13.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  318: 223 */     this.jLabel13.setOpaque(true);
/*  319:     */     
/*  320: 225 */     this.txtNombres_R_empleado.setEditable(false);
/*  321: 226 */     this.txtNombres_R_empleado.setHorizontalAlignment(0);
/*  322: 227 */     this.txtNombres_R_empleado.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  323:     */     
/*  324: 229 */     this.jLabel14.setBackground(new Color(0, 0, 51));
/*  325: 230 */     this.jLabel14.setForeground(new Color(255, 255, 255));
/*  326: 231 */     this.jLabel14.setHorizontalAlignment(0);
/*  327: 232 */     this.jLabel14.setText("Ingrese sus Nombres");
/*  328: 233 */     this.jLabel14.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  329: 234 */     this.jLabel14.setOpaque(true);
/*  330:     */     
/*  331: 236 */     this.jPanel6.setBackground(new Color(255, 255, 255));
/*  332: 237 */     this.jPanel6.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  333: 238 */     this.jPanel6.setLayout(new AbsoluteLayout());
/*  334:     */     
/*  335: 240 */     this.btnrSEXO.add(this.rbMasc);
/*  336: 241 */     this.rbMasc.setText("Masculino");
/*  337: 242 */     this.rbMasc.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  338: 243 */     this.jPanel6.add(this.rbMasc, new AbsoluteConstraints(1, 1, -1, 14));
/*  339:     */     
/*  340: 245 */     this.btnrSEXO.add(this.rbFeme);
/*  341: 246 */     this.rbFeme.setText("Femenino");
/*  342: 247 */     this.rbFeme.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  343: 248 */     this.jPanel6.add(this.rbFeme, new AbsoluteConstraints(93, 1, 81, 14));
/*  344:     */     
/*  345: 250 */     this.jLabel15.setBackground(new Color(0, 0, 51));
/*  346: 251 */     this.jLabel15.setForeground(new Color(255, 255, 255));
/*  347: 252 */     this.jLabel15.setHorizontalAlignment(0);
/*  348: 253 */     this.jLabel15.setText("Elija el Sexo");
/*  349: 254 */     this.jLabel15.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  350: 255 */     this.jLabel15.setOpaque(true);
/*  351: 256 */     this.jPanel6.add(this.jLabel15, new AbsoluteConstraints(0, 20, 200, -1));
/*  352:     */     
/*  353: 258 */     this.txtDireccion_R_empleado.setEditable(false);
/*  354: 259 */     this.txtDireccion_R_empleado.setHorizontalAlignment(0);
/*  355: 260 */     this.txtDireccion_R_empleado.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  356:     */     
/*  357: 262 */     this.jLabel16.setBackground(new Color(0, 0, 51));
/*  358: 263 */     this.jLabel16.setForeground(new Color(255, 255, 255));
/*  359: 264 */     this.jLabel16.setHorizontalAlignment(0);
/*  360: 265 */     this.jLabel16.setText("Ingrese su Dirección");
/*  361: 266 */     this.jLabel16.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  362: 267 */     this.jLabel16.setOpaque(true);
/*  363:     */     
/*  364: 269 */     this.txtEmail_R_empleado.setEditable(false);
/*  365: 270 */     this.txtEmail_R_empleado.setHorizontalAlignment(0);
/*  366: 271 */     this.txtEmail_R_empleado.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  367:     */     
/*  368: 273 */     this.jLabel17.setBackground(new Color(0, 0, 51));
/*  369: 274 */     this.jLabel17.setForeground(new Color(255, 255, 255));
/*  370: 275 */     this.jLabel17.setHorizontalAlignment(0);
/*  371: 276 */     this.jLabel17.setText("Ingrese un Email");
/*  372: 277 */     this.jLabel17.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  373: 278 */     this.jLabel17.setOpaque(true);
/*  374:     */     
/*  375: 280 */     this.txtTelefono_R_empleado.setEditable(false);
/*  376: 281 */     this.txtTelefono_R_empleado.setHorizontalAlignment(0);
/*  377: 282 */     this.txtTelefono_R_empleado.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  378: 283 */     this.txtTelefono_R_empleado.addKeyListener(new KeyAdapter()
/*  379:     */     {
/*  380:     */       public void keyTyped(KeyEvent evt)
/*  381:     */       {
/*  382: 285 */         empleadoDesk.this.txtTelefono_R_empleadoKeyTyped(evt);
/*  383:     */       }
/*  384: 288 */     });
/*  385: 289 */     this.jLabel18.setBackground(new Color(0, 0, 51));
/*  386: 290 */     this.jLabel18.setForeground(new Color(255, 255, 255));
/*  387: 291 */     this.jLabel18.setHorizontalAlignment(0);
/*  388: 292 */     this.jLabel18.setText("Telefono /u celular");
/*  389: 293 */     this.jLabel18.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  390: 294 */     this.jLabel18.setOpaque(true);
/*  391:     */     
/*  392: 296 */     this.jPanel7.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)), "ID/Contraseña", 2, 2));
/*  393:     */     
/*  394: 298 */     this.txtIDEusuario.setEditable(false);
/*  395: 299 */     this.txtIDEusuario.setForeground(new Color(0, 0, 255));
/*  396: 300 */     this.txtIDEusuario.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)), "id de acceso:", 2, 3));
/*  397:     */     
/*  398: 302 */     this.txtContraseña_R.setEditable(false);
/*  399: 303 */     this.txtContraseña_R.setFont(new Font("sansserif", 1, 14));
/*  400: 304 */     this.txtContraseña_R.setForeground(new Color(0, 0, 255));
/*  401: 305 */     this.txtContraseña_R.setHorizontalAlignment(0);
/*  402: 306 */     this.txtContraseña_R.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)), "Ingrese contraseña", 2, 3));
///*  403: 307 */     this.txtContraseña_R.setEchoChar(61514);
/*  404:     */     
/*  405: 309 */     this.txtContraseña_V.setEditable(false);
/*  406: 310 */     this.txtContraseña_V.setFont(new Font("sansserif", 1, 14));
/*  407: 311 */     this.txtContraseña_V.setForeground(new Color(0, 0, 255));
/*  408: 312 */     this.txtContraseña_V.setHorizontalAlignment(0);
/*  409: 313 */     this.txtContraseña_V.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)), "Verifique contraseña", 2, 3));
///*  410: 314 */     this.txtContraseña_V.setEchoChar(61514);
/*  411:     */     
/*  412: 316 */     this.jLabel20.setBackground(new Color(0, 0, 51));
/*  413: 317 */     this.jLabel20.setForeground(new Color(255, 255, 255));
/*  414: 318 */     this.jLabel20.setHorizontalAlignment(0);
/*  415: 319 */     this.jLabel20.setText("Tipo de Usuario:");
/*  416: 320 */     this.jLabel20.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  417: 321 */     this.jLabel20.setOpaque(true);
/*  418:     */     
/*  419: 323 */     this.cboTipoUsuario.setBackground(new Color(0, 0, 0));
/*  420: 324 */     this.cboTipoUsuario.setModel(new DefaultComboBoxModel(new String[] { "ADMINISTRADOR", "VENDEDOR", "TECNICO" }));
/*  421:     */     
/*  422: 326 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  423: 327 */     this.jPanel7.setLayout(jPanel7Layout);
/*  424: 328 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel20, -1, -1, 32767).addComponent(this.cboTipoUsuario, 0, 310, 32767)).addContainerGap(-1, 32767)).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.txtIDEusuario, -2, 209, -2).addGap(18, 18, 18).addComponent(this.txtContraseña_R, -2, 243, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 52, 32767).addComponent(this.txtContraseña_V, -2, 228, -2).addGap(80, 80, 80)))));
/*  425:     */     
/*  426:     */ 
/*  427:     */ 
/*  428:     */ 
/*  429:     */ 
/*  430:     */ 
/*  431:     */ 
/*  432:     */ 
/*  433:     */ 
/*  434:     */ 
/*  435:     */ 
/*  436:     */ 
/*  437:     */ 
/*  438:     */ 
/*  439:     */ 
/*  440:     */ 
/*  441:     */ 
/*  442: 346 */     jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtIDEusuario, -2, -1, -2).addComponent(this.txtContraseña_R, -2, -1, -2))).addComponent(this.txtContraseña_V, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.jLabel20).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboTipoUsuario, -2, 34, -2).addContainerGap(26, 32767)));
/*  443:     */     
/*  444:     */ 
/*  445:     */ 
/*  446:     */ 
/*  447:     */ 
/*  448:     */ 
/*  449:     */ 
/*  450:     */ 
/*  451:     */ 
/*  452:     */ 
/*  453:     */ 
/*  454:     */ 
/*  455:     */ 
/*  456:     */ 
/*  457:     */ 
/*  458:     */ 
/*  459: 363 */     this.txtSueldo_R_empleado.setEditable(false);
/*  460: 364 */     this.txtSueldo_R_empleado.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  461:     */     
/*  462: 366 */     this.jLabel19.setBackground(new Color(0, 0, 51));
/*  463: 367 */     this.jLabel19.setForeground(new Color(255, 255, 255));
/*  464: 368 */     this.jLabel19.setHorizontalAlignment(0);
/*  465: 369 */     this.jLabel19.setText("Ingrese sueldo S/.  ");
/*  466: 370 */     this.jLabel19.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  467: 371 */     this.jLabel19.setOpaque(true);
/*  468:     */     
/*  469: 373 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  470: 374 */     this.jPanel3.setLayout(jPanel3Layout);
/*  471: 375 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.btnNuevo, -2, 129, -2).addComponent(this.btnRegistrar, -1, -1, 32767).addComponent(this.btnExit, -2, 130, -2)).addGap(76, 76, 76).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel7, -2, -1, -2).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel19, -1, -1, 32767).addComponent(this.txtSueldo_R_empleado).addComponent(this.jLabel16, -1, 236, 32767).addComponent(this.txtDNI).addComponent(this.jLabel12, -1, -1, 32767).addComponent(this.txtDireccion_R_empleado)).addGap(67, 67, 67).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel6, -1, -1, 32767).addComponent(this.jLabel17, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.txtEmail_R_empleado, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel13, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.txtApellidos_R_empleado)).addGap(67, 67, 67).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel14, -1, -1, 32767).addComponent(this.txtTelefono_R_empleado).addComponent(this.jLabel18, -1, -1, 32767).addComponent(this.txtNombres_R_empleado, -2, 258, -2)))).addContainerGap(251, 32767)));
/*  472:     */     
/*  473:     */ 
/*  474:     */ 
/*  475:     */ 
/*  476:     */ 
/*  477:     */ 
/*  478:     */ 
/*  479:     */ 
/*  480:     */ 
/*  481:     */ 
/*  482:     */ 
/*  483:     */ 
/*  484:     */ 
/*  485:     */ 
/*  486:     */ 
/*  487:     */ 
/*  488:     */ 
/*  489:     */ 
/*  490:     */ 
/*  491:     */ 
/*  492:     */ 
/*  493:     */ 
/*  494:     */ 
/*  495:     */ 
/*  496:     */ 
/*  497:     */ 
/*  498:     */ 
/*  499:     */ 
/*  500:     */ 
/*  501:     */ 
/*  502:     */ 
/*  503:     */ 
/*  504:     */ 
/*  505: 409 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(38, 38, 38).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnNuevo).addComponent(this.jLabel12).addComponent(this.jLabel13).addComponent(this.jLabel14)).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtDNI, -2, -1, -2).addComponent(this.txtApellidos_R_empleado, -2, -1, -2).addComponent(this.txtNombres_R_empleado, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnRegistrar).addComponent(this.jLabel16).addComponent(this.jLabel17).addComponent(this.jLabel18)).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtDireccion_R_empleado, -2, -1, -2).addComponent(this.txtEmail_R_empleado, -2, -1, -2).addComponent(this.txtTelefono_R_empleado, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnExit, -2, 50, -2).addComponent(this.jLabel19)).addComponent(this.jPanel6, -2, 38, -2).addComponent(this.txtSueldo_R_empleado, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.jPanel7, -2, -1, -2).addContainerGap(-1, 32767)));
/*  506:     */     
/*  507:     */ 
/*  508:     */ 
/*  509:     */ 
/*  510:     */ 
/*  511:     */ 
/*  512:     */ 
/*  513:     */ 
/*  514:     */ 
/*  515:     */ 
/*  516:     */ 
/*  517:     */ 
/*  518:     */ 
/*  519:     */ 
/*  520:     */ 
/*  521:     */ 
/*  522:     */ 
/*  523:     */ 
/*  524:     */ 
/*  525:     */ 
/*  526:     */ 
/*  527:     */ 
/*  528:     */ 
/*  529:     */ 
/*  530:     */ 
/*  531:     */ 
/*  532:     */ 
/*  533:     */ 
/*  534:     */ 
/*  535:     */ 
/*  536:     */ 
/*  537:     */ 
/*  538:     */ 
/*  539:     */ 
/*  540:     */ 
/*  541:     */ 
/*  542: 446 */     this.tbbRegistros.addTab("Registrar Empleado", this.jPanel3);
/*  543:     */     
/*  544: 448 */     this.jPanel4.setBackground(new Color(153, 153, 153));
/*  545: 449 */     this.jPanel4.setLayout(new AbsoluteLayout());
/*  546:     */     
/*  547: 451 */     this.tblRegistrosEmpl.setBackground(new Color(204, 255, 204));
/*  548: 452 */     this.tblRegistrosEmpl.setModel(new DefaultTableModel(new Object[0][], new String[] { "Codigo", "DNI", "Apellidos", "Nombres", "Direccion", "Email", "Telefono", "Area", "Sueldo" })
/*  549:     */     {
/*  550: 460 */       boolean[] canEdit = { false, false, false, false, false, false, false, false, false };
/*  551:     */       
/*  552:     */       public boolean isCellEditable(int rowIndex, int columnIndex)
/*  553:     */       {
/*  554: 465 */         return this.canEdit[columnIndex];
/*  555:     */       }
/*  556: 467 */     });
/*  557: 468 */     this.tblRegistrosEmpl.setOpaque(false);
/*  558: 469 */     this.tblRegistrosEmpl.addMouseListener(new MouseAdapter()
/*  559:     */     {
/*  560:     */       public void mouseClicked(MouseEvent evt)
/*  561:     */       {
/*  562: 471 */         empleadoDesk.this.tblRegistrosEmplMouseClicked(evt);
/*  563:     */       }
/*  564: 473 */     });
/*  565: 474 */     this.jScrollPane2.setViewportView(this.tblRegistrosEmpl);
/*  566: 475 */     if (this.tblRegistrosEmpl.getColumnModel().getColumnCount() > 0)
/*  567:     */     {
/*  568: 476 */       this.tblRegistrosEmpl.getColumnModel().getColumn(0).setMinWidth(80);
/*  569: 477 */       this.tblRegistrosEmpl.getColumnModel().getColumn(0).setPreferredWidth(80);
/*  570: 478 */       this.tblRegistrosEmpl.getColumnModel().getColumn(0).setMaxWidth(80);
/*  571: 479 */       this.tblRegistrosEmpl.getColumnModel().getColumn(1).setMinWidth(80);
/*  572: 480 */       this.tblRegistrosEmpl.getColumnModel().getColumn(1).setPreferredWidth(80);
/*  573: 481 */       this.tblRegistrosEmpl.getColumnModel().getColumn(1).setMaxWidth(80);
/*  574: 482 */       this.tblRegistrosEmpl.getColumnModel().getColumn(6).setMinWidth(80);
/*  575: 483 */       this.tblRegistrosEmpl.getColumnModel().getColumn(6).setPreferredWidth(80);
/*  576: 484 */       this.tblRegistrosEmpl.getColumnModel().getColumn(6).setMaxWidth(80);
/*  577: 485 */       this.tblRegistrosEmpl.getColumnModel().getColumn(8).setMinWidth(80);
/*  578: 486 */       this.tblRegistrosEmpl.getColumnModel().getColumn(8).setPreferredWidth(80);
/*  579: 487 */       this.tblRegistrosEmpl.getColumnModel().getColumn(8).setMaxWidth(80);
/*  580:     */     }
/*  581: 490 */     this.jPanel4.add(this.jScrollPane2, new AbsoluteConstraints(6, 6, 1300, 150));
/*  582:     */     
/*  583: 492 */     this.lblFoto.setHorizontalAlignment(0);
/*  584: 493 */     this.lblFoto.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
/*  585: 494 */     this.jPanel4.add(this.lblFoto, new AbsoluteConstraints(12, 170, 180, 270));
/*  586:     */     
/*  587: 496 */     this.jLabel5.setText("D N I :");
/*  588: 497 */     this.jPanel4.add(this.jLabel5, new AbsoluteConstraints(310, 180, -1, -1));
/*  589:     */     
/*  590: 499 */     this.jLabel6.setText("A P E L L I D O S :");
/*  591: 500 */     this.jPanel4.add(this.jLabel6, new AbsoluteConstraints(250, 210, -1, -1));
/*  592:     */     
/*  593: 502 */     this.txtDni.setEditable(false);
/*  594: 503 */     this.txtDni.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 204), 2));
/*  595: 504 */     this.jPanel4.add(this.txtDni, new AbsoluteConstraints(350, 180, 190, -1));
/*  596:     */     
/*  597: 506 */     this.txtApellidos.setEditable(false);
/*  598: 507 */     this.txtApellidos.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 204), 2));
/*  599: 508 */     this.jPanel4.add(this.txtApellidos, new AbsoluteConstraints(350, 210, 190, -1));
/*  600:     */     
/*  601: 510 */     this.txtNombres.setEditable(false);
/*  602: 511 */     this.txtNombres.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 204), 2));
/*  603: 512 */     this.jPanel4.add(this.txtNombres, new AbsoluteConstraints(354, 240, 190, -1));
/*  604:     */     
/*  605: 514 */     this.jLabel7.setText("N O M B R E S :");
/*  606: 515 */     this.jPanel4.add(this.jLabel7, new AbsoluteConstraints(260, 240, -1, -1));
/*  607:     */     
/*  608: 517 */     this.jLabel10.setText("C E L U L A R :");
/*  609: 518 */     this.jPanel4.add(this.jLabel10, new AbsoluteConstraints(570, 240, -1, -1));
/*  610:     */     
/*  611: 520 */     this.jLabel9.setText("E - M A I L :");
/*  612: 521 */     this.jPanel4.add(this.jLabel9, new AbsoluteConstraints(590, 210, -1, -1));
/*  613:     */     
/*  614: 523 */     this.jLabel8.setText("D I R E C C I Ó N :");
/*  615: 524 */     this.jPanel4.add(this.jLabel8, new AbsoluteConstraints(550, 180, -1, -1));
/*  616:     */     
/*  617: 526 */     this.txtDireccion.setEditable(false);
/*  618: 527 */     this.txtDireccion.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 204), 2));
/*  619: 528 */     this.jPanel4.add(this.txtDireccion, new AbsoluteConstraints(660, 180, 240, -1));
/*  620:     */     
/*  621: 530 */     this.txtEmail.setEditable(false);
/*  622: 531 */     this.txtEmail.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 204), 2));
/*  623: 532 */     this.jPanel4.add(this.txtEmail, new AbsoluteConstraints(660, 210, 240, -1));
/*  624:     */     
/*  625: 534 */     this.txtTelefono.setEditable(false);
/*  626: 535 */     this.txtTelefono.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 204), 2));
/*  627: 536 */     this.jPanel4.add(this.txtTelefono, new AbsoluteConstraints(660, 240, 240, -1));
/*  628:     */     
/*  629: 538 */     this.jLabel11.setText("S U E L D O   S/ ");
/*  630: 539 */     this.jPanel4.add(this.jLabel11, new AbsoluteConstraints(960, 210, -1, -1));
/*  631:     */     
/*  632: 541 */     this.txtSueldo.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 204), 2));
/*  633: 542 */     this.jPanel4.add(this.txtSueldo, new AbsoluteConstraints(1070, 210, 210, -1));
/*  634:     */     
/*  635: 544 */     this.cboAreaTrb.setBackground(new Color(0, 0, 0));
/*  636: 545 */     this.jPanel4.add(this.cboAreaTrb, new AbsoluteConstraints(1070, 170, 210, -1));
/*  637:     */     
/*  638: 547 */     this.jLabel3.setText("A R E A.  T R A B A J O :");
/*  639: 548 */     this.jPanel4.add(this.jLabel3, new AbsoluteConstraints(930, 180, -1, -1));
/*  640:     */     
/*  641: 550 */     this.jPanel2.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
/*  642: 551 */     this.jPanel2.setOpaque(false);
/*  643:     */     
/*  644: 553 */     this.btnCancelar.setBackground(new Color(153, 204, 255));
/*  645: 554 */     this.btnCancelar.setIcon(new ImageIcon(getClass().getResource("/icon/cancel-32.png")));
/*  646: 555 */     this.btnCancelar.setText("Cancelar");
/*  647: 556 */     this.btnCancelar.setEnabled(false);
/*  648: 557 */     this.btnCancelar.addActionListener(new ActionListener()
/*  649:     */     {
/*  650:     */       public void actionPerformed(ActionEvent evt)
/*  651:     */       {
/*  652: 559 */         empleadoDesk.this.btnCancelarActionPerformed(evt);
/*  653:     */       }
/*  654: 562 */     });
/*  655: 563 */     this.btnModificar.setBackground(new Color(153, 204, 255));
/*  656: 564 */     this.btnModificar.setIcon(new ImageIcon(getClass().getResource("/icon/basic3-068_compose_new_document_write_edit-32.png")));
/*  657: 565 */     this.btnModificar.setText("Modificar");
/*  658: 566 */     this.btnModificar.addActionListener(new ActionListener()
/*  659:     */     {
/*  660:     */       public void actionPerformed(ActionEvent evt)
/*  661:     */       {
/*  662: 568 */         empleadoDesk.this.btnModificarActionPerformed(evt);
/*  663:     */       }
/*  664: 571 */     });
/*  665: 572 */     this.btnSalir.setBackground(new Color(153, 204, 255));
/*  666: 573 */     this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/icon/logout-32.png")));
/*  667: 574 */     this.btnSalir.setText("Salir");
/*  668: 575 */     this.btnSalir.addActionListener(new ActionListener()
/*  669:     */     {
/*  670:     */       public void actionPerformed(ActionEvent evt)
/*  671:     */       {
/*  672: 577 */         empleadoDesk.this.btnSalirActionPerformed(evt);
/*  673:     */       }
/*  674: 580 */     });
/*  675: 581 */     this.btnGrabar.setBackground(new Color(153, 204, 255));
/*  676: 582 */     this.btnGrabar.setIcon(new ImageIcon(getClass().getResource("/icon/user-add-32.png")));
/*  677: 583 */     this.btnGrabar.setText("Grabar");
/*  678: 584 */     this.btnGrabar.setEnabled(false);
/*  679: 585 */     this.btnGrabar.addActionListener(new ActionListener()
/*  680:     */     {
/*  681:     */       public void actionPerformed(ActionEvent evt)
/*  682:     */       {
/*  683: 587 */         empleadoDesk.this.btnGrabarActionPerformed(evt);
/*  684:     */       }
/*  685: 590 */     });
/*  686: 591 */     this.btnEliminar.setBackground(new Color(153, 204, 255));
/*  687: 592 */     this.btnEliminar.setIcon(new ImageIcon(getClass().getResource("/icon/delete-32.png")));
/*  688: 593 */     this.btnEliminar.setText("Eliminar");
/*  689: 594 */     this.btnEliminar.addActionListener(new ActionListener()
/*  690:     */     {
/*  691:     */       public void actionPerformed(ActionEvent evt)
/*  692:     */       {
/*  693: 596 */         empleadoDesk.this.btnEliminarActionPerformed(evt);
/*  694:     */       }
/*  695: 599 */     });
/*  696: 600 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  697: 601 */     this.jPanel2.setLayout(jPanel2Layout);
/*  698: 602 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(22, 22, 22).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.btnCancelar, -2, 138, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnEliminar, -2, 154, -2)).addComponent(this.btnGrabar, -2, 298, -2)).addGap(49, 49, 49).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.btnModificar, -1, 212, 32767).addComponent(this.btnSalir, -1, -1, 32767)).addContainerGap(57, 32767)));
/*  699:     */     
/*  700:     */ 
/*  701:     */ 
/*  702:     */ 
/*  703:     */ 
/*  704:     */ 
/*  705:     */ 
/*  706:     */ 
/*  707:     */ 
/*  708:     */ 
/*  709:     */ 
/*  710:     */ 
/*  711:     */ 
/*  712:     */ 
/*  713:     */ 
/*  714: 618 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnGrabar).addComponent(this.btnModificar, -1, -1, 32767)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnCancelar, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.btnSalir, -2, 51, -2))).addGroup(jPanel2Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btnEliminar, -2, 53, -2).addGap(3, 3, 3))).addContainerGap()));
/*  715:     */     
/*  716:     */ 
/*  717:     */ 
/*  718:     */ 
/*  719:     */ 
/*  720:     */ 
/*  721:     */ 
/*  722:     */ 
/*  723:     */ 
/*  724:     */ 
/*  725:     */ 
/*  726:     */ 
/*  727:     */ 
/*  728:     */ 
/*  729:     */ 
/*  730:     */ 
/*  731:     */ 
/*  732:     */ 
/*  733:     */ 
/*  734: 638 */     this.jPanel4.add(this.jPanel2, new AbsoluteConstraints(320, 310, 640, 120));
/*  735:     */     
/*  736: 640 */     this.tbbRegistros.addTab("Ver Empleado", this.jPanel4);
/*  737:     */     
/*  738: 642 */     this.tblRegistros.setBackground(new Color(204, 255, 204));
/*  739: 643 */     this.tblRegistros.setModel(new DefaultTableModel(new Object[0][], new String[] { "Codigo", "DNI", "Apellidos", "Nombres", "Direccion", "Email", "Telefono", "Area", "Sueldo" })
/*  740:     */     {
/*  741: 651 */       boolean[] canEdit = { false, false, false, false, false, false, false, false, false };
/*  742:     */       
/*  743:     */       public boolean isCellEditable(int rowIndex, int columnIndex)
/*  744:     */       {
/*  745: 656 */         return this.canEdit[columnIndex];
/*  746:     */       }
/*  747: 658 */     });
/*  748: 659 */     this.tblRegistros.setOpaque(false);
/*  749: 660 */     this.tblRegistros.addMouseListener(new MouseAdapter()
/*  750:     */     {
/*  751:     */       public void mouseClicked(MouseEvent evt)
/*  752:     */       {
/*  753: 662 */         empleadoDesk.this.tblRegistrosMouseClicked(evt);
/*  754:     */       }
/*  755: 664 */     });
/*  756: 665 */     this.jScrollPane1.setViewportView(this.tblRegistros);
/*  757:     */     
/*  758: 667 */     this.btnVerVentas.setIcon(new ImageIcon(getClass().getResource("/icon/add_product-32.png")));
/*  759: 668 */     this.btnVerVentas.setText("Ver Ventas");
/*  760: 669 */     this.btnVerVentas.addActionListener(new ActionListener()
/*  761:     */     {
/*  762:     */       public void actionPerformed(ActionEvent evt)
/*  763:     */       {
/*  764: 671 */         empleadoDesk.this.btnVerVentasActionPerformed(evt);
/*  765:     */       }
/*  766: 674 */     });
/*  767: 675 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  768: 676 */     this.jPanel5.setLayout(jPanel5Layout);
/*  769: 677 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 1309, 32767).addContainerGap()).addGroup(jPanel5Layout.createSequentialGroup().addGap(76, 76, 76).addComponent(this.btnVerVentas, -2, 136, -2).addContainerGap(-1, 32767)));
/*  770:     */     
/*  771:     */ 
/*  772:     */ 
/*  773:     */ 
/*  774:     */ 
/*  775:     */ 
/*  776:     */ 
/*  777:     */ 
/*  778:     */ 
/*  779:     */ 
/*  780: 688 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(36, 36, 36).addComponent(this.jScrollPane1, -2, 234, -2).addGap(18, 18, 18).addComponent(this.btnVerVentas, -2, 50, -2).addContainerGap(149, 32767)));
/*  781:     */     
/*  782:     */ 
/*  783:     */ 
/*  784:     */ 
/*  785:     */ 
/*  786:     */ 
/*  787:     */ 
/*  788:     */ 
/*  789:     */ 
/*  790: 698 */     this.tbbRegistros.addTab("Reportar Empleados", this.jPanel5);
/*  791:     */     
/*  792: 700 */     this.jLabel1.setFont(new Font("sansserif", 1, 18));
/*  793: 701 */     this.jLabel1.setForeground(new Color(204, 255, 255));
/*  794: 702 */     this.jLabel1.setText("REGISTRO DE EMPLEADO - \"LEDATEL\" BARRANCA");
/*  795:     */     
/*  796: 704 */     GroupLayout principalLayout = new GroupLayout(this.principal);
/*  797: 705 */     this.principal.setLayout(principalLayout);
/*  798: 706 */     principalLayout.setHorizontalGroup(principalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.tbbRegistros).addGroup(GroupLayout.Alignment.TRAILING, principalLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jLabel1).addGap(370, 370, 370)).addGroup(principalLayout.createSequentialGroup().addGap(192, 192, 192).addComponent(this.txtBuscar, -2, 242, -2).addGap(196, 196, 196).addComponent(this.jLabel4).addContainerGap(-1, 32767)).addGroup(principalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(principalLayout.createSequentialGroup().addContainerGap().addGroup(principalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(principalLayout.createSequentialGroup().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()).addGroup(principalLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 661, 32767).addComponent(this.txtCodigo, -2, 176, -2).addContainerGap(316, 32767))))));
/*  799:     */     
/*  800:     */ 
/*  801:     */ 
/*  802:     */ 
/*  803:     */ 
/*  804:     */ 
/*  805:     */ 
/*  806:     */ 
/*  807:     */ 
/*  808:     */ 
/*  809:     */ 
/*  810:     */ 
/*  811:     */ 
/*  812:     */ 
/*  813:     */ 
/*  814:     */ 
/*  815:     */ 
/*  816:     */ 
/*  817:     */ 
/*  818:     */ 
/*  819:     */ 
/*  820:     */ 
/*  821:     */ 
/*  822:     */ 
/*  823:     */ 
/*  824:     */ 
/*  825: 733 */     principalLayout.setVerticalGroup(principalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(principalLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(principalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.txtBuscar, -2, -1, -2)).addGap(14, 14, 14).addComponent(this.tbbRegistros, -1, 524, 32767).addContainerGap()).addGroup(principalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(principalLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(9, 9, 9).addGroup(principalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.txtCodigo, -2, -1, -2)).addContainerGap(442, 32767))));
/*  826:     */     
/*  827:     */ 
/*  828:     */ 
/*  829:     */ 
/*  830:     */ 
/*  831:     */ 
/*  832:     */ 
/*  833:     */ 
/*  834:     */ 
/*  835:     */ 
/*  836:     */ 
/*  837:     */ 
/*  838:     */ 
/*  839:     */ 
/*  840:     */ 
/*  841:     */ 
/*  842:     */ 
/*  843:     */ 
/*  844:     */ 
/*  845:     */ 
/*  846:     */ 
/*  847:     */ 
/*  848: 756 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  849: 757 */     getContentPane().setLayout(layout);
/*  850: 758 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.principal, -1, -1, 32767)));
/*  851:     */     
/*  852:     */ 
/*  853:     */ 
/*  854:     */ 
/*  855:     */ 
/*  856: 764 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.principal, -1, -1, 32767));
/*  857:     */     
/*  858:     */ 
/*  859:     */ 
/*  860:     */ 
/*  861: 769 */     pack();
/*  862:     */   }
/*  863:     */   
/*  864:     */   private void txtBuscarKeyReleased(KeyEvent evt)
/*  865:     */   {
/*  866:     */     try
/*  867:     */     {
/*  868: 774 */       String nombre = this.txtBuscar.getText();
/*  869: 775 */       String apellido = this.txtBuscar.getText();
/*  870: 776 */       String dni = this.txtBuscar.getText();
/*  871: 777 */       this.model = ((DefaultTableModel)this.tblRegistros.getModel());
/*  872: 778 */       this.model2 = ((DefaultTableModel)this.tblRegistrosEmpl.getModel());
/*  873: 779 */       if ((this.model.getRowCount() > 0) || (this.model2.getRowCount() > 0))
/*  874:     */       {
/*  875: 780 */         this.model.removeRow(0);
/*  876: 781 */         this.model2.removeRow(0);
/*  877:     */       }
/*  878:     */       else
/*  879:     */       {
/*  880: 783 */         this.rs = this.oEmplaDao.buscarEmpleado(apellido, nombre, dni);
/*  881: 784 */         while (this.rs.next())
/*  882:     */         {
/*  883: 785 */           Object[] reg = { this.rs.getObject("codigoempleado"), this.rs.getObject("dni"), this.rs.getObject("apellidos"), this.rs.getObject("nombres"), this.rs.getObject("direccion"), this.rs.getObject("correo"), this.rs.getObject("telefono"), this.rs.getObject("tipoempleado"), this.rs.getObject("sueldo") };
/*  884:     */           
/*  885:     */ 
/*  886:     */ 
/*  887:     */ 
/*  888:     */ 
/*  889:     */ 
/*  890:     */ 
/*  891:     */ 
/*  892:     */ 
/*  893:     */ 
/*  894: 796 */           this.model.addRow(reg);
/*  895: 797 */           this.model2.addRow(reg);
/*  896:     */         }
/*  897:     */       }
/*  898:     */     }
/*  899:     */     catch (Exception e)
/*  900:     */     {
/*  901: 802 */       System.out.println(e);
/*  902:     */     }
/*  903:     */   }
/*  904:     */   
/*  905:     */   private void btnNuevoActionPerformed(ActionEvent evt)
/*  906:     */   {
/*  907: 807 */     btnRegistros(true);
/*  908:     */   }
/*  909:     */   
/*  910:     */   private void btnCancelarActionPerformed(ActionEvent evt)
/*  911:     */   {
/*  912: 811 */     this.cboAreaTrb.removeAllItems();
/*  913: 812 */     muestraRegistro();
/*  914: 813 */     habilitaControles(false);
/*  915:     */   }
/*  916:     */   
/*  917:     */   private void btnModificarActionPerformed(ActionEvent evt)
/*  918:     */   {
/*  919: 817 */     habilitaControles(true);
/*  920: 818 */     cbo();
/*  921: 819 */     this.sw = false;
/*  922:     */   }
/*  923:     */   
/*  924:     */   private void btnSalirActionPerformed(ActionEvent evt)
/*  925:     */   {
/*  926: 823 */     int opc = JOptionPane.showConfirmDialog(this.rootPane, "Desea salir ...?", "Cuadro de alerta", 0, 3);
/*  927: 824 */     if (opc == 0) {
/*  928: 825 */       dispose();
/*  929:     */     }
/*  930:     */   }
/*  931:     */   
/*  932:     */   private void btnGrabarActionPerformed(ActionEvent evt)
/*  933:     */   {
/*  934:     */     try
/*  935:     */     {
/*  936: 831 */       empleado_TO to = new empleado_TO();
/*  937: 832 */       String mensaje = "";
/*  938:     */       
/*  939: 834 */       to.setCodigoempleado(this.txtCodigo.getText());
/*  940: 835 */       to.setTipoUsuario(this.cboAreaTrb.getSelectedItem().toString());
/*  941: 836 */       to.setDNI(this.txtDni.getText());
/*  942: 837 */       to.setApellidos(this.txtApellidos.getText());
/*  943: 838 */       to.setNombres(this.txtNombres.getText());
/*  944: 839 */       to.setDireccion(this.txtDireccion.getText());
/*  945: 840 */       to.setCorreo(this.txtEmail.getText());
/*  946: 841 */       to.setTelefono(this.txtTelefono.getText());
/*  947: 842 */       to.setSueldo(Double.parseDouble(this.txtSueldo.getText()));
/*  948: 843 */       this.oEmplaDao.ModificarEmpleado(to);
/*  949: 844 */       mensaje = "SE modifocaron los datos Correctamente...";
/*  950:     */       
/*  951: 846 */       JOptionPane.showMessageDialog(this.rootPane, mensaje);
/*  952: 847 */       habilitaControles(false);
/*  953: 848 */       limpiaControles();
/*  954: 849 */       getRootPane().setDefaultButton(this.btnNuevo);
/*  955:     */     }
/*  956:     */     catch (Exception e)
/*  957:     */     {
/*  958: 851 */       System.out.println(e.getMessage());
/*  959:     */     }
/*  960:     */   }
/*  961:     */   
/*  962:     */   private void btnEliminarActionPerformed(ActionEvent evt)
/*  963:     */   {
/*  964:     */     try
/*  965:     */     {
/*  966: 857 */       empleado_TO to = new empleado_TO();
/*  967:     */       
/*  968:     */ 
/*  969: 860 */       int opc = JOptionPane.showConfirmDialog(this, "desea  eliminar...", "Cuadro de advertencia", 0, 3);
/*  970: 861 */       if (opc == 0)
/*  971:     */       {
/*  972: 862 */         to.setCodigoempleado(this.txtCodigo.getText());
/*  973: 863 */         this.oEmplaDao.EliminarEmpleado(to);
/*  974:     */       }
/*  975: 865 */       JOptionPane.showMessageDialog(this.rootPane, "Se elimino el empleado ...");
/*  976: 866 */       limpiaControles();
/*  977:     */     }
/*  978:     */     catch (Exception e) {}
/*  979:     */   }
/*  980:     */   
/*  981:     */   private void tblRegistrosMouseClicked(MouseEvent evt)
/*  982:     */   {
/*  983: 872 */     muestraRegistro();
/*  984:     */   }
/*  985:     */   
/*  986:     */   private void tblRegistrosEmplMouseClicked(MouseEvent evt)
/*  987:     */   {
/*  988: 885 */     muestraRegistro();
/*  989:     */   }
/*  990:     */   
/*  991:     */   private void btnRegistrarActionPerformed(ActionEvent evt)
/*  992:     */   {
/*  993:     */     try
/*  994:     */     {
/*  995: 890 */       empleado_TO toempl = new empleado_TO();
/*  996:     */       
/*  997: 892 */       String idUsuario = this.txtIDEusuario.getText();
/*  998: 893 */       String contraseña = this.txtContraseña_R.getText();
/*  999: 894 */       String contraseña2 = this.txtContraseña_V.getText();
/* 1000:     */       
/* 1001: 896 */       toempl.setTipoUsuario(this.cboTipoUsuario.getSelectedItem().toString());
/* 1002: 897 */       toempl.setDNI(this.txtDNI.getText());
/* 1003: 898 */       toempl.setApellidos(this.txtApellidos_R_empleado.getText().toUpperCase());
/* 1004: 899 */       toempl.setNombres(this.txtNombres_R_empleado.getText().toUpperCase());
/* 1005: 900 */       if (this.rbFeme.isSelected()) {
/* 1006: 901 */         toempl.setSexo("F");
/* 1007:     */       } else {
/* 1008: 903 */         toempl.setSexo("M");
/* 1009:     */       }
/* 1010: 905 */       toempl.setDireccion(this.txtDireccion_R_empleado.getText().toUpperCase());
/* 1011: 906 */       toempl.setCorreo(this.txtEmail_R_empleado.getText());
/* 1012: 907 */       toempl.setTelefono(this.txtTelefono_R_empleado.getText());
/* 1013: 908 */       toempl.setSueldo(Double.parseDouble(this.txtSueldo_R_empleado.getText()));
/* 1014: 910 */       if ((idUsuario.isEmpty()) || (contraseña.isEmpty()) || (contraseña2.isEmpty()))
/* 1015:     */       {
/* 1016: 911 */         JOptionPane.showMessageDialog(this.rootPane, "No se permiten campos nulos");
/* 1017:     */       }
/* 1018:     */       else
/* 1019:     */       {
/* 1020: 913 */         toempl.setId(idUsuario);
/* 1021: 914 */         if (contraseña.equals(contraseña2)) {
/* 1022: 915 */           toempl.setContraseña(this.txtContraseña_V.getText());
/* 1023:     */         } else {
/* 1024: 917 */           JOptionPane.showMessageDialog(this.rootPane, "Las contraseña no coinciden ... verifique");
/* 1025:     */         }
/* 1026:     */       }
/* 1027: 921 */       this.oEmplaDao.RegistrarEmpleado(toempl);
/* 1028: 922 */       JOptionPane.showMessageDialog(this.rootPane, this.txtApellidos_R_empleado.getText() + " " + this.txtNombres_R_empleado.getText() + " Fue Registrado correctamente");
/* 1029: 923 */       btnRegistros(false);
/* 1030:     */     }
/* 1031:     */     catch (Exception e)
/* 1032:     */     {
/* 1033: 925 */       JOptionPane.showMessageDialog(this.rootPane, "Error en el registro En : \n" + e);
/* 1034:     */     }
/* 1035:     */   }
/* 1036:     */   
/* 1037:     */   private void btnExitActionPerformed(ActionEvent evt)
/* 1038:     */   {
/* 1039: 931 */     dispose();
/* 1040:     */   }
/* 1041:     */   
/* 1042:     */   private void txtDNIKeyTyped(KeyEvent evt)
/* 1043:     */   {
/* 1044: 935 */     char c = evt.getKeyChar();
/* 1045: 936 */     if ((c < '0') || (c > '9')) {
/* 1046: 937 */       evt.consume();
/* 1047:     */     }
/* 1048:     */   }
/* 1049:     */   
/* 1050:     */   private void txtTelefono_R_empleadoKeyTyped(KeyEvent evt)
/* 1051:     */   {
/* 1052: 942 */     char c = evt.getKeyChar();
/* 1053: 943 */     if ((c < '0') || (c > '9')) {
/* 1054: 944 */       evt.consume();
/* 1055:     */     }
/* 1056:     */   }
/* 1057:     */   
/* 1058:     */   private void btnVerVentasActionPerformed(ActionEvent evt)
/* 1059:     */   {
/* 1060:     */     try
/* 1061:     */     {
/* 1062: 950 */       ventas_vendedorDesk g = new ventas_vendedorDesk();
/* 1063: 951 */       ventas_vendedorDesk.lblCodigo_vendedor.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 0).toString());
/* 1064: 952 */       ventas_vendedorDesk.txtApellidos_Nombres.setText(this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 3).toString() + " " + this.tblRegistros.getValueAt(this.tblRegistros.getSelectedRow(), 2).toString());
/* 1065: 953 */       VentanaPrincipalGUI.desk.add(g);
/* 1066: 954 */       g.show();
/* 1067:     */     }
/* 1068:     */     catch (Exception e)
/* 1069:     */     {
/* 1070: 956 */       System.out.println(e);
/* 1071:     */     }
/* 1072:     */   }
/* 1073:     */   
/* 1074:     */   private void habilitaControles(boolean b)
/* 1075:     */   {
/* 1076:1031 */     JButton[] btn = { this.btnEliminar, this.btnNuevo, this.btnSalir, this.btnModificar };
/* 1077:1034 */     for (JButton bton : btn) {
/* 1078:1035 */       bton.setEnabled(!b);
/* 1079:     */     }
/* 1080:1037 */     this.btnGrabar.setEnabled(b);
/* 1081:1038 */     this.btnCancelar.setEnabled(b);
/* 1082:     */     
/* 1083:1040 */     JTextField[] txt = { this.txtDni, this.txtApellidos, this.txtDireccion, this.txtEmail, this.txtNombres, this.txtTelefono };
/* 1084:1043 */     for (JTextField txtx : txt) {
/* 1085:1044 */       txtx.setEditable(b);
/* 1086:     */     }
/* 1087:1046 */     this.txtDni.grabFocus();
/* 1088:     */   }
/* 1089:     */   
/* 1090:     */   private void limpiaControles()
/* 1091:     */   {
/* 1092:1051 */     this.txtApellidos.setText(null);
/* 1093:1052 */     this.txtCodigo.setText(null);
/* 1094:1053 */     this.txtDireccion.setText(null);
/* 1095:1054 */     this.txtDni.setText(null);
/* 1096:1055 */     this.txtEmail.setText(null);
/* 1097:1056 */     this.txtNombres.setText(null);
/* 1098:1057 */     this.txtTelefono.setText(null);
/* 1099:1058 */     this.txtDni.grabFocus();
/* 1100:     */   }
/* 1101:     */   
/* 1102:     */   private void muestraRegistro()
/* 1103:     */   {
/* 1104:1062 */     this.txtCodigo.setText(this.tblRegistrosEmpl.getValueAt(this.tblRegistrosEmpl.getSelectedRow(), 0).toString());
/* 1105:1063 */     this.txtDni.setText(this.tblRegistrosEmpl.getValueAt(this.tblRegistrosEmpl.getSelectedRow(), 1).toString());
/* 1106:1064 */     this.txtApellidos.setText(this.tblRegistrosEmpl.getValueAt(this.tblRegistrosEmpl.getSelectedRow(), 2).toString());
/* 1107:1065 */     this.txtNombres.setText(this.tblRegistrosEmpl.getValueAt(this.tblRegistrosEmpl.getSelectedRow(), 3).toString());
/* 1108:1066 */     this.txtDireccion.setText(this.tblRegistrosEmpl.getValueAt(this.tblRegistrosEmpl.getSelectedRow(), 4).toString());
/* 1109:1067 */     this.txtEmail.setText(this.tblRegistrosEmpl.getValueAt(this.tblRegistrosEmpl.getSelectedRow(), 5).toString());
/* 1110:1068 */     this.txtTelefono.setText(this.tblRegistrosEmpl.getValueAt(this.tblRegistrosEmpl.getSelectedRow(), 6).toString());
/* 1111:1069 */     this.cboAreaTrb.removeAllItems();
/* 1112:1070 */     this.cboAreaTrb.addItem(this.tblRegistrosEmpl.getValueAt(this.tblRegistrosEmpl.getSelectedRow(), 7).toString());
/* 1113:1071 */     this.txtSueldo.setText(this.tblRegistrosEmpl.getValueAt(this.tblRegistrosEmpl.getSelectedRow(), 8).toString());
/* 1114:     */     
/* 1115:1073 */     muestraImagen();
/* 1116:     */   }
/* 1117:     */   
/* 1118:     */   private void muestraImagen()
/* 1119:     */   {
/* 1120:1077 */     ImageIcon[] imagen = new ImageIcon[100];
/* 1121:1078 */     long cadena = 100000L;
/* 1122:     */     
/* 1123:1080 */     long cod = Long.parseLong(this.tblRegistrosEmpl.getValueAt(this.tblRegistrosEmpl.getSelectedRow(), 0).toString());
/* 1124:1081 */     for (int i = 1; i < 100; i++)
/* 1125:     */     {
/* 1126:1082 */       int a = (int)(cadena + i);
/* 1127:1083 */       imagen[i] = new ImageIcon("C:/LEDATEL/Foto/" + a + ".jpg");
/* 1128:1084 */       System.out.println(i);
/* 1129:     */     }
/* 1130:1086 */     for (int vista = 1; vista < 100; vista++)
/* 1131:     */     {
/* 1132:1087 */       long codigo = cadena + vista;
/* 1133:1088 */       if (cod == codigo) {
/* 1134:1089 */         this.lblFoto.setIcon(imagen[vista]);
/* 1135:     */       }
/* 1136:1091 */       System.out.println(codigo);
/* 1137:     */     }
/* 1138:     */   }
/* 1139:     */   
/* 1140:     */   private void cbo()
/* 1141:     */   {
/* 1142:1096 */     this.cboAreaTrb.removeAllItems();
/* 1143:1097 */     this.cboAreaTrb.addItem("Administrador");
/* 1144:1098 */     this.cboAreaTrb.addItem("Limpiza");
/* 1145:1099 */     this.cboAreaTrb.addItem("Tecnica");
/* 1146:1100 */     this.cboAreaTrb.addItem("Vendedor");
/* 1147:     */   }
/* 1148:     */   
/* 1149:     */   private void btnRegistros(boolean b)
/* 1150:     */   {
/* 1151:1104 */     JTextField[] txt = { this.txtTelefono_R_empleado, this.txtDNI, this.txtApellidos_R_empleado, this.txtDireccion_R_empleado, this.txtApellidos_R_empleado, this.txtContraseña_R, this.txtContraseña_V, this.txtEmail_R_empleado, this.txtIDEusuario, this.txtNombres_R_empleado, this.txtSueldo_R_empleado, this.txtSueldo_R_empleado };
/* 1152:1107 */     for (JTextField field : txt)
/* 1153:     */     {
/* 1154:1108 */       field.setEditable(b);
/* 1155:1109 */       field.setText("");
/* 1156:     */     }
/* 1157:1111 */     this.btnRegistrar.setEnabled(b);
/* 1158:1112 */     this.btnNuevo.setEnabled(!b);
/* 1159:1113 */     this.txtDNI.grabFocus();
/* 1160:     */   }
/* 1161:     */ }



/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar

 * Qualified Name:     Desk.empleadoDesk

 * JD-Core Version:    0.7.0.1

 */