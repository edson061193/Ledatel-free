/*   1:    */ package Desk;
/*   2:    */ 
/*   3:    */ import Dao.boletaDao;
/*   4:    */ import java.awt.Container;
/*   5:    */ import java.awt.event.ActionEvent;
/*   6:    */ import java.awt.event.ActionListener;
/*   7:    */ import java.io.PrintStream;
/*   8:    */ import java.sql.ResultSet;
/*   9:    */ import javax.swing.GroupLayout;
/*  10:    */ import javax.swing.GroupLayout.Alignment;
/*  11:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  12:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  13:    */ import javax.swing.JButton;
/*  14:    */ import javax.swing.JInternalFrame;
/*  15:    */ import javax.swing.JLabel;
/*  16:    */ import javax.swing.JScrollPane;
/*  17:    */ import javax.swing.JTable;
/*  18:    */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*  19:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  20:    */ import javax.swing.table.DefaultTableModel;
/*  21:    */ 
/*  22:    */ public class rDetalleDesk
/*  23:    */   extends JInternalFrame
/*  24:    */ {
/*  25:    */   ResultSet rs;
/*  26:    */   DefaultTableModel model;
/*  27: 20 */   boletaDao oBoleta = new boletaDao();
/*  28:    */   private JButton jButton1;
/*  29:    */   private JLabel jLabel1;
/*  30:    */   private JLabel jLabel2;
/*  31:    */   private JLabel jLabel3;
/*  32:    */   private JScrollPane jScrollPane1;
/*  33:    */   private JTable tblRegistro;
/*  34:    */   private JTextField txtCliente;
/*  35:    */   public static JTextField txtFactura;
/*  36:    */   private JTextField txtVendedor;
/*  37:    */   
/*  38:    */   public rDetalleDesk()
/*  39:    */   {
/*  40: 23 */     initComponents();
/*  41:    */   }
/*  42:    */   
/*  43:    */   private void initComponents()
/*  44:    */   {
/*  45: 37 */     txtFactura = new JTextField();
/*  46: 38 */     this.jLabel1 = new JLabel();
/*  47: 39 */     this.jLabel2 = new JLabel();
/*  48: 40 */     this.jLabel3 = new JLabel();
/*  49: 41 */     this.txtCliente = new JTextField();
/*  50: 42 */     this.txtVendedor = new JTextField();
/*  51: 43 */     this.jScrollPane1 = new JScrollPane();
/*  52: 44 */     this.tblRegistro = new JTable();
/*  53: 45 */     this.jButton1 = new JButton();
/*  54:    */     
/*  55: 47 */     setClosable(true);
/*  56: 48 */     setMaximizable(true);
/*  57:    */     
/*  58: 50 */     this.jLabel1.setText("BOLETA:");
/*  59:    */     
/*  60: 52 */     this.jLabel2.setText("CLIENTE:");
/*  61:    */     
/*  62: 54 */     this.jLabel3.setText("VENDEDOR:");
/*  63:    */     
/*  64: 56 */     this.tblRegistro.setModel(new DefaultTableModel(new Object[0][], new String[] { "MARCA", "SERIE", "PRECIO", "CANTIDAD", "IMPORTE" })
/*  65:    */     {
/*  66: 64 */       Class[] types = { Object.class, Object.class, Double.class, Integer.class, Double.class };
/*  67:    */       
/*  68:    */       public Class getColumnClass(int columnIndex)
/*  69:    */       {
/*  70: 69 */         return this.types[columnIndex];
/*  71:    */       }
/*  72: 71 */     });
/*  73: 72 */     this.jScrollPane1.setViewportView(this.tblRegistro);
/*  74:    */     
/*  75: 74 */     this.jButton1.setText("buscar");
/*  76: 75 */     this.jButton1.addActionListener(new ActionListener()
/*  77:    */     {
/*  78:    */       public void actionPerformed(ActionEvent evt)
/*  79:    */       {
/*  80: 77 */         rDetalleDesk.this.jButton1ActionPerformed(evt);
/*  81:    */       }
/*  82: 80 */     });
/*  83: 81 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  84: 82 */     getContentPane().setLayout(layout);
/*  85: 83 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(9, 9, 9).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(txtFactura, -2, 112, -2).addGap(10, 10, 10).addComponent(this.jButton1).addGap(18, 18, 18).addComponent(this.jLabel2).addGap(18, 18, 18).addComponent(this.txtCliente, -2, 237, -2).addGap(59, 59, 59).addComponent(this.jLabel3).addGap(18, 18, 18).addComponent(this.txtVendedor, -2, 172, -2).addContainerGap(131, 32767)).addComponent(this.jScrollPane1));
/*  86:    */     
/*  87:    */ 
/*  88:    */ 
/*  89:    */ 
/*  90:    */ 
/*  91:    */ 
/*  92:    */ 
/*  93:    */ 
/*  94:    */ 
/*  95:    */ 
/*  96:    */ 
/*  97:    */ 
/*  98:    */ 
/*  99:    */ 
/* 100:    */ 
/* 101:    */ 
/* 102:    */ 
/* 103:    */ 
/* 104:    */ 
/* 105:103 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(txtFactura, -2, -1, -2).addComponent(this.jLabel1).addComponent(this.jLabel2).addComponent(this.jLabel3).addComponent(this.txtCliente, -2, -1, -2).addComponent(this.txtVendedor, -2, -1, -2).addComponent(this.jButton1)).addGap(18, 18, 18).addComponent(this.jScrollPane1, -2, 169, -2)));
/* 106:    */     
/* 107:    */ 
/* 108:    */ 
/* 109:    */ 
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
/* 121:119 */     pack();
/* 122:    */   }
/* 123:    */   
/* 124:    */   private void jButton1ActionPerformed(ActionEvent evt)
/* 125:    */   {
/* 126:    */     try
/* 127:    */     {
/* 128:124 */       cargaRegistros();
/* 129:    */     }
/* 130:    */     catch (Exception e) {}
/* 131:    */   }
/* 132:    */   
/* 133:    */   public void cargaRegistros()
/* 134:    */     throws Exception
/* 135:    */   {
/* 136:    */     try
/* 137:    */     {
/* 138:144 */       String factura = txtFactura.getText();
/* 139:145 */       this.model = ((DefaultTableModel)this.tblRegistro.getModel());
/* 140:146 */       this.rs = this.oBoleta.listaDetalle(factura);
/* 141:147 */       while (this.rs.next())
/* 142:    */       {
/* 143:148 */         Object[] resul = { this.rs.getString(2), this.rs.getString(3), this.rs.getString(4), this.rs.getString(5), this.rs.getString(6) };
/* 144:    */         
/* 145:    */ 
/* 146:    */ 
/* 147:    */ 
/* 148:    */ 
/* 149:    */ 
/* 150:155 */         this.txtCliente.setText(this.rs.getString(7));
/* 151:156 */         this.txtVendedor.setText(this.rs.getString(8));
/* 152:157 */         this.model.addRow(resul);
/* 153:    */       }
/* 154:    */     }
/* 155:    */     catch (Exception e)
/* 156:    */     {
/* 157:160 */       System.out.println(e);
/* 158:    */     }
/* 159:    */   }
/* 160:    */ }



/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar

 * Qualified Name:     Desk.rDetalleDesk

 * JD-Core Version:    0.7.0.1

 */