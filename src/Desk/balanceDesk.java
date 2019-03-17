/*   1:    */ package Desk;
/*   2:    */ 
/*   3:    */ import Dao.gastosServiciosDAO;
/*   4:    */ import datechooser.beans.DateChooserCombo;
/*   5:    */ import datechooser.events.CommitEvent;
/*   6:    */ import datechooser.events.CommitListener;
/*   7:    */ import java.awt.Color;
/*   8:    */ import java.awt.Container;
/*   9:    */ import java.awt.Dimension;
/*  10:    */ import java.awt.Font;
/*  11:    */ import java.awt.event.ActionEvent;
/*  12:    */ import java.awt.event.ActionListener;
/*  13:    */ import java.io.PrintStream;
/*  14:    */ import java.sql.ResultSet;
/*  15:    */ import java.util.Locale;
/*  16:    */ import javax.swing.BorderFactory;
/*  17:    */ import javax.swing.GroupLayout;
/*  18:    */ import javax.swing.GroupLayout.Alignment;
/*  19:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  20:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  21:    */ import javax.swing.JButton;
/*  22:    */ import javax.swing.JInternalFrame;
/*  23:    */ import javax.swing.JLabel;
/*  24:    */ import javax.swing.JPanel;
/*  25:    */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*  26:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  27:    */ 
/*  28:    */ public class balanceDesk
/*  29:    */   extends JInternalFrame
/*  30:    */ {
/*  31:    */   ResultSet rs;
/*  32: 18 */   gastosServiciosDAO Ogastos = new gastosServiciosDAO();
/*  33:    */   double totalServ;
/*  34:    */   double totalcompras;
/*  35: 20 */   private static balanceDesk fromBalance = null;
/*  36:    */   private JButton btnBuscar;
/*  37:    */   private JButton btnCalculo2;
/*  38:    */   private JButton btnCalculoOtrosPagos;
/*  39:    */   private DateChooserCombo dateFechaFinal;
/*  40:    */   private DateChooserCombo dateFechaInicial;
/*  41:    */   private JLabel jLabel1;
/*  42:    */   private JLabel jLabel10;
/*  43:    */   private JLabel jLabel11;
/*  44:    */   private JLabel jLabel12;
/*  45:    */   private JLabel jLabel13;
/*  46:    */   private JLabel jLabel14;
/*  47:    */   private JLabel jLabel15;
/*  48:    */   private JLabel jLabel16;
/*  49:    */   private JLabel jLabel2;
/*  50:    */   private JLabel jLabel4;
/*  51:    */   private JLabel jLabel5;
/*  52:    */   private JLabel jLabel6;
/*  53:    */   private JLabel jLabel7;
/*  54:    */   private JLabel jLabel8;
/*  55:    */   private JLabel jLabel9;
/*  56:    */   private JPanel jPanel1;
/*  57:    */   private JPanel jPanel2;
/*  58:    */   private JPanel jPanel3;
/*  59:    */   private JPanel jPanel4;
/*  60:    */   private JPanel jPanel5;
/*  61:    */   private JLabel lblFechaActual;
/*  62:    */   private JTextField txtAguaPotable;
/*  63:    */   private JTextField txtCompras;
/*  64:    */   private JTextField txtGanancia;
/*  65:    */   private JTextField txtOtrosServicios;
/*  66:    */   private JTextField txtPagoAlquileres;
/*  67:    */   private JTextField txtPagoEmpleado;
/*  68:    */   private JTextField txtPagoEnergia;
/*  69:    */   private JTextField txtReparaciones;
/*  70:    */   private JTextField txtTotalCompras;
/*  71:    */   private JTextField txtTotalPagosServ;
/*  72:    */   private JTextField txtTotalServicios;
/*  73:    */   private JTextField txtTotalVentas;
/*  74:    */   private JTextField txtVentas;
/*  75:    */   
/*  76:    */   public static balanceDesk getForm()
/*  77:    */   {
/*  78: 23 */     if (fromBalance == null) {
/*  79: 24 */       fromBalance = new balanceDesk();
/*  80:    */     }
/*  81: 26 */     return fromBalance;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public balanceDesk()
/*  85:    */   {
/*  86: 30 */     initComponents();
/*  87:    */   }
/*  88:    */   
/*  89:    */   private void initComponents()
/*  90:    */   {
/*  91: 42 */     this.jPanel1 = new JPanel();
/*  92: 43 */     this.jLabel6 = new JLabel();
/*  93: 44 */     this.btnBuscar = new JButton();
/*  94: 45 */     this.dateFechaFinal = new DateChooserCombo();
/*  95: 46 */     this.dateFechaInicial = new DateChooserCombo();
/*  96: 47 */     this.jLabel8 = new JLabel();
/*  97: 48 */     this.lblFechaActual = new JLabel();
/*  98: 49 */     this.jPanel2 = new JPanel();
/*  99: 50 */     this.jLabel1 = new JLabel();
/* 100: 51 */     this.txtCompras = new JTextField();
/* 101: 52 */     this.jPanel3 = new JPanel();
/* 102: 53 */     this.jLabel4 = new JLabel();
/* 103: 54 */     this.txtVentas = new JTextField();
/* 104: 55 */     this.jLabel2 = new JLabel();
/* 105: 56 */     this.txtReparaciones = new JTextField();
/* 106: 57 */     this.jPanel4 = new JPanel();
/* 107: 58 */     this.jLabel5 = new JLabel();
/* 108: 59 */     this.jLabel7 = new JLabel();
/* 109: 60 */     this.jLabel9 = new JLabel();
/* 110: 61 */     this.jLabel10 = new JLabel();
/* 111: 62 */     this.txtPagoEmpleado = new JTextField();
/* 112: 63 */     this.txtPagoAlquileres = new JTextField();
/* 113: 64 */     this.txtPagoEnergia = new JTextField();
/* 114: 65 */     this.txtAguaPotable = new JTextField();
/* 115: 66 */     this.btnCalculoOtrosPagos = new JButton();
/* 116: 67 */     this.jLabel11 = new JLabel();
/* 117: 68 */     this.txtOtrosServicios = new JTextField();
/* 118: 69 */     this.txtTotalServicios = new JTextField();
/* 119: 70 */     this.jLabel12 = new JLabel();
/* 120: 71 */     this.jPanel5 = new JPanel();
/* 121: 72 */     this.btnCalculo2 = new JButton();
/* 122: 73 */     this.jLabel13 = new JLabel();
/* 123: 74 */     this.jLabel14 = new JLabel();
/* 124: 75 */     this.jLabel15 = new JLabel();
/* 125: 76 */     this.txtTotalCompras = new JTextField();
/* 126: 77 */     this.txtTotalVentas = new JTextField();
/* 127: 78 */     this.txtTotalPagosServ = new JTextField();
/* 128: 79 */     this.jLabel16 = new JLabel();
/* 129: 80 */     this.txtGanancia = new JTextField();
/* 130:    */     
/* 131: 82 */     setClosable(true);
/* 132: 83 */     setIconifiable(true);
/* 133: 84 */     setTitle("Balance de gastos y ganancias mensuales");
/* 134:    */     
/* 135: 86 */     this.jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
/* 136:    */     
/* 137: 88 */     this.jLabel6.setText("Fecha Inicial :");
/* 138:    */     
/* 139: 90 */     this.btnBuscar.setText("Procesar");
/* 140: 91 */     this.btnBuscar.addActionListener(new ActionListener()
/* 141:    */     {
/* 142:    */       public void actionPerformed(ActionEvent evt)
/* 143:    */       {
/* 144: 93 */         balanceDesk.this.btnBuscarActionPerformed(evt);
/* 145:    */       }
/* 146: 96 */     });
/* 147: 97 */     this.dateFechaFinal.setCalendarBackground(new Color(204, 255, 255));
/* 148: 98 */     this.dateFechaFinal.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 149: 99 */     this.dateFechaFinal.setCalendarPreferredSize(new Dimension(441, 270));
/* 150:100 */     this.dateFechaFinal.setNothingAllowed(false);
/* 151:101 */     this.dateFechaFinal.setLocale(new Locale("pt", "BR", ""));
/* 152:102 */     this.dateFechaFinal.addCommitListener(new CommitListener()
/* 153:    */     {
/* 154:    */       public void onCommit(CommitEvent evt)
/* 155:    */       {
/* 156:104 */         balanceDesk.this.dateFechaFinalOnCommit(evt);
/* 157:    */       }
/* 158:107 */     });
/* 159:108 */     this.dateFechaInicial.setCalendarBackground(new Color(204, 255, 255));
/* 160:109 */     this.dateFechaInicial.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 161:110 */     this.dateFechaInicial.setCalendarPreferredSize(new Dimension(441, 270));
/* 162:111 */     this.dateFechaInicial.setNothingAllowed(false);
/* 163:112 */     this.dateFechaInicial.setLocale(new Locale("pt", "BR", ""));
/* 164:113 */     this.dateFechaInicial.addCommitListener(new CommitListener()
/* 165:    */     {
/* 166:    */       public void onCommit(CommitEvent evt)
/* 167:    */       {
/* 168:115 */         balanceDesk.this.dateFechaInicialOnCommit(evt);
/* 169:    */       }
/* 170:118 */     });
/* 171:119 */     this.jLabel8.setText("Fecha Final:");
/* 172:    */     
/* 173:121 */     this.lblFechaActual.setFont(new Font("sansserif", 1, 24));
/* 174:122 */     this.lblFechaActual.setHorizontalAlignment(0);
/* 175:123 */     this.lblFechaActual.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)), "Fecha Actual:"));
/* 176:    */     
/* 177:125 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 178:126 */     this.jPanel1.setLayout(jPanel1Layout);
/* 179:127 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.dateFechaInicial, -2, 236, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel8).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.dateFechaFinal, -2, 236, -2))).addGap(18, 18, 18).addComponent(this.btnBuscar).addGap(68, 68, 68).addComponent(this.lblFechaActual, -2, 106, -2).addContainerGap(-1, 32767)));
 jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblFechaActual, -2, 60, -2).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel6).addComponent(this.dateFechaInicial, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel8).addComponent(this.dateFechaFinal, -2, -1, -2))).addComponent(this.btnBuscar, -2, 62, -2)).addContainerGap(-1, 32767)));
    this.jPanel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2), "Compras: $", 1, 2));
    this.jLabel1.setText("Mobiles/ Otros: $");
   this.txtCompras.setText("0.00");
GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 223:171 */     this.jPanel2.setLayout(jPanel2Layout);
/* 224:172 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel1).addGap(49, 49, 49).addComponent(this.txtCompras, -2, 120, -2).addGap(0, 56, 32767)));
  jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.txtCompras, -2, -1, -2)).addContainerGap(71, 32767)));
 this.jPanel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2), "Ventas: $", 3, 2));
  this.jLabel4.setText("Total en Ventas:$");
  this.txtVentas.setText("0.00");
 this.jLabel2.setText("Total en reparaciones :$");
 this.txtReparaciones.setText("0.00");
 GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 253:201 */     this.jPanel3.setLayout(jPanel3Layout);
