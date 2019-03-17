/*   1:    */ package Desk;
/*   2:    */ 
/*   3:    */ import datechooser.beans.DateChooserCombo;
/*   4:    */ import datechooser.events.CommitEvent;
/*   5:    */ import datechooser.events.CommitListener;
/*   6:    */ import datechooser.view.BackRenderer;
/*   7:    */ import datechooser.view.appearance.AppearancesList;
/*   8:    */ import datechooser.view.appearance.ViewAppearance;
/*   9:    */ import datechooser.view.appearance.swing.ButtonPainter;
/*  10:    */ import datechooser.view.appearance.swing.LabelPainter;
/*  11:    */ import datechooser.view.appearance.swing.SwingCellAppearance;
/*  12:    */ import java.awt.Color;
/*  13:    */ import java.awt.Container;
/*  14:    */ import java.awt.Dimension;
/*  15:    */ import java.awt.Font;
/*  16:    */ import java.sql.ResultSet;
/*  17:    */ import java.util.Locale;
/*  18:    */ import javax.swing.BorderFactory;
/*  19:    */ import javax.swing.GroupLayout;
/*  20:    */ import javax.swing.GroupLayout.Alignment;
/*  21:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  22:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  23:    */ import javax.swing.JButton;
/*  24:    */ import javax.swing.JInternalFrame;
/*  25:    */ import javax.swing.JLabel;
/*  26:    */ import javax.swing.JPanel;
/*  27:    */ import javax.swing.JScrollPane;
/*  28:    */ import javax.swing.JTable;
/*  29:    */ import javax.swing.JTextArea;
/*  30:    */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*  31:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  32:    */ import javax.swing.table.DefaultTableModel;
/*  33:    */ 
/*  34:    */ public class informacion_productoDesk
/*  35:    */   extends JInternalFrame
/*  36:    */ {
/*  37:    */   ResultSet resul;
/*  38:    */   DefaultTableModel model;
/*  39:    */   private JButton btnAnterior;
/*  40:    */   private JButton btnPrimero;
/*  41:    */   private JButton btnSiguiente;
/*  42:    */   private JButton btnUltimo;
/*  43:    */   private DateChooserCombo dateFechaInicial;
/*  44:    */   private JLabel jLabel1;
/*  45:    */   private JLabel jLabel2;
/*  46:    */   private JLabel jLabel3;
/*  47:    */   private JLabel jLabel4;
/*  48:    */   private JLabel jLabel5;
/*  49:    */   private JPanel jPanel1;
/*  50:    */   private JPanel jPanel2;
/*  51:    */   private JPanel jPanel3;
/*  52:    */   private JScrollPane jScrollPane1;
/*  53:    */   private JScrollPane jScrollPane2;
/*  54:    */   private JScrollPane jScrollPane3;
/*  55:    */   private JScrollPane jScrollPane4;
/*  56:    */   private JTable jTable1;
/*  57:    */   private JTextArea jTextArea1;
/*  58:    */   private JTextArea jTextArea2;
/*  59:    */   private JTextArea jTextArea3;
/*  60:    */   private JLabel lblImagen;
/*  61:    */   public static JTextField txtCodigo;
/*  62:    */   
/*  63:    */   public informacion_productoDesk()
/*  64:    */   {
/*  65: 14 */     initComponents();
/*  66:    */   }
/*  67:    */   
/*  68:    */   private void initComponents()
/*  69:    */   {
/*  70: 21 */     this.jPanel1 = new JPanel();
/*  71: 22 */     this.jPanel2 = new JPanel();
/*  72: 23 */     this.lblImagen = new JLabel();
/*  73: 24 */     this.btnPrimero = new JButton();
/*  74: 25 */     this.btnAnterior = new JButton();
/*  75: 26 */     this.btnSiguiente = new JButton();
/*  76: 27 */     this.btnUltimo = new JButton();
/*  77: 28 */     this.jLabel1 = new JLabel();
/*  78: 29 */     txtCodigo = new JTextField();
/*  79: 30 */     this.jScrollPane1 = new JScrollPane();
/*  80: 31 */     this.jTable1 = new JTable();
/*  81: 32 */     this.jPanel3 = new JPanel();
/*  82: 33 */     this.jLabel2 = new JLabel();
/*  83: 34 */     this.jLabel3 = new JLabel();
/*  84: 35 */     this.jLabel4 = new JLabel();
/*  85: 36 */     this.jLabel5 = new JLabel();
/*  86: 37 */     this.jScrollPane2 = new JScrollPane();
/*  87: 38 */     this.jTextArea1 = new JTextArea();
/*  88: 39 */     this.dateFechaInicial = new DateChooserCombo();
/*  89: 40 */     this.jScrollPane3 = new JScrollPane();
/*  90: 41 */     this.jTextArea2 = new JTextArea();
/*  91: 42 */     this.jScrollPane4 = new JScrollPane();
/*  92: 43 */     this.jTextArea3 = new JTextArea();
/*  93:    */     
/*  94: 45 */     setClosable(true);
/*  95: 46 */     setMaximizable(true);
/*  96: 47 */     setMinimumSize(new Dimension(1350, 620));
/*  97: 48 */     setPreferredSize(new Dimension(1350, 620));
/*  98:    */     
/*  99: 50 */     this.jPanel1.setBackground(new Color(102, 102, 102));
/* 100:    */     
/* 101: 52 */     this.jPanel2.setBackground(new Color(0, 0, 0));
/* 102:    */     
/* 103: 54 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 104: 55 */     this.jPanel2.setLayout(jPanel2Layout);
/* 105: 56 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
/* 106:    */     
/* 107:    */ 
/* 108:    */ 
/* 109: 60 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 56, 32767));
/* 110:    */     
/* 111:    */ 
/* 112:    */ 
/* 113:    */ 
/* 114: 65 */     this.lblImagen.setHorizontalAlignment(0);
/* 115: 66 */     this.lblImagen.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 116:    */     
/* 117: 68 */     this.btnPrimero.setText("|<<");
/* 118:    */     
/* 119: 70 */     this.btnAnterior.setText("<<|");
/* 120:    */     
/* 121: 72 */     this.btnSiguiente.setText("|>>");
/* 122:    */     
/* 123: 74 */     this.btnUltimo.setText(">>|");
/* 124:    */     
/* 125: 76 */     this.jLabel1.setFont(new Font("sansserif", 1, 14));
/* 126: 77 */     this.jLabel1.setForeground(new Color(255, 255, 255));
/* 127: 78 */     this.jLabel1.setText("C O D I G O       D E L       P R O D U C T O :");
/* 128:    */     
/* 129: 80 */     txtCodigo.setEditable(false);
/* 130: 81 */     txtCodigo.setFont(new Font("sansserif", 0, 14));
/* 131: 82 */     txtCodigo.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 132:    */     
/* 133: 84 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], new String[] { "c o d i g o    producto", "Fecha lanzamiento", "demanda", "caracteristicas", "alertas", "estado" })
/* 134:    */     {
/* 135: 92 */       boolean[] canEdit = { false, false, false, false, false, false };
/* 136:    */       
/* 137:    */       public boolean isCellEditable(int rowIndex, int columnIndex)
/* 138:    */       {
/* 139: 97 */         return this.canEdit[columnIndex];
/* 140:    */       }
/* 141: 99 */     });
/* 142:100 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 143:    */     
/* 144:102 */     this.jPanel3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 145:103 */     this.jPanel3.setForeground(new Color(153, 153, 153));
/* 146:104 */     this.jPanel3.setOpaque(false);
/* 147:    */     
/* 148:106 */     this.jLabel2.setText("F E C H A    L A N Z A M I E N T O :");
/* 149:    */     
/* 150:108 */     this.jLabel3.setText("D E M A N D A :");
/* 151:    */     
/* 152:110 */     this.jLabel4.setText("C A R A C T E R I S T I C A S :");
/* 153:    */     
/* 154:112 */     this.jLabel5.setText("A L E R T A S :");
/* 155:    */     
/* 156:114 */     this.jTextArea1.setColumns(20);
/* 157:115 */     this.jTextArea1.setRows(5);
/* 158:116 */     this.jScrollPane2.setViewportView(this.jTextArea1);
/* 159:    */     
/* 160:118 */     this.dateFechaInicial.setCurrentView(new AppearancesList("Grey", new ViewAppearance[] { new ViewAppearance("custom", new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 0), new Color(0, 0, 255), false, true, new ButtonPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 0), new Color(0, 0, 255), true, true, new ButtonPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 255), new Color(0, 0, 255), false, true, new ButtonPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(128, 128, 128), new Color(0, 0, 255), false, true, new LabelPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 0), new Color(0, 0, 255), false, true, new LabelPainter()), new SwingCellAppearance(new Font("Tahoma", 0, 11), new Color(0, 0, 0), new Color(255, 0, 0), false, false, new ButtonPainter()), (BackRenderer)null, false, true) }));
/* 161:    */     
/* 162:    */ 
/* 163:    */ 
/* 164:    */ 
/* 165:    */ 
/* 166:    */ 
/* 167:    */ 
/* 168:    */ 
/* 169:    */ 
/* 170:    */ 
/* 171:    */ 
/* 172:    */ 
/* 173:    */ 
/* 174:    */ 
/* 175:    */ 
/* 176:    */ 
/* 177:    */ 
/* 178:    */ 
/* 179:    */ 
/* 180:    */ 
/* 181:    */ 
/* 182:    */ 
/* 183:    */ 
/* 184:    */ 
/* 185:    */ 
/* 186:    */ 
/* 187:    */ 
/* 188:    */ 
/* 189:    */ 
/* 190:    */ 
/* 191:    */ 
/* 192:    */ 
/* 193:    */ 
/* 194:    */ 
/* 195:    */ 
/* 196:    */ 
/* 197:    */ 
/* 198:    */ 
/* 199:    */ 
/* 200:    */ 
/* 201:159 */     this.dateFechaInicial.setCalendarBackground(new Color(204, 255, 255));
/* 202:160 */     this.dateFechaInicial.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/* 203:161 */     this.dateFechaInicial.setCalendarPreferredSize(new Dimension(441, 270));
/* 204:162 */     this.dateFechaInicial.setNothingAllowed(false);
/* 205:163 */     this.dateFechaInicial.setLocale(new Locale("pt", "BR", ""));
/* 206:164 */     this.dateFechaInicial.addCommitListener(new CommitListener()
/* 207:    */     {
/* 208:    */       public void onCommit(CommitEvent evt)
/* 209:    */       {
/* 210:166 */         informacion_productoDesk.this.dateFechaInicialOnCommit(evt);
/* 211:    */       }
/* 212:169 */     });
/* 213:170 */     this.jTextArea2.setColumns(20);
/* 214:171 */     this.jTextArea2.setRows(5);
/* 215:172 */     this.jScrollPane3.setViewportView(this.jTextArea2);
/* 216:    */     
/* 217:174 */     this.jTextArea3.setColumns(20);
/* 218:175 */     this.jTextArea3.setRows(5);
/* 219:176 */     this.jScrollPane4.setViewportView(this.jTextArea3);
/* 220:    */     
/* 221:178 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 222:179 */     this.jPanel3.setLayout(jPanel3Layout);
/* 223:180 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel3).addComponent(this.jLabel4).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel2).addGap(18, 18, 18).addComponent(this.dateFechaInicial, -2, 183, -2))).addContainerGap(128, 32767)).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2).addComponent(this.jScrollPane3).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel5).addGap(0, 0, 32767)).addComponent(this.jScrollPane4)).addContainerGap()));
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
/* 238:    */ 
/* 239:    */ 
/* 240:    */ 
/* 241:    */ 
/* 242:    */ 
/* 243:    */ 
/* 244:    */ 
/* 245:202 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.dateFechaInicial, -2, -1, -2).addComponent(this.jLabel2)).addGap(18, 18, 18).addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane4, -2, -1, -2).addContainerGap(31, 32767)));
/* 246:    */     
/* 247:    */ 
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
/* 267:224 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 268:225 */     this.jPanel1.setLayout(jPanel1Layout);
/* 269:226 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.lblImagen, -2, 271, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(txtCodigo, -2, 331, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.btnPrimero, -2, 45, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnAnterior).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnSiguiente).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnUltimo))).addComponent(this.jScrollPane1, -2, 652, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jPanel3, -2, -1, -2).addGap(33, 33, 33)));
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
/* 292:    */ 
/* 293:    */ 
/* 294:    */ 
/* 295:252 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(txtCodigo, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.btnAnterior, GroupLayout.Alignment.TRAILING, -2, 41, -2).addComponent(this.btnPrimero, -2, 41, -2).addComponent(this.btnSiguiente, GroupLayout.Alignment.TRAILING, -2, 41, -2).addComponent(this.btnUltimo, GroupLayout.Alignment.TRAILING, -2, 41, -2)).addGap(481, 481, 481)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane1, -1, 385, 32767).addComponent(this.lblImagen, -1, -1, 32767)).addGap(90, 90, 90)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel3, -2, -1, -2).addContainerGap()))));
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
/* 322:279 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 323:280 */     getContentPane().setLayout(layout);
/* 324:281 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/* 325:    */     
/* 326:    */ 
/* 327:    */ 
/* 328:285 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/* 329:    */     
/* 330:    */ 
/* 331:    */ 
/* 332:    */ 
/* 333:290 */     pack();
/* 334:    */   }
/* 335:    */   
/* 336:    */   private void dateFechaInicialOnCommit(CommitEvent evt) {}
/* 337:    */ }



/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar

 * Qualified Name:     Desk.informacion_productoDesk

 * JD-Core Version:    0.7.0.1

 */