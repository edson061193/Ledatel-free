/*   1:    */ package Desk;
/*   2:    */ 
/*   3:    */ import java.awt.Color;
/*   4:    */ import java.awt.Container;
/*   5:    */ import java.awt.Dimension;
/*   6:    */ import java.io.PrintStream;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.util.Calendar;
/*   9:    */ import javax.swing.BorderFactory;
/*  10:    */ import javax.swing.GroupLayout;
/*  11:    */ import javax.swing.GroupLayout.Alignment;
/*  12:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  13:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  14:    */ import javax.swing.JInternalFrame;
/*  15:    */ import javax.swing.JPanel;
/*  16:    */ import org.jfree.chart.ChartFactory;
/*  17:    */ import org.jfree.chart.ChartPanel;
/*  18:    */ import org.jfree.chart.JFreeChart;
/*  19:    */ import org.jfree.chart.plot.CategoryPlot;
/*  20:    */ import org.jfree.chart.plot.PlotOrientation;
/*  21:    */ import org.jfree.data.category.DefaultCategoryDataset;
/*  22:    */ 
/*  23:    */ public class graficoEstadisticosDesk
/*  24:    */   extends JInternalFrame
/*  25:    */ {
/*  26:    */   ResultSet rsEnero;
/*  27:    */   ResultSet rsFebrero;
/*  28:    */   ResultSet rsMarzo;
/*  29:    */   ResultSet rsAbril;
/*  30:    */   ResultSet rsMayo;
/*  31:    */   ResultSet rsJunio;
/*  32:    */   ResultSet rsJulio;
/*  33:    */   ResultSet rsAgosto;
/*  34:    */   ResultSet rsSetiembre;
/*  35:    */   ResultSet rsOctubre;
/*  36:    */   ResultSet rsNoviembre;
/*  37:    */   ResultSet rsDiciembre;
/*  38: 23 */   graficaDao oGraficaDao = new graficaDao();
/*  39:    */   private JPanel panelGrafic;
/*  40:    */   
/*  41:    */   public graficoEstadisticosDesk()
/*  42:    */   {
/*  43: 25 */     initComponents();
/*  44: 26 */     grafica();
/*  45:    */   }
/*  46:    */   
/*  47:    */   private void initComponents()
/*  48:    */   {
/*  49: 33 */     this.panelGrafic = new JPanel();
/*  50:    */     
/*  51: 35 */     setClosable(true);
/*  52: 36 */     setMinimumSize(new Dimension(13453, 640));
/*  53: 37 */     setPreferredSize(new Dimension(1353, 640));
/*  54:    */     
/*  55: 39 */     this.panelGrafic.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  56:    */     
/*  57: 41 */     GroupLayout panelGraficLayout = new GroupLayout(this.panelGrafic);
/*  58: 42 */     this.panelGrafic.setLayout(panelGraficLayout);
/*  59: 43 */     panelGraficLayout.setHorizontalGroup(panelGraficLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1317, 32767));
/*  60:    */     
/*  61:    */ 
/*  62:    */ 
/*  63: 47 */     panelGraficLayout.setVerticalGroup(panelGraficLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 579, 32767));
/*  64:    */     
/*  65:    */ 
/*  66:    */ 
/*  67:    */ 
/*  68: 52 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  69: 53 */     getContentPane().setLayout(layout);
/*  70: 54 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.panelGrafic, -1, -1, 32767).addContainerGap()));
/*  71:    */     
/*  72:    */ 
/*  73:    */ 
/*  74:    */ 
/*  75:    */ 
/*  76:    */ 
/*  77: 61 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.panelGrafic, -2, -1, -2).addContainerGap(22, 32767)));
/*  78:    */     
/*  79:    */ 
/*  80:    */ 
/*  81:    */ 
/*  82:    */ 
/*  83:    */ 
/*  84:    */ 
/*  85: 69 */     pack();
/*  86:    */   }
/*  87:    */   
/*  88:    */   public void grafica()
/*  89:    */   {
/*  90:    */     try
/*  91:    */     {
/*  92: 74 */       Calendar cal1 = Calendar.getInstance();
/*  93: 75 */       int año = cal1.get(1);
/*  94: 76 */       String fEneroI = año + "-01-01";
/*  95: 77 */       String fEneroF = año + "-01-31";
/*  96: 78 */       String fFebreroI = año + "-02-01";
/*  97: 79 */       String fFebreroF = año + "-02-31";
/*  98: 80 */       String fMarzoI = año + "-03-01";
/*  99: 81 */       String fMarzoF = año + "-03-31";
/* 100: 82 */       String fAbrilI = año + "-04-01";
/* 101: 83 */       String fAbrilF = año + "-04-31";
/* 102: 84 */       String fMayoI = año + "-05-01";
/* 103: 85 */       String fMayoF = año + "-05-31";
/* 104: 86 */       String fJunioI = año + "-06-01";
/* 105: 87 */       String fJunioF = año + "-06-31";
/* 106: 88 */       String fJulioI = año + "-07-01";
/* 107: 89 */       String fJulioF = año + "-07-31";
/* 108: 90 */       String fAgostoI = año + "-08-01";
/* 109: 91 */       String fAgostoF = año + "-08-31";
/* 110: 92 */       String fSetiembreI = año + "-09-01";
/* 111: 93 */       String fSetiembreF = año + "-09-31";
/* 112: 94 */       String fOctubreI = año + "-10-01";
/* 113: 95 */       String fOctubreF = año + "-10-31";
/* 114: 96 */       String fNoviembreI = año + "-11-01";
/* 115: 97 */       String fNoviembreF = año + "-11-31";
/* 116: 98 */       String fDiciembreI = año + "-12-01";
/* 117: 99 */       String fDiciembreF = año + "-12-31";
/* 118:    */       
/* 119:    */ 
/* 120:102 */       JFreeChart chart = null;
/* 121:103 */       DefaultCategoryDataset data = new DefaultCategoryDataset();
/* 122:104 */       double enero = 0.0D;double febrero = 0.0D;double marzo = 0.0D;double abril = 0.0D;double mayo = 0.0D;double junio = 0.0D;double julio = 0.0D;double agosto = 0.0D;double setiembre = 0.0D;double octubre = 0.0D;double noviembre = 0.0D;double diciembre = 0.0D;
/* 123:105 */       this.rsEnero = this.oGraficaDao.cargaFecha(fEneroI, fEneroF);
/* 124:106 */       this.rsFebrero = this.oGraficaDao.cargaFecha(fFebreroI, fFebreroF);
/* 125:107 */       this.rsMarzo = this.oGraficaDao.cargaFecha(fMarzoI, fMarzoF);
/* 126:108 */       this.rsAbril = this.oGraficaDao.cargaFecha(fAbrilI, fAbrilF);
/* 127:109 */       this.rsMayo = this.oGraficaDao.cargaFecha(fMarzoI, fMayoF);
/* 128:110 */       this.rsJunio = this.oGraficaDao.cargaFecha(fJunioI, fJunioF);
/* 129:111 */       this.rsJulio = this.oGraficaDao.cargaFecha(fJulioI, fJulioF);
/* 130:112 */       this.rsAgosto = this.oGraficaDao.cargaFecha(fAgostoI, fAgostoF);
/* 131:113 */       this.rsSetiembre = this.oGraficaDao.cargaFecha(fSetiembreI, fSetiembreF);
/* 132:114 */       this.rsOctubre = this.oGraficaDao.cargaFecha(fOctubreI, fOctubreF);
/* 133:115 */       this.rsNoviembre = this.oGraficaDao.cargaFecha(fNoviembreI, fNoviembreF);
/* 134:116 */       this.rsDiciembre = this.oGraficaDao.cargaFecha(fDiciembreI, fDiciembreF);
/* 135:117 */       while (this.rsEnero.next()) {
/* 136:118 */         enero = this.rsEnero.getDouble(1);
/* 137:    */       }
/* 138:121 */       while (this.rsFebrero.next()) {
/* 139:122 */         febrero = this.rsFebrero.getDouble(1);
/* 140:    */       }
/* 141:125 */       while (this.rsMarzo.next()) {
/* 142:126 */         marzo = this.rsMarzo.getDouble(1);
/* 143:    */       }
/* 144:129 */       while (this.rsAbril.next()) {
/* 145:130 */         abril = this.rsAbril.getDouble(1);
/* 146:    */       }
/* 147:133 */       while (this.rsMayo.next()) {
/* 148:134 */         mayo = this.rsMayo.getDouble(1);
/* 149:    */       }
/* 150:137 */       while (this.rsJunio.next()) {
/* 151:138 */         junio = this.rsJunio.getDouble(1);
/* 152:    */       }
/* 153:141 */       while (this.rsJulio.next()) {
/* 154:142 */         julio = this.rsJulio.getDouble(1);
/* 155:    */       }
/* 156:145 */       while (this.rsAgosto.next()) {
/* 157:146 */         agosto = this.rsAgosto.getDouble(1);
/* 158:    */       }
/* 159:149 */       while (this.rsSetiembre.next()) {
/* 160:150 */         setiembre = this.rsSetiembre.getDouble(1);
/* 161:    */       }
/* 162:153 */       while (this.rsOctubre.next()) {
/* 163:154 */         octubre = this.rsOctubre.getDouble(1);
/* 164:    */       }
/* 165:157 */       while (this.rsNoviembre.next()) {
/* 166:158 */         noviembre = this.rsNoviembre.getDouble(1);
/* 167:    */       }
/* 168:161 */       while (this.rsDiciembre.next()) {
/* 169:162 */         diciembre = this.rsDiciembre.getDouble(1);
/* 170:    */       }
/* 171:164 */       data.addValue(enero, "ENERO  ", "01");
/* 172:165 */       data.addValue(febrero, "FEBRERO  ", "02");
/* 173:166 */       data.addValue(marzo, "MARZO  ", "03");
/* 174:167 */       data.addValue(abril, "ABRIL  ", "04");
/* 175:168 */       data.addValue(mayo, "MAYO  ", "05");
/* 176:169 */       data.addValue(junio, "JUNIO  ", "06");
/* 177:170 */       data.addValue(julio, "JULIO  ", "07");
/* 178:171 */       data.addValue(agosto, "AGOSTO  ", "08");
/* 179:172 */       data.addValue(setiembre, "SETIEMBRE  ", "09");
/* 180:173 */       data.addValue(octubre, "0CTUBRE  ", "10");
/* 181:174 */       data.addValue(noviembre, "NOVIEMBRE  ", "11");
/* 182:175 */       data.addValue(diciembre, "DICIEMBRE  ", "12");
/* 183:    */       
/* 184:177 */       chart = ChartFactory.createBarChart("Reporte de ventas", "Fecha-Mes-" + año, "Total efectivo en ventas", data, PlotOrientation.VERTICAL, true, true, true);
/* 185:178 */       CategoryPlot plot = (CategoryPlot)chart.getPlot();
/* 186:179 */       plot.setDomainGridlinesVisible(true);
/* 187:180 */       ChartPanel panel = new ChartPanel(chart);
/* 188:181 */       panel.setBounds(0, 0, 1319, 581);
/* 189:182 */       this.panelGrafic.add(panel);
/* 190:    */     }
/* 191:    */     catch (Exception e)
/* 192:    */     {
/* 193:185 */       System.out.println(e);
/* 194:    */     }
/* 195:    */   }
/* 196:    */ }


/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar
 * Qualified Name:     Desk.graficoEstadisticosDesk
 * JD-Core Version:    0.7.0.1
 */