/* 254:202 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtVentas, -2, 207, -2).addGap(0, 0, 32767)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel2).addGap(18, 18, 18).addComponent(this.txtReparaciones))).addContainerGap()));
jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.txtVentas, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.txtReparaciones, -2, -1, -2)).addContainerGap(-1, 32767)));
this.jPanel4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2), "Pagos de Empleados y  otros Servicios", 2, 2));
 this.jLabel5.setText("Empleados          $");
  this.jLabel7.setText("Alquileres:            $");
   this.jLabel9.setText("Energia Electrica:$");
     this.jLabel10.setText("Agua Potable:        $");
    this.txtPagoEmpleado.setText("0.0");
   this.txtPagoAlquileres.setText("0.00");
 this.txtPagoEnergia.setText("0.00");
    this.txtAguaPotable.setText("0.00");
   this.btnCalculoOtrosPagos.setText("C a l c u l a r");
     this.btnCalculoOtrosPagos.addActionListener(new ActionListener()
/* 304:    */     {
/* 305:    */       public void actionPerformed(ActionEvent evt)
/* 306:    */       {
/* 307:253 */         balanceDesk.this.btnCalculoOtrosPagosActionPerformed(evt);
/* 308:    */       }
/* 309:256 */     });
/* 310:257 */     this.jLabel11.setText("Otros servicios: $");
/* 311:    */     
/* 312:259 */     this.txtOtrosServicios.setText("0.00");
/* 313:    */     
/* 314:261 */     this.txtTotalServicios.setText("0.00");
/* 315:    */     
/* 316:263 */     this.jLabel12.setFont(new Font("Khmer UI", 1, 24));
/* 317:264 */     this.jLabel12.setText("T O T A L : $");
/* 318:    */     
/* 319:266 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 320:267 */     this.jPanel4.setLayout(jPanel4Layout);
/* 321:268 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel10).addComponent(this.jLabel9).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel5).addComponent(this.jLabel7)))).addGap(28, 28, 28).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtPagoEmpleado).addComponent(this.txtPagoAlquileres).addComponent(this.txtPagoEnergia).addComponent(this.txtAguaPotable, -1, 134, 32767)).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(35, 35, 35).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtTotalServicios).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel11).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtOtrosServicios))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel12).addGap(64, 64, 64))).addComponent(this.btnCalculoOtrosPagos).addContainerGap()));
  jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(9, 9, 9).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.txtPagoEmpleado, -2, -1, -2).addComponent(this.jLabel11).addComponent(this.txtOtrosServicios, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.txtPagoAlquileres, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtPagoEnergia, -2, -1, -2).addComponent(this.jLabel9).addComponent(this.jLabel12)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel10).addComponent(this.txtAguaPotable, -2, -1, -2).addComponent(this.txtTotalServicios, -2, -1, -2)).addContainerGap(17, 32767)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.btnCalculoOtrosPagos, -1, -1, 32767).addContainerGap()));
  this.jPanel5.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2), "Sumaroria de Gastos/Pagos/ventas", 2, 2));
    this.btnCalculo2.setText("C a l c u l a r");
/* 387:334 */     this.btnCalculo2.addActionListener(new ActionListener()
/* 388:    */     {
/* 389:    */       public void actionPerformed(ActionEvent evt)
/* 390:    */       {
/* 391:336 */         balanceDesk.this.btnCalculo2ActionPerformed(evt);
/* 392:    */       }
/* 393:339 */     });
/* 394:340 */     this.jLabel13.setText("Compras :               $");
    this.jLabel14.setText("Ventas     :                $");
     this.jLabel15.setText("Pagos y servicios : $");
    this.txtTotalCompras.setText("0.00");
     this.txtTotalVentas.setText("0.00");
    this.txtTotalPagosServ.setText("0.00");
   this.jLabel16.setFont(new Font("Khmer UI", 1, 24));
/* 407:353 */     this.jLabel16.setText("Ganancias : $");
     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 410:356 */     this.jPanel5.setLayout(jPanel5Layout);
/* 411:357 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.btnCalculo2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jLabel13).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtTotalCompras, -2, 122, -2)).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jLabel14).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtTotalVentas)).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jLabel15).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtTotalPagosServ))).addGap(18, 18, 18).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(0, 2, 32767).addComponent(this.jLabel16)).addComponent(this.txtGanancia)).addGap(123, 123, 123)));
jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnCalculo2, -1, -1, 32767).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel13).addComponent(this.txtTotalCompras, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel14).addComponent(this.txtTotalVentas, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel15).addComponent(this.txtTotalPagosServ, -2, -1, -2))).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jLabel16).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtGanancia, -2, 44, -2))).addGap(0, 22, 32767))).addContainerGap()));
GroupLayout layout = new GroupLayout(getContentPane());
/* 467:413 */     getContentPane().setLayout(layout);
/* 468:414 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jPanel3, -2, -1, -2)).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel4, -1, -1, 32767).addComponent(this.jPanel5, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel3, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel5, -2, -1, -2).addGap(0, 0, 32767)));
 pack();
/* 498:    */   }
  private void btnBuscarActionPerformed(ActionEvent evt)
/* 501:    */   {
/* 502:    */     try
/* 503:    */     {
/* 504:450 */       String nuevoAño = "";
/* 505:451 */       String año = this.dateFechaInicial.getText().substring(6);
/* 506:452 */       String mes = this.dateFechaInicial.getText().substring(3, 5);
/* 507:453 */       String dia = this.dateFechaInicial.getText().substring(0, 2);
/* 508:454 */       if (año.equals("00")) {
/* 509:455 */         nuevoAño = "2000-";
/* 510:    */       }
/* 511:457 */       nuevoAño = "20" + año + "-";
/* 512:458 */       String nuevomes = mes + "-";
/* 513:459 */       String año2 = this.dateFechaFinal.getText().substring(6);
/* 514:460 */       String mes2 = this.dateFechaFinal.getText().substring(3, 5);
/* 515:461 */       String dia2 = this.dateFechaFinal.getText().substring(0, 2);
/* 516:462 */       String nuevoAño2 = "20" + año2 + "-";
/* 517:463 */       String nuevomes2 = mes2 + "-";
/* 518:464 */       String fechaIcinio = nuevoAño + nuevomes + dia;
/* 519:465 */       String fechaFinal = nuevoAño2 + nuevomes2 + dia2;
/* 520:    */       
/* 521:467 */       this.rs = this.Ogastos.cargaCompras(fechaIcinio, fechaFinal);
/* 522:468 */       while (this.rs.next()) {
/* 523:469 */         this.txtCompras.setText(String.valueOf(this.rs.getDouble(1)));
/* 524:    */       }
/* 525:472 */       this.rs = this.Ogastos.cargaventas(fechaIcinio, fechaFinal);
/* 526:473 */       while (this.rs.next()) {
/* 527:474 */         this.txtVentas.setText(String.valueOf(this.rs.getDouble(1)));
/* 528:    */       }
/* 529:476 */       this.rs = this.Ogastos.cargareparaciones(fechaIcinio, fechaFinal);
/* 530:477 */       while (this.rs.next()) {
/* 531:478 */         this.txtReparaciones.setText(String.valueOf(this.rs.getLong(1)));
/* 532:    */       }
/* 533:    */     }
/* 534:    */     catch (Exception e)
/* 535:    */     {
/* 536:483 */       System.out.println(e);
/* 537:    */     }
/* 538:    */   }
/* 539:    */   
/* 540:    */   private void dateFechaFinalOnCommit(CommitEvent evt) {}
/* 541:    */   
/* 542:    */   private void dateFechaInicialOnCommit(CommitEvent evt) {}
/* 543:    */   
/* 544:    */   private void btnCalculoOtrosPagosActionPerformed(ActionEvent evt)
/* 545:    */   {
/* 546:496 */     double pagoEmpleado = Double.parseDouble(this.txtPagoEmpleado.getText());
/* 547:497 */     double alquileres = Double.parseDouble(this.txtPagoAlquileres.getText());
/* 548:498 */     double energia = Double.parseDouble(this.txtPagoEnergia.getText());
/* 549:499 */     double aguapotable = Double.parseDouble(this.txtAguaPotable.getText());
/* 550:500 */     double otrosServicios = Double.parseDouble(this.txtOtrosServicios.getText());
/* 551:    */     
/* 552:502 */     this.totalServ = (pagoEmpleado + alquileres + energia + aguapotable + otrosServicios);
/* 553:503 */     this.txtTotalServicios.setText(String.valueOf(this.totalServ));
/* 554:    */   }
/* 555:    */   
/* 556:    */   private void btnCalculo2ActionPerformed(ActionEvent evt)
/* 557:    */   {
/* 558:508 */     double compras = Double.parseDouble(this.txtCompras.getText());
/* 559:509 */     double reparaciones = Double.parseDouble(this.txtReparaciones.getText());
/* 560:510 */     double ventas = Double.parseDouble(this.txtVentas.getText());
/* 561:511 */     this.totalcompras = compras;
/* 562:512 */     double totalventas = Double.parseDouble(this.txtReparaciones.getText()) + Double.parseDouble(this.txtVentas.getText());
/* 563:513 */     this.txtTotalPagosServ.setText(String.valueOf(this.totalServ));
/* 564:514 */     this.txtTotalCompras.setText(String.valueOf(this.totalcompras));
/* 565:515 */     this.txtTotalVentas.setText(String.valueOf(totalventas));
/* 566:516 */     double totalGanancias = totalventas - this.totalcompras - this.totalServ;
/* 567:517 */     this.txtGanancia.setText(String.valueOf(totalGanancias));
/* 568:    */   }
/* 569:    */ }




/* AUTOR:           EDSON J SUAREZ LOLI
 